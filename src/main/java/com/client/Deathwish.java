package com.client;

import com.client.discord.DiscordRP;
import com.client.events.Event;
import com.client.module.MOVEMENT.Fly;
import com.client.module.Module;
import com.client.ui.HUD;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.Display;

import java.util.concurrent.CopyOnWriteArrayList;
public class Deathwish {
    public static String name = "Deathwish premium";
    public Minecraft mc = Minecraft.getMinecraft();

    public static CopyOnWriteArrayList<Module> modules = new CopyOnWriteArrayList<Module>();

    public static HUD hud = new HUD();
    static DiscordRP discordRP = new DiscordRP();

    public static void startup(){
        Display.setTitle(name);
        discordRP.start();

        modules.add(new Fly());

    }

    public static void onEvent(Event event){
        for (Module module : modules) {
            if(!module.isToggled()){
                continue;
            }
            module.onEvent(event);
        }
    }

    public static void keyPress(int key){
        for (Module module : modules) {
            if(module.getKey() == key){
                module.toggle();
            }
        }
    }
}
