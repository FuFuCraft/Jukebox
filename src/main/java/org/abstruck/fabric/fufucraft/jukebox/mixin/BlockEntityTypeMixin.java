package org.abstruck.fabric.fufucraft.jukebox.mixin;

import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import org.abstruck.fabric.fufucraft.jukebox.common.entity.JukeboxBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

/**
 * @author Astrack
 * @date 2023/7/23
 */
@Mixin(BlockEntityType.class)
public abstract class BlockEntityTypeMixin {
    @ModifyArgs(method = "<clinit>",at = @At(value = "INVOKE",target = "Lnet/minecraft/block/entity/BlockEntityType;create(Ljava/lang/String;Lnet/minecraft/block/entity/BlockEntityType$Builder;)Lnet/minecraft/block/entity/BlockEntityType;"))
    private static <T extends BlockEntity> void customJukeboxBlockEntity(Args args){
        String id = args.get(0);
        if ("jukebox".equals(id)){
            args.set(1,BlockEntityType.Builder.create(JukeboxBlockEntity::new, Blocks.JUKEBOX));
        }
    }
}
