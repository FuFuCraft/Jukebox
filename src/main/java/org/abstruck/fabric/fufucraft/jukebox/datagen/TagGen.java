package org.abstruck.fabric.fufucraft.jukebox.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import org.abstruck.fabric.fufucraft.jukebox.common.registry.ItemRegistry;
import org.abstruck.fabric.fufucraft.jukebox.common.registry.ModTags;

import java.util.concurrent.CompletableFuture;

/**
 * @author Astrack
 * @date 2023/7/23
 */
public class TagGen extends FabricTagProvider.ItemTagProvider {


    public TagGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ItemRegistry.ALBUM1)
                .add(ItemRegistry.ALBUM2)
                .add(ItemRegistry.ALBUM3)
                .add(ItemRegistry.ALBUM4)
                .add(ItemRegistry.ALBUM5)
                .add(ItemRegistry.ALBUM6)
                .add(ItemRegistry.ALBUM7)
                .add(ItemRegistry.ALBUM8);

        getOrCreateTagBuilder(ModTags.RECORDS)
                .add(ItemRegistry.ALBUM1)
                .add(ItemRegistry.ALBUM2)
                .add(ItemRegistry.ALBUM3)
                .add(ItemRegistry.ALBUM4)
                .add(ItemRegistry.ALBUM5)
                .add(ItemRegistry.ALBUM6)
                .add(ItemRegistry.ALBUM7)
                .add(ItemRegistry.ALBUM8);
    }
}
