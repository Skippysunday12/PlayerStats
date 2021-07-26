package me.Skippysunday12.Commands.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Skippysunday12.Commands.backbone.PCommand;
import net.md_5.bungee.api.ChatColor;

public class UUID extends PCommand implements CommandExecutor{

    public UUID() {
        super(1, "stat.uuid");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(label.equalsIgnoreCase("uuid")) {

            boolean succeeded = false;
            succeeded = check(args, sender, "/uuid <player>", 0, false);

            if(!succeeded) return false;

            Player target = Bukkit.getPlayerExact(args[0]);

            sender.sendMessage(ChatColor.GOLD + args[0] + "'s " + ChatColor.GREEN + "UUID is: " + target.getUniqueId());
            return false;
        }

        return false;
    }

}
