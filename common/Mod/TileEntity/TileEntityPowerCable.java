package Mod.TileEntity;

import Mod.Block.ModBlockCharger;
import Mod.Block.ModBlockPowerCable;
import Mod.Block.ModBlockPowerModule;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityPowerCable extends TileEntity{

	
       
       int Power = 0;
       int MaxPower = 6;
       
   	   int Ticks = 10;
   	   int CurrentTick = 0;
       int GenerateTime = 0;
       
       
       
       
	   @Override
	public void writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);
		compound.setInteger("Power", this.Power);
		compound.setInteger("Time", this.GenerateTime);

	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
	
		
		Power = compound.getInteger("Power");
		GenerateTime = compound.getInteger("Time");

		

		
	}
	
	
    public void updateEntity()
    {
    	
    	
 	   World world = this.worldObj;
       int X = this.xCoord;
       int Y = this.yCoord;
       int Z = this.zCoord;
  
    	
    	boolean Top, Bottom, Left, Right, Front, Back;
        Bottom = IsPowerBlock(world, X, Y - 1, Z, true, false);
        Top = IsPowerBlock(world, X, Y + 1, Z, true, true);
        Front = IsPowerBlock(world, X, Y, Z + 1, false, false);
        Back = IsPowerBlock(world, X, Y, Z - 1, false, false);
        Right = IsPowerBlock(world, X - 1, Y, Z, false, false);
        Left = IsPowerBlock(world, X + 1, Y, Z, false, false);
        
        if(Bottom)
        	SendPowerToCable(world, X, Y - 1, Z);
        
        if(Top)
        	SendPowerToCable(world, X, Y + 1, Z);
        
        if(Front)
        	SendPowerToCable(world, X, Y, Z + 1);
        
        if(Back)
        	SendPowerToCable(world, X, Y, Z - 1);
        
        if(Right)
        	SendPowerToCable(world, X - 1, Y, Z);
        
        if(Left)
        	SendPowerToCable(world, X + 1, Y , Z);
        
        
        if(Bottom){
        	if(world.getBlockTileEntity(X, Y - 1, Z) instanceof TileEntityCharger){
        		TileEntityCharger tile = (TileEntityCharger)world.getBlockTileEntity(X, Y - 1, Z);
        		
        		if(tile.GetPower() != tile.MaxPower){
        			if(Power > 0){
        				tile.SetPower(tile.GetPower() + 1);
        				Power--;
        			}
        		}
        		
        	}
        	
        }
        
        if(Top){
        	if(world.getBlockTileEntity(X, Y + 1, Z) instanceof TileEntityCharger){
        		TileEntityCharger tile = (TileEntityCharger)world.getBlockTileEntity(X, Y + 1, Z);
        		
        		if(tile.GetPower() > 0 && Power < MaxPower){
        			tile.SetPower(tile.GetPower() - 1);
        			Power++;
        		}
        		
        	}else {
        		if(CurrentTick >= Ticks){
        			CurrentTick = 0;
        		int BlockId = world.getBlockId(X, Y + 1, Z);
        		Block block = Block.blocksList[BlockId];
        		
        		if(block instanceof ModBlockPowerModule){
        			ModBlockPowerModule Module = (ModBlockPowerModule)block;
        			if(GenerateTime == Module.WorkTime()){
        				GenerateTime = 0;
        				Module.OnWork(worldObj, xCoord, yCoord + 1, zCoord);
    				Power = Power + Module.PowerGenerated();
        			}else{
        				GenerateTime++;
        			}
        			
        			
        		}
        		}else{
        			CurrentTick++;
        		}
        		
        		
        	}
        }

    }
    
    public int GetPower(){
    	return Power;
    }
    
    public int GetMaxPower(){
    	return Power;
    }
    
    public int GetPowerSpaceLeft(){
    	return MaxPower - Power;
    }
    
    public void SetPower(int i){
    	Power = i;
    }
    
 public boolean IsPowerBlock(World world, int x, int y, int z, boolean CanBeCharger, boolean CanBeModule){
    	
    	int BlockID = world.getBlockId(x, y, z);
    	
    	Block block = Block.blocksList[BlockID];
    	
    	if(block instanceof ModBlockPowerCable)return true;
    	if(CanBeModule)
    	if(block instanceof ModBlockPowerModule)return true;
    	if(CanBeCharger)
    	if(block instanceof ModBlockCharger)return true;

    	
    	return false;
    }
 public void SendPowerToCable(World world, int x, int y, int z){
	 TileEntityPowerCable tile;
	 
	 if(world.getBlockTileEntity(x, y, z) instanceof TileEntityPowerCable){
		 tile = (TileEntityPowerCable)world.getBlockTileEntity(x, y, z);
	 
	 
	if(Power > tile.GetPower()){
		tile.SetPower(tile.GetPower() + 1);
		Power--;
	}
	 }
 }
       

}


