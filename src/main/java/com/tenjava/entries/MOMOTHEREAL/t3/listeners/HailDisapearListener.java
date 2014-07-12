package com.tenjava.entries.MOMOTHEREAL.t3.listeners;

import com.tenjava.entries.MOMOTHEREAL.t3.TenJava;
import com.tenjava.entries.MOMOTHEREAL.t3.timing.HailDisappear;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;

import java.util.Random;

/**
 * Copyright MOMOTHEREAL (c) 2014.
 */
public class HailDisapearListener implements Listener {
    private TenJava plugin;

    public HailDisapearListener(TenJava plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onReachFloor(EntityChangeBlockEvent event) {
        if (event.getEntity().getType() == EntityType.FALLING_BLOCK) {
            FallingBlock hail = (FallingBlock)event.getEntity();
            if (hail.getMaterial()== Material.PACKED_ICE) {
                Random random = new Random();
                int i = random.nextInt(60);
                plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new HailDisappear(event.getBlock()), i*20l);
            }
        }
    }
}
