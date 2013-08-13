package Mod.TileEntity;

import net.minecraft.block.BlockHopper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Facing;

public class TileEntityBin extends TileEntity implements IInventory{

	private ItemStack[] Items;
	
	public TileEntityBin(){
		
		Items = new ItemStack[1];
	}
	
	@Override
	public int getSizeInventory() {
		return Items.length;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return Items[i];
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		Items[i].stackSize = Items[i].stackSize - j;
		
		return Items[i];
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		return null;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		Items[i] = itemstack;
		
	}

	@Override
	public String getInvName() {
		return "TrashBin";
	}

	@Override
	public boolean isInvNameLocalized() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
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

	
	public Packet getDescriptionPacket() {
        NBTTagCompound nbtTag = new NBTTagCompound();
        this.writeToNBT(nbtTag);
        return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 1, nbtTag);
        }

        public void onDataPacket(INetworkManager net, Packet132TileEntityData packet) {
        readFromNBT(packet.customParam1);
        }
        
        public void onInventoryChanged(){
        	setInventorySlotContents(0, null);
        	
        	
        	
        }
        

        

        
        
        
}
