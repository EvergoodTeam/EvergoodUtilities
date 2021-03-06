package evergoodteam.evergoodutilities.init;


import evergoodteam.evergoodutilities.config.Configs;
import evergoodteam.evergoodutilities.objects.blocks.BlockBase;
import evergoodteam.evergoodutilities.objects.blocks.BlockOre;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;


/**
 * Each Block first has to pass the Config check (a simple boolean):
 * if this boolean is true, the block is added to an array (inside of BlockBase)
 * that is later used to register everything, otherwise it will
 * be set as null and won't be added to the array.
 */

public class BlockInit {

        public static final List<Block> BLOCKS = new ArrayList<Block>();

        public static final Block BLOCK_ZINC = Configs.additions.Blocks ? new BlockBase("block_zinc", Material.IRON, 6.0f, 30.0f, 3, "pickaxe", true) : null;
        public static final Block BLOCK_PALLADIUM = Configs.additions.Blocks ? new BlockBase("block_palladium", Material.IRON, 6.0f, 30.0f, 3, "pickaxe", true) : null;
        public static final Block BLOCK_TITANIUM = Configs.additions.Blocks ? new BlockBase("block_titanium", Material.IRON, 6.0f, 30.0f, 3, "pickaxe", true) : null;
        public static final Block BLOCK_MERCURY = Configs.additions.Blocks ? new BlockBase("block_mercury", Material.IRON, 6.0f, 30.0f, 3, "pickaxe", true) : null;

        public static final Block ORE_ZINC = Configs.additions.Blocks ? new BlockBase("ore_zinc", Material.ROCK, 3.0f, 5.0f, 2, "pickaxe", true) : null;
        public static final Block ORE_PALLADIUM = Configs.additions.Blocks ? new BlockBase("ore_palladium", Material.ROCK, 3.0f, 5.0f, 2, "pickaxe", true) : null;
        public static final Block ORE_TITANIUM = Configs.additions.Blocks ? new BlockBase("ore_titanium", Material.ROCK, 3.0f, 5.0f, 2, "pickaxe", true) : null;

        public static final Block ORE_CINNABAR = Configs.additions.Blocks ? new BlockOre("ore_cinnabar", Material.ROCK, ItemInit.GEM_CINNABAR, 3.0f, 5.0f, 2, "pickaxe", true) : null;

        // Misc
        public static final Block BLOCK_ASTRALSTARMETAL = Configs.additions.Blocks ? new BlockBase("block_astralstarmetal", Material.IRON, 6.0f, 30.0f, 3, "pickaxe", true) : null;
        public static final Block BLOCK_AQUAMARINE = Configs.additions.Blocks ? new BlockBase("block_aquamarine", Material.IRON, 6.0f, 30.0f, 3, "pickaxe", true) : null;

}
