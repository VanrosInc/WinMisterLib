package lib.winmister332.wmlib.spigot.library.recipes;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/**
 * DynamicCraftingItem Created By: WinMister332 On 12/5/2017 At 2:08 AM!
 * Copyright © WinMister332 2017!
 */
public final class DynamicCraftingItem
{
    private ItemStack item = null;

    public DynamicCraftingItem(Material material)
    {
        this(material, 0);
    }

    public DynamicCraftingItem(Material material, int durability)
    {
        item = new ItemStack(material, durability);
    }

    public ItemStack getItem()
    {
        return item;
    }
}
