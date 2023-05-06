package com.client.module.MOVEMENT;

import com.client.events.Event;
import com.client.events.listeners.EventUpdate;
import com.client.module.Category;
import com.client.module.Module;
import org.lwjgl.input.Keyboard;

public class AutoSprint extends Module {

    public AutoSprint() {
        super("AutoSprint", "Sprinting without ctrl", Keyboard.KEY_O, Category.MOVEMENT);
    }

    public void onEnable(){

    }
    public void onDisable() {
        mc.player.setSprinting(mc.gameSettings.keyBindSprint.isPressed());
    }

    public void onEvent(Event event){
        if(event instanceof EventUpdate){
            if(event.isPre()){
                if(!mc.player.isSneaking() && mc.gameSettings.keyBindForward.isKeyDown()){
                    mc.player.setSprinting(true);
                }
            }
        }
    }
}
