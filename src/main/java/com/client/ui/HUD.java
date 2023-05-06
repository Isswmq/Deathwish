package com.client.ui;

import com.client.Deathwish;
import com.client.module.Module;
import com.client.util.font.FontRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.ScaledResolution;
import optifine.FontUtils;

import java.awt.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

import static net.minecraft.client.gui.Gui.drawRect;

public class HUD {

    public Minecraft mc = Minecraft.getMinecraft();

    public void draw() {
        int y = 10;
        final int[] counter = {1};
        ScaledResolution sr = new ScaledResolution(mc);

        String text = "Deathwish" + " | " + mc.getSession().getUsername() + " | " + "FPS " + Minecraft.getDebugFPS();

        if(mc.getCurrentServerData() != null){
            text = "Deathwish" + " | " + mc.getSession().getUsername() + " | " + "FPS " + Minecraft.getDebugFPS() + " | " + "PING " + Objects.requireNonNull(mc.getCurrentServerData()).pingToServer;
        }

        try {
            drawRect(5,5, (FontRenderer.renderer.getStringWidth(text) + 16), 15, new Color(0x282828).hashCode());
            drawRect(5,5, (FontRenderer.renderer.getStringWidth(text) + 16), 4, rainbow(300));
            drawRect(5,15, (FontRenderer.renderer.getStringWidth(text) + 16), 16, rainbow(300));
            drawRect(4,4, 5, 16, rainbow(300));
            drawRect((FontRenderer.renderer.getStringWidth(text) + 16 - 1),5, (FontRenderer.renderer.getStringWidth(text) + 16), 16, rainbow(300));
        }finally {
            FontRenderer.renderer.drawString(text, 10, 6.5, rainbow(counter[0] * 300));
        }

        Deathwish.modules.sort(Comparator.comparingInt(m -> mc.fontRendererObj.getStringWidth(((Module)m).getName())).reversed());

        for (Module module : Deathwish.modules){
            if(module.isToggled()) {
                Gui.drawRect(sr.getScaledWidth(), y, sr.getScaledWidth() - 2, y + 10, rainbow(counter[0] * 300));

                FontRenderer.renderer.drawStringWithShadow(module.getName(), sr.getScaledWidth() - 4 - FontRenderer.renderer.getStringWidth(module.getName()),
                        y, rainbow(counter[0] * 300));
                y += 10;
                counter[0]++;
            }
        }

    }

    public static int rainbow ( int delay){
        double rainbowState = Math.ceil((System.currentTimeMillis() + delay) / 20.0);
        rainbowState %= 360;
        return Color.getHSBColor((float) (rainbowState / 360.0f), 0.5f, 1f).getRGB();
    }
}
