package evergoodteam.evergoodutilities.objects.commands;


import net.minecraft.command.*;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.play.server.SPacketEntityStatus;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.storage.WorldInfo;

import java.util.Random;


public class CommandSunny extends CommandBase {

    /**
     * Gets the name of the command
     */
    public String getName() {

        return "sunny";
    }


    /**
     * Return the required permission level for this command.
     */
    public int getRequiredPermissionLevel() {

        return 2;
    }


    /**
     * Gets the usage string for the command.
     */
    public String getUsage(ICommandSender sender) {

        return "/sunny  - Disables doDaylightCycle, doWeatherCycle and sets time to cleared day";
    }


    /**
     * Callback for when the command is executed
     */
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {

        GameRules gamerules = this.getOverWorldGameRules(server);
        String gamerule = "doDaylightCycle";
        String gamerule1 = "doWeatherCycle";
        String bool = "false";

        gamerules.setOrCreateGameRule(gamerule, bool);
        notifyGameRuleChange(gamerules, gamerule, server);
        notifyCommandListener(sender, this, "commands.gamerule.success", new Object[] {gamerule, bool});

        gamerules.setOrCreateGameRule(gamerule1, bool);
        notifyGameRuleChange(gamerules, gamerule1, server);
        notifyCommandListener(sender, this, "commands.gamerule.success", new Object[] {gamerule1, bool});

        int i = (300 + (new Random()).nextInt(600)) * 20;

        World world = server.worlds[0];
        WorldInfo worldinfo = world.getWorldInfo();

        worldinfo.setCleanWeatherTime(i);
        worldinfo.setRainTime(0);
        worldinfo.setThunderTime(0);
        worldinfo.setRaining(false);
        worldinfo.setThundering(false);
        notifyCommandListener(sender, this, "commands.weather.clear", new Object[0]);

        int time = 1000;
        this.setAllWorldTimes(server, time);
        notifyCommandListener(sender, this, "commands.time.set", new Object[] {time});
        return;
    }


    public static void notifyGameRuleChange(GameRules rules, String p_184898_1_, MinecraftServer server) {

        if ("reducedDebugInfo".equals(p_184898_1_)) {

            byte b0 = (byte)(rules.getBoolean(p_184898_1_) ? 22 : 23);

            for (EntityPlayerMP entityplayermp : server.getPlayerList().getPlayers()) {

                entityplayermp.connection.sendPacket(new SPacketEntityStatus(entityplayermp, b0));
            }
        }

        net.minecraftforge.event.ForgeEventFactory.onGameRuleChange(rules, p_184898_1_, server);
    }

    private GameRules getOverWorldGameRules(MinecraftServer server) {

        return server.getWorld(0).getGameRules();
    }


    protected void setAllWorldTimes(MinecraftServer server, int time) {

        for (int i = 0; i < server.worlds.length; ++i) {

            server.worlds[i].setWorldTime((long)time);
        }
    }
}