package Mod.Container;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.world.World;
import Mod.Gui.SlotCraftingInvOutput;
import Mod.Gui.SlotGhost;
import Mod.TileEntity.TileEntityBox;
import Mod.TileEntity.TileEntityCraftingInv;

public class ContainerCraftingInv extends Container{

    private TileEntityCraftingInv tile;
    
    public InventoryCrafting craftMatrix = new InventoryCrafting(this, 3, 3);
    public IInventory craftResult = new InventoryCraftResult();
    
    private World worldObj;
    
    ItemStack[] Items;
    
    int SlotNext;
    
	
    public ContainerCraftingInv(InventoryPlayer InvPlayer, TileEntityCraftingInv tile)
    {
    	this.tile = tile;
        this.worldObj = tile.world;
        
        Items = new ItemStack[tile.Items.length];
    	
    	
    	this.addSlotToContainer(new SlotCrafting(InvPlayer.player, this.craftMatrix, this.craftResult, 0, 121, 27));
    	
        int l;
        int i1;

        
        // Crafting grid
        for (l = 0; l < 3; ++l)
        {
            for (i1 = 0; i1 < 3; ++i1)
            {
                this.addSlotToContainer(new Slot(this.craftMatrix, i1 + l * 3, 27 + i1 * 18, 9 + l * 18));
            }
        }
    	
        // Hotbar
    	for(int x = 0; x < 9; x++){
    		
    		addSlotToContainer(new Slot(InvPlayer, x, 8 + 18 * x, 173));
    	}
    	
    	// Player Inv
    	for(int y = 0; y < 3; y++){
    		for(int x = 0; x < 9; x++){
    			
    			addSlotToContainer(new Slot(InvPlayer, x + y * 9 + 9, 8 + 18 * x, 115 + y * 18));
    		}
    	}
    	
    	
    	// Crafting Extra Slots
    	for (int x = 0; x != 9; x++){
    		
    		addSlotToContainer(new Slot(tile, SlotNext, 8 + (18 * x), 70));
    		SlotNext++;
    	}
    	
    	for (int x = 0; x != 9; x++){
    		
    		addSlotToContainer(new Slot(tile, SlotNext, 8 + (18 * x), 88));
    		SlotNext++;
    	}
    	
    	
    	// Moved Crafting Slots
    	for (int x = 0; x != 3; x++){
    		addSlotToContainer(new SlotCraftingInvOutput(tile, SlotNext, 191 + x * 18, 70));
    		SlotNext++;
    	}
    	
    	for (int x = 0; x != 3; x++){
    		addSlotToContainer(new SlotCraftingInvOutput(tile, SlotNext, 191 + x * 18, 88));
    		SlotNext++;
    	}
    	
    	for (int x = 0; x != 3; x++){
    		addSlotToContainer(new SlotCraftingInvOutput(tile, SlotNext, 191 + x * 18, 106));
    		SlotNext++;
    	}
    	
    	// Product Slot
    	
    	tile.ProductSlot = SlotNext;
    	addSlotToContainer(new SlotGhost(tile, SlotNext, 209, 22));
    	SlotNext++;
    	
    	
    	
    	}


	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return tile.isUseableByPlayer(entityplayer);
	}
	
	 public void onCraftMatrixChanged(IInventory par1IInventory)
	    {	
	        this.craftResult.setInventorySlotContents(0, CraftingManager.getInstance().findMatchingRecipe(this.craftMatrix, tile.world));
	        tile.setInventorySlotContents(tile.ProductSlot, null);
	    }
	 
	 @Override 
	 public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
    {
	       tile.setInventorySlotContents(tile.ProductSlot, null);
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
	 
	    public void onContainerClosed(EntityPlayer player)
	    {
	        super.onContainerClosed(player);
	        if (!tile.worldObj.isRemote)
	        {
	            for (int i = 0; i < 9; ++i)
	            {
	                ItemStack itemstack = this.craftMatrix.getStackInSlotOnClosing(i);

	                if (itemstack != null)
	                {
	                	
	                	if(tile.getStackInSlot(i + 18) == null){
	                   	tile.setInventorySlotContents(i + 18, itemstack);
	                	}else if(tile.getStackInSlot(i + 18).itemID == itemstack.itemID){
	                		tile.IncrStackSize(i + 18, itemstack.stackSize, player, itemstack);
	                	}else{
	                		player.dropItem(itemstack.itemID, itemstack.stackSize);
	                	}
	                   	tile.setInventorySlotContents(tile.ProductSlot, craftResult.getStackInSlot(1));
	                	
	                		
	                	}
	                	
	                }
	            }
	        }
	    
	    

	    	
	    }
    