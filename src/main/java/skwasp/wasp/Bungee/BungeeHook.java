package skwasp.wasp.Bungee;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class BungeeHook {
    private static HashMap<String, Integer> playercount = new HashMap<>();
    private static HashMap<String, OfflinePlayer[]> playerlist = new HashMap<>();
    public static String[] serverlist;
    public static void setPlayercount(int playercount, String server) {
        BungeeHook.playercount.put(server, playercount);
    }
    public static int getPlayercount(String server) {
        return playercount.get(server);
    }



    public static OfflinePlayer[] getPlayerlist(String server) {
        return playerlist.get(server);
    }
    public static void setPlayerlist(OfflinePlayer[] playerlist, String server) {
        BungeeHook.playerlist.put(server, playerlist);
    }



    public static String[] getServerlist() {
        return serverlist;
    }
    public static void setServerlist(String[] serverlist) {
        BungeeHook.serverlist = serverlist;
    }
}