package com.client.module.MOVEMENT;

import com.client.event.EventTarget;
import com.client.module.Module;
import org.lwjgl.input.Keyboard;

public class AutoSprint extends Module {
    public AutoSprint(){
        super("AutoSprint", "Auto ctrl sprint",Keyboard.KEY_P, Category.MOVEMENT);
    }

    @EventTarget
    public void onUpdate(EventTarget event){
        if(this.isEnabled() && !mc.player.isSneaking() && !mc.player.isAirBorne){
            mc.player.setSprinting(true);
        }
    }

    @Override
    public void onDisable(){
        mc.player.setSprinting(false);
    }
}
