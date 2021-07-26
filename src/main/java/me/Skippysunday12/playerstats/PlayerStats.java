package me.Skippysunday12.playerstats;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.stream.Collectors;

import me.Skippysunday12.mysql.BotManager;
import me.Skippysunday12.mysql.SQLSetup;
import me.Skippysunday12.mysql.SQLdata;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.java.JavaPlugin;

import me.Skippysunday12.Commands.commands.ArrowsInBody;
import me.Skippysunday12.Commands.commands.Bed;
import me.Skippysunday12.Commands.commands.BedCompleter;
import me.Skippysunday12.Commands.commands.CanFly;
import me.Skippysunday12.Commands.commands.Compass;
import me.Skippysunday12.Commands.commands.CustomLink;
import me.Skippysunday12.Commands.commands.CustomName;
import me.Skippysunday12.Commands.commands.Damage;
import me.Skippysunday12.Commands.commands.Get;
import me.Skippysunday12.Commands.commands.GetAll;
import me.Skippysunday12.Commands.commands.GetCompleter;
import me.Skippysunday12.Commands.commands.GetPing;
import me.Skippysunday12.Commands.commands.GetStat;
import me.Skippysunday12.Commands.commands.Hand;
import me.Skippysunday12.Commands.commands.HandCompleter;
import me.Skippysunday12.Commands.commands.Inventories;
import me.Skippysunday12.Commands.commands.InventoriesCompleter;
import me.Skippysunday12.Commands.commands.IsOp;
import me.Skippysunday12.Commands.commands.Location;
import me.Skippysunday12.Commands.commands.NameMCLink;
import me.Skippysunday12.Commands.commands.PotionEffects;
import me.Skippysunday12.Commands.commands.RenderDistance;
import me.Skippysunday12.Commands.commands.StatCompleter;
import me.Skippysunday12.Commands.commands.Surface;
import me.Skippysunday12.Commands.commands.UUID;
import me.Skippysunday12.Commands.commands.WorldCommand;
import me.Skippysunday12.Commands.commands.XP;
import me.Skippysunday12.Commands.commands.XPCompleter;



public class PlayerStats extends JavaPlugin{
    //TODO test bed command, accidentally messed up completer
    public static PlayerStats instance;

    public static YamlConfiguration config;
    public static boolean sqlSetup = false;
    public static SQLSetup ms = new SQLSetup();
    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new GetAll(), this);
        this.getServer().getPluginManager().registerEvents(new SQLdata(), this);

        this.getCommand("canFly").setExecutor(new CanFly());
        this.getCommand("potfects").setExecutor(new PotionEffects());
        this.getCommand("surface").setExecutor(new Surface());
        this.getCommand("where").setExecutor(new Location());
        this.getCommand("get").setExecutor(new Get());
        this.getCommand("get").setTabCompleter(new GetCompleter());
        this.getCommand("stat").setExecutor(new GetStat());
        this.getCommand("stat").setTabCompleter(new StatCompleter());
        this.getCommand("isop").setExecutor(new IsOp());
        this.getCommand("namemcpage").setExecutor(new NameMCLink());
        this.getCommand("sendcustomlink").setExecutor(new CustomLink());
        this.getCommand("bed").setExecutor(new Bed());
        this.getCommand("bed").setTabCompleter(new BedCompleter());
        this.getCommand("compass").setExecutor(new Compass());
        this.getCommand("viewdistance").setExecutor(new RenderDistance());
        this.getCommand("ping").setExecutor(new GetPing());
        this.getCommand("hand").setExecutor(new Hand());
        this.getCommand("hand").setTabCompleter( new HandCompleter());
        this.getCommand("arrowsinbody").setExecutor(new ArrowsInBody());
        this.getCommand("getnick").setExecutor(new CustomName());
        this.getCommand("getxp").setExecutor(new XP());
        this.getCommand("getxp").setTabCompleter(new XPCompleter());
        this.getCommand("lastdamage").setExecutor(new Damage());
        this.getCommand("uuid").setExecutor(new UUID());
        this.getCommand("getall").setExecutor(new GetAll());
        this.getCommand("getInv").setExecutor(new Inventories());
        this.getCommand("getinv").setTabCompleter(new InventoriesCompleter());
        this.getCommand("getworld").setExecutor(new WorldCommand());

        instance = this;
        configurize();
        ms.setUpSql();
        try {
            if(config.getBoolean("discord-settings.enabled") == true)
                BotManager.discordManager();
        } catch (Exception e) {
            Bukkit.getLogger().info("[PlayerStats] Something went wrong while enabling the discord bot!");
        }

        new UpdateChecker(this, 85774).getVersion(version -> {
            if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
                Bukkit.getLogger().info("[PlayerStats] You are up to date!");
            } else {
                Bukkit.getLogger().info("[PlayerStats] There is an update available!");
            }
        });

    }

    @Override
    public void onDisable() {
        if(sqlSetup) {
            try {
                ms.close();
            } catch(ClassNotFoundException | SQLException e) {
                Bukkit.getLogger().log(Level.SEVERE, "Something went wrong closing the connection!");
            }
        }

    }

    private void configurize() {
        saveDefaultConfig();
        config = (YamlConfiguration) this.getConfig();
    }

    public static boolean isOnline(String pl) {
        if(!(Bukkit.getServer().getPlayerExact(pl) == null)) {
            return true;
        }
        return false;
    }



    public static void setData(String type, boolean value, Player p) {
        p.setMetadata(type, new FixedMetadataValue(getPlugin(PlayerStats.class), value));
    }


    //Code by CodedRed, in video: https://www.youtube.com/watch?v=3RzhFGvUqZ4&list=PL65-DKRLvp3Yn7iglPfxKoc7bl0N80XgG&index=9
    @SuppressWarnings("deprecation")
    public static ItemStack pHead(String pl) {

        boolean newV = Arrays.stream(Material.values()).map(Material::name).collect(Collectors.toList()).contains("PLAYER_HEAD");
        Material type = Material.matchMaterial(newV ? "PLAYER_HEAD" : "SKULL_ITEM");
        ItemStack item = new ItemStack(type);

        if(!newV) item.setDurability((short) 3);

        SkullMeta meta = (SkullMeta) item.getItemMeta();
        meta.setOwner(pl);

        item.setItemMeta(meta);

        return item;
    }

    //This method and the one after it was taken from spigot page: https://www.spigotmc.org/threads/
    //get-player-ping-with-reflection.147773/?__cf_chl_jschl_tk__=4d8eb0761c9a5d2dee9146191331b3374e
    //95f180-1612126425-0-ARjoS2gR2NtlfdS0oLYqrdfPgNVqs_lBfkO3XTPrQSQbjp7MpWBtPEINWD0lgi-Tk7ajpsBNx-
    //rxI1KY2E-udkw63bcyKmPUpBQy7FxahN_Lm00IF7xJEFRQfMK1PJvxbFUKb1sLY8NsaW2jJcgaLMFWKB8rQiTqyXlOX9Wl
    //45VfnU1VBQeTUpkokcEWYE2ty0RoFrLYG_1vo72A5mwNrni-CmjNVG-6umGgfeY7aFYXlmTmdifkmZ8pGMNKSOkHLtGhsyq
    //Klw0e0bMrb7Xx958Bz_m6RwsxPtAPtxN4ZcrTH4p_tZ2WXeUovfXRsKNhptQwhAwzH4QNNKnibaBSyxs3FQLB0EZ4uLm-xB-HAEuwETKNnxXYfXGBhJp_sdGEnw
    //Jeez thats a long url
    public static int getPlayerPing(Player player) {
        try {
            int ping = 0;
            Class<?> craftPlayer = Class.forName("org.bukkit.craftbukkit." + getServerVersion() + ".entity.CraftPlayer");
            Object converted = craftPlayer.cast(player);
            Method handle = converted.getClass().getMethod("getHandle", new Class[0]);
            Object entityPlayer = handle.invoke(converted, new Object[0]);
            Field pingField = entityPlayer.getClass().getField("ping");
            ping = pingField.getInt(entityPlayer);
            return ping;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private static String getServerVersion() {
        return Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
    }

    @SuppressWarnings("unused")
    public static int getUpdateTime() {
        if(!config.getBoolean("GUI.live-updates")) return -1;
        int time = 5;
        return time = config.getInt("GUI.live-update-time");

    }


}
