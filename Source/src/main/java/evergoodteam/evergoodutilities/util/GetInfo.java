package evergoodteam.evergoodutilities.util;


import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fluids.Fluid;

import org.apache.commons.lang3.ArrayUtils;
import java.util.List;


public class GetInfo {

    // Returns type of metal (Ingot, nugget, etc.)
    public static String type(String input){
        String type = input.split(":")[1].split("_")[0];

        if(type.contains("icon")) return null;

        if(type.contains("dirty")) type = "dustDirty";

        return type;
    }

    public static String type(Item input){
        return type(input.getRegistryName().toString());
    }

    public static String type(Block input){
        return type(input.getRegistryName().toString());
    }


    // Returns metal (Zinc, etc.)
    public static String metal(String input){
        StringBuilder name = new StringBuilder(input);

        name.setCharAt(name.indexOf("_") + 1, Character.toUpperCase(name.charAt(name.indexOf("_") + 1)));
        String metal = name.toString().split("_")[1];

        if (metal.contains("Astralstarmetal")) metal = "AstralStarmetal";

        return metal;
    }


    public static String metal(Item input){
        return metal(input.getRegistryName().toString());
    }

    public static String metal(Fluid input){
        return metal(input.getUnlocalizedName());
    }


    // Lower case metal
    public static String metalUncapital(Item input){
        return metal(input).substring(0, 1).toLowerCase() + metal(input).substring(1);
    }

    public static String metalUncapital(Fluid input){
        return metal(input).substring(0, 1).toLowerCase() + metal(input).substring(1);
    }


    // OreDictionary friendly name
    public static String oreDict(Item input){

        if(type(input) == null){
            return null;
        }
        else{
            return type(input)+ metal(input);
        }
    }


    // Get same metal from a given group
    public static Item findClone(List<Item> input, Item clone){

        int index = ArrayUtils.indexOf(GetList.metaList(input), metal(clone), 0);
        if(index==-1) return null;
        else return input.get(index);
    }
}
