package Mod.Block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import Mod.TileEntity.TileEntityItemPedestal;
import Mod.TileEntity.TileEntityMiningChamber;

public class ModBlockMiningChamber extends ModBlockPowerMachine{

	protected ModBlockMiningChamber(int par1) {
		super(par1, Material.rock);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityMiningChamber();
	}

	
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("furnace_top");
        
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
