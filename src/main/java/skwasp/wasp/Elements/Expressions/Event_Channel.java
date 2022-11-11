package skwasp.wasp.Elements.Expressions;

import ch.njol.skript.Skript;
import ch.njol.skript.doc.Events;
import ch.njol.skript.expressions.base.EventValueExpression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.util.Utils;
import org.bukkit.event.Event;
import org.checkerframework.checker.nullness.qual.Nullable;
import skwasp.wasp.Bungee.SeeChannel;
import skwasp.wasp.Elements.Events.ChannelReceive;

public class Event_Channel extends EventValueExpression<String> {

    static {
        Skript.registerExpression(Event_Channel.class, String.class, ExpressionType.SIMPLE, "bungee-channel");
    }

    public Event_Channel() {
        super(String.class);
    }


    @Override
    public boolean init() {
        if (!getParser().isCurrentEvent(ChannelReceive.getEventClass())) {
            Skript.error("There's no bla bla bla in " + Utils.a(getParser().getCurrentEventName()) + " event");
            return false;
        }
        return true;
    }

    @Override
    protected @Nullable String[] get(Event e) {
        return new String[] {
                SeeChannel.getChannel
        };
    }

    @Override
    public String toString(@Nullable Event e, boolean debug) {
        return "bungee-channel";
    }
}