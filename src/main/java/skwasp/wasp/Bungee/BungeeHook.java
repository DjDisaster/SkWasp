package skwasp.wasp.Bungee;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class BungeeHook {
    private static HashMap<String, Double> playercount = new HashMap<>();
    public static OfflinePlayer[] playerlist;
    public static String[] serverlist;
    public static void setPlayercount(int playercount, String server) {
        BungeeHook.playercount.put(server, (double) playercount);
    }

    public static int getPlayercount(String server) {
        return BungeeHook.playercount.get(server).intValue();
    }

    public static OfflinePlayer[] getPlayerlist() {
        System.out.println("PlayerList Requested! " + playerlist);
        return playerlist;
    }
    public static void setPlayerlist(OfflinePlayer[] playerlist) {
        BungeeHook.playerlist = playerlist;
    }

    public static String[] getServerlist() {
        System.out.println("PlayerList Requested! " + serverlist);
        return serverlist;
    }
    public static void setServerlist(String[] serverlist) {
        BungeeHook.serverlist = serverlist;
    }
}