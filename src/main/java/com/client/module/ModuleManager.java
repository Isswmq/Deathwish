package com.client.module;

import com.client.module.MOVEMENT.AutoSprint;

import java.util.ArrayList;

public class ModuleManager {
    public ArrayList<Module> modules;
    public AutoSprint sprint;

    public ModuleManager(){
        modules = new ArrayList<>();
        newModule(sprint = new AutoSprint());

    }

    public void newModule(Module module){
        modules.add(module);
    }

    public ArrayList<Module> getModules(){
        return modules;
    }

    public void onUpdate(){
        for (Module module : modules) {
            module.onUpdate();
        }
    }

    public void onRender(){
        for (Module module : modules) {
            module.onRender();
        }
    }

    public void onKey(int key){
        for (Module module : modules) {
            if(module.getKeyCode() == key){
                module.enable();
            }
        }
    }
}
