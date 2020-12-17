package com.adamuseq.aqchangeblocks.helpers;

import com.adamuseq.aqchangeblocks.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public abstract class CommandHelper extends Command
{
    private String name;
    private String description;
    private String usage;
    private String permission;
    private List<String> aliases;
    private CommandMap cmap;
    private boolean player;

    public CommandHelper(final String name, final boolean player, final String permission, final String description, final String usage, final String... aliases) {
        super(name, description, usage, (List) Arrays.asList(aliases));
        this.name = name;
        this.description = description;
        this.usage = usage;
        this.permission = permission;
        this.aliases = Arrays.asList(aliases);
        this.player = player;
        this.register(this);
    }

    private void register(final Command command) {
        this.getCommandMap().register(command.getName(), command);
    }

    private CommandMap getCommandMap() {
        if (this.cmap == null) {
            try {
                final Field f = Bukkit.getServer().getClass().getDeclaredField("commandMap");
                f.setAccessible(true);
                this.cmap = (CommandMap)f.get(Bukkit.getServer());
                return this.getCommandMap();
            }
            catch (Exception e) {
                e.printStackTrace();
                return this.getCommandMap();
            }
        }
        return this.cmap;
    }

    public boolean execute(final CommandSender sender, final String command, final String[] args) {
        if (this.isPlayer() && !(sender instanceof Player)) {
            return ChatUtils.sendMessage(sender, "&4Blad: &cKomenda dostepna jest tylko w grze!");
        }
        if (!sender.hasPermission(this.getPermission())) {
            return ChatUtils.sendMessage(sender, "&4Blad: &cNie masz uprawnien! &7(" + this.getPermission() + ")");
        }
        return this.exe(sender, command, args);
    }

    public abstract boolean exe(final CommandSender p0, final String p1, final String[] p2);

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getUsage() {
        return "&8\u25b8 &7Poprawne uzycie: &a" + this.usage;
    }

    public String getPermission() {
        return this.permission;
    }

    public List<String> getAliases() {
        return this.aliases;
    }

    public boolean isPlayer() {
        return this.player;
    }

    public boolean setName(final String name) {
        this.name = name;
        return this.player;
    }

    public CommandHelper setDescription(final String description) {
        this.description = description;
        return this;
    }

    public CommandHelper setUsage(final String usage) {
        this.usage = usage;
        return this;
    }

    public void setPermission(final String permission) {
        this.permission = permission;
    }

    public CommandHelper setAliases(final List<String> aliases) {
        this.aliases = aliases;
        return this;
    }
}
