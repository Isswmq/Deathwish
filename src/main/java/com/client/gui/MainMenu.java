package com.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.*;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;

import java.io.IOException;

public class MainMenu extends GuiScreen {

    private static final ResourceLocation texture = new ResourceLocation("deathwish/mainMenu.jpg");
    //Tessellator tessellator = Tessellator.getInstance();

    @Override
    public void initGui() {
        int i = this.height / 4 + 48;
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(0, this.width / 2 - 67, i + 72 - 24, 135, 20, "OPTIONS"));
        this.buttonList.add(new GuiButton(1, this.width / 2 - 67, i + 72 + 24, 135, 20, "EXIT"));
        this.buttonList.add(new GuiButton(2, this.width / 2 - 67, i + 72, 135, 20, "ALT MANAGER"));
        this.buttonList.add(new GuiButton(3, this.width / 2 - 67, i + 72 - 48, 135, 20, "MULTIPLAYER"));
        this.buttonList.add(new GuiButton(4, this.width / 2 - 67, i + 72 - 72, 135, 20, "SINGLEPLAYER"));;
        super.initGui();
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        GlStateManager.disableAlpha();
        GlStateManager.enableAlpha();
        this.mc.getTextureManager().bindTexture(texture);
        Gui.drawScaledCustomSizeModalRect(0, 0, 0.0F, 0.0F, this.width, this.height, this.width, this.height, (float)this.width, (float)this.height);
        new ScaledResolution(this.mc);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if(button.id == 0){
            mc.displayGuiScreen(new GuiOptions(this, mc.gameSettings));
        }if(button.id == 1){
            mc.shutdown();
        }if(button.id == 2){

        }if (button.id == 3){
            mc.displayGuiScreen(new GuiMultiplayer(this));
        }if(button.id == 4){
            mc.displayGuiScreen(new GuiWorldSelection(this));
        }
        super.actionPerformed(button);
    }
}
