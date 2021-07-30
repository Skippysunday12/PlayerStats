package me.Skippysunday12.Commands.commands;

import me.Skippysunday12.Commands.backbone.PCommand;
import me.Skippysunday12.NMS.SkinManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SkinCommand extends PCommand implements CommandExecutor {

    public SkinCommand() {
        super(1, "stat.getskin");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!label.equalsIgnoreCase("getskin")) return false;

        if(!check(args, sender, "/getskin <player>", true)) return false;

        SkinManager.spawnSkin(args[0], (Player) sender);

        return true;
    }
}
