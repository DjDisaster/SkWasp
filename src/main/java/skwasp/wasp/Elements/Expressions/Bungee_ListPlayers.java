package skwasp.wasp.Elements.Expressions;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.Event;

import org.checkerframework.checker.nullness.qual.Nullable;
import skwasp.wasp.Bungee.BungeeHook;

public class Bungee_ListPlayers extends SimpleExpression<OfflinePlayer> {
    static {
        Skript.registerExpression(Bungee_ListPlayers.class, OfflinePlayer.class, ExpressionType.SIMPLE, "[the] bungee[s] players [of %-string%]");
    }

    private Expression<String> server;

    @Override
    public Class<? extends OfflinePlayer> getReturnType() {
        return OfflinePlayer.class;
    }

    @Override
    public boolean isSingle() {
        return false;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, SkriptParser.ParseResult parser) {
        server = (Expression<String>) exprs[0];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        return "bungee players of " + (this.server != null ? this.server.toString(event, debug) : " all servers");
    }

    @Override
    protected OfflinePlayer[] get(Event e) {
        if (this.server == null) {
            return BungeeHook.getPlayerlist("ALL");
        }
        return BungeeHook.getPlayerlist(server.getSingle(e));
    }
}
