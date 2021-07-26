package me.Skippysunday12.Commands.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Skippysunday12.Commands.backbone.PCommand;
import net.md_5.bungee.api.ChatColor;

public class IsOp extends PCommand implements CommandExecutor{

    public IsOp() {
        super(1, "stat.isop");
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(label.equalsIgnoreCase("isop")) {

            boolean succeeded = false;
            succeeded = check(args, sender, "/isop <player>", 0, false);

            if(!succeeded) return false;

            Player target = Bukkit.getPlayerExact(args[0]);

            if(target.isOp()) {
                sender.sendMessage(ChatColor.GOLD + args[0] + ChatColor.GREEN + " is opped");
                return false;
            }

            else {
                sender.sendMessage(ChatColor.GOLD + args[0] + ChatColor.GREEN + " is not opped");
                return false;
            }
        }
        return false;
    }

}
