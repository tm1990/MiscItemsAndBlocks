package Mod.TileEntity;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;

public class TileEntityGenerator extends TileEntityPowerGeneration{

	public TileEntityGenerator() {
		super(1, "CoalGenerator", 64, 1);
	}
	
	
	int Power = 0;
	int TimeLeft = 0;
	int MaxTime = 80;
	
	
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

		
		compound.setInteger("Power", this.Power);
		compound.setInteger("TimeLeft", this.TimeLeft);
		isProvidingPower = compound.getBoolean("Providing");

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
		TimeLeft = compound.getInteger("TimeLeft");
		compound.setBoolean("Providing", isProvidingPower);

		

		
	}
	
    public void updateEntity()
    {
    
    	if(Power < 1)
    	if(this.getStackInSlot(0) != null){
    		if(this.getStackInSlot(0).getItem() == Item.coal){
    			if(TimeLeft == MaxTime){
    				TimeLeft = 0;
    				this.decrStackSize(0, 1);
    				Power++;
    				
    				
    			}else{
    				TimeLeft++;
    			}
    			
    			
    		}
    	}
    	
    	super.updateEntity();
    	
    	
    }
    
    public int GetFuel(){
    	return Power;
    }
    
    public int GetTimeLeft(){
    	return TimeLeft;
    }
    
    public int GetMaxTime(){
    	return MaxTime;
    }
    
    
    
    public void SetFuel(int i){
    	Power = i;
    }
    
    public void SetTimeLeft(int i){
    	TimeLeft = i;
    }

	@Override
	public boolean CanWork(World world, int X, int Y, int Z) {


		return Power > 0;
	}


	@Override
	public int WorkTime() {
		return MaxTime + 10;
	}

	@Override
	public int PowerProduced() {
		return 1;
	}
	
    public void OnWork(World world, int x, int y, int z){
    	Power--;
    	
    	
    }
	
   

}
