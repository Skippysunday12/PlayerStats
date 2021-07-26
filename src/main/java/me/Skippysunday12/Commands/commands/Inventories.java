package me.Skippysunday12.Commands.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Skippysunday12.Commands.backbone.PCommand;
import me.Skippysunday12.guimanagers.GuiSetup;
import me.Skippysunday12.guimanagers.Guimanager;
import net.md_5.bungee.api.ChatColor;

public class Inventories extends PCommand implements CommandExecutor{

    public Inventories(){
        super(2, "stat.inv");
    }

    private static GuiSetup GS = new GuiSetup();
    private static Guimanager guimanager = GS.getManager();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(label.equalsIgnoreCase("getInv")) {

            boolean succeeded = false;
            succeeded = check(args, sender, "getinv <echest/current> <player>", 1, true);

            if(!succeeded) return false;

            Player player = (Player) sender;

            if(args[0].equalsIgnoreCase("echest")) {
                guimanager.echest(args[1]);
                player.openInventory(guimanager.getEChest());
                return false;
            }

            if(args[0].equalsIgnoreCase("current")) {
                try {
                    guimanager.chest(args[1]);
                    player.openInventory(guimanager.getChest());
                }catch (Exception e) {
                    player.sendMessage(ChatColor.BLUE + "That player is not currently viewing an inventory");
                }
                return false;
            }
        }
        return false;
    }

}
