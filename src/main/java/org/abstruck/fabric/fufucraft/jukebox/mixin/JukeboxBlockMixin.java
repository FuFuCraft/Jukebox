package org.abstruck.fabric.fufucraft.jukebox.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.JukeboxBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import org.abstruck.fabric.fufucraft.jukebox.common.entity.JukeboxBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * @author Astrack
 * @date 2023/7/23
 */
@Mixin(JukeboxBlock.class)
public abstract class JukeboxBlockMixin {
    @Inject(method = "createBlockEntity",at = @At("HEAD"), cancellable = true)
    private void createNewBlockEntity(BlockPos pos, BlockState state, CallbackInfoReturnable<BlockEntity> cir){
        cir.setReturnValue(new JukeboxBlockEntity(pos,state));
    }
}
