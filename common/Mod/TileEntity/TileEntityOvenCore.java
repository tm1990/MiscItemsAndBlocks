package Mod.TileEntity;

import java.util.Random;

import Mod.Block.ModBlockOvenCore;
import Mod.Items.ModItems;

import net.minecraft.block.Block;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class TileEntityOvenCore extends TileEntityInvBase implements ISidedInventory{

	public TileEntityOvenCore() {
		super(3, "PizzaOven", 64);
	}
	
	private static final int[] sidedSlotSides = new int[] { 0 };
	private static final int[] sidedSlotBottom = new int[] { 2, 1 };
	private static final int[] sidedSlotTop = new int[] { 1 };
	
	public int WorkTime = 0;
	public int Heat = 0;
	public int Fuel;
	public int FinishTime = 300;
	int Heatup = 20;
	int counter = 0;

	public boolean Working = false;
	
	Random rand = new Random();
	
	
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

   		
   		
   		compound.setInteger("WorkTime", this.WorkTime);
   		compound.setInteger("Heat", this.Heat);
   		compound.setTag("Items", Items);
   		compound.setInteger("Fuel", this.Fuel);
   		
   		
   		
   		
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
   		
   		WorkTime = compound.getInteger("WorkTime");
   		Heat = compound.getInteger("Heat");
   		Fuel = compound.getInteger("Fuel");
   		

   		
   	}
   	
    public void updateEntity()
    {
    	
    	
    	
    	if(this.getStackInSlot(1) == null || this.getStackInSlot(1).itemID == 0){
    		WorkTime = 0;
    	}
    
    	if(Heat > 100){
    		Heat = 100;
    	}
  
    	if(Fuel <= 0 && Heat <= 100){
    		if(IsFuel(this.getStackInSlot(0)) && Heat < 100){
    			
    			Fuel = Fuel + rand.nextInt(FuelValue(this.getStackInSlot(0)));
    			if(this.getStackInSlot(0).itemID == Item.bucketLava.itemID){
    				this.setInventorySlotContents(0, new ItemStack(Item.bucketEmpty));
    			}else{
    					this.decrStackSize(0, 1);
    			}
    			
    			if(Fuel > 20){
    				Fuel = 20;
    			}
    		}
    	

    }else if (Fuel > 0 && Heat <= 100){
    
    	if(Heat < 100)
    	if(this.worldObj.getBlockId(xCoord, yCoord - 1, zCoord) == Block.fire.blockID){
    		Heat = Heat + 1 + rand.nextInt(4);
    	}else{
    	Heat++;
    	}
    	if(Heat > 100){
    		Heat = 100;
    		
    	}else{
    	
    	Fuel--;
    	}
    }
    	

    		
    		if(Heat < 4 && counter == Heatup && this.worldObj.getBlockId(xCoord, yCoord - 1, zCoord) == Block.fire.blockID){
    			Heat++;
    			counter = 0;
    			if(Heat > 100){
    	    		Heat = 100;
    	    		
    	    	}
    		}else{
    			if(Heat > 100)
    	    		Heat = 100;
    			
    			if(Heat < 100)
    			if(this.worldObj.getBlockId(xCoord, yCoord - 1, zCoord) == Block.fire.blockID)
    		counter++;
    	    		

    			else
    				counter = 0;
    			
    			if(Heat > 100)
    	    		Heat = 100;
    			
    	    	if(Heat > 0){
    		if(rand.nextInt(100) == 5){
    			if(Fuel > 0){
    				Fuel--;
    			}else{
    		Heat--;
    			}
    		}
    		}
    		
    
    	}
    	
    	
    	
    	
    	if(Heat > 0){
    		if(this.getStackInSlot(1) != null){
    			
    			if(Output() != null && !this.worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord)){
    				
    				
    				if(WorkTime >= FinishTime){
    					WorkTime = 0;
    					
    					
    					if(this.getStackInSlot(2) == null || Items[2].stackSize <= 0){
    					this.setInventorySlotContents(2, Output());
    					}else{
    						Items[2].stackSize = Items[2].stackSize + 1;
    					}
    					this.decrStackSize(1, 1);
    				}else{


    		
    					if(Heat > 0 && Heat <= 25){
    						WorkTime++;
    						
    						
    					}else if(Heat > 25 && Heat <= 50){
    						WorkTime = WorkTime + 3;
    						
    					}else if(Heat > 50 && Heat <= 75){
    						WorkTime = WorkTime + 5;
    						
    					}else if(Heat > 75 && Heat <= 100){
    						WorkTime = WorkTime + 8;
    						
    						
    					}
    					
						if(WorkTime > FinishTime){
							WorkTime = FinishTime;
						}
    				}
    			}
    		}
    	}
    	
    	
    	
}
    	
    	
    	
    	
    	

    
    
    public int GetWorkTime(){
    	return WorkTime;
    }
    
    public boolean CanWork(){
    	return Heat > 0;
    }
    
    public void SetWorkTime(int i){
    	WorkTime = i;
    }
    
    public void SetHeat(int i){
    	Heat = i;
    }
    
    public int GetHeat(){
    	return Heat;
    }
    
    public int GetFuel(){
    	return Fuel;
    }
    
    
    public int FuelValue(ItemStack item){
    	
    	if(item != null){
    	int id = item.itemID;
    
    	if(id == Item.coal.itemID)return 7;
    	if(id == Block.wood.blockID)return 4;
    	if(id == Block.planks.blockID)return 2;
    	if(id == Item.bucketLava.itemID)return 40;
    	
    	}

    	return 0;
    }
    
    public boolean IsFuel(ItemStack item){
    	
    	
    	return FuelValue(item) > 0;
    }
    
    
    
    public ItemStack Output(){
    	if(this.getStackInSlot(1) != null){
    	int id = this.getStackInSlot(1).itemID;
    	
    	
    	if(id == ModItems.PizzaRaw.itemID)return new ItemStack(ModItems.Pizza, 1, this.getStackInSlot(1).getItemDamage());
    	if(id == Item.beefRaw.itemID)return new ItemStack(Item.beefCooked);
    	if(id == Item.porkRaw.itemID)return new ItemStack(Item.porkCooked);
    	if(id == Item.fishRaw.itemID)return new ItemStack(Item.fishCooked);
    	if(id == Item.chickenRaw.itemID)return new ItemStack(Item.chickenCooked);
    	if(id == ModItems.Flour.itemID)return new ItemStack(Item.bread);
    	
    	
    	}
    	
    	
    	return null;
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
		return j != 0 || i != 1 || itemstack.itemID == Item.bucketEmpty.itemID;
	}
    
    

}
