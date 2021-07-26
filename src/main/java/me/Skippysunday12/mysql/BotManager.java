package me.Skippysunday12.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

import javax.security.auth.login.LoginException;

import org.bukkit.Bukkit;

import me.Skippysunday12.playerstats.PlayerStats;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class BotManager extends ListenerAdapter{

    private String name;
    private String nick;
    private String UUID;
    private String Gamemode;
    private int health;
    private int hunger;
    private int PosX;
    private int PosY;
    private int PosZ;
    private int BedPosX;
    private int BedPosY;
    private int BedPosZ;
    private int CompassPosX;
    private int CompassPosY;
    private int CompassPosZ;
    private int arrows;
    private int xpLevels;
    private int xpTotal;
    private int renderDistance;
    private ResultSet set;

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        if(event.getAuthor().isBot()) return;
        if(event.getMessage().getContentRaw().startsWith("!stathelp")) {
            event.getChannel().sendMessage("Hello! I am a discord bot who watches over a minecraft server's players! Use the command !stat "
                    + "<playername>"
                    + "to get the stats of a player!").queue();
            return;

        }

        if(!event.getMessage().getContentRaw().startsWith("!stat")) return;
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        if(args.length > 2 || args.length == 1) {
            event.getChannel().sendMessage("Incorrect syntax! Proper command is !stat <playername>").queue();

            return;
        }

        if(!SQLSetup.hasEntry(args[1])) {
            event.getChannel().sendMessage("That user is not in the database!").queue();
            return;
        }
        set = SQLSetup.entryByName(args[1]);
        setVars();
        //18 Variables

        event.getChannel().sendMessage("Here are the stats for player " + name + ":\n"
                + "Name: " + name + "\nNickname: " + nick + "\nUUID: " + UUID + "\nGamemode: " + Gamemode + "\nHealth: " + health + "\nHunger level: " + hunger +
                "\nX Position: " + PosX + "\nY Position: " + PosY + "\nZ Position: " + PosZ +
                "\nBed X: " + BedPosX + "\nBed Y: " + BedPosY + "\nBed Z: " + BedPosZ + "\n(If bed pos is 0, then they do not have a bed)" +
                "\nCompass X: " + CompassPosX + "\nCompass Y: " + CompassPosY + "\nCompass Z: " + CompassPosZ +
                "\n" + arrows + " arrows in their body" + "\n" + name + " has " + xpLevels + " XP levels, and " + xpTotal + " points"
                + "\nRender Distance: " + renderDistance + " chunks")
                .queue();


    }

    private void setVars() {
        try {
            while(set.next()) {
                name = set.getString("name");
                nick = set.getString("CurrentNickname");
                UUID = set.getString("UUID");
                health = set.getInt("Health");
                hunger = set.getInt("Hunger");
                PosX = set.getInt("CurrentPosX");
                PosY = set.getInt("CurrentPosY");
                PosZ = set.getInt("CurrentPosZ");
                BedPosX = set.getInt("BedPosX");
                BedPosY = set.getInt("BedPosY");
                BedPosZ = set.getInt("BedPosZ");
                CompassPosX = set.getInt("CompassTargetPosX");
                CompassPosY = set.getInt("CompassTargetPosY");
                CompassPosZ = set.getInt("CompassTargetPosZ");
                arrows = set.getInt("ArrowsInBody");
                xpLevels = set.getInt("XPLevels");
                xpTotal = set.getInt("XPTotalPoints");
                renderDistance = set.getInt("ViewDistance");
                Gamemode = set.getString("Gamemode");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void discordManager() throws LoginException {

        boolean enabled = PlayerStats.config.getBoolean("discord-settings.enabled");
        String token = PlayerStats.config.getString("discord-settings.token");

        if(!enabled) {
            Bukkit.getLogger().info("[PlayerStats] Discord bot is not enabled!");
            return;
        }

        else if(enabled == true && PlayerStats.config.getBoolean("mySQL.enable") == false) {
            Bukkit.getLogger().info("[PlayerStats] You have the discord bot enabled, but it also requires MySQL to be enabled!");
            return;
        }

        else if (enabled == true && PlayerStats.sqlSetup == false) {
            Bukkit.getLogger().info("[Playerstats] The MySQL server connection did not start correctly! Please check login info and other possible errors!");
            return;
        }
        else if(token == null) {
            Bukkit.getLogger().log(Level.WARNING, "[PlayerStats] You must fill out the token field for the discord bot to function!");
            return;
        }

        if(Bukkit.getServer().getPluginManager().getPlugin("JDASpigot") != null && enabled == true) {
            Bukkit.getLogger().info("[PlayerStats] JDA Spigot plugin has been found! Discord bot is now starting!");


            JDABuilder.createDefault(token).addEventListeners(new BotManager()).build().getPresence().setPresence(OnlineStatus.ONLINE, Activity.watching("Your servers players"));
        }
        else {
            Bukkit.getLogger().log(Level.WARNING, "[PlayerStats] You enabled the discord bot, but you forgot the dependancy! Check the spigot website for a download link!");
        }

    }



}
