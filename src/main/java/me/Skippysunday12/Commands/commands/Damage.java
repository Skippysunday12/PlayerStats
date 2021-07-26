package me.Skippysunday12.Commands.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Skippysunday12.Commands.backbone.PCommand;
import net.md_5.bungee.api.ChatColor;

public class Damage extends PCommand implements CommandExecutor{

    public Damage() {
        super(1, "stat.damage");
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(label.equalsIgnoreCase("lastdamage")) {

            boolean succeeded = false;
            succeeded = check(args, sender, "/lastdamage <player>", 0, false);

            if(!succeeded) return false;

            Player target = Bukkit.getPlayerExact(args[0]);

            sender.sendMessage(ChatColor.GOLD + args[0] + ChatColor.GREEN + " last damage amount was " + target.getLastDamage());
            return false;
        }

        return false;
    }

}
