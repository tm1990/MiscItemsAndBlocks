package Mod.Block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import Mod.Lib.Refrence;
import Mod.Main.Main;
import Mod.TileEntity.TileEntityXpStorage;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModBlockXpStorage extends BlockContainer{

	public ModBlockXpStorage(int par1) {
		super(par1, Material.iron);
		
		setCreativeTab(Main.CreativeTab);
		setUnlocalizedName("BlockXpStorage");
		this.setHardness(7);
		this.setResistance(100000000);

	}
	
	   @SideOnly(Side.CLIENT)
	   public void registerIcons(IconRegister par1IconRegister)
	   {
		   this.blockIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "XpStorage");
		   
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
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityXpStorage();
	}
	
	   @Override
	    public void breakBlock(World World, int x, int y, int z, int id, int meta)
	    {

	    	TileEntity tile_e = World.getBlockTileEntity(x, y, z);
	    	
	    	if(tile_e != null && tile_e instanceof TileEntityXpStorage){
	    		TileEntityXpStorage tile = (TileEntityXpStorage)tile_e;
	    	
	    		ItemStack stack = new ItemStack(ModBlocks.XpStorage);
	    		
	    		if(tile.XpAmount > 0){
	    		stack.setTagCompound(new NBTTagCompound());
	    		
	    		stack.stackTagCompound.setInteger("Levels", tile.XpAmount);
	    		}
   		
	    		
	    	
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
   				super.breakBlock(World, x, y, z, id, meta);
   			}
   				
   				
	    }

}
}
