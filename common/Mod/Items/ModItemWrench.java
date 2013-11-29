package Mod.Items;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import Mod.Block.ModBlockPowerCable;
import Mod.Lib.Refrence;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModItemWrench extends Item{

	public ModItemWrench(int par1) {
		super(par1);
	}

	
	   @SideOnly(Side.CLIENT)
	   public void registerIcons(IconRegister par1IconRegister)
	   {
		   this.itemIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":Wrench");
		   
	   }
	   
	    public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10)
	    {
	    	
	    	int BlockId = world.getBlockId(x, y, z);
	    	Block block = Block.blocksList[BlockId];
	    	
	    	if(block instanceof ModBlockPowerCable){
	    	if(!world.isRemote){
	    		
	    		
		    	int Meta = world.getBlockMetadata(x, y, z);


		    	
		    		if(player.isSneaking()){
		    			if(Meta > 0){
		    	    		world.setBlockMetadataWithNotify(x, y, z, Meta - 1, 2);
		    		    	Meta = world.getBlockMetadata(x, y, z);
		    	    	}
		    	    	
		    	    		player.addChatMessage(ModBlockPowerCable.messages[Meta]);

		    			
		    		}
		    	}
	    	}

	    	
	    	return true;
	    }
}
