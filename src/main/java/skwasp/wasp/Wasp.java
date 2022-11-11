package skwasp.wasp;

import ch.njol.skript.Skript;
import ch.njol.skript.SkriptAddon;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;
import skwasp.wasp.Bungee.BungeeHook;
import skwasp.wasp.Bungee.BungeeTotal;
import skwasp.wasp.Bungee.SeeChannel;
import skwasp.wasp.Bungee.SendChannel;
import skwasp.wasp.Events.Temp;

import java.io.IOException;


public class Wasp extends JavaPlugin {


    SkriptAddon addon;
    public static void UpdateThings() {
        BungeeTotal.requestServers();
        BungeeTotal.requestCount("ALL");
        BungeeTotal.requestPlayers("ALL");
        for (String server : BungeeHook.getServerlist()) {
            BungeeTotal.requestCount(server);
            BungeeTotal.requestPlayers(server);
        }
    }
    public void onEnable() {
        // register the event in SeeChannel.java
        Bukkit.getPluginManager().registerEvents(new SeeChannel(null, null, null), this);
        //Bukkit.getPluginManager().registerEvents(new (), this);
        //
        BungeeTotal.registerChannel();
        addon = Skript.registerAddon(this);
        try {
            //This will register all our syntax for us. Explained below
            addon.loadClasses("skwasp.wasp", "Effects");
            addon.loadClasses("skwasp.wasp", "Expressions");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bukkit.getLogger().info("[ExampleAddon] has been enabled!");

        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                UpdateThings();
            }
        }, 0L, 5L);
    }

    public static Wasp getInstance() {
        return getPlugin(Wasp.class);
    }
    // get server
    public static Server server() {
        return Bukkit.getServer();
    }
    public SkriptAddon getAddonInstance() {
        return addon;
    }

    // check when a player gets damaged

}