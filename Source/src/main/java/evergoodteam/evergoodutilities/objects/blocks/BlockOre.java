package evergoodteam.evergoodutilities.objects.blocks;


import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

import java.util.Random;


public class BlockOre extends BlockBase{

    int min = 1;
    int max = 0;
    Item drop;

    public BlockOre(String name, Material material, float hardness, float resistance, int miningLevel, String tool, boolean tab) {
        this(name, material, null, 1, 1, hardness, resistance, miningLevel, tool, tab);
    }

    public BlockOre(String name, Material material, Item drop, float hardness, float resistance, int miningLevel, String tool, boolean tab) {
        this(name, material, drop, 1, 1, hardness, resistance, miningLevel, tool, tab);
    }

    public BlockOre(String name, Material material, Item drop, int dropAmount, float hardness, float resistance, int miningLevel, String tool, boolean tab) {
        this(name, material, drop, dropAmount, dropAmount, hardness, resistance, miningLevel, tool, tab);
    }

    public BlockOre(String name, Material material, Item drop, int minDropAmount, int maxDropAmount, float hardness, float resistance, int miningLevel, String tool, boolean tab) {

        super(name, material, hardness, resistance, miningLevel, tool, tab);
        this.drop = drop;
        this.min = minDropAmount;
        this.max = maxDropAmount;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {

        return drop ==null?Item.getItemFromBlock(this): drop;
    }

    @Override
    public int quantityDropped(Random random) {

        if(this.min >this.max) {

            int i = this.min;
            this.min =this.max;
            this.max =i;
        }

        return this.min + random.nextInt(this.max - this.min + 1);
    }

    @Override
    public int quantityDroppedWithBonus(int fortune, Random random) {

        if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped(this.getDefaultState(), random, fortune)) {

            int i = random.nextInt(fortune + 2) - 1;

            if (i < 0) i = 0;

            return this.quantityDropped(random) * (i + 1);
        }

        else return this.quantityDropped(random);
    }
}
