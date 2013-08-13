package Mod.Block;

import cpw.mods.fml.common.network.FMLNetworkHandler;
import Mod.Lib.Refrence;
import Mod.Main.Config;
import Mod.Main.Main;
import Mod.TileEntity.TileEntityShelf;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class ModBlockShelf extends BlockContainer{

	protected ModBlockShelf(int par1) {
		super(par1, Material.wood);
		setUnlocalizedName("Shelf");
		
		
        this.setBlockBounds(0F, 0.0F, 0F, 1F, 0.68F, 0.5F);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityShelf();
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
	        this.blockIcon = icon.registerIcon(Refrence.Mod_Name + ":Shelf");
	}
	    
	    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	    {
	        if (par1World.isRemote)
	        {
	            return true;
	        }
	        else
	        {
	        	
	        	
	        	FMLNetworkHandler.openGui(par5EntityPlayer, Main.instance, Config.ShelfGuiId, par1World, par2, par3, par4);
	            return true;
	        }
	    }
	    

	    


}
