package org.abstruck.fabric.fufucraft.jukebox.client.render;

import com.mojang.logging.LogUtils;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.entity.JukeboxBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.World;
import org.joml.Vector3f;

/**
 * @author Astrack
 * @date 2023/7/22
 */
@Environment(EnvType.CLIENT)
public class JukeboxBlockEntityRender implements BlockEntityRenderer<JukeboxBlockEntity> {
    public JukeboxBlockEntityRender(BlockEntityRendererFactory.Context ctx){}
    @Override
    public void render(JukeboxBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        World world = entity.getWorld();
        if (!entity.isPlayingRecord() || world == null){
            return;
        }
        matrices.push();
        matrices.translate(0.5F,1.0325,0.375);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotation((world.getTime() + tickDelta)/8));
        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
        int lightAbove = WorldRenderer.getLightmapCoordinates(world, entity.getPos().up());
        itemRenderer.renderItem(entity.getStack(), ModelTransformationMode.GROUND,lightAbove,overlay,matrices,vertexConsumers, world,0);
        matrices.pop();
    }
}
