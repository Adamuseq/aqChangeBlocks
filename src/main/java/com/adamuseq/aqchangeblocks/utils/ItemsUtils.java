package com.adamuseq.aqchangeblocks.utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemsUtils
{
    public static boolean checkItems(final List<ItemStack> items, final Player p) {
        for (final ItemStack item : items) {
            if (!p.getInventory().containsAtLeast(item, item.getAmount())) {
                return false;
            }
        }
        return true;
    }

    public static void removeItems(final List<ItemStack> items, final Player player) {
        final Inventory inv = (Inventory)player.getInventory();
        final List<ItemStack> removes = new ArrayList<ItemStack>();
        for (final ItemStack item : items) {
            if (inv.containsAtLeast(item, item.getAmount())) {
                removes.add(item);
            }
        }
        if (removes.size() == items.size()) {
            for (final ItemStack item : items) {
                for (final ItemStack remove : removes) {
                    if (item.getType().equals((Object)remove.getType()) && item.getData().equals((Object)remove.getData())) {
                        inv.removeItem(new ItemStack[] { item });
                    }
                }
            }
        }
        removes.clear();
    }

    public static boolean checkAndRemove(final List<ItemStack> items, final Player player) {
        final boolean has = checkItems(items, player);
        if (has) {
            removeItems(items, player);
        }
        return has;
    }

    public static int getAmountOfItem(final Material material, final Player player, final short durability) {
        int amount = 0;
        ItemStack[] contents;
        for (int length = (contents = player.getInventory().getContents()).length, i = 0; i < length; ++i) {
            final ItemStack itemStack = contents[i];
            if (itemStack != null && itemStack.getType().equals((Object)material) && itemStack.getDurability() == durability) {
                amount += itemStack.getAmount();
            }
        }
        return amount;
    }

    public static ItemStack getPlayerHead(final String name) {
        final ItemStack itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        final SkullMeta meta = (SkullMeta)itemStack.getItemMeta();
        meta.setOwner(name);
        meta.setDisplayName(name);
        itemStack.setItemMeta((ItemMeta)meta);
        return itemStack;
    }

    public static void recalculateDurability(final Player player, final ItemStack item) {
        if (item.getType().getMaxDurability() == 0) {
            return;
        }
        final int enchantLevel = item.getEnchantmentLevel(Enchantment.DURABILITY);
        final short d = item.getDurability();
        if (enchantLevel > 0) {
            if (100 / (enchantLevel + 1) > RandomUtils.getRandInt(0, 100)) {
                if (d == item.getType().getMaxDurability()) {
                    player.getInventory().clear(player.getInventory().getHeldItemSlot());
                    player.playSound(player.getLocation(), Sound.ITEM_BREAK, 1.0f, 1.0f);
                }
                else {
                    item.setDurability((short)(d + 1));
                }
            }
        }
        else if (d == item.getType().getMaxDurability()) {
            player.getInventory().clear(player.getInventory().getHeldItemSlot());
            player.playSound(player.getLocation(), Sound.ITEM_BREAK, 1.0f, 1.0f);
        }
        else {
            item.setDurability((short)(d + 1));
        }
    }

    public static void giveOrDrop(final Player p, final ItemStack is) {
        for (final ItemStack item : p.getInventory().addItem(new ItemStack[] { is }).values()) {
            p.getWorld().dropItemNaturally(p.getLocation(), item);
        }
    }

    public static void remove(final ItemStack is, final Player player, final int amount) {
        int removed = 0;
        boolean all = false;
        final List<ItemStack> toRemove = new ArrayList<ItemStack>();
        final ItemStack[] contents = player.getInventory().getContents();
        for (int i = 0; i < contents.length; ++i) {
            final ItemStack item = contents[i];
            if (item != null && !item.getType().equals((Object)Material.AIR) && item.getType().equals((Object)is.getType()) && item.getDurability() == is.getDurability() && !all && removed != amount) {
                if (item.getAmount() == amount) {
                    if (removed == 0) {
                        toRemove.add(item.clone());
                        all = true;
                        removed = item.getAmount();
                    }
                    else {
                        final int a = amount - removed;
                        final ItemStack s = item.clone();
                        s.setAmount(a);
                        toRemove.add(s);
                        removed += a;
                        all = true;
                    }
                }
                else if (item.getAmount() > amount) {
                    if (removed == 0) {
                        final ItemStack s2 = item.clone();
                        s2.setAmount(amount);
                        toRemove.add(s2);
                        all = true;
                        removed = amount;
                    }
                    else {
                        final int a = amount - removed;
                        final ItemStack s = item.clone();
                        s.setAmount(a);
                        toRemove.add(s);
                        removed += a;
                        all = true;
                    }
                }
                else if (item.getAmount() < amount) {
                    if (removed == 0) {
                        toRemove.add(item.clone());
                        removed = item.getAmount();
                    }
                    else {
                        final int a = amount - removed;
                        if (a == item.getAmount()) {
                            toRemove.add(item.clone());
                            removed += item.getAmount();
                            all = true;
                        }
                        else if (item.getAmount() > a) {
                            final ItemStack s = item.clone();
                            s.setAmount(a);
                            toRemove.add(s);
                            removed += a;
                            all = true;
                        }
                        else if (item.getAmount() < a) {
                            toRemove.add(item.clone());
                            removed += item.getAmount();
                        }
                    }
                }
            }
        }
        removeItem(player, toRemove);
    }

    public static void removeItem(final Player player, final List<ItemStack> items) {
        if (player == null || items == null || items.isEmpty()) {
            return;
        }
        for (final ItemStack is : items) {
            player.getInventory().removeItem(new ItemStack[] { is });
        }
    }

    public static void giveItem(final Player player, final List<ItemStack> items, Location location) {
        final PlayerInventory inv = player.getInventory();
        final HashMap<Integer, ItemStack> notStored = (HashMap<Integer, ItemStack>)inv.addItem((ItemStack[])items.toArray(new ItemStack[items.size()]));
        for (final Map.Entry<Integer, ItemStack> en : notStored.entrySet()) {
            if (en.getValue() != null) {
                if (en.getValue().getType().equals((Object)Material.AIR)) {
                    continue;
                }
                player.getLocation().getWorld().dropItemNaturally(player.getLocation(), (ItemStack)en.getValue());
            }
        }
    }

    public static void giveItems(final Player p, final ItemStack... items) {
        final Inventory i = (Inventory)p.getInventory();
        final HashMap<Integer, ItemStack> notStored = (HashMap<Integer, ItemStack>)i.addItem(items);
        for (final Map.Entry<Integer, ItemStack> e : notStored.entrySet()) {
            p.getWorld().dropItemNaturally(p.getLocation(), (ItemStack)e.getValue());
        }
    }
}
