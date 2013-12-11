package Mod.TileEntity;

import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.packet.Packet;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import Mod.Misc.ItemHelper;
import Mod.Network.PacketTileWithItemUpdate;
import Mod.Network.PacketTypeHandler;

public class TileEntityItemPedestal extends ModTileEntity implements IInventory{

	public ItemStack[] items;
	
	public TileEntityItemPedestal() {
		items = new ItemStack[1];
	}
	


	
	  @Override
	    public void readFromNBT(NBTTagCompound nbtTagCompound) {

	        super.readFromNBT(nbtTagCompound);
	        NBTTagList tagList = nbtTagCompound.getTagList("Items");
	        items = new ItemStack[this.getSizeInventory()];
	        for (int i = 0; i < tagList.tagCount(); ++i) {
	            NBTTagCompound tagCompound = (NBTTagCompound) tagList.tagAt(i);
	            byte slotIndex = tagCompound.getByte("Slot");
	            if (slotIndex >= 0 && slotIndex < items.length) {
	            	items[slotIndex] = ItemStack.loadItemStackFromNBT(tagCompound);
	            }
	        }
	    }

	    @Override
	    public void writeToNBT(NBTTagCompound nbtTagCompound) {

	        super.writeToNBT(nbtTagCompound);

	        NBTTagList tagList = new NBTTagList();
	        for (int currentIndex = 0; currentIndex < items.length; ++currentIndex) {
	            if (items[currentIndex] != null) {
	                NBTTagCompound tagCompound = new NBTTagCompound();
	                tagCompound.setByte("Slot", (byte) currentIndex);
	                items[currentIndex].writeToNBT(tagCompound);
	                tagList.appendTag(tagCompound);
	            }
	        }
	        nbtTagCompound.setTag("Items", tagList);
	    }
	    
	    
  		





	@Override
	public int getSizeInventory() {
		return 64;
	}



	@Override
	public ItemStack getStackInSlot(int i) {
		return items[i];
	}



	@Override
	public ItemStack decrStackSize(int i, int j) {
		if(items[i].stackSize - j < 0){
			return items[i];
		}
		
		items[i].stackSize = items[i].stackSize - j;
		
		return items[i];
	}



	 @Override
	    public ItemStack getStackInSlotOnClosing(int slotIndex) {

	        ItemStack itemStack = getStackInSlot(slotIndex);
	        if (itemStack != null) {
	            setInventorySlotContents(slotIndex, null);
	        }
	        return itemStack;
	    }




	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		items[i] = itemstack;
		
	}



	@Override
	public String getInvName() {
		return "Pedestal";
	}



	@Override
	public boolean isInvNameLocalized() {
		return true;
	}



	@Override
	public int getInventoryStackLimit() {
		return 1;
	}



	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return entityplayer.getDistanceSqToEntity(entityplayer) < 64;
	}



	@Override
	public void openChest() {
		
	}



	@Override
	public void closeChest() {
		
	}



	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return false;
	}
	
	   @Override
	    public Packet getDescriptionPacket() {

	        ItemStack itemStack = getStackInSlot(0);

	        if (itemStack != null && itemStack.stackSize > 0)
	            return PacketTypeHandler.populatePacket(new PacketTileWithItemUpdate(xCoord, yCoord, zCoord, orientation, state, customName, itemStack.itemID, itemStack.getItemDamage(), itemStack.stackSize, ItemHelper.getColor(itemStack)));
	        else
	            return super.getDescriptionPacket();
	    }
  	
  	
}
