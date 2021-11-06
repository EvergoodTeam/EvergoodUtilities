package evergoodteam.evergoodutilities.compat.mods;


import blusunrize.immersiveengineering.api.crafting.CrusherRecipe;
import blusunrize.immersiveengineering.api.crafting.ArcFurnaceRecipe;

import evergoodteam.evergoodutilities.compat.ModLoaded;
import evergoodteam.evergoodutilities.init.BlockInit;
import evergoodteam.evergoodutilities.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


public class ImmersiveEngineering {

    public static void addCrusherRecipe() {

        for(int i=0; i<2; i++){
            CrusherRecipe.addRecipe(new ItemStack(ItemInit.ITEMS.get(i+16), 2), new ItemStack(BlockInit.BLOCKS.get(i)), 6000);
        }

        if(ModLoaded.id("extraplanets")){

            CrusherRecipe.addRecipe(new ItemStack(ItemInit.DUST_ZINC, 2), new ItemStack(Block.getBlockFromName("extraplanets:neptune"), 1, 6), 6000);
            CrusherRecipe.addRecipe(new ItemStack(ItemInit.DUST_PALLADIUM, 2), new ItemStack(Block.getBlockFromName("extraplanets:jupiter"), 1, 6), 6000);
            CrusherRecipe.addRecipe(new ItemStack(ItemInit.DUST_MERCURY, 2), new ItemStack(Block.getBlockFromName("extraplanets:mercury"), 1, 6), 6000);
        }

        if(ModLoaded.id("thermalfoundation")){

            CrusherRecipe.addRecipe(new ItemStack(Item.getByNameOrId("thermalfoundation:material"), 2, 866), new ItemStack(BlockInit.ORE_CINNABAR), 6000);
        }
    }

    public static void addArcFurnaceRecipe(){

        for(int i=0; i<2; i++){

            ArcFurnaceRecipe.addRecipe(new ItemStack(ItemInit.ITEMS.get(i+24), 2), new ItemStack(BlockInit.BLOCKS.get(i)), new ItemStack(Block.getBlockFromName("immersiveengineering:material"), 1, 7), 2000, 512);
        }

        if(ModLoaded.id("extraplanets")) {

            ArcFurnaceRecipe.addRecipe(new ItemStack(ItemInit.INGOT_ZINC, 2), new ItemStack(Block.getBlockFromName("extraplanets:neptune"), 1, 6), new ItemStack(Block.getBlockFromName("immersiveengineering:material"), 1, 7), 2000, 512);
            ArcFurnaceRecipe.addRecipe(new ItemStack(ItemInit.INGOT_PALLADIUM, 2), new ItemStack(Block.getBlockFromName("extraplanets:jupiter"), 1, 6), new ItemStack(Block.getBlockFromName("immersiveengineering:material"), 1, 7), 2000, 512);
        }
    }
}
