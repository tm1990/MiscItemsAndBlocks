package Mod.Block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import Mod.Lib.Refrence;
import Mod.TileEntity.TileEntityPowerCable;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ModBlockPowerCable extends BlockContainer{

	protected ModBlockPowerCable(int par1) {
		super(par1, Material.iron);
		this.setHardness(2);
		 this.setBlockBounds(0.23F, 0.23F, 0.23F, 0.75F, 0.75F, 0.75F);
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

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityPowerCable();
	}

    	
	
	  @SideOnly(Side.CLIENT)
	   public void registerIcons(IconRegister par1IconRegister)
	   {
		   this.blockIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "PowerCable");
		   
	   }
    }
    	


