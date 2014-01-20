package Mod.ItemBlock;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import Mod.Block.ModBlocks;
import Mod.TileEntity.TileEntityXpStorage;

public class ModItemXpStorageBlock extends ItemBlock{

	public ModItemXpStorageBlock(int par1) {
		super(par1);
	}

	 public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata)
	    {
	      
		 if(stack.stackTagCompound != null){
			 world.setBlock(x, y, z, ModBlocks.XpStorage.blockID);
			 if(world.getBlockTileEntity(x, y, z) != null){
				 TileEntityXpStorage tile = (TileEntityXpStorage)world.getBlockTileEntity(x, y, z);
				 
				 
				 tile.XpAmount = stack.stackTagCompound.getInteger("Levels");
			 }
			 
			 
		 }else{
			 world.setBlock(x, y, z, ModBlocks.XpStorage.blockID); 
		 }
	       return true;
	    }
	 

	    @Override
	    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
	    {
	    	
	    	if(itemstack.stackTagCompound != null){
	    		list.add("Levels stored: " + itemstack.stackTagCompound.getInteger("Levels"));
	    	}

	    }
}

