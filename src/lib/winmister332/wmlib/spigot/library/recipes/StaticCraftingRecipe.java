package lib.winmister332.wmlib.spigot.library.recipes;

import lib.winmister332.wmlib.util.Dictionary;
import org.bukkit.Material;

/**
 * StaticCraftingRecipe Created By: WinMister332 On 12/5/2017 At 1:18 AM!
 * Copyright © WinMister332 2017!
 */
public final class StaticCraftingRecipe
{
    private String[] shapex = null;
    private Dictionary<Character, Material> dictionary = new Dictionary<>();
    public StaticCraftingRecipe(String[] shape, RecipeIngredients[] ingredients)
    {
        shapex = shape;
        for (RecipeIngredients ingredient : ingredients)
        {
            dictionary.add(ingredient.key, ingredient.getMaterial());
        }
    }

    public String[] getShape()
    {
        return shapex;
    }

    public Dictionary<Character, Material> getIngredients()
    {
        return dictionary;
    }

    public static final class RecipeIngredients
    {
        Character key = 'X';
        Material material = Material.AIR;
        public RecipeIngredients(Character key, Material material)
        {
            this.key = key;
            this.material = material;
        }

        public Character getKey()
        {
            return key;
        }

        public Material getMaterial()
        {
            return material;
        }
    }
}
