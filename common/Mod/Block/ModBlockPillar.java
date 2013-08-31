package Mod.Block;

import Mod.TileEntity.TileEntityPillar;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ModBlockPillar extends BlockContainer {

	protected ModBlockPillar(int par1) {
		super(par1, Material.rock);
		this.setHardness(1F);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityPillar();
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
}
