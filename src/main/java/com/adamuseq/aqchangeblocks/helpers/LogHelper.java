package com.adamuseq.aqchangeblocks.helpers;

import org.bukkit.plugin.java.JavaPlugin;

public final class LogHelper {

    private JavaPlugin plugin;
    private String prefix;

    public LogHelper(JavaPlugin plugin){
        this.plugin = plugin;
        this.prefix = plugin.getName();
    }

    public void warn(String... strings) {
        for (String m : strings) {
            plugin.getServer().getConsoleSender().sendMessage("[ "+prefix+" - WARN ]: "+m);
        }
    }

    public void info(String... strings) {
        for (String m : strings) {
            plugin.getServer().getConsoleSender().sendMessage("[ "+prefix+" - INFO ]: "+m);
        }
    }

    public void debug(String... strings) {
        for (String m : strings) {
            plugin.getServer().getConsoleSender().sendMessage("[ "+prefix+" ]: "+m);
        }
    }
}
