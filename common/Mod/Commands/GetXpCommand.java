package Mod.Commands;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.EnumChatFormatting;

public class GetXpCommand extends CommandBase{

	private List aliases;
	public GetXpCommand(){
		
		this.aliases = new ArrayList();
	    this.aliases.add("GetXp");

		
	}
	
	@Override
	public int compareTo(Object arg0) {
		return 0;
	}

	@Override
	public String getCommandName() {
		return "GetExp";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		return "/GetXp <player>";
	}
	
	@Override
	public List getCommandAliases() {
		return this.aliases;
	}
	
    public int getRequiredPermissionLevel()
    {
        return 2;
    }

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		
		if(astring.length >= 1){
		
            EntityPlayer player = func_82359_c(icommandsender, astring[0]);
            
            icommandsender.sendChatToPlayer(ChatMessageComponent.func_111082_b("Experience of player " + player.username + " was Exp : " + player.experience + " Exp Level : " + player.experienceLevel + " Exp Total : " + player.experienceTotal));
			
			
			
		}else{
			
			
			icommandsender.sendChatToPlayer(Error(icommandsender));
		}
		
	}
	
	@Override
	public boolean canCommandSenderUseCommand(ICommandSender icommandsender) {
		return true;
	}

    public List addTabCompletionOptions(ICommandSender par1ICommandSender, String[] par2ArrayOfStr)
    {
    	
    	if(par2ArrayOfStr.length == 1){
    		
    		return getListOfStringsMatchingLastWord(par2ArrayOfStr, this.getPlayers());
    	}
    return null;
    }
	
    protected String[] getPlayers()
    {
        return MinecraftServer.getServer().getAllUsernames();
    }

    public boolean isUsernameIndex(String[] par1ArrayOfStr, int par2)
    {
        return par2 == 0;
    }
    
	public ChatMessageComponent Error(ICommandSender sender){
		
		return ChatMessageComponent.func_111082_b(getCommandUsage(sender)).func_111059_a(EnumChatFormatting.RED);
	}

}
