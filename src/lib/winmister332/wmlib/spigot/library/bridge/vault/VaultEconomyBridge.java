package lib.winmister332.wmlib.spigot.library.bridge.vault;

import org.bukkit.OfflinePlayer;

/**
 * VaultEconomyBridge Created By: WinMister332 On 1/7/2018 At 2:28 AM.
 * Copyright © WinMister332 2018!
 */
public final class VaultEconomyBridge
{
    private static VaultLibrary vault = VaultLibrary.INSTANCE;

    /**
     * Adds money to a players' Vault bank account.
     * @param plr The data of the player to add the money to.
     * @param amount The amount of money to add to the player.
     */
    public static void AddMoney(OfflinePlayer plr, double amount)
    {
        OfflinePlayer player = plr;
        vault.getEconomy().depositPlayer(player, amount);
    }

    /**
     * Subtracts money from a players' Vault bank account.
     * @param plr The data of the player to add the money to.
     * @param amount
     */
    public static void SubtractMoney(OfflinePlayer plr, double amount)
    {
        OfflinePlayer player = plr;
        vault.getEconomy().withdrawPlayer(player, amount);
    }

    /**
     * Gets the total value that the player currently has in their Vault bank account.
     * @param plr The data of the player that owns the acount with the balance to check.
     * @return The total balance the player has in their Vault bank acount.
     */
    public static double GetMoney(OfflinePlayer plr)
    {
        OfflinePlayer player = plr;
        return vault.getEconomy().getBalance(player);
    }
}
