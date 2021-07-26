package me.Skippysunday12.Commands.commands;

import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Skippysunday12.Commands.backbone.PCommand;
import net.md_5.bungee.api.ChatColor;

public class GetStat extends PCommand implements CommandExecutor{

    public GetStat() {
        super(2, "stat.stat");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(label.equalsIgnoreCase("stat")) {

            boolean succeeded = false;
            succeeded = check(args, sender, "/stat <stat_type> <player>", 1, false);

            if(!succeeded) return false;

            Player target = Bukkit.getPlayerExact(args[1]);

            if(args[0].equalsIgnoreCase("animalbreeds")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has bred " +
                        target.getStatistic(Statistic.ANIMALS_BRED) + " animals");
                return false;
            }

            else if(args[0].equalsIgnoreCase("armorcleans")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has removed dye from " +
                        target.getStatistic(Statistic.ARMOR_CLEANED) + " leather armors");
                return false;
            }

            else if(args[0].equalsIgnoreCase("elytra_time")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has flown with elytra for " +
                        (((target.getStatistic(Statistic.AVIATE_ONE_CM)/20)/60)/60) + " minutes");
                return false;
            }

            else if(args[0].equalsIgnoreCase("banner_cleaned")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has removed dye from " +
                        target.getStatistic(Statistic.BANNER_CLEANED) + " banners");
                return false;
            }

            else if(args[0].equalsIgnoreCase("beacon_interaction")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has interacted with " +
                        target.getStatistic(Statistic.BEACON_INTERACTION) + " beacons");
                return false;
            }

            else if(args[0].equalsIgnoreCase("bell_ring")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has ringed " +
                        target.getStatistic(Statistic.ARMOR_CLEANED) + " bells");
                return false;
            }

            else if(args[0].equalsIgnoreCase("bell_ring")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has ringed " +
                        target.getStatistic(Statistic.ARMOR_CLEANED) + " bells");
                return false;
            }

            else if(args[0].equalsIgnoreCase("boatage")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has ridden a boat for " +
                        (((target.getStatistic(Statistic.BOAT_ONE_CM)/20)/60)/60) + " minutes");
                return false;
            }

            else if(args[0].equalsIgnoreCase("cake")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has eaten " +
                        target.getStatistic(Statistic.CAKE_SLICES_EATEN) + " cake slices");
                return false;
            }

            else if(args[0].equalsIgnoreCase("cauldron_filled")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has filled " +
                        target.getStatistic(Statistic.CAULDRON_FILLED) + " cauldrons");
                return false;
            }

            else if(args[0].equalsIgnoreCase("cauldron_used")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has used " +
                        target.getStatistic(Statistic.CAULDRON_USED) + " cauldrons");
                return false;
            }

            else if(args[0].equalsIgnoreCase("chest_open")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has opened " +
                        target.getStatistic(Statistic.CHEST_OPENED) + " chests");
                return false;
            }

            else if(args[0].equalsIgnoreCase("shulker_cleaned")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has cleaned " +
                        target.getStatistic(Statistic.CLEAN_SHULKER_BOX) + " shulker boxes");
                return false;
            }

            else if(args[0].equalsIgnoreCase("climb")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has climbed for " +
                        (((target.getStatistic(Statistic.CLIMB_ONE_CM)/20)/60)/60) + " minutes");
                return false;
            }

            else if(args[0].equalsIgnoreCase("craft")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has crafted " +
                        target.getStatistic(Statistic.CRAFT_ITEM) + " items");
                return false;
            }

            else if(args[0].equalsIgnoreCase("craft_interact")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has interacted with " +
                        target.getStatistic(Statistic.CRAFTING_TABLE_INTERACTION) + " crafting tables");
                return false;
            }

            else if(args[0].equalsIgnoreCase("crouch_time")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has crouched for " +
                        (((target.getStatistic(Statistic.CROUCH_ONE_CM)/20)/60)/60) + " minutes");
                return false;
            }

            else if(args[0].equalsIgnoreCase("damage_taken")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has taken " +
                        target.getStatistic(Statistic.DAMAGE_ABSORBED) + " damage points");
                return false;
            }

            else if(args[0].equalsIgnoreCase("damaga_shield")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has blocked " +
                        target.getStatistic(Statistic.DAMAGE_BLOCKED_BY_SHIELD) + " damage points with a shield");
                return false;
            }

            else if(args[0].equalsIgnoreCase("damage_dealt")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has dealt a total of " +
                        target.getStatistic(Statistic.DAMAGE_DEALT) + " damage points");
                return false;
            }

            else if(args[0].equalsIgnoreCase("damage_dealt_absorbed")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has dealt " +
                        target.getStatistic(Statistic.DAMAGE_DEALT_ABSORBED) + " damage points that were absorbed");
                return false;
            }

            else if(args[0].equalsIgnoreCase("damage_dealt_resisted")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has dealt " +
                        target.getStatistic(Statistic.DAMAGE_DEALT_RESISTED) + " that was resisted");
                return false;
            }

            else if(args[0].equalsIgnoreCase("damage_resisted")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has resisted " +
                        target.getStatistic(Statistic.DAMAGE_RESISTED) + " damage points");
                return false;
            }

            else if(args[0].equalsIgnoreCase("damage_taken")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has taken " +
                        target.getStatistic(Statistic.DAMAGE_TAKEN) + " damage points");
                return false;
            }

            else if(args[0].equalsIgnoreCase("deaths")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has died " +
                        target.getStatistic(Statistic.DEATHS) + " times");
                return false;
            }

            else if(args[0].equalsIgnoreCase("dispensers_inspected")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has inspected " +
                        target.getStatistic(Statistic.DISPENSER_INSPECTED) + " dispensers");
                return false;
            }

            else if(args[0].equalsIgnoreCase("drop")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has droped " +
                        target.getStatistic(Statistic.DROP_COUNT) + " items");
                return false;
            }

            else if(args[0].equalsIgnoreCase("dropper_inspected")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has inspected " +
                        target.getStatistic(Statistic.DROPPER_INSPECTED) + " droppers");
                return false;
            }

            else if(args[0].equalsIgnoreCase("ender_chest")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has opened " +
                        target.getStatistic(Statistic.ENDERCHEST_OPENED) + " ender chests");
                return false;
            }

            else if(args[0].equalsIgnoreCase("fall_time")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has fell for " +
                        (((target.getStatistic(Statistic.FALL_ONE_CM)/20)/60)/60) + " minutes");
                return false;
            }

            else if(args[0].equalsIgnoreCase("fish_caught")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has caught " +
                        target.getStatistic(Statistic.FISH_CAUGHT) + " fish");
                return false;
            }

            else if(args[0].equalsIgnoreCase("flowers_potted")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has potted " +
                        target.getStatistic(Statistic.FLOWER_POTTED) + " flowers");
                return false;
            }

            else if(args[0].equalsIgnoreCase("creative_fly_time")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has flown in creative mode for " +
                        (((target.getStatistic(Statistic.FLY_ONE_CM)/20)/60)/60) + " minutes");
                return false;
            }

            else if(args[0].equalsIgnoreCase("furnace_interaction")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has interacted with " +
                        target.getStatistic(Statistic.FURNACE_INTERACTION) + " furnaces");
                return false;
            }

            else if(args[0].equalsIgnoreCase("hopper_inspected")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has inspected " +
                        target.getStatistic(Statistic.HOPPER_INSPECTED) + " hoppers");
                return false;
            }

            else if(args[0].equalsIgnoreCase("horse_ride_time")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has ridden a horse for " +
                        (((target.getStatistic(Statistic.HORSE_ONE_CM)/20)/60)/60) + " minutes");
                return false;
            }

            else if(args[0].equalsIgnoreCase("anvil_interact")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has interacted with " +
                        target.getStatistic(Statistic.INTERACT_WITH_ANVIL) + " anvil");
                return false;
            }

            else if(args[0].equalsIgnoreCase("blast_furnace")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has interacted with " +
                        target.getStatistic(Statistic.INTERACT_WITH_BLAST_FURNACE) + " blast furnaces");
                return false;
            }

            else if(args[0].equalsIgnoreCase("loom")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has interacted with " +
                        target.getStatistic(Statistic.INTERACT_WITH_LOOM) + " looms");
                return false;
            }

            else if(args[0].equalsIgnoreCase("smithing_table")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has interacted with " +
                        target.getStatistic(Statistic.INTERACT_WITH_SMITHING_TABLE) + " smithing tables");
                return false;
            }

            else if(args[0].equalsIgnoreCase("smoker")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has interacted with " +
                        target.getStatistic(Statistic.INTERACT_WITH_SMOKER) + " smokers");
                return false;
            }

            else if(args[0].equalsIgnoreCase("stone_cutter")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has interacted with " +
                        target.getStatistic(Statistic.INTERACT_WITH_STONECUTTER) + " stone cutters");
                return false;
            }

            else if(args[0].equalsIgnoreCase("enchants")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has enchanted " +
                        target.getStatistic(Statistic.ITEM_ENCHANTED) + " items");
                return false;
            }

            else if(args[0].equalsIgnoreCase("jump")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has jumped " +
                        target.getStatistic(Statistic.JUMP) + " times");
                return false;
            }

            else if(args[0].equalsIgnoreCase("leave_game")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has left " +
                        target.getStatistic(Statistic.LEAVE_GAME) + " times");
                return false;
            }

            else if(args[0].equalsIgnoreCase("blocks_mined")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has mined " +
                        target.getStatistic(Statistic.MINE_BLOCK) + " blocks");
                return false;
            }

            else if(args[0].equalsIgnoreCase("minecart_time")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has ridden in a minecart for " +
                        (((target.getStatistic(Statistic.MINECART_ONE_CM)/20)/60)/60) + " minutes");
                return false;
            }

            else if(args[0].equalsIgnoreCase("mobkills")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has killed " +
                        target.getStatistic(Statistic.MOB_KILLS) + " mobs");
                return false;
            }

            else if(args[0].equalsIgnoreCase("noteblock_played")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has played " +
                        target.getStatistic(Statistic.NOTEBLOCK_PLAYED) + " noteblocks");
                return false;
            }

            else if(args[0].equalsIgnoreCase("noteblock_tuned")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has tuned " +
                        target.getStatistic(Statistic.NOTEBLOCK_TUNED) + " noteblocks");
                return false;
            }

            else if(args[0].equalsIgnoreCase("barrels_opened")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has opened " +
                        target.getStatistic(Statistic.OPEN_BARREL) + " barrels");
                return false;
            }

            else if(args[0].equalsIgnoreCase("pig_time")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has ridden a pig for " +
                        (((target.getStatistic(Statistic.PIG_ONE_CM)/20)/60)/60) + " minutes");
                return false;
            }

            else if(args[0].equalsIgnoreCase("playtime")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has played for " +
                        ((target.getStatistic(Statistic.PLAY_ONE_MINUTE)/20)/60) + " minutes");
                return false;
            }

            else if(args[0].equalsIgnoreCase("player_kills")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has killed " +
                        target.getStatistic(Statistic.PLAYER_KILLS) + " players");
                return false;
            }

            else if(args[0].equalsIgnoreCase("raid_triggers")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has triggered " +
                        target.getStatistic(Statistic.RAID_TRIGGER) + " raids");
                return false;
            }

            else if(args[0].equalsIgnoreCase("raid_win")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has won " +
                        target.getStatistic(Statistic.RAID_WIN) + " raids");
                return false;
            }

            else if(args[0].equalsIgnoreCase("records_played")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has played " +
                        target.getStatistic(Statistic.RECORD_PLAYED) + " records");
                return false;
            }

            else if(args[0].equalsIgnoreCase("shulkers_opened")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has opened " +
                        target.getStatistic(Statistic.SHULKER_BOX_OPENED) + " shulker boxes");
                return false;
            }

            else if(args[0].equalsIgnoreCase("sleeps")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has slept " +
                        target.getStatistic(Statistic.SLEEP_IN_BED) + " times");
                return false;
            }

            else if(args[0].equalsIgnoreCase("sneak_time")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has crouched for " +
                        (target.getStatistic(Statistic.SNEAK_TIME)/20) + " seconds");
                return false;
            }

            else if(args[0].equalsIgnoreCase("sprint_time")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has sprinted for " +
                        ((target.getStatistic(Statistic.SPRINT_ONE_CM)/20)/60) + " seconds");
                return false;
            }

            else if(args[0].equalsIgnoreCase("strider_time")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has ridden a strider for " +
                        (((target.getStatistic(Statistic.STRIDER_ONE_CM)/20)/60)/60) + " minutes");
                return false;
            }

            else if(args[0].equalsIgnoreCase("swim_time")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has swam for " +
                        (((target.getStatistic(Statistic.SWIM_ONE_CM)/20)/60)/60) + " minutes");
                return false;
            }

            else if(args[0].equalsIgnoreCase("talked_to_villager")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has talked to " +
                        target.getStatistic(Statistic.TALKED_TO_VILLAGER) + " villagers");
                return false;
            }

            else if(args[0].equalsIgnoreCase("target_hit")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has hit " +
                        target.getStatistic(Statistic.TARGET_HIT) + " targets");
                return false;
            }

            else if(args[0].equalsIgnoreCase("time_since_death")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " died " +
                        ((target.getStatistic(Statistic.TIME_SINCE_DEATH)/20)/60) + " minutes ago");
                return false;
            }

            else if(args[0].equalsIgnoreCase("time_since_rest")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " slept " +
                        ((target.getStatistic(Statistic.TIME_SINCE_REST)/20)/60) + " minutes ago");
                return false;
            }

            else if(args[0].equalsIgnoreCase("villager_trades")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has traded with " +
                        target.getStatistic(Statistic.TRADED_WITH_VILLAGER) + " villagers");
                return false;
            }

            else if(args[0].equalsIgnoreCase("trapped_chests")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has triggered " +
                        target.getStatistic(Statistic.TRAPPED_CHEST_TRIGGERED) + " trapped chests");
                return false;
            }

            else if(args[0].equalsIgnoreCase("water_walk_time")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has walked on water for " +
                        (((target.getStatistic(Statistic.WALK_ON_WATER_ONE_CM)/20)/60)/60) + " minutes");
                return false;
            }

            else if(args[0].equalsIgnoreCase("walk_time")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has walked for " +
                        (((target.getStatistic(Statistic.WALK_ONE_CM)/20)/60)/60) + " minutes");
                return false;
            }

            else if(args[0].equalsIgnoreCase("under_water_walk_time")) {
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GREEN + " has walked under water for " +
                        (((target.getStatistic(Statistic.WALK_UNDER_WATER_ONE_CM)/20)/60)/60) + " minutes");
                return false;
            }

            else {
                sender.sendMessage(ChatColor.RED + "Usage: /stat <stat_type> <player>");
                return false;
            }


        }
        return false;
    }

}
