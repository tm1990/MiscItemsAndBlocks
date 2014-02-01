package Mod.TileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityInvBase  extends ModTileEntity implements IInventory{
	

	public String Name;
	public ItemStack[] Items;
	public int SlotSize;
	
	public NBTTagCompound nbt;
	
	
	public TileEntityInvBase(int Slots, String Name, int Size){
		

		Items = new ItemStack[Slots];
		this.Name = Name;
		this.SlotSize = Size;
		
	}
	
	@Override
	public int getSizeInventory() {
		return Items.length;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		onInventoryChanged();
		return Items[i];
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		ItemStack itemstack = getStackInSlot(i);
		
		if(itemstack != null){
			
			if(itemstack.stackSize <= j){
				
				setInventorySlotContents(i, null);
			}else{
				
				itemstack = itemstack.splitStack(j);
				onInventoryChanged();
				
			}
			
		}
		onInventoryChanged();
		return itemstack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		ItemStack item = getStackInSlot(i);
		
		setInventorySlotContents(i, null);
		return item;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
	
		Items[i] = itemstack;
		
		if(itemstack != null && itemstack.stackSize > getInventoryStackLimit()){
			itemstack.stackSize = getInventoryStackLimit();
			
		}
		
		onInventoryChanged();
		
	}

	@Override
	public String getInvName() {
		return Name;
	}

	@Override
	public boolean isInvNameLocalized() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return SlotSize;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return entityplayer.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) <= 64;
	}

	@Override
	public void openChest() {}

	@Override
	public void closeChest() {}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return true;
		
	}
	
	

        
        @Override
    	public void writeToNBT(NBTTagCompound compound){
    		super.writeToNBT(compound);
    		this.nbt = compound;
    		
    		NBTTagList Items = new NBTTagList();
    		
    		for (int i = 0; i < getSizeInventory(); i++){
    			
    			ItemStack stack = getStackInSlot(i);
    			if(stack != null){
    				
    				NBTTagCompound item = new NBTTagCompound();
    				item.setByte("Slot", (byte)i);
    				stack.writeToNBT(item);
    				Items.appendTag(item);
    			}
    		}

    		
    		compound.setTag("Items", Items);
    		
    		
    		
    		
    	}
    	
    	@Override
    	public void readFromNBT(NBTTagCompound compound){
    		super.readFromNBT(compound);
    		this.nbt = compound;
    		

    		NBTTagList items = compound.getTagList("Items");
    		
    		for(int i = 0; i < items.tagCount(); i++){
    			
    			NBTTagCompound item = (NBTTagCompound)items.tagAt(i);
    			int slot = item.getByte("Slot");
    			
    			if(slot >= 0 && slot < getSizeInventory()){
    				setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(item));
    				
    			}
    			

    		}
    		
    		
    		
    	}
}