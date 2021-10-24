package evergoodteam.evergoodutilities.compat.mods;


import evergoodteam.evergoodutilities.compat.ModLoaded;
import evergoodteam.evergoodutilities.config.Configs;
import evergoodteam.evergoodutilities.init.BlockInit;
import evergoodteam.evergoodutilities.init.FluidInit;
import evergoodteam.evergoodutilities.init.ItemInit;

import evergoodteam.evergoodutilities.util.GetName;
import mekanism.api.MekanismAPI;
import mekanism.api.gas.Gas;
import mekanism.api.gas.GasRegistry;
import mekanism.api.gas.GasStack;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


public class Mekanism {

    public static void addGases(){

        GasRegistry.register(new Gas("zincSlurry", FluidInit.FLUIDS.get(0).getColor()));
        GasRegistry.register(new Gas("palladiumSlurry", FluidInit.FLUIDS.get(1).getColor()));
        GasRegistry.register(new Gas("titaniumSlurry", FluidInit.FLUIDS.get(2).getColor()));
        GasRegistry.register(new Gas("mercurySlurry", FluidInit.FLUIDS.get(3).getColor()));

        GasRegistry.register(new Gas("cleanZincSlurry", 16121343));
        GasRegistry.register(new Gas("cleanPalladiumSlurry", 16578554));
        GasRegistry.register(new Gas("cleanTitaniumSlurry", 10921377));
        GasRegistry.register(new Gas("cleanMercurySlurry", 12237494));
    }

    public static void addEnrichmentChamberRecipe(){

        //Dirty Dust > Dust
        //Shard > Dust
        for(int i=0; i<4; i++){
            MekanismAPI.recipeHelper().addEnrichmentChamberRecipe(new ItemStack(ItemInit.ITEMS.get(i+12)), new ItemStack(ItemInit.ITEMS.get(i+16)));
            MekanismAPI.recipeHelper().addEnrichmentChamberRecipe(new ItemStack(BlockInit.BLOCKS.get(i+4)), new ItemStack(ItemInit.ITEMS.get(i+16), 2));
        }

        /*

        for(int i=0; i<3; i++){

        }*/

        if(ModLoaded.id("extraplanets")){
            MekanismAPI.recipeHelper().addEnrichmentChamberRecipe(new ItemStack(Block.getBlockFromName("extraplanets:neptune"), 1, 6), new ItemStack(ItemInit.DUST_ZINC, 2));
            MekanismAPI.recipeHelper().addEnrichmentChamberRecipe(new ItemStack(Block.getBlockFromName("extraplanets:jupiter"), 1, 6), new ItemStack(ItemInit.DUST_PALLADIUM, 2));
            MekanismAPI.recipeHelper().addEnrichmentChamberRecipe(new ItemStack(Block.getBlockFromName("extraplanets:mercury"), 1, 6), new ItemStack(ItemInit.DUST_MERCURY, 2));
        }

        if(Configs.compat.Mod("Thermal")){
            MekanismAPI.recipeHelper().addEnrichmentChamberRecipe(new ItemStack(BlockInit.ORE_CINNABAR), new ItemStack(Item.getByNameOrId("thermalfoundation:material"), 2, 866));
        }
    }

    public static void addCombinerRecipe(){

        //Dust > Ore
        for(int i=0; i<3; i++){
            MekanismAPI.recipeHelper().addCombinerRecipe(new ItemStack(ItemInit.ITEMS.get(i+16), 8), new ItemStack(Blocks.COBBLESTONE), new ItemStack(BlockInit.BLOCKS.get(i+4)));
        }
    }

    public static void addCrusherRecipe(){

        //Ingot > Dust
        //Clump > Dirty Dust
        for(int i=0; i<4; i++){
            MekanismAPI.recipeHelper().addCrusherRecipe(new ItemStack(ItemInit.ITEMS.get(i+24)), new ItemStack(ItemInit.ITEMS.get(i+16)));
            MekanismAPI.recipeHelper().addCrusherRecipe(new ItemStack(ItemInit.ITEMS.get(i+8)), new ItemStack(ItemInit.ITEMS.get(i+12)));
        }
    }

    public static void addPurificationChamberRecipe(){

        //Shard > Clump
        for(int i=0; i<4; i++){
            MekanismAPI.recipeHelper().addPurificationChamberRecipe(new ItemStack(ItemInit.ITEMS.get(i+4)), new ItemStack(ItemInit.ITEMS.get(i+8)));
        }

        //Ore > Clump
        for(int i=0; i<3; i++){
            MekanismAPI.recipeHelper().addPurificationChamberRecipe(new ItemStack(BlockInit.BLOCKS.get(i+4)), new ItemStack(ItemInit.ITEMS.get(i+8), 3));
        }

        if(ModLoaded.id("thaumcraft")){
            MekanismAPI.recipeHelper().addPurificationChamberRecipe(new ItemStack(BlockInit.ORE_CINNABAR, 1), new ItemStack(Item.getByNameOrId("thaumcraft:cluster"), 3, 6));
        }

        if(ModLoaded.id("extraplanets")){
            MekanismAPI.recipeHelper().addPurificationChamberRecipe(new ItemStack(Block.getBlockFromName("extraplanets:neptune"), 1, 6), new ItemStack(ItemInit.CLUMP_ZINC, 3));
            MekanismAPI.recipeHelper().addPurificationChamberRecipe(new ItemStack(Block.getBlockFromName("extraplanets:jupiter"), 1, 6), new ItemStack(ItemInit.CLUMP_PALLADIUM, 3));
            MekanismAPI.recipeHelper().addPurificationChamberRecipe(new ItemStack(Block.getBlockFromName("extraplanets:mercury"), 1, 6), new ItemStack(ItemInit.CLUMP_MERCURY, 3));
        }
    }

    public static void addChemicalInjectionChamberRecipe(){

        //Crystal > Shard
        //Ore > Shard
        for(int i=0; i<4; i++){
            MekanismAPI.recipeHelper().addChemicalInjectionChamberRecipe(new ItemStack(ItemInit.ITEMS.get(i)), GasRegistry.getGas("hydrogenchloride"), new ItemStack(ItemInit.ITEMS.get(i+4)));
            MekanismAPI.recipeHelper().addChemicalInjectionChamberRecipe(new ItemStack(BlockInit.BLOCKS.get(i+4)), GasRegistry.getGas("hydrogenchloride"), new ItemStack(ItemInit.ITEMS.get(i+4), 4));
        }

        if(ModLoaded.id("extraplanets")){
            MekanismAPI.recipeHelper().addChemicalInjectionChamberRecipe(new ItemStack(Block.getBlockFromName("extraplanets:neptune"), 1, 6), GasRegistry.getGas("hydrogenchloride"), new ItemStack(ItemInit.SHARD_ZINC, 4));
            MekanismAPI.recipeHelper().addChemicalInjectionChamberRecipe(new ItemStack(Block.getBlockFromName("extraplanets:jupiter"), 1, 6), GasRegistry.getGas("hydrogenchloride"), new ItemStack(ItemInit.SHARD_PALLADIUM, 4));
            MekanismAPI.recipeHelper().addChemicalInjectionChamberRecipe(new ItemStack(Block.getBlockFromName("extraplanets:mercury"), 1, 6), GasRegistry.getGas("hydrogenchloride"), new ItemStack(ItemInit.SHARD_MERCURY, 4));
        }
    }

    public static void addChemicalDissolutionChamberRecipe(){

        for(int i=0; i<3; i++){
            MekanismAPI.recipeHelper().addChemicalDissolutionChamberRecipe(new ItemStack(BlockInit.BLOCKS.get(i+4)), new GasStack(GasRegistry.getGas(GetName.metalUncapital(ItemInit.ITEMS.get(i).getRegistryName().toString())+"Slurry"), 1000));
        }
        //MekanismAPI.recipeHelper().addChemicalDissolutionChamberRecipe(new ItemStack(BlockInit.ORE_ZINC), new GasStack(GasRegistry.getGas("zincSlurry"), 1000));
        //MekanismAPI.recipeHelper().addChemicalDissolutionChamberRecipe(new ItemStack(BlockInit.ORE_PALLADIUM), new GasStack(GasRegistry.getGas("palladiumSlurry"), 1000));

        if(ModLoaded.id("extraplanets")){
            MekanismAPI.recipeHelper().addChemicalDissolutionChamberRecipe(new ItemStack(Block.getBlockFromName("extraplanets:neptune"), 1, 6), new GasStack(GasRegistry.getGas("zincSlurry"), 1000));
            MekanismAPI.recipeHelper().addChemicalDissolutionChamberRecipe(new ItemStack(Block.getBlockFromName("extraplanets:jupiter"), 1, 6), new GasStack(GasRegistry.getGas("palladiumSlurry"), 1000));
            MekanismAPI.recipeHelper().addChemicalDissolutionChamberRecipe(new ItemStack(Block.getBlockFromName("extraplanets:mercury"), 1, 6), new GasStack(GasRegistry.getGas("mercurySlurry"), 1000));

        }
    }

    public static void addChemicalWasherRecipe(){

        MekanismAPI.recipeHelper().addChemicalWasherRecipe(new GasStack(GasRegistry.getGas("zincSlurry"), 1), new GasStack(GasRegistry.getGas("cleanZincSlurry"), 1));
        MekanismAPI.recipeHelper().addChemicalWasherRecipe(new GasStack(GasRegistry.getGas("palladiumSlurry"), 1), new GasStack(GasRegistry.getGas("cleanPalladiumSlurry"), 1));
        MekanismAPI.recipeHelper().addChemicalWasherRecipe(new GasStack(GasRegistry.getGas("mercurySlurry"), 1), new GasStack(GasRegistry.getGas("cleanMercurySlurry"), 1));
    }

    public static void addChemicalCrystallizerRecipe(){

        MekanismAPI.recipeHelper().addChemicalCrystallizerRecipe(new GasStack(GasRegistry.getGas("cleanZincSlurry"), 200), new ItemStack(ItemInit.CRYSTAL_ZINC));
        MekanismAPI.recipeHelper().addChemicalCrystallizerRecipe(new GasStack(GasRegistry.getGas("cleanPalladiumSlurry"), 200), new ItemStack(ItemInit.CRYSTAL_PALLADIUM));
        MekanismAPI.recipeHelper().addChemicalCrystallizerRecipe(new GasStack(GasRegistry.getGas("cleanMercurySlurry"), 200), new ItemStack(ItemInit.CRYSTAL_MERCURY));
    }
}
