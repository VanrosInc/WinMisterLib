package lib.winmister332.wmlib.spigot.library.bridge.vault;

import lib.winmister332.wmlib.spigot.library.logger.Logger;
import lib.winmister332.wmlib.spigot.main.WMPlugin;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.plugin.RegisteredServiceProvider;

/**
 * VaultLibrary Created By: WinMister332 On 1/7/2018 At 2:29 AM.
 * Copyright © WinMister332 2018!
 */
public class VaultLibrary
{
    private Economy economy = null;
    private Chat chat = null;
    private Permission perm = null;
    private boolean usingVault = false;

    public static VaultLibrary INSTANCE = null;

    public VaultLibrary()
    {
        if (!(setupEconomy()))
        {
            WMPlugin.INSTANCE.getWMLogger().Log(Logger.LogStatus.WARNING, "Vault dependency is not found, loading plugin without Vault configuration.");
            usingVault = false;
            return;
        }
        setupPermissions();
        setupChat();
        usingVault = true;
        INSTANCE = this;
    }

    private boolean setupEconomy()
    {
        if (WMPlugin.INSTANCE.getServer().getPluginManager().getPlugin("Vault") == null) return false;
        RegisteredServiceProvider<Economy> rsp = WMPlugin.INSTANCE.getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) return false;
        economy = rsp.getProvider();
        return economy != null;
    }

    private boolean setupChat()
    {
        RegisteredServiceProvider<Chat> rsp = WMPlugin.INSTANCE.getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }

    private boolean setupPermissions()
    {
        RegisteredServiceProvider<Permission> rsp = WMPlugin.INSTANCE.getServer().getServicesManager().getRegistration(Permission.class);
        perm = rsp.getProvider();
        return perm != null;
    }

    /**
     * Gets the internal Economy class that was created by the initializer.
     * @return The main economy class.
     */
    public Economy getEconomy()
    {
        return economy;
    }

    /**
     * Gets the internal Chat class that was created by the initializer.
     * @return The main chat class.
     */
    public Chat getChat()
    {
        return chat;
    }

    /**
     * Gets the internal Permission class that was created by the initializer.
     * @return The main permission class.
     */
    public Permission getPermissions()
    {
        return perm;
    }

    /**
     * Checks to see if the plugin was found by the initializer and being used currently by the AdvancedSlaves plugin.
     * @return Is Vault loaded by the server and is usable.
     */
    public boolean vaultEnabled()
    {
        if (usingVault == true && WMPlugin.INSTANCE.getServer().getPluginManager().isPluginEnabled("Vault") == true) return true;
        return false;
    }
}
