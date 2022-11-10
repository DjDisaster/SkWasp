package skwasp.wasp.Bungee;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class BungeeHook {
    private static HashMap<String, Double> playercount = new HashMap<>();
    private static HashMap<String, OfflinePlayer[]> playerlist = new HashMap<>();
    public static String[] serverlist;
    public static void setPlayercount(int playercount, String server) {
        BungeeHook.playercount.put(server, (double) playercount);
    }
    public static int getPlayercount(String server) {
        return BungeeHook.playercount.get(server).intValue();
    }

    public static OfflinePlayer[] getPlayerlist(String server) {
        System.out.println("PlayerList Requested! " + playerlist);
        return playerlist.get(server);
    }
    public static void setPlayerlist(OfflinePlayer[] playerlist, String server) {
        BungeeHook.playerlist.put(server, playerlist);
    }

    public static String[] getServerlist() {
        System.out.println("PlayerList Requested! " + serverlist);
        return serverlist;
    }
    public static void setServerlist(String[] serverlist) {
        BungeeHook.serverlist = serverlist;
    }
}