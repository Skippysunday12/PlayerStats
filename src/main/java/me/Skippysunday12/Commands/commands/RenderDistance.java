package me.Skippysunday12.Commands.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Skippysunday12.Commands.backbone.PCommand;
import net.md_5.bungee.api.ChatColor;

public class RenderDistance extends PCommand implements CommandExecutor{

    public RenderDistance() {
        super(1, "stat.view");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(label.equalsIgnoreCase("viewdistance") || label.equalsIgnoreCase("vd")) {

            boolean succeeded = false;
            succeeded = check(args, sender, "/viewdistance(or /vd) <player>", 0, false);

            if(!succeeded) return false;

            Player target = Bukkit.getPlayerExact(args[0]);

            sender.sendMessage(ChatColor.GOLD + args[0] + ChatColor.GREEN + " can see " + target.getClientViewDistance() + " chunks");
            return false;
        }

        return false;
    }

}
