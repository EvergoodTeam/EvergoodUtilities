package evergoodteam.evergoodutilities.objects.blocks;


import evergoodteam.evergoodutilities.EvergoodUtilities;
import evergoodteam.evergoodutilities.init.BlockInit;
import evergoodteam.evergoodutilities.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;


public class BlockBase extends Block {

    public BlockBase(String name, Material material, float hardness, float resistance, int miningLevel, String tool, boolean tab){
        super(material);
        setRegistryName(name);
        setUnlocalizedName(name);
        setHardness(hardness);
        setResistance(resistance);
        setHarvestLevel(tool, miningLevel);

        if(tab){
            setCreativeTab(EvergoodUtilities.EVERGOODUTILITIESTAB);
        }

        if(this != null) {
            BlockInit.BLOCKS.add(this);
            ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
        }
    }

    /**
     * Make the layers have transparency, or whatever you want to call it.
     * It allows us to have block textures made up of different layers:
     *
     * #layer0 is stone, #layer1 (on top of #layer0) is the ore.
     * Without this #layer1 would just have a white background.
     */
/*
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }
*/
}
