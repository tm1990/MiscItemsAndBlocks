package Mod.TileEntity;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityDisarmTrap extends TileEntity{

	
	public static int MaxTime = 20;
	public int Time = 0;
	
	
	public Block TextureBlock;
	
	
	public void SetBlock(Block block){
		TextureBlock = block;
	}
	
	public Block GetBlock(){
		return TextureBlock;
		

	}
	
	
	   @Override
		public void writeToNBT(NBTTagCompound compound){
			super.writeToNBT(compound);

			if(this.TextureBlock != null)
			compound.setInteger("BlockID", TextureBlock.blockID);

		}
	   
		@Override
		public void readFromNBT(NBTTagCompound compound){
			super.readFromNBT(compound);
			
		
			TextureBlock = Block.blocksList[compound.getInteger("BlockID")];
		}
		
		
	    public void updateEntity()
	    {
	    	int x = this.xCoord;
	    	int y = this.yCoord;
	    	int z = this.zCoord;
	    	
	    	World world = this.worldObj;
	    	
	    	
	    	if(world.getBlockMetadata(x, y, z) >= 1){
	    	if(Time >= MaxTime){
	    		Time = 0;
	    		
	    		if(world.getBlockMetadata(x, y, z) >= 1){
	                world.playSoundEffect((double)x + 0.5D, (double)y + 0.1D, (double)z + 0.5D, "random.click", 0.3F, 0.6F);
	                world.setBlockMetadataWithNotify(x, y, z, 0, 2);
	         	
	         }
	    		
	    		
	    		
	    	}else{
	    		Time++;
	    	}
	    	}
	    	
	    }
	    
	
}


