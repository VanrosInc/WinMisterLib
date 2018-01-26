package lib.winmister332.wmlib.spigot.library.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * CommandInvoker Created By: WinMister332 On 1/6/2018 At 9:54 PM.
 * Copyright © WinMister332 2018!
 */
public class CommandInvoker
{
    public static CommandInvoker INSTANCE = null;
    private List<Command> commands = new ArrayList<>();

    public CommandInvoker()
    {
        INSTANCE = this;
    }

    /**
     * Adds a command to the internal command registry.
     * @param command The command to add to the internal registry.
     */
    public void addCommand(Command command)
    {
        commands.add(command);
    }

    /**
     * Removes a command from the internal command registry.
     * @param command The command to remove from the internal registry.
     */
    public void removeCommand(Command command)
    {
        commands.remove((Command)command);
    }

    /**
     * Gets a list of all commands in the internal command registry.
     * @return The list of commands from the command registry.
     */
    public List<Command> getCommands()
    {
        return Collections.unmodifiableList(commands);
    }

    /**
     * Gets a command with the specified name.
     * @param name The name to search for.
     * @return {@link Command} - The command in the internal command registry with the specified name.
     */
    public Command getCommandByName(String name)
    {
        Command x = null;
        for (Command cmd : getCommands())
        {
            if (cmd.CommandName().toLowerCase() == name.toLowerCase())
            {
                x = cmd;
                break;
            }
        }
        return x;
    }

    /**
     * Gets a command with the specified alias.
     * @param alias The alias to search for.
     * @return {@link Command} - The command in the internal command registry with the specified alias.
     */
    public Command getCommandByAlias(String alias)
    {
        boolean allowBreak = false;
        Command x = null;
        for (Command cmd : getCommands())
        {
            for (String s : cmd.CommandAliases())
            {
                if (s.toLowerCase() == alias.toLowerCase())
                {
                    x = cmd;
                    allowBreak = true;
                    break;
                }
            }
            if (allowBreak) break;
        }
        return x;
    }

    /**
     * Gets a command with the specified name or alias.
     * @param value The name or alias to search for.
     * @return {@link Command} - The command with the following name or alias.
     */
    public Command getCommand(String value)
    {
        Command cname = getCommandByName(value);
        Command calias = getCommandByAlias(value);
        if (cname != null && calias == null) return cname;
        else if (cname == null && calias != null) return calias;
        else if (cname != null && calias != null) return cname;
        else return null;
    }

    /**
     * Invokes a command from the command registry with the specified data if one is found.
     * @param command The command to check and invoke.
     * @param sender The sender that sent the command.
     * @param args The args that where sent if any.
     */
    public void InvokeCommand(String command, CommandSender sender, String[] args)
    {
        Command cmd = getCommand(command);
        CommandArgs cmdArgs = new CommandArgs(args);
        if (!(cmd == null))
        {
            if ((sender.getSenderType() == SenderType.PLAYER) && (cmd.RequiredSender() == SenderType.CONSOLE))
            {
                //Is Player - Requires Console!
                sender.sendMessage("&6&lThat command may only be used by the console!");
                return;
            }
            if ((sender.getSenderType() == SenderType.CONSOLE) && (cmd.RequiredSender() == SenderType.PLAYER))
            {
                //Is Console - Requires Player!
                sender.sendMessage("&6&lThat command may only be used in-game!");
                return;
            }
            if ((sender.getSenderType() == SenderType.PLAYER && cmd.RequiredSender() == SenderType.PLAYER) || (sender.getSenderType() == SenderType.CONSOLE && cmd.RequiredSender() == SenderType.CONSOLE))
            {
                //Invoke Command Normally!
                try
                {
                    cmd.CommandInvoked(this, sender, new CommandArgs(args));
                    return;
                }
                catch (Exception ex)
                {
                    sender.sendMessage("&c&lSyntax Error: &a&l/" + command + " " + cmd.CommandSyntax());
                    return;
                }
            }
        }
        else
        {
            sender.sendMessage("That's not a valid command!");
            return;
        }
    }
}
