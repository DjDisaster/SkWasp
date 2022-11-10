package skwasp.wasp.Events;

import ch.njol.skript.Skript;
import ch.njol.skript.entity.EntityData;
import ch.njol.skript.lang.Literal;
import ch.njol.skript.lang.SkriptEvent;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.registrations.EventValues;
import ch.njol.skript.util.Getter;
import ch.njol.util.Checker;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityAirChangeEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.messaging.PluginMessageListener;
import org.checkerframework.checker.nullness.qual.Nullable;
import skwasp.wasp.Bungee.SeeChannel;
import skwasp.wasp.Bungee.SendChannel;

import java.math.BigInteger;

public class ChannelReceive extends SkriptEvent {

    static {
        Skript.registerEvent("Channel Receive", ChannelReceive.class, SeeChannel.class, "Channel Receive");
        // get Channel class
        EventValues.registerEventValue(SeeChannel.class, String.class, new Getter<String, SeeChannel>() {
            @Override
            public String get(SeeChannel e) {
                return e.GetStuff();
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

}