package com.tenjava.entries.MOMOTHEREAL.t3.listeners;

import com.tenjava.entries.MOMOTHEREAL.t3.TenJava;
import com.tenjava.entries.MOMOTHEREAL.t3.timing.AcidRainDamage;
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
    public void onStartRaining(WeatherChangeEvent event) {
        Random random = new Random();
        int b = random.nextInt(100);
        if (b <= 20) {
            plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new AcidRainDamage(), 20l*2, 20l*2);
        }

    }
}
