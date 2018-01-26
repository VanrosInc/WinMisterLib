package lib.winmister332.wmlib.spigot.library.recipes;

import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

/**
 * FlameRecipe Created By: WinMister332 On 1/7/2018 At 1:21 AM.
 * Copyright © WinMister332 2018!
 */
public class FlameRecipe
{
    private FurnaceRecipe recipe = null;
    public FlameRecipe(final DynamicCraftingItem item, final FlameCraftingRecipe recipe)
    {
        /*NamespacedKey key = new NamespacedKey(CraftingManager.INSTANCE.GetPlugin(), "wmlib_crafting_dynamic_item_" + TextUtil.convertToSafeString(item.getItem().getItemMeta().getLocalizedName()));
        this.recipe = new ShapelessRecipe(key, item.getItem());
        for (DynamicCraftingRecipe recipe : recipes)
        {
            this.recipe.addIngredient(recipe.getAmount(), recipe.getMaterial());
        }*/
        ItemStack result = item.getItem();
        MaterialData source = new MaterialData(recipe.getMaterial());
        float experience = recipe.getXp();

        this.recipe = new FurnaceRecipe(result, source, experience);
    }

    public FurnaceRecipe getRecipe()
    {
        return recipe;
    }
}
