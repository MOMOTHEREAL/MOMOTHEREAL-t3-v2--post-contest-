package com.tenjava.entries.MOMOTHEREAL.t3.timing;

import com.tenjava.entries.MOMOTHEREAL.t3.TenJava;
import org.bukkit.*;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;

/**
 * Copyright MOMOTHEREAL (c) 2014.
 */
public class AcidRainDamage implements Runnable {
    /**
     * Damages all the players that are: at daylight, do not have less than a heart of health, in a world with a difficulty higher that Peaceful.
     */
    @Override
    public void run() {

        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.getWorld().isThundering()) {
                if (TenJava.isAtDayLight(player) && (!(player.getHealth() < 2d)) && player.getWorld().getDifficulty() != Difficulty.PEACEFUL && TenJava.isAcidicWeather && TenJava.enabledFeatures && !TenJava.isInSnowBiome(player)) {
                    player.damage(1d);
                    player.playSound(player.getLocation(), Sound.FIZZ, 1f, 1f);
                }
            }
        }

    }



}