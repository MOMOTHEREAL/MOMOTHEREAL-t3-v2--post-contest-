package com.tenjava.entries.MOMOTHEREAL.t3.timing;

import com.tenjava.entries.MOMOTHEREAL.t3.TenJava;
import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

/**
 * Copyright MOMOTHEREAL (c) 2014.
 */
public class AcidRainDamage implements Runnable {
    @Override
    public void run() {

        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.getWorld().isThundering()) {
                Bukkit.broadcastMessage("Thunder!");
                if (isAtDayLight(player) && (!(player.getHealth() < 2d)) && player.getWorld().getDifficulty() != Difficulty.PEACEFUL && TenJava.isAcidRaining) {
                    player.damage(1d);
                    player.playSound(player.getLocation(), Sound.FIZZ, 1f, 1f);
                }
            }else{
                Bukkit.broadcastMessage("No thunder!");
            }
        }

    }

    public boolean isAtDayLight(Player player) {
            int y = player.getLocation().getBlockY()+2;
            int x = player.getLocation().getBlockX();
            int z = player.getLocation().getBlockZ();
            boolean light = true;
            for (int iy = y; iy < player.getWorld().getMaxHeight(); iy++) {
                if (player.getWorld().getBlockAt(x, iy, z).getType() != Material.AIR) {
                    light = false;
                    break;
                }
            }
            return light;
        }
}
