package com.kqp.inventorytabs.tabs.tab;

import com.kqp.inventorytabs.mixin.ShulkerBoxBlockInvoker;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.ShulkerBoxBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

/**
 * Tab for shulker boxes.
 */
public class ShulkerBoxTab extends SimpleBlockTab {
    public ShulkerBoxTab(Identifier blockId, BlockPos blockPos) {
        super(blockId, blockPos);
    }

    @Override
    public boolean shouldBeRemoved() {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;

        BlockEntity blockEntity = player.method_48926().getBlockEntity(blockPos);

        if (blockEntity instanceof ShulkerBoxBlockEntity) {
            BlockState blockState = player.method_48926().getBlockState(blockPos);

            return !ShulkerBoxBlockInvoker.invokeCanOpen(blockState, player.method_48926(), blockPos,
                    (ShulkerBoxBlockEntity) blockEntity);
        }

        return super.shouldBeRemoved();
    }
}
