package com.tenjava.entries.MOMOTHEREAL.t3.listeners;

import com.tenjava.entries.MOMOTHEREAL.t3.TenJava;
import com.tenjava.entries.MOMOTHEREAL.t3.timing.AcidRainDamage;
import com.tenjava.entries.MOMOTHEREAL.t3.timing.BlackIce;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

import java.util.Random;

/**
 * Copyright MOMOTHEREAL (c) 2014.
 */
public class WeatherListener implements Listener {

    private TenJava plugin;

    public WeatherListener(TenJava plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onStopRaining(WeatherChangeEvent event) {
        if (!event.toWeatherState()) {
            TenJava.isAcidRaining = false;
        }
    }


    @EventHandler
    public void onStartRaining(WeatherChangeEvent event) {
        if (event.toWeatherState()) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                    Random random = new Random();
                    int b = random.nextInt(100);
                    Bukkit.broadcastMessage(b + "");
                    if (b <= 20) {
                        TenJava.isAcidRaining = true;
                        for (Player player : Bukkit.getOnlinePlayers()) {
                            player.getWorld().setThundering(true);
                        }
                        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new BlackIce(), 20l*2, 20l*2);
                        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new AcidRainDamage(), 20l*2, 20l*2);
                    }
            }

        }
    }
}
