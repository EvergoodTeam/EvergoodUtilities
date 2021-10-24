package evergoodteam.evergoodutilities;


import evergoodteam.evergoodutilities.objects.tabs.MainTab;
import evergoodteam.evergoodutilities.util.Reference;
import evergoodteam.evergoodutilities.proxy.CommonProxy;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, updateJSON = Reference.UPDATE)

public class EvergoodUtilities{

    @Instance
    public static EvergoodUtilities instance;


    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;


    public static final Logger logger = LogManager.getLogger(Reference.NAME);

    public static final CreativeTabs EVERGOODUTILITIESTAB = new MainTab(Reference.TAB);

    static { FluidRegistry.enableUniversalBucket(); }


    @EventHandler
    public void preInit(FMLPreInitializationEvent event){

        proxy.preInit(event);
        logger.info("EU's PreInit Completed");
    }

    @EventHandler
    public void init(FMLInitializationEvent event){

        proxy.init(event);
        logger.info("EU's Init Completed");
    }


    @EventHandler
    public void postInit(FMLPostInitializationEvent event){

        proxy.postInit(event);
        logger.info("EU's PostInit Completed");
    }

    @EventHandler
    public void serverInit(FMLServerStartingEvent event){

        proxy.serverInit(event);
    }
}
