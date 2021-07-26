package me.Skippysunday12.Commands.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Skippysunday12.Commands.backbone.PCommand;
import me.Skippysunday12.playerstats.PlayerStats;
import net.md_5.bungee.api.ChatColor;

public class Get extends PCommand implements CommandExecutor{

    public Get() {
        super(2, "stat.get");
    }

    public boolean isOnline(String p) {
        return PlayerStats.isOnline(p);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(label.equalsIgnoreCase("get")) {

            boolean succeeded = false;
            succeeded = check(args, sender, "/get <hunger/health/gamemode> <player>", 1, false);

            if(!succeeded) return false;

            Player target = Bukkit.getPlayerExact(args[1]);

            if(args[0].equalsIgnoreCase("health")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + "'s " + ChatColor.RED + "health " + ChatColor.BLUE +
                        "is " + target.getHealth());
                return false;
            }

            else if(args[0].equalsIgnoreCase("hunger")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + "'s " + ChatColor.DARK_GREEN + "hunger level " + ChatColor.BLUE +
                        "is " + target.getFoodLevel());
                return false;
            }

            else if(args[0].equalsIgnoreCase("gamemode")) {
                String mode = "" + target.getGameMode();
                sender.sendMessage(ChatColor.GOLD + args[1] + "'s " + ChatColor.GREEN + "gamemode is " + mode.toLowerCase());
                return false;
            }

            else {
                sender.sendMessage(ChatColor.RED + "Usage: /get <hunger/health/gamemode> <player>");
                return false;
            }


        }
        return false;
    }

}
