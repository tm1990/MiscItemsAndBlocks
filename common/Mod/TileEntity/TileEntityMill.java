package Mod.TileEntity;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import Mod.Items.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;

public class TileEntityMill extends TileEntity implements IInventory{

	public ItemStack[] Items;
	
	public int WorkTime = 0;
	public static int FinishTime = 300;
	public static int Original = 300;
	
	Random rand = new Random();
	
	public TileEntityMill(){
		
		Items = new ItemStack[2];
		
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
	
		Items[i] = itemstack;
		
		if(itemstack != null && itemstack.stackSize > getInventoryStackLimit()){
			itemstack.stackSize = getInventoryStackLimit();
			
		}
		
		onInventoryChanged();
		
	}

	@Override
	public String getInvName() {
		return "ShelfInv";
	}

	@Override
	public boolean isInvNameLocalized() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 16;
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
    		 compound.setShort("Work", (short)this.WorkTime);
    		
    		compound.setTag("Items", Items);
    		
    		
    		
    		
    	}
    	
    	@Override
    	public void readFromNBT(NBTTagCompound compound){
    		super.readFromNBT(compound);
    		

    		NBTTagList items = compound.getTagList("Items");
    		
    		for(int i = 0; i < items.tagCount(); i++){
    			
    			NBTTagCompound item = (NBTTagCompound)items.tagAt(i);
    			int slot = item.getByte("Slot");
    			
    			if(slot >= 0 && slot < getSizeInventory()){
    				setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(item));
    				
    			}
    			
    	        this.WorkTime = compound.getShort("Work");
    		}
    		
    		
    		
    	}
    	
    	
        public void updateEntity()
        {
        	
        	if(this.getStackInSlot(0) != null){
        	if(this.getStackInSlot(0).itemID == Item.wheat.itemID){
        		if(this.getStackInSlot(1) == null || this.getStackInSlot(1).stackSize <= 0 || this.getStackInSlot(1).stackSize < 16){

        		
        		if(WorkTime == FinishTime){
        			WorkTime = 0;

        			
        			this.decrStackSize(0, 1);
        			
        			if(this.getStackInSlot(1) == null || Items[1].stackSize <= 0){
        				this.setInventorySlotContents(1, new ItemStack(ModItems.Flour));
        			}else{
        				
        				Items[1].stackSize = Items[1].stackSize + 1;
        				
        				FinishTime = Original + rand.nextInt(50);
        			}
        			
        			
        			
        		}else{

            		WorkTime++;
        		}
        		
        
        	
        	
        	}
        	}
        	}
        }




}
