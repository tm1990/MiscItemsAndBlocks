package Mod.Block;

import java.util.Random;

import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import Mod.Items.ModItems;
import Mod.Lib.Refrence;
import Mod.Main.ModConfig;
import Mod.Main.Main;
import Mod.TileEntity.TileEntityShelf;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
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
		
		setCreativeTab(Main.CreativeTab);
		

        

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
	        this.blockIcon = icon.registerIcon(Refrence.Mod_Id + ":Shelf");
	}
	    
	    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	    {
	        if (par1World.isRemote)
	        {
	        	
	            return true;
	        }
	        else
	        {
	        	
	        	
	        	FMLNetworkHandler.openGui(par5EntityPlayer, Main.instance, 0, par1World, par2, par3, par4);
	            return true;
	        }
	    }
	    
	    


    
	    @Override
	    public void setBlockBoundsBasedOnState(IBlockAccess access, int i, int j, int k)
	    {
	     int dir = access.getBlockMetadata(i, j, k);

	    if(dir == 1)
	   {
	        this.setBlockBounds(0F, 0.0F, 0.5F, 1F, 0.68F, 1F);
	    }
	    else if(dir == 2)
	    {
	        this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.6F, 0.68F, 1F);
	    }
	    else if(dir == 3)
	      {
	        this.setBlockBounds(0F, 0.0F, 0F, 1F, 0.68F, 0.6F);
	     }
	     else if(dir == 4)
	     {
	    	 
	        this.setBlockBounds(0.4F, 0.0F, 0F, 1F, 0.68F, 1F);
	}
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

public void onBlockPlacedBy(World par1World, int x, int y, int z, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
{
    int Direction = MathHelper.floor_double((double)(par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

    if (Direction == 0)
    {
    	
        par1World.setBlockMetadataWithNotify(x, y, z, 1, 2);
    }

    if (Direction == 1)
    {
        par1World.setBlockMetadataWithNotify(x, y, z, 2, 2);
    }

    if (Direction == 2)
    {
        par1World.setBlockMetadataWithNotify(x, y, z, 3, 2);
    }

    if (Direction == 3)
    {
        par1World.setBlockMetadataWithNotify(x, y, z, 4, 2);
    }


}

@Override
public int onBlockPlaced(World world, int x, int y, int z, int side, float hitx, float hity, float hitz, int meta)
{
	
	return 0;
	
}

public boolean canPlaceBlockAt(World world, int x, int y, int z){
	
    int Direction = MathHelper.floor_double((double)(Minecraft.getMinecraft().thePlayer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
	
    if(Direction == 0){
    	
    	if(world.doesBlockHaveSolidTopSurface(x, y, z + 1)){
    		return true;
    	}
    }
    
    if(Direction == 1){
    	
    	if(world.doesBlockHaveSolidTopSurface(x - 1, y, z)){
    		return true;
    	}
    }
    
    if(Direction == 2){
    	
    	if(world.doesBlockHaveSolidTopSurface(x, y, z - 1)){
    		return true;
    	}
    }
    
    if(Direction == 3){
    	
    	if(world.doesBlockHaveSolidTopSurface(x + 1, y, z)){
    		return true;
    	}
    }
    
	return false;
}



}
