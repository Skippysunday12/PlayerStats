package me.Skippysunday12.Commands.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.Skippysunday12.Commands.backbone.PCommand;
import net.md_5.bungee.api.ChatColor;

public class NameMCLink extends PCommand implements CommandExecutor{

    public NameMCLink() {
        super(1, "stat.mclink");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(label.equalsIgnoreCase("namemcpage") || label.equalsIgnoreCase("nmcl")) {

            boolean succeeded = false;
            succeeded = check(args, sender, "/namemcpage(or /nmcl) <player>", false);

            if(!succeeded) return false;

            sender.sendMessage(ChatColor.BLUE + "https://namemc.com/search?q=" + args[0]);


        }
        return false;
    }

}
