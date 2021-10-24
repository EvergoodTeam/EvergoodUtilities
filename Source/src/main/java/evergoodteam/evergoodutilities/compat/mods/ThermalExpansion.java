package evergoodteam.evergoodutilities.compat.mods;


import cofh.thermalexpansion.util.managers.machine.PrecipitatorManager;

import evergoodteam.evergoodutilities.init.BlockInit;
import evergoodteam.evergoodutilities.init.FluidInit;
import evergoodteam.evergoodutilities.init.ItemInit;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;


public class ThermalExpansion {

    public static void addGlacialPrecipitator(){

        PrecipitatorManager.addRecipe(100, new ItemStack(ItemInit.NUGGET_MERCURY), new FluidStack(FluidInit.MERCURY_FLUID, 16));
        PrecipitatorManager.addRecipe(900, new ItemStack(ItemInit.INGOT_MERCURY), new FluidStack(FluidInit.MERCURY_FLUID, 144));
        PrecipitatorManager.addRecipe(8100, new ItemStack(BlockInit.BLOCK_MERCURY), new FluidStack(FluidInit.MERCURY_FLUID, 1296));
    }
}
