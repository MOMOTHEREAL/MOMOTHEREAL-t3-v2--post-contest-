package com.tenjava.entries.MOMOTHEREAL.t3.errors;

import com.tenjava.entries.MOMOTHEREAL.t3.MessageUtil;
import org.bukkit.command.CommandSender;

/**
 * Copyright MOMOTHEREAL (c) 2014.
 */
public class NoPermissionError {
    private MessageUtil mu = new MessageUtil();
    private String message = mu.prefixedMessage("§4You can't do that!");

    public String getMessage() {
        return message;
    }

    public NoPermissionError(CommandSender sender) {
        sender.sendMessage(getMessage());
    }
}
