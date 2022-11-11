package skwasp.wasp.Elements.Events;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Literal;
import ch.njol.skript.lang.SkriptEvent;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.registrations.EventValues;
import ch.njol.skript.util.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.checkerframework.checker.nullness.qual.Nullable;
import skwasp.wasp.Bungee.SeeChannel;

public class ChannelReceive extends SkriptEvent {

    static {
        Skript.registerEvent("Channel Receive", ChannelReceive.class, SeeChannel.class, "Channel Receive");
        // get Channel class
        EventValues.registerEventValue(SeeChannel.class, Player.class, new Getter<Player, SeeChannel>() {
            @Override
            public Player get(SeeChannel e) {
                // get player from string
                String p = SeeChannel.playerName;
                return Bukkit.getServer().getPlayer(p);
            }
        }, 0);
    }


    @Override
    public boolean init(Literal<?>[] args, int matchedPattern, SkriptParser.ParseResult parseResult) {
        return true;
    }

    @Override
    public boolean check(Event e) {
        return true;
    }

    @Override
    public String toString(@Nullable Event e, boolean debug) {
        return "";
    }
    // get this
    public static Class getEventClass() {
        return SeeChannel.class;
    }
}