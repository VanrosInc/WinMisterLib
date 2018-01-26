package lib.winmister332.wmlib.spigot.library.commands;

/**
 * Command Created By: WinMister332 On 1/6/2018 At 10:08 PM.
 * Copyright © WinMister332 2018!
 */
public interface Command
{
    String CommandName();
    String CommandDescription();
    String CommandSyntax();
    String[] CommandAliases();
    SenderType RequiredSender();
    void CommandInvoked(CommandInvoker invoker, CommandSender sender, CommandArgs args);
}
