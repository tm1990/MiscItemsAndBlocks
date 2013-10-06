package Mod.Block;

import cpw.mods.fml.common.network.FMLNetworkHandler;
import Mod.Items.ModItemKey;
import Mod.Items.ModItems;
import Mod.Main.Main;
import Mod.TileEntity.TileEntityLockableChest;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ModBlockLockableChest extends BlockContainer{

	public ModBlockLockableChest(int par1) {
		super(par1, Material.iron);
        this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
        this.setHardness(1);
        
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityLockableChest();
	}
	
	  
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("iron_block");
    }
	
	  int i = 0;
	  
	  @Override
	    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	    {
		  
		  if(i == 1){
			  i = 0;
	    	TileEntityLockableChest tile;
	    	
	    	if(world.getBlockTileEntity(x, y, z) instanceof TileEntityLockableChest){
	    		tile = (TileEntityLockableChest)world.getBlockTileEntity(x, y, z);
	    		
    			ItemStack item = player.inventory.getCurrentItem();
    			
    			if(item == null || item.itemID != ModItems.Key.itemID){
    				player.addChatMessage("You require a key to access this chest!");
    				return true;
    			}
	    		
	    		
	    		if(player.inventory.getCurrentItem() != null && player.inventory.getCurrentItem().itemID == ModItems.Key.itemID){
	    			
	    			
	    			
	    			if(!item.hasTagCompound()){
    					player.addChatMessage("The key is invalid!");
    					return false;
    				}
	    			

	    			if(item.hasTagCompound()){
	    				NBTTagCompound Compound = item.getTagCompound().getCompoundTag("ChestData");
	    				
	    				if(Compound.getInteger("LocX") != x || Compound.getInteger("LocY") != y || Compound.getInteger("LocZ") != z){
	    					if(tile.Player == "null")
	    					player.addChatMessage("Chest is not locked!");
	    					else
	    					player.addChatMessage("Wrong key! Chest is locked by: " + tile.Player);
	    					return false;
	    				}
	    			}


	    			
	    			
	    			if(item.hasTagCompound()){
	    				
	    				NBTTagCompound Compound = item.getTagCompound().getCompoundTag("ChestData");
	    				
	    				if(Compound.getInteger("LocX") == x){
		    				if(Compound.getInteger("LocY") == y){
			    				if(Compound.getInteger("LocZ") == z){
			    					
			    					
			    					player.addChatMessage("Opend the chest with the correct key.");
			    					
			    					if(!world.isRemote)
			    			        	FMLNetworkHandler.openGui(player, Main.instance, 0, world, x, y, z);
			    					
			    					
			    					
			    					
			    					
			    				}
		    				}
		    				}
	    			
	    			
	    		      }
	    			}
	    		
	    		
	    		}
	    	
		  
		  

	    }else{
    		i++;
    	}
		  
	    	return true;
	    }
	  
	   public boolean isOpaqueCube()
	    {
	        return false;
	    }


	    public boolean renderAsNormalBlock()
	    {
	        return false;
	    }


	    public int getRenderType()
	    {
	        return -1;
	    }
	    
	    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
	    {
	        byte b0 = 0;
	        int l = MathHelper.floor_double((double)(par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

	        if (l == 0)
	        {
	            b0 = 2;
	        }

	        if (l == 1)
	        {
	            b0 = 5;
	        }

	        if (l == 2)
	        {
	            b0 = 3;
	        }

	        if (l == 3)
	        {
	            b0 = 4;
	        }

	        par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 2);
	    }


	    @Override
	    public void breakBlock(World World, int x, int y, int z, int id, int meta)
	    {
	   
	    }


	    	
			

}
