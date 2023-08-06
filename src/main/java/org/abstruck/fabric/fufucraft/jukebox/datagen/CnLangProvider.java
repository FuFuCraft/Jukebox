package org.abstruck.fabric.fufucraft.jukebox.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import org.abstruck.fabric.fufucraft.jukebox.common.registry.ItemRegistry;

/**
 * @author Astrack
 * @date 2023/7/31
 */
public class CnLangProvider extends FabricLanguageProvider {
    public CnLangProvider(FabricDataOutput dataOutput) {
        super(dataOutput,"zh_cn");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(ItemRegistry.ALBUM1,"magical mirai 主题曲黑胶唱片");
        translationBuilder.add(ItemRegistry.ALBUM2,"八王子p精选集黑胶唱片");
        translationBuilder.add(ItemRegistry.ALBUM3,"2021 magical mirai 黑胶唱片");
        translationBuilder.add(ItemRegistry.ALBUM4,"magical mirai 主题曲黑胶唱片");
        translationBuilder.add(ItemRegistry.ALBUM5,"wowaka 精选集黑胶唱片");
        translationBuilder.add(ItemRegistry.ALBUM6,"老匹精选集黑胶唱片");
        translationBuilder.add(ItemRegistry.ALBUM7,"雪未来主题黑胶唱片");
        translationBuilder.add(ItemRegistry.ALBUM8,"MitchieM精选集黑胶唱片");
    }
}
