package org.abstruck.fabric.fufucraft.jukebox.common.registry;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import org.abstruck.fabric.fufucraft.jukebox.util.RegistryUtils;

/**
 * @author Astrack
 * @date 2023/7/24
 */
public class ModTags {
    public static final TagKey<Item> RECORDS = TagKey.of(
            RegistryKeys.ITEM,
            RegistryUtils.identifier("records")
    );
}
