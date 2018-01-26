package lib.winmister332.wmlib.spigot.library.recipes;

import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

/**
 * CraftingManager Created By: WinMister332 On 12/5/2017 At 12:53 AM!
 * Copyright © WinMister332 2017!
 */
public class CraftingManager
{
    private Plugin plugin = null;
    public static CraftingManager INSTANCE = null;

    public CraftingManager(final Plugin plugin)
    {
        INSTANCE = this;
        this.plugin = plugin;
    }

    public void addStaticRecipe(StaticRecipe recipe)
    {
        plugin.getServer().addRecipe(recipe.getRecipe());
    }

    public void addDynamicRecipe(DynamicRecipe recipe)
    {
        plugin.getServer().addRecipe(recipe.getRecipe());
    }

    public void addFlameRecipe(FlameRecipe recipe)
    {
        plugin.getServer().addRecipe(recipe.getRecipe());
    }

    Plugin getPlugin()
    {
        return plugin;
    }
}
