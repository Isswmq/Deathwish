package com.client.module.MOVEMENT;

import com.client.events.Event;
import com.client.events.listeners.EventUpdate;
import com.client.module.Category;
import com.client.module.Module;
import org.lwjgl.input.Keyboard;

public class Fly extends Module {

    public Fly() {
        super("fly", "Fly without creative", Keyboard.KEY_P, Category.MOVEMENT);
    }

    public void onDisable() {
        mc.player.capabilities.isFlying = false;
        mc.player.capabilities.allowFlying = false;
    }

    public void onEvent(Event event){
        if(event instanceof EventUpdate){
            if(event.isPre()){
                mc.player.capabilities.isFlying = true;
                mc.player.capabilities.allowFlying = true;
            }
        }
    }
}
