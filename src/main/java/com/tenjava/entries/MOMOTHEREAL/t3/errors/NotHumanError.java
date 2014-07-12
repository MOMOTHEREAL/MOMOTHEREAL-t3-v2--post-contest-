package com.tenjava.entries.MOMOTHEREAL.t3.errors;

import com.tenjava.entries.MOMOTHEREAL.t3.MessageUtil;
import org.bukkit.command.CommandSender;

/**
 * Copyright MOMOTHEREAL (c) 2014.
 */
public class NotHumanError {
    private MessageUtil mu = new MessageUtil();
    private String message = mu.prefixedMessage("§4I have no idea what you are.");

    public String getMessage() {
        return message;
    }

    public NotHumanError(CommandSender sender) {
        sender.sendMessage(getMessage());
    }
}
