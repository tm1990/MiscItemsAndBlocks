package Mod.TileEntity;

import Mod.Items.ModItems;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class TileEntitySquezer extends TileEntityInvBase implements ISidedInventory {

	public TileEntitySquezer() {
		super(3, "Squezer", 16);
	}
	
	private static final int[] sidedSlotSides = new int[] { 0 };
	private static final int[] sidedSlotBottom = new int[] { 2, 1 };
	private static final int[] sidedSlotTop = new int[] { 1 };
	
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
    	
    	Item item_1 = this.getStackInSlot(0).getItem();
    	Item item_2 = this.getStackInSlot(1).getItem();
    	
    	if(item_1 == Item.glassBottle && item_2 == Item.appleRed) return new ItemStack(ModItems.Liquid, 1, 0);
    	if(item_1 == Item.bucketEmpty && item_2 == ModItems.Tomato) return new ItemStack(ModItems.Liquid, 1, 1);
    	if(item_1 == Item.glassBottle && item_2 == ModItems.Orange)return new ItemStack(ModItems.Liquid, 1, 2);
    	if(item_1 == Item.glassBottle && item_2 == Item.carrot)return new ItemStack(ModItems.Liquid, 1, 3);
    	
    	

    	return null;
    }
    
    
    
    public boolean CanWork(){
    	
    	if(GetOutput() == null)
    		return false;

    	return GetOutput() != null && this.getStackInSlot(2) == null;
    	
    }
    
    public int GetWorkTime(){
    	
    	return this.WorkTime;
    }
    
    public void setWorkTime(int amount){
    	
    	WorkTime = amount;
    }
    
	@Override
	public int[] getAccessibleSlotsFromSide(int var1) {
		return var1 == 0 ? sidedSlotBottom : (var1 == 1 ? sidedSlotTop : sidedSlotSides);
	}

	@Override
	public boolean canInsertItem(int i, ItemStack itemstack, int j) {
		return this.isItemValidForSlot(i, itemstack);
	}

	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int j) {
		return j != 0 || i != 1 || itemstack.getItem() == Item.bucketEmpty;
	}
    
    
    
  	

}
