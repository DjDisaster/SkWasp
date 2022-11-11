package skwasp.wasp.Elements.Expressions;

import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.util.SimpleExpression;
import org.bukkit.event.Event;


import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;
import org.checkerframework.checker.nullness.qual.Nullable;
import skwasp.wasp.Bungee.BungeeHook;

public class Bungee_Total extends SimpleExpression<Integer> {

    static {
        Skript.registerExpression(Bungee_Total.class, Integer.class, ExpressionType.SIMPLE, "[the] bungee[s] total [of %-string%]");
    }
    private Expression<String> server;

    @Override
    public Class<? extends Integer> getReturnType() {
        return Integer.class;
    }

    @Override
    public boolean isSingle() {
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
        server = (Expression<String>) exprs[0];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        return "bungee total of " + (this.server != null ? this.server.toString(event,debug) : " all servers");
    }

    @Override
    @Nullable
    protected Integer[] get(Event e) {
        if (this.server == null) {
            return new Integer[]{BungeeHook.getPlayercount("ALL")};
        }
        return new Integer[]{BungeeHook.getPlayercount(server.getSingle(e))};
    }
}