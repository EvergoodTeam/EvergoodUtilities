package evergoodteam.evergoodutilities.compat;


import evergoodteam.evergoodutilities.init.ItemInit;
import evergoodteam.evergoodutilities.util.GetName;

import net.minecraftforge.oredict.OreDictionary;


public class OreDict {

    public static void registerOreDict(){

        for(int i=0; i<ItemInit.ITEMS.size(); i++){
            if(GetName.oreDict(ItemInit.ITEMS.get(i).getRegistryName().toString()) == null){
                continue;
            }
            else{
                OreDictionary.registerOre(GetName.oreDict(ItemInit.ITEMS.get(i).getRegistryName().toString()), ItemInit.ITEMS.get(i));
            }
        }
    }
}
