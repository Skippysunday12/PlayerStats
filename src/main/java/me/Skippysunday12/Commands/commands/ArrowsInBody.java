package me.Skippysunday12.Commands.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Skippysunday12.Commands.backbone.PCommand;
import net.md_5.bungee.api.ChatColor;

public class ArrowsInBody extends PCommand implements CommandExecutor {

    public ArrowsInBody() {
        super(1, "stat.arrows");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(label.equalsIgnoreCase("arrowsinbody") || label.equalsIgnoreCase("aib")) {

            boolean succeeded = false;
            succeeded = check(args, sender, "/arrowsinbody <player>", 0, false);

            if(!succeeded) return false;

            Player target = Bukkit.getPlayerExact(args[0]);

            sender.sendMessage(ChatColor.GOLD + args[0] + ChatColor.GREEN + " has " + target.getArrowsInBody() + " in their body");
            return false;

        }
        return false;
    }

}
