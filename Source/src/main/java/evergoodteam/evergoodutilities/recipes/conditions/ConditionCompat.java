package evergoodteam.evergoodutilities.recipes.conditions;


import com.google.gson.JsonObject;

import evergoodteam.evergoodutilities.config.Configs;

import net.minecraftforge.common.crafting.IConditionFactory;
import net.minecraftforge.common.crafting.JsonContext;

import java.util.function.BooleanSupplier;


public class ConditionCompat implements IConditionFactory { // Used in _factories.json

    @Override
    public BooleanSupplier parse(JsonContext context, JsonObject json) {
            return () -> Configs.compat.Mod(json.get("mod").getAsString());
    }
}
