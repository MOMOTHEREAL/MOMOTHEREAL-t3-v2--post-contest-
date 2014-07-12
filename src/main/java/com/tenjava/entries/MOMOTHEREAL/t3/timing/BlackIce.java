package com.tenjava.entries.MOMOTHEREAL.t3.timing;

import com.tenjava.entries.MOMOTHEREAL.t3.TenJava;
import org.bukkit.*;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Copyright MOMOTHEREAL (c) 2014.
 */
public class BlackIce implements Runnable {

    /**
     * Spawns spikes of black ice of all players that are: in a world where the difficulty is higher than Peaceful, in a snow biome and in direct contact with daylight.
     */
    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.getWorld().isThundering()) {
                if (player.getWorld().getDifficulty() != Difficulty.PEACEFUL && TenJava.isAcidicWeather && TenJava.enabledFeatures && TenJava.isInSnowBiome(player) && isAtDayLight(player)) {
                    for (Location l : randomLocationAroundPlayer(player)) {
                        l.getBlock().setType(Material.ICE);
                    }
                    player.playSound(player.getLocation(), Sound.FIZZ, 1f, 1f);
                }
            }
        }
    }

    /**
     * Gets a list of random places to spawn ice spikes.
     */
    public List<Location> randomLocationAroundPlayer(Player player) {
        List<Location> r = new ArrayList<>();

        Location under = player.getLocation().subtract(0d, 1d, 0d);
        r.add(under);

        Random random = new Random();

        int where = random.nextInt(4);

        if (where == 1) {
            Location p1 = player.getLocation().add(1d, 0d, 1d);
            Location p2 = player.getLocation().add(1d, 1d, 1d);
            r.add(p1);
            r.add(p2);
        }

        if (where == 2) {
            Location p1 = player.getLocation().add(-1d, 0d, 1d);
            Location p2 = player.getLocation().add(-1d, 1d, 1d);
            r.add(p1);
            r.add(p2);
        }

        if (where == 3) {
            Location p1 = player.getLocation().add(-1d, 0d, -1d);
            Location p2 = player.getLocation().add(-1d, 1d, -1d);
            r.add(p1);
            r.add(p2);
        }

        if (where == 4) {
            Location p1 = player.getLocation().add(1d, 0d, -1d);
            Location p2 = player.getLocation().add(1d, 1d, -1d);
            r.add(p1);
            r.add(p2);
        }


        return r;
    }

    /**
     * Checks is a player is in direct contact with daylight.
     */
    public boolean isAtDayLight(Player player) {
        int y = player.getLocation().getBlockY() + 2;
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
