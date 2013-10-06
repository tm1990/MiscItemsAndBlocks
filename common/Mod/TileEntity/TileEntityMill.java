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

public class TileEntityMill extends TileEntityInvBase{

	public TileEntityMill() {
		super(2, "Mill", 16);
	}

	
	public int WorkTime = 0;
	public static int FinishTime = 300;
	public static int Original = 300;
	
	Random rand = new Random();
	

	

        
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
        	if(CanItemWork()){
        		if(this.getStackInSlot(1) == null || this.getStackInSlot(1).stackSize <= 0 || this.getStackInSlot(1).stackSize < 16){

        		
        		if(WorkTime == FinishTime){
        			WorkTime = 0;
        			
        			ItemStack finishItem = OutputItem();

        			
        			this.decrStackSize(0, 1);
        			
        			if(this.getStackInSlot(1) == null || Items[1].stackSize <= 0){
        				this.setInventorySlotContents(1, finishItem);
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
        
        public boolean CanItemWork(){
        	ItemStack itemstack = this.getStackInSlot(0);
        	
        	if(OutputItem() != null)return true;
        	
        	
        	return false;
        }

        
        public ItemStack OutputItem(){
        	int id = this.getStackInSlot(0).itemID;
        	
        	if(id == Item.wheat.itemID) return new ItemStack(ModItems.Flour);
        	if(id == Item.rottenFlesh.itemID)return new ItemStack(Item.leather);
        	
        	return null;
        }
        
        public int GetWorkTime(){
        	
        	return this.WorkTime;
        }
        
        public void setWorkTime(int amount){
        	
        	WorkTime = amount;
        }



}
