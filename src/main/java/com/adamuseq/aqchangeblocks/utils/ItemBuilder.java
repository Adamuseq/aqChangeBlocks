package com.adamuseq.aqchangeblocks.utils;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.material.MaterialData;

import java.util.Arrays;
import java.util.List;

public class ItemBuilder
{
    private final ItemStack is;

    public ItemBuilder(final Material m) {
        this(m, 1);
    }

    public ItemBuilder(final ItemStack is) {
        this.is = is;
    }

    public ItemBuilder(final Material m, final int amount) {
        this.is = new ItemStack(m, amount);
    }

    public ItemBuilder(final Material m, final int amount, final short data) {
        this.is = new ItemStack(m, amount, data);
    }

    public ItemBuilder(final Material m, final short data) {
        this.is = new ItemStack(m, (int)data);
    }

    public ItemBuilder setDurability(final short dur) {
        this.is.setDurability(dur);
        return this;
    }

    public ItemBuilder setName(final String name) {
        final ItemMeta im = this.is.getItemMeta();
        im.setDisplayName(name);
        this.is.setItemMeta(im);
        return this;
    }

    public ItemBuilder setMaterialData(final MaterialData data) {
        this.is.setData(data);
        return this;
    }

    public ItemBuilder addUnsafeEnchantment(final Enchantment ench) {
        this.is.addUnsafeEnchantment(ench, 5);
        return this;
    }

    public ItemBuilder removeEnchantment(final Enchantment ench) {
        this.is.removeEnchantment(ench);
        return this;
    }

    public ItemBuilder setSkullOwner(final String owner) {
        try {
            final SkullMeta im = (SkullMeta)this.is.getItemMeta();
            im.setOwner(owner);
            this.is.setItemMeta((ItemMeta)im);
        }
        catch (ClassCastException expected) {
            expected.printStackTrace();
        }
        return this;
    }

    public ItemBuilder addEnchant(final Enchantment ench, final int level) {
        final ItemMeta im = this.is.getItemMeta();
        im.addEnchant(ench, level, true);
        this.is.setItemMeta(im);
        return this;
    }

    public ItemBuilder setWoolColor(final DyeColor color) {
        if (!this.is.getType().equals((Object)Material.WOOL)) {
            return this;
        }
        this.is.setDurability((short)color.getData());
        return this;
    }

    public ItemBuilder setInfinityDurability() {
        this.is.setDurability((short)32767);
        return this;
    }

    public ItemBuilder setLore(final String... lore) {
        final ItemMeta im = this.is.getItemMeta();
        im.setLore((List) Arrays.asList(lore));
        this.is.setItemMeta(im);
        return this;
    }

    public ItemBuilder setLore(final List<String> lore) {
        final ItemMeta im = this.is.getItemMeta();
        im.setLore((List)lore);
        this.is.setItemMeta(im);
        return this;
    }

    public ItemStack toItemStack() {
        return this.is;
    }
}
