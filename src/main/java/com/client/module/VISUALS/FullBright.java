package com.client.module.VISUALS;

import com.client.module.Category;
import com.client.module.Module;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import org.lwjgl.input.Keyboard;

import java.util.Objects;

public class FullBright extends Module {

    public FullBright() {
        super("FullBright", "set gamma 100", Keyboard.KEY_I, Category.MOVEMENT);
    }

    public void onEnable(){
        mc.player.addPotionEffect(new PotionEffect(Objects.requireNonNull(Potion.getPotionById(16)), 99999, 1));
    }

    public void onDisable() {
        mc.player.removeActivePotionEffect(Objects.requireNonNull(Potion.getPotionById(16)));
    }
}
