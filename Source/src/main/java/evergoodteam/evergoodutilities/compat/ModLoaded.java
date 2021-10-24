package evergoodteam.evergoodutilities.compat;


import net.minecraftforge.fml.common.Loader;


public class ModLoaded{

    public static boolean id(String name){

        boolean modLoaded = Loader.isModLoaded(name);
        return modLoaded;
    }
}
