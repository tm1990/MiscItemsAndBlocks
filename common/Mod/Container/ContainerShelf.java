package Mod.Container;

import Mod.TileEntity.TileEntityShelf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


public class ContainerShelf extends Container {

    private TileEntityShelf tile;
	
    public ContainerShelf(InventoryPlayer InvPlayer, TileEntityShelf tile)
    {
    	this.tile = tile;
    	
    	
    	for(int x = 0; x < 9; x++){
    		
    		addSlotToContainer(new Slot(InvPlayer, x, 8 + 18 * x, 142));
    	}
    	
    	for(int y = 0; y < 3; y++){
    		for(int x = 0; x < 9; x++){
    			
    			addSlotToContainer(new Slot(InvPlayer, x + y * 9 + 9, 8 + 18 * x, 84 + y * 18));
    		}
    		
    		
    	}
    	
    	for (int x = 0; x < 4; x++){
    		
    		addSlotToContainer(new Slot(tile, x, 52 + x * 18, 18));
    		
    	}
    	
    	for (int y = 0; y < 4; y++){
    		
    		int x = y + 4;
    		addSlotToContainer(new Slot(tile, x, 52 + y * 18, 45));
    		
    	}
    	

}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return tile.isUseableByPlayer(entityplayer);
	}
	
	  public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
	    {
	        ItemStack itemstack = null;
	        Slot slot = (Slot)this.inventorySlots.get(par2);

	        if (slot != null && slot.getHasStack())
	        {
	            ItemStack itemstack1 = slot.getStack();
	            itemstack = itemstack1.copy();

	            if (par2 == 0)
	            {
	                if (!this.mergeItemStack(itemstack1, 10, 46, true))
	                {
	                    return null;
	                }

	                slot.onSlotChange(itemstack1, itemstack);
	            }
	            else if (par2 >= 10 && par2 < 37)
	            {
	                if (!this.mergeItemStack(itemstack1, 37, 46, false))
	                {
	                    return null;
	                }
	            }
	            else if (par2 >= 37 && par2 < 46)
	            {
	                if (!this.mergeItemStack(itemstack1, 10, 37, false))
	                {
	                    return null;
	                }
	            }
	            else if (!this.mergeItemStack(itemstack1, 10, 46, false))
	            {
	                return null;
	            }

	            if (itemstack1.stackSize == 0)
	            {
	                slot.putStack((ItemStack)null);
	            }
	            else
	            {
	                slot.onSlotChanged();
	            }

	            if (itemstack1.stackSize == itemstack.stackSize)
	            {
	                return null;
	            }

	            slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
	        }

	        return itemstack;
	    }
}
