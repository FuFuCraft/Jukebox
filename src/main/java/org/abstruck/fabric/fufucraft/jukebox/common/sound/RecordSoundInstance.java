package org.abstruck.fabric.fufucraft.jukebox.common.sound;

import net.minecraft.client.sound.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import org.abstruck.fabric.fufucraft.jukebox.util.IdentifierSound;
import org.abstruck.fabric.fufucraft.jukebox.util.MusicSound;
import org.abstruck.fabric.fufucraft.jukebox.util.MusicUrlIdentifier;
import org.abstruck.fabric.fufucraft.jukebox.util.UrlUtils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * @author Astrack
 * @date 2023/7/24
 */
public class RecordSoundInstance extends PositionedSoundInstance {
    private URL url;
    private Sound sound;
    public RecordSoundInstance(String url,  BlockPos pos) {
        super(new MusicUrlIdentifier(url),SoundCategory.RECORDS,4.0F, 1.0F, SoundInstance.createRandom(), false, 0, AttenuationType.LINEAR, pos.getX(), pos.getY(), pos.getZ(),false);
        try {
            this.url = new URL(url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        sound = new MusicSound(url);
    }

    @Override
    public float getVolume() {
        return volume;
    }

    @Override
    public float getPitch() {
        return pitch;
    }


    @Override
    public WeightedSoundSet getSoundSet(SoundManager soundManager) {
        return new WeightedSoundSet(id,"");
    }


    public URL getUrl() {
        return url;
    }

    @Override
    public Sound getSound() {
        return sound;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    @Override
    public CompletableFuture<AudioStream> getAudioStream(SoundLoader loader, Identifier id, boolean repeatInstantly) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return new OggAudioStream(UrlUtils.download(getUrl()));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }, Util.getMainWorkerExecutor());
    }
}
