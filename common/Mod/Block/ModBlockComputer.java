package Mod.Block;

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
import Mod.Gui.GuiHandler;
import Mod.Main.Main;
import Mod.TileEntity.TileEntityComputer;

public class ModBlockComputer extends BlockContainer{

	protected ModBlockComputer(int par1) {
		super(par1, Material.iron);
		this.setHardness(1);
		this.setBlockBounds(0, 0, 0, 1, 0.84F, 1);

	}
	
   


	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityComputer();
	}
	
	   public boolean onBlockActivated(World world, int par2, int par3, int par4, EntityPlayer player, int par6, float par7, float par8, float par9)
	    {
			player.openGui(Main.instance, GuiHandler.ComputerID, world, par2, par3, par4);
			
			return true;
	    }

	   
	    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
	    {

	    	return par1World.isBlockSolidOnSide(par2, par3 - 1, par4, ForgeDirection.UP);
	    }
	   
	    public void registerIcons(IconRegister icon) {
	        this.blockIcon = icon.registerIcon("stone");
	}
	   
		public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
		{
		   return false;
		}

		public boolean isOpaqueCube()
		{
		   return false;
		}

		  private void setDefaultDirection(World par1World, int par2, int par3, int par4)
		    {
		        if (!par1World.isRemote)
		        {
		            int l = par1World.getBlockId(par2, par3, par4 - 1);
		            int i1 = par1World.getBlockId(par2, par3, par4 + 1);
		            int j1 = par1World.getBlockId(par2 - 1, par3, par4);
		            int k1 = par1World.getBlockId(par2 + 1, par3, par4);
		            byte b0 = 3;

		            if (Block.opaqueCubeLookup[l] && !Block.opaqueCubeLookup[i1])
		            {
		                b0 = 3;
		            }

		            if (Block.opaqueCubeLookup[i1] && !Block.opaqueCubeLookup[l])
		            {
		                b0 = 2;
		            }

		            if (Block.opaqueCubeLookup[j1] && !Block.opaqueCubeLookup[k1])
		            {
		                b0 = 5;
		            }

		            if (Block.opaqueCubeLookup[k1] && !Block.opaqueCubeLookup[j1])
		            {
		                b0 = 4;
		            }

		            par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 2);
		        }
		    }
		  
		    public void onBlockAdded(World par1World, int par2, int par3, int par4)
		    {
		        super.onBlockAdded(par1World, par2, par3, par4);
		        this.setDefaultDirection(par1World, par2, par3, par4);
		    }
		
	    @Override
	    public int getRenderType() {
	            return -1;
	    }
	    
	    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
	    {
	        int l = MathHelper.floor_double((double)(par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

	        if (l == 0)
	        {
	            par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
	        }

	        if (l == 1)
	        {
	            par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
	        }

	        if (l == 2)
	        {
	            par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
	        }

	        if (l == 3)
	        {
	            par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
	        }

	    }


}
