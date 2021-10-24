package evergoodteam.evergoodutilities.util.handlers;


import evergoodteam.evergoodutilities.EvergoodUtilities;
import evergoodteam.evergoodutilities.init.*;
import evergoodteam.evergoodutilities.objects.commands.CommandSunny;
import evergoodteam.evergoodutilities.objects.commands.CommandNightvision;
import evergoodteam.evergoodutilities.objects.commands.CommandSpectator;
import evergoodteam.evergoodutilities.objects.commands.CommandText;
import evergoodteam.evergoodutilities.recipes.CraftingRecipes;
import evergoodteam.evergoodutilities.recipes.SmeltingRecipes;
import static evergoodteam.evergoodutilities.config.Configs.*;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


@EventBusSubscriber
public class RegistryHandler {

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event){

        event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));

    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event){

        RenderHandler.registerCustomMeshesAndStates(); //Fluids

        for (Item item : ItemInit.ITEMS) {
            EvergoodUtilities.proxy.registerItemRenderer(item, 0, "inventory");
        }

        for (Block block : BlockInit.BLOCKS) {
            EvergoodUtilities.proxy.registerItemRenderer(Item.getItemFromBlock(block), 0, "inventory");
        }


    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event){

        event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));
        event.getRegistry().registerAll(FluidBlockInit.BLOCKSFLUID.toArray(new Block[0]));
    }


    public static void preInitRegistries(FMLPreInitializationEvent event){

        FluidInit.registerFluids();
    }

    public static void initRegistries(){

        CraftingRecipes.Init();
        SmeltingRecipes.Init();

        EvergoodUtilities.proxy.render();

        CompatHandler.init();
    }

    public static void postInitRegistries(){

        CompatHandler.postInit();
    }

    public static void serverRegistries(FMLServerStartingEvent event){

        if(commands.Sunny) event.registerServerCommand(new CommandSunny());
        if(commands.Nightvision) event.registerServerCommand(new CommandNightvision());
        if(commands.Spectator) event.registerServerCommand(new CommandSpectator());
        if(commands.Text) event.registerServerCommand(new CommandText());
    }
}
