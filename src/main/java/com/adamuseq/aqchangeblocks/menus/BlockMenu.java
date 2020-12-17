package com.adamuseq.aqchangeblocks.menus;

import com.adamuseq.aqchangeblocks.utils.ChatUtils;
import com.adamuseq.aqchangeblocks.utils.ItemBuilder;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.UUID;

public class BlockMenu {

    public static ItemStack getCustomTextureHead(String value) {
        ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        SkullMeta meta = (SkullMeta) head.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), "");
        profile.getProperties().put("textures", new Property("textures", value));
        Field profileField = null;
        try {
            profileField = meta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(meta, profile);
        } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
            e.printStackTrace();
        }
        head.setItemMeta(meta);
        return head;
    }

    public static void open(final Player p) {
        final Inventory inv = Bukkit.createInventory((InventoryHolder)p, 27, ChatUtils.fixColors("&9Bloki &8(&fMENU&8)"));
        inv.setItem(11, new ItemBuilder(BlockMenu.getCustomTextureHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTdmNTdlN2FhOGRlODY1OTFiYjBiYzUyY2JhMzBhNDlkOTMxYmZhYmJkNDdiYmM4MGJkZDY2MjI1MTM5MjE2MSJ9fX0=")).setName(ChatUtils.fixColors("&6&lZłoto")).setLore("1", "2").toItemStack());
        inv.setItem(12, new ItemBuilder(BlockMenu.getCustomTextureHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTI2Yjc3MjMyOWNmMzJmODY0M2M0OTI4NjI2YjZhMzI1MjMzZmY2MWFhOWM3NzI1ODczYTRiZDY2ZGIzZDY5MiJ9fX0=")).setName(ChatUtils.fixColors("&f&lŻelazo")).setLore("1", "2").toItemStack());
        inv.setItem(13, new ItemBuilder(BlockMenu.getCustomTextureHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWYxMjFmN2MxYWIxNTY3ZmYyMTk4M2ZmN2E5ZTU1YzQwYzBiODY1ZjA1MGQzN2U1ZDM1ZGVmYmFhIn19fQ==")).setName(ChatUtils.fixColors("&2&lEmeraldy")).setLore("1", "2").toItemStack());
        inv.setItem(14, new ItemBuilder(BlockMenu.getCustomTextureHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTYzMTU5N2RjZTRlNDA1MWU4ZDVhNTQzNjQxOTY2YWI1NGZiZjI1YTBlZDYwNDdmMTFlNjE0MGQ4OGJmNDhmIn19fQ==")).setName(ChatUtils.fixColors("&b&lDiaxy")).setLore("1", "2").toItemStack());
        inv.setItem(15, new ItemBuilder(BlockMenu.getCustomTextureHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmI3OGZhNWRlZmU3MmRlYmNkOWM3NmFiOWY0ZTExNDI1MDQ3OWJiOWI0NGY0Mjg4N2JiZjZmNzM4NjEyYiJ9fX0=")).setName(ChatUtils.fixColors("&4&lRedstone")).setLore("1", "2").toItemStack());
        inv.setItem(22, new ItemBuilder((Material.HOPPER)).setName(ChatUtils.fixColors("&9&lWymień wszystko")).setLore("1", "2").toItemStack());
        inv.setItem(18, new ItemBuilder(BlockMenu.getCustomTextureHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmViNTg4YjIxYTZmOThhZDFmZjRlMDg1YzU1MmRjYjA1MGVmYzljYWI0MjdmNDYwNDhmMThmYzgwMzQ3NWY3In19fQ==")).setName(ChatUtils.fixColors("&9&lWyjście")).setLore("1", "2").toItemStack());
        final ItemStack wallpaper = new ItemBuilder(Material.STAINED_GLASS_PANE,1, (short)15).setName(ChatUtils.fixColors("&8*")).toItemStack();
        for (int i = 0; i < inv.getSize(); ++i) {
            if (inv.getItem(i) == null) {
                inv.setItem(i, wallpaper);
            }
        }
        p.openInventory(inv);
    }
}
