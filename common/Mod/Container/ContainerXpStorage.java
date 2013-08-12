package Mod.Container;


import Mod.TileEntity.TileEntityXpStorage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerXpStorage extends Container
{

    private TileEntityXpStorage tile;

    public ContainerXpStorage(InventoryPlayer InvPlayer, TileEntityXpStorage tile)
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
    	


}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return tile.isUseableByPlayer(entityplayer);
	}
	
	@Override 
	public ItemStack transferStackInSlot(EntityPlayer player ,int i){
		return null;
		
	}
	
	public TileEntityXpStorage getTile() {
		return tile;
	}
}



