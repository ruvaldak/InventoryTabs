package com.kqp.inventorytabs.mixin;

import com.kqp.inventorytabs.interf.TabManagerContainer;
import com.kqp.inventorytabs.tabs.TabManager;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.StonecutterScreen;

@Environment(EnvType.CLIENT)
@Mixin(StonecutterScreen.class)
public class StonecutterScreenTabAdder {
    @Inject(method = "drawBackground", at = @At("RETURN"))
    protected void drawBackgroundTabs(DrawContext context, float delta, int mouseX, int mouseY, CallbackInfo ci) {
        MinecraftClient client = MinecraftClient.getInstance();
        TabManager tabManager = ((TabManagerContainer) client).getTabManager();

        tabManager.tabRenderer.renderBackground(context);
    }
}
