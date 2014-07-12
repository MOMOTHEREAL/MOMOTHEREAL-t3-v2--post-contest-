package com.tenjava.entries.MOMOTHEREAL.t3;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Copyright MOMOTHEREAL (c) 2014.
 */
public class MessageUtil {

    private String prefix = "§8[§3" + TenJava.pluginName + "§8]§r ";

    public String getPrefix() {
        return prefix;
    }

    public String colorizeMessageFromColorCode(String message, char color) {
        return ChatColor.translateAlternateColorCodes('§', "§" + color + message);
    }

    public void sendMessage(String message, Player player, boolean prefix) {
        if (prefix) {
            player.sendMessage(prefixedMessage(message));
            return;
        }
        player.sendMessage(message);
    }

    public String prefixedMessage(String message) {
        return prefix + " " + message;
    }


}
