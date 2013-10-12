package Mod.Block;

import Mod.Lib.Refrence;
import Mod.TileEntity.TileEntityItemPedestal;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ModBlockItemPedestal extends BlockContainer{

	public ModBlockItemPedestal(int par1) {
		super(par1, Material.rock);
		this.setBlockBounds(0F, 0F, 0F, 1F, 1.7F, 1F);
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
		return new TileEntityItemPedestal();
	}
	
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("furnace_top");
        
    }
    
	  @Override
	    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	    {
	        if (player.isSneaking())
	            return false;
	        TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
	        
	        
	        if(tile_entity instanceof TileEntityItemPedestal){
		  
		  TileEntityItemPedestal tile = (TileEntityItemPedestal)tile_entity;
			  
			  if(player.inventory.getCurrentItem() == null){
				  if(tile.getStackInSlot(0) != null){

					 player.inventory.addItemStackToInventory(tile.getStackInSlot(0));
	    				tile.setInventorySlotContents(0, null);
					  return true;
				  }

			  }else if (player.inventory.getCurrentItem() != null){
				  if(tile.getStackInSlot(0) == null){
					  
					  if(player.inventory.getCurrentItem().hasTagCompound()){
						  ItemStack stack = new ItemStack(player.inventory.getCurrentItem().getItem(), 1, player.inventory.getCurrentItem().getItemDamage());
						  stack.setTagCompound(player.inventory.getCurrentItem().getTagCompound());
						  tile.setInventorySlotContents(0, stack);
					  }else{
					  tile.setInventorySlotContents(0, new ItemStack(player.inventory.getCurrentItem().getItem(), 1, player.inventory.getCurrentItem().getItemDamage()));
					  }
					  player.inventory.consumeInventoryItem(player.inventory.getCurrentItem().itemID);
					  return true;
					  
				  
			  
			  
			  
			  
		  }
	        }

		  }
		  
		  
		  return true;
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
	    				super.breakBlock(World, x, y, z, id, meta);
	    			}
	    			
	    		}
	    	}
	    }

}
