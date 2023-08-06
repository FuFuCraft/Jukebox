package org.abstruck.fabric.fufucraft.jukebox.common.registry;

import com.google.common.collect.ImmutableList;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import org.abstruck.fabric.fufucraft.jukebox.util.RegistryUtils;

import java.util.stream.IntStream;

/**
 * @author Astrack
 * @date 2023/7/21
 */
public class SoundEventRegistry {
    public static final SoundEvent ALBUM1_SOUND = register(RegistryUtils.identifier("album1_sound"));
    public static final SoundEvent ALBUM2_SOUND = register(RegistryUtils.identifier("album2_sound"));
    public static final SoundEvent ALBUM3_SOUND = register(RegistryUtils.identifier("album3_sound"));
    public static final SoundEvent ALBUM4_SOUND = register(RegistryUtils.identifier("album4_sound"));
    public static final SoundEvent ALBUM5_SOUND = register(RegistryUtils.identifier("album5_sound"));
    public static final SoundEvent ALBUM6_SOUND = register(RegistryUtils.identifier("album6_sound"));
    public static final SoundEvent ALBUM7_SOUND = register(RegistryUtils.identifier("album7_sound"));
    public static final SoundEvent ALBUM8_SOUND = register(RegistryUtils.identifier("album8_sound"));
    public static void register(){}

    private static RegistryEntry<SoundEvent> register(Identifier id, Identifier soundId, float distanceToTravel) {
        return Registry.registerReference(Registries.SOUND_EVENT, id, SoundEvent.of(soundId, distanceToTravel));
    }

    private static SoundEvent register(String id) {
        return register(new Identifier(id));
    }

    private static SoundEvent register(Identifier id) {
        return register(id, id);
    }

    private static RegistryEntry.Reference<SoundEvent> registerReference(String id) {
        return registerReference(new Identifier(id));
    }

    private static RegistryEntry.Reference<SoundEvent> registerReference(Identifier id) {
        return registerReference(id, id);
    }

    private static SoundEvent register(Identifier id, Identifier soundId) {
        return (SoundEvent)Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(soundId));
    }

    private static RegistryEntry.Reference<SoundEvent> registerReference(Identifier id, Identifier soundId) {
        return Registry.registerReference(Registries.SOUND_EVENT, id, SoundEvent.of(soundId));
    }
}
