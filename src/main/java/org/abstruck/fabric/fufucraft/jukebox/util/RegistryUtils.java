package org.abstruck.fabric.fufucraft.jukebox.util;

import net.minecraft.util.Identifier;

/**
 * @author Astrack
 * @date 2023/7/21
 */
public class RegistryUtils {
    public static Identifier identifier(String id){
        return new Identifier(ModUtils.MOD_ID,id.replace(":",""));
    }
}
