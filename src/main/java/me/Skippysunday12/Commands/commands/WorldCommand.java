package me.Skippysunday12.Commands.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Skippysunday12.Commands.backbone.PCommand;
import net.md_5.bungee.api.ChatColor;

public class WorldCommand extends PCommand implements CommandExecutor{

    public WorldCommand() {
        super(1, "stat.world");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(label.equalsIgnoreCase("getworld")) {
            if(!check(args, sender, "/getworld <player>", false)) return false;

            Player player = Bukkit.getPlayerExact(args[0]);

            sender.sendMessage(ChatColor.GOLD + args[0] + " " + ChatColor.GREEN + "is in world " + player.getWorld().getName());
        }

        return false;
    }

}
