package Mod.TileEntity;

import Mod.Gui.XpStorageGui;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityXpStorage extends TileEntity implements IInventory{
	
	public int XpAmount;
	private EntityPlayer player;
	
	
	
	@Override
	public void writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);
		
		compound.setInteger("XpAmount", XpAmount);

	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		

		XpAmount = compound.getInteger("XpAmount");
		
		
	}

	@Override
	public int getSizeInventory() {
		return 0;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return null;
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
			
		}
		

	@Override
	public String getInvName() {
		return "InvCrafting";
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
		this.player = entityplayer;
		return entityplayer.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) <= 64;
	}

	@Override
	public void openChest() {}

	@Override
	public void closeChest() {}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return itemstack.itemID == Item.coal.itemID;
	}
	
	
	public void receiveButtonEvent(byte buttonId) {
		
		switch (buttonId) {
			case 1:
				
				if(XpAmount > 0){
				player.experienceLevel = player.experienceLevel + 1;
				XpAmount = XpAmount - 1;
				}
				
				System.out.println(player.experienceLevel + ":" + XpAmount);
				
				break;
				
			case 2:
				
				if(player.experienceLevel > 0){
				player.experienceLevel = player.experienceLevel - 1;
				XpAmount = XpAmount + 1;
				}
				
				System.out.println(player.experienceLevel + ":" + XpAmount);
				
				break;
				
			case 3:
				
				player.addChatMessage("Currently stored xp levels : " + XpAmount + " (This will be added to the gui soon)");
				
				break;
		}
	}
	
	public int GetXp(){
		
		return XpAmount;
	}
	

	
	
}
