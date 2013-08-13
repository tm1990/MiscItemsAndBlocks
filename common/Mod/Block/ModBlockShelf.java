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
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class ModBlockShelf extends BlockContainer{

	
	protected ModBlockShelf(int par1) {
		super(par1, Material.wood);
		setUnlocalizedName("Shelf");
		
        this.setBlockBounds(0F, 0.0F, 0F, 1F, 0.68F, 0.55F);
		
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
	    
	    


    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess access, int i, int j, int k)
    {
     int dir = access.getBlockMetadata(i, j, k);

    if(dir == 0)
   {
        this.setBlockBounds(0F, 0.0F, 0F, 1F, 0.68F, 0.55F);
    }
    else if(dir == 1)
    {
        this.setBlockBounds(0F, 0.0F, 0F, 1F, 0.68F, 0.55F);
    }
    else if(dir == 2)
      {
        this.setBlockBounds(0F, 0.0F, 0F, 1F, 0.68F, 0.55F);
     }
     else if(dir == 3)
     {
        this.setBlockBounds(0F, 0.0F, 0F, 1F, 0.68F, 0.55F);
}
}



@Override
public boolean canPlaceBlockOnSide(World world, int i, int j, int k, int side)
{
if(this.canPlaceBlockAt(world, i, j, k))
{
if(side == 5 && world.isBlockNormalCube(i-1, j, k)) {
return true;
}
if(side == 4 && world.isBlockNormalCube(i+1, j, k)) {
return true;
}
if(side == 2 && world.isBlockNormalCube(i, j, k+1)) {
return true;
}
if(side == 3 && world.isBlockNormalCube(i, j, k-1)) {
return true;
}
}
return false;
}


public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
{
    boolean flag = false;
    
    {
        int i1 = par1World.getBlockMetadata(par2, par3, par4);
        flag = true;

        if (i1 == 2 && par1World.getBlockMaterial(par2, par3, par4 + 1).isSolid())
        {
            flag = false;
        }

        if (i1 == 3 && par1World.getBlockMaterial(par2, par3, par4 - 1).isSolid())
        {
            flag = false;
        }

        if (i1 == 4 && par1World.getBlockMaterial(par2 + 1, par3, par4).isSolid())
        {
            flag = false;
        }

        if (i1 == 5 && par1World.getBlockMaterial(par2 - 1, par3, par4).isSolid())
        {
            flag = false;
        }
    }

    if (flag)
    {
        this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
        par1World.setBlockToAir(par2, par3, par4);
    }

    super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
}


public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
{
    return null;
}



public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
{
    this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
    return super.getSelectedBoundingBoxFromPool(par1World, par2, par3, par4);

}

          
  
@Override
public void breakBlock(World World, int x, int y, int z, int id, int meta)
{
	TileEntity tile = World.getBlockTileEntity(x, y, z);
	
	if(tile != null && tile instanceof IInventory){
		IInventory inv = (IInventory)tile;
		
		for(int i = 0; i < inv.getSizeInventory(); i++){
			ItemStack stack = inv.getStackInSlotOnClosing(i);
			
			if(stack != null){
				float spawnX = x + World.rand.nextFloat();
				float spawnY = y + World.rand.nextFloat();
				float spawnZ = z + World.rand.nextFloat();
				
				
				EntityItem droppedItem = new EntityItem(World, spawnX, spawnY, spawnZ, stack);
				
				float mult = 0.05F;
				
				droppedItem.motionX = (-0.5 + World.rand.nextFloat()) * mult;
				droppedItem.motionY = (4 + World.rand.nextFloat()) * mult;
				droppedItem.motionZ = (-0.5 + World.rand.nextFloat()) * mult;
				
				
				World.spawnEntityInWorld(droppedItem);
				
			}
			
		}
	}
}


}
