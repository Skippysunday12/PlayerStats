package me.Skippysunday12.Commands.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class GetCompleter implements TabCompleter{

    List<String> arguments = new ArrayList<String>();

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {

        if(arguments.isEmpty()) {
            arguments.add("health");
            arguments.add("hunger");
            arguments.add("gamemode");
        }

        List<String> result = new ArrayList<String>();

        if(args.length == 1) {
            for (String a : arguments) {
                if(a.toLowerCase().startsWith(args[0].toLowerCase())) {
                    result.add(a);
                }

            }
            return result;
        }

        else if (args.length == 2) {
            return null;
        }
        return null;
    }



}
