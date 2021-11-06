package evergoodteam.evergoodutilities.proxy;


import evergoodteam.evergoodutilities.util.handlers.RegistryHandler;

import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

import java.io.File;


public class CommonProxy {
    public void registerItemRenderer(Item item, int meta, String id){


    }

    public void render(){


    }


    public static Configuration config;

    public void preInit(FMLPreInitializationEvent event){

        RegistryHandler.preInitRegistries(event);

        // Config file
        File directory = event.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), "evergoodutilities.cfg"));
    }

    public void init(FMLInitializationEvent event){

        RegistryHandler.initRegistries();

    }

    public void postInit(FMLPostInitializationEvent event){

        RegistryHandler.postInitRegistries();

        // Save Config file
        if (config.hasChanged()) {
            config.save();
        }
    }

    public void serverInit(FMLServerStartingEvent event){

        RegistryHandler.serverRegistries(event);

    }
}
