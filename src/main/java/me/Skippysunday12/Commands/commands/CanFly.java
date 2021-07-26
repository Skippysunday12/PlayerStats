package me.Skippysunday12.Commands.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Skippysunday12.Commands.backbone.PCommand;
import net.md_5.bungee.api.ChatColor;

public class CanFly extends PCommand implements CommandExecutor {

    public CanFly() {
        super(1, "stat.canfly");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (label.equalsIgnoreCase("canFly")) {

            boolean succeeded = false;
            succeeded = check(args, sender, "/canfly <player>", 0, false);

            if(!succeeded) return false;

            String name = args[0];
            Player target = Bukkit.getPlayerExact(name);
            sender.sendMessage(ChatColor.GOLD + name + " flying currently set to " + ChatColor.GOLD + target.getAllowFlight());
        }

        return false;
    }

}