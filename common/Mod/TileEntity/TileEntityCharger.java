package Mod.TileEntity;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import Mod.Items.ModItemPowerTool;

public class TileEntityCharger extends TileEntityInvBase{

	public TileEntityCharger() {
		super(6, "Charger", 64);
	}
	
	int Power = 0;
	int Ticks = 10;
	int GenerateTime = 0;
	int CurrentTick = 0;
	public int PrimePower = 5000;
	public int MaxPower = PrimePower;
	
	
	public int GetPower(){
		return this.Power;
	}
	
	
	public void SetPower(int i){
		this.Power = i;
	}
	
	public int GetMaxPower(){
		return this.MaxPower;
	}
	
	
	public void SetMaxPower(int i){
		this.MaxPower = i;
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

    	int Bigger = 0;
    	
    	if(this.getStackInSlot(2) != null){
    		if(this.getStackInSlot(2).getItemDamage() == 0){
    			Bigger = Bigger + this.getStackInSlot(2).stackSize * 100;
    		}
    	}
    	
    	if(this.getStackInSlot(3) != null){
    		if(this.getStackInSlot(3).getItemDamage() == 0){
    			Bigger = Bigger + this.getStackInSlot(3).stackSize * 100;
    		}
    	}
    	
    	if(this.getStackInSlot(4) != null){
    		if(this.getStackInSlot(4).getItemDamage() == 0){
    			Bigger = Bigger + this.getStackInSlot(4).stackSize * 100;
    		}
    	}
    	
    	if(this.getStackInSlot(5) != null){
    		if(this.getStackInSlot(5).getItemDamage() == 0){
    			Bigger = Bigger + this.getStackInSlot(5).stackSize * 100;
    		}
    	}
    	
    	if(Bigger > 0){
    		MaxPower = PrimePower + Bigger;
    		Bigger = 0;
    	}else{
    		MaxPower = PrimePower;
    	}
    	
    	

    	
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
    		
 
    		
    		
    		if(this.worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityCharger){
    			TileEntityCharger tile = (TileEntityCharger)this.worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord);
    			if(Power > 0){
    				if(tile.GetPower() < tile.MaxPower){
    					this.SetPower(this.GetPower() - 1);
    					tile.SetPower(tile.GetPower() + 1);
    				}
    			}
    		}
    		

    		if(this.worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityPowerCable){
    			TileEntityPowerCable tile = (TileEntityPowerCable)this.worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord);
    			if(Power > 0){
    				if(tile.GetPower() < tile.MaxPower){
    					this.SetPower(this.GetPower() - 1);
    					tile.SetPower(tile.GetPower() + 1);
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
