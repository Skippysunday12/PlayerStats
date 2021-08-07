package me.Skippysunday12.mysql;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

import com.mysql.jdbc.Connection;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;


import me.Skippysunday12.playerstats.PlayerStats;

public class SQLSetup {

    public static Connection connection;
    private static String username = "", password = "", database = "", IP = "", port = "";
    public static String mainTable = "";
    public static boolean interact = false;

    public void setUpSql() {
        if(!PlayerStats.config.getBoolean("mySQL.enable")) {
            Bukkit.getServer().getLogger().log(Level.INFO, "[PlayerStats] You currently do not have MySQL enabled. If you think this is"
                    + " a mistake, check the config! Also be aware that you must have this option enabled and working for the discord bot to"
                    + " function!");
            PlayerStats.sqlSetup = false;
            return;
        }

        if(PlayerStats.config.getString("mySQL.username") == null) {
            Bukkit.getServer().getLogger().log(Level.SEVERE, "[PlayerStats] You have mySQL enabled, but did not fill out the username. Please do that.");
            PlayerStats.sqlSetup = false;
        } else username = PlayerStats.config.getString("mySQL.username");

        if(PlayerStats.config.getString("mySQL.password") == null) {
            Bukkit.getServer().getLogger().log(Level.SEVERE, "[PlayerStats] You have mySQL enabled, but did not fill out the password. Please do that.");
            PlayerStats.sqlSetup = false;
        } else {
            if(PlayerStats.config.getString("mySQL.password").equals("-~-")) {password = "";}
            else password = PlayerStats.config.getString("mySQL.password");
        }

        if(PlayerStats.config.getString("mySQL.IP") == null) {
            Bukkit.getServer().getLogger().log(Level.SEVERE, "[PlayerStats] You have mySQL enabled, but did not fill out the IP. Please do that.");
            PlayerStats.sqlSetup = false;
        } else IP = PlayerStats.config.getString("mySQL.IP");

        if(PlayerStats.config.getString("mySQL.port") == null) {
            Bukkit.getServer().getLogger().log(Level.SEVERE, "[PlayerStats] You have mySQL enabled, but did not fill out the port. Please do that.");
            PlayerStats.sqlSetup = false;
        } else port = PlayerStats.config.getString("mySQL.port");

        if(PlayerStats.config.getString("mySQL.database") == null) {
            Bukkit.getServer().getLogger().log(Level.INFO, "[PlayerStats] You have mySQL enabled, and did not fill out database. Defaulting to 'test'");
            database = "test";
        } else database = PlayerStats.config.getString("mySQL.database");

        if(PlayerStats.config.getString("mySQL.main") == null) {
            Bukkit.getServer().getLogger().log(Level.INFO, "[PlayerStats] You have mySQL enabled, and did not fill out table. Defaulting to 'playerstats'");
            mainTable = "playerstats";
        } else mainTable = PlayerStats.config.getString("mySQL.main");

        if(PlayerStats.config.getString("mySQL.update_on_interact") == null) {
            Bukkit.getServer().getLogger().info("[PlayerStats] update_on_interact was left empty, defaulting to 'false'");
            interact=false;
        }else interact = PlayerStats.config.getBoolean("mySQL.update_on_interact");

        try {
            openConnection();
            Bukkit.getLogger().info("[PlayerStats] MySQL has been successfully enabled!");
            PlayerStats.sqlSetup = true;
        } catch (ClassNotFoundException | SQLException e) {
            Bukkit.getLogger().log(Level.SEVERE, "[PlayerStats] Something went wrong trying to connect to MySQL! Check login info and database status!");
        }

        try {
            PreparedStatement p = connection.prepareStatement("CREATE TABLE IF NOT EXISTS " + mainTable + " (Name VARCHAR(20), CurrentNickname VARCHAR(100), "
                    + "UUID VARCHAR(100), Gamemode VARCHAR(50), Health INT(2), Hunger INT(2), CurrentPosX INT(8), CurrentPosY INT(8), CurrentPosZ INT(8), "
                    + "BedPosX INT(8), BedPosY INT(8), BedPosZ INT(8), CompassTargetPosX INT(8), CompassTargetPosY INT(8), CompassTargetPosZ INT(8), "
                    + "ArrowsInBody INT(3), XPLevels INT(3), XPTotalPoints INT(4), ViewDistance INT(2), PRIMARY KEY(NAME))");

            p.executeUpdate();
            Bukkit.getLogger().info("[PlayerStats] Using database: " + database + ", and table: " + mainTable);
        } catch (SQLException e) {
            Bukkit.getLogger().log(Level.WARNING, "[PlayerStats] There was an uh oh! MySQL did something naughty!");
        }
    }

    //Code taken from Spigot forums, link: https://www.spigotmc.org/wiki/connecting-to-databases-mysql/
    //Actual DriverManager URL from Stack Overflow at https://stackoverflow.com/questions/2993251/jdbc-batch-insert-performance/10617768#10617768
    public void openConnection() throws SQLException, ClassNotFoundException {
        if (connection != null && !connection.isClosed()) {
            return;
        }
        Class.forName("com.mysql.jdbc.Driver");
        connection = (Connection) DriverManager.getConnection("jdbc:mysql://" + IP + ":" + port + "/" +
                database + "?useServerPrepStmts=false&rewriteBatchedStatements=true", username, password);
        //DriverManager.getConnection("jdbc:mysql://" + IP + ":" + port + "/" + database + "?useServerPrepStmts=false&rewriteBatchedStatements=true", username, password);

    }


    public void close() throws SQLException, ClassNotFoundException{
        if(PlayerStats.sqlSetup) {
            try{
                connection.close();
                Bukkit.getLogger().info("[PlayerStats] SQL connection successfully closed!");
            } catch(SQLException e) {
                Bukkit.getLogger().log(Level.SEVERE, "Something went wrong trying to close SQL connection! PANIC!! (No dont really!)");
            }
        }
    }

    public Connection getConnection() {return connection;}

    public static boolean hasEntry(String name) {
        try {
            PreparedStatement pss = connection.prepareStatement("SELECT * FROM " + mainTable);
            ResultSet r = pss.executeQuery();

            while(r.next()) {
                if(r.getString("Name") != null) {
                    if(r.getString("Name").equals(name))return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean hasEntryByUUID(String u) {

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + mainTable);
            ResultSet r = ps.executeQuery();

            while(r.next()) {
                if(r.getString("UUID") != null) {
                    if(r.getString("UUID").equals(u))return true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static void updateMains(String name) {
        try {
            Player player = Bukkit.getPlayerExact(name);

            if(!hasEntry(player.getName())) {createEntry(player); return;}

            PreparedStatement ps = connection.prepareStatement("UPDATE " + mainTable + " SET CurrentPosX=?, CurrentPosY=?, CurrentPosZ=?, Health=?, "
                    + "Hunger=?, CurrentNickname=?, ArrowsInBody=?, XPLevels=?, XPTotalPoints=?, Gamemode=?, ViewDistance=? WHERE Name=?");
            ps.setInt(1, (int)player.getLocation().getX());
            ps.setInt(2, (int)player.getLocation().getY());
            ps.setInt(3, (int)player.getLocation().getZ());
            ps.setInt(4, (int)player.getHealth());
            ps.setInt(5, (int)player.getSaturation());
            ps.setString(6, player.getDisplayName());
            ps.setInt(7, player.getArrowsInBody());
            ps.setInt(8, player.getExpToLevel());
            ps.setInt(9, player.getTotalExperience());
            ps.setString(10, "" + player.getGameMode().toString());
            ps.setInt(11, player.getClientViewDistance());
            ps.setString(12, name);

            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void createEntry(Player pl) {
        try {
            Player player = pl;
            ResultSet result;

            PreparedStatement ps = SQLSetup.connection.prepareStatement("SELECT * FROM " + SQLSetup.mainTable);
            result = ps.executeQuery();
            while(result.next())if(result.getString("Name").equals(player.getName())) {SQLSetup.updateMains(player.getName()); return;}


            PreparedStatement ps2 = (PreparedStatement) SQLSetup.connection.prepareStatement("INSERT IGNORE INTO " + SQLSetup.mainTable + " (Name, UUID, CurrentNickname,"
                    + " Health, Hunger, "
                    + "CurrentPosX, CurrentPosY, CurrentPosZ, CompassTargetPosX, CompassTargetPosY, CompassTargetPosZ, ArrowsInBody, "
                    + "XPLevels, XPTotalPoints, ViewDistance)"
                    + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps2.setString(1, player.getName());
            ps2.setString(2, player.getUniqueId().toString());
            ps2.setString(3, player.getDisplayName());
            ps2.setInt(4, (int)player.getHealth());
            ps2.setInt(5, (int)player.getSaturation());
            ps2.setInt(6, (int)player.getLocation().getX());
            ps2.setInt(7, (int)player.getLocation().getY());
            ps2.setInt(8, (int)player.getLocation().getZ());
            ps2.setInt(9, 0);
            ps2.setInt(10, 0);
            ps2.setInt(11, 0);
            ps2.setInt(12, player.getArrowsInBody());
            ps2.setInt(13, player.getExpToLevel());
            ps2.setInt(14, player.getTotalExperience());
            ps2.setInt(15, player.getClientViewDistance());
            ps2.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static ResultSet entryByName(String name) {

        try {

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + mainTable + " WHERE Name=?");
            ps.setString(1, name);
            ResultSet set = ps.executeQuery();

            return set;
        }catch(SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

    public static ResultSet entryByUUID(String uuid) {
        try {

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + mainTable + " WHERE UUID=?");
            ps.setString(1, uuid);
            ResultSet set = ps.executeQuery();

            return set;
        }catch(SQLException e) {
            e.printStackTrace();
        }


        return null;
    }




}
