package me.Skippysunday12.mysql;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.event.player.PlayerToggleSprintEvent;

import me.Skippysunday12.playerstats.PlayerStats;


public class SQLdata implements Listener{

    @EventHandler()
    public void updateMainTable(PlayerJoinEvent event) {
        if(!PlayerStats.sqlSetup) return;
        if(SQLSetup.hasEntry(event.getPlayer().getName())){SQLSetup.updateMains(event.getPlayer().getName());}else SQLSetup.createEntry(event.getPlayer());
    }

    @EventHandler()
    public void updateBed(PlayerBedEnterEvent event) {
        if(!PlayerStats.sqlSetup) return;
        Player player = event.getPlayer();
        SQLSetup.updateMains(player.getName());
    }

    @EventHandler()
    public void respawnUpdate(PlayerToggleSneakEvent event) {
        if(!PlayerStats.sqlSetup) return;
        SQLSetup.updateMains(event.getPlayer().getName());
    }

    @EventHandler()
    public void sprintUpdate(PlayerToggleSprintEvent event) {
        if(!PlayerStats.sqlSetup) return;
        SQLSetup.updateMains(event.getPlayer().getName());
    }

    @EventHandler()
    public void interactEvent(PlayerInteractEvent event) {
        if(!PlayerStats.sqlSetup) return;
        if(SQLSetup.interact) SQLSetup.updateMains(event.getPlayer().getName());
    }


}
