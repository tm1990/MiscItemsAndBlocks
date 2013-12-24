package Mod.Items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import Mod.Block.ModBlocks;
import Mod.Lib.Refrence;
import Mod.LibMisc.BlockUtil;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class ModItemHeatDrill extends ModItemPowerTool{

	private static Block[] MineableBlocks = new Block[]{Block.stone, Block.dirt, Block.gravel, Block.sand, Block.oreCoal, Block.oreDiamond, Block.oreEmerald, Block.oreGold, Block.oreIron, Block.oreLapis, Block.oreNetherQuartz, Block.oreRedstone, Block.oreRedstoneGlowing, Block.grass, ModBlocks.SilverOre, Block.obsidian, Block.cobblestone, Block.stoneDoubleSlab, Block.stoneSingleSlab, Block.stone, Block.sandStone, Block.cobblestoneMossy, Block.oreIron, Block.oreCoal, Block.blockGold, Block.oreGold, Block.oreDiamond, Block.blockDiamond, Block.ice, Block.netherrack, Block.oreLapis, Block.blockLapis, Block.oreRedstone, Block.oreRedstoneGlowing, Block.rail, Block.railDetector, Block.railPowered, Block.planks, Block.bookShelf, Block.wood, Block.chest, Block.stoneDoubleSlab, Block.stoneSingleSlab, Block.pumpkin, Block.pumpkinLantern, Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay, Block.tilledField, Block.slowSand, Block.mycelium,};
	
	
	public ModItemHeatDrill(int par1) {
		super(par1, 0.1F, EnumToolMaterial.EMERALD, MineableBlocks);
		
		this.damageVsEntity = 0;
		this.efficiencyOnProperMaterial = 8;
		this.setMaxDamage(930);
	}
	
	
    public boolean canHarvestBlock(Block par1Block)
    {
        return par1Block == Block.obsidian ? this.toolMaterial.getHarvestLevel() == 3 : (par1Block != Block.blockDiamond && par1Block != Block.oreDiamond ? (par1Block != Block.oreEmerald && par1Block != Block.blockEmerald ? (par1Block != Block.blockGold && par1Block != Block.oreGold ? (par1Block != Block.oreIron ? (par1Block != Block.blockLapis && par1Block != Block.oreLapis ? (par1Block != Block.oreRedstone && par1Block != Block.oreRedstoneGlowing ? (par1Block.blockMaterial == Material.rock ? true : (par1Block.blockMaterial == Material.iron ? true : par1Block.blockMaterial == Material.anvil)) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 2);
    }

	
    @Override
    public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
    {
    	if(par1ItemStack.getItemDamage() == par1ItemStack.getMaxDamage())
    		return 0;
    	
        return par2Block != null && (par2Block.blockMaterial == Material.iron || par2Block.blockMaterial == Material.anvil || par2Block.blockMaterial == Material.rock || par2Block.blockMaterial == Material.wood || par2Block.blockMaterial == Material.plants || par2Block.blockMaterial == Material.vine) ? this.efficiencyOnProperMaterial : super.getStrVsBlock(par1ItemStack, par2Block);
    }
    
    public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, int par3, int par4, int par5, int par6, EntityLivingBase par7EntityLivingBase)
    {
    	
            par1ItemStack.damageItem(1, par7EntityLivingBase);

        return true;
    }
    
    
	public boolean onBlockStartBreak(ItemStack itemstack, int x, int y, int z, EntityPlayer player)
    {
		
		if(!player.worldObj.isRemote){
    	int Luck = EnchantmentHelper.getEnchantmentLevel(35, player.inventory.getCurrentItem());
		
		
		int BlockId = player.worldObj.getBlockId(x, y, z);
		Block block = Block.blocksList[BlockId];
		
		if(block != null){
			
	        List<ItemStack> stacks = block.getBlockDropped(player.worldObj, x, y, z, player.worldObj.getBlockMetadata(x, y, z), Luck);

	        if (stacks != null) {
	                for (ItemStack s : stacks) {
	                        if (s != null) {

	                        	Smelt(s, x, y, z, player.worldObj, player);
	                        
	                        }
	                }
	       }
		}
		
		 player.worldObj.destroyBlock(x, y, z, false);
		this.onBlockDestroyed(itemstack,  player.worldObj, BlockId, x, y, z, player);
		}
		return true;
    }
    
    
	   @SideOnly(Side.CLIENT)
	   public void registerIcons(IconRegister par1IconRegister)
	   {
		   this.itemIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":HeatDrill");
		   
	   }
	   
	   @Override
	    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
	    {
	    	int i = itemstack.getMaxDamage() - itemstack.getItemDamage();
	    	

	            list.add("Power left: " + i);
	            if(itemstack.getItemDamage() == itemstack.getMaxDamage())
	            	list.add(EnumChatFormatting.RED + "Out of power recharge!");

	            
	    }
	   
	public void Smelt(ItemStack stack, int x, int y, int z, World world, EntityPlayer player){

			ItemStack result = FurnaceRecipes.smelting().getSmeltingResult(stack);
			if(result != null){
				ItemStack smeltingStack;
				if(result.stackSize > 1){
					   smeltingStack = new ItemStack(result.getItem(), result.stackSize, result.getItemDamage());
				}else{
			   smeltingStack = new ItemStack(result.getItem(), 1, result.getItemDamage());
				}
				
				EntityItem item = new EntityItem(world, x, y, z, smeltingStack);
				world.spawnEntityInWorld(item);
			}else{

				EntityItem item = new EntityItem(world, x, y, z, stack);
				world.spawnEntityInWorld(item);

				
			

			}
	   }
	   
	    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10)
	    {
	    	int Luck = EnchantmentHelper.getEnchantmentLevel(35, player.inventory.getCurrentItem());
	    	
	    	int BlockId = world.getBlockId(x, y, z);
	    	Block block = Block.blocksList[BlockId];
	    	
	    	if(block != null){
	    		
		        List<ItemStack> stacks = block.getBlockDropped(player.worldObj, x, y, z, player.worldObj.getBlockMetadata(x, y, z), Luck);
		        
		        ItemStack stack1 = new ItemStack(block);
    			ItemStack result1 = FurnaceRecipes.smelting().getSmeltingResult(stack1);

		        if (stacks != null) {
		                for (ItemStack s : stacks) {
		                        if (s != null) {
		                        	
	                    			ItemStack result = FurnaceRecipes.smelting().getSmeltingResult(s);
	                    			if(result != null){

		                        	
		                        	if(result.itemID < 256 || result.itemID > 421 && result.itemID < 4096){


		                    				
		                    				world.setBlock(x, y, z, result.itemID);
		                    				player.inventory.getCurrentItem().damageItem(1, player);
		                    				
		                    			}
		                        
		                        
	                    			}else{
	                    				if(result1 != null){
	    		                        	if(result1.itemID < 256 || result1.itemID > 421 && result1.itemID < 4096){


			                    				
			                    				world.setBlock(x, y, z, result1.itemID);
			                    				player.inventory.getCurrentItem().damageItem(1, player);
			                    				
			                    			}
	                    				}
	                    				
	                    			}
		                        }
		                }
		       }
			}
	    		
	    	
	    	
	    	
	        return true;
	    }

}
