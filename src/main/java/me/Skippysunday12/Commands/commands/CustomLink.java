package me.Skippysunday12.Commands.commands;

import me.Skippysunday12.Commands.backbone.PCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class CustomLink extends PCommand implements CommandExecutor{

    public CustomLink(){
        super(2, "stat.link");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(label.equalsIgnoreCase("sendcustomlink") || label.equalsIgnoreCase("scl")) {

            boolean succeeded = false;
            succeeded = check(args, sender, "/sendcustomlink(or /scl) <link> <player>. Please use this responsibly, and if the link does not start with https:// or http:// then it will not work.", 1, false);

            if(!succeeded) return false;

            Player target = Bukkit.getPlayerExact(args[1]);


            target.sendMessage(ChatColor.GREEN + "You have been sent this custom link: " + ChatColor.AQUA + args[0]);

        }
        return false;
    }

}
