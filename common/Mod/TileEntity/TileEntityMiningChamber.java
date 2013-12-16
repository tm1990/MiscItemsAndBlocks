package Mod.TileEntity;

import java.util.List;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.packet.Packet;
import net.minecraft.world.World;
import Mod.LibMisc.BlockUtil;
import Mod.LibMisc.Utils;
import Mod.Misc.ItemHelper;
import Mod.Network.PacketTileWithItemUpdate;
import Mod.Network.PacketTypeHandler;

public class TileEntityMiningChamber extends TileEntityPowerInv{

	public TileEntityMiningChamber() {
		super(1, "MiningCHamber", 64, MaxPower);
	}
	
	int Power = this.GetPower();
	int PowerTime = 0;
	int Time = 0;
	int MinedY = 0;
	int BlocksMined = 0;
	int GenerateTime = 0;
	boolean CanMine = true;
	boolean Ready = false;
	int CurrentBlock = 0;
	
	public boolean Running;
	
	int Fortune = 0;
	int MiningTime = 0;
	
	public static int MaxPower = 100;
	public static int ToolSlot = 0;
	
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
	
	public boolean IsRunning(){
		return Running;
	}
	
	public boolean CanMine(){
		return CanMine;
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
		
		compound.setInteger("Current", CurrentBlock);
		
		compound.setInteger("Luck", Fortune);
		compound.setInteger("MiningTime", MiningTime);

		
		
		
		
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
		
		CurrentBlock = compound.getInteger("Current");
		
		Fortune = compound.getInteger("Luck");
		MiningTime = compound.getInteger("MiningTime");

		
		
		
	}
	
    public void updateEntity()
    {
    	
    	
    	int Eff = EnchantmentHelper.getEnchantmentLevel(32, this.getStackInSlot(ToolSlot));
    	int Luck = EnchantmentHelper.getEnchantmentLevel(35, this.getStackInSlot(ToolSlot));
    	
    	
    	
    	if(Eff > 0){
    		int t = Eff * 3;
    		this.MiningTime = 50 - t;
    	}else{
    		this.MiningTime = 80;
    	}
    	
    	if(Luck > 0){
    		Fortune = Luck;
    	}
    	
    	if(CurrentBlock < 0 || CurrentBlock > 9){
    		CurrentBlock = 0;
    	}
    	
    
    	if(Power > 0 && this.getStackInSlot(this.ToolSlot) != null && this.getStackInSlot(ToolSlot).getItem() instanceof ItemPickaxe){

    		
    	if(Ready && Time >= MiningTime){
    		Time = 0;


			SetValue(1);

    	
        	
        				
        					if(MinedY == 0){
        						MinedY = this.yCoord - 1;
        					}
        					
        					

        					int x = this.xCoord;
        					int y = this.MinedY;
        					int z = this.zCoord;
        					
        					CurrentBlock++;
        					
        					if(Power > 0){
        					
        					if(CurrentBlock == 1 && !IsAirBlock(x, y, z))
        					MineBlock(x, y, z);
        					else if(CurrentBlock == 2 && !IsAirBlock(x + 1, y, z))
        					MineBlock(x + 1, y, z);
        					else if (CurrentBlock == 3 && !IsAirBlock(x - 1, y, z))
        					MineBlock(x - 1, y, z);
        					else if (CurrentBlock == 4 && !IsAirBlock(x, y, z + 1))
        					MineBlock(x, y, z + 1);
        					else if (CurrentBlock == 5 && !IsAirBlock(x, y, z - 1))
        					MineBlock(x, y, z - 1);
        					else if (CurrentBlock == 6 && !IsAirBlock(x + 1, y, z + 1))
        					MineBlock(x + 1, y, z + 1);
        					else if (CurrentBlock == 7 && !IsAirBlock(x + 1, y, z - 1))
        					MineBlock(x + 1, y, z - 1);
        					else if (CurrentBlock == 8 && !IsAirBlock(x - 1, y, z + 1))
        					MineBlock(x - 1, y, z + 1);
        					else if (CurrentBlock == 9 && !IsAirBlock(x - 1, y, z - 1))
        					MineBlock(x - 1, y, z - 1);
        					
        					
        					if(CurrentBlock == 9){
        					MinedY--;
        					CurrentBlock = 0;
        					}
        					
        					
        					this.getStackInSlot(this.ToolSlot).attemptDamageItem(1, this.worldObj.rand);
        					Power = this.GetPower() - (3 + this.worldObj.rand.nextInt(9));
        					
        					if(Power < 0 ){
        						Power = 0;
        						SetValue(0);
        					}else if (Power == 0){
        						SetValue(0);
        					}
        						
        					
        					if(MinedY <= LastY){
        						SetValue(0);
        						return;
        					}
        						
        					
        						
        					
        					
        					}

        		
        	
        	}else{
        		Time++;
        	}
    		
    		
    	
    	
    	}else{
    		if(Power > 0 && GetValue() != 2 && this.getStackInSlot(this.ToolSlot) != null && !(this.getStackInSlot(ToolSlot).getItem() instanceof ItemPickaxe)){
				SetValue(2);
    		}else if (this.getStackInSlot(ToolSlot) == null){
    			SetValue(0);
    		}

    		CanMine = false;
    	
    		}
    	

    		
    		


    	
    }
    
    public void SetValue(int i){
		this.worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, i, 2);
		System.out.println("Setting " + i);
		
		if(i != 1)
		Ready = false;
		
		if(i == 0 || i == 2){
			CanMine = false;
			
		}else{
			CanMine = true;
		}
    }
    
    public int GetValue(){
    	return this.worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
    }
    
    
    public boolean IsAirBlock(int x, int y, int z){
    	World world = this.worldObj;
    	
    	return world.isAirBlock(x, y, z);
    }
    
    
    public void MineBlock(int x, int y, int z){

    	
    	BlocksMined++;
    	
        List<ItemStack> stacks = BlockUtil.getItemStackFromBlock(worldObj, x, y, z, Fortune);

        if (stacks != null) {
                for (ItemStack s : stacks) {
                        if (s != null) {
                                mineStack(s);
                        }
                }
        }
        
        this.worldObj.destroyBlock(x, y, z, false);
    	
    	}
    	
    	
    	
    

	





    public void receiveButtonEvent(byte buttonId) {
	
    	
    	switch(buttonId){
    	
    		
    	case 1:
    		if(LastY > 0)
    			LastY--;
    		
    		CanMine = true;
    		Ready = false;
    		break;
    		
    	case 2:
    		LastY = LastY + 1;
    		
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
    		MinedY = 0;
    		
    		CanMine = true;
    		Ready = false;
    		break;
    		
    
	
    	}

    }
    
    @Override
    public Packet getDescriptionPacket() {

        ItemStack itemStack = getStackInSlot(0);

        if (itemStack != null && itemStack.stackSize > 0)
            return PacketTypeHandler.populatePacket(new PacketTileWithItemUpdate(xCoord, yCoord, zCoord, orientation, state, customName, itemStack.itemID, itemStack.getItemDamage(), itemStack.stackSize, ItemHelper.getColor(itemStack)));
        else
            return super.getDescriptionPacket();
    }
	
    private void mineStack(ItemStack stack) {
    	
        // First, try to add to a nearby chest
        stack.stackSize -= Utils.addToRandomInventoryAround(worldObj, xCoord, yCoord, zCoord, stack);


        // Lastly, throw the object away
        if (stack.stackSize > 0) {
                float f = worldObj.rand.nextFloat() * 0.8F + 0.1F;
                float f1 = worldObj.rand.nextFloat() * 0.8F + 0.1F;
                float f2 = worldObj.rand.nextFloat() * 0.8F + 0.1F;

                EntityItem entityitem = new EntityItem(worldObj, xCoord + f, yCoord + f1 + 0.5F, zCoord + f2, stack);

                entityitem.lifespan =  1200;
                entityitem.delayBeforeCanPickup = 10;

                float f3 = 0.05F;
                entityitem.motionX = (float) worldObj.rand.nextGaussian() * f3;
                entityitem.motionY = (float) worldObj.rand.nextGaussian() * f3 + 1.0F;
                entityitem.motionZ = (float) worldObj.rand.nextGaussian() * f3;
                worldObj.spawnEntityInWorld(entityitem);
        }
}
    
   
}
