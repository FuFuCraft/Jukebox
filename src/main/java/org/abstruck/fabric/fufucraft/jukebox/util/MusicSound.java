package org.abstruck.fabric.fufucraft.jukebox.util;

import net.minecraft.client.sound.Sound;
import net.minecraft.util.Identifier;

/**
 * @author Astrack
 * @date 2023/7/30
 */
public class MusicSound extends IdentifierSound {
    public MusicSound(String url) {
        super(
                new MusicUrlIdentifier(url),
                (r) -> 4.0F,
                (r) -> 1.0F,
                1,
                Sound.RegistrationType.FILE,
                true,
                false,
                16
        );
    }

    @Override
    public Identifier getLocation() {
        return getIdentifier();
    }


    @Override
    public int getAttenuation() {
        return 16;
    }
}
