package skwasp.wasp.Bungee;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;
import skwasp.wasp.Wasp;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

public class BungeeTotal {
    public static void requestCount(String server) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("PlayerCount");
        out.writeUTF(server);
        Wasp.server().sendPluginMessage(Wasp.getInstance(), "BungeeCord", out.toByteArray());
    }
    public static void requestPlayers(String server) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("PlayerList");
        out.writeUTF(server);
        Wasp.server().sendPluginMessage(Wasp.getInstance(), "BungeeCord", out.toByteArray());
    }
    public static void requestServers() {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("GetServers");
        Wasp.server().sendPluginMessage(Wasp.getInstance(), "BungeeCord", out.toByteArray());
    }
    // register channel
    public static void registerChannel() {
        Wasp.server().getMessenger().registerOutgoingPluginChannel(Wasp.getInstance(), "BungeeCord");
        Wasp.server().getMessenger().registerIncomingPluginChannel(Wasp.getInstance(), "BungeeCord", new PluginMessageListener() {
            @Override
            public void onPluginMessageReceived(String channel, Player player, byte[] message) {

                String msg = new String(message, StandardCharsets.UTF_8);
                Bukkit.getPluginManager().callEvent(new SeeChannel(player.getName(), channel, message.toString()));
                msg = msg.replaceAll("[^A-Za-z0-9]", "");
                // message contains PlayerCount
                if (msg.contains("PlayerCount")) {
                 System.out.println("PlayerCount: " + msg);
                  ByteArrayDataInput in = ByteStreams.newDataInput(message);
                    in.readUTF();
                    String server = in.readUTF();
                    int count = in.readInt();
                    BungeeHook.setPlayercount(count, server);
                }
                // message contains PlayerList run setPlayerlist using OfflinePlayer[] type
                if (msg.contains("PlayerList")) {
                    System.out.println("PlayerList: " + msg);
                    ByteArrayDataInput in = ByteStreams.newDataInput(message);
                    in.readUTF();
                    String server = in.readUTF();
                    String[] players = in.readUTF().split(", ");
                    OfflinePlayer[] playerlist = new OfflinePlayer[players.length];
                    System.out.println("player" + Arrays.toString(players));
                    for (int i = 0; i < players.length; i++) {

                        // player name to UUID
                        UUID uuid = UUID.nameUUIDFromBytes(("OfflinePlayer:" + players[i]).getBytes(StandardCharsets.UTF_8));
                        playerlist[i] = Bukkit.getOfflinePlayer(uuid);
                    }
                    BungeeHook.setPlayerlist(playerlist, server);
                }
                // message contains GetServers
                if (msg.contains("GetServers")) {
                    System.out.println("GetServers: " + msg);
                    ByteArrayDataInput in = ByteStreams.newDataInput(message);
                    in.readUTF();
                    String[] servers = in.readUTF().split(", ");
                    BungeeHook.setServerlist(servers);
                    Bukkit.getLogger().info("Servers: " + Arrays.toString(servers));
                    System.out.println("Servers: " + Arrays.toString(servers));
                }
                System.out.println("Channel: " + "n/a");
                System.out.println("Player: " + player.getName());
                System.out.println("Message: " + msg);
            }
        });
    }
}
