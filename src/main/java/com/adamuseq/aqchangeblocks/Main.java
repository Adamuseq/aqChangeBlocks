package com.adamuseq.aqchangeblocks;

import com.adamuseq.aqchangeblocks.commands.BlockCommand;
import com.adamuseq.aqchangeblocks.helpers.LogHelper;
import com.adamuseq.aqchangeblocks.listeners.ChangeBlockListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private LogHelper logHelper;


    @Override
    public void onLoad(){
        this.logHelper = new LogHelper(this);
    }

    @Override
    public void onEnable(){
        this.initialize();
    }


    private void initialize(){
        final long start = System.currentTimeMillis();
        logHelper.info("Inicjacja pluginu aqChangeBlocks...");

        new BlockCommand(this);

        new ChangeBlockListener(this);

        logHelper.info("Zaladowano plugin aqChangeBlocks w "+(System.currentTimeMillis()-start)+"ms");
    }


    public static Main getPlugin(){
        return Main.getPlugin(Main.class);
    }

    public LogHelper getLogHelper(){
        return logHelper;
    }


}
