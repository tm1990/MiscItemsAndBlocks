package Mod.GamePart;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import Mod.Block.ModBlocks;

public class ModBlockGamePart extends BlockContainer{


	
	public ModBlockGamePart(int par1){
		super(par1, Material.rock);
		this.setHardness(1F);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
				
		return new TileEntityGamePart();
		}
	
    public int damageDropped(int par1)
    {
        return par1;
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

        	this.blockIcon = par1IconRegister.registerIcon("quartz_block_side");
    }
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
        int Meta;
    	int Id = world.getBlockId(x, y, z);
        
    	if(player.inventory.getCurrentItem() == null){
    	
    	int DirectionMath = MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
    	
    	String Direction = DirectionMath == 0 ? "south" : DirectionMath == 1 ? "west" : DirectionMath == 2 ? "north" : "east";
    	
		  
		  Meta = world.getBlockMetadata(x, y, z);
      
    	if(Direction == "south"){
    		
  		  if(world.getBlockMetadata(x, y, z + 1) == Meta && Id == ModBlocks.GamePart.blockID && world.getBlockId(x, y + 1, z + 1) == 0){
			  
    		  world.setBlock(x, y, z, 0);
    		  world.setBlock(x, y + 1, z + 1, ModBlocks.GamePart.blockID, Meta, 2);
    		  
		  }else{
    	  
    	  if(world.getBlockId(x, y, z + 1) == Block.tallGrass.blockID || world.getBlockId(x, y, z + 1) == Block.waterStill.blockID || world.getBlockId(x, y, z + 1) == Block.waterMoving.blockID || world.getBlockId(x, y, z + 1) == 0 ){
    		  

    		  world.setBlock(x, y, z, 0);
    		  world.setBlock(x, y, z + 1, ModBlocks.GamePart.blockID, Meta, 2);
    	  }
    		  
    	  
    	  }
    	}
    	  
    	  
    	  

    	if(Direction == "west"){
    		
  		  if(world.getBlockMetadata(x - 1, y, z) == Meta && Id == ModBlocks.GamePart.blockID && world.getBlockId(x - 1, y + 1, z) == 0){
			  
    		  world.setBlock(x, y, z, 0);
    		  world.setBlock(x - 1, y + 1, z, ModBlocks.GamePart.blockID, Meta, 2);
    		  
		  }else{
    	  
    	  if(world.getBlockId(x - 1, y, z) == Block.tallGrass.blockID || world.getBlockId(x - 1, y, z) == Block.waterStill.blockID || world.getBlockId(x - 1, y, z) == Block.waterMoving.blockID || world.getBlockId(x - 1, y,z) == 0){

    		  
    		  world.setBlock(x, y, z, 0);
    		  world.setBlock(x - 1, y, z, ModBlocks.GamePart.blockID, Meta , 2);

    	  }
    		  
    	  
    	  }
    	}
    	  
      if(Direction == "north"){
    	  
		  
		  if(world.getBlockMetadata(x, y, z - 1) == Meta && Id == ModBlocks.GamePart.blockID && world.getBlockId(x, y + 1, z - 1) == 0){
			  
    		  world.setBlock(x, y, z, 0);
    		  world.setBlock(x, y + 1, z - 1, ModBlocks.GamePart.blockID, Meta , 2);
    		  
		  }else{
			  
    	  if(world.getBlockId(x, y, z - 1) == Block.tallGrass.blockID || world.getBlockId(x, y, z - 1) == Block.waterStill.blockID || world.getBlockId(x, y, z - 1) == Block.waterMoving.blockID || world.getBlockId(x, y, z - 1) == 0){

    		  
    		  world.setBlock(x, y, z, 0);
    		  world.setBlock(x, y, z - 1, ModBlocks.GamePart.blockID, Meta , 2);
    		  
    		  
    		  
    	  }
    		  
    	  }
      }
    	  
      if(Direction == "east"){
    	  
		  
		  if(world.getBlockMetadata(x + 1, y, z) == Meta && Id == ModBlocks.GamePart.blockID && world.getBlockId(x + 1, y + 1, z) == 0){
			  
    		  world.setBlock(x, y, z, 0);
    		  world.setBlock(x + 1, y + 1, z, ModBlocks.GamePart.blockID, Meta , 2);
    		  
		  }else{
    	  
    	  if(world.getBlockId(x + 1, y,z) == Block.tallGrass.blockID || world.getBlockId(x + 1, y, z) == Block.waterStill.blockID || world.getBlockId(x + 1, y, z) == Block.waterMoving.blockID || world.getBlockId(x + 1, y,z) == 0){
    		  
    		  world.setBlock(x, y, z, 0);
    		  world.setBlock(x + 1, y, z, ModBlocks.GamePart.blockID, Meta , 2);

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
    	
		 int Meta = block.getBlockMetadata(x, y, z);
    	int Id = block.getBlockId(x, y, z);
    	
    	
		 if(block.getBlockMetadata(x, y + 1, z) == Meta && block.getBlockMetadata(x, y - 1, z) == Meta && Id == ModBlocks.GamePart.blockID){
				this.setBlockBounds(0.2F, 0, 0.2F, 0.8F, 1, 0.8F);
		 }else{
				this.setBlockBounds(0.1F, 0, 0.1F, 0.9F, 1, 0.9F);
		 }
    	
    }
    
    public void blockFall(World world, int x, int y, int z){

    	
    	if(world.getBlockId(x, y - 1, z) == 0 || world.getBlockId(x, y - 1, z) == Block.tallGrass.blockID || world.getBlockId(x, y - 1, z) == Block.waterStill.blockID || world.getBlockId(x, y - 1, z) == Block.waterMoving.blockID){
    		
    		int BlockID = world.getBlockId(x, y, z);
    		int Meta = world.getBlockMetadata(x, y, z);
    		
    		world.setBlock(x, y, z, 0);
    		world.setBlock(x, y - 1, z, BlockID, Meta, 2);
    		
    	}

    	
    }
    
    
    public void getSubBlocks(int id, CreativeTabs tabs, List list)
    {
        list.add(new ItemStack(id, 1, 0));
        list.add(new ItemStack(id, 1, 1));
        list.add(new ItemStack(id, 1, 2));
        list.add(new ItemStack(id, 1, 3));
        list.add(new ItemStack(id, 1, 4));
        
    }
    

}



    