package lib.winmister332.wmlib.spigot.library.recipes;

import lib.winmister332.wmlib.util.TextUtil;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapelessRecipe;

/**
 * DynamicRecipe Created By: WinMister332 On 12/5/2017 At 2:04 AM!
 * Copyright © WinMister332 2017!
 */
public final class DynamicRecipe
{
    private ShapelessRecipe recipe = null;
    public DynamicRecipe(final DynamicCraftingItem item, final DynamicCraftingRecipe[] recipes)
    {
        NamespacedKey key = new NamespacedKey(CraftingManager.INSTANCE.getPlugin(), "wmlib_crafting_dynamic_item_" + TextUtil.convertToSafeString(item.getItem().getItemMeta().getLocalizedName()));
        this.recipe = new ShapelessRecipe(key, item.getItem());
        for (DynamicCraftingRecipe recipe : recipes)
        {
            this.recipe.addIngredient(recipe.getAmount(), recipe.getMaterial());
        }
    }

    public ShapelessRecipe getRecipe()
    {
        return recipe;
    }

}
