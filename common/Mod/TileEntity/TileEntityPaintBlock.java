package Mod.TileEntity;

import java.awt.Color;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;

public class TileEntityPaintBlock extends TileEntity{
	
	

	int Red = 0;
	int Green = 0;
	int Blue = 0;

	
	int i = 0;
	
	  

      
	    public void updateEntity() {



	    	
	    }
	  
      public void SetRed(int i){
    	  if(i < 255 && i > - 1)
    	  Red = i;
      }
      
      public void SetGreen(int i){
    	  if(i < 255 && i > - 1)
    	  Green = i;
      }
      
      public void SetBlue(int i){
    	  if(i < 255 && i > - 1)
    	  Blue = i;
      }
      
      
      
      
      public int GetRed(){
    	 return Red;
      }
      
      public int GetGreen(){
    	  return Green;
      }
      
      public int GetBlue(){
    	  return Blue;
      }
      
      public int GetHex(){
    	  Color color = new Color(Red, Green, Blue);
        	  return color.getRGB();

      }
      
      

      @Override
  	public void writeToNBT(NBTTagCompound compound){
  		super.writeToNBT(compound);
  		
  		compound.setInteger("Red", Red);
  		compound.setInteger("Blue", Blue);
  		compound.setInteger("Green", Green);

  		
  	}
  	
  	@Override
  	public void readFromNBT(NBTTagCompound compound){
  		super.readFromNBT(compound);

  		Red = compound.getInteger("Red");
  		Blue = compound.getInteger("Blue");
  		Green = compound.getInteger("Green");
  		
  	}

  	@Override
  	public Packet getDescriptionPacket()
  	{
  	 NBTTagCompound var1 = new NBTTagCompound();
  	 this.writeToNBT(var1);
  	 return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 2, var1);
  	}
  	        
  	@Override
  	public void onDataPacket(INetworkManager netManager, Packet132TileEntityData packet)
  	{
  	 readFromNBT(packet.data);
  	}
  






}
