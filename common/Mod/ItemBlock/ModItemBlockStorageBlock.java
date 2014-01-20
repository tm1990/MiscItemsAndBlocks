package Mod.ItemBlock;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import Mod.Block.ModBlocks;
import Mod.TileEntity.TileEntityBox;
import Mod.TileEntity.TileEntityStorageBlock;

public class ModItemBlockStorageBlock extends ItemBlock {

	public ModItemBlockStorageBlock(int par1) {
		super(par1);
	}

	
	 public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata)
	    {
	      
		 if(stack.stackTagCompound != null){
			 world.setBlock(x, y, z, ModBlocks.StorageBlock.blockID);
			 if(world.getBlockTileEntity(x, y, z) != null){
				 TileEntityStorageBlock tile = (TileEntityStorageBlock)world.getBlockTileEntity(x, y, z);
				 
					NBTTagList items = stack.stackTagCompound.getTagList("Items");
		    		
		    		for(int i = 0; i < items.tagCount(); i++){
		    			
		    			NBTTagCompound item = (NBTTagCompound)items.tagAt(i);
		    			int slot = item.getByte("Slot");
		    			
		    			if(slot >= 0 && slot < tile.getSizeInventory()){
		    				tile.setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(item));
		    				
		    			}
		    			

		    		}
			 }
			 
			 
		 }else{
			 world.setBlock(x, y, z, ModBlocks.StorageBlock.blockID); 
		 }
	       return true;
	    }
	 
	    @Override
	    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
	    {
	    	
	    	if(itemstack.stackTagCompound != null){


	    		if(itemstack.stackTagCompound.getInteger("ItemsNumber") == 0){
	    			itemstack.setTagCompound(null);
	    		}
	    		
				
					list.add("Stored items " + itemstack.stackTagCompound.getInteger("ItemsNumber") + " of " + itemstack.stackTagCompound.getInteger("MaxItems"));

	    		
	    		
	    	}else{
    			list.add("Storage is empty");
	    	}
	    }
}
