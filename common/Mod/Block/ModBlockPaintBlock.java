package Mod.Block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import Mod.Items.ModItems;
import Mod.Lib.Refrence;
import Mod.TileEntity.TileEntityPaintBlock;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModBlockPaintBlock extends BlockContainer{

    private int layer = 0;
    private int renderSide = 0;
	
	protected ModBlockPaintBlock(int par1) {
		super(par1, Material.cloth);
		this.setStepSound(soundClothFootstep);
		this.setHardness(1);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityPaintBlock();
	}
	
	   @SideOnly(Side.CLIENT)
	   public void registerIcons(IconRegister par1IconRegister)
	   {
		   this.blockIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":PaintBlock");
		   
	   }
	   

	   
	   
	    public int colorMultiplier(IBlockAccess block, int x, int y, int z)
	    {
	    	//(Red)(Red)(Green)(Green)(Blue)(Blue)
	    	//0xrrggbb
	    	// Defualt : 0xFFFFFF
	    	
	    	TileEntity tile_e = block.getBlockTileEntity(x, y, z);
	    	
	    	if(tile_e instanceof TileEntityPaintBlock){
	    		TileEntityPaintBlock tile = (TileEntityPaintBlock)tile_e;
	    		
	    		if(tile.GetRed() == 0 && tile.GetBlue() == 0 && tile.GetGreen() == 0){

	    		}else{
	    			return tile.GetHex();
	    		}
	    	}
	    	return 0xFFFFFF;
	    	
	    }
	    
	    

	    @Override
	    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	    {

	    	world.markBlockForRenderUpdate(x, y, z);

	    	return false;
	    }





	    

	    


}
