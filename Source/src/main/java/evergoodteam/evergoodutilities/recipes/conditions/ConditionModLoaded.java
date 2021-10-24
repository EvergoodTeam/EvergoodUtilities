package evergoodteam.evergoodutilities.recipes.conditions;


import com.google.gson.JsonObject;

import net.minecraftforge.common.crafting.IConditionFactory;
import net.minecraftforge.common.crafting.JsonContext;
import net.minecraftforge.fml.common.Loader;

import java.util.function.BooleanSupplier;


public class ConditionModLoaded implements IConditionFactory { //  Used in _factories.json

    @Override
    public BooleanSupplier parse(JsonContext context, JsonObject json) {
            return () -> Loader.isModLoaded(json.get("mod").getAsString());
    }
}
