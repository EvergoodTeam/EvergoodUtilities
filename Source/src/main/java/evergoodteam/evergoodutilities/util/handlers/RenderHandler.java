package evergoodteam.evergoodutilities.util.handlers;


import evergoodteam.evergoodutilities.config.Configs;
import evergoodteam.evergoodutilities.init.FluidBlockInit;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;


public class RenderHandler {

    public static void registerCustomMeshesAndStates() {

        if(Configs.additions.Fluids) {
            for (int index = 0; index < FluidBlockInit.BLOCKSFLUID.size(); index++) {

                int finalIndex = index;

                ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(FluidBlockInit.BLOCKSFLUID.get(index)), new ItemMeshDefinition() {
                    @Override
                    public ModelResourceLocation getModelLocation(ItemStack stack) {
                        return new ModelResourceLocation(FluidBlockInit.BLOCKSFLUID.get(finalIndex).getRegistryName(), "fluid");
                    }
                });

                ModelLoader.setCustomStateMapper(FluidBlockInit.BLOCKSFLUID.get(index), new StateMapperBase() {
                    @Override
                    protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
                        return new ModelResourceLocation(FluidBlockInit.BLOCKSFLUID.get(finalIndex).getRegistryName(), "fluid");
                    }
                });
            }
        }
    }
}
