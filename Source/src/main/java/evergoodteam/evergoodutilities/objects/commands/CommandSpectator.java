package evergoodteam.evergoodutilities.objects.commands;

import net.minecraft.command.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.GameType;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;

public class CommandSpectator extends CommandBase {

    /**
     * Gets the name of the command
     */
    public String getName() {

        return "sp";
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

        return "/sp [player]  - Puts into spectator";
    }

    /**
     * Callback for when the command is executed
     */
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {/*
            if (args.length <= 0)
            {
                throw new WrongUsageException("commands.gamemode.usage", new Object[0]);
            }
            else
            {*/
        GameType gametype = GameType.SPECTATOR;

        EntityPlayer entityplayer = args.length >= 1 ? getPlayer(server, sender, args[0]) : getCommandSenderAsPlayer(sender);
        entityplayer.setGameType(gametype);
        ITextComponent itextcomponent = new TextComponentTranslation("gameMode." + gametype.getName(), new Object[0]);

        if (sender.getEntityWorld().getGameRules().getBoolean("sendCommandFeedback")) {
            entityplayer.sendMessage(new TextComponentTranslation("gameMode.changed", new Object[]{itextcomponent}));
        }

        if (entityplayer == sender) {
            notifyCommandListener(sender, this, 1, "commands.gamemode.success.self", new Object[]{itextcomponent});
        } else {
            notifyCommandListener(sender, this, 1, "commands.gamemode.success.other", new Object[]{entityplayer.getName(), itextcomponent});
        }
    }

    /**
     * Get a list of options for when the user presses the TAB key
     */
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos) {
        return args.length == 1 ? getListOfStringsMatchingLastWord(args, server.getOnlinePlayerNames()) : Collections.emptyList();
    }

    /**
     * Return whether the specified command parameter index is a username parameter.
     */
    public boolean isUsernameIndex(String[] args, int index) {
        return index == 1;
    }
}
