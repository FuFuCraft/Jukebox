package org.abstruck.fabric.fufucraft.jukebox.common.item;

import com.mojang.logging.LogUtils;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;
import org.abstruck.fabric.fufucraft.jukebox.util.MusicUrlIdentifier;
import org.abstruck.fabric.fufucraft.jukebox.util.RegistryUtils;
import org.jetbrains.annotations.Nullable;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * @author Astrack
 * @date 2023/7/24
 */
public class RecordItem extends MusicDiscItem {
    private URL url;
    private List<Text> texts;
    public RecordItem(String url, Settings settings, int lengthInSeconds,List<Text> texts) {
        super(1, SoundEvent.of(new MusicUrlIdentifier(url)), settings, lengthInSeconds);
        this.texts = texts;
        try {
            this.url = new URL(url);
        } catch (MalformedURLException e) {
            LogUtils.getLogger().error("this should not happen in runtime");
            throw new RuntimeException(e);
        }
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.addAll(texts);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        ActionResult superResult = super.useOnBlock(context);
        if (superResult == ActionResult.SUCCESS) {
            context.getStack().getOrCreateSubNbt("jukebox").putFloat("RecordState",1.0F);
        }
        return superResult;
    }
}
