package evergoodteam.evergoodutilities.objects.commands;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.GameType;
import net.minecraftforge.common.util.EnumHelper;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;

import static java.awt.SystemColor.text;

/**
 * Created by User on 18/09/2021.
 */
public class CommandText extends CommandBase {


    public static String stringToRainbow(String parString, boolean parReturnToBlack)
    {
        int stringLength = parString.length();
        if (stringLength < 1)
        {
            return "";
        }
        String outputString = "";
        TextFormatting[] colorChar =
                {
                        TextFormatting.RED,
                        TextFormatting.GOLD,
                        TextFormatting.YELLOW,
                        TextFormatting.GREEN,
                        TextFormatting.AQUA,
                        TextFormatting.BLUE,
                        TextFormatting.LIGHT_PURPLE,
                        TextFormatting.DARK_PURPLE
                };
        for (int i = 0; i < stringLength; i++)
        {
            outputString = outputString+colorChar[i%8]+parString.substring(i, i+1);
        }
        // return color to a common one after (most chat is white, but for other GUI might want black)
        if (parReturnToBlack)
        {
            return outputString+TextFormatting.BLACK;
        }
        return outputString+TextFormatting.WHITE;
    }



    public String getName() {

        return "text";
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

        return "/text <text>  - Sends back your text colored";
    }

    /**
     * Callback for when the command is executed
     */
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {

        TextComponentString message = new TextComponentString(stringToRainbow(args[0], true));
        sender.sendMessage(message);
    }
}
