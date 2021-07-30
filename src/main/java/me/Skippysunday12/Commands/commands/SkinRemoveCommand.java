package me.Skippysunday12.Commands.commands;

import me.Skippysunday12.Commands.backbone.PCommand;
import me.Skippysunday12.NMS.SkinManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SkinRemoveCommand extends PCommand implements CommandExecutor {

    public SkinRemoveCommand() {
        super(0, "stat.getskin");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!label.equalsIgnoreCase("removeskins")) return false;

        if(!check(args, sender, "/removeskins", true)) return false;

        if(SkinManager.removeSkins((Player) sender)) sender.sendMessage(ChatColor.RED + "No skins currently spawned!");
        else sender.sendMessage(ChatColor.AQUA + "Skins successfully removed!");

        return true;
    }
}
