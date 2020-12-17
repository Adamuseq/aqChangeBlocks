package com.adamuseq.aqchangeblocks.commands;

import com.adamuseq.aqchangeblocks.Main;
import com.adamuseq.aqchangeblocks.helpers.CommandHelper;
import com.adamuseq.aqchangeblocks.menus.BlockMenu;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BlockCommand extends CommandHelper {

    public BlockCommand(Main main) {
        super("bloki", false, "", "Wymiana surowcow na bloki", "/bloki ", new String[] {});
    }

    @Override
    public boolean exe(CommandSender cs, String p1, String[] p2) {
        final Player p = (Player) cs;
        BlockMenu.open(p);
        return false;    }
}
