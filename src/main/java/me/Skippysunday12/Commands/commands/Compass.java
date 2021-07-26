package me.Skippysunday12.Commands.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Skippysunday12.Commands.backbone.PCommand;
import net.md_5.bungee.api.ChatColor;

public class Compass extends PCommand implements CommandExecutor{

    public Compass() {
        super(1, "stat.compass");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(label.equalsIgnoreCase("compass") || label.equalsIgnoreCase("cmp")) {

            boolean succeeded = false;
            succeeded = check(args, sender, "/compass <player>", 0, false);

            if(!succeeded) return false;

            Player target = Bukkit.getPlayerExact(args[0]);

            double locx = target.getCompassTarget().getX();
            double locy = target.getCompassTarget().getY();
            double locz = target.getCompassTarget().getZ();


            sender.sendMessage(ChatColor.GOLD + args[0] + "'s " + ChatColor.YELLOW + "compass is pointing to ");
            sender.sendMessage(ChatColor.GREEN + "X: " + locx);
            sender.sendMessage(ChatColor.BLUE + "Y: " + locy);
            sender.sendMessage(ChatColor.DARK_PURPLE + "Z: " + locz);

            return false;
        }

        return false;
    }

}
