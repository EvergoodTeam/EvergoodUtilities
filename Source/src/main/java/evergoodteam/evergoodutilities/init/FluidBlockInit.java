package evergoodteam.evergoodutilities.init;


import evergoodteam.evergoodutilities.config.Configs;
import evergoodteam.evergoodutilities.objects.fluids.FluidBlockBase;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;


public class FluidBlockInit {

    public static final List<Block> BLOCKSFLUID = new ArrayList<Block>();

    public static final Block ZINC_FLUID = Configs.additions.Fluids ? new FluidBlockBase("fluid_zinc", FluidInit.ZINC_FLUID, Material.LAVA, 1.0F) : null;
    public static final Block PALLADIUM_FLUID = Configs.additions.Fluids ? new FluidBlockBase("fluid_palladium", FluidInit.PALLADIUM_FLUID, Material.LAVA, 1.0F) : null;
    public static final Block TITANIUM_FLUID = Configs.additions.Fluids ? new FluidBlockBase("fluid_titanium", FluidInit.TITANIUM_FLUID, Material.WATER, 0.0F) : null;
    public static final Block MERCURY_FLUID = Configs.additions.Fluids ? new FluidBlockBase("fluid_mercury", FluidInit.MERCURY_FLUID, Material.WATER, 0.0F) : null;
    public static final Block ASTRALSTARMETAL_FLUID = Configs.additions.Fluids ? new FluidBlockBase("fluid_astralstarmetal", FluidInit.ASTRALSTARMETAL_FLUID, Material.LAVA, 1.0F) : null;
    public static final Block AQUAMARINE_FLUID = Configs.additions.Fluids ? new FluidBlockBase("fluid_aquamarine", FluidInit.AQUAMARINE_FLUID, Material.LAVA, 1.0F) : null;
}
