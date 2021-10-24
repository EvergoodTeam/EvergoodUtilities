package evergoodteam.evergoodutilities.objects.fluids;


import evergoodteam.evergoodutilities.init.FluidBlockInit;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;


public class FluidBlockBase extends BlockFluidClassic {

    public FluidBlockBase(String name, Fluid fluid, Material material, Float light){
        super(fluid, material);
        setRegistryName(name);
        setUnlocalizedName(name);
        setLightLevel(light);

        if(this != null) {
            FluidBlockInit.BLOCKSFLUID.add(this);
            //ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName())); // This adds the Fluid as a block, which you can add
        }                                                                                      // in the Creative tab. We want it to only show
    }                                                                                          // up in JEI as a single simple texture, like any other fluid

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state){
        return EnumBlockRenderType.MODEL;
    }
}
