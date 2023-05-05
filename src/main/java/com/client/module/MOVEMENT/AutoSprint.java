package com.client.module.MOVEMENT;

import com.client.module.Category;
import com.client.module.Module;
import org.lwjgl.input.Keyboard;

public class AutoSprint extends Module {
    public AutoSprint(){
        super("AutoSprint", "Auto ctrl sprint",25, Category.MOVEMENT);
    }

    @Override
    public void onEnable() {
        if(this.isToggled() && !mc.player.isSneaking() && !mc.player.isAirBorne){
            mc.player.setSprinting(true);
        }
    }

    @Override
    public void onDisable(){
        mc.player.setSprinting(false);
    }
}
