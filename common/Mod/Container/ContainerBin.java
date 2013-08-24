package Mod.Container;

import Mod.TileEntity.TileEntityBin;
import Mod.TileEntity.TileEntityXpStorage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerBin extends Container{

    private TileEntityBin tile;
    
    public ContainerBin(InventoryPlayer InvPlayer, TileEntityBin tile)
    {
    	this.tile = tile;
    	
    	addSlotToContainer(new Slot(tile, 0, 80, 30));
    	
    	for(int x = 0; x < 9; x++){
    		
    		addSlotToContainer(new Slot(InvPlayer, x, 8 + 18 * x, 142));
    	}
    	
    	for(int y = 0; y < 3; y++){
    		for(int x = 0; x < 9; x++){
    			
    			addSlotToContainer(new Slot(InvPlayer, x + y * 9 + 9, 8 + 18 * x, 84 + y * 18));
    		}
    		
    		
    	}

}
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return tile.isUseableByPlayer(entityplayer);
	}

	
	  public ItemStack transferStackInSlot(EntityPlayer player, int Slot)
	    {
		  Slot = Slot - 1;
		  player.inventory.setInventorySlotContents(Slot, null);
	       return player.inventory.getStackInSlot(Slot);
	    }
	  
	  
}
