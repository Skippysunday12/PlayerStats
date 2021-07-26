package me.Skippysunday12.guimanagers;

import org.bukkit.Bukkit;

public class GuiSetup {
    private String versionRaw = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
    private String versionString = versionRaw.substring(3, 5);
    private int version = 0;
    public Guimanager guimanager;
    public GuiSetup(){

        if(versionString.substring(1).equals("_")) {
            version = Integer.parseInt(versionString.substring(0, 1));
        }
        else {
            version = Integer.parseInt(versionString);
        }

        if(version >= 13) {
            guimanager = new GuiManager_1_13_Plus();
        }

        else if(version >= 9) {
            guimanager = new GuiManager_1_11();
        }

        else if(version >= 8) {
            guimanager = new GuiManager_1_8();
        }

        else {
            Bukkit.getLogger().info("[PlayerStats] Incompatable version for GUI!");
        }



    }

    public Guimanager getManager() {return guimanager;}

}
