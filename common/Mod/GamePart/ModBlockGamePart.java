package Mod.GamePart;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import Mod.Lib.ModConfig;
import Mod.Lib.Refrence;

public class ModBlockGamePart extends BlockContainer{


	private String Name;
	
	public ModBlockGamePart(int par1, String Name){
		super(par1, Material.rock);
		this.Name = Name;
		this.setHardness(1F);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {

		
		if(Name == "Blue"){

			return new TileEntityGamePartBlue();
		}
		
		if(Name == "Red"){

			return new TileEntityGamePartRed();
		}
		
		if(Name == "Yellow"){
			
			return new TileEntityGamePartYellow();
		}
		
		if(Name == "Green"){

			return new TileEntityGamePartGreen();
		}
				
		return new TileEntityGamePartNull();
		}
	
	@Override
	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
	{
	   return false;
	}
	@Override
	public boolean isOpaqueCube()
	{
	   return false;
	}


	
    @Override
    public int getRenderType() {
            return -1;
    }
	@Override
    public boolean renderAsNormalBlock() {
        return false;
}

    public void registerIcons(IconRegister par1IconRegister)
    {
    	
    	if(Name != "null"){
    		
    		if(Name == "Yellow")
    	    	this.blockIcon = par1IconRegister.registerIcon("hardened_clay_stained_yellow");
    		
    		if(Name == "Green")
    	    	this.blockIcon = par1IconRegister.registerIcon("hardened_clay_stained_green");
    		
    		if(Name == "Red")
    	    	this.blockIcon = par1IconRegister.registerIcon("hardened_clay_stained_red");
    		
    		if(Name == "Blue")
    	    	this.blockIcon = par1IconRegister.registerIcon("hardened_clay_stained_blue");
    		
    		
    		
    	}else{
        	this.blockIcon = par1IconRegister.registerIcon("quartz_block_side");
    	}
    }
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
        int Id;
        
    	if(player.inventory.getCurrentItem() == null){
    	
    	int DirectionMath = MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
    	
    	String Direction = DirectionMath == 0 ? "south" : DirectionMath == 1 ? "west" : DirectionMath == 2 ? "north" : "east";
    	
		  
		  Id = world.getBlockId(x, y, z);
      
    	if(Direction == "south"){
    		
  		  if(world.getBlockId(x, y, z + 1) == Id && world.getBlockId(x, y + 1, z + 1) == 0){
			  
    		  world.setBlock(x, y, z, 0);
    		  world.setBlock(x, y + 1, z + 1, Id);
    		  
		  }else{
    	  
    	  if(world.getBlockId(x, y, z + 1) == Block.tallGrass.blockID || world.getBlockId(x, y, z + 1) == 0 ){
    		  

    		  world.setBlock(x, y, z, 0);
    		  world.setBlock(x, y, z + 1, Id);
    	  }
    		  
    	  
    	  }
    	}
    	  
    	  
    	  

    	if(Direction == "west"){
    		
  		  if(world.getBlockId(x - 1, y, z) == Id && world.getBlockId(x - 1, y + 1, z) == 0){
			  
    		  world.setBlock(x, y, z, 0);
    		  world.setBlock(x - 1, y + 1, z, Id);
    		  
		  }else{
    	  
    	  if(world.getBlockId(x - 1, y,z) == Block.tallGrass.blockID || world.getBlockId(x - 1, y,z) == 0){

    		  
    		  world.setBlock(x, y, z, 0);
    		  world.setBlock(x - 1, y, z, Id);

    	  }
    		  
    	  
    	  }
    	}
    	  
      if(Direction == "north"){
    	  
		  
		  if(world.getBlockId(x, y, z - 1) == Id && world.getBlockId(x, y + 1, z - 1) == 0){
			  
    		  world.setBlock(x, y, z, 0);
    		  world.setBlock(x, y + 1, z - 1, Id);
    		  
		  }else{
			  
    	  if(world.getBlockId(x, y, z - 1) == Block.tallGrass.blockID || world.getBlockId(x, y, z - 1) == 0){

    		  
    		  world.setBlock(x, y, z, 0);
    		  world.setBlock(x, y, z - 1, Id);
    		  
    		  
    		  
    	  }
    		  
    	  }
      }
    	  
      if(Direction == "east"){
    	  
		  
		  if(world.getBlockId(x + 1, y, z) == Id && world.getBlockId(x + 1, y + 1, z) == 0){
			  
    		  world.setBlock(x, y, z, 0);
    		  world.setBlock(x + 1, y + 1, z, Id);
    		  
		  }else{
    	  
    	  if(world.getBlockId(x + 1, y,z) == Block.tallGrass.blockID || world.getBlockId(x + 1, y,z) == 0){
    		  
    		  world.setBlock(x, y, z, 0);
    		  world.setBlock(x + 1, y, z, Id);

    		  }
    		  
    	  }
      }
    	  
    	  
    	
    	}else{
    		return false;
    	}
    	
        return true;
    }
    
    public void onBlockAdded(World world, int x, int y, int z) {
    	
		 blockFall(world, x, y, z);

    	
    }
    
    public void onNeighborBlockChange(World world, int x, int y, int z, int nId) {

		 blockFall(world, x, y, z);
    	
    }
    
    public void setBlockBoundsBasedOnState(IBlockAccess block, int x, int y, int z) {
    	
		 int Id = block.getBlockId(x, y, z);
    	
    	
		 if(block.getBlockId(x, y + 1, z) == Id && block.getBlockId(x, y - 1, z) == Id){
				this.setBlockBounds(0.2F, 0, 0.2F, 0.8F, 1, 0.8F);
		 }else{
				this.setBlockBounds(0.1F, 0, 0.1F, 0.9F, 1, 0.9F);
		 }
    	
    }
    
    public void blockFall(World world, int x, int y, int z){

    	
    	if(world.getBlockId(x, y - 1, z) == 0 || world.getBlockId(x, y - 1, z) == Block.tallGrass.blockID){
    		
    		int BlockID = world.getBlockId(x, y, z);
    		
    		world.setBlock(x, y, z, 0);
    		world.setBlock(x, y - 1, z, BlockID);
    		
    	}

    	
    }
    
    
    
    

}



    