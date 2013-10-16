package Mod.TileEntity;

import Mod.Block.ModBlockPowerModule;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityMiningChamber extends TileEntityInvBase{

	public TileEntityMiningChamber() {
		super(30, "MiningCHamber", 64);
	}
	
	int Power = 0;
	int PowerTime = 0;
	int Time = 0;
	int MinedY = 0;
	int BlocksMined = 0;
	int GenerateTime = 0;
	boolean CanMine = true;
	boolean Ready = false;
	
	public static int MaxPower = 100;
	public static int ToolSlot = 29;
	
	 int LastY = 0;
	
	
	
	
	public int GetPower(){
		return Power;
	}
	
	public void SetPower(int i){
		Power = i;
	}
	
	public int GetBlocksMined(){
		return BlocksMined;
	}
	
	public int GetMinedY(){
		return MinedY;
	}
	
	public int GetLastY(){
		return LastY;
	}
	
	public boolean Ready(){
		return Ready;
	}
	
	public void SetBlocksMined(int i){
		BlocksMined = i;
	}
	
	public void SetMinedY(int i){
		MinedY = i;
	}
	
	public void SetLastY(int i){
		LastY = i;
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

		
		compound.setTag("Items", Items);
		compound.setInteger("Power", Power);
		
		compound.setInteger("Mined", BlocksMined);
		compound.setInteger("Y", MinedY);
		
		compound.setInteger("LastY", LastY);
		
		compound.setBoolean("Can", CanMine);
		compound.setBoolean("Ready", Ready);
		
		
		
		
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
		
		BlocksMined = compound.getInteger("Mined");
		MinedY = compound.getInteger("Y");
		
		LastY = compound.getInteger("LastY");
		
		CanMine = compound.getBoolean("Can");
		Ready = compound.getBoolean("Ready");
		
		
		
	}
	public boolean HasSpaceFor(ItemStack item){
		
		
		
		for(int x = 0; x < this.getSizeInventory(); x++) {
			if(this.getStackInSlot(x) == null)
				return true;
			else if(this.getStackInSlot(x) == item && this.getStackInSlot(x).stackSize < 64)
				return true;
			
		}
		
		
		return false;
	}
	
	int x = 0;
	public void AddItem(ItemStack item){
		if(HasSpaceFor(item)){
			
			

			
			if(this.getStackInSlot(x) == null){
				this.setInventorySlotContents(x, item);
			}else if (this.getStackInSlot(x) == item && this.getStackInSlot(x).stackSize < 64){
				this.getStackInSlot(x).stackSize = this.getStackInSlot(x).stackSize + 1;
				
				
			}else{
				AddItem(item);
			}
			
			
			
			
		}

	}

	
    public void updateEntity()
    {
    	
    	
    	if(PowerTime >= 40){
    		PowerTime = 0;
    		
    	TileEntity tile_entity = this.worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord);
    	TileEntityPowerCable tileCable;
    	int BlockID = this.worldObj.getBlockId(xCoord, yCoord + 1, zCoord);
    	Block block = Block.blocksList[BlockID];
    	ModBlockPowerModule module;
    	 
    	
    	
    	if(tile_entity instanceof TileEntityPowerCable){
    		tileCable = (TileEntityPowerCable)tile_entity;
    		
    		if(tileCable.GetPower() > 0 && Power < MaxPower){
    			tileCable.SetPower(tileCable.GetPower() - 1);
    			Power++;
    			
    		}
    	}
    	}else{
    		PowerTime++;
    	}
    	
    	if(Time >= 80){
    		Time = 0;
    		if(CanMine && Ready){

    		
    		
    		
    		
    		
    		TileEntityItemPedestal tile1;
        	TileEntityItemPedestal tile2;
        	TileEntityItemPedestal tile3;
        	TileEntityItemPedestal tile4;
        	

        	TileEntity tile_entity_1 = this.worldObj.getBlockTileEntity(xCoord + 2, yCoord, zCoord);
        	TileEntity tile_entity_2 = this.worldObj.getBlockTileEntity(xCoord - 2, yCoord, zCoord);
        	TileEntity tile_entity_3 = this.worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 2);
        	TileEntity tile_entity_4 = this.worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 2);
        	
        	
        	if(Power > 0 && this.getStackInSlot(this.ToolSlot) != null && this.getStackInSlot(this.ToolSlot).getItem() == Item.pickaxeDiamond)
        	if(tile_entity_1 instanceof TileEntityItemPedestal){
        		tile1 = (TileEntityItemPedestal)tile_entity_1;
        		if(tile_entity_2 instanceof TileEntityItemPedestal){
        			tile2 = (TileEntityItemPedestal)tile_entity_2;
        			if(tile_entity_3 instanceof TileEntityItemPedestal){
        				tile3 = (TileEntityItemPedestal)tile_entity_3;
        				if(tile_entity_4 instanceof TileEntityItemPedestal){
        					tile4 = (TileEntityItemPedestal)tile_entity_4;
        					if(tile1.getStackInSlot(0) != null && tile2.getStackInSlot(0) != null && tile3.getStackInSlot(0) != null && tile4.getStackInSlot(0) != null)
        					if(tile1.getStackInSlot(0).getItem() == Item.enderPearl && tile2.getStackInSlot(0).getItem() == Item.enderPearl  && tile3.getStackInSlot(0).getItem() == Item.enderPearl  && tile4.getStackInSlot(0).getItem() == Item.enderPearl){

        				
        					if(MinedY == 0){
        						MinedY = this.yCoord - 1;
        					}
        					
        					if(MinedY <= LastY){
        						CanMine = false;
        						return;
        					}
        					
        					int x = this.xCoord;
        					int y = this.MinedY;
        					int z = this.zCoord;
        					
        					MineBlock(x, y, z);
        					
        					MineBlock(x + 1, y, z);
        					MineBlock(x - 1, y, z);
        					
        					MineBlock(x, y, z + 1);
        					MineBlock(x, y, z - 1);
        					
        					MineBlock(x + 1, y, z + 1);
        					MineBlock(x + 1, y, z - 1);
        					
        					MineBlock(x - 1, y, z + 1);
        					MineBlock(x - 1, y, z - 1);
        					
        					MinedY--;
        					this.getStackInSlot(this.ToolSlot).attemptDamageItem(1, this.worldObj.rand);
        					Power = Power - 3 + this.worldObj.rand.nextInt(5);
        					
        						
        						
        						
        					
        					
        					
        					}
        				}
        			}

        		}
        		
        	}
    		
    		}
    		
    		
    	}else{
    		Time++;
    	}

    	
    }
    
    
    public void MineBlock(int x, int y, int z){
    	World world = this.worldObj;
    	
    	world.destroyBlock(x, y, z, true);
    	
    	BlocksMined++;
    	
    }

	





    public void receiveButtonEvent(byte buttonId) {
	
    	
    	switch(buttonId){
    	
    	case 1:
    		LastY = LastY + 1;
    		
    		CanMine = true;
    		Ready = false;
    		break;
    		
    	case 2:
    		if(LastY > 0)
    			LastY--;
    		
    		CanMine = true;
    		Ready = false;
    		break;
    		
    	case 3:
    		if(Ready)
    			Ready = false;
    		else
    			Ready = true;
    		break;
    	
    	case 4:
    		LastY = this.yCoord - 1;
    		
    		CanMine = true;
    		Ready = false;
    		break;
	
    	}

    }
 
    
   
}
