package lib.winmister332.wmlib.spigot.library.commands;

import lib.winmister332.wmlib.util.TextUtil;
import org.bukkit.entity.Player;

/**
 * CommandSender Created By: WinMister332 On 1/6/2018 At 10:53 PM.
 * Copyright © WinMister332 2018!
 */
public class CommandSender
{
    private org.bukkit.command.CommandSender sender = null;

    public CommandSender(org.bukkit.command.CommandSender sender)
    {
        this.sender = sender;
    }

    /**
     * Sends a message to the sender.
     * @param message The message to send.
     */
    public void sendMessage(final String message)
    {
        if (getSenderType() == SenderType.CONSOLE)
        {
            sender.sendMessage(TextUtil.translateColorCodes(message));
        }
        else
        {
            if (message.contains("&"))
            {
                String x = "";
                x = message.replaceAll("&", "§");
                sender.sendMessage(TextUtil.logToConsole(x));
            }
        }
    }

    /**
     * The type of sender.
     * @return {@link SenderType} - The sender.
     */
    public SenderType getSenderType()
    {
        if (sender instanceof Player)
            return SenderType.PLAYER;
        return SenderType.CONSOLE;
    }

    /**
     * The original raw sender that was forwarded to this class.
     * @return {@link org.bukkit.command.CommandSender} - The original command sender.
     */
    public org.bukkit.command.CommandSender getSender()
    {
        return sender;
    }
}
