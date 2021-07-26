package me.Skippysunday12.Commands.commands;

import java.util.Hashtable;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.scheduler.BukkitRunnable;

import me.Skippysunday12.Commands.backbone.PCommand;
import me.Skippysunday12.guimanagers.GuiSetup;
import me.Skippysunday12.guimanagers.Guimanager;
import me.Skippysunday12.playerstats.PlayerStats;
import net.md_5.bungee.api.ChatColor;

public class GetAll extends PCommand implements CommandExecutor, Listener{

    public GetAll() {
        super(1, "stat.getall");
    }
    public static Hashtable<String, String> name = new Hashtable<String, String>();
    public static Hashtable<String, Integer> tasks = new Hashtable<String, Integer>();
    public static Hashtable<String, String> openInv = new Hashtable<String, String>();
    private static GuiSetup GS = new GuiSetup();
    private static Guimanager guimanager = GS.getManager();
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(label.equalsIgnoreCase("getall")) {

            boolean succeeded = false;
            succeeded = check(args, sender, "/getall <player>", 0, true);

            if(!succeeded) return false;

            Player player = (Player) sender;

            if(name.containsKey(player.getName())) name.remove(player.getName());

            name.put(player.getName(), args[0]);
            guimanager.maininv(name.get(player.getName()));
            player.openInventory(guimanager.getMain());

            int time = PlayerStats.getUpdateTime();
            if(time == -1) return false;

            int taskid = new BukkitRunnable() {
                Player pl = player;
                @Override
                public void run() {
                    switch(getInv(pl)) {

                        case "statistics":
                            guimanager.maininv(name.get(pl.getName()));
                            pl.openInventory(guimanager.getMain());
                            break;

                        case "potion effects":
                            guimanager.potsinv(name.get(pl.getName()));
                            pl.openInventory(guimanager.getPotInv());
                            break;

                        case "permissions":
                            guimanager.permInv(name.get(pl.getName()));
                            pl.openInventory(guimanager.getPermInv());
                            break;

                        case "player statistics":
                            guimanager.statsInv1(name.get(pl.getName()));
                            pl.openInventory(guimanager.getStatInv1());
                            break;

                        case "player statistics page 2":
                            guimanager.statsInv2(name.get(pl.getName()));
                            pl.openInventory(guimanager.getStatInv2());
                            break;

                        default:
                            Bukkit.getScheduler().cancelTask(tasks.get(pl.getName()));
                            tasks.remove(pl.getName());
                            break;
                    }



                }
            }.runTaskTimer(PlayerStats.getPlugin(PlayerStats.class), time*20, time*20).getTaskId();

            tasks.put(player.getName(), taskid);


        }

        return false;
    }

    /* Testing shows this is not usually nescecary. However, I am keeping for now just in case.
    @EventHandler
    public void onClose(InventoryCloseEvent event) {
        if(!tasks.containsKey(event.getPlayer().getName())) return;
        new BukkitRunnable() {
            @Override
            public void run() {
                if(!event.getPlayer().getOpenInventory().getTitle().equalsIgnoreCase("crafting")) return;
                Bukkit.getScheduler().cancelTask(tasks.get(event.getPlayer().getName()));
                tasks.remove(event.getPlayer().getName());
            }
        }.runTaskLater(Main.getPlugin(Main.class), 5);

    }
    */
    private String getInv(Player player) {
        return ChatColor.stripColor(player.getOpenInventory().getTitle()).toLowerCase();
    }
    @EventHandler()
    public static void onClick(InventoryClickEvent event) {

        if(!guimanager.getInventories().contains(event.getInventory())) return;
        if(event.getCurrentItem() == null) return;
        if(event.getInventory().equals(guimanager.getEChest()) || event.getInventory().equals(guimanager.getChest())) {event.setCancelled(true);}
        if(event.getCurrentItem().getType() == Material.AIR) return;
        if(!event.getCurrentItem().getItemMeta().hasLore()) return;
        event.setCancelled(true);

        if(event.getCurrentItem().getItemMeta().getDisplayName().contains("Potion effects")) {
            guimanager.potsinv(name.get(event.getWhoClicked().getName()));
            event.getWhoClicked().openInventory(guimanager.getPotInv());
            openInv.put(event.getWhoClicked().getName(), "Potion");
            return;
        }

        if(event.getCurrentItem().getItemMeta().getDisplayName().contains("Back")) {
            guimanager.maininv(name.get(event.getWhoClicked().getName()));
            event.getWhoClicked().openInventory(guimanager.getMain());
            openInv.put(event.getWhoClicked().getName(), "Main");
            return;
        }

        if(event.getCurrentItem().getItemMeta().getDisplayName().contains("Permissions")) {
            guimanager.permInv(name.get(event.getWhoClicked().getName()));
            event.getWhoClicked().openInventory(guimanager.getPermInv());
            openInv.put(event.getWhoClicked().getName(), "Perm");
            return;
        }

        if(event.getCurrentItem().getItemMeta().getDisplayName().contains("Player Statistics") && !event.getCurrentItem().getItemMeta().getDisplayName().contains("page 2")) {
            guimanager.statsInv1(name.get(event.getWhoClicked().getName()));
            event.getWhoClicked().openInventory(guimanager.getStatInv1());
            openInv.put(event.getWhoClicked().getName(), "Stat1");
            return;
        }

        if(event.getCurrentItem().getItemMeta().getDisplayName().contains("Player Statistics page 2")) {
            guimanager.statsInv2(name.get(event.getWhoClicked().getName()));
            event.getWhoClicked().openInventory(guimanager.getStatInv2());
            openInv.put(event.getWhoClicked().getName(), "Stat2");
            return;
        }

        if(event.getCurrentItem().getItemMeta().getDisplayName().contains("See the contents of the inventory a player is currently viewing")) {
            guimanager.chest(name.get(event.getWhoClicked().getName()));
            event.getWhoClicked().openInventory(guimanager.getChest());
            openInv.put(event.getWhoClicked().getName(), "CurInv");
            return;
        }

        if(event.getCurrentItem().getItemMeta().getDisplayName().contains("See the contents of a players ender chest")) {
            guimanager.echest(name.get(event.getWhoClicked().getName()));
            event.getWhoClicked().openInventory(guimanager.getEChest());
            openInv.put(event.getWhoClicked().getName(), "echest");
            return;
        }

        if(event.getInventory().equals(guimanager.getMain()) && event.getCurrentItem().getType().equals(Material.FILLED_MAP)) {
            Player toT = Bukkit.getPlayerExact(name.get(event.getWhoClicked().getName()));
            event.getWhoClicked().teleport(toT.getLocation());
            event.getWhoClicked().sendMessage(ChatColor.GREEN + "You have been teleported to " + ChatColor.GOLD + toT.getName());
        }

    }




}
