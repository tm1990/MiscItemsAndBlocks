package Mod.Items;

import java.util.List;

import Mod.Block.ModBlocks;
import Mod.Lib.Refrence;
import Mod.TileEntity.TileEntityLockableChest;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ModItemKey extends ItemTool{

	public ModItemKey(int par1) {
		super(par1, 0, EnumToolMaterial.IRON, new Block[]{ModBlocks.LockableChest});
		this.efficiencyOnProperMaterial = 8;
		this.setMaxStackSize(1);
		this.setMaxDamage(0);
	}
	
	   @SideOnly(Side.CLIENT)
	   public void registerIcons(IconRegister par1IconRegister)
	   {
		   this.itemIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":Key");

	   }
	   
	    @Override
	    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
	    {
	    	list.add("Can be used to open locked chests");
	    	
	    	if(itemstack.hasTagCompound()){
	    		
		        NBTTagCompound Compound = itemstack.getTagCompound().getCompoundTag("ChestData");
		        
		        list.add("Chest x: " + Compound.getInteger("LocX"));
		        list.add("Chest y: " + Compound.getInteger("LocY"));
		        list.add("Chest z: " + Compound.getInteger("LocZ"));
		        
		        list.add("Owner: " + Compound.getString("Owner"));
		        
		        
	    	}else{
	    		list.add("Key not linked!");
	    	}
	    	
	    }
	    
	    public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10)
	    {
	    	if(player.isSneaking()){
	    		
	    		
		        NBTTagCompound stackCompound = item.hasTagCompound() ? item.getTagCompound() : new NBTTagCompound();
		        NBTTagCompound compound = new NBTTagCompound();
	    		
		    	TileEntityLockableChest tile;
		    	
		    	if(world.getBlockTileEntity(x, y, z) instanceof TileEntityLockableChest){
		    		tile = (TileEntityLockableChest)world.getBlockTileEntity(x, y, z);
		    		
		    		if(!item.hasTagCompound()){
		    		if(!tile.IsLocked){
		    			tile.SetX(x);
		    			tile.SetY(y);
		    			tile.SetZ(z);
		    			
		    			tile.Player = player.username;
		    			
		    			compound.setInteger("LocX", x);
		    			compound.setInteger("LocY", y);
		    			compound.setInteger("LocZ", z);
		    			
		    			compound.setString("Owner", player.username);
		    			
			            stackCompound.setCompoundTag("ChestData", compound);
			            item.setTagCompound(stackCompound);
		    			
		    		}else{
		    			if(world.isRemote)
		    			player.addChatMessage("Chest already locked!");
		    		}
		    		}else{
		    			if(world.isRemote)
		    				player.addChatMessage("Key is already linked to a chest!");
		    		}
		    		
		    	}
		    	

	    		
	    	}
	    	
	    	
	        return true;
	    }
	    
	
		
	    public boolean canHarvestBlock(Block block)
	    {
	        return block == ModBlocks.LockableChest;
	    }

		
	    @Override
	    public float getStrVsBlock(ItemStack item, Block block)
	    {

	    	
	    	return block == ModBlocks.LockableChest ? 10 : 0;
}
	    
	    @Override
	    public boolean onBlockDestroyed(ItemStack item, World world, int x, int y, int z, int meta, EntityLivingBase Living)
	    {
	    	
	    	if(!world.isRemote){
	    	TileEntityLockableChest tile;
	    	
	    	if(world.getBlockTileEntity(x, y, z) instanceof TileEntityLockableChest){
	    		tile = (TileEntityLockableChest)world.getBlockTileEntity(x, y, z);
	    		
	    		
	    		
    			if(item.hasTagCompound()){
    				
    				NBTTagCompound Compound = item.getTagCompound().getCompoundTag("ChestData");
    				
    				if(Compound.getInteger("LocX") == x){
	    				if(Compound.getInteger("LocY") == y){
		    				if(Compound.getInteger("LocZ") == z){
		    					
		    					
		    				 	TileEntity tilee = world.getBlockTileEntity(x, y, z);
		    			    	
		    			    	if(tilee != null && tilee instanceof IInventory){
		    			    		IInventory inv = (IInventory)tilee;
		    			    		
		    			    		for(int i = 0; i < inv.getSizeInventory(); i++){
		    			    			ItemStack stack = inv.getStackInSlotOnClosing(i);
		    			    			
		    			    			if(stack != null){
		    			    				float spawnX = x + world.rand.nextFloat();
		    			    				float spawnY = y + world.rand.nextFloat();
		    			    				float spawnZ = z + world.rand.nextFloat();
		    			    				
		    			    				
		    			    				EntityItem droppedItem = new EntityItem(world, spawnX, spawnY, spawnZ, stack);
		    			    				
		    			    				float mult = 0.05F;
		    			    				
		    			    				droppedItem.motionX = (-0.5 + world.rand.nextFloat()) * mult;
		    			    				droppedItem.motionY = (4 + world.rand.nextFloat()) * mult;
		    			    				droppedItem.motionZ = (-0.5 + world.rand.nextFloat()) * mult;
		    			    				
		    			    				
		    			    				world.spawnEntityInWorld(droppedItem);
		    			    				
		    			    			}
		    			    			
		    			    		}
		    			    	}
		    					
		    					return true;
		    					
		    					
		    					
		    					
		    				}
	    				}
    				}
    			}
		    				}
	    		
	    	}
	    	
	    	
	    	

	        return false;
	    }
	    
	    
	
	    
	    

}
