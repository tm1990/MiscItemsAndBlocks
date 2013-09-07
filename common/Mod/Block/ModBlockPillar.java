package Mod.Block;

import Mod.Lib.Refrence;
import Mod.TileEntity.TileEntityPillar;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
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
	
    public void setBlockBoundsBasedOnState(IBlockAccess block, int x, int y, int z) {
    	
		 int Id = block.getBlockId(x, y, z);
    	
    	
		 if(block.getBlockId(x, y + 1, z) == Id && block.getBlockId(x, y - 1, z) == Id){
				this.setBlockBounds(0.2F, 0, 0.2F, 0.8F, 1, 0.8F);
		 }else{
				this.setBlockBounds(0.1F, 0, 0.1F, 0.9F, 1, 0.9F);
		 }
    	
    }
    
    public void registerIcons(IconRegister par1IconRegister)
    {
    	
        this.blockIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "Pillar");
        
    }
}
