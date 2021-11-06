package evergoodteam.evergoodutilities.compat;


import evergoodteam.evergoodutilities.init.ItemInit;
import evergoodteam.evergoodutilities.util.GetInfo;

import net.minecraftforge.oredict.OreDictionary;


public class OreDict {

    public static void registerOreDict(){

        for(int i=0; i<ItemInit.ITEMS.size(); i++){
            if(GetInfo.oreDict(ItemInit.ITEMS.get(i)) == null){

                continue;
            }
            else{

                OreDictionary.registerOre(GetInfo.oreDict(ItemInit.ITEMS.get(i)), ItemInit.ITEMS.get(i));
            }
        }
    }
}
