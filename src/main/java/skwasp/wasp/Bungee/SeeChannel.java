package skwasp.wasp.Bungee;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class SeeChannel extends Event implements Listener {
    private static final HandlerList HANDLERS = new HandlerList();
    public static String message;
    public static String playerName;
    public static String getChannel;
    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public SeeChannel(String playerName, String getChannel, String message) {
        SeeChannel.playerName = playerName;
        SeeChannel.getChannel = getChannel;
        SeeChannel.message = message;
    }
    public static String GetStuff() {
        HashMap<String, String> map = new HashMap<>();
        map.put("playerName", SeeChannel.playerName);
        map.put("getChannel", getChannel);
        map.put("message", message);
        return map.toString();
    }
}
