package com.client.module;

import com.client.Deathwish;
import net.minecraft.client.Minecraft;

public class Module {

    public String name, description;
    public boolean enabled;
    public int keyCode;
    public Category category;


    public Minecraft mc = Minecraft.getMinecraft();

    public enum Category{
        COMBAT,
        VISUALS,
        MOVEMENT,
        PLAYER,
        RENDER,
        MISC
    }

    public Module(String name, String description, int key, Category category){
        this.name = name;
        this.description = description;
        this.keyCode = key;
        this.category = category;

        enabled = true;
    }

    public void onEnabled(){
        Deathwish.INSTANCE.eventManager.register(this);
    }
    public void onDisable(){
        Deathwish.INSTANCE.eventManager.unregister(this);
    }
    public void onUpdate(){}
    public void onRender(){}


    public void enable(){
        enabled = !enabled;
        if(enabled){
            this.onEnabled();
        }else{
            this.onDisable();
        }
    }

    public void setEnabled(boolean toggled){
        this.enabled = toggled;
        if(this.enabled){
            onEnabled();
        }else{
            onDisable();
        }
    }

    public void toggle(){
        setEnabled(!this.enabled);
    }

    public void toggled(){
        setEnabled(!this.enabled);
    }

    public String getName() {
        return name;
    }

    public String getDescription(){
        return description;
    }

    public int getKeyCode() {
        return keyCode;
    }

    public Category getCategory() {
        return category;
    }

    public boolean isEnabled(){
        return enabled;
    }
}
