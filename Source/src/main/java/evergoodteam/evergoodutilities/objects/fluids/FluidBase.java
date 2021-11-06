package evergoodteam.evergoodutilities.objects.fluids;


import evergoodteam.evergoodutilities.init.FluidInit;
import evergoodteam.evergoodutilities.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

import java.awt.*;


public class FluidBase extends Fluid {

    public FluidBase(String name, int dens, int visc, int temp, String color){ // Requires id, which is used both for id and texture id
        super(name, new ResourceLocation(Reference.MOD_ID, "fluids/fluid_molten_still"), new ResourceLocation(Reference.MOD_ID, "fluids/fluid_molten_flow"), new ResourceLocation(Reference.MOD_ID, "fluids/fluid_molten_overlay"));
        this.setUnlocalizedName(name);
        this.setDensity(dens);
        this.setViscosity(visc);
        this.setTemperature(temp + 273);
        this.setColor(Color.decode("0x"+color));

        Color antonio = Color.decode("0x"+color);
        antonio.brighter();

        if(this != null) {
            FluidInit.FLUIDS.add(this); // Add what just happened to the array from FluidInit
        }
    }

    public FluidBase(String name, int dens, int visc, int temp){ // Fluids with custom textures, which obviously dont need a color
        super(name, new ResourceLocation(Reference.MOD_ID, "fluids/" + name + "_still"), new ResourceLocation(Reference.MOD_ID, "fluids/" + name + "_flow"), new ResourceLocation(Reference.MOD_ID, "fluids/" + name + "_overlay"));
        this.setUnlocalizedName(name);
        this.setDensity(dens);
        this.setViscosity(visc);
        this.setTemperature(temp + 273);

        if(this != null) {
            FluidInit.FLUIDS.add(this);
        }
    }
}
