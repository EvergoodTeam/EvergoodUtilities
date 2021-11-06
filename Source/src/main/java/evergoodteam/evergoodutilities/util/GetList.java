package evergoodteam.evergoodutilities.util;


import evergoodteam.evergoodutilities.init.ItemInit;

import net.minecraft.item.Item;
import net.minecraftforge.fluids.Fluid;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class GetList {

    public static String[] metalList(List<Fluid> input){

        String [] stuffs = new String[input.size()];

        for(int i=0; i<input.size(); i++){
            stuffs[i] = GetInfo.metal(input.get(i));

        }

        return stuffs;
    }

    public static String[] metaList(List<Item> input){

        String [] stuffs = new String[input.size()];

        for(int i=0; i<input.size(); i++){
            stuffs[i] = GetInfo.metal(input.get(i));

        }

        return stuffs;
    }


    public static String[] oreDictList(List<Item> input){

        String [] stuffs = new String[input.size()];

        for(int i=0; i<input.size(); i++){
            stuffs[i] = GetInfo.oreDict(input.get(i));

        }

        return stuffs;
    }



    public static List<Item> type(String type){

        List<Item> TYPES = new ArrayList<Item>();

        for(int i=0; i<ItemInit.ITEMS.size(); i++){

            if (Objects.equals(GetInfo.type(ItemInit.ITEMS.get(i)), type)) {
                TYPES.add(ItemInit.ITEMS.get(i));
            }
        }

        return TYPES;
    }

}
