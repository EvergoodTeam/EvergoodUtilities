package evergoodteam.evergoodutilities.util;


import evergoodteam.evergoodutilities.init.ItemInit;

import net.minecraft.item.Item;
import net.minecraftforge.fluids.Fluid;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class GetList {

    public static String[] metalList(List<Fluid> input){

        String [] list = new String[input.size()];

        for(int i=0; i<input.size(); i++){
            list[i] = GetInfo.metal(input.get(i));

        }

        return list;
    }

    public static String[] metaList(List<Item> input){

        String [] list = new String[input.size()];

        for(int i=0; i<input.size(); i++){
            list[i] = GetInfo.metal(input.get(i));

        }

        return list;
    }


    // Every oredict entry
    public static String[] oreDictList(List<Item> input){

        String [] list = new String[input.size()];

        for(int i=0; i<input.size(); i++){
            list[i] = GetInfo.oreDict(input.get(i));

        }

        return list;
    }


    public static List<Item> type(String type){

        List<Item> list = new ArrayList<Item>();

        for(int i=0; i<ItemInit.ITEMS.size(); i++){

            if (Objects.equals(GetInfo.type(ItemInit.ITEMS.get(i)), type)) {
                list.add(ItemInit.ITEMS.get(i));
            }
        }

        return list;
    }

}
