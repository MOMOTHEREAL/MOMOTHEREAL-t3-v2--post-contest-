package com.tenjava.entries.MOMOTHEREAL.t3;

import com.tenjava.entries.MOMOTHEREAL.t3.commands.ToggleAcidicWeatherCommandExec;
import com.tenjava.entries.MOMOTHEREAL.t3.listeners.WeatherListener;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;
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

    /**
     * Are the features enabled on the server? (change using /toggleacid)
     */
    public static boolean enabledFeatures = true;

    /**
     * Is the acidic weather (plugin random events) enabled?
     */
    public static boolean isAcidicWeather = false;


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

    /**
     * Checks if the player is currently in a snow biome.
     */
    public static boolean isInSnowBiome(Player player) {
        Location l = player.getLocation();
        Biome b = l.getBlock().getBiome();
        if (b == Biome.ICE_PLAINS || b == Biome.ICE_MOUNTAINS || b == Biome.ICE_PLAINS_SPIKES
                || b == Biome.COLD_BEACH || b == Biome.COLD_TAIGA || b == Biome.COLD_TAIGA_HILLS || b == Biome.COLD_TAIGA_MOUNTAINS || b == Biome.FROZEN_OCEAN
                || b == Biome.FROZEN_RIVER) return true;

        return false;
    }

    public static boolean isInDesert(Player player) {
        Location l = player.getLocation();
        Biome b = l.getBlock().getBiome();
        if (b == Biome.DESERT || b == Biome.DESERT_HILLS || b == Biome.DESERT_MOUNTAINS
                || b == Biome.SAVANNA || b == Biome.SAVANNA_MOUNTAINS || b == Biome.SAVANNA_PLATEAU || b == Biome.SAVANNA_PLATEAU_MOUNTAINS)
                return true;

        return false;
    }




}
