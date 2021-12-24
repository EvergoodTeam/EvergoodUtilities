package evergoodteam.evergoodutilities.compat.mods;


import blusunrize.immersiveengineering.api.crafting.CrusherRecipe;
import blusunrize.immersiveengineering.api.crafting.ArcFurnaceRecipe;

import evergoodteam.evergoodutilities.compat.ModLoaded;
import evergoodteam.evergoodutilities.init.BlockInit;
import evergoodteam.evergoodutilities.init.ItemInit;

import evergoodteam.evergoodutilities.util.GetInfo;
import evergoodteam.evergoodutilities.util.GetList;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;


public class ImmersiveEngineering {

    private static List<Item> ORE = GetList.type("ore");
    private static List<Item> INGOT = GetList.type("ingot");
    private static List<Item> DUST = GetList.type("dust");

    public static void addCrusherRecipe() {

        // Ore -> Dust
        for (Item ore : ORE) {
            if (GetInfo.findClone(DUST, ore) == null) continue;
            CrusherRecipe.addRecipe(new ItemStack(GetInfo.findClone(DUST, ore), 2), new ItemStack(ore), 6000);
        }

        if(ModLoaded.id("extraplanets")){

            CrusherRecipe.addRecipe(new ItemStack(ItemInit.DUST_ZINC, 2), new ItemStack(Block.getBlockFromName("extraplanets:neptune"), 1, 6), 6000);
            CrusherRecipe.addRecipe(new ItemStack(ItemInit.DUST_PALLADIUM, 2), new ItemStack(Block.getBlockFromName("extraplanets:jupiter"), 1, 6), 6000);
            CrusherRecipe.addRecipe(new ItemStack(ItemInit.DUST_TITANIUM, 2), new ItemStack(Block.getBlockFromName("galacticraftplanets:asteroids_block"), 1, 4), 6000);
            CrusherRecipe.addRecipe(new ItemStack(ItemInit.DUST_MERCURY, 2), new ItemStack(Block.getBlockFromName("extraplanets:mercury"), 1, 6), 6000);
        }

        if(ModLoaded.id("thermalfoundation")){

            CrusherRecipe.addRecipe(new ItemStack(Item.getByNameOrId("thermalfoundation:material"), 2, 866), new ItemStack(BlockInit.ORE_CINNABAR), 6000);
        }
    }

    public static void addArcFurnaceRecipe(){

        // Ore -> 2x Ingot
        for (Item ore : ORE) {
            if (GetInfo.findClone(DUST, ore) == null) continue;
            ArcFurnaceRecipe.addRecipe(new ItemStack(GetInfo.findClone(INGOT, ore), 2), new ItemStack(ore), new ItemStack(Block.getBlockFromName("immersiveengineering:material"), 1, 7), 2000, 512);
        }

        if(ModLoaded.id("extraplanets")) {

            ArcFurnaceRecipe.addRecipe(new ItemStack(ItemInit.INGOT_ZINC, 2), new ItemStack(Block.getBlockFromName("extraplanets:neptune"), 1, 6), new ItemStack(Block.getBlockFromName("immersiveengineering:material"), 1, 7), 2000, 512);
            ArcFurnaceRecipe.addRecipe(new ItemStack(ItemInit.INGOT_PALLADIUM, 2), new ItemStack(Block.getBlockFromName("extraplanets:jupiter"), 1, 6), new ItemStack(Block.getBlockFromName("immersiveengineering:material"), 1, 7), 2000, 512);
            ArcFurnaceRecipe.addRecipe(new ItemStack(ItemInit.INGOT_TITANIUM, 2), new ItemStack(Block.getBlockFromName("galacticraftplanets:asteroids_block"), 1, 4), new ItemStack(Block.getBlockFromName("immersiveengineering:material"), 1, 7), 2000, 512);
        }
    }
}
