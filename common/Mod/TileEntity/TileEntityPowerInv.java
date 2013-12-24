package Mod.TileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public abstract class TileEntityPowerInv  extends TileEntityInvBase implements IInventory{
	

	public TileEntityPowerInv(int Slots, String Name, int Size, int PowerMax) {
		super(Slots, Name, Size);

		this.PowerMax = PowerMax;
	}

	public int Power;
	public int PowerMax;
	
	
	public void SetPower(int i){
		Power = i;
	}
	
	public int GetPower(){
		return Power;
	}


	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return entityplayer.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) <= 64;
	}

	@Override
	public void openChest() {}

	@Override
	public void closeChest() {}
	
	public abstract boolean CanAcceptPower();

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
    		compound.setInteger("Power", Power);
    		
    		
    		
    		
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
    		
    		
    		Power = compound.getInteger("Power");
    		
    		
    		
    	}
}