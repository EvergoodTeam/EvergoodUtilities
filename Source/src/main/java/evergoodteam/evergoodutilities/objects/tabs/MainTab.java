package evergoodteam.evergoodutilities.objects.tabs;


import evergoodteam.evergoodutilities.init.ItemInit;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;


public class MainTab extends CreativeTabs {

    public MainTab(String label){
        super("evergoodutilitiestab");
        this.setBackgroundImageName("evergoodutilities.png");
    }

    @Override
    public ItemStack getTabIconItem(){

        return new ItemStack(ItemInit.ICON_BLOCK2);
    }
}
