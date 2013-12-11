package Mod.Block;

import Mod.Lib.Refrence;
import Mod.Main.Main;
import Mod.TileEntity.TileEntityCharger;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class ModBlockCharger extends BlockContainer{

	public Icon InIcon;
	public Icon OutIcon;
	
	
	public ModBlockCharger(int par1) {
		super(par1, Material.iron);
		this.setHardness(3);
	}
	
	   @SideOnly(Side.CLIENT)
	   public void registerIcons(IconRegister par1IconRegister)
	   {
		   this.InIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "ChargerSideIn");
		   this.OutIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "ChargerSideOut");
		   
	   }
	   
	    public Icon getIcon(int par1, int par2)
	    {
	        return par1 == 1 ? InIcon : (par1 == 0 ? OutIcon : (par1 != 2 && par1 != 4 ? InIcon : InIcon) );
	    }

		@Override
		public TileEntity createNewTileEntity(World world) {
			return new TileEntityCharger();
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
			super.breakBlock(World, x, y, z, id, meta);
	    }

}
