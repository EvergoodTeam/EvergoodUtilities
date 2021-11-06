package evergoodteam.evergoodutilities.init;


import evergoodteam.evergoodutilities.config.Configs;
import evergoodteam.evergoodutilities.objects.items.ItemBase;

import net.minecraft.item.Item;

import java.util.List;
import java.util.ArrayList;


public class ItemInit {

    public static final List<Item> ITEMS = new ArrayList<Item>();


    // Metals
    public static final Item CRYSTAL_ZINC = Configs.additions.Items ? Configs.compat.Mod("Mekanism") ? new ItemBase("crystal_zinc", true) : null : null;
    public static final Item CRYSTAL_PALLADIUM = Configs.additions.Items ? Configs.compat.Mod("Mekanism") ? new ItemBase("crystal_palladium", true) : null : null;
    public static final Item CRYSTAL_TITANIUM = Configs.additions.Items ? Configs.compat.Mod("Mekanism") ? new ItemBase("crystal_titanium", true) : null : null;
    public static final Item CRYSTAL_MERCURY = Configs.additions.Items ? Configs.compat.Mod("Mekanism") ? new ItemBase("crystal_mercury", true) : null : null;

    public static final Item SHARD_ZINC = Configs.additions.Items ? Configs.compat.Mod("Mekanism") ? new ItemBase("shard_zinc", true) : null : null;
    public static final Item SHARD_PALLADIUM = Configs.additions.Items ? Configs.compat.Mod("Mekanism") ? new ItemBase("shard_palladium", true) : null : null;
    public static final Item SHARD_TITANIUM = Configs.additions.Items ?  Configs.compat.Mod("Mekanism") ? new ItemBase("shard_titanium", true) : null : null;
    public static final Item SHARD_MERCURY = Configs.additions.Items ?  Configs.compat.Mod("Mekanism") ? new ItemBase("shard_mercury", true) : null : null;

    public static final Item CLUMP_ZINC = Configs.additions.Items ? Configs.compat.Mod("Mekanism") ? new ItemBase("clump_zinc", true) : null : null;
    public static final Item CLUMP_PALLADIUM = Configs.additions.Items ? Configs.compat.Mod("Mekanism") ? new ItemBase("clump_palladium", true) : null : null;
    public static final Item CLUMP_TITANIUM = Configs.additions.Items ? Configs.compat.Mod("Mekanism") ? new ItemBase("clump_titanium", true) : null : null;
    public static final Item CLUMP_MERCURY = Configs.additions.Items ? Configs.compat.Mod("Mekanism") ? new ItemBase("clump_mercury", true) : null : null;

    public static final Item DUSTDIRTY_ZINC = Configs.additions.Items ? Configs.compat.Mod("Mekanism") ? new ItemBase("dustdirty_zinc", true) : null : null;
    public static final Item DUSTDIRTY_PALLADIUM = Configs.additions.Items ? Configs.compat.Mod("Mekanism") ? new ItemBase("dustdirty_palladium", true) : null : null;
    public static final Item DUSTDIRTY_TITANIUM = Configs.additions.Items ? Configs.compat.Mod("Mekanism") ? new ItemBase("dustdirty_titanium", true) : null : null;
    public static final Item DUSTDIRTY_MERCURY = Configs.additions.Items ? Configs.compat.Mod("Mekanism") ? new ItemBase("dustdirty_mercury", true) : null : null;


    public static final Item DUST_ZINC = Configs.additions.Items ? new ItemBase("dust_zinc", true) : null;
    public static final Item DUST_PALLADIUM = Configs.additions.Items ? new ItemBase("dust_palladium", true) : null;
    public static final Item DUST_TITANIUM = Configs.additions.Items ? new ItemBase("dust_titanium", true) : null;
    public static final Item DUST_MERCURY = Configs.additions.Items ? new ItemBase("dust_mercury", true) : null;

    public static final Item NUGGET_ZINC = Configs.additions.Items ? new ItemBase("nugget_zinc", true) : null;
    public static final Item NUGGET_PALLADIUM = Configs.additions.Items ? new ItemBase("nugget_palladium", true) : null;
    public static final Item NUGGET_TITANIUM = Configs.additions.Items ? new ItemBase("nugget_titanium", true) : null;
    public static final Item NUGGET_MERCURY = Configs.additions.Items ? new ItemBase("nugget_mercury", true) : null;

    public static final Item INGOT_ZINC = Configs.additions.Items ? new ItemBase("ingot_zinc", true) : null;
    public static final Item INGOT_PALLADIUM = Configs.additions.Items ? new ItemBase("ingot_palladium", true) : null;
    public static final Item INGOT_TITANIUM = Configs.additions.Items ? new ItemBase("ingot_titanium", true) : null;
    public static final Item INGOT_MERCURY = Configs.additions.Items ? new ItemBase("ingot_mercury", true) : null;

    public static final Item PLATE_ZINC = Configs.additions.Items ? Configs.compat.Mod("Thermal") ? new ItemBase("plate_zinc", true) : null : null;
    public static final Item PLATE_PALLADIUM = Configs.additions.Items ? Configs.compat.Mod("Thermal") ? new ItemBase("plate_palladium", true) : null : null;
    public static final Item PLATE_TITANIUM = Configs.additions.Items ? Configs.compat.Mod("Thermal") ? new ItemBase("plate_titanium", true) : null : null;
    public static final Item PLATE_MERCURY = Configs.additions.Items ? Configs.compat.Mod("Thermal") ? new ItemBase("plate_mercury", true) : null : null;


    // Misc
    public static final Item NUGGET_LAPIS = Configs.additions.Items ? new ItemBase("nugget_lapis", true) : null;

    public static final Item NUGGET_BORON = Configs.additions.Items ?  Configs.compat.Mod("Nuclearcraft") ? new ItemBase("nugget_boron", true, 11842740) : null : null;
    public static final Item NUGGET_LITHIUM = Configs.additions.Items ?  Configs.compat.Mod("Nuclearcraft") ? new ItemBase("nugget_lithium", true, 16777215) : null : null;
    public static final Item NUGGET_THORIUM = Configs.additions.Items ?  Configs.compat.Mod("Nuclearcraft") ? new ItemBase("nugget_thorium", true, 4013373) : null : null;
    public static final Item NUGGET_URANIUM = Configs.additions.Items ?  Configs.compat.Mod("Nuclearcraft") ? new ItemBase("nugget_uranium", true, 5205326) : null : null;
    public static final Item NUGGET_MAGNESIUM = Configs.additions.Items ?  Configs.compat.Mod("Nuclearcraft") ? new ItemBase("nugget_magnesium", true, 15782125) : null : null;
    public static final Item NUGGET_GRAPHITE = Configs.additions.Items ?  Configs.compat.Mod("Nuclearcraft") ? new ItemBase("nugget_graphite", true, 3223857) : null : null;
    public static final Item NUGGET_BERYLLIUM = Configs.additions.Items ?  Configs.compat.Mod("Nuclearcraft") ? new ItemBase("nugget_beryllium", true, 13358774) : null : null;
    public static final Item NUGGET_ZIRCONIUM = Configs.additions.Items ?  Configs.compat.Mod("Nuclearcraft") ? new ItemBase("nugget_zirconium", true, 14540464) : null : null;
    public static final Item NUGGET_MANGANESE = Configs.additions.Items ?  Configs.compat.Mod("Nuclearcraft") ? new ItemBase("nugget_manganese", true, 11186124) : null : null;

    public static final Item NUGGET_AMETHYST = Configs.additions.Items ? Configs.compat.Mod("BiomesOPlenty") ? new ItemBase("nugget_amethyst", true) : null : null;
    public static final Item NUGGET_RUBY = Configs.additions.Items ? Configs.compat.Mod("BiomesOPlenty") ? new ItemBase("nugget_ruby", true) : null : null;
    public static final Item NUGGET_PERIDOT = Configs.additions.Items ? Configs.compat.Mod("BiomesOPlenty") ? new ItemBase("nugget_peridot", true) : null : null;
    public static final Item NUGGET_TOPAZ = Configs.additions.Items ? Configs.compat.Mod("BiomesOPlenty") ? new ItemBase("nugget_topaz", true) : null : null;
    public static final Item NUGGET_TANZANITE = Configs.additions.Items ? Configs.compat.Mod("BiomesOPlenty") ? new ItemBase("nugget_tanzanite", true) : null : null;
    public static final Item NUGGET_MALACHITE = Configs.additions.Items ? Configs.compat.Mod("BiomesOPlenty") ? new ItemBase("nugget_malachite", true) : null : null;
    public static final Item NUGGET_SAPPHIRE = Configs.additions.Items ? Configs.compat.Mod("BiomesOPlenty") ? new ItemBase("nugget_sapphire", true) : null : null;
    public static final Item NUGGET_AMBER = Configs.additions.Items ? Configs.compat.Mod("BiomesOPlenty") ? new ItemBase("nugget_amber", true) : null : null;

    public static final Item GEM_CINNABAR = Configs.additions.Items ? new ItemBase("gem_cinnabar", true) : null;


    public static final Item ICON_DOT = new ItemBase("icon_dot", false);
    public static final Item ICON_BLOCK1 = new ItemBase("icon_block1", false);
    public static final Item ICON_BLOCK2 = new ItemBase("icon_block2", false);
    public static final Item ICON_BLOCK3 = new ItemBase("icon_block3", false);
    public static final Item ICON_BLOCK4 = new ItemBase("icon_block4", false);

}
