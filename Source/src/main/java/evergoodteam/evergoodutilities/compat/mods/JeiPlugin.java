package evergoodteam.evergoodutilities.compat.mods;


import evergoodteam.evergoodutilities.config.Configs;
import evergoodteam.evergoodutilities.init.FluidInit;
import evergoodteam.evergoodutilities.init.ItemInit;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;

import javax.annotation.Nonnull;


@JEIPlugin
public class JeiPlugin implements IModPlugin{

    @Override
    public void register(@Nonnull IModRegistry registry) {

        for(int i = 0; i< ItemInit.ITEMS.size(); i++){
            if(ItemInit.ITEMS.get(i).getUnlocalizedName().contains("icon")){
                registry.getJeiHelpers().getIngredientBlacklist().addIngredientToBlacklist(new ItemStack(ItemInit.ITEMS.get(i)));
            }
        }

        if(Configs.compat.Mod("TinkersConstruct")){
            if(Configs.additions.Fluids){
                registry.getJeiHelpers().getIngredientBlacklist().addIngredientToBlacklist(new FluidStack(FluidInit.ZINC_FLUID, 1));
                registry.getJeiHelpers().getIngredientBlacklist().addIngredientToBlacklist(FluidUtil.getFilledBucket(new FluidStack(FluidInit.ZINC_FLUID,1)));
            }
        }
    }
}
