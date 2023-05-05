package com.client.module.MOVEMENT;

import com.client.events.Event;
import com.client.events.listeners.EventUpdate;
import com.client.module.Category;
import com.client.module.Module;

public class Fly extends Module {

    public Fly() {
        super("fly", "Fly without creative", 25, Category.MOVEMENT);
    }

    public void onEnable(){
        mc.player.capabilities.isFlying = true;
        mc.player.capabilities.allowFlying = true;
    }

    public void onDisable() {
        mc.player.capabilities.isFlying = false;
        mc.player.capabilities.allowFlying = false;
    }

    public void onEvent(Event event){
        if(event instanceof EventUpdate){
            if(event.isPre()){

            }
        }
    }
}
