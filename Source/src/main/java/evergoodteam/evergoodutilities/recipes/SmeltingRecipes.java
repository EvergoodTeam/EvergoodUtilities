package evergoodteam.evergoodutilities.recipes;


import evergoodteam.evergoodutilities.compat.ModLoaded;
import evergoodteam.evergoodutilities.config.Configs;
import evergoodteam.evergoodutilities.init.BlockInit;
import evergoodteam.evergoodutilities.init.ItemInit;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;


public class SmeltingRecipes {

    public static void Init(){

        if(Configs.additions.Blocks && Configs.additions.Items){

            // Zinc
            GameRegistry.addSmelting(new ItemStack(BlockInit.ORE_ZINC), new ItemStack(ItemInit.INGOT_ZINC), 0.7f);
            GameRegistry.addSmelting(new ItemStack(ItemInit.DUST_ZINC), new ItemStack(ItemInit.INGOT_ZINC), 0.7F);

            // Palladium
            GameRegistry.addSmelting(new ItemStack(BlockInit.ORE_PALLADIUM), new ItemStack(ItemInit.INGOT_PALLADIUM), 0.7f);
            GameRegistry.addSmelting(new ItemStack(ItemInit.DUST_PALLADIUM), new ItemStack(ItemInit.INGOT_PALLADIUM), 0.7F);

            if(ModLoaded.id("thermalfoundation")){
                GameRegistry.addSmelting(new ItemStack(BlockInit.ORE_CINNABAR), new ItemStack(Item.getByNameOrId("thermalfoundation:material"), 1, 866), 0.7f);
            }
        }
    }
}
