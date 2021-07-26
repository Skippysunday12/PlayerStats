package me.Skippysunday12.Commands.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Skippysunday12.Commands.backbone.PCommand;
import net.md_5.bungee.api.ChatColor;

public class XP extends PCommand implements CommandExecutor{

    public XP() {
        super(2, "stat.xp");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(label.equalsIgnoreCase("getXp")) {

            boolean succeeded = false;
            succeeded = check(args, sender, "/getxp <levels/total> <player>", 1, false);

            if(!succeeded) return false;

            Player target = Bukkit.getPlayerExact(args[1]);

            if(args[0].equalsIgnoreCase("total")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has a total of " + target.getTotalExperience() + " xp points");
                return false;
            }

            else if(args[0].equalsIgnoreCase("levels")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has " + target.getLevel() + " xp levels");
                return false;
            }

            else {
                sender.sendMessage(ChatColor.RED + "Usage: /getxp <levels/total> <player>");
                return false;
            }
        }

        return false;
    }

}
