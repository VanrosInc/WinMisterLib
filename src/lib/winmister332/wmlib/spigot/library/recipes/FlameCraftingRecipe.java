package lib.winmister332.wmlib.spigot.library.recipes;

import org.bukkit.Material;

/**
 * FlameCraftingRecipe Created By: WinMister332 On 1/7/2018 At 1:24 AM.
 * Copyright © WinMister332 2018!
 */
public class FlameCraftingRecipe
{
    /*private int amount = 0;
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
    }*/

    private float xp = 0;
    private Material material = Material.AIR;

    public FlameCraftingRecipe(Material material)
    {
        this(material, 0);
    }

    public FlameCraftingRecipe(Material material, float xp)
    {
        this.material = material;
        this.xp = xp;
    }

    public float getXp()
    {
        return xp;
    }
    
    public Material getMaterial()
    {
        return material;
    }
}
