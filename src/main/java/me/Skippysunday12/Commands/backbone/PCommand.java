package me.Skippysunday12.Commands.backbone;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class PCommand {

    private int argCount;
    private String perm;

    public PCommand(int args, String permission) {
        argCount = args;
        perm = permission;
    }

    public boolean check(String[] args, CommandSender sender, String correctSyntax, boolean checkSender) {
        try {
            checkArgs(argCount, args, correctSyntax, sender);
        } catch(ArgumentException e) {return false;}

        if(checkSender)
            try {
                checkSender(sender);
            } catch (SenderTypeException e) {
                sender.sendMessage(ChatColor.RED + "Must be a player to run this command!");
                return false;
            }

        if(!checkPerms(sender)) return false;

        return true;
    }

    public boolean check(String[] args, CommandSender sender, String correctSyntax, int nameIndex, boolean checkSender) {

        try {
            checkArgs(argCount, args, correctSyntax, sender);
        } catch(ArgumentException e) {return false;}

        if(checkSender)
            try {
                checkSender(sender);
            } catch (SenderTypeException e) {
                return false;
            }

        try {
            checkOnline(args, nameIndex, sender);
        } catch(OnlinePlayerException e) {return false;}

        if(!checkPerms(sender)) return false;

        return true;
    }

    private boolean checkSender(CommandSender sender) throws SenderTypeException {

        if(!(sender instanceof Player)){
            throw new SenderTypeException("Sender is not player");
        }

        return true;
    }

    private boolean checkPerms(CommandSender sender) {

        if(!sender.hasPermission(perm)) return false;

        return true;
    }

    private boolean checkArgs(int length, String[] args, String correctSyntax, CommandSender sender) throws ArgumentException {
        if((argCount != args.length) || (args == null && argCount != 0)) {
            sender.sendMessage(ChatColor.RED + "Correct syntax: " + correctSyntax);
            throw new ArgumentException("Incorrect number of arguments");
        }
        return true;
    }

    private boolean checkOnline(String[] args, int nameIndex, CommandSender sender) throws OnlinePlayerException {
        String pname = null;
        try {pname = args[nameIndex];} catch(ArrayIndexOutOfBoundsException e) {}
        if(Bukkit.getPlayerExact(pname) == null) {
            sender.sendMessage(ChatColor.RED + pname + " is not online");
            throw new OnlinePlayerException(ChatColor.RED + pname + " is not online");
        }

        return true;
    }

}
