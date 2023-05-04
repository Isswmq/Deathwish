package com.client;

import com.client.discord.DiscordRP;
import com.client.event.EventManager;
import com.client.event.EventTarget;
import com.client.event.impl.EventTick;
import com.client.module.ModuleManager;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.Display;

public class Deathwish {
    public ModuleManager moduleManager;
    public static String name = "Deathwish premium";
    public EventManager eventManager;
    public Minecraft mc = Minecraft.getMinecraft();
    public static Deathwish INSTANCE = new Deathwish();
    DiscordRP discordRP = new DiscordRP();

    public void startup(){
        moduleManager = new ModuleManager();
        eventManager = new EventManager();
        eventManager.register(this);
        Display.setTitle(name);
        discordRP.start();

    }

    public void shutdown(){
        eventManager.unregister(this);
        discordRP.shutdown();
    }

    @EventTarget
    public void onTick(EventTick eventTick){
        if(mc.gameSettings.keyBindSprint.isPressed()){
            moduleManager.sprint.toggled();
        }
    }
}
