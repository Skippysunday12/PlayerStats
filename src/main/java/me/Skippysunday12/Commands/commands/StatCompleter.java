package me.Skippysunday12.Commands.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class StatCompleter implements TabCompleter {

    List<String> arguments = new ArrayList<String>();

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        if (arguments.isEmpty()) {
            arguments.add("animalbreeds"); arguments.add("armorcleans"); arguments.add("fly_time"); arguments.add("banner_cleaned");
            arguments.add("bell_ring"); arguments.add("boatage"); arguments.add("cake"); arguments.add("cauldron_filled"); arguments.add("cauldron_used");
            arguments.add("chest_open"); arguments.add("shulker_cleaned"); arguments.add("climb"); arguments.add("craft"); arguments.add("craft_interact");
            arguments.add("crouch_time"); arguments.add("damage_taken"); arguments.add("damage_shield"); arguments.add("damage_dealt");
            arguments.add("damage_dealt_absorbed"); arguments.add("damage_dealt_resisted"); arguments.add("damage_resisted"); arguments.add("damage_taken");
            arguments.add("deaths"); arguments.add("dispensers_inspected"); arguments.add("drop"); arguments.add("dropper_inspected");
            arguments.add("ender_chest"); arguments.add("fall_time"); arguments.add("fish_caught"); arguments.add("flowers_potted");
            arguments.add("creative_fly_time"); arguments.add("furnace_interaction"); arguments.add("hopper_inspected"); arguments.add("horse_ride_time");
            arguments.add("anvil_interact"); arguments.add("blast_furnace"); arguments.add("loom"); arguments.add("smithing_table");
            arguments.add("smoker"); arguments.add("stone_cutter"); arguments.add("enchants"); arguments.add("jump"); arguments.add("leave_game");
            arguments.add("blocks_mined"); arguments.add("minecart_time"); arguments.add("mobkills"); arguments.add("noteblock_played");
            arguments.add("noteblock_tuned"); arguments.add("barrels_opened"); arguments.add("pig_time"); arguments.add("playtime");
            arguments.add("player_kills"); arguments.add("raid_triggers"); arguments.add("raid_win"); arguments.add("records_played"); arguments.add("shulkers_opened");
            arguments.add("sleeps"); arguments.add("sneak_time"); arguments.add("sprint_time"); arguments.add("strider_time");
            arguments.add("swim_time"); arguments.add("talked_to_villager"); arguments.add("target_hit"); arguments.add("time_since_death");
            arguments.add("time_since_rest"); arguments.add("villager_trades"); arguments.add("trapped_chests"); arguments.add("walk_water_time");
            arguments.add("walk_time"); arguments.add("under_water_walk_time");
        }

        List<String> result = new ArrayList<String>();

        if (args.length == 1) {
            for (String a : arguments) {
                if (a.toLowerCase().startsWith(args[0].toLowerCase())) {
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
