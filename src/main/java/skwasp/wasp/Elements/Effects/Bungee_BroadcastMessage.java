package skwasp.wasp.Elements.Effects;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.Event;
import org.checkerframework.checker.nullness.qual.Nullable;
import skwasp.wasp.Bungee.BungeeHook;
import skwasp.wasp.Bungee.BungeeOut;
import skwasp.wasp.Bungee.BungeeTotal;

public class Bungee_BroadcastMessage extends Effect {
    static {
        Skript.registerEffect(Bungee_SendMessage.class, "bungee broadcast %string%");
    }

    private Expression<String> text;

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        return "";//""Send bungee message to " + players.toString(event, debug) + " with text " + text.toString(event, debug);
    }

    @Override
    protected void execute(Event event) {
        String message = text.getSingle(event);
        for (OfflinePlayer player: BungeeHook.getPlayerlist("All")){
            BungeeOut.sendMessage(player.getName(), message);
        }

    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] expressions, int matchedPattern, Kleenean isDelayed, SkriptParser.ParseResult parser) {
        this.text = (Expression<String>) expressions[0];
        return true;
    }
}
