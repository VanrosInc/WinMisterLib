package lib.winmister332.wmlib.spigot.library.recipes;

import org.bukkit.Material;

/**
 * DynamicCraftingRecipe Created By: WinMister332 On 12/5/2017 At 2:11 AM!
 * Copyright © WinMister332 2017!
 */
public final class DynamicCraftingRecipe
{
    private int amount = 0;
    private Material material = Material.AIR;

    public DynamicCraftingRecipe(int amount, Material material)
    {
        this.amount = amount;
        this.material = material;
    }

    public int getAmount()
    {
        return amount;
    }

    public Material getMaterial()
    {
        return material;
    }
}
