package skwasp.wasp.Bungee;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import skwasp.wasp.Wasp;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

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
        out.writeUTF("Forward"); // So BungeeCord knows to forward it
        out.writeUTF("ALL");
        out.writeUTF(subchannel);
        ByteArrayOutputStream msgbytes = new ByteArrayOutputStream();
        DataOutputStream msgout = new DataOutputStream(msgbytes);
        try {
            msgout.writeUTF(message);
            msgout.writeShort(123);
        } catch (IOException exception){
            exception.printStackTrace();
        }
    }
}
