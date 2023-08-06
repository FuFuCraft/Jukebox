package org.abstruck.fabric.fufucraft.jukebox.mixin;

import net.fabricmc.fabric.api.tag.convention.v1.TagUtil;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.abstruck.fabric.fufucraft.jukebox.common.item.RecordItem;
import org.abstruck.fabric.fufucraft.jukebox.common.registry.ModTags;
import org.abstruck.fabric.fufucraft.jukebox.common.sound.RecordSoundInstance;
import org.abstruck.fabric.fufucraft.jukebox.util.MusicUrlIdentifier;
import org.abstruck.fabric.fufucraft.jukebox.util.RegistryUtils;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.net.MalformedURLException;
import java.util.Map;

/**
 * @author Astrack
 * @date 2023/7/24
 */
@Mixin(WorldRenderer.class)
public abstract class WorldRenderMixin {
    @Shadow @Final private MinecraftClient client;

    @Shadow @Final private Map<BlockPos, SoundInstance> playingSongs;

    @Shadow protected abstract void updateEntitiesForSong(World world, BlockPos pos, boolean playing);

    @Shadow @Nullable private ClientWorld world;

    @Inject(method = "processWorldEvent",at = @At("HEAD"),cancellable = true)
    private void playRecord(int eventId, BlockPos pos, int data, CallbackInfo ci){
        if (eventId != 1010) return;
        Item item = Item.byRawId(data);
        if (!TagUtil.isIn(ModTags.RECORDS,item)) return;
        if (!(item instanceof RecordItem recordItem)) return;

        SoundInstance soundInstance = this.playingSongs.get(pos);
        if (soundInstance != null) {
            this.client.getSoundManager().stop(soundInstance);
            this.playingSongs.remove(pos);
        }
        this.client.inGameHud.setRecordPlayingOverlay(recordItem.getDescription());
        RecordSoundInstance recordSoundInstance = new RecordSoundInstance(recordItem.getUrl().toString(),pos);

        this.playingSongs.put(pos, recordSoundInstance);
        this.client.getSoundManager().play(recordSoundInstance);

        this.updateEntitiesForSong(this.world, pos, true);
        ci.cancel();
    }
}
