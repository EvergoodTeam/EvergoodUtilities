package evergoodteam.evergoodutilities.recipes;


import evergoodteam.evergoodutilities.config.Configs;
import evergoodteam.evergoodutilities.util.GetInfo;
import evergoodteam.evergoodutilities.util.GetList;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.List;


public class SmeltingRecipes {

    public static void Init(){

        if(Configs.additions.Blocks && Configs.additions.Items){

            List<Item> ORE = GetList.type("ore");
            List<Item> INGOT = GetList.type("ingot");

            for(int i=0; i<ORE.size(); i++){
                if(GetInfo.findClone(INGOT, ORE.get(i)) == null) continue;
                GameRegistry.addSmelting(new ItemStack(ORE.get(i)), new ItemStack(GetInfo.findClone(INGOT, ORE.get(i))), 0.7f);
            }

        }
    }
}
