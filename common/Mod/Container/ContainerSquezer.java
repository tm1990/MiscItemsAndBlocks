package Mod.Container;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import Mod.Slots.SlotFruit;
import Mod.Slots.SlotLiquidContainer;
import Mod.Slots.SlotOutput;
import Mod.TileEntity.TileEntitySquezer;

public class ContainerSquezer  extends Container {

	public TileEntitySquezer tile;
    private int workTime;
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return tile.isUseableByPlayer(entityplayer);
	}
	
	
    public ContainerSquezer(InventoryPlayer InvPlayer, TileEntitySquezer tile)
    {
    	this.tile = tile;
    	
    	for(int x = 0; x < 9; x++){
    		
    		addSlotToContainer(new Slot(InvPlayer, x, 8 + 18 * x, 142));
    	}
    	
    	for(int y = 0; y < 3; y++){
    		for(int x = 0; x < 9; x++){
    			
    			addSlotToContainer(new Slot(InvPlayer, x + y * 9 + 9, 8 + 18 * x, 84 + y * 18));
    		}
    		
    		addSlotToContainer(new SlotLiquidContainer(tile, 0, 62, 11));
    		addSlotToContainer(new SlotFruit(tile, 1, 98, 11));
    		addSlotToContainer(new SlotOutput(tile, 2, 80, 57));
    	
    }

}
    

    @Override
	  public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
	    {

		  return null;
	    }
    
    public void addCraftingToCrafters(ICrafting par1ICrafting)
    {
        super.addCraftingToCrafters(par1ICrafting);
        par1ICrafting.sendProgressBarUpdate(this, 0, this.tile.GetWorkTime());
    }

    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); ++i)
        {
            ICrafting icrafting = (ICrafting)this.crafters.get(i);

            if (this.workTime != this.tile.GetWorkTime())
            {
                icrafting.sendProgressBarUpdate(this, 0, this.tile.GetWorkTime());
            }
        }

        this.workTime = this.tile.GetWorkTime();
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int par1, int par2)
    {
        if (par1 == 0)
        {
            this.tile.setWorkTime(par2);
        }
    }
	  

}
