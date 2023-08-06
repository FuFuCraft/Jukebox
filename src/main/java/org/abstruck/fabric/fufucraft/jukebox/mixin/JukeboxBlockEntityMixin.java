package org.abstruck.fabric.fufucraft.jukebox.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.JukeboxBlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.SingleStackInventory;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @author Astrack
 * @date 2023/7/23
 */
@Mixin(JukeboxBlockEntity.class)
public abstract class JukeboxBlockEntityMixin extends BlockEntity implements SingleStackInventory {
    public JukeboxBlockEntityMixin(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Inject(method = "updateState",at = @At("TAIL"))
    private void update(Entity entity, boolean hasRecord, CallbackInfo ci){
        if (world != null) {
            world.updateListeners(pos,getCachedState(),getCachedState(), Block.NOTIFY_LISTENERS);
        }
    }
}
