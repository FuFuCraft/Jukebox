package org.abstruck.fabric.fufucraft.jukebox.util;

import com.mojang.logging.LogUtils;
import net.minecraft.resource.Resource;
import net.minecraft.resource.ResourceFactory;
import net.minecraft.util.Identifier;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Optional;

/**
 * @author Astrack
 * @date 2023/7/30
 */
public class MusicResourceFactory implements ResourceFactory {
    private ResourceFactory factory;
    public MusicResourceFactory(ResourceFactory factory){
        this.factory = factory;
    }
    @Override
    public Optional<Resource> getResource(Identifier id) {
        return factory.getResource(id);
    }

    @Override
    public Resource getResourceOrThrow(Identifier id) throws FileNotFoundException {
        return factory.getResourceOrThrow(id);
    }

    @Override
    public BufferedReader openAsReader(Identifier id) throws IOException {
        return factory.openAsReader(id);
    }

    @Override
    public InputStream open(Identifier id) throws IOException {
        if (id instanceof MusicUrlIdentifier urlIdentifier){
            try {
                System.out.println("located music resource");
                return UrlUtils.download(new URL(urlIdentifier.getPath()));
            } catch (Exception e) {
                LogUtils.getLogger().warn(e.getMessage());
            }
        }
        return factory.open(id);
    }
}
