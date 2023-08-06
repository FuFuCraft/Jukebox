package org.abstruck.fabric.fufucraft.jukebox.util;

import net.minecraft.util.Identifier;

/**
 * @author Astrack
 * @date 2023/7/30
 */
public class MusicUrlIdentifier extends Identifier {
    public MusicUrlIdentifier(String id) {
        super(ModUtils.MOD_ID,id,null);
    }
}
