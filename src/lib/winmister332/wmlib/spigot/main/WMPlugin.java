package lib.winmister332.wmlib.spigot.main;

import lib.winmister332.wmlib.spigot.library.bridge.factions.FactionsLibrary;
import lib.winmister332.wmlib.spigot.library.bridge.vault.VaultLibrary;
import lib.winmister332.wmlib.spigot.library.commands.CommandInvoker;
import lib.winmister332.wmlib.spigot.library.configuration.GeneralConfig;
import lib.winmister332.wmlib.spigot.library.logger.Logger;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * WMPlugin Created By: WinMister332 On 12/30/2017 At 1:07 AM.
 * Copyright © WinMister332 2017!
 */
public class WMPlugin extends JavaPlugin
{
    private Logger logger = null;
    private boolean isToggled = false;
    public static WMPlugin INSTANCE;
    private GeneralConfig config = null;
    private CommandInvoker invoker = null;

    public WMPlugin()
    {
        INSTANCE = this;
        invoker = new CommandInvoker();
    }

    @Override
    public FileConfiguration getConfig() {
        return super.getConfig();
    }

    /**
     * Reloads the config that was set if one was set using SetConfig().
     */
    @Override
    public void reloadConfig()
    {
        if (config == null) super.reloadConfig();
        config.check();
        config.reload();
    }

    /**
     * Saves the config that was set if one was set using SetConfig().
     */
    @Override
    public void saveConfig()
    {
        if (config == null) super.saveConfig();
        config.check();
        config.save();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (isToggled)
        {
            invoker.InvokeCommand(label, new lib.winmister332.wmlib.spigot.library.commands.CommandSender(sender), args);
            return false;
        }
        else
            return false;
    }

    @Override
    public void onDisable()
    {
        isToggled = false;
        logger = null;
        disable();
    }

    @Override
    public void onEnable()
    {
        isToggled = true;
        logger = new Logger(this, true);
        new VaultLibrary();
        new FactionsLibrary();
        enable();
    }

    /**
     * Reloads the plugin.
     */
    public void Reload()
    {
        getWMLogger().Log(Logger.LogStatus.DEBUG_INFO, "Reloading Plugin...");
        getPluginLoader().disablePlugin(this);
        getPluginLoader().enablePlugin(this);
        getWMLogger().Log(Logger.LogStatus.DEBUG_INFO, "Reload Complete!");
    }

    /**
     * Sets the toggle of the plugin.
     * If enabled the plugin will disable.
     * If disabled the plugin will enable.
     */
    public void toggle()
    {
        if (toggled())
        {
            //Untoggle
            Bukkit.getPluginManager().disablePlugin(this);
            isToggled = false;
            getWMLogger().Log(Logger.LogStatus.DEBUG_INFO, "Disabled!");
        }
        else
        {
            //Toggle
            Bukkit.getPluginManager().enablePlugin(this);
            isToggled = true;
            getWMLogger().Log(Logger.LogStatus.DEBUG_INFO, "Enabled!");
        }
    }

    /**
     * Gets a true/false value on weather or not the plugin is enabled or disabled.
     * @return boolean - Returns a value representing wheather or not the plugin is enabled or disabled.
     */
    public final boolean toggled()
    {
        return isToggled;
    }

    public void enable() {}
    public void disable() {}

    /**
     * Sets wheather or not the attached logger will allow debug output.
     * @param debug Sets weather the logger should accept debug output.
     */
    public void allowDebug(boolean debug)
    {
        logger.SetDebug(debug);
    }

    /**
     * Gets the attached logger.
     * @return {@link Logger} - Gets the internal logger, or an external logger that was forwarded to the internal logger.
     */
    public Logger getWMLogger()
    {
        return logger;
    }

    /**
     * Sets the internal logger to another logger, if this method is set the internal logger should be redirected to this one.
     * @param logger - The logger to set with the internal logger.
     */
    public void setWMLogger(Logger logger)
    {
        this.logger = logger;
    }

    /**
     * Gets the RAW WMSpigotPlugin class that this one is inheriting from.
     * @return {@link WMPlugin} - Gets this plugin class.
     */
    public WMPlugin getPlugin()
    {
        return this;
    }

    /**
     * Sets the Main config file so you can use the features in this class like reloadConfig(), and saveConfig().
     * @param config - The config class to set that the main config functions will follow.
     */
    public void setConfig(GeneralConfig config)
    {
        this.config = config;
    }
}
