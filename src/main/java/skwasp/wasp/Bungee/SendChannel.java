package skwasp.wasp.Bungee;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import skwasp.wasp.Wasp;

public class SendChannel {
    public static void sendChannel(String channel, String subchannel, String message) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF(subchannel);
        out.writeUTF(message);
        Wasp.server().sendPluginMessage(Wasp.getInstance(), channel, out.toByteArray());
    }
}
