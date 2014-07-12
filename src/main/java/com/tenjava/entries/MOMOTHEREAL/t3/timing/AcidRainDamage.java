package com.tenjava.entries.MOMOTHEREAL.t3.timing;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.Material;
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
                if (isAtDayLight(player) && (!(player.getHealth() < 2d)) && player.getWorld().getDifficulty() != Difficulty.PEACEFUL) {
                    player.damage(1d);
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
            for (int iy = y; iy<=256; iy++) {
                if ((player.getWorld().getBlockAt(x, iy, z) != null) && player.getWorld().getBlockAt(x, iy, z).getType() != Material.AIR) {
                    light = false;
                    break;
                }
            }

            return light;
        }
}
