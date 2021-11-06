package evergoodteam.evergoodutilities.util.handlers;


import evergoodteam.evergoodutilities.config.Configs;
import evergoodteam.evergoodutilities.init.FluidInit;
import evergoodteam.evergoodutilities.init.ItemInit;
import evergoodteam.evergoodutilities.objects.items.ItemBase;
import evergoodteam.evergoodutilities.util.GetInfo;
import evergoodteam.evergoodutilities.util.GetList;
import evergoodteam.evergoodutilities.util.Reference;

import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.apache.commons.lang3.ArrayUtils;


@EventBusSubscriber(modid = Reference.MOD_ID)

public class ColorHandler {


    /*
    @SubscribeEvent
    public static void registerBlockColourHandlers(final ColorHandlerEvent.Block event) {

        final BlockColors blockColors = event.getBlockColors();

        for(int i=0; i<3; i++){
            int finalIndex = i;

            final IBlockColor blockColorHandler = (state, blockAccess, pos, tintIndex) -> {
                return FluidInit.FLUIDS.get(finalIndex).getColor();  //Reuse the colors used for Fluids
            };

            blockColors.registerBlockColorHandler(blockColorHandler, BlockInit.BLOCKS.get(i));
        }
    }*/

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void registerItemColourHandlers(final ColorHandlerEvent.Item event) {
        final ItemColors itemColors = event.getItemColors();

        if(Configs.additions.Items){

            for(int i=0; i<ItemInit.ITEMS.size(); i++){

                int finalI = i;
                int index = ArrayUtils.indexOf(GetList.metalList(FluidInit.FLUIDS), GetInfo.metal(ItemInit.ITEMS.get(finalI)), 0);
                if(index == -1) continue;

                itemColors.registerItemColorHandler(new IItemColor(){
                    public int colorMultiplier(ItemStack stack, int tintIndex) {
                        return tintIndex == 0 ? FluidInit.FLUIDS.get(index).getColor() : -1;
                    }
                }, ItemInit.ITEMS.get(i));

            }


            if(Configs.compat.Mod("Nuclearcraft")){
                for(int i = 0; i<ItemBase.NEEDS_CUSTOM_COLOR.size(); i++){

                    int finalI = i;

                    itemColors.registerItemColorHandler(new IItemColor(){
                        public int colorMultiplier(ItemStack stack, int tintIndex) {
                            return tintIndex == 0 ? ItemBase.CUSTOM_COLORS.get(finalI) : -1;
                        }
                    }, ItemBase.NEEDS_CUSTOM_COLOR.get(i));
                }
            }
        }


        /*
         //Blocks in item form, get color from their block form

        final BlockColors blockColors = event.getBlockColors();
        final ItemColors itemBlockColors = event.getItemColors();

        final IItemColor itemBlockColourHandler = (stack, tintIndex) -> {
            final IBlockState state = ((ItemBlock) stack.getItem()).getBlock().getStateFromMeta(stack.getMetadata());
            return blockColors.colorMultiplier(state, null, null, tintIndex);
        };

        if(Configs.additions.Blocks){
            for(int i=2; i<3; i++){
                itemBlockColors.registerItemColorHandler(itemBlockColourHandler, BlockInit.BLOCKS.get(i));
            }
        }*/
    }
}
