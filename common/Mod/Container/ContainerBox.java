package Mod.Container;

import Mod.TileEntity.TileEntityBox;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerBox extends Container{

    private TileEntityBox tile;
    
    int numRows = 3;
	
    public ContainerBox(InventoryPlayer InvPlayer, TileEntityBox tile)
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
    	
    	for(int i = 0; i != 5; i++){
    		
    		addSlotToContainer(new Slot(tile, i, 44 + (18 * i), 15));
    	}
    	
    	for(int i = 0; i != 5; i++){
    		
    		addSlotToContainer(new Slot(tile, i + 5, 44 + (18 * i), 33));
    	}
    	
    	for(int i = 0; i != 5; i++){
    		
    		addSlotToContainer(new Slot(tile, i + 10, 44 + (18 * i), 51));
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

	            if (par2 < this.numRows * 9)
	            {
	                if (!this.mergeItemStack(itemstack1, this.numRows * 9, this.inventorySlots.size(), true))
	                {
	                    return null;
	                }
	            }
	            else if (!this.mergeItemStack(itemstack1, 0, this.numRows * 9, false))
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
	        }

	        return itemstack;
	    }
	 
	    public void onContainerClosed(EntityPlayer par1EntityPlayer)
	    {
	        super.onContainerClosed(par1EntityPlayer);
	        this.tile.closeChest();
	    }
	    
	    public IInventory getLowerChestInventory()
	    {
	        return this.tile;
	    }

}
