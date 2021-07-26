package me.Skippysunday12.Commands.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Skippysunday12.Commands.backbone.PCommand;
import net.md_5.bungee.api.ChatColor;

public class Surface extends PCommand implements CommandExecutor{

    public Surface() {
        super(1, "stat.surface");
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(label.equalsIgnoreCase("surface")) {

            boolean succeeded = false;
            succeeded = check(args, sender, "/surface <player>", 0, false);

            if(!succeeded) return false;

            Player target = Bukkit.getPlayerExact(args[0]);

            if(target.isFlying()) {
                sender.sendMessage(ChatColor.GOLD + args[0] + ChatColor.AQUA + " is currently flying");
                return false;
            }

            else if(target.isOnGround()) {
                sender.sendMessage(ChatColor.GOLD + args[0] + ChatColor.DARK_GREEN + " is currently on the ground");

                if(target.isSprinting()) {
                    sender.sendMessage(ChatColor.GOLD + args[0] + ChatColor.DARK_GREEN + " is also currently sprinting!");
                }
                return false;
            }

            else if(target.isSwimming()) {
                sender.sendMessage(ChatColor.GOLD + args[0] + ChatColor.BLUE + "is currenyly swimming");
                return false;
            }

            else if(target.getFallDistance() > 0) {
                sender.sendMessage(ChatColor.GOLD + args[0] + ChatColor.DARK_BLUE + " is falling");
            }

            else {
                sender.sendMessage(ChatColor.GOLD + args[0] + ChatColor.WHITE + " is in a place that is currently being worked on. They are either being launched upward, or floating in water."
                        + " Please try again in a minute.");
                return false;
            }



        }

        return false;
    }

}
