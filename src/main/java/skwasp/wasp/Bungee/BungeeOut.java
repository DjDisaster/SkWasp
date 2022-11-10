package skwasp.wasp.Bungee;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import skwasp.wasp.Wasp;

public class BungeeOut {
    public static void sendMessage(String player, String message) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Message");
        out.writeUTF(player);
        out.writeUTF(message);
        Wasp.server().sendPluginMessage(Wasp.getInstance(), "BungeeCord", out.toByteArray());
    }
    public static void sendChannel(String subchannel, String message) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF(subchannel);
        out.writeUTF(message);
        Wasp.server().sendPluginMessage(Wasp.getInstance(), "BungeeCord", out.toByteArray());
    }
}
