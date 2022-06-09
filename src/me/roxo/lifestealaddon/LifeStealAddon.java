package me.roxo.lifestealaddon;

import me.roxo.lifestealaddon.commands.HealthCommand;
import me.roxo.lifestealaddon.items.ItemManager;
import me.roxo.lifestealaddon.listeners.HealthListener;
import me.roxo.lifestealaddon.listeners.UseRevival;
import org.bukkit.plugin.java.JavaPlugin;

public class LifeStealAddon extends JavaPlugin {




    @Override
    public void onEnable(){

        loadConfig();
        ItemManager.createRevival();
        getServer().getPluginManager().registerEvents(new HealthListener(),this);
        getServer().getPluginManager().registerEvents(new UseRevival(this),this);
        getCommand("gethealth").setExecutor(new HealthCommand());
        //getServer().getPluginManager().registerEvents( this,this);
        //getServer().getPluginManager().registerEvents(new LifeStealAddon(), this);

    }


    @Override
    public void onDisable(){



    }

    private void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();


    }

    public LifeStealAddon plugin() {
        return this;
    }


}
