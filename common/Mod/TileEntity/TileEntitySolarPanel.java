package Mod.TileEntity;

import Mod.Block.ModBlockSolarPanel;
import Mod.Block.ModBlocks;
import net.minecraft.tileentity.TileEntity;

public class TileEntitySolarPanel extends TileEntity{

	String Mode = "No Charger";
	String ModeStat = "off";
	
    public void updateEntity()
    {

    	
    	
    		int MetaData = this.worldObj.getBlockMetadata(xCoord, yCoord, zCoord);

    		if(MetaData == 1 || MetaData == 0){
    			
    			Mode = "Currently Generating";
    			ModeStat = "on";
    			
    		}else if (MetaData == 2){
    			
    			Mode = "Solar panel cant see the sky";
    			ModeStat = "blocked";
    			
    		}else if (MetaData == 3){
    			
    			Mode = "Solar panel cant see the sun";
    			ModeStat = "rain";
    			
    		}else if (MetaData == 4){
    			
    			Mode = "Solar panel cant see the sun";
    			ModeStat = "night";
    			
    		}else{
    			Mode = "No Power Storage!";
    			ModeStat = "";
    		}
    		
    	
    	
	}
    
    public String GetMessage(){
    	return Mode;
    }
    
    public String GetState(){
    	return ModeStat;
    }
}
