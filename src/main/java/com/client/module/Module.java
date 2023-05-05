package com.client.module;

import com.client.events.Event;
import net.minecraft.client.Minecraft;

public class Module {

    public Minecraft mc = Minecraft.getMinecraft();
    private String name, description;
    private boolean toggled;
    private int key;
    private Category category;


    public Module(String name, String description, int key, Category category){
        this.name = name;
        this.description = description;
        this.key = key;
        this.category = category;
        toggled = false;

    }

    public void onEvent(Event event){

    }

    public void toggle(){
        toggled = !toggled;
        if(toggled){
            onEnable();
        }else {
            onDisable();
        }
    }

    public void onEnable(){

    }

    public void onDisable(){

    }

    public void onUpdate(){

    }

    public void onRender(){

    }

    public Minecraft getMc() {
        return mc;
    }

    public void setMc(Minecraft mc) {
        this.mc = mc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isToggled() {
        return toggled;
    }

    public void setToggled(boolean toggled) {
        this.toggled = toggled;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
