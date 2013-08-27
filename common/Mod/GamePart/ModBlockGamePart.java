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
import Mod.Lib.Refrence;
import Mod.Main.ModConfig;

public class ModBlockGamePart extends BlockContainer{


	private String Name;
	
	boolean isActive = false;

	
	public ModBlockGamePart(int par1, String Name){
		super(par1, Material.rock);
		this.Name = Name;
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		
		this.Name = Name.toLowerCase();
		
		switch(Name){
		
		case "blue":
			return new TileEntityGamePartBlue();
			
		case "red":
			return new TileEntityGamePartRed();
			
		case "yellow":
			return new TileEntityGamePartYellow();
		
		case "green":
			return new TileEntityGamePartGreen();
			
		case "null":
			return new TileEntityGamePartNull();
			
			
			
			
			default :
				return new TileEntityGamePartRed();
				
		
		}
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
    	this.blockIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "GamePart" + Name);
    	}else{
        	this.blockIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "GamePart");
    	}
    }
    
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
        int Id;
    	
    	
    	if(player.inventory.getCurrentItem() == null){
    	
    	int DirectionMath = MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
    	
    	String Direction = DirectionMath == 0 ? "south" : DirectionMath == 1 ? "west" : DirectionMath == 2 ? "north" : "east";
      
      
      switch(Direction){
      
      
      case "south":
    	  
    	  if(world.getBlockId(x, y, z + 1) == Block.tallGrass.blockID || world.getBlockId(x, y, z + 1) == 0 ){
    		  if(world.getBlockId(x, y - 1, z + 1)== Block.tallGrass.blockID || world.getBlockId(x, y - 1, z + 1) == 0){
        		  Id = world.getBlockId(x, y, z);
        		  world.setBlock(x, y, z, 0);
        		  world.setBlock(x, y - 1, z + 1, Id);
    		  }else{
    		  
    		  Id = world.getBlockId(x, y, z);
    		  world.setBlock(x, y, z, 0);
    		  world.setBlock(x, y, z + 1, Id);
    		  
    	  }
    	  }
    	  
    	  
    	  
    	  break;
    	  
      case "west":
    	  
    	  if(world.getBlockId(x - 1, y,z) == Block.tallGrass.blockID || world.getBlockId(x - 1, y,z) == 0){
    		  Id = world.getBlockId(x, y, z);
    		  world.setBlock(x, y, z, 0);
    		  world.setBlock(x - 1, y, z, Id);
    		  
    	  
    	  }
    	  
    	  
    	  break;
    	  
      case "north":
    	  if(world.getBlockId(x, y, z - 1) == Block.tallGrass.blockID || world.getBlockId(x, y, z - 1) == 0){
    		  Id = world.getBlockId(x, y, z);
    		  world.setBlock(x, y, z, 0);
    		  world.setBlock(x, y, z - 1, Id);
    		  
    	  }
    	  
    	  
    	  break;
    	  
      case "east":
    	  
    	  if(world.getBlockId(x + 1, y,z) == Block.tallGrass.blockID || world.getBlockId(x + 1, y,z) == 0){
    		  Id = world.getBlockId(x, y, z);
    		  world.setBlock(x, y, z, 0);
    		  world.setBlock(x + 1, y, z, Id);
    		  
    	  }
    	  
    	 
    	
    	  
    	  break;
    	  
    	  
    	  
    	  
      }
    	}else{
    		return false;
    	}
    	
        return true;
    }
    
    /*
     * 0 = south z-
     * 1 = west  x-
     * 2 = north z+
     * 3 = east x+
     */
    
    
    
    
    public boolean canProvidePower(){
    	
    	return true;
    }
    
    public void onNeighborBlockChange(World world, int x, int y, int z, int Id) {
    	
    	
    	if(world.getBlockId(x, y - 1, z) == 159){
    		isActive = true;
    	}else{
    		isActive = false;
    	}
    }
    
    
    @Override
    public int isProvidingWeakPower(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
    	
    	if(isActive){

        {
            int i1 = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
            return i1 == 5 && par5 == 1 ? 0 : (i1 == 3 && par5 == 3 ? 0 : (i1 == 4 && par5 == 2 ? 0 : (i1 == 1 && par5 == 5 ? 0 : (i1 == 2 && par5 == 4 ? 0 : 15))));
        }
    }else{
    	return 0;
    }
    }
    
    public int isProvidingStrongPower(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
    	
    	
        return par5 == 0 ? this.isProvidingWeakPower(par1IBlockAccess, par2, par3, par4, par5) : 0;
    }
    

}



    