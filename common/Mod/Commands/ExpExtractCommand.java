package Mod.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Mod.Items.ModItems;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.EnumChatFormatting;

public class ExpExtractCommand extends CommandBase{


	private List aliases;
	public ExpExtractCommand(){
		
		this.aliases = new ArrayList();
	    this.aliases.add("ExpExtract");
	    this.aliases.add("Extract");

		
	}
	
	@Override
	public int compareTo(Object arg0) {
		return 0;
	}

	@Override
	public String getCommandName() {
		return "Exp Extract";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		return "/ExpExtract <type(Level/Xp)> <player> <amount> [player]";
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
		
		
	    if(astring.length < 2)
	    {
	    	icommandsender.sendChatToPlayer(Error());
	    	
	      return;
	    }
	    
	    if(astring.length >= 3){
	    	
	    	String Type = astring[0].toLowerCase();
	    	
            EntityPlayer player = func_82359_c(icommandsender, astring[1]);
            
            if(!player.capabilities.isCreativeMode && player.inventory.getCurrentItem().itemID != ModItems.XpExtractor.itemID){
            	
            	icommandsender.sendChatToPlayer(ChatMessageComponent.func_111082_b("Must have Xp Extractor selected to extract!").func_111059_a(EnumChatFormatting.RED));
                return;
            	
            }else{
            	

	    		int Amount = parseInt(icommandsender, astring[2]);
	    		
            	if(player.inventory.getCurrentItem().getItemDamage() - player.inventory.getCurrentItem().getMaxDamage() > 40){

            	
            
	    		
	    		if(astring.length >= 4){
	    	
	    			
	    			EntityPlayer playerTwo = func_82359_c(icommandsender, astring[3]);
	    			

	    			if(Type == "xp"){
	    				
	    				if(player.experience >= Amount){
	    				icommandsender.sendChatToPlayer(ChatMessageComponent.func_111082_b("Extracted : " + Amount + " " + Type + " From " + player.username + " and transferd to " + playerTwo.username));
	    				player.addExperience(-Amount);
	    				playerTwo.addExperience(Amount);
	    				if(!player.capabilities.isCreativeMode)
		    				DamageItem(player.inventory.getCurrentItem(), player);
	    				}
	    			}else if (Type == "level"){
	    				
	    				if(player.experienceLevel >= Amount){
	    				icommandsender.sendChatToPlayer(ChatMessageComponent.func_111082_b("Extracted : " + Amount + " " + Type + " From " + player.username + " and transferd to " + playerTwo.username));
	    				player.addExperienceLevel(-Amount);
	    				playerTwo.addExperienceLevel(Amount);
	    				if(!player.capabilities.isCreativeMode)
		    				DamageItem(player.inventory.getCurrentItem(), player);
	    				}
	    			}
	    			
	    		}
	    			
	    			
	    		}
            else{
	    			

	    			if(Type == "xp"){
	    				
	    				
	    				if(player.experience >= Amount){
	    				icommandsender.sendChatToPlayer(ChatMessageComponent.func_111082_b("Extracted : " + Amount + " " + Type + " From " + player.username));
	    				player.addExperience(-Amount);
	    				if(!player.capabilities.isCreativeMode)
		    				DamageItem(player.inventory.getCurrentItem(), player);
	    				
	    				}
	    			}else if(Type == "leve"){
	    				
	    				
	    				if(player.experienceLevel >= Amount){
	    				icommandsender.sendChatToPlayer(ChatMessageComponent.func_111082_b("Extracted : " + Amount + " " + Type + " From " + player.username));
	    				player.addExperienceLevel(-Amount);
	    				if(!player.capabilities.isCreativeMode)
	    				DamageItem(player.inventory.getCurrentItem(), player);
	    				}
	    			}
	    			
	    		}
	    			
	    		}	
	    		}else{
	    	    	
	    	    	icommandsender.sendChatToPlayer(ChatMessageComponent.func_111082_b("Duribility Too Low!").func_111059_a(EnumChatFormatting.RED));
	    	        return;
	    		}
            	
	    		
	    		
	    		}
	             
	    			
	    		  



	@Override
	public boolean canCommandSenderUseCommand(ICommandSender icommandsender) {
		return true;
	}

    public List addTabCompletionOptions(ICommandSender par1ICommandSender, String[] par2ArrayOfStr)
    {
    	
    	if(par2ArrayOfStr.length == 2 || par2ArrayOfStr.length == 4){
    		
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
	
	public ChatMessageComponent Error(){
		
		return ChatMessageComponent.func_111082_b("Command Usage : /ExpExtract <type(Level/Xp)> <player> <amount> [player]").func_111059_a(EnumChatFormatting.RED);
	}
	
	public void DamageItem(ItemStack item, EntityPlayer player) {
		
		
		if(!player.capabilities.isCreativeMode){
			
			if(player.inventory.getCurrentItem().getItemDamage() >= player.inventory.getCurrentItem().getMaxDamage() || player.inventory.getCurrentItem().getItemDamage() == 480){

			}else{
				
				player.inventory.getCurrentItem().damageItem(40, player);
				System.out.println(player.inventory.getCurrentItem().getItemDamage());
				
			}
			
		}
		
	}

}
