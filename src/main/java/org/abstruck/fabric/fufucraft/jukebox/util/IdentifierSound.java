package org.abstruck.fabric.fufucraft.jukebox.util;

import net.minecraft.client.sound.Sound;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.floatprovider.FloatSupplier;

import java.lang.reflect.Field;

/**
 * @author Astrack
 * @date 2023/8/1
 */
public class IdentifierSound extends Sound {
    private static final Field idField;
    public IdentifierSound(Identifier identifier, FloatSupplier volume, FloatSupplier pitch, int weight, RegistrationType registrationType, boolean stream, boolean preload, int attenuation) {
        super("temp", volume, pitch, weight, registrationType, stream, preload, attenuation);
        try {
            idField.set(this,identifier);
        } catch (IllegalAccessException ignored) {
        }
    }

    static {
        try {
            idField = Sound.class.getDeclaredField("id");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        idField.setAccessible(true);
    }
}
