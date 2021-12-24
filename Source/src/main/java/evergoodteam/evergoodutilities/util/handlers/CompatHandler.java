package evergoodteam.evergoodutilities.util.handlers;


import evergoodteam.evergoodutilities.compat.OreDict;
import evergoodteam.evergoodutilities.compat.mods.ImmersiveEngineering;
import evergoodteam.evergoodutilities.compat.mods.Mekanism;
import evergoodteam.evergoodutilities.compat.mods.ThermalExpansion;
import evergoodteam.evergoodutilities.compat.mods.TinkersConstruct;
import evergoodteam.evergoodutilities.config.Configs;


public class CompatHandler {

    public static void preInit(){


    }

    public static void init(){

        if(Configs.compat.OreDictionary){

            OreDict.registerOreDict();
        }

        if(Configs.additions.Items && Configs.additions.Blocks && Configs.additions.Fluids) {

            if (Configs.compat.Mod("Mekanism")) {
                Mekanism.addGases();
                Mekanism.addEnrichmentChamberRecipe();
                Mekanism.addCombinerRecipe();
                Mekanism.addCrusherRecipe();
                Mekanism.addPurificationChamberRecipe();
                Mekanism.addChemicalInjectionChamberRecipe();
                Mekanism.addChemicalDissolutionChamberRecipe();
                Mekanism.addChemicalWasherRecipe();
                Mekanism.addChemicalCrystallizerRecipe();
            }

            if(Configs.compat.Mod("Thermal")){

                ThermalExpansion.addGlacialPrecipitator();
            }
        }
    }

    public static void postInit(){

        if(Configs.additions.Items && Configs.additions.Blocks && Configs.additions.Fluids) {

            if(Configs.compat.Mod("TinkersConstruct")) {

                TinkersConstruct.addMeltingRecipe();
                TinkersConstruct.addAlloyRecipe();
                TinkersConstruct.addCastingRecipe();
            }
        }

        if(Configs.additions.Items && Configs.additions.Blocks) {

            if(Configs.compat.Mod("ImmersiveEngineering")){

                ImmersiveEngineering.addCrusherRecipe();
                ImmersiveEngineering.addArcFurnaceRecipe();
            }
        }
    }
}
