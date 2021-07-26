package me.Skippysunday12.Commands.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Skippysunday12.Commands.backbone.PCommand;
import me.Skippysunday12.playerstats.PlayerStats;
import net.md_5.bungee.api.ChatColor;

public class GetPing extends PCommand implements CommandExecutor{

    public GetPing() {
        super(1, "stat.ping");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(label.equalsIgnoreCase("ping") || label.equalsIgnoreCase("pg")) {

            boolean succeeded = false;
            succeeded = check(args, sender, "/ping(or /pl) <player>", 0, false);

            if(!succeeded) return false;

            Player target = Bukkit.getPlayerExact(args[0]);

            sender.sendMessage(ChatColor.GOLD + args[0] + ChatColor.GREEN + " has a ping of " + PlayerStats.getPlayerPing(target) + ", the lower the better");
        }

        return false;
    }

}
