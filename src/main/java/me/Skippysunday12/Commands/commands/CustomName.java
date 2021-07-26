package me.Skippysunday12.Commands.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Skippysunday12.Commands.backbone.PCommand;
import net.md_5.bungee.api.ChatColor;

public class CustomName extends PCommand implements CommandExecutor{

    public CustomName() {
        super(1, "stat.getnick");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(label.equalsIgnoreCase("getnick")) {

            boolean succeeded = false;
            succeeded = check(args, sender, "/getnick <player>", 0, false);

            if(!succeeded) return false;

            Player target = Bukkit.getPlayerExact(args[0]);

            sender.sendMessage(ChatColor.GOLD + args[0] + ChatColor.GREEN + " has the nickname of " + target.getDisplayName());
            return false;

        }

        return false;
    }

}
