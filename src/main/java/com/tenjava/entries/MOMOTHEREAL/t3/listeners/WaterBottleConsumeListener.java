package com.tenjava.entries.MOMOTHEREAL.t3.listeners;

import com.tenjava.entries.MOMOTHEREAL.t3.TenJava;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

/**
 * Copyright MOMOTHEREAL (c) 2014.
 */
public class WaterBottleConsumeListener implements Listener{
    @EventHandler
    public void onConsume(PlayerItemConsumeEvent event) {
        ItemStack item = event.getItem();
        if (item.getType()== Material.POTION && item.getDurability()==(short)0) {
            if (TenJava.isInDesert(event.getPlayer())) {
                Player player = event.getPlayer();
                if (player.hasPotionEffect(PotionEffectType.CONFUSION)) player.removePotionEffect(PotionEffectType.CONFUSION);
                if (player.hasPotionEffect(PotionEffectType.BLINDNESS)) player.removePotionEffect(PotionEffectType.BLINDNESS);
                if (player.hasPotionEffect(PotionEffectType.SLOW)) player.removePotionEffect(PotionEffectType.SLOW);
                if (player.getFireTicks()!=0) player.setFireTicks(0);
            }
        }
    }
}
