package evergoodteam.evergoodutilities.compat.mods;


import evergoodteam.evergoodutilities.compat.ModLoaded;
import evergoodteam.evergoodutilities.init.BlockInit;
import evergoodteam.evergoodutilities.init.FluidInit;
import evergoodteam.evergoodutilities.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;


public class TinkersConstruct {


    public static void addMeltingRecipe() {

        for(int i=0; i<FluidInit.FLUIDS.size(); i++){
            if(FluidInit.FLUIDS.get(i).getUnlocalizedName().contains("zinc") || FluidInit.FLUIDS.get(i).getUnlocalizedName().contains("mercury")){
                continue;
            }
            if(FluidInit.FLUIDS.get(i).getUnlocalizedName().contains("astralstarmetal")){
                TinkerSmeltery.registerOredictMeltingCasting(FluidInit.FLUIDS.get(i), "AstralStarmetal");
            }
            else{
                TinkerSmeltery.registerOredictMeltingCasting(FluidInit.FLUIDS.get(i), FluidInit.FLUIDS.get(i).getLocalizedName(new FluidStack(FluidInit.FLUIDS.get(i), 1)).replaceAll("Molten ", ""));
            }
        }

        TinkerRegistry.registerMelting(ItemInit.DUST_MERCURY, FluidInit.MERCURY_FLUID, 144);
        TinkerRegistry.registerMelting(ItemInit.NUGGET_MERCURY, FluidInit.MERCURY_FLUID, 36);
        TinkerRegistry.registerMelting(ItemInit.INGOT_MERCURY, FluidInit.MERCURY_FLUID, 144);
        TinkerRegistry.registerMelting(BlockInit.BLOCK_MERCURY, FluidInit.MERCURY_FLUID, 1296);
        if(ModLoaded.id("extraplanets")) {
            TinkerRegistry.registerMelting(new ItemStack(Block.getBlockFromName("extraplanets:mercury"), 1, 6), FluidInit.MERCURY_FLUID, 288);
        }
    }

    public static void addAlloyRecipe(){

        //TinkerRegistry.registerAlloy(new FluidStack(TinkerFluids.brass, 3), new FluidStack(TinkerFluids.copper, 2), new FluidStack(FluidInit.ZINC_FLUID, 1));
    }

    public static void addCastingRecipe(){

    }
}
