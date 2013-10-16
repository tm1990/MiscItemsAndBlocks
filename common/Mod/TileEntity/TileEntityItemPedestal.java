package Mod.TileEntity;

import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityItemPedestal extends TileEntity implements IInventory{

	public ItemStack[] items = new ItemStack[this.getSizeInventory()];
	
	public TileEntityItemPedestal() {
	}
	
	int i = 0;
	ItemStack finsishItem;
	

	
	 @Override
	    public void readFromNBT(NBTTagCompound nbtTagCompound) {

	        super.readFromNBT(nbtTagCompound);

	        NBTTagList tagList = nbtTagCompound.getTagList("Items");
	        items = new ItemStack[this.getSizeInventory()];
	        for (int i = 0; i < tagList.tagCount(); ++i) {
	            NBTTagCompound tagCompound = (NBTTagCompound) tagList.tagAt(i);
	            byte slotIndex = tagCompound.getByte("Slot");
	            if (slotIndex >= 0 && slotIndex < items.length) {
	                items[slotIndex] = ItemStack.loadItemStackFromNBT(tagCompound);
	            }
	        }
	        
	        i = nbtTagCompound.getInteger("Time");
	    }

	    @Override
	    public void writeToNBT(NBTTagCompound nbtTagCompound) {

	        super.writeToNBT(nbtTagCompound);

	        NBTTagList tagList = new NBTTagList();
	        for (int currentIndex = 0; currentIndex < items.length; ++currentIndex) {
	            if (items[currentIndex] != null) {
	                NBTTagCompound tagCompound = new NBTTagCompound();
	                tagCompound.setByte("Slot", (byte) currentIndex);
	                items[currentIndex].writeToNBT(tagCompound);
	                tagList.appendTag(tagCompound);
	            }
	        }
	        nbtTagCompound.setTag("Items", tagList);
	        
	        nbtTagCompound.setInteger("Time", i);
	    }
	    public ItemStack[] workItems = new ItemStack[9];
		private ItemStack finishItem;
  		
	    public boolean CanCraft(){
	    	TileEntityItemPedestal tile;


	    	
	    	World world = this.worldObj;
	    	int x = this.xCoord;
	    	int y = this.yCoord;
	    	int z = this.zCoord;
	    	

	    	TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
	    	
	    	if(!IsPedestal(x, y, z))
	    		return false;
	    	else
	    		workItems[0] = GetPedestalItems(x - 1, y, z + 1);
	    	
	    	if(!IsPedestal(x + 1, y, z))
	    		return false;
	    	else
	    		workItems[1] = GetPedestalItems(x, y, z + 1);
	    	
	    	if(!IsPedestal(x - 1, y, z))
	    		return false;
	    	else
	    		workItems[2] = GetPedestalItems(x - 1, y, z + 1);
	    	
	    	if(!IsPedestal(x + 1, y, z + 1))
	    		return false;
	    	else
	    		workItems[3] = GetPedestalItems(x - 1, y, z);
	    	
	    	if(!IsPedestal(x - 1, y, z + 1))
	    		return false;
	    	else
	    		workItems[4] = GetPedestalItems(x, y, z);
	    	
	    	if(!IsPedestal(x + 1, y, z - 1))
	    		return false;
	    	else
	    		workItems[5] = GetPedestalItems(x + 1, y, z);
	    	
	    	if(!IsPedestal(x - 1, y, z - 1))
	    		return false;
	    	else
	    		workItems[6] = GetPedestalItems(x - 1, y, z - 1);
	    	
	    	if(!IsPedestal(x, y, z + 1))
	    		return false;
	    	else
	    		workItems[7] = GetPedestalItems(x, y, z - 1);
	    	
	    	if(!IsPedestal(x, y, z - 1))
	    		return false;
	    	else
	    		workItems[8] = GetPedestalItems(x + 1, y, z - 1);

	    	finishItem = Recipe(workItems);

	    	return Recipe(workItems) != null;
	    }
	    
	    public boolean IsPedestal(int x, int y, int z){
	    	
	    	TileEntity tile_entity = this.worldObj.getBlockTileEntity(x, y, z);
	    	
	    	if(tile_entity instanceof TileEntityItemPedestal){
	    		
	    		
	    		return true;
	    	}
	    	
	    	return false;
	    }
	    
	    public ItemStack GetPedestalItems(int x, int y, int z){
	    	
	    	
	    	TileEntityItemPedestal tile;
	    	TileEntity tile_entity = this.worldObj.getBlockTileEntity(x, y, z);
	    	
	    	if(tile_entity instanceof TileEntityItemPedestal){
	    		tile = (TileEntityItemPedestal)tile_entity;
	    		
	    	
	    		
	    		if(tile.getStackInSlot(0) != null){
	    			return tile.getStackInSlot(0);
	    		}
	    	}
	    	
	    	
	    	return null;
	    }
	    
	    
	    public ItemStack Recipe(ItemStack[] items){
	    	
	    	if(Check(items, null, Item.blazeRod, null, Item.blazeRod, Item.enderPearl, Item.blazeRod, null, Item.blazeRod, null))
	    	return new ItemStack(Item.eyeOfEnder, 8);
	    	
	    	if(Check(items, Item.ingotIron, Item.ingotIron, Item.ingotIron, Item.ingotIron, Item.ingotGold, Item.ingotIron, Item.ingotIron, Item.ingotIron, Item.ingotIron))
    	   return new ItemStack(Item.ingotGold, 4);
	    	
	    	if(Check(items, Item.ingotGold, Item.ingotGold, Item.ingotGold, Item.ingotGold, Item.diamond, Item.ingotGold, Item.ingotGold, Item.ingotGold, Item.ingotGold))
    	   return new ItemStack(Item.diamond, 4);
	    	
	    	if(Check(items, null, Item.diamond, null, Item.diamond, Item.diamond, Item.diamond, null, Item.diamond, null))
    	   return new ItemStack(Item.ingotGold, 5);
	    	
	    	if(Check(items, null, Item.ingotGold, null, Item.ingotGold, Item.ingotGold, Item.ingotGold, null, Item.ingotGold, null))
	     	   return new ItemStack(Item.ingotIron, 5);
	    	
	    	return null;
	    }
	    
	    public boolean Check(ItemStack item[], Item item1, Item item2, Item item3, Item item4, Item item5, Item item6, Item item7, Item item8, Item item9){
	    	
	    	
	    	if(Item(item[0], item1))
    			if(Item(item[1], item2))
    					if(Item(item[2], item3))
    					    if(Item(item[3], item4))
    							if(Item(item[4], item5))
    									if(Item(item[5], item6))
    											if(Item(item[6], item7))
    											    if(Item(item[7], item8))
    													if(Item(item[8], item9))
    														return true;

	    	return false;
	    }
	    
	    public boolean Item(ItemStack item, Item checkItem){
	    	
	    	if(checkItem == null)
	    		return true;
	    	
	    	return item != null && item.getItem() == checkItem;
	    }
	    
	    
	    
	    
    public void updateEntity()
    {

    	
    	if(CanCraft()){
    		
    	
    			  EntityLightningBolt lightning = new EntityLightningBolt(this.worldObj, this.xCoord, this.yCoord, this.zCoord);
                  
    			  this.worldObj.spawnEntityInWorld(lightning);
    			  
      			SetItem(null, this.xCoord, this.yCoord, this.zCoord);
      			SetItem(null, this.xCoord + 1, this.yCoord, this.zCoord);
      			SetItem(null, this.xCoord - 1, this.yCoord, this.zCoord);
      			SetItem(null, this.xCoord, this.yCoord, this.zCoord + 1);
      			SetItem(null, this.xCoord, this.yCoord, this.zCoord - 1);
      			
      			SetItem(null, this.xCoord + 1, this.yCoord, this.zCoord - 1);
      			SetItem(null, this.xCoord - 1, this.yCoord, this.zCoord - 1);
      			SetItem(null, this.xCoord + 1, this.yCoord, this.zCoord + 1);
      			SetItem(null, this.xCoord - 1, this.yCoord, this.zCoord + 1);
      			
      			
      			
      			
      			SetItem(finishItem, this.xCoord, this.yCoord, this.zCoord);
      			finishItem = null;
    			  }
    			  
    		
    			  
    			  
    	}
    	
    	  

    	
    	
    
    
    public boolean CheckForItem(Item item, int x, int y, int z){
    	TileEntityItemPedestal tile;
    	TileEntity tile_entity = this.worldObj.getBlockTileEntity(x, y, z);
    	
    	if(tile_entity instanceof TileEntityItemPedestal){
    		tile = (TileEntityItemPedestal)tile_entity;
    		
    		if(tile.getStackInSlot(0) != null){
    		if(tile.getStackInSlot(0).getItem() == item){
    			return true;
    		}else{
    			return false;
    		}
    	}
    		
    	}
   
    	return false;
    	
    }
    
    public void SetItem(ItemStack item, int x, int y, int z){
    	TileEntityItemPedestal tile;
    	TileEntity tile_entity = this.worldObj.getBlockTileEntity(x, y, z);
    	
    	if(tile_entity instanceof TileEntityItemPedestal){
    		tile = (TileEntityItemPedestal)tile_entity;

    		tile.setInventorySlotContents(0, item);
    		
    	}
   
    	
    	
    }



	@Override
	public int getSizeInventory() {
		return 1;
	}



	@Override
	public ItemStack getStackInSlot(int i) {
		return items[i];
	}



	@Override
	public ItemStack decrStackSize(int i, int j) {
		if(items[i].stackSize - j < 0){
			return items[i];
		}
		
		items[i].stackSize = items[i].stackSize - j;
		
		return items[i];
	}



	 @Override
	    public ItemStack getStackInSlotOnClosing(int slotIndex) {

	        ItemStack itemStack = getStackInSlot(slotIndex);
	        if (itemStack != null) {
	            setInventorySlotContents(slotIndex, null);
	        }
	        return itemStack;
	    }




	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		items[i] = itemstack;
		
	}



	@Override
	public String getInvName() {
		return "Pedestal";
	}



	@Override
	public boolean isInvNameLocalized() {
		return true;
	}



	@Override
	public int getInventoryStackLimit() {
		return 1;
	}



	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return entityplayer.getDistanceSqToEntity(entityplayer) < 64;
	}



	@Override
	public void openChest() {
		
	}



	@Override
	public void closeChest() {
		
	}



	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return false;
	}
  	
  	
}
