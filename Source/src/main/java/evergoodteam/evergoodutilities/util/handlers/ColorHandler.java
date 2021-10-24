package evergoodteam.evergoodutilities.util.handlers;


import evergoodteam.evergoodutilities.config.Configs;
import evergoodteam.evergoodutilities.init.FluidInit;
import evergoodteam.evergoodutilities.objects.items.ItemBase;
import evergoodteam.evergoodutilities.util.Reference;

import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


/**
 * Thanks Choonster: https://git.io/J0hPz
 * If the link above ever stops working, contanct whoever is currently maintaining Evergood Utilities.
 *
 * His code was obviously modified quite a bit for our purposes.
 *
 * But why would anyone want to do all this shit instead of just making some extra textures?
 *
 * Its more fun.
 * And im lazy. + I get to make a block/item that changes color when biomes do
 */

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


    @SubscribeEvent
    public static void registerItemColourHandlers(final ColorHandlerEvent.Item event) {
        final ItemColors itemColors = event.getItemColors();

        if(Configs.additions.Items){
            for(int i = 0; i < ItemBase.METALS.size(); i++){

                if(ItemBase.METALS.get(i).getUnlocalizedName().contains("zinc")){
                    itemColors.registerItemColorHandler(new IItemColor(){
                        public int colorMultiplier(ItemStack stack, int tintIndex) {
                            return tintIndex == 0 ? FluidInit.FLUIDS.get(0).getColor() : -1;
                        }
                    }, ItemBase.METALS.get(i));
                }

                if(ItemBase.METALS.get(i).getUnlocalizedName().contains("palladium")){
                    itemColors.registerItemColorHandler(new IItemColor(){
                        public int colorMultiplier(ItemStack stack, int tintIndex) {
                            return tintIndex == 0 ? FluidInit.FLUIDS.get(1).getColor() : -1;
                        }
                    }, ItemBase.METALS.get(i));
                }

                if(ItemBase.METALS.get(i).getUnlocalizedName().contains("titanium")){
                    itemColors.registerItemColorHandler(new IItemColor(){
                        public int colorMultiplier(ItemStack stack, int tintIndex) {
                            return tintIndex == 0 ? FluidInit.FLUIDS.get(2).getColor() : -1;
                        }
                    }, ItemBase.METALS.get(i));
                }

                if(ItemBase.METALS.get(i).getUnlocalizedName().contains("mercury")){
                    itemColors.registerItemColorHandler(new IItemColor(){
                        public int colorMultiplier(ItemStack stack, int tintIndex) {
                            return tintIndex == 0 ? FluidInit.FLUIDS.get(3).getColor() : -1;
                        }
                    }, ItemBase.METALS.get(i));
                }

            }

            if(Configs.compat.Mod("Nuclearcraft")){
                for(int i = 0; i< ItemBase.NEEDS_CUSTOM_COLOR.size(); i++){

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
