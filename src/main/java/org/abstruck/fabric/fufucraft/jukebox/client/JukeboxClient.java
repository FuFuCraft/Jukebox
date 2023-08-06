package org.abstruck.fabric.fufucraft.jukebox.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import org.abstruck.fabric.fufucraft.jukebox.client.render.JukeboxBlockEntityRender;

/**
 * @author Astrack
 * @date 2023/7/21
 */
@Environment(EnvType.CLIENT)
public class JukeboxClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockEntityRendererFactories.register(BlockEntityType.JUKEBOX, JukeboxBlockEntityRender::new);
    }
}
