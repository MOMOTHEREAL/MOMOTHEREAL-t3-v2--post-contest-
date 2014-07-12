package com.tenjava.entries.MOMOTHEREAL.t3.commands;

import com.tenjava.entries.MOMOTHEREAL.t3.TenJava;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Copyright MOMOTHEREAL (c) 2014.
 *
 * Toggles the features of the plugin, in case the world needs a break from heavy duty.
 */
public class ToggleAcidicWeatherCommandExec implements CommandExecutor {
    private TenJava plugin;

    public ToggleAcidicWeatherCommandExec(TenJava plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender commandSender, Command cmd, String commandLabel, String[] args) {
        //TODO: Do stuff
        return false;
    }
}
