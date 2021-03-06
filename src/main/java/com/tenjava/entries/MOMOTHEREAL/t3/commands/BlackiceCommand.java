package com.tenjava.entries.MOMOTHEREAL.t3.commands;

import com.tenjava.entries.MOMOTHEREAL.t3.MessageUtil;
import com.tenjava.entries.MOMOTHEREAL.t3.TenJava;
import com.tenjava.entries.MOMOTHEREAL.t3.errors.NoPermissionError;
import com.tenjava.entries.MOMOTHEREAL.t3.errors.NotHumanError;
import com.tenjava.entries.MOMOTHEREAL.t3.listeners.WeatherListener;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Copyright MOMOTHEREAL (c) 2014.
 */
public class BlackiceCommand implements CommandExecutor{
    private TenJava plugin;

    public BlackiceCommand(TenJava plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender commandSender, Command cmd, String label, String[] args) {
        if (!(commandSender instanceof Player)) {
            new NotHumanError(commandSender);
            return false;
        }

        Player player = (Player)commandSender;
        if (!player.hasPermission("acidic.blackice")) {
            new NoPermissionError(commandSender);
            return false;
        }

        MessageUtil messageUtil = new MessageUtil();
        WeatherListener weather = new WeatherListener(plugin);
        weather.startBlackIce();
        messageUtil.sendMessage("§3Started black ice storm in all worlds.", player, true);

        return true;
    }
}
