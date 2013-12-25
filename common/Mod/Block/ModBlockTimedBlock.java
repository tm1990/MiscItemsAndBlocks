package Mod.Block;

import Mod.Lib.Refrence;
import Mod.TileEntity.TileEntityTimedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ModBlockTimedBlock extends BlockContainer{

	public ModBlockTimedBlock(int par1) {
		super(par1, Material.glass);
		this.setHardness(-1);
		this.setTextureName(Refrence.Mod_Id + ":TimedBlock");
	}
	
    public boolean isOpaqueCube()
    {
        return false;
    }

	@Override
	public TileEntity createNewTileEntity(World world) {
		
		return new TileEntityTimedBlock();
	}
	
    public int getRenderBlockPass()
    {
        return 1;
    }
    

   public boolean renderAsNormalBlock()
   {
       return false;
   }
	
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
    	return false;
    }

   
   public int idPicked(World par1World, int par2, int par3, int par4)
   {
       return 0;
   }
   
   
}
