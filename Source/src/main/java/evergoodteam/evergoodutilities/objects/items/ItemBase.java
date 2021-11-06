package evergoodteam.evergoodutilities.objects.items;


import evergoodteam.evergoodutilities.EvergoodUtilities;
import evergoodteam.evergoodutilities.init.ItemInit;

import net.minecraft.item.Item;

import java.util.*;
import java.util.List;


public class ItemBase extends Item {

    public static final List<Integer> CUSTOM_COLORS = new ArrayList<Integer>();
    public static final List<Item> NEEDS_CUSTOM_COLOR = new ArrayList<Item>();


    public ItemBase(String name, Boolean tab){
        setRegistryName(name);
        setUnlocalizedName(name);

        if (tab) setCreativeTab(EvergoodUtilities.EVERGOODUTILITIESTAB);

        if(this != null) ItemInit.ITEMS.add(this);
    }

    // Needs specific color
    public ItemBase(String name, Boolean Tab, int color){
        setRegistryName(name);
        setUnlocalizedName(name);

        ItemBase.CUSTOM_COLORS.add(color);

        if(Tab) setCreativeTab(EvergoodUtilities.EVERGOODUTILITIESTAB);

        if(this != null) {
            ItemInit.ITEMS.add(this);

            ItemBase.NEEDS_CUSTOM_COLOR.add(this);
        }
    }
}
