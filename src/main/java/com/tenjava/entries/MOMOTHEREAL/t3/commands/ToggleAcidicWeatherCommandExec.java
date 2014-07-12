package com.tenjava.entries.MOMOTHEREAL.t3.commands;

import com.tenjava.entries.MOMOTHEREAL.t3.MessageUtil;
import com.tenjava.entries.MOMOTHEREAL.t3.TenJava;
import com.tenjava.entries.MOMOTHEREAL.t3.errors.NotHumanError;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Copyright MOMOTHEREAL (c) 2014.
 *
 * Toggles the features of the plugin, in case the world needs a break from heavy duty.
 */
public class ToggleAcidicWeatherCommandExec implements CommandExecutor {
    private TenJava plugin;
    private MessageUtil messages = new MessageUtil();

    public ToggleAcidicWeatherCommandExec(TenJava plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender commandSender, Command cmd, String commandLabel, String[] args) {
        //TODO: Do stuff

        if (!(commandSender instanceof Player)) {
            new NotHumanError(commandSender);
            return false;
        }

        Player player = (Player)commandSender;

        TenJava.enabledFeatures = !TenJava.enabledFeatures;
        return true;
    }
}
