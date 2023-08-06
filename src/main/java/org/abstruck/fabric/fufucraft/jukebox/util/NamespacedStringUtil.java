package org.abstruck.fabric.fufucraft.jukebox.util;

/**
 * @author Astrack
 * @date 2023/7/30
 */
public class NamespacedStringUtil {
    public static String modString(String str){
        return ModUtils.MOD_ID+":"+str;
    }
}
