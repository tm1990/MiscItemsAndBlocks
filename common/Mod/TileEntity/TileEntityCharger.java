package Mod.TileEntity;

import Mod.Block.ModBlockPowerCable;
import Mod.Block.ModBlockPowerModule;
import Mod.Items.ModItemPowerStorage;
import Mod.Items.ModItemPowerTool;
import net.minecraft.block.Block;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCharger extends TileEntityInvBase{

	public TileEntityCharger() {
		super(2, "Charger", 64);
	}
	
	int Power = 0;
	int Ticks = 10;
	int GenerateTime = 0;
	int CurrentTick = 0;
	public static int MaxPower = 5000;
	
	
	public int GetPower(){
		return this.Power;
	}
	
	
	public void SetPower(int i){
		this.Power = i;
	}
	
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

		

		
	}
	
	
    public void updateEntity()
    {
    	

    	
    	if(Power > MaxPower){
    		Power = MaxPower;
    	}
    	
    	
    	
    	
    	int BlockID = this.worldObj.getBlockId(xCoord, yCoord + 1, zCoord);
    	Block block = Block.blocksList[BlockID];

    	ItemStack itemStack = this.getStackInSlot(0);
    	
    	if(itemStack != null){
    	int ItemID = itemStack.itemID;
    	Item item = Item.itemsList[ItemID];
		
		if(item instanceof ModItemPowerTool){
			if(itemStack.getItemDamage() > 0 && Power > 0){
				Power--;
				itemStack.setItemDamage(itemStack.getItemDamage() - 1);
			}
		}
    	}
    	
    	if(Power < MaxPower){
    	ItemStack emptyStack = this.getStackInSlot(1);
    	
    	if(emptyStack != null){
    		int ItemID = emptyStack.itemID;
    		Item item = Item.itemsList[ItemID];
    		
    		if(item instanceof ModItemPowerTool){
    			int i = emptyStack.getMaxDamage() - emptyStack.getItemDamage();
    			if(i > 0){
    				emptyStack.setItemDamage(emptyStack.getItemDamage() + 1);
    				Power++;
    				
    			}
    			
    		}
    		
    		
    	}
    	
    	
    	
    	if(CurrentTick == Ticks){
    		CurrentTick = 0;
    		
    		
    		
    		
    		if(block instanceof ModBlockPowerModule){
    			ModBlockPowerModule Module = (ModBlockPowerModule)block;
    			
    			
    			if(Module.CanWork(worldObj, xCoord, yCoord + 1, zCoord)){
        			if(GenerateTime == Module.WorkTime()){
        				GenerateTime = 0;
        				Module.OnWork(worldObj, xCoord, yCoord + 1, zCoord);
    				Power = Power + Module.PowerGenerated();
        			}else{
        				GenerateTime++;
        			}
    			}
    			
    		}

    		
    		
    	}else{
    		CurrentTick++;
    	}
    	
    	if(Power > MaxPower){
    		Power = MaxPower;
    	}
    	
    	}
    	
    	if(Power > MaxPower){
    		Power = MaxPower;
    	}
    	
    }
	
	
	

}
