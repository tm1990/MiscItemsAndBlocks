package Mod.Block;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import Mod.Lib.Refrence;
import Mod.TileEntity.TileEntityDiceHolder;

public class ModBlockDiceHolder extends BlockContainer{

	protected ModBlockDiceHolder(int par1) {
		super(par1, Material.rock);
		this.setHardness(1);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityDiceHolder();
	}

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
    
    	
    	Random rand = new Random();
    	
    	if(!world.isRemote)
    	world.setBlockMetadataWithNotify(x, y, z, rand.nextInt(7), 2);
    	
        return true;
    }
	 
		public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
		{
		   return false;
		}

		public boolean isOpaqueCube()
		{
		   return false;
		}


		
	    @Override
	    public int getRenderType() {
	            return -1;
	    }
	    
	    public boolean renderAsNormalBlock() {
	        return false;
	}
	    
	    public void registerIcons(IconRegister icon) {
	        this.blockIcon = icon.registerIcon("furnace_top");
	}
}
