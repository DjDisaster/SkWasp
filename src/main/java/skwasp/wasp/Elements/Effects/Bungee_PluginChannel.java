package skwasp.wasp.Elements.Effects;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import com.google.common.base.Strings;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.checkerframework.checker.nullness.qual.Nullable;
import skwasp.wasp.Bungee.BungeeOut;

public class Bungee_PluginChannel extends Effect {
    static {
        Skript.registerEffect(Bungee_PluginChannel.class, "Pluginmessage %string% on [bungee] channel %string%");
    }

    private Expression<String> text;
    private Expression<String> string;

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] expressions, int matchedPattern, Kleenean isDelayed, SkriptParser.ParseResult parser) {
        this.text = (Expression<String>) expressions[0];
        this.string = (Expression<String>) expressions[1];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        return "Sent a message on the channel + " + string.toString(event, debug) + " with text " + text.toString(event, debug);
    }

    @Override
    protected void execute(Event event) {
        String message = text.getSingle(event);
        String channel = string.getSingle(event);
        if (Strings.isNullOrEmpty(message)) {
            Bukkit.broadcastMessage("Message is empty" + message + " " + channel);
            return;
        }
        Bukkit.broadcastMessage("Sending message on channel " + channel + " with text " + message);
        BungeeOut.sendChannel(channel, message);
    }
}
