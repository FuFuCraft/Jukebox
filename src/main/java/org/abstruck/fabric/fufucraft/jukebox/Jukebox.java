package org.abstruck.fabric.fufucraft.jukebox;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.entity.Entity;
import org.abstruck.fabric.fufucraft.jukebox.common.registry.ItemRegistry;
import org.abstruck.fabric.fufucraft.jukebox.datagen.CnLangProvider;
import org.abstruck.fabric.fufucraft.jukebox.datagen.TagGen;
import org.abstruck.fabric.fufucraft.jukebox.util.RegistryUtils;

/**
 * @author Astrack
 * @date 2023/7/21
 */
public class Jukebox implements ModInitializer, DataGeneratorEntrypoint {
    @Override
    public void onInitialize() {


        ModelPredicateProviderRegistry.register(RegistryUtils.identifier("playing"),(stack,world,entity,seed)-> stack.getOrCreateNbt().getBoolean("jukebox:IsPlaying")?1:0);
        ModelPredicateProviderRegistry.register(RegistryUtils.identifier("drop"),(stack,world,entity,seed)->{
            Entity e = entity != null ? entity : stack.getHolder();
            if (entity == null) {
                return 1;
            }
            return 0;
        });

//        SoundEventRegistry.register();
        ItemRegistry.register();
    }


    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(TagGen::new);
        pack.addProvider(CnLangProvider::new);
    }
}

