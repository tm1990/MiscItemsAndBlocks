package Mod.Block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import Mod.TileEntity.TileEntityTable;

public class ModBlockTable extends BlockContainer{

	protected ModBlockTable(int par1) {
		super(par1, Material.wood);
		this.setHardness(1F);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityTable();
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
        this.blockIcon = icon.registerIcon("planks_spruce");
}
    
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
    	
    	if(player.inventory.getCurrentItem() != null){
    		//TODO Must change before 1.7
    	if(player.inventory.getCurrentItem().itemID == Block.carpet.blockID){
    		
    		if(world.getBlockMetadata(x, y, z) > 0){
    			return true;
    		}
    		world.setBlockMetadataWithNotify(x, y, z, 1, 2);
            world.playSoundEffect((double)x + 0.5D, (double)y + 0.1D, (double)z + 0.5D, "step.cloth", 0.8F, 0.5F);
    	}else{
    		if(world.getBlockMetadata(x, y, z) >= 1){
    		world.setBlockMetadataWithNotify(x, y, z, 0, 2);
            world.playSoundEffect((double)x + 0.5D, (double)y + 0.1D, (double)z + 0.5D, "step.cloth", 0.8F, 0.7F);
    		}
    	}
    	}else{
    		if(world.getBlockMetadata(x, y, z) >= 1){
    		world.setBlockMetadataWithNotify(x, y, z, 0, 2);
            world.playSoundEffect((double)x + 0.5D, (double)y + 0.1D, (double)z + 0.5D, "step.cloth", 0.8F, 0.7F);
    		}
    	}
    	
    	return true;
    }
}
