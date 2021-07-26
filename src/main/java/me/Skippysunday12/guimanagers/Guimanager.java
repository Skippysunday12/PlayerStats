package me.Skippysunday12.guimanagers;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.inventory.Inventory;

public interface Guimanager {

    public Inventory chest = null;
    public Inventory echest = null;
    public List<Inventory> inventories = new ArrayList<Inventory>();
    public Inventory maininv = null;
    public Inventory perminv = null;
    public Inventory statinv1 = null;
    public Inventory statinv2 = null;
    public Inventory potinv = null;

    public void maininv(String pl);
    public void chest(String pl);
    public void echest(String pl);
    public void permInv(String pl);
    public void potsinv(String pl);
    public void statsInv1(String pl);
    public void statsInv2(String pl);
    public Inventory getMain();
    public Inventory getChest();
    public Inventory getEChest();
    public List<Inventory> getInventories();
    public Inventory getPermInv();
    public Inventory getStatInv1();
    public Inventory getStatInv2();
    public Inventory getPotInv();
}
