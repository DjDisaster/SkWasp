package skwasp.wasp.Bungee;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

import java.util.HashMap;

public class SeeChannel extends Event implements Listener {
    private static final HandlerList HANDLERS = new HandlerList();
    private String message;
    private String playerName;
    private String getChannel;
    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public SeeChannel(String playerName, String getChannel, String message) {
        this.playerName = playerName;
        this.getChannel = getChannel;
        this.message = message;
    }
    public String GetStuff() {
        HashMap<String, String> map = new HashMap<>();
        map.put("playerName", playerName);
        map.put("getChannel", getChannel);
        map.put("message", message);
        return "test";
    }
}
