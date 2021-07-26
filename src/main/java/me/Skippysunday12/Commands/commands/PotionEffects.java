package me.Skippysunday12.Commands.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

import me.Skippysunday12.Commands.backbone.PCommand;
import net.md_5.bungee.api.ChatColor;

public class PotionEffects extends PCommand implements CommandExecutor {

    public PotionEffects() {
        super(1, "stat.potfects");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (label.equalsIgnoreCase("potfects")) {

            boolean succeeded = false;
            succeeded = check(args, sender, "/potfects <player>", 0, false);

            if(!succeeded) return false;

            Player target = Bukkit.getPlayerExact(args[0]);

            sender.sendMessage(ChatColor.GREEN + "The user " + ChatColor.GOLD + args[0] + ChatColor.GREEN
                    + " has the following effects (if none are listed, then that player has none): " + ChatColor.AQUA);

            if (target.hasPotionEffect(PotionEffectType.ABSORPTION)) {
                sender.sendMessage("'absorbtion'  ");
            }
            if (target.hasPotionEffect(PotionEffectType.BAD_OMEN)) {
                sender.sendMessage("'bad omen'  ");
            }
            if (target.hasPotionEffect(PotionEffectType.BLINDNESS)) {
                sender.sendMessage("'blindness'  ");
            }
            if (target.hasPotionEffect(PotionEffectType.CONDUIT_POWER)) {
                sender.sendMessage("'conduit power'  ");
            }
            if (target.hasPotionEffect(PotionEffectType.CONFUSION)) {
                sender.sendMessage("'confusion'  ");
            }
            if (target.hasPotionEffect(PotionEffectType.DAMAGE_RESISTANCE)) {
                sender.sendMessage("'damage resistance'  ");
            }
            if (target.hasPotionEffect(PotionEffectType.DOLPHINS_GRACE)) {
                sender.sendMessage("'dolphins grace'  ");
            }
            if (target.hasPotionEffect(PotionEffectType.FAST_DIGGING)) {
                sender.sendMessage("'haste'  ");
            }
            if (target.hasPotionEffect(PotionEffectType.FIRE_RESISTANCE)) {
                sender.sendMessage("'fire resistance'  ");
            }
            if (target.hasPotionEffect(PotionEffectType.GLOWING)) {
                sender.sendMessage("'glowing'  ");
            }
            if (target.hasPotionEffect(PotionEffectType.HARM)) {
                sender.sendMessage("'harming'  ");
            }
            if (target.hasPotionEffect(PotionEffectType.HEAL)) {
                sender.sendMessage("'healing'  ");
            }
            if (target.hasPotionEffect(PotionEffectType.HEALTH_BOOST)) {
                sender.sendMessage("'health boost'  ");
            }
            if (target.hasPotionEffect(PotionEffectType.HERO_OF_THE_VILLAGE)) {
                sender.sendMessage("'hero of the village'  ");
            }
            if (target.hasPotionEffect(PotionEffectType.HUNGER)) {
                sender.sendMessage("'hunger'  ");
            }
            if (target.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)) {
                sender.sendMessage("'increased damage'  ");
            }
            if (target.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
                sender.sendMessage("'invisibility'  ");
            }
            if (target.hasPotionEffect(PotionEffectType.JUMP)) {
                sender.sendMessage("'jump boost'  ");
            }
            if (target.hasPotionEffect(PotionEffectType.LEVITATION)) {
                sender.sendMessage("'levitation'  ");
            }
            if (target.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
                sender.sendMessage("'night vision'  ");
            }
            if (target.hasPotionEffect(PotionEffectType.POISON)) {
                sender.sendMessage("'poison'  ");
            }
            if (target.hasPotionEffect(PotionEffectType.REGENERATION)) {
                sender.sendMessage("'regeneration'  ");
            }
            if (target.hasPotionEffect(PotionEffectType.SATURATION)) {
                sender.sendMessage("'saturation'  ");
            }
            if (target.hasPotionEffect(PotionEffectType.SLOW)) {
                sender.sendMessage("'slowness'  ");
            }
            if (target.hasPotionEffect(PotionEffectType.SLOW_DIGGING)) {
                sender.sendMessage("'mining fatigue'  ");
            }
            if (target.hasPotionEffect(PotionEffectType.SLOW_FALLING)) {
                sender.sendMessage("'slow falling'  ");
            }
            if (target.hasPotionEffect(PotionEffectType.SPEED)) {
                sender.sendMessage("'speed'  ");
            }
            if (target.hasPotionEffect(PotionEffectType.WATER_BREATHING)) {
                sender.sendMessage("'water breathing'  ");
            }
            if (target.hasPotionEffect(PotionEffectType.WEAKNESS)) {
                sender.sendMessage("'weakness'  ");
            }
            if (target.hasPotionEffect(PotionEffectType.WITHER)) {
                sender.sendMessage("'withering'  ");
            }

        }

        return false;
    }

}
