package org.abstruck.fabric.fufucraft.jukebox.common.entity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

/**
 * @author Astrack
 * @date 2023/7/23
 */
public class JukeboxBlockEntity extends net.minecraft.block.entity.JukeboxBlockEntity {
    public JukeboxBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    public void markDirty() {
        super.markDirty();
        update();
    }

    @Override
    public void startPlaying() {
        getStack().getOrCreateNbt().putBoolean("jukebox:IsPlaying",true);
        super.startPlaying();
    }

    @Override
    public void dropRecord() {
        getStack().getOrCreateNbt().putBoolean("jukebox:IsPlaying",false);
        super.dropRecord();
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        NbtCompound nbtCompound = new NbtCompound();
        writeNbt(nbtCompound);
        return nbtCompound;
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    private void update(){
        if (world != null) {
            world.updateListeners(pos,getCachedState(),getCachedState(), Block.NOTIFY_LISTENERS);
        }
    }
}
