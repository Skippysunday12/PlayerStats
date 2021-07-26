package me.Skippysunday12.Commands.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Skippysunday12.Commands.backbone.PCommand;
import net.md_5.bungee.api.ChatColor;

public class Hand extends PCommand implements CommandExecutor{

    public Hand() {
        super(2, "stat.hand");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(label.equalsIgnoreCase("hand")) {

            boolean succeeded = false;
            succeeded = check(args, sender, "/hand <main/off> <player>", 1, false);

            if(!succeeded) return false;

            Player target = Bukkit.getPlayerExact(args[1]);

            if(args[0].equalsIgnoreCase("main")) {

                String before = "" + target.getInventory().getItemInOffHand();
                String after = before.substring(10);
                String afterafter = "";
                int length = (after.length()-1);

                if(after.charAt(length) == '}') {
                    afterafter = after.substring(0, ((length)));
                }
                else {
                    afterafter = after.substring(0);
                }

                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has " + afterafter.toLowerCase() + " in their main hand");
                return false;
            }

            else if(args[0].equalsIgnoreCase("off")) {

                String before = "" + target.getInventory().getItemInOffHand();
                String after = before.substring(10);
                String afterafter = "";
                int length = (after.length()-1);

                if(after.charAt(length) == '}') {
                    afterafter = after.substring(0, ((length)));
                }
                else {
                    afterafter = after.substring(0);
                }


                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has " + afterafter.toLowerCase() + " in their offhand");
                return false;
            }

            else {
                sender.sendMessage(ChatColor.RED + "Usage: /hand <main/off> <player>");
            }
        }
        return false;
    }

}
