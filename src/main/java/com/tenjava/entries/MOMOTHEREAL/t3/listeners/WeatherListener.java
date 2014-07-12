package com.tenjava.entries.MOMOTHEREAL.t3.listeners;

import com.tenjava.entries.MOMOTHEREAL.t3.TenJava;
import com.tenjava.entries.MOMOTHEREAL.t3.timing.AcidRainDamage;
import com.tenjava.entries.MOMOTHEREAL.t3.timing.BlackIce;
import org.bukkit.*;
import org.bukkit.block.Biome;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

/**
 * Copyright MOMOTHEREAL (c) 2014.
 */
public class WeatherListener implements Listener {

    private TenJava plugin;

    public WeatherListener(TenJava plugin) {
        this.plugin = plugin;
    }

    /**
     * Stops the acidic weather as soon as the raining stops.
     */
    @EventHandler
    public void onStopRaining(WeatherChangeEvent event) {
        if (!event.toWeatherState()) {
            TenJava.isAcidicWeather = false;
        }
        if (TenJava.enabledFeatures) {
            Random random = new Random();
            int b = random.nextInt(100);
            if (b <= 10) {
                startHeatStroke();
            }
        }

    }

    public void startHeatStroke() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (TenJava.isInDesert(player) && TenJava.isAcidicWeather) {
                player.setFireTicks(Integer.MAX_VALUE);
                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 1));
                player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, Integer.MAX_VALUE, 1));
                player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, Integer.MAX_VALUE, 0));
            }
        }
    }

    public void startHailFalling() {
        for (World world : Bukkit.getWorlds()) {
            for (Chunk chunk : world.getLoadedChunks()) {
                Biome biome = chunk.getBlock(8, 30, 8).getBiome(); //8, 30, 8 is to find the center of the chunk
                if (biome == Biome.ICE_PLAINS || biome == Biome.ICE_MOUNTAINS || biome == Biome.ICE_PLAINS_SPIKES
                        || biome == Biome.COLD_BEACH || biome == Biome.COLD_TAIGA || biome == Biome.COLD_TAIGA_HILLS ||
                        biome == Biome.COLD_TAIGA_MOUNTAINS || biome == Biome.FROZEN_OCEAN
                        || biome == Biome.FROZEN_RIVER) {
                    for (int i = 0; i <= 5; i++) {
                        Random random = new Random();
                        int x = random.nextInt(16) - 1;
                        int z = random.nextInt(16) - 1;
                        Location randomLocation = chunk.getBlock(x, 200, z).getLocation();
                        world.spawnFallingBlock(randomLocation, Material.PACKED_ICE, (byte) 0);
                    }
                }
            }
        }
    }

    /**
     * Starts the possibility of acidic weather to start (when rain starts)
     */
    @EventHandler
    public void onStartRaining(WeatherChangeEvent event) {
        if (event.toWeatherState()) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                Random random = new Random();
                int b = random.nextInt(100);
                if (b <= 20) {
                    TenJava.isAcidicWeather = true;
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        player.getWorld().setThundering(true);
                    }
                    Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new BlackIce(), 20l * 2, 20l * 2);
                    Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new AcidRainDamage(), 20l * 2, 20l * 2);

                }
            }
            Random random = new Random();
            int i = random.nextInt(100);
            if (i <= 20 && TenJava.enabledFeatures)
                startHailFalling();
        }

    }
}
