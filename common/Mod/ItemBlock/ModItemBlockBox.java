package Mod.ItemBlock;

import java.util.List;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.settings.GameSettings;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import Mod.Block.ModBlocks;
import Mod.TileEntity.TileEntityBox;

public class ModItemBlockBox extends ItemBlock {

	public ModItemBlockBox(int par1) {
		super(par1);
	}

	
	 public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata)
	    {
	      
		 if(stack.stackTagCompound != null){
			 world.setBlock(x, y, z, ModBlocks.Box.blockID);
			 if(world.getBlockTileEntity(x, y, z) != null){
				 TileEntityBox tile = (TileEntityBox)world.getBlockTileEntity(x, y, z);
				 
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
			 world.setBlock(x, y, z, ModBlocks.Box.blockID); 
		 }
	       return true;
	    }
	 
	 
	 //TODO Add shift functionality to other items
	    @Override
	    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
	    {
	    
	    	
	    	if(Keyboard.isKeyDown(42)){
	    	if(itemstack.stackTagCompound != null){


	    		
				NBTTagList items = itemstack.stackTagCompound.getTagList("Items");
	    		if(items.tagCount() > 0)
	    		list.add("Contains: ");
	    		else
	    			list.add("Cardboard box is empty");
	    		for(int i = 0; i < items.tagCount(); i++){
	    			
	    			NBTTagCompound item = (NBTTagCompound)items.tagAt(i);

	    			list.add("- " + ItemStack.loadItemStackFromNBT(item).getDisplayName() + " x" + ItemStack.loadItemStackFromNBT(item).stackSize);
	    			
    				ItemStack stack = ItemStack.loadItemStackFromNBT(item);
    				
    				if(stack.getItem() instanceof ItemTool){
    					list.remove(list.size() - 1);
    	    			list.add("- " + stack.getDisplayName() + " x" + stack.stackSize + " Dur.:" + (stack.getMaxDamage() - stack.getItemDamage() + "/" + stack.getItemDamage()));
    				}
	    				
	    				if(stack.stackTagCompound != null && stack.stackTagCompound.hasKey("ench")){
	    					
		    				list.add("  - Enchantments: ");
	    					
	    					 NBTTagList nbttaglist = (NBTTagList)stack.stackTagCompound.getTag("ench");

	    				        if (nbttaglist != null)
	    				        {
	    				            for (int j = 0; j < nbttaglist.tagCount(); ++j)
	    				            {
	    				                short short1 = ((NBTTagCompound)nbttaglist.tagAt(j)).getShort("id");
	    				                short short2 = ((NBTTagCompound)nbttaglist.tagAt(j)).getShort("lvl");

	    				                if (Enchantment.enchantmentsList[short1] != null)
	    				                {
	    				                    list.add("    - " + Enchantment.enchantmentsList[short1].getTranslatedName(short2));
	    				                }
	    				            }
	    				        }
	    				}

	    				
	    			
	    			

	    		}
	    		
	    		
	    	}else{
    			list.add("Cardboard box is empty");
	    	}
	    	
	    	}else{
	    		list.add("< Hold Shift for info >");
	    	}
	    }
}
