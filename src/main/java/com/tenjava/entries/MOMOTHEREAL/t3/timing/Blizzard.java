package com.tenjava.entries.MOMOTHEREAL.t3.timing;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Snowball;
import org.bukkit.util.Vector;

import java.util.Random;

/**
 * Copyright MOMOTHEREAL (c) 2014.
 */
public class Blizzard implements Runnable {
    private World world;

    public Blizzard(World world) {
        this.world = world;
    }


    @Override
    public void run() {
        for (Chunk chunk : world.getLoadedChunks()) {
            Biome biome = chunk.getBlock(8, 30, 8).getBiome(); //8, 30, 8 is to find the center of the chunk
            if (biome == Biome.ICE_PLAINS || biome == Biome.ICE_MOUNTAINS || biome == Biome.ICE_PLAINS_SPIKES
                    || biome == Biome.COLD_BEACH || biome == Biome.COLD_TAIGA || biome == Biome.COLD_TAIGA_HILLS ||
                    biome == Biome.COLD_TAIGA_MOUNTAINS || biome == Biome.FROZEN_OCEAN
                    || biome == Biome.FROZEN_RIVER) {
                for (int foo = 1; foo <= 10; foo++) {
                    Random random = new Random();
                    int x = random.nextInt(16) - 1;
                    int z = random.nextInt(16) - 1;
                    Location randomLocation = chunk.getBlock(x, 200, z).getLocation();
                    Snowball snowball = (Snowball) world.spawnEntity(randomLocation, EntityType.SNOWBALL);
                }

            }
        }
    }
}
