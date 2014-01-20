package Mod.Block;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import Mod.Lib.Refrence;
import Mod.Main.Main;
import Mod.TileEntity.TileEntityBox;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModBlockBox extends BlockContainer{

	public Icon TopIcon;
	public Icon SideIcon;
	
	public ModBlockBox(int par1) {
		super(par1, Material.wood);
		this.setStepSound(soundWoodFootstep);
		this.setUnlocalizedName("Box");
		this.setHardness(0.5F);
	}
	
    public int quantityDropped(Random par1Random)
    {
        return 0;
    }
	
	
	   @SideOnly(Side.CLIENT)
	   public void registerIcons(IconRegister par1IconRegister)
	   {
		   this.blockIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "Box");
		   this.TopIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "BoxTop");
		   this.SideIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "BoxSide");
		   
	   }
	   
	    public Icon getIcon(int par1, int par2)
	    {
	        return par1 == 1 ? TopIcon : (par1 == 0 ? this.blockIcon : (par1 != 2 && par1 != 4 ? this.SideIcon : SideIcon) );
	    }


		@Override
		public TileEntity createNewTileEntity(World world) {
			return new TileEntityBox();
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

	    	TileEntity tile_e = World.getBlockTileEntity(x, y, z);
	    	
	    	if(tile_e != null && tile_e instanceof TileEntityBox){
	    		TileEntityBox tile = (TileEntityBox)tile_e;
	    	
	    		ItemStack stack = new ItemStack(ModBlocks.Box);
	    		
	    		stack.setTagCompound(new NBTTagCompound());

	
	    			NBTTagList Items = new NBTTagList();
    		

	        		for (int i = 0; i < tile.getSizeInventory(); i++){
	        			
	        			ItemStack stack1 = tile.getStackInSlot(i);
	        			if(stack1 != null){
	        				
	        				NBTTagCompound item = new NBTTagCompound();
	        				item.setByte("Slot", (byte)i);
	        				stack1.writeToNBT(item);
	        				Items.appendTag(item);
	        			}
	        		}

    		
    				stack.stackTagCompound.setTag("Items", Items);
    		
	    	
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
