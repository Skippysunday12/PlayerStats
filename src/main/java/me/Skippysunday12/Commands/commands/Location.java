package me.Skippysunday12.Commands.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Skippysunday12.Commands.backbone.PCommand;
import net.md_5.bungee.api.ChatColor;

public class Location extends PCommand implements CommandExecutor{

    public Location() {
        super(1, "stat.where");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(label.equalsIgnoreCase("where")) {

            boolean succeeded = false;
            succeeded = check(args, sender, "/where <player>", 0, false);

            if(!succeeded) return false;

            Player target = Bukkit.getPlayerExact(args[0]);

            double locy = target.getLocation().getY();
            double locx = target.getLocation().getX();
            double locz = target.getLocation().getZ();

            sender.sendMessage(ChatColor.GOLD + args[0] + ChatColor.WHITE + " is at:");
            sender.sendMessage(ChatColor.GREEN + "X: " + locx);
            sender.sendMessage(ChatColor.BLUE + "Y: " + locy);
            sender.sendMessage(ChatColor.DARK_PURPLE + "Z: " + locz);


        }
        return false;
    }

}
