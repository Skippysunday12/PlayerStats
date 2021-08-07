package me.Skippysunday12.guimanagers;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.Skippysunday12.playerstats.PlayerStats;
import net.md_5.bungee.api.ChatColor;

public class GuiManager_1_8 implements Guimanager{
    public static Inventory maininv;
    public static Inventory potinv;
    public static Inventory perminv;
    public static Inventory statinv1;
    public static Inventory statinv2;
    public static Inventory chest;
    public static Inventory echest;
    public static List<Inventory> inventories = new ArrayList<Inventory>();

    @SuppressWarnings("deprecation")
    public void maininv(String pl) {

        List<String> lore = new ArrayList<String>();

        Player player = Bukkit.getPlayerExact(pl);

        maininv = Bukkit.createInventory(null, 54, ChatColor.BLUE + "Statistics");

        ItemStack item = PlayerStats.pHead(pl);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + pl);
        lore.add(ChatColor.GRAY + "Health: " + ChatColor.RED + player.getHealth());
        lore.add(ChatColor.GRAY + "Hunger: " + ChatColor.GREEN + player.getFoodLevel());
        lore.add(ChatColor.GRAY + "Gamemode: " + ChatColor.BLUE + player.getGameMode());
        lore.add(ChatColor.GRAY + "Nickname: " + ChatColor.AQUA + player.getDisplayName());
        meta.setLore(lore);
        item.setItemMeta(meta);


        maininv.setItem(4, item);

        inventories.add(maininv);



        item = new ItemStack(Material.POTION);
        meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.RED + "Potion effects");
        lore.clear();
        lore.add(ChatColor.GRAY + "See a players potion effects");
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);

        item.setItemMeta(meta);
        maininv.setItem(15, item);


        if(player.isOp()) {
            item = new ItemStack(Material.BEDROCK);
            meta = item.getItemMeta();

            meta.setDisplayName(ChatColor.GREEN + player.getName() + " is opped");

            lore.clear();
            lore.add(ChatColor.GRAY + "Is this player opped?");
            meta.setLore(lore);

            item.setItemMeta(meta);
        }
        else {
            item = new ItemStack(Material.GLASS);
            meta = item.getItemMeta();

            meta.setDisplayName(ChatColor.RED + player.getName() + " is not opped");

            lore.clear();
            lore.add(ChatColor.GRAY + "Is this player opped?");
            meta.setLore(lore);

            item.setItemMeta(meta);
        }

        maininv.setItem(19, item);

        if(player.getAllowFlight()) {
            item = new ItemStack(Material.FEATHER);
            meta = item.getItemMeta();
            lore.clear();

            meta.setDisplayName(ChatColor.GREEN + player.getName() + " can fly");
            lore.add(ChatColor.GRAY + "Can this player fly?");
            meta.setLore(lore);

            item.setItemMeta(meta);
        }
        else {
            item = new ItemStack(Material.WATER_BUCKET);
            meta = item.getItemMeta();
            lore.clear();

            meta.setDisplayName(ChatColor.BLUE + player.getName() + " cannot fly");
            lore.add(ChatColor.GRAY + "Can this player fly?");
            meta.setLore(lore);

            item.setItemMeta(meta);
        }

        maininv.setItem(28, item);


        item = new ItemStack(Material.valueOf("GRASS"));
        meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.AQUA + "Ping: " + PlayerStats.getPlayerPing(player) + "ms");

        lore.clear();
        lore.add(ChatColor.GRAY + "What is this players ping?");
        meta.setLore(lore);

        item.setItemMeta(meta);

        maininv.setItem(20, item);


        item = new ItemStack(Material.MAP);
        meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.GREEN + player.getName() + " is at:");

        lore.clear();
        lore.add(ChatColor.YELLOW + "World: " + player.getWorld().getName());
        lore.add(ChatColor.GREEN + "X: " + (int)player.getLocation().getX());
        lore.add(ChatColor.BLUE + "Y: " + (int)player.getLocation().getY());
        lore.add(ChatColor.DARK_PURPLE + "Z: " + (int)player.getLocation().getZ());
        lore.add(ChatColor.GRAY + "Click to teleport");
        meta.setLore(lore);
        item.setItemMeta(meta);

        maininv.setItem(29, item);



        item = new ItemStack(Material.PAPER);
        meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.GREEN + "Permissions");
        lore.clear();
        lore.add(ChatColor.GRAY + "See a players permissions");
        meta.setLore(lore);

        item.setItemMeta(meta);
        maininv.setItem(24, item);


        item = new ItemStack(Material.APPLE);
        meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.DARK_PURPLE + "Player Statistics");

        lore.clear();
        lore.add(ChatColor.GRAY + "See player statistics");
        meta.setLore(lore);
        item.setItemMeta(meta);

        maininv.setItem(16, item);

        item = new ItemStack(Material.APPLE);
        meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.DARK_PURPLE + "Player Statistics page 2");

        lore.clear();
        lore.add(ChatColor.GRAY + "See player statistics");
        meta.setLore(lore);
        item.setItemMeta(meta);

        maininv.setItem(25, item);

        item = new ItemStack(Material.WRITTEN_BOOK);
        BookMeta bmeta = (BookMeta) item.getItemMeta();
        bmeta.setAuthor("Skippysunday12");
        bmeta.setTitle("Help and Updates");
        bmeta.addPage("Thank you for downloading my plugin, and welcome to the help page! This is version 2.0, and there will be books like this on every openable page for you to read for help."
                + "\n\n\nThis is the Main Page, where you can see a general overview of");
        bmeta.addPage(" the GUI. It has some basic stats, and links to other pages. In future updates, these books will be added to other pages.");
        item.setItemMeta(bmeta);
        maininv.setItem(53, item);


        if(player.getInventory().getItemInHand().getType() == Material.AIR) {
            item = new ItemStack(Material.valueOf("THIN_GLASS"));
        }
        else {
            item = new ItemStack(player.getInventory().getItemInHand());
        }
        meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.DARK_BLUE + "This is the item in " + player.getName() + "'s main hand:");
        lore.clear();
        lore.add(ChatColor.GRAY + player.getInventory().getItemInHand().toString());
        if(item.getType() == Material.valueOf("THIN_GLASS")) {
            lore.add(ChatColor.GRAY + "As of now, this represents air, but it");
            lore.add(ChatColor.GRAY + "can also be actual glass panes!");
        }
        meta.setLore(lore);
        item.setItemMeta(meta);
        maininv.setItem(37, item);



        item = new ItemStack(Material.valueOf("BED"));
        meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.YELLOW + "Spawn location:");
        lore.clear();
        try {
            lore.add(ChatColor.GREEN + "X: " + player.getBedSpawnLocation().getX());
            lore.add(ChatColor.BLUE + "Y: " + player.getBedSpawnLocation().getY());
            lore.add(ChatColor.DARK_PURPLE + "Z: " + player.getBedSpawnLocation().getZ());
        }catch (Exception e) {
            lore.add(ChatColor.GRAY + "This player does not have a");
            lore.add(ChatColor.GRAY + "bed spawn, so they spawn at worldspawn");
        }
        meta.setLore(lore);
        item.setItemMeta(meta);
        maininv.setItem(10, item);


        if(player.isFlying()) {
            item = new ItemStack(Material.FEATHER);
            meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GOLD + "What is this player standing on?");
            lore.clear();
            lore.add("This player is flying");
            meta.setLore(lore);
            item.setItemMeta(meta);
        }

        else if(player.isOnGround()) {
            item = new ItemStack(Material.DIRT);
            meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GOLD + "What is this player standing on?");
            lore.clear();
            lore.add("This player is standing/walking");
            meta.setLore(lore);
            item.setItemMeta(meta);
            if(player.isSprinting()) {
                item = new ItemStack(Material.SUGAR);
                meta = item.getItemMeta();
                meta.setDisplayName(ChatColor.GOLD + "What is this player standing on?");
                lore.clear();
                lore.add("This player is sprinting");
                meta.setLore(lore);
                item.setItemMeta(meta);
            }
        }

        else if(player.isSwimming()) {
            item = new ItemStack(Material.WATER_BUCKET);
            meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GOLD + "What is this player standing on?");
            lore.clear();
            lore.add("This player is swimming");
            meta.setLore(lore);
            item.setItemMeta(meta);
        }

        else if(player.getFallDistance() > 0) {
            item = new ItemStack(Material.PHANTOM_MEMBRANE);
            meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GOLD + "What is this player standing on?");
            lore.clear();
            lore.add("This player is falling");
            meta.setLore(lore);
            item.setItemMeta(meta);
        }

        else if(player.isGliding()) {
            item = new ItemStack(Material.ELYTRA);
            meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GOLD + "What is this player standing on?");
            lore.clear();
            lore.add("This player is using elytra");
            meta.setLore(lore);
            item.setItemMeta(meta);
        }
        else {
            item = new ItemStack(Material.WATER_BUCKET);
            meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GOLD + "What is this player standing on?");
            lore.clear();
            lore.add("This player is freefloating in the water");
            meta.setLore(lore);
            item.setItemMeta(meta);
        }

        maininv.setItem(11, item);


        item = new ItemStack(Material.CHEST);
        meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.BLUE + "See the contents of the inventory a player is currently viewing");
        lore.clear();

        try {
            player.getOpenInventory();
            lore.add(ChatColor.GRAY + "Click to view");
            lore.add(ChatColor.GRAY + "Note: you cannot change the");
            lore.add(ChatColor.GRAY + "contents of this inventory");
        } catch(Exception e) {
            lore.add(ChatColor.GRAY + "This playeer is not currently viewing an inventory");
        }
        meta.setLore(lore);
        item.setItemMeta(meta);
        maininv.setItem(33, item);


        item = new ItemStack(Material.ENDER_CHEST);
        meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.DARK_PURPLE + "See the contents of a players ender chest");
        lore.clear();
        lore.add(ChatColor.GRAY + "Click to view");
        lore.add(ChatColor.GRAY + "Note: you cannot change the");
        lore.add(ChatColor.GRAY + "contents of this players ender chest");
        meta.setLore(lore);
        item.setItemMeta(meta);
        maininv.setItem(34, item);


        //42
        /*
        item = new ItemStack(Material.ARMOR_STAND);
        meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.GREEN + player.getName() + "'s Skin");
        lore.clear();
        lore.add(ChatColor.GRAY + "Click to view");
        lore.add(ChatColor.GRAY + "Type /removeskins to remove");
        meta.setLore(lore);
        item.setItemMeta(meta);
        maininv.setItem(42, item);
        */
    }


    public void potsinv(String pl) {
        Player player = Bukkit.getPlayerExact(pl);

        potinv = Bukkit.createInventory(null, 54, ChatColor.RED + "Potion Effects");
        List<String> lore = new ArrayList<String>();
        inventories.add(potinv);
        int slot = 0;


        for(PotionEffect effect : player.getActivePotionEffects()) {

            ItemStack item = new ItemStack(Material.POTION);
            PotionMeta meta = (PotionMeta) item.getItemMeta();

            PotionEffectType type = effect.getType();

            meta.addCustomEffect(new PotionEffect(type, 5*20, 1), true);

            String oname = effect.toString();
            int num = 0;
            String aname = "";

            while(num < oname.length()) {
                if(oname.charAt(num) == ':') {
                    aname = oname.substring(0, num);
                    break;
                }

                num++;
            }


            meta.setDisplayName(aname);

            lore.clear();
            lore.add(ChatColor.GRAY + "Duration: " + ChatColor.BLUE + effect.getDuration() + " ticks");
            lore.add(ChatColor.GRAY + "Amplifier: " + ChatColor.GREEN + effect.getAmplifier());
            lore.add(ChatColor.GRAY + "Has particles: " + ChatColor.DARK_PURPLE +effect.hasParticles());
            meta.setLore(lore);

            meta.setColor(type.getColor());

            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS);

            item.setItemMeta(meta);
            potinv.setItem(slot, item);

            slot++;
        }

        ItemStack item = new ItemStack(Material.BARRIER);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.DARK_GREEN + "" + ChatColor.ITALIC + "Back");
        lore.clear();
        lore.add(ChatColor.GRAY + "Back to Main page");
        meta.setLore(lore);

        item.setItemMeta(meta);
        potinv.setItem(49, item);





    }


    public void permInv(String pl) {

        List<String> lore = new ArrayList<String>();
        perminv = Bukkit.createInventory(null, 54, ChatColor.GREEN + "Permissions");
        inventories.add(perminv);

        Player player = Bukkit.getPlayerExact(pl);

        ItemStack item = new ItemStack(Material.PAPER);
        ItemMeta meta = item.getItemMeta();
        int slot = 0;

        lore.add(ChatColor.GRAY + " ");
        meta.setLore(lore);

        for(PermissionAttachmentInfo perm : player.getEffectivePermissions()) {
            String name = perm.getPermission();

            meta = item.getItemMeta();
            meta.setDisplayName(name);
            lore.clear();
            lore.add(ChatColor.GRAY + "A permission, * means all");
            meta.setLore(lore);

            item.setItemMeta(meta);
            perminv.setItem(slot, item);

            slot++;
        }

        item = new ItemStack(Material.BARRIER);
        meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.DARK_GREEN + "" + ChatColor.ITALIC + "Back");

        lore.clear();
        lore.add(ChatColor.GRAY + "Back to Main page");
        meta.setLore(lore);

        item.setItemMeta(meta);
        perminv.setItem(49, item);

    }

    public void statsInv1(String pl) {

        Player player = Bukkit.getPlayerExact(pl);
        statinv1 = Bukkit.createInventory(null, 54, ChatColor.DARK_PURPLE + "Player Statistics");
        inventories.add(statinv1);
        List<String> lore = new ArrayList<String>();
        Statistic[] stat = Statistic.values();

        ItemStack item = new ItemStack(Material.PAPER);
        ItemMeta meta = item.getItemMeta();
        int slot = 0;

        for(int i = 0; i < 53; i++) {
            try {
                String name = stat[i].toString();
                meta.setDisplayName(name);
                Statistic statype = stat[i];
                int val;

                lore.clear();
                if(name.contains("CM")) {
                    val = (((player.getStatistic(statype)/20)/60)/60);
                    lore.add(ChatColor.GRAY + "Time (Minutes): " + val);
                    lore.add(ChatColor.GRAY + "CM means time in ticks, and the value is in minutes");
                }

                else if(name.contains("MINUTE")) {
                    val = (((player.getStatistic(statype)/20)/60)/60);
                    lore.add(ChatColor.GRAY + "Time (Minutes): " + val);
                    lore.add(ChatColor.GRAY + "CM means time in ticks, and the value is in minutes");
                }
                else {
                    val = player.getStatistic(statype);
                    lore.add(ChatColor.GRAY + "Value: " + val);
                }

                meta.setLore(lore);
                item.setItemMeta(meta);
                statinv1.setItem(slot, item);

                slot++;
            }catch(Exception e) {
                continue;
            }

        }

        item = new ItemStack(Material.BARRIER);
        meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.DARK_GREEN + "" + ChatColor.ITALIC + "Back");
        lore.clear();
        lore.add(ChatColor.GRAY + "Go back to Main page");
        meta.setLore(lore);
        item.setItemMeta(meta);
        statinv1.setItem(49, item);

    }

    public void statsInv2(String pl) {
        Player player = Bukkit.getPlayerExact(pl);
        statinv2 = Bukkit.createInventory(null, 54, ChatColor.DARK_PURPLE + "Player Statistics page 2");
        inventories.add(statinv2);
        List<String> lore = new ArrayList<String>();
        Statistic[] stat = Statistic.values();

        ItemStack item = new ItemStack(Material.PAPER);
        ItemMeta meta = item.getItemMeta();
        int slot = 0;

        for(int i = 53; i <= 82; i++) {
            try {
                String name = stat[i].toString();
                meta.setDisplayName(name);
                Statistic statype = stat[i];
                int val;

                lore.clear();
                if(name.contains("CM")) {
                    val = (((player.getStatistic(statype)/20)/60)/60);
                    lore.add(ChatColor.GRAY + "Time (Minutes): " + val);
                    lore.add(ChatColor.GRAY + "CM means time in ticks, and the value is in minutes");
                }
                else {
                    val = player.getStatistic(statype);
                    lore.add(ChatColor.GRAY + "Value: " + val);
                }

                meta.setLore(lore);
                item.setItemMeta(meta);
                statinv2.setItem(slot, item);

                slot++;
            }catch(Exception e) {
                continue;
            }
        }

        item = new ItemStack(Material.BARRIER);
        meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.DARK_GREEN + "" + ChatColor.ITALIC + "Back");
        lore.clear();
        lore.add(ChatColor.GRAY + "Back to Main page");
        meta.setLore(lore);
        item.setItemMeta(meta);

        statinv2.setItem(49, item);

    }

    public void chest(String pl) {
        Player player = Bukkit.getPlayerExact(pl);
        InventoryView view = player.getOpenInventory();
        chest = Bukkit.createInventory(null, (view.countSlots() - 41), ChatColor.DARK_GREEN + player.getName() + "'s current viewed inventory");
        inventories.add(chest);


        for(int slot = 0; slot < (view.countSlots() - 41); slot++){
            chest.setItem(slot, view.getItem(slot));
        }
    }

    public void echest(String pl) {
        Player player = Bukkit.getPlayerExact(pl);
        echest = Bukkit.createInventory(null, 27, ChatColor.DARK_GREEN + pl + "'s Ender Chest");
        echest.setContents(player.getEnderChest().getContents());
        inventories.add(echest);
    }

    public Inventory getMain() {return maininv;}


    @Override
    public Inventory getChest() {
        return chest;
    }


    @Override
    public Inventory getEChest() {
        return echest;
    }


    @Override
    public List<Inventory> getInventories() {
        return inventories;
    }


    @Override
    public Inventory getPermInv() {
        return perminv;
    }


    @Override
    public Inventory getStatInv1() {
        return statinv1;
    }


    @Override
    public Inventory getStatInv2() {
        return statinv2;
    }


    @Override
    public Inventory getPotInv() {
        return potinv;
    }
}
