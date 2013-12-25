package Mod.TileEntity;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public abstract class TileEntityPowerGeneration extends TileEntityPowerInv{

	public TileEntityPowerGeneration(int Slots, String Name, int Size, int PowerMax) {
		super(Slots, Name, Size, PowerMax);
	}
	
	public abstract boolean CanWork(World world, int X, int Y, int Z);
	public abstract int WorkTime();
	public abstract int PowerProduced();
	
    public void OnWork(World world, int x, int y, int z){}
    
    public boolean isProvidingPower = false;
    
    
	@Override
	public boolean CanAcceptPower() {
		return false;
	}
	
	
	public int GetX(){
		return this.xCoord;
	}
	
	public int GetY(){
		return this.yCoord;
	}
	
	public int GetZ(){
		return this.zCoord;
	}
    
    @Override
	public void writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);
		
		compound.setBoolean("Providing", isProvidingPower);

	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		isProvidingPower = compound.getBoolean("Providing");

	}
	
	int ActiveSides = 0;
	Boolean[] Sides = new Boolean[6];
	
    public void updateEntity()
    {
  	   World world = this.worldObj;
       int X = this.xCoord;
       int Y = this.yCoord;
       int Z = this.zCoord;
    	


       if(CanWork(worldObj, xCoord, yCoord, zCoord)){
       
    	Sides[0] = AceptsPower(X, Y, Z + 1); // Front
    	Sides[1] = AceptsPower(X, Y, Z - 1); // Back
    	Sides[2] = AceptsPower(X - 1, Y, Z); // Right
    	Sides[3] = AceptsPower(X + 1, Y, Z); // Left
    	Sides[4] = AceptsPower(X, Y - 1, Z); // Bottom
    	Sides[5] = AceptsPower(X, Y + 1, Z); // Top


    	


    	ActiveSides = 0;
    	
    	for(int h = 0; h < Sides.length; h++){
    		if(Sides[h] == true)
    			ActiveSides++;
    	}

    	

    	
    	
    	
    	for(int h = 0; h < 6; h++){
    		if(Sides[h] == true){
    			SendPower(this.worldObj ,GetXCord(h), GetYCord(h), GetZCord(h), this.PowerProduced() / ActiveSides);
    			
    	    	//if(ActiveSides > 0)
    	        //	System.out.println("Power: " + ((double)this.PowerProduced() / (double)ActiveSides) + " Default: " + this.PowerProduced() + " Side: " + h + " Active sides: " + ActiveSides);
    		}
    	}
    	
       }
       
       if(ActiveSides > 0 && CanWork(worldObj, xCoord, yCoord, zCoord))
           this.OnWork(worldObj, xCoord, yCoord, zCoord);
       

    	
    }
    
    public int GetXCord(int h){
    	
    	int x = this.GetX();
    	
    	
    	switch(h){
    	
    	
    	case 0:
    		return x;
    		
    	case 1:
    		return x;
    		
    	case 2:
    		return x - 1;
    		
    	case 3:
    		return x + 1;
    		
    	case 4:
    		return x;
    		
    	case 5:
    		return x;
    		
    	}
    	
    	return 0;
    }
    
    public int GetZCord(int h){
    	
    	int z = this.GetZ();
    	
    	switch(h){
    	
    	
    	case 0:
    		return z + 1;
    		
    	case 1:
    		return z - 1;
    		
    	case 2:
    		return z;
    		
    	case 3:
    		return z;
    		
    	case 4:
    		return z;
    		
    	case 5:
    		return z;
    		
    	}
    	
    	return 0;
    }
    
    public int GetYCord(int h){
    	
    	int y = this.GetY();
    	
    	switch(h){
    	
    	
    	case 0:
    		return y;
    		
    	case 1:
    		return y;
    		
    	case 2:
    		return y;
    		
    	case 3:
    		return y;
    		
    	case 4:
    		return y - 1;
    		
    	case 5:
    		return y + 1;
    		
    	}
    	
    	return 0;
    }
    
    
    public void SendPower(World world, int x, int y, int z, int Amount){
    	
    	TileEntity tile_e = world.getBlockTileEntity(x, y, z);
    	
    	
    	
    	if(tile_e instanceof TileEntityPowerInv){
    		TileEntityPowerInv tile = (TileEntityPowerInv)tile_e;
    		
    		if(tile.CanAcceptPower()){
    		if(tile.GetPower() < tile.PowerMax && tile.GetPower() + Amount <= tile.PowerMax){
    			tile.SetPower(tile.GetPower() + Amount);
    		}
    			return;
    		}else{
    			tile.SetPower(tile.PowerMax);
    			return;
    		}
    		
    	}else if (tile_e instanceof TileEntityCharger){
    		TileEntityCharger tile = (TileEntityCharger)tile_e;
    		
    		if(tile.GetPower() < tile.GetMaxPower() && tile.GetPower() + Amount <= tile.GetMaxPower()){
    			tile.SetPower(tile.GetPower() + Amount);
    			return;
    		
    		}else{
    			tile.SetPower(tile.GetMaxPower());
    			return;
    		}
    		
    	}else if (tile_e instanceof TileEntityPowerCable){
    		TileEntityPowerCable tile = (TileEntityPowerCable)tile_e;
    		
    		if(tile.GetPower() < tile.MaxPower && tile.GetPower() + Amount <= tile.MaxPower){
    			tile.SetPower(tile.GetPower() + Amount);
    			return;
    		}else{
    			tile.SetPower(tile.MaxPower);
    			return;
    		}
    		
    	}
   
    	
    }
    
    public boolean AceptsPower(int x, int y, int z){
    	
    	TileEntity tile_e = this.worldObj.getBlockTileEntity(x, y, z);
    	if(tile_e instanceof TileEntityPowerInv || tile_e instanceof TileEntityPowerCable || tile_e instanceof TileEntityCharger){
    		
    		if(tile_e instanceof TileEntityPowerInv){
    			TileEntityPowerInv tile = (TileEntityPowerInv)tile_e;
    			
    			return tile.CanAcceptPower() && tile.PowerMax < tile.PowerMax;
    		}else if (tile_e instanceof TileEntityCharger){
    			TileEntityCharger tile = (TileEntityCharger)tile_e;

    			return y <= this.yCoord && tile.GetPower() < tile.GetMaxPower();
    		}else if (tile_e instanceof TileEntityPowerCable){
    			int Meta = this.worldObj.getBlockMetadata(x, y, z);
    			TileEntityPowerCable tile = (TileEntityPowerCable)tile_e;
    			
    			return Meta != 1 && tile.GetPower() < tile.MaxPower;

    		}
    		
    		return true;
    	}

    	return false;
    	

    }

}
