package lib.winmister332.wmlib.spigot.library.recipes;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

/**
 * StaticCraftingItem Created By: WinMister332 On 12/5/2017 At 12:59 AM!
 * Copyright © WinMister332 2017!
 */
public final class StaticCraftingItem
{
    private ItemStack item = null;
    public StaticCraftingItem(final String displayName, final Material material)
    {
        this(displayName, null, material);
    }
    public StaticCraftingItem(final String displayName, final String[] lore, final Material material)
    {
        this(displayName, lore, 0, material);
    }
    public StaticCraftingItem(final String displayName, final String[] lore, final int durability, final Material material)
    {
        item = new ItemStack(material, durability);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(displayName);
        if (!(lore == null))
        {
            List<String> xLore = convertToList(lore);
            meta.setLore(xLore);
        }
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
    }

    public ItemStack GetItem()
    {
        return item;
    }

    private List<String> convertToList(String[] strArr)
    {
        List<String> s = new ArrayList<>(strArr.length);
        for (String sx : strArr)
        {
            s.add(sx);
        }
        return s;
    }
}
