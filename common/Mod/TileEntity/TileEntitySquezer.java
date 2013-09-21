package Mod.TileEntity;

import Mod.Items.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class TileEntitySquezer extends TileEntityInvBase {

	public TileEntitySquezer() {
		super(3, "Squezer", 16);
	}
	
	public int WorkTime = 0;
	public int FinishTime = 400;
	
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
  	
    public void updateEntity()
    {
    	
    	
    	if(this.getStackInSlot(0) != null && this.getStackInSlot(1) != null){
    		if(CanWork()){
    		
    		if(WorkTime == FinishTime){
    			WorkTime = 0;
    			
    			
    			ItemStack finishItem = GetOutput();
    			
    			this.decrStackSize(0, 1);
    			this.decrStackSize(1, 1);
    			
    			if(this.getStackInSlot(2) == null || Items[2].stackSize <= 0){
    				this.setInventorySlotContents(2, finishItem);
    			}else{
    				
    				Items[2].stackSize = Items[2].stackSize + 1;

    			}
    			
    		}else{
    			WorkTime++;
    		}
    		}
    	}
    	
    }
    
    public ItemStack GetOutput(){
    	
    	int id1 = this.getStackInSlot(0).itemID;
    	int id2 = this.getStackInSlot(1).itemID;
    	
    	if(id1 == Item.glassBottle.itemID && id2 == Item.appleRed.itemID) return new ItemStack(ModItems.Liquid, 1, 0);
    	if(id1 == Item.bucketEmpty.itemID && id2 == ModItems.Tomato.itemID) return new ItemStack(ModItems.Liquid, 1, 1);
    	if(id1 == Item.glassBottle.itemID && id2 == ModItems.Orange.itemID)return new ItemStack(ModItems.Liquid, 1, 2);
    	
    	

    	return null;
    }
    
    
    
    public boolean CanWork(){

    	return GetOutput() != null && this.getStackInSlot(2) == null || this.getStackInSlot(2).stackSize == 0;
    	
    }
    
    public int GetWorkTime(){
    	
    	return this.WorkTime;
    }
    
    public void setWorkTime(int amount){
    	
    	WorkTime = amount;
    }
    
    
    
  	

}
