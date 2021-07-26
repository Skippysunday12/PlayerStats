package me.Skippysunday12.Commands.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Skippysunday12.Commands.backbone.PCommand;
import net.md_5.bungee.api.ChatColor;

public class Bed extends PCommand implements CommandExecutor{

    public Bed() {
        super(2, "stat.bed");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(label.equalsIgnoreCase("bed")) {

            boolean succeeded = false;
            succeeded = check(args, sender, "/bed <location/spawn> <player>", 1, false);

            if(!succeeded) return false;

            Player target = Bukkit.getPlayerExact(args[1]);

            if(args[0].equalsIgnoreCase("spawn")) {
                if(target.getBedSpawnLocation() == null) {
                    sender.sendMessage(ChatColor.AQUA + "That user does not have a bed");
                    return false;
                }

                double locx = target.getBedSpawnLocation().getX();
                double locy = target.getBedSpawnLocation().getY();
                double locz = target.getBedSpawnLocation().getZ();

                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.DARK_AQUA + " bedspawn is at:");
                sender.sendMessage(ChatColor.GREEN + "X: " + locx);
                sender.sendMessage(ChatColor.BLUE + "Y: " + locy);
                sender.sendMessage(ChatColor.DARK_PURPLE + "Z: " + locz);
            }

            else if(args[0].equalsIgnoreCase("location")) {
                if(!target.isSleeping()) {
                    sender.sendMessage(ChatColor.AQUA + "That player is not currently sleeping");
                    return false;
                }

                double locx = target.getBedLocation().getX();
                double locy = target.getBedLocation().getY();
                double locz = target.getBedLocation().getZ();

                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.DARK_AQUA + " is sleeping at:");
                sender.sendMessage(ChatColor.GREEN + "X: " + locx);
                sender.sendMessage(ChatColor.BLUE + "Y: " + locy);
                sender.sendMessage(ChatColor.DARK_PURPLE + "Z: " + locz);
            }

        }
        return false;
    }

}
