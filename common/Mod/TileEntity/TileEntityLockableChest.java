package Mod.TileEntity;

import net.minecraft.block.BlockChest;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.ResourceLocation;

public class TileEntityLockableChest extends TileEntityInvBase{

	
	public TileEntityLockableChest() {
		super(54, "LockChest", 64);
	}

	public int x;
	public int y;
	public int z;
	public String Player = "null";
	
	public boolean IsLocked;
	
	
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
   		 compound.setShort("LocX", (short)this.x);
   		 compound.setShort("LocY", (short)this.y);
   		 compound.setShort("LocZ", (short)this.z);
   		 
   		 compound.setString("Player", (String)this.Player);
   		
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
   			
   	        this.x = compound.getShort("LocX");
   	        this.y = compound.getShort("LocY");
   	        this.z = compound.getShort("LocZ");
   	        
   	        this.Player = compound.getString("Player");
   		}
   		
   		
   		
   	}
   	
    public void updateEntity()
    {
        float f = 5.0F;
        
        if(x != 0 || y != 0 || z != 0 || Player != "null"){
        	IsLocked = true;
        }else{
        	IsLocked = false;
        }
        
    }
    
    public void SetX(int i){x = i;}
    public void SetY(int i){y = i;}
    public void SetZ(int i){z = i;}

	
}
