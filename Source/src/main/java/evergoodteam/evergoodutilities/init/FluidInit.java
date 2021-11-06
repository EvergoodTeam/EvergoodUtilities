package evergoodteam.evergoodutilities.init;


import evergoodteam.evergoodutilities.config.Configs;
import evergoodteam.evergoodutilities.objects.fluids.FluidBase;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

import java.util.ArrayList;
import java.util.List;


public class FluidInit {

    public static final List<Fluid> FLUIDS = new ArrayList<Fluid>(); //Make array to which FluidBase will add

    public static final Fluid ZINC_FLUID = Configs.additions.Fluids ? new FluidBase("fluid_zinc", 2000, 10000, 1000, "bac4c8") : null; //ecf4f6
    public static final Fluid PALLADIUM_FLUID = Configs.additions.Fluids ? new FluidBase("fluid_palladium", 2000, 10000, 1000, "c1c1bb") : null;
    public static final Fluid TITANIUM_FLUID = Configs.additions.Fluids ? new FluidBase("fluid_titanium",1000, 10000, 1000, "878681") : null;
    public static final Fluid MERCURY_FLUID = Configs.additions.Fluids ? new FluidBase("fluid_mercury",1000, 1800, 30, "747b81") : null;

    public static final Fluid ASTRALSTARMETAL_FLUID = Configs.additions.Fluids ? new FluidBase("fluid_astralstarmetal", 2000, 10000, 1000) : null;
    //public static final Fluid AQUAMARINE_FLUID = Configs.additions.Fluids ? new FluidBase("fluid_aquamarine", 2000, 10000, 1000, "0099ff") : null;

    public static void registerFluid(Fluid fluid) {

        FluidRegistry.registerFluid(fluid);
        FluidRegistry.addBucketForFluid(fluid);
    }

    public static void registerFluids() { //Used in RegistryHandler

        for (int i = 0; i < FLUIDS.size(); i++) { //Register everything from the array
            registerFluid(FLUIDS.get(i));
        }
    }
}
