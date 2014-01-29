package Mod.TileEntity;

import Mod.Block.ModBlocks;
import Mod.Gui.GuiXpStorage;
import Mod.Lib.Messages;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;

public class TileEntityXpStorage extends TileEntity implements IInventory{
	
	
	public int XpAmount;
	public EntityPlayer player;
	
	
	
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
		return getStackInSlot(i);
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		
		return getStackInSlot(i);
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
			
		}
		

	@Override
	public String getInvName() {
		return "";
	}

	@Override
	public boolean isInvNameLocalized() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 0;
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
		return false;
	}
	
	
	
	public void receiveButtonEvent(byte buttonId) {
		
		switch (buttonId) {
			case 1:
				
				if(XpAmount > 0){
				player.addExperienceLevel(1);
				XpAmount = XpAmount - 1;
				}

				
				break;
				
			case 2:
				
				if(player.experienceLevel > 0){
				player.addExperienceLevel(-1);
				XpAmount = XpAmount + 1;
				}

				
				break;
				
			case 3:
				
				break;
		}

		
	}
	
	public int GetLevels(){
		return XpAmount;
	}
	
	public void SetLevels(int Levels){
		XpAmount = Levels;
	}
	
	

	
	
}
