package lib.winmister332.wmlib.spigot.library.bridge.vault;

import net.milkbowl.vault.permission.Permission;
import org.bukkit.World;

/**
 * VaultChatBridge Created By: WinMister332 On 1/17/2018 At 9:25 PM.
 * Copyright © WinMister332 2018!
 */
public class VaultChatBridge
{
    private static VaultLibrary vault = VaultLibrary.INSTANCE;
    private static VaultChatBridge INSTANCE = null;

    public boolean getGroupInfoAsBoolean(String world, String group, String node, boolean defaultValue)
    {
        return vault.getChat().getGroupInfoBoolean(world, group, node, defaultValue);
    }

    public boolean getGroupInfoAsBoolean(World world, String group, String node, boolean defaultValue)
    {
        return vault.getChat().getGroupInfoBoolean(world, group, node, defaultValue);
    }

    public double getGroupInfoAsDouble(String world, String group, String node, double defaultValue)
    {
        return vault.getChat().getGroupInfoDouble(world, group, node, defaultValue);
    }

    public double getGroupInfoAsDouble(World world, String group, String node, double defaultValue)
    {
    }
}
