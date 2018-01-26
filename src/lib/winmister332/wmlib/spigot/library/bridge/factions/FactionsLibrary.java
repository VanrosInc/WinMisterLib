package lib.winmister332.wmlib.spigot.library.bridge.factions;

import com.massivecraft.factions.Factions;
import com.massivecraft.factions.entity.Faction;
import com.massivecraft.factions.entity.FactionColl;
import com.massivecraft.factions.entity.MPlayer;
import lib.winmister332.wmlib.spigot.library.logger.Logger;
import lib.winmister332.wmlib.spigot.main.WMPlugin;
import org.bukkit.OfflinePlayer;

import java.util.UUID;

/**
 * FactionsLibrary Created By: WinMister332 On 12/3/2017 At 1:40 PM!
 * Copyright © WinMister332 2017!
 */
public class FactionsLibrary
{
    public static FactionsLibrary INSTANCE = null;
    public Factions factions = null;
    public boolean usingFactions = false;

    public FactionsLibrary()
    {
        if (!(setupFactions()))
        {
            WMPlugin.INSTANCE.getWMLogger().Log(Logger.LogStatus.WARNING, "\"MCore Factions\" dependency is not found, loading AdvancedSlaves without MCore Factions configuration.");
            usingFactions = false;
            return;
        }
        usingFactions = true;
        INSTANCE = this;
    }

    private boolean setupFactions()
    {
        if (WMPlugin.INSTANCE.getServer().getPluginManager().getPlugin("Factions") == null) return false;
        factions = (Factions) WMPlugin.INSTANCE.getServer().getPluginManager().getPlugin("Factions");
        return factions != null;
    }

    /**
     * Gets the MCore player based on the UUID of the player.
     * @param uuid - The UUID of the player.
     * @return Gets the MCore player.
     */
    public MPlayer getPlayer(UUID uuid)
    {
        MPlayer player = null;
        player = MPlayer.get(uuid);
        return player;
    }

    /**
     * Gets the MCore player based on the OfflinePlayer.
     * @param plr - The OfflinePlayer.
     * @return Gets the MCore player.
     */
    public MPlayer getPlayer(OfflinePlayer plr)
    {
        MPlayer player = null;
        player = MPlayer.get(plr);
        return player;
    }

    /**
     * Gets the faction of the MCore player.
     * @param player - The player of the faction to look for.
     * @return Tbe faction of the specified player.
     */
    public Faction getFaction(MPlayer player)
    {
        return player.getFaction();
    }

    /**
     * Gets the faction of the OfflinePlayer.
     * @param plr - The player of the faction to look for.
     * @return Tbe faction of the specified player.
     */
    public Faction getFaction(OfflinePlayer plr)
    {
        return getPlayer(plr).getFaction();
    }

    /**
     * Gets the power of the specified faction.
     * @param faction - The faction that contains the power wanted.
     * @return The power of the specified faction.
     */
    public double getFactionPower(Faction faction)
    {
        return faction.getPower();
    }

    /**
     * Gets the power of the specified faction.
     * @param player - The player that has a faction.
     * @return The power of the specified faction.
     */
    public double getFactionPower(MPlayer player)
    {
        return getFaction(player).getPower();
    }

    /**
     * Gets the power of the specified faction.
     * @param plr - OfflinePlayer that has a faction.
     * @return The power of the specified faction.
     */
    public double getFactionPower(OfflinePlayer plr)
    {
        return getFaction(plr).getPower();
    }

    /**
     * Gets the wilderness as a faction.
     * @return The wilderness.
     */
    public static Faction NoFaction()
    {
        Faction faction = null;
        faction = FactionColl.get().getNone();
        return faction;
    }

    /**
     * Gets the safezone of the wilderness usually used as the server spawn.
     * @return The spawn or safezone of the wilderness.
     */
    public static Faction GetSafesone()
    {
        Faction faction = null;
        faction = FactionColl.get().getSafezone();
        return faction;
    }

    /**
     * Gets the warzone of the wilderness.
     * @return The warzone of the wilderness.
     */
    public static Faction GetWarzone()
    {
        Faction faction = null;
        faction = FactionColl.get().getWarzone();
        return faction;
    }

    /**
     * Checks to see if the plugin was found by the initializer and being used currently by the plugin.
     * @return Is Factions loaded by the server and is usable.
     */
    public boolean FactionsEnabled()
    {
        if (usingFactions == true && WMPlugin.INSTANCE.getServer().getPluginManager().isPluginEnabled("Factions") == true) return true;
        return false;
    }
}
