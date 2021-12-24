package evergoodteam.evergoodutilities.compat.mods;


import evergoodteam.evergoodutilities.compat.ModLoaded;
import evergoodteam.evergoodutilities.init.BlockInit;
import evergoodteam.evergoodutilities.init.FluidInit;
import evergoodteam.evergoodutilities.init.ItemInit;
import evergoodteam.evergoodutilities.util.GetInfo;
import evergoodteam.evergoodutilities.util.GetList;

import mekanism.api.MekanismAPI;
import mekanism.api.gas.Gas;
import mekanism.api.gas.GasRegistry;
import mekanism.api.gas.GasStack;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;

import java.util.List;


public class Mekanism {

    public static void addSlurries(Fluid name, int color){

        GasRegistry.register(new Gas(GetInfo.metalUncapital(name)+"Slurry", color - 15));
        GasRegistry.register(new Gas("clean"+GetInfo.metal(name)+"Slurry", color + 15));
    }

    public static void addSlurries(Fluid name, Fluid color){

        addSlurries(name, color.getColor());
    }

    public static void addGases(){

        for(int i=0; i<4; i++){
            addSlurries(FluidInit.FLUIDS.get(i), FluidInit.FLUIDS.get(i));
        }
    }


    private static List<Item> ORE = GetList.type("ore");
    private static List<Item> DUST = GetList.type("dust");
    private static List<Item> DIRTY = GetList.type("dustDirty");
    private static List<Item> INGOT = GetList.type("ingot");
    private static List<Item> CLUMP = GetList.type("clump");
    private static List<Item> CRYSTAL = GetList.type("crystal");
    private static List<Item> SHARD = GetList.type("shard");


    public static void addEnrichmentChamberRecipe(){

        // Dirty Dust -> Dust
        for(int i=0; i<DIRTY.size(); i++) MekanismAPI.recipeHelper().addEnrichmentChamberRecipe(new ItemStack(DIRTY.get(i)), new ItemStack(GetInfo.findClone(DUST, DIRTY.get(i))));

        // Ore -> 2x Dust
        for(int i=0; i<ORE.size(); i++) {
            if(GetInfo.findClone(DUST, ORE.get(i)) == null) continue;
            MekanismAPI.recipeHelper().addEnrichmentChamberRecipe(new ItemStack(ORE.get(i)), new ItemStack(GetInfo.findClone(DUST, ORE.get(i)), 2));
        }

        MekanismAPI.recipeHelper().addEnrichmentChamberRecipe(new ItemStack(BlockInit.ORE_CINNABAR), new ItemStack(ItemInit.GEM_CINNABAR, 2));

        if(ModLoaded.id("extraplanets")){
            MekanismAPI.recipeHelper().addEnrichmentChamberRecipe(new ItemStack(Block.getBlockFromName("extraplanets:neptune"), 1, 6), new ItemStack(ItemInit.DUST_ZINC, 2));
            MekanismAPI.recipeHelper().addEnrichmentChamberRecipe(new ItemStack(Block.getBlockFromName("extraplanets:jupiter"), 1, 6), new ItemStack(ItemInit.DUST_PALLADIUM, 2));
            MekanismAPI.recipeHelper().addEnrichmentChamberRecipe(new ItemStack(Block.getBlockFromName("galacticraftplanets:asteroids_block"), 1, 4), new ItemStack(ItemInit.DUST_TITANIUM, 2));
            MekanismAPI.recipeHelper().addEnrichmentChamberRecipe(new ItemStack(Block.getBlockFromName("extraplanets:mercury"), 1, 6), new ItemStack(ItemInit.DUST_MERCURY, 2));
        }
    }


    public static void addCombinerRecipe(){

        // 8x Dust + Cobble -> Ore
        for(int i=0; i<ORE.size(); i++){
            if(GetInfo.findClone(ORE, DUST.get(i)) == null) continue;
            MekanismAPI.recipeHelper().addCombinerRecipe(new ItemStack(DUST.get(i), 8), new ItemStack(Blocks.COBBLESTONE), new ItemStack(GetInfo.findClone(ORE, DUST.get(i))));
        }
    }


    public static void addCrusherRecipe(){

        for(int i=0; i<INGOT.size(); i++){
            if(GetInfo.findClone(DUST, INGOT.get(i)) == null || GetInfo.findClone(DIRTY, CLUMP.get(i)) == null) continue;
            // Ingot -> Dust
            MekanismAPI.recipeHelper().addCrusherRecipe(new ItemStack(INGOT.get(i)), new ItemStack(GetInfo.findClone(DUST, INGOT.get(i))));
            // Clump -> Dirty Dust
            MekanismAPI.recipeHelper().addCrusherRecipe(new ItemStack(CLUMP.get(i)), new ItemStack(GetInfo.findClone(DIRTY, CLUMP.get(i))));
        }
    }


    public static void addPurificationChamberRecipe(){

        // Shard -> Clump
        for(int i=0; i<CLUMP.size(); i++){
            if(GetInfo.findClone(CLUMP, SHARD.get(i)) == null) continue;
            MekanismAPI.recipeHelper().addPurificationChamberRecipe(new ItemStack(SHARD.get(i)), new ItemStack(GetInfo.findClone(CLUMP, SHARD.get(i))));
        }

        // Ore -> 3x Clump
        for(int i=0; i<ORE.size(); i++){
            if(GetInfo.findClone(CLUMP, ORE.get(i)) == null) continue;
            MekanismAPI.recipeHelper().addPurificationChamberRecipe(new ItemStack(ORE.get(i)), new ItemStack(GetInfo.findClone(CLUMP, ORE.get(i)), 3));
        }

        if(ModLoaded.id("thaumcraft")){
            MekanismAPI.recipeHelper().addPurificationChamberRecipe(new ItemStack(BlockInit.ORE_CINNABAR, 1), new ItemStack(Item.getByNameOrId("thaumcraft:cluster"), 3, 6));
        }

        if(ModLoaded.id("extraplanets")){
            MekanismAPI.recipeHelper().addPurificationChamberRecipe(new ItemStack(Block.getBlockFromName("extraplanets:neptune"), 1, 6), new ItemStack(ItemInit.CLUMP_ZINC, 3));
            MekanismAPI.recipeHelper().addPurificationChamberRecipe(new ItemStack(Block.getBlockFromName("extraplanets:jupiter"), 1, 6), new ItemStack(ItemInit.CLUMP_PALLADIUM, 3));
            MekanismAPI.recipeHelper().addPurificationChamberRecipe(new ItemStack(Block.getBlockFromName("galacticraftplanets:asteroids_block"), 1, 4), new ItemStack(ItemInit.CLUMP_TITANIUM, 3));
            MekanismAPI.recipeHelper().addPurificationChamberRecipe(new ItemStack(Block.getBlockFromName("extraplanets:mercury"), 1, 6), new ItemStack(ItemInit.CLUMP_MERCURY, 3));
        }
    }


    public static void addChemicalInjectionChamberRecipe(){

        for(int i=0; i<SHARD.size(); i++){
            if(GetInfo.findClone(SHARD, CRYSTAL.get(i)) == null || GetInfo.findClone(SHARD, ORE.get(i)) == null) continue;
            // Crystal -> Shard
            MekanismAPI.recipeHelper().addChemicalInjectionChamberRecipe(new ItemStack(CRYSTAL.get(i)), GasRegistry.getGas("hydrogenchloride"), new ItemStack(GetInfo.findClone(SHARD, CRYSTAL.get(i))));
            // Ore -> 4x Shard
            MekanismAPI.recipeHelper().addChemicalInjectionChamberRecipe(new ItemStack(ORE.get(i)), GasRegistry.getGas("hydrogenchloride"), new ItemStack(GetInfo.findClone(SHARD, ORE.get(i)), 4));
        }

        MekanismAPI.recipeHelper().addChemicalInjectionChamberRecipe(new ItemStack(BlockInit.ORE_CINNABAR), GasRegistry.getGas("hydrogenchloride"), new ItemStack(ItemInit.SHARD_MERCURY, 4));

        if(ModLoaded.id("extraplanets")){
            MekanismAPI.recipeHelper().addChemicalInjectionChamberRecipe(new ItemStack(Block.getBlockFromName("extraplanets:neptune"), 1, 6), GasRegistry.getGas("hydrogenchloride"), new ItemStack(ItemInit.SHARD_ZINC, 4));
            MekanismAPI.recipeHelper().addChemicalInjectionChamberRecipe(new ItemStack(Block.getBlockFromName("extraplanets:jupiter"), 1, 6), GasRegistry.getGas("hydrogenchloride"), new ItemStack(ItemInit.SHARD_PALLADIUM, 4));
            MekanismAPI.recipeHelper().addChemicalInjectionChamberRecipe(new ItemStack(Block.getBlockFromName("galacticraftplanets:asteroids_block"), 1, 4), GasRegistry.getGas("hydrogenchloride"), new ItemStack(ItemInit.SHARD_TITANIUM, 4));
            MekanismAPI.recipeHelper().addChemicalInjectionChamberRecipe(new ItemStack(Block.getBlockFromName("extraplanets:mercury"), 1, 6), GasRegistry.getGas("hydrogenchloride"), new ItemStack(ItemInit.SHARD_MERCURY, 4));
        }
    }


    public static void addChemicalDissolutionChamberRecipe(){

        // Ore -> Slurry
        for(int i=0; i<INGOT.size(); i++){
            if(GetInfo.findClone(INGOT, ORE.get(i)) == null) continue;
            MekanismAPI.recipeHelper().addChemicalDissolutionChamberRecipe(new ItemStack(ORE.get(i)), new GasStack(GasRegistry.getGas(GetInfo.metalUncapital(GetInfo.findClone(INGOT, ORE.get(i)))+"Slurry"), 1000));
        }

        if(ModLoaded.id("extraplanets")){
            MekanismAPI.recipeHelper().addChemicalDissolutionChamberRecipe(new ItemStack(Block.getBlockFromName("extraplanets:neptune"), 1, 6), new GasStack(GasRegistry.getGas("zincSlurry"), 1000));
            MekanismAPI.recipeHelper().addChemicalDissolutionChamberRecipe(new ItemStack(Block.getBlockFromName("extraplanets:jupiter"), 1, 6), new GasStack(GasRegistry.getGas("palladiumSlurry"), 1000));
            MekanismAPI.recipeHelper().addChemicalDissolutionChamberRecipe(new ItemStack(Block.getBlockFromName("galacticraftplanets:asteroids_block"), 1, 4), new GasStack(GasRegistry.getGas("titaniumSlurry"), 1000));
            MekanismAPI.recipeHelper().addChemicalDissolutionChamberRecipe(new ItemStack(Block.getBlockFromName("extraplanets:mercury"), 1, 6), new GasStack(GasRegistry.getGas("mercurySlurry"), 1000));
        }
    }


    public static void addChemicalWasherRecipe(){

        // Slurry -> Clean Slurry
        for(int i=0; i<INGOT.size(); i++){
            MekanismAPI.recipeHelper().addChemicalWasherRecipe(new GasStack(GasRegistry.getGas(GetInfo.metalUncapital(INGOT.get(i))+"Slurry"), 1), new GasStack(GasRegistry.getGas("clean"+ GetInfo.metal(INGOT.get(i))+"Slurry"), 1));
        }
    }


    public static void addChemicalCrystallizerRecipe(){

        // Clean Slurry -> Crystal
        for(int i=0; i<CRYSTAL.size(); i++){
            if(GetInfo.findClone(CRYSTAL, INGOT.get(i)) == null) continue;
            MekanismAPI.recipeHelper().addChemicalCrystallizerRecipe(new GasStack(GasRegistry.getGas("clean"+ GetInfo.metal(INGOT.get(i))+"Slurry"), 200), new ItemStack(GetInfo.findClone(CRYSTAL, INGOT.get(i))));
        }
    }
}
