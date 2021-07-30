package me.Skippysunday12.NMS;

import me.Skippysunday12.playerstats.PlayerStats;
import net.jitse.npclib.NPCLib;
import net.jitse.npclib.api.NPC;
import net.jitse.npclib.api.skin.Skin;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.jetbrains.annotations.NotNull;

public class SkinManager {

    private static NPCLib lib = new NPCLib(PlayerStats.instance);
    private static HashMap<Player, ArrayList<NPC>> npcs = new HashMap<>();
    private SkinManager(){}

    public static void spawnSkin(String name, @NotNull Player player) {
        Location loc = player.getLocation();

        String texture = "";
        String signature = "";
        try {
            URL url = new URL("https://api.mojang.com/users/profiles/minecraft/" + name);
            InputStreamReader reader = new InputStreamReader(url.openStream());
            String uuid = new JsonParser().parse(reader).getAsJsonObject().get("id").getAsString();

            URL url2 = new URL("https://sessionserver.mojang.com/session/minecraft/profile/" + uuid +
                    "?unsigned=false");
            InputStreamReader r = new InputStreamReader(url2.openStream());
            JsonObject property = new JsonParser().parse(r).getAsJsonObject().get("properties").getAsJsonArray().get(0).getAsJsonObject();

            texture = property.get("value").getAsString();
            signature = property.get("signature").getAsString();

        }catch(Exception e) {
            player.sendMessage(ChatColor.AQUA + "Something went wrong getting the skin! Check the spelling and try again in a minute!");
        }

        List<String> lines = new ArrayList<>();
        lines.add(name);
        NPC npc = lib.createNPC(lines);
        Skin skin = new Skin(texture, signature);
        npc.setSkin(skin);
        npc.setLocation(player.getLocation());
        npc.create();
        npc.show(player);

        if(!npcs.containsKey(player)) npcs.put(player, new ArrayList<NPC>());
        npcs.get(player).add(npc);
    }

    public static boolean removeSkins(Player player) {
        if(!npcs.containsKey(player)) return false;

        for(NPC n : npcs.get(player)) {
            n.hide(player);
            n.destroy();
        }

        return true;
    }
}
