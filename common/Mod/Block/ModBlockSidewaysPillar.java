package Mod.Block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import Mod.TileEntity.TileEntityPillar;
import Mod.TileEntity.TileEntitySidewaysPillar;

public class ModBlockSidewaysPillar extends BlockContainer {

	protected ModBlockSidewaysPillar(int par1) {
		super(par1, Material.rock);
		this.setHardness(1F);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntitySidewaysPillar();
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
	
    public void setBlockBoundsBasedOnState(IBlockAccess block, int x, int y, int z) {
    	
		 int Id = block.getBlockId(x, y, z);
    	
    	
		 if(block.getBlockId(x, y, z + 1) == Id && block.getBlockId(x, y, z - 1) == Id){
				this.setBlockBounds(0.2F, 0.012F, 0F, 0.8F, 0.63F, 1F);
		 }else{
				this.setBlockBounds(0.13F, 0.012F, 0F, 0.9F, 0.8F, 1F);
		 }
    	
    }
}
