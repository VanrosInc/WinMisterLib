package lib.winmister332.wmlib.spigot.library.recipes;

import lib.winmister332.wmlib.util.TextUtil;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.Plugin;

/**
 * StaticRecipe Created By: WinMister332 On 12/5/2017 At 12:56 AM!
 * Copyright © WinMister332 2017!
 */
public class StaticRecipe
{
    //Shaped Recipe.
    private ShapedRecipe recipe = null;
    public StaticRecipe(final StaticCraftingItem item, final StaticCraftingRecipe recipe)
    {
        String safeKey = (TextUtil.convertToSafeString(item.GetItem().getItemMeta().getDisplayName()));
        NamespacedKey key = new NamespacedKey(CraftingManager.INSTANCE.getPlugin(), "wmlib_crafting_static_item_" + safeKey);
        this.recipe = new ShapedRecipe(key, item.GetItem());
        this.recipe.shape(recipe.getShape());
        for (Character ing_c : recipe.getIngredients().getKeys())
        {
            for (Material ing_m : recipe.getIngredients().getValues())
            {
                this.recipe.setIngredient(ing_c, ing_m);
            }
        }
    }

    public ShapedRecipe getRecipe()
    {
        return recipe;
    }
}
