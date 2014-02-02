package Mod.TileEntity;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import cpw.mods.fml.common.network.PacketDispatcher;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet131MapData;
import Mod.Items.ModItems;
import Mod.Main.Main;

public class TileEntityMetalPress extends TileEntityPowerInv implements ISidedInventory{

	
	
	
	public TileEntityMetalPress() {
		super(6, "Metal Press", 64, 1000);
	}

	public int WorkTime = 1;
	public int MaxWorkTime = 50;
	
	//1 = Normal plate
	//2 = Hardened plate
	public int Mode = 1;
	
	
	private final int[] sidedSlotSides = new int[] { 1 };
	private final int[] sidedSlotBottom = new int[] { 0 };
	private final int[] sidedSlotTop = new int[] { 1 };
	
	public int GetMode(){
		return Mode;
	}
	
	public void SetMode(int i){
		if(i == 1 || i == 2){
			Mode = i;
		}else{
			
			Mode = 1;
		}
		
	}
	
	public int GetWorkTime(){
	return WorkTime;
}
	
	public void SetWorkTime(int i){
		if(i >= MaxWorkTime){
			WorkTime = MaxWorkTime;
		}else{
			WorkTime = i;
		}
	}
	
	
	
	
	public void updateEntity(){

		
		if(!this.worldObj.isRemote){
			
			if(Mode == 1 ? Power > 10 : Power > 20){
		if(WorkTime <= MaxWorkTime ){
		if(Mode == 1){
			if(this.getStackInSlot(1) != null && this.getStackInSlot(1).getItem() == Item.ingotIron
					&& this.getStackInSlot(0) == null){ 
					
				WorkTimeAdd();
				
			}else if (this.getStackInSlot(1) != null && this.getStackInSlot(1).getItem() == Item.ingotIron &&
					this.getStackInSlot(0) != null && this.getStackInSlot(0).getItem() == ModItems.IronPlate && this.getStackInSlot(0).getItemDamage() == 0 && this.getStackInSlot(0).stackSize < this.getInventoryStackLimit()){
				
				WorkTimeAdd();
				
			}else if (this.getStackInSlot(1) == null && Mode == 1){
				SetWorkTimeUpdate(0);
				
			}

			
		}else if (Mode == 2){
			if(this.getStackInSlot(2) != null && this.getStackInSlot(2).getItem() == Item.ingotIron
					&& this.getStackInSlot(3) != null && this.getStackInSlot(3).getItem() == Item.ingotIron
					&& this.getStackInSlot(4) != null && this.getStackInSlot(4).getItem() == Item.ingotIron
					&& this.getStackInSlot(5) != null && this.getStackInSlot(5).getItem() == Item.ingotIron
					&& this.getStackInSlot(0) == null
					
					||
					this.getStackInSlot(2) != null && this.getStackInSlot(2).getItem() == Item.ingotIron
							&& this.getStackInSlot(3) != null && this.getStackInSlot(3).getItem() == Item.ingotIron
							&& this.getStackInSlot(4) != null && this.getStackInSlot(4).getItem() == Item.ingotIron
							&& this.getStackInSlot(5) != null && this.getStackInSlot(5).getItem() == Item.ingotIron
							&&
					this.getStackInSlot(0) != null && this.getStackInSlot(0).getItem() == ModItems.IronPlate && this.getStackInSlot(0).getItemDamage() == 2 && this.getStackInSlot(0).stackSize < this.getInventoryStackLimit()){
				WorkTimeAdd();
			
			}else{

				SetWorkTimeUpdate(0);
			}
			
		}
		
		
		}else{
			
			WorkTimeReset();
			
			
			
			if(Mode == 1){
				this.decrStackSize(1, 1);
				this.SetPower(this.GetPower() - 10);
				
				if(this.getStackInSlot(0) == null){
					this.setInventorySlotContents(0, new ItemStack(ModItems.IronPlate, 1, 0));
					
				}else if(this.getStackInSlot(0) != null && this.getStackInSlot(0).getItem() == ModItems.IronPlate && this.getStackInSlot(0).getItemDamage() == 0){
				
					if(this.getStackInSlot(0).stackSize < this.getInventoryStackLimit()){
						this.setInventorySlotContents(0, new ItemStack(ModItems.IronPlate, this.getStackInSlot(0).stackSize + 1, 0));
					}
					
				}
				
			}else if (Mode == 2){
				this.SetPower(this.GetPower() - 20);
				

				this.decrStackSize(2, 1);
				this.decrStackSize(3, 1);
				this.decrStackSize(4, 1);
				this.decrStackSize(5, 1);
				
				if(this.getStackInSlot(0) == null){
					this.setInventorySlotContents(0, new ItemStack(ModItems.IronPlate, 1, 2));
					
				}else if(this.getStackInSlot(0) != null && this.getStackInSlot(0).getItem() == ModItems.IronPlate && this.getStackInSlot(0).getItemDamage() == 2){
				
					if(this.getStackInSlot(0).stackSize < this.getInventoryStackLimit()){
						this.setInventorySlotContents(0, new ItemStack(ModItems.IronPlate, this.getStackInSlot(0).stackSize + 1, 2));
					}
					
				}
				
			}
			
		}
		
		
		}
		
	}
	}
	
		
		
	
	
	
	 public void readFromNBT(NBTTagCompound NBT)
	    {
		  super.readFromNBT(NBT);


		  WorkTime = NBT.getInteger("WorkTime");
		  Mode = NBT.getInteger("Mode");
	    }


	    public void writeToNBT(NBTTagCompound NBT)
	    {
	      super.writeToNBT(NBT);
	      
	    	
	      NBT.setInteger("WorkTime", WorkTime);
	      NBT.setInteger("Mode", Mode);
	    }
	    
	    
	    
		public void receiveButtonEvent(byte buttonId) {
			
			if(buttonId == 1){
				
				if(Mode == 1)
					Mode = 2;
				else if (Mode == 2)
					Mode = 1;
			}
			
		}
	    
			@Override
			public int[] getAccessibleSlotsFromSide(int var1) {
				this.onInventoryChanged();
				
				if(Mode == 1)
					return var1 == 0 ? sidedSlotBottom : new int[]{ 1 };
				else if (Mode == 2)
					return var1 == 0 ? sidedSlotBottom : new int[]{ 2, 3, 4, 5 };
					
					
				return var1 == 0 ? sidedSlotBottom : (var1 == 1 ? sidedSlotTop : sidedSlotSides);
			}

			@Override
			public boolean canInsertItem(int i, ItemStack itemstack, int j) {
				this.onInventoryChanged();
				return this.isItemValidForSlot(i, itemstack);
			}

			@Override
			public boolean canExtractItem(int i, ItemStack itemstack, int j) {
				this.onInventoryChanged();
				return j != 0 || i != 1 ;
			}
			
			public void WorkTimeAdd(){
				WorkTime++;
				
	        	 ByteArrayOutputStream bytes = new ByteArrayOutputStream();
	             DataOutputStream stream = new DataOutputStream(bytes);

	             try
	             {
	            	 
	            	 stream.writeInt(xCoord);
	            	 stream.writeInt(yCoord);
	            	 stream.writeInt(zCoord);
	            	 
	            	 stream.writeInt(WorkTime);
	            	 
	            	 stream.writeBoolean(false);
	                     
	                     PacketDispatcher.sendPacketToAllPlayers(new Packet131MapData((short)Main.getNetId(), (short)6, bytes.toByteArray()));
	             }
	             catch(IOException e)
	             {}
	    	}
			
			
			
			public void WorkTimeReset(){
				WorkTime = 0;
				
				

	        	 ByteArrayOutputStream bytes = new ByteArrayOutputStream();
	             DataOutputStream stream = new DataOutputStream(bytes);

	             try
	             {
	            	 
	            	 stream.writeInt(xCoord);
	            	 stream.writeInt(yCoord);
	            	 stream.writeInt(zCoord);
	            	 
	            	 stream.writeInt(WorkTime);
	            	 
	            	 stream.writeBoolean(true);
	                     
	                     PacketDispatcher.sendPacketToAllPlayers(new Packet131MapData((short)Main.getNetId(), (short)6, bytes.toByteArray()));
	             }
	             catch(IOException e)
	             {}
	    	}

			@Override
			public boolean CanAcceptPower() {
				return true;
			}
			
			
			public void SetWorkTimeUpdate(int i){
			
				WorkTime = i;
				
	        	 ByteArrayOutputStream bytes = new ByteArrayOutputStream();
	             DataOutputStream stream = new DataOutputStream(bytes);

	             try
	             {
	            	 
	            	 stream.writeInt(xCoord);
	            	 stream.writeInt(yCoord);
	            	 stream.writeInt(zCoord);
	            	 
	            	 stream.writeInt(WorkTime);
	            	 
	            	 stream.writeBoolean(false);
	                     
	                     PacketDispatcher.sendPacketToAllPlayers(new Packet131MapData((short)Main.getNetId(), (short)6, bytes.toByteArray()));
	             }
	             catch(IOException e)
	             {}
			}
			
			}

