package com.adamuseq.aqchangeblocks.listeners;

import com.adamuseq.aqchangeblocks.Main;
import com.adamuseq.aqchangeblocks.utils.ChatUtils;
import com.adamuseq.aqchangeblocks.utils.ItemsUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public class ChangeBlockListener implements Listener {

    private Main main;


    public ChangeBlockListener(Main main){
        this.main = main;
        Bukkit.getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    public void blocks(final InventoryClickEvent e) {
        if (!e.getInventory().getTitle().equalsIgnoreCase(ChatUtils.fixColors("&9Bloki &8(&fMENU&8)"))) {
            return;
        }
        final ItemStack is = e.getCurrentItem();
        if (is != null) {
            final Player p = (Player) e.getWhoClicked();
            e.setCancelled(true);
            final String itemName = ChatUtils.fixColors(e.getCurrentItem().getItemMeta().getDisplayName());
            if (itemName.equalsIgnoreCase(ChatUtils.fixColors("&9&lWyjście"))) {
                p.closeInventory();
            }
            if (ItemsUtils.getAmountOfItem(Material.GOLD_INGOT, p, (short)0) >= 9 || ItemsUtils.getAmountOfItem(Material.IRON_INGOT, p, (short)0) >= 9 || ItemsUtils.getAmountOfItem(Material.EMERALD, p, (short)0) >= 9 || ItemsUtils.getAmountOfItem(Material.DIAMOND, p, (short)0) >= 9 || ItemsUtils.getAmountOfItem(Material.REDSTONE, p, (short)0) >= 9) {
                if (itemName.equalsIgnoreCase(ChatUtils.fixColors("&6&lZłoto"))) {
                    if (ItemsUtils.getAmountOfItem(Material.GOLD_INGOT, p, (short)0) >= 9) {
                        while (ItemsUtils.getAmountOfItem(Material.GOLD_INGOT, p, (short)0) >= 9) {
                            ItemsUtils.remove(new ItemStack(Material.GOLD_INGOT), p, 9);
                            ItemsUtils.giveItem(p, (List) Arrays.asList(new ItemStack(Material.GOLD_BLOCK)), p.getLocation());
                        }
                        ChatUtils.sendMessage((CommandSender)p, "&aWymieniono przedmioty!");
                    }
                    else {
                        ChatUtils.sendMessage((CommandSender)p, "&cNie posiadasz przedmiotow do wymiany!");
                    }
                }
                if (itemName.equalsIgnoreCase(ChatUtils.fixColors("&f&lŻelazo"))) {
                    if (ItemsUtils.getAmountOfItem(Material.IRON_INGOT, p, (short)0) >= 9) {
                        while (ItemsUtils.getAmountOfItem(Material.IRON_INGOT, p, (short)0) >= 9) {
                            ItemsUtils.remove(new ItemStack(Material.IRON_INGOT), p, 9);
                            ItemsUtils.giveItem(p, (List) Arrays.asList(new ItemStack(Material.IRON_BLOCK)), p.getLocation());
                        }
                        ChatUtils.sendMessage((CommandSender)p, "&aWymieniono przedmioty!");
                    }
                    else {
                        ChatUtils.sendMessage((CommandSender)p, "&cNie posiadasz przedmiotow do wymiany!");
                    }
                }
                if (itemName.equalsIgnoreCase(ChatUtils.fixColors("&2&lEmeraldy"))) {
                    if (ItemsUtils.getAmountOfItem(Material.EMERALD, p, (short)0) >= 9) {
                        while (ItemsUtils.getAmountOfItem(Material.EMERALD, p, (short)0) >= 9) {
                            ItemsUtils.remove(new ItemStack(Material.EMERALD), p, 9);
                            ItemsUtils.giveItem(p, (List) Arrays.asList(new ItemStack(Material.EMERALD_BLOCK)), p.getLocation());
                        }
                        ChatUtils.sendMessage((CommandSender)p, "&aWymieniono przedmioty!");
                    }
                    else {
                        ChatUtils.sendMessage((CommandSender)p, "&cNie posiadasz przedmiotow do wymiany!");
                    }
                }
                if (itemName.equalsIgnoreCase(ChatUtils.fixColors("&b&lDiaxy"))) {
                    if (ItemsUtils.getAmountOfItem(Material.DIAMOND, p, (short)0) >= 9) {
                        while (ItemsUtils.getAmountOfItem(Material.DIAMOND, p, (short)0) >= 9) {
                            ItemsUtils.remove(new ItemStack(Material.DIAMOND), p, 9);
                            ItemsUtils.giveItem(p, (List) Arrays.asList(new ItemStack(Material.DIAMOND_BLOCK)), p.getLocation());
                        }
                        ChatUtils.sendMessage((CommandSender)p, "&aWymieniono przedmioty!");
                    }
                    else {
                        ChatUtils.sendMessage((CommandSender)p, "&cNie posiadasz przedmiotow do wymiany!");
                    }
                }
                if (itemName.equalsIgnoreCase(ChatUtils.fixColors("&4&lRedstone"))) {
                    if (ItemsUtils.getAmountOfItem(Material.REDSTONE, p, (short)0) >= 9) {
                        while (ItemsUtils.getAmountOfItem(Material.REDSTONE, p, (short)0) >= 9) {
                            ItemsUtils.remove(new ItemStack(Material.REDSTONE), p, 9);
                            ItemsUtils.giveItem(p, (List) Arrays.asList(new ItemStack(Material.REDSTONE_BLOCK)), p.getLocation());
                        }
                        ChatUtils.sendMessage((CommandSender)p, "&aWymieniono przedmioty!");
                    }
                    else {
                        ChatUtils.sendMessage((CommandSender)p, "&cNie posiadasz przedmiotow do wymiany!");
                    }
                }
                if (itemName.equalsIgnoreCase(ChatUtils.fixColors("&9&lWymień wszystko"))) {
                    if (ItemsUtils.getAmountOfItem(Material.REDSTONE, p, (short)0) >= 9) {
                        while (ItemsUtils.getAmountOfItem(Material.REDSTONE, p, (short)0) >= 9) {
                            ItemsUtils.remove(new ItemStack(Material.REDSTONE), p, 9);
                            ItemsUtils.giveItem(p, (List) Arrays.asList(new ItemStack(Material.REDSTONE_BLOCK)), p.getLocation());
                        }
                        ChatUtils.sendMessage((CommandSender)p, "&aWymieniono przedmioty!");
                    }
                    if (ItemsUtils.getAmountOfItem(Material.REDSTONE, p, (short)0) >= 9) {
                        while (ItemsUtils.getAmountOfItem(Material.REDSTONE, p, (short)0) >= 9) {
                            ItemsUtils.remove(new ItemStack(Material.REDSTONE), p, 9);
                            ItemsUtils.giveItem(p, (List) Arrays.asList(new ItemStack(Material.REDSTONE_BLOCK)), p.getLocation());
                        }
                        ChatUtils.sendMessage((CommandSender)p, "&aWymieniono przedmioty!");
                    }
                    if (ItemsUtils.getAmountOfItem(Material.DIAMOND, p, (short)0) >= 9) {
                        while (ItemsUtils.getAmountOfItem(Material.DIAMOND, p, (short)0) >= 9) {
                            ItemsUtils.remove(new ItemStack(Material.DIAMOND), p, 9);
                            ItemsUtils.giveItem(p, (List) Arrays.asList(new ItemStack(Material.DIAMOND_BLOCK)), p.getLocation());
                        }
                        ChatUtils.sendMessage((CommandSender)p, "&aWymieniono przedmioty!");
                    }
                    if (ItemsUtils.getAmountOfItem(Material.EMERALD, p, (short)0) >= 9) {
                        while (ItemsUtils.getAmountOfItem(Material.EMERALD, p, (short)0) >= 9) {
                            ItemsUtils.remove(new ItemStack(Material.EMERALD), p, 9);
                            ItemsUtils.giveItem(p, (List) Arrays.asList(new ItemStack(Material.EMERALD_BLOCK)), p.getLocation());
                        }
                        ChatUtils.sendMessage((CommandSender)p, "&aWymieniono przedmioty!");
                    }
                    if (ItemsUtils.getAmountOfItem(Material.IRON_INGOT, p, (short)0) >= 9) {
                        while (ItemsUtils.getAmountOfItem(Material.IRON_INGOT, p, (short)0) >= 9) {
                            ItemsUtils.remove(new ItemStack(Material.IRON_INGOT), p, 9);
                            ItemsUtils.giveItem(p, (List) Arrays.asList(new ItemStack(Material.IRON_BLOCK)), p.getLocation());
                        }
                        ChatUtils.sendMessage((CommandSender)p, "&aWymieniono przedmioty!");
                    }
                    if (ItemsUtils.getAmountOfItem(Material.GOLD_INGOT, p, (short)0) >= 9) {
                        while (ItemsUtils.getAmountOfItem(Material.GOLD_INGOT, p, (short)0) >= 9) {
                            ItemsUtils.remove(new ItemStack(Material.GOLD_INGOT), p, 9);
                            ItemsUtils.giveItem(p, (List) Arrays.asList(new ItemStack(Material.GOLD_BLOCK)), p.getLocation());
                        }
                        ChatUtils.sendMessage((CommandSender)p, "&aWymieniono przedmioty!");
                    }
                }
            }
            else {
                ChatUtils.sendMessage((CommandSender)p, "&cNie posiadasz przedmiotow do wymiany!");
            }
        }
    }
}
