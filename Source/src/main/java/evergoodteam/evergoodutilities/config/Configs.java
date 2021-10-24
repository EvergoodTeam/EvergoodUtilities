package evergoodteam.evergoodutilities.config;


import evergoodteam.evergoodutilities.compat.ModLoaded;
import evergoodteam.evergoodutilities.util.Reference;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.RequiresMcRestart;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


@Config(modid = Reference.MOD_ID)
public class Configs {

    @Comment("Configs related to the blocks, fluids and items added")
    public static Additions additions = new Additions(true, true, true);

    public static class Additions{

        @RequiresMcRestart
        @Comment("Enable/Disable every block added by this mod and everything related to them (recipes)")
        public boolean Blocks;
        @RequiresMcRestart
        @Comment("Enable/Disable every fluid added by this mod and everything related to them (recipes)")
        public boolean Fluids;
        @RequiresMcRestart
        @Comment("Enable/Disable every item added by this mod and everything related to them (recipes)")
        public boolean Items;


        public Additions(final boolean Blocks, final boolean Fluids, final boolean Items) {

            this.Blocks = Blocks;
            this.Fluids = Fluids;
            this.Items = Items;
        }

        // Used by recipe conditions
        public boolean Additions(String name){

            switch (name) {
                case "Blocks":
                    return additions.Blocks;
                case "Fluids":
                    return additions.Fluids;
                case "Items":
                    return additions.Items;
                default:
                    if (additions.Blocks && additions.Fluids && additions.Items) return true;
                    else return false;
            }
        }
    }


    @Comment("Configs related to compatibility with other mods")
    public static Compat compat = new Compat(true, true, true, true, true, true, true);

    public static class Compat{

        @RequiresMcRestart
        @Comment("Enable/Disable every item and recipe added as integration")
        public boolean Mekanism;
        @RequiresMcRestart
        @Comment("Enable/Disable every recipe added as integration")
        public boolean Thermal;
        @RequiresMcRestart
        @Comment("Enable/Disable every recipe added as integration")
        public boolean TinkersConstruct;
        @RequiresMcRestart
        @Comment("Enable/Disable every recipe added as integration")
        public boolean ImmersiveEngineering;
        @RequiresMcRestart
        @Comment("Enable/Disable every item and recipe added as integration")
        public boolean Nuclearcraft;
        @RequiresMcRestart
        @Comment("Enable/Disable every item and recipe added as integration")
        public boolean BiomesOPlenty;
        @RequiresMcRestart
        @Comment("Enable/Disable every OreDictionary entry added. Note that this can and will break some recipes")
        public boolean OreDictionary;


        public Compat(final boolean Mekanism, final boolean Thermal, final boolean TinkersConstruct, final boolean ImmersiveEngineering, final boolean Nuclearcraft, final boolean BiomesOPlenty, final boolean OreDictionary) {

            this.Mekanism = Mekanism;
            this.Thermal = Thermal;
            this.TinkersConstruct = TinkersConstruct;
            this.ImmersiveEngineering = ImmersiveEngineering;
            this.Nuclearcraft = Nuclearcraft;
            this.BiomesOPlenty = BiomesOPlenty;
            this.OreDictionary = OreDictionary;
        }

        public boolean Mod(String name){

            switch (name) {
                case "Mekanism":
                    if(ModLoaded.id("mekanism")) return compat.Mekanism;
                    else return false;
                case "Thermal":
                    if(ModLoaded.id("thermalexpansion")) return compat.Thermal;
                    else return false;
                case "TinkersConstruct":
                    if(ModLoaded.id("tconstruct")) return compat.TinkersConstruct;
                    else return false;
                case "ImmersiveEngineering":
                    if(ModLoaded.id("immersiveengineering")) return compat.ImmersiveEngineering;
                    else return false;
                case "Nuclearcraft":
                    if(ModLoaded.id("nuclearcraft")) return compat.Nuclearcraft;
                    else return false;
                case "BiomesOPlenty":
                    if(ModLoaded.id("biomesoplenty")) return compat.BiomesOPlenty;
                    else return false;
                default:
                    return true;
            }
        }
    }

    @Comment("Configs related to the commands added")
    public static Cmds commands = new Cmds(true, true, true, true);

    public static class Cmds{

        @RequiresMcRestart
        @Comment("Enable/Disable the /sunny command")
        public boolean Sunny;
        @RequiresMcRestart
        @Comment("Enable/Disable the /nv command")
        public boolean Nightvision;
        @RequiresMcRestart
        @Comment("Enable/Disable the /sp command")
        public boolean Spectator;
        @RequiresMcRestart
        @Comment("Enable/Disable the /text command")
        public boolean Text;


        public Cmds(final boolean Sunny, final boolean Nightvision, final boolean Spectator, final boolean Text) {

            this.Sunny = Sunny;
            this.Nightvision = Nightvision;
            this.Spectator = Spectator;
            this.Text = Text;
        }
    }



    @EventBusSubscriber(modid = Reference.MOD_ID)
    private static class EventHandler{

        @SubscribeEvent
        public static void onConfigChanged(final ConfigChangedEvent.OnConfigChangedEvent event) {

            if (event.getModID().equals(Reference.MOD_ID)) {
                ConfigManager.sync(Reference.MOD_ID, Config.Type.INSTANCE);
            }
        }
    }
}
