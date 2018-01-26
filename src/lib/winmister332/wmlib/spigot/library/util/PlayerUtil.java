package lib.winmister332.wmlib.spigot.library.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.block.Chest;
import org.bukkit.block.Container;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.potion.PotionEffect;

import java.util.*;

/**
 * PlayerUtil Created By: WinMister332 On 9/19/2017 At 10:01 PM!
 * Copyright © WinMister332 2017!
 */
public final class PlayerUtil {
    private static List<NameData> nameData = new ArrayList<>();

    /**
     * Allows the player to fly, or have permission to fly, but only while the setting is enabled.
     *
     * @param player The IGN of the player to apply the 'Fly-Mode' onto.
     * @param fly    Toggles 'Fly-Mode' on or off, based on the value.
     */
    public static void fly(String player, boolean fly) {
        Player plr = Bukkit.getPlayer(player);
        plr.setAllowFlight(fly);
        plr.setFlying(fly);
    }

    /**
     * Allows the player to fly, or have permission to fly, but only while the setting is enabled.
     *
     * @param player The UUID of the player to apply the 'Fly-Mode' onto.
     * @param fly    Toggles 'Fly-Mode' on or off, based on the value.
     */
    public static void fly(UUID player, boolean fly) {
        Player plr = Bukkit.getPlayer(player);
        plr.setAllowFlight(fly);
        plr.setFlying(fly);
    }

    /**
     * Teleports a player to another player.
     *
     * @param fromPlayer The IGN of the player to teleport.
     * @param toPlayer   The IGN of the destination player.
     */
    public static void teleport(String fromPlayer, String toPlayer) {
        Player p1 = Bukkit.getPlayer(fromPlayer);
        Player p2 = Bukkit.getPlayer(toPlayer);
        p1.teleport(p2);
    }

    /**
     * Teleports a player to another player.
     *
     * @param fromPlayer The UUID of the player to teleport.
     * @param toPlayer   The UUID of the destination player.
     */
    public static void teleport(UUID fromPlayer, UUID toPlayer) {
        Player p1 = Bukkit.getPlayer(fromPlayer);
        Player p2 = Bukkit.getPlayer(toPlayer);
        p1.teleport(p2);
    }

    /**
     * Teleports a player to another location within the current world.
     *
     * @param player     The IGN of the player to teleport.
     * @param toLocation The location the player will be teleported to.
     */
    public static void teleport(String player, Location toLocation) {
        Player tpPlayer = Bukkit.getPlayer(player);
        tpPlayer.teleport(toLocation);
    }

    /**
     * Teleports a player to another location within the current world.
     *
     * @param player     The UUID of the player to teleport.
     * @param toLocation The location the player will be teleported to.
     */
    public static void teleport(UUID player, Location toLocation) {
        Player tpPlayer = Bukkit.getPlayer(player);
        tpPlayer.teleport(toLocation);
    }

    /**
     * Gives the following effect to the player.
     *
     * @param player The IGN of the player to give the effect(s) to.
     * @param effect The effect(s) to give to the following player.
     */
    public static void setEffect(String player, PotionEffect effect) {
        Player plr = Bukkit.getPlayer(player);
        plr.addPotionEffect(effect);
    }

    /**
     * Gives the following effect to the player.
     *
     * @param player The UUID of the player to give the effect(s) to.
     * @param effect The effect(s) to give to the following player.
     */
    public static void setEffect(UUID player, PotionEffect effect) {
        Player plr = Bukkit.getPlayer(player);
        plr.addPotionEffect(effect);
    }

    /**
     * Gives the following effect to the player.
     *
     * @param player  The IGN of the player to give the effect(s) to.
     * @param effects The effect(s) to give to the following player.
     */
    public static void setEffect(String player, PotionEffect[] effects) {
        Player plr = Bukkit.getPlayer(player);
        for (PotionEffect effect : effects) {
            plr.addPotionEffect(effect);
        }
    }

    /**
     * Gives the following effect to the player.
     *
     * @param player  The UUID of the player to give the effect(s) to.
     * @param effects The effect(s) to give to the following player.
     */
    public static void setEffect(UUID player, PotionEffect[] effects) {
        Player plr = Bukkit.getPlayer(player);
        for (PotionEffect effect : effects) {
            plr.addPotionEffect(effect);
        }
    }

    /**
     * Removes the following effect(s) from the player.
     *
     * @param player The IGN of the player the effect(s) will be removed from.
     * @param effect The effect(s) that will be removed from the specified player.
     */
    public static void removeEffect(String player, PotionEffect effect) {
        Player plr = Bukkit.getPlayer(player);
        plr.removePotionEffect(effect.getType());
    }

    /**
     * Removes the following effect(s) from the player.
     *
     * @param player The UUID of the player the effect(s) will be removed from.
     * @param effect The effect(s) that will be removed from the specified player.
     */
    public static void removeEffect(UUID player, PotionEffect effect) {
        Player plr = Bukkit.getPlayer(player);
        plr.removePotionEffect(effect.getType());
    }

    /**
     * Removes the following effect(s) from the player.
     *
     * @param player  The IGN of the player the effect(s) will be removed from.
     * @param effects The effect(s) that will be removed from the specified player.
     */
    public static void removeEffect(String player, PotionEffect[] effects) {
        Player plr = Bukkit.getPlayer(player);
        for (PotionEffect effect : effects) {
            plr.removePotionEffect(effect.getType());
        }
    }

    /**
     * Removes the following effect(s) from the player.
     *
     * @param player  The UUID of the player the effect(s) will be removed from.
     * @param effects The effect(s) that will be removed from the specified player.
     */
    public static void removeEffect(UUID player, PotionEffect[] effects) {
        Player plr = Bukkit.getPlayer(player);
        for (PotionEffect effect : effects) {
            plr.removePotionEffect(effect.getType());
        }
    }

    /**
     * Sends a private message to the specified player.
     *
     * @param player  The IGN of the player that will receive the message.
     * @param message The message to send to the player.
     */
    public static void sendMessage(String player, String message) {
        Player plr = Bukkit.getPlayer(player);
        plr.sendMessage(message);
    }

    /**
     * Sends a private message to the specified player.
     *
     * @param player  The IGN of the player that will receive the message.
     * @param message The message to send to the player.
     */
    public static void sendMessage(String player, String[] message) {
        Player plr = Bukkit.getPlayer(player);
        plr.sendMessage(message);
    }

    /**
     * Sends a private message to the specified player.
     *
     * @param player  The UUID of the player that will receive the message.
     * @param message The message to send to the player.
     */
    public static void sendMessage(UUID player, String message) {
        Player plr = Bukkit.getPlayer(player);
        plr.sendMessage(message);
    }

    /**
     * Sends a private message to the specified player.
     *
     * @param player  The UUID of the player that will receive the message.
     * @param message The message to send to the player.
     */
    public static void sendMessage(UUID player, String[] message) {
        Player plr = Bukkit.getPlayer(player);
        plr.sendMessage(message);
    }

    /**
     * Sends a public chat message as if it came from the specified player.
     *
     * @param player  The IGN of the player that will send the public message.
     * @param message The message to send to the entire server.
     */
    public static void chatMessage(String player, String message) {
        Player plr = Bukkit.getPlayer(player);
        plr.chat(message);
    }

    /**
     * Sends a public chat message as if it came from the specified player.
     *
     * @param player  The IGN of the player that will send the public message.
     * @param message The message to send to the entire server.
     */
    public static void chatMessage(String player, String[] message) {
        Player plr = Bukkit.getPlayer(player);
        for (String s : message) {
            plr.chat(s);
        }
    }

    /**
     * Sends a public chat message as if it came from the specified player.
     *
     * @param player  The UUID of the player that will send the public message.
     * @param message The message to send to the entire server.
     */
    public static void chatMessage(UUID player, String message) {
        Player plr = Bukkit.getPlayer(player);
        plr.chat(message);
    }

    /**
     * Sends a public chat message as if it came from the specified player.
     *
     * @param player  The UUID of the player that will send the public message.
     * @param message The message to send to the entire server.
     */
    public static void chatMessage(UUID player, String[] message) {
        Player plr = Bukkit.getPlayer(player);
        for (String s : message) {
            plr.chat(s);
        }
    }

    /**
     * Sets the players total EXPERIENCE count to the value specified.
     *
     * @param player The IGN of the player that will receive the TOTAL number of levels.
     * @param xp     The total number of XP to set the players experience to.
     */
    public static void setEXP(String player, float xp) {
        Player plr = Bukkit.getPlayer(player);
        plr.setExp(xp);
    }

    /**
     * Sets the players total EXPERIENCE count to the value specified.
     *
     * @param player The UUID of the player that will receive the TOTAL number of levels.
     * @param xp     The total number of XP to set the players experience to.
     */
    public static void setEXP(UUID player, float xp) {
        Player plr = Bukkit.getPlayer(player);
        plr.setExp(xp);
    }

    /**
     * Sets the players total LEVEL count to the value specified.
     *
     * @param player The IGN of the player that will receive the TOTAL number of levels.
     * @param level  The total number of levels to set the players experience to.
     */
    public static void setLevel(String player, int level) {
        Player plr = Bukkit.getPlayer(player);
        plr.setLevel(level);
    }

    /**
     * Sets the players total EXPERIENCE count to the value specified.
     *
     * @param player The UUID of the player that will receive the TOTAL number of levels.
     * @param level  The total number of levels to set the players experience to.
     */
    public static void setLevel(UUID player, int level) {
        Player plr = Bukkit.getPlayer(player);
        plr.setLevel(level);
    }

    /**
     * Gives the player the total amount of XP specified, and adds it to the value they had previously.
     *
     * @param player The IGN of the player that will receive the XP.
     * @param xp     The number of xp that will be added to the players total number of xp.
     */
    public static void addEXP(String player, int xp) {
        Player plr = Bukkit.getPlayer(player);
        plr.giveExp(xp);
    }

    /**
     * Gives the player the total amount of XP specified, and adds it to the value they had previously.
     *
     * @param player The IGN of the player that will receive the levels.
     * @param level  The number of levels that will be added to the players total number of levels.
     */
    public static void addLevel(String player, int level) {
        Player plr = Bukkit.getPlayer(player);
        plr.giveExpLevels(level);
    }

    /**
     * Gives the player the total amount of XP specified, and adds it to the value they had previously.
     *
     * @param player The UUID of the player that will receive the XP.
     * @param xp     The number of xp that will be added to the players total number of xp.
     */
    public static void addEXP(UUID player, int xp) {
        Player plr = Bukkit.getPlayer(player);
        plr.giveExp(xp);
    }

    /**
     * Gives the player the total amount of XP specified, and adds it to the value they had previously.
     *
     * @param player The UUID of the player that will receive the levels.
     * @param level  The number of levels that will be added to the players total number of levels.
     */
    public static void addLevel(UUID player, int level) {
        Player plr = Bukkit.getPlayer(player);
        plr.giveExpLevels(level);
    }

    /**
     * Sets weather the player should be silent.
     *
     * @param player The IGN of the player that 'Silent-Mode' will be placed on.
     * @param silent Sets weather the player should be silent based on the value.
     */
    public static void silent(String player, boolean silent) {
        Player plr = Bukkit.getPlayer(player);
        plr.setSilent(silent);
    }

    /**
     * Sets weather the player should be silent.
     *
     * @param player The UUID of the player that 'Silent-Mode' will be placed on.
     * @param silent Sets weather the player should be silent based on the value.
     */
    public static void silent(UUID player, boolean silent) {
        Player plr = Bukkit.getPlayer(player);
        plr.setSilent(silent);
    }

    /**
     * Sets weather the player is immune from any sort of injury.
     *
     * @param player       The IGN of the player to make invincible.
     * @param invulnerable Sets weather the player can be hurt based on the value.
     */
    public static void invulnerable(String player, boolean invulnerable) {
        Player plr = Bukkit.getPlayer(player);
        plr.setInvulnerable(invulnerable);
    }

    /**
     * Sets weather the player is immune from any sort of injury.
     *
     * @param player       The UUID of the player to make invincible.
     * @param invulnerable Sets weather the player can be hurt based on the value.
     */
    public static void invulnerable(UUID player, boolean invulnerable) {
        Player plr = Bukkit.getPlayer(player);
        plr.setInvulnerable(invulnerable);
    }

    /**
     * Hides the specified player from the tab menu, and it makes the name above their head disappear.
     *
     * @param player The player to hide from tab, and the players name to take.
     */
    public static void hidePlayerName(String player) {
        Player plr = Bukkit.getPlayer(player);
        nameData.add(new NameData(plr.getUniqueId(), plr.getDisplayName(), plr.getPlayerListName()));
        plr.setDisplayName("");
        plr.setPlayerListName("");
    }

    /**
     * Hides the specified player from the tab menu, and it makes the name above their head disappear.
     *
     * @param player The player to hide from tab, and the players name to take.
     */
    public static void hidePlayerName(UUID player) {
        Player plr = Bukkit.getPlayer(player);
        nameData.add(new NameData(plr.getUniqueId(), plr.getDisplayName(), plr.getPlayerListName()));
        plr.setDisplayName("");
        plr.setPlayerListName("");
    }

    /**
     * Shows the specified players name in the tab menu, and it makes the name appear above their head.
     *
     * @param player The player to show in tab, and the players name to show.
     */
    public static void showPlayerName(String player) {
        Player plr = Bukkit.getPlayer(player);
        UUID plrID = plr.getUniqueId();
        for (NameData data : nameData) {
            if (data.getPlayerUUID() == plrID) {
                plr.setDisplayName(data.getDisplayName());
                plr.setPlayerListName(data.getTabMenuName());
                nameData.remove(data);
                break;
            }
        }
    }

    /**
     * Shows the specified players name in the tab menu, and it makes the name appear above their head.
     *
     * @param player The player to show in tab, and the players name to show.
     */
    public static void showPlayerName(UUID player) {
        Player plr = Bukkit.getPlayer(player);
        UUID plrID = plr.getUniqueId();
        for (NameData data : nameData) {
            if (data.getPlayerUUID() == plrID) {
                plr.setDisplayName(data.getDisplayName());
                plr.setPlayerListName(data.getTabMenuName());
                nameData.remove(data);
                break;
            }
        }
    }

    /**
     * Shows another players inventory to the specified player.
     * @param playerToShowInventory The IGN of the player that will see the other players inventory.
     * @param playersInventoryToShow The IGN of the player who's inventory will be shown.
     */
    public static void openInventory(String playerToShowInventory, String playersInventoryToShow)
    {
        Player showPlayer = getOnlinePlayer(playerToShowInventory);
        OfflinePlayer openPlayer = getOfflinePlayer(playersInventoryToShow);
        Entity playerToOpen = openPlayer.getPlayer();
        if (playerToOpen instanceof Player)
        {
            Player plr = (Player)playerToOpen;
            showPlayer.openInventory(plr.getInventory());
            plr.updateInventory();
            showPlayer.updateInventory();
        }
    }

    public static void openInventory(UUID playerToShowInventory, UUID playersInventoryToShow)
    {
        Player showPlayer = getOnlinePlayer(playerToShowInventory);
        OfflinePlayer openPlayer = getOfflinePlayer(playersInventoryToShow);
        Entity playerToOpen = openPlayer.getPlayer();
        if (playerToOpen instanceof Player)
        {
            Player plr = (Player)playerToOpen;
            showPlayer.openInventory(plr.getInventory());
            plr.updateInventory();
            showPlayer.updateInventory();
        }
    }

    /**
     * Gets the player by the specified name that is currently on the server.
     * <br>
     * Note: if the player is offline then nothing will be returned I suggest using 'getOfflinePlayer()'.
     * @param player The IGN of the player to get.
     * @return {@link Player} - The player with the following name.
     */
    public static Player getOnlinePlayer(String player)
    {
        return Bukkit.getPlayer(player);
    }

    /**
     * Gets the player by the specified UUID that is currently on the server.
     * <br>
     * Note: if the player is offline then nothing will be returned I suggest using 'getOfflinePlayer()'.
     * @param player The UUID of the player to get.
     * @return {@link Player} - The player with the following UUID.
     */
    public static Player getOnlinePlayer(UUID player)
    {
        return Bukkit.getPlayer(player);
    }

    /**
     * Searches all offline players for the player with the specified name.
     * @param player The IGN of the offline player.
     * @return {@link OfflinePlayer} - The offline player that was found.
     */
    public static OfflinePlayer getOfflinePlayer(String player)
    {
        OfflinePlayer output = null;
        OfflinePlayer[] plrs = Bukkit.getOfflinePlayers();
        for (OfflinePlayer plr : plrs)
        {
            if (plr.getName() == player)
            {
                output = plr;
                break;
            }
        }
        return output;
    }

    /**
     * Searches all offline players for the player with the specified UUID.
     * @param player The UUID of the offline player.
     * @return {@link OfflinePlayer} - The offline player that was found.
     */
    public static OfflinePlayer getOfflinePlayer(UUID player)
    {
        OfflinePlayer output = null;
        OfflinePlayer[] plrs = Bukkit.getOfflinePlayers();
        for (OfflinePlayer plr : plrs)
        {
            if (plr.getUniqueId() == player)
            {
                output = plr;
                break;
            }
        }
        return output;
    }

    private static final class NameData
    {
        private static String displayName = "";
        private static String tabMenuName = "";
        private static UUID playerUUID = null;

        public NameData(UUID uuid, String plrDisplayName, String tabName)
        {
            displayName = plrDisplayName;
            tabMenuName = tabName;
            playerUUID = uuid;
        }

        public UUID getPlayerUUID()
        {
            return playerUUID;
        }

        public String getDisplayName()
        {
            return displayName;
        }

        public String getTabMenuName()
        {
            return tabMenuName;
        }
    }
}
