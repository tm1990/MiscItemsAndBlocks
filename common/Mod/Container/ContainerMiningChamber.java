package Mod.Container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import Mod.Slots.SlotPowerStorage;
import Mod.TileEntity.TileEntityCharger;
import Mod.TileEntity.TileEntityMiningChamber;
import Mod.TileEntity.TileEntityXpStorage;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerMiningChamber  extends Container {

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return tile.isUseableByPlayer(entityplayer);
	}
	
    private TileEntityMiningChamber tile;
    
    int LastPower;
    int LastBlocksMined;
    int LastY;
    int LastLastY;

	
    public ContainerMiningChamber(InventoryPlayer InvPlayer, TileEntityMiningChamber tile)
    {
    	this.tile = tile;
    	
    	for(int x = 0; x < 9; x++){
    		
    		addSlotToContainer(new Slot(InvPlayer, x, 8 + 18 * x, 181));
    	}
    	
    	for(int y = 0; y < 3; y++){
    		for(int x = 0; x < 9; x++){
    			
    			addSlotToContainer(new Slot(InvPlayer, x + y * 9 + 9, 8 + 18 * x, 123 + y * 18));
    		}

    }
    	
    	
    	
    	
    	addSlotToContainer(new Slot(tile, tile.ToolSlot, 24, 24));

}
    

    

	 public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
	    {
	        ItemStack itemstack = null;
	        Slot slot = (Slot)this.inventorySlots.get(par2);

	        if (slot != null && slot.getHasStack())
	        {
	            ItemStack itemstack1 = slot.getStack();
	            itemstack = itemstack1.copy();

	            if (par2 < 3 * 9)
	            {
	                if (!this.mergeItemStack(itemstack1, 3 * 9, this.inventorySlots.size(), true))
	                {
	                    return null;
	                }
	            }
	            else if (!this.mergeItemStack(itemstack1, 0, 3 * 9, false))
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
    
 
    public void addCraftingToCrafters(ICrafting par1ICrafting)
    {
        super.addCraftingToCrafters(par1ICrafting);
        par1ICrafting.sendProgressBarUpdate(this, 0, this.tile.GetPower());
        par1ICrafting.sendProgressBarUpdate(this, 1, this.tile.GetBlocksMined());
        par1ICrafting.sendProgressBarUpdate(this, 2, this.tile.GetMinedY());
        par1ICrafting.sendProgressBarUpdate(this, 3, this.tile.GetLastY());
    }

    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); ++i)
        {
            ICrafting icrafting = (ICrafting)this.crafters.get(i);

            if (this.LastPower != this.tile.GetPower())
            {
                icrafting.sendProgressBarUpdate(this, 0, this.tile.GetPower());
            }
            
            if (this.LastBlocksMined != this.tile.GetBlocksMined())
            {
                icrafting.sendProgressBarUpdate(this, 1, this.tile.GetBlocksMined());
            }
            
            if (this.LastY != this.tile.GetMinedY())
            {
                icrafting.sendProgressBarUpdate(this, 2, this.tile.GetMinedY());
            }
            
            if (this.LastLastY != this.tile.GetLastY())
            {
                icrafting.sendProgressBarUpdate(this, 3, this.tile.GetLastY());
            }
            
        }

        this.LastPower = this.tile.GetPower();
        this.LastBlocksMined = this.tile.GetBlocksMined();
        this.LastY = this.tile.GetMinedY();
        this.LastLastY = this.tile.GetLastY();
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int par1, int par2)
    {
        if (par1 == 0)
        {
            this.tile.SetPower(par2);
        }
        
        if (par1 == 1)
        {
            this.tile.SetBlocksMined(par2);
        }
        
        if (par1 == 2)
        {
            this.tile.SetMinedY(par2);
        }
        
        if (par1 == 3)
        {
            this.tile.SetLastY(par2);
        }
        

    }
    
	public TileEntityMiningChamber getTile() {
		return tile;
	}
}
