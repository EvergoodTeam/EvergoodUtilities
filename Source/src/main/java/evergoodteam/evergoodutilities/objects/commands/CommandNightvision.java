package evergoodteam.evergoodutilities.objects.commands;


import net.minecraft.command.*;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;


public class CommandNightvision extends CommandBase {
    /**
     * Gets the name of the command
     */
    public String getName() {
        return "nv";
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

        return "/nv [player]  - Gives permanent nightvision";
    }

    /**
     * Callback for when the command is executed
     */
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {

        if (args.length < 1) {

            throw new WrongUsageException("/nv [player]", new Object[0]);
        } else {

            EntityLivingBase entitylivingbase = (EntityLivingBase) getEntity(server, sender, args[0], EntityLivingBase.class);

            Potion potion;

            potion = Potion.getPotionFromResourceLocation("minecraft:night_vision");


            int i = 199980;
            int j = 9999;
            int k = 0;


            boolean flag = true;

            if (j > 0) {

                PotionEffect potioneffect = new PotionEffect(potion, i, k, false, flag);
                entitylivingbase.addPotionEffect(potioneffect);
                notifyCommandListener(sender, this, "commands.effect.success", new Object[]{new TextComponentTranslation(potioneffect.getEffectName(), new Object[0]), Potion.getIdFromPotion(potion), k, entitylivingbase.getName(), j});
            }

            else if (entitylivingbase.isPotionActive(potion)) {

                entitylivingbase.removePotionEffect(potion);
                notifyCommandListener(sender, this, "commands.effect.success.removed", new Object[]{new TextComponentTranslation(potion.getName(), new Object[0]), entitylivingbase.getName()});
            }

            else {

                throw new CommandException("commands.effect.failure.notActive", new Object[]{new TextComponentTranslation(potion.getName(), new Object[0]), entitylivingbase.getName()});
            }
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
        return index == 0;
    }
}
