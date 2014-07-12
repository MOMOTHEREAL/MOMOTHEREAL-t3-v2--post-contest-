package com.tenjava.entries.MOMOTHEREAL.t3;

import com.tenjava.entries.MOMOTHEREAL.t3.commands.ToggleAcidicWeatherCommandExec;
import com.tenjava.entries.MOMOTHEREAL.t3.listeners.WeatherListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class TenJava extends JavaPlugin {
    /**
     * The name of the plugin (connected with the plugin description).
     */
    public static String pluginName;
    /**
     * The version of the plugin (connected with the plugin description).
     */
    public static String pluginVersion;
    /**
     * The server logger.
     */
    public Logger logger;

    public static boolean enabledFeatures;

    public static boolean isAcidRaining;


    @Override
    public void onEnable() {
        pluginName = this.getDescription().getName();
        pluginVersion = this.getDescription().getVersion();
        this.logger = Bukkit.getLogger();
        logger.info(pluginName + " has been enabled.");
        registerCommands();
        registerListeners();
    }

    @Override
    public void onDisable() {
        logger.info(pluginName + " has been disabled.");
    }

    /**
     * Registers all the commands used by the plugin.
     */
    public void registerCommands() {
        this.getCommand("toggleacidic").setExecutor(new ToggleAcidicWeatherCommandExec(this));
    }

    /**
     * Registers all the events used by the plugin.
     */
    public void registerListeners(){
        this.getServer().getPluginManager().registerEvents(new WeatherListener(this), this);
    };



}
