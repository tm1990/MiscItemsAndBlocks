package Mod.Commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.util.ChatMessageComponent;
import Mod.Util.Strings;
import Mod.VersionChecker.VersionChecker;

public class CommandVersion extends CommandBase{

    public void processCommand(ICommandSender commandSender, String[] args) {

        String subCommand;

        if (args.length > 0) {
            subCommand = args[0];

            if (subCommand.toLowerCase().equals(Strings.COMMAND_VERSION)) {
                processVersionCommand(commandSender);
            }
            else if (subCommand.toLowerCase().equals(Strings.COMMAND_CHANGELOG)) {
                processChangelogCommand(commandSender);
            }
            else
                throw new WrongUsageException(Strings.COMMAND_VERSION_USAGE, new Object[0]);
        }
        else
            throw new WrongUsageException(Strings.COMMAND_VERSION_USAGE, new Object[0]);
    }

    private static void processVersionCommand(ICommandSender commandSender) {

        commandSender.sendChatToPlayer(ChatMessageComponent.func_111077_e(VersionChecker.getResultMessage() + "Test"));
    }

    private static void processChangelogCommand(ICommandSender commandSender) {

    }

	@Override
	public String getCommandName() {
		return "MiscVersion";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		return null;
	}
	
    @Override
    public boolean canCommandSenderUseCommand(ICommandSender commandSender) {

        return true;
    }
}