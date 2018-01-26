package lib.winmister332.wmlib.spigot.library.bridge.vault;

import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * VaultPermissionBridge Created By: WinMister332 On 1/7/2018 At 8:55 PM.
 * Copyright © WinMister332 2018!
 */
public final class VaultPermissionBridge
{
    private static VaultLibrary vault = VaultLibrary.INSTANCE;

    /**
     * Gets a list of all known groups that was registered.
     * @return Returns a list of known groups.
     */
    public static List<String> getGroups()
    {
        String[] x = vault.getPermissions().getGroups();
        List<String> list = new ArrayList<>(x.length);
        for (String s : x)
        {
            list.add(s);
        }
        return list;
    }

    /**
     * Gets a list of groups the specified player has.
     * @param player The player that has groups to list.
     * @return A list of groups the player has.
     */
    public static List<String> getPlayerGroups(Player player)
    {
        String[] x = vault.getPermissions().getPlayerGroups(player);
        List<String> list = new ArrayList<>(x.length);
        for (String s : x)
        {
            list.add(s);
        }
        return list;
    }

    /**
     * Gets a list of groups the specified player has for the specified world.
     * @param world The world that the player has the groups in.
     * @param player The player that has groups to list for the specified world.
     * @return A list of groups the player has for the specified world.
     */
    public static List<String> getPlayerGroups(String world, OfflinePlayer player)
    {
        String[] x = vault.getPermissions().getPlayerGroups(world, player);
        List<String> list = new ArrayList<>(x.length);
        for (String s : x)
        {
            list.add(s);
        }
        return list;
    }

    /**
     * Gets the primary group for a player.
     * @param player The player who's primary group should be grabbed.
     * @return The primary group of the specified player.
     */
    public static String getPrimaryGroup(Player player)
    {
        return vault.getPermissions().getPrimaryGroup(player);
    }

    /**
     * Gets the primary group a player has for the specified world.
     * @param world The world where the player has the group.
     * @param player The player who's primary group should be grabbed for the specified world.
     * @return The primary group of the player specified for the specified world.
     */
    public static String getPrimaryGroup(String world, OfflinePlayer player)
    {
        return vault.getPermissions().getPrimaryGroup(world, player);
    }

    /**
     * Adds a permission to the specified group.
     * @param world The world to add the permission node to for the group.
     * @param group The group that will contain the permission node.
     * @param permission The permission node to add to the group and the world.
     * @return Returns true if the permission was successfully added to the group.
     */
    public static boolean addPermissionToGroup(String world, String group, String permission)
    {
        return vault.getPermissions().groupAdd(world, group, permission);
    }

    /**
     * Adds a permission to the specified group.
     * @param world The world to add the permission node to for the group.
     * @param group The group that will contain the permission node.
     * @param permission The permission node to add to the group and the world.
     * @return Returns true if the permission was successfully added to the group.
     */
    public static boolean addPermissionToGroup(World world, String group, String permission)
    {
        return vault.getPermissions().groupAdd(world, group, permission);
    }

    /**
     * Checks to see if the specified group has the specified permission node for the world.
     * @param world The world that contains the permission.
     * @param group The group that contains the permission.
     * @param permission The permission node to check.
     * @return Returns true if the node was found.
     */
    public static boolean groupHasPermission(String world, String group, String permission)
    {
        return vault.getPermissions().groupHas(world, group, permission);
    }

    /**
     * Checks to see if the specified group has the specified permission node for the world.
     * @param world The world that contains the permission.
     * @param group The group that contains the permission.
     * @param permission The permission node to check.
     * @return Returns true if the node was found.
     */
    public static boolean groupHasPermission(World world, String group, String permission)
    {
        return vault.getPermissions().groupHas(world, group, permission);
    }

    /**
     * Removes a permission form the specified group for the specific world.
     * @param world The world that contains the permission to remove.
     * @param group The group that contains the permission to remove.
     * @param permission The permission node to remove.
     * @return Returns true if the node was removed.
     */
    public static boolean removePermissionFromGroup(String world, String group, String permission)
    {
        return vault.getPermissions().groupRemove(world, group, permission);
    }

    /**
     * Removes a permission form the specified group for the specific world.
     * @param world The world that contains the permission to remove.
     * @param group The group that contains the permission to remove.
     * @param permission The permission node to remove.
     * @return Returns true if the node was removed.
     */
    public static boolean removePermissionFromGroup(World world, String group, String permission)
    {
        return vault.getPermissions().groupRemove(world, group, permission);
    }

    /**
     * Checks to see if the sender has the following permission.
     * @param sender The sender to check.
     * @param permission The permission to check.
     * @return Returns true if the sender has the permission.
     */
    public static boolean senderHasPermission(CommandSender sender, String permission)
    {
        return vault.getPermissions().has(sender, permission);
    }

    /**
     * Checks to see if the permissions system supports groups.
     * @return Returns true if the permission system supports groups.
     */
    public static boolean permissionSupportsGroups()
    {
        return vault.getPermissions().hasGroupSupport();
    }

    /**
     * Checks to see if the permission system is currently enabled.
     * @return Returns true if the permissions system is enabled.
     */
    public static boolean isEnabled()
    {
        return vault.getPermissions().isEnabled();
    }

    /**
     * Adds a permission node to the player.
     * @param player The player the permission relates to.
     * @param permission The permission the player has.
     * @return Returns true if the permission was added to the player.
     */
    public static boolean addPermissionToPlayerForCurrentWorld(Player player, String permission)
    {
        return vault.getPermissions().playerAdd(player, permission);
    }

    /**
     * Adds a permission node to the player.
     * @param world The world the permission relates to for the player.
     * @param player The player the permission relates to.
     * @param permission The permission the player has.
     * @return Returns true if the permission was added to the player.
     */
    public static boolean addPermissionToPlayer(String world, OfflinePlayer player, String permission)
    {
        return vault.getPermissions().playerAddTransient(world, player, permission);
    }

    /**
     * Adds a player to the specified group.
     * @param player The player to add to the group.
     * @param group The group to add the player to.
     * @return Returns true if the player was added to the group.
     */
    public static boolean addPlayerToGroup(Player player, String group)
    {
        return vault.getPermissions().playerAddGroup(player, group);
    }

    /**
     * Adds a player to a group for the specified world.
     * @param world The world where the player has the group.
     * @param player The player the group relates to.
     * @param group The group to add to the player for the specified world.
     * @return Returns true if the group was added to the player for the specified world.
     */
    public static boolean addPlayerToGroup(String world, OfflinePlayer player, String group)
    {
        return vault.getPermissions().playerAddGroup(world, player, group);
    }

    /**
     * Adds a temporary permission to the player.
     * @param player The player to add the permission to.
     * @param permission The permission.
     * @return Returns true if the permission was added to the player.
     */
    public static boolean addTransientPermissionToPlayer(OfflinePlayer player, String permission)
    {
        return vault.getPermissions().playerAddTransient(player, permission);
    }

    /**
     * Adds a temporary permission to the player.
     * @param player The player to add the permission to.
     * @param permission The permission.
     * @return Returns true if the permission was added to the player.
     */
    public static boolean addTransientPermissionToPlayer(Player player, String permission)
    {
        return vault.getPermissions().playerAddTransient(player, permission);
    }

    /**
     * Adds a temporary permission for the specified player.
     * @param worldname The world where the permission is allowed to be used.
     * @param player The player that's allowed to use the permission.
     * @param permission The permission to add.
     * @return Returns true if the permission was added to the player.
     */
    public static boolean addTransientPermissionToPlayer(String worldname, Player player, String permission)
    {
        return vault.getPermissions().playerAddTransient(worldname, player, permission);
    }

    /**
     * Adds a temporary permission for the specified player.
     * @param worldname The world where the permission is allowed to be used.
     * @param player The player that's allowed to use the permission.
     * @param permission The permission to add.
     * @return Returns true if the permission was added to the player.
     */
    public static boolean addTransientPermissionToPlayer(String worldname, OfflinePlayer player, String permission)
    {
        return vault.getPermissions().playerAddTransient(worldname, player, permission);
    }

    /**
     * Checks to see if the player has the specified permission.
     * @param player The player to check.
     * @param permission The permission to check for.
     * @return Returns true if the permission was found.
     */
    public static boolean playerHasPermission(Player player, String permission)
    {
        return vault.getPermissions().playerHas(player, permission);
    }

    /**
     * Checks to see if the player has the specified permission.
     * @param world The world where the player has the permission.
     * @param player The player that has the permission.
     * @param permission The permission.
     * @return Returns true if the player has the following permission in the specified world.
     */
    public static boolean playerHasPermission(String world, OfflinePlayer player, String permission)
    {
        return vault.getPermissions().playerHas(world, player, permission);
    }

    /**
     * Checks if the player is in the following group.
     * @param player The player to check.
     * @param group The group.
     * @return Returns true if the player is already in the specified group.
     */
    public static boolean playerIsInGroup(Player player, String group)
    {
        return vault.getPermissions().playerInGroup(player, group);
    }

    /**
     * Checks if the player is in the following group for the specified world.
     * @param world The world with the group.
     * @param player The player to check.
     * @param group The group to look for.
     * @return Returns true if the player has the specified group for the specified world.
     */
    public static boolean playerIsInGroup(String world, OfflinePlayer player, String group)
    {
        return vault.getPermissions().playerInGroup(world, player, group);
    }

    /**
     * Removes the specified permission from the player.
     * @param player The player that has the permission to remove.
     * @param permission The permission to remove.
     * @return Returns true if the permission was removed.
     */
    public static boolean removePermissionFromPlayer(Player player, String permission)
    {
        return vault.getPermissions().playerRemove(player, permission);
    }

    /**
     * Removes the specified permission from a player by a world where the player is allowed to use it.
     * @param world The world where the player is allowed to use the permission.
     * @param player The player with the specified permission.
     * @param permission The permission.
     * @return Returns true if the permission was removed from the player.
     */
    public static boolean removePermissionFromPlayer(String world, OfflinePlayer player, String permission)
    {
        return vault.getPermissions().playerRemove(world, player, permission);
    }

    /**
     * Removes a player from a group.
     * @param player The player in the group.
     * @param group The group to remove.
     * @return Returns true if the group was removed from the player.
     */
    public static boolean removePlayerFromGroup(Player player, String group)
    {
        return vault.getPermissions().playerRemoveGroup(player, group);
    }

    /**
     * Removes a group from a player in the specified world.
     * @param world The world where the player had the group.
     * @param player The player with the group.
     * @param group The group to remove.
     * @return Returns true if the group was removed from the player.
     */
    public static boolean removePlayerFromGroup(String world, OfflinePlayer player, String group)
    {
        return vault.getPermissions().playerRemoveGroup(world, player, group);
    }

    /**
     * Removes a temporary permission from a player.
     * @param player The player with the permission.
     * @param permission The permission to remove from the player.
     * @return Returns true if the permission was removed form the player.
     */
    public static boolean removeTransientPermissionFromPlayer(OfflinePlayer player, String permission)
    {
        return vault.getPermissions().playerRemoveTransient(player, permission);
    }

    /**
     * Removes a temporary permission from a player.
     * @param player The player with the permission.
     * @param permission The permission to remove from the player.
     * @return Returns true if the permission was removed form the player.
     */
    public static boolean removeTransiantPermissionFromPlayer(Player player, String permission)
    {
        return vault.getPermissions().playerRemoveTransient(player, permission);
    }

    /**
     * Removes a temporary permission from a player.
     * @param world The world where the player had the permission.
     * @param player The player with the pemission.
     * @param permission The permission to remove.
     * @return Returns true if the permission was removed from the player.
     */
    public static boolean removeTransiantPermissionFromPlayer(String world, OfflinePlayer player, String permission)
    {
        return vault.getPermissions().playerRemoveTransient(world, player, permission);
    }

    /**
     * Removes a temporary permission from a player.
     * @param world The world where the player had the permission.
     * @param player The player with the pemission.
     * @param permission The permission to remove.
     * @return Returns true if the permission was removed from the player.
     */
    public static boolean removeTransiantPermissionFromPlayer(String world, Player player, String permission)
    {
        return vault.getPermissions().playerRemoveTransient(world, player, permission);
    }
}
