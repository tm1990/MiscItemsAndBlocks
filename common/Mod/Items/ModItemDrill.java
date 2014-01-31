package Mod.Items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import Mod.Block.ModBlocks;
import Mod.Lib.Refrence;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModItemDrill extends ModItemPowerTool{

	int MaxCharge = 750;
	int RechargAmount = 10;
	
	Icon Drill;
	Icon DrillGreen;
	Icon DrillYellow;
	Icon DrillOrange;
	Icon DrillRed;
	
	private boolean Mode3 = false;
	
	private static Block[] MineableBlocks = new Block[]{Block.stone, Block.dirt, Block.gravel, Block.sand, Block.oreCoal, Block.oreDiamond, Block.oreEmerald, Block.oreGold, Block.oreIron, Block.oreLapis, Block.oreNetherQuartz, Block.oreRedstone, Block.oreRedstoneGlowing, Block.grass, ModBlocks.SilverOre, Block.obsidian, Block.cobblestone, Block.stoneDoubleSlab, Block.stoneSingleSlab, Block.stone, Block.sandStone, Block.cobblestoneMossy, Block.oreIron, Block.oreCoal, Block.blockGold, Block.oreGold, Block.oreDiamond, Block.blockDiamond, Block.ice, Block.netherrack, Block.oreLapis, Block.blockLapis, Block.oreRedstone, Block.oreRedstoneGlowing, Block.rail, Block.railDetector, Block.railPowered, Block.planks, Block.bookShelf, Block.wood, Block.chest, Block.stoneDoubleSlab, Block.stoneSingleSlab, Block.pumpkin, Block.pumpkinLantern, Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay, Block.tilledField, Block.slowSand, Block.mycelium,};
	
	protected ModItemDrill(int par1, EnumToolMaterial par2) {
		super(par1, 0, par2, MineableBlocks);
		this.setMaxStackSize(1);
		this.setMaxDamage(MaxCharge);
		this.efficiencyOnProperMaterial = 8;
		this.damageVsEntity = 0;
	}
	
	
	@Override
    public Icon getIconFromDamage(int Damage)
    {

    	if(Damage < MaxCharge / 4){
    		return DrillGreen;
    	}
    	
    	if(Damage < MaxCharge / 4 * 2 && Damage > MaxCharge / 4){
    		return DrillYellow;
    	}
    	
    	if(Damage < MaxCharge && Damage > MaxCharge / 4 * 2){
    		return DrillOrange;
    	}
    	
    	if(Damage == MaxCharge){
    		return DrillRed;
    	}
    	
    	
    	return Drill;
    	
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
    	
        if ((double)Block.blocksList[par3].getBlockHardness(par2World, par4, par5, par6) != 0.0D)
        {
            par1ItemStack.damageItem(1, par7EntityLivingBase);
        }

        return true;
    }
    
    
    
	   @SideOnly(Side.CLIENT)
	   public void registerIcons(IconRegister par1IconRegister)
	   {
		   this.Drill = par1IconRegister.registerIcon(Refrence.Mod_Id + ":Drill");
		   this.DrillGreen = par1IconRegister.registerIcon(Refrence.Mod_Id + ":DrillGreen");
		   this.DrillYellow = par1IconRegister.registerIcon(Refrence.Mod_Id + ":DrillYellow");
		   this.DrillOrange = par1IconRegister.registerIcon(Refrence.Mod_Id + ":DrillOrange");
		   this.DrillRed = par1IconRegister.registerIcon(Refrence.Mod_Id + ":DrillRed");
		   
	   }
	   
	    @Override
	    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
	    {
	    	int i = itemstack.getMaxDamage() - itemstack.getItemDamage();
	    	
	            list.add(StatCollector.translateToLocal("items.desc.drill.mode.1"));
	            list.add(StatCollector.translateToLocal("items.desc.drill.mode.2"));
	            list.add(StatCollector.translateToLocal("items.desc.drill.mode.3"));
	            list.add(StatCollector.translateToLocal("items.desc.drill.1"));
	            
	            
	            list.add(StatCollector.translateToLocal("items.desc.string.powerleft") + ": " + i);
	            if(itemstack.getItemDamage() == itemstack.getMaxDamage())
	            	list.add(EnumChatFormatting.RED + StatCollector.translateToLocal("items.desc.string.outofpowerrecharge"));
	            
	    			  
	            if(HasInfo(itemstack)){
	    			  NBTTagCompound Compound = itemstack.getTagCompound().getCompoundTag("Data");
		    		list.add(EnumChatFormatting.GOLD + StatCollector.translateToLocal("items.desc.drill.2") + ": " + Compound.getString("Mode"));	
	            }else{

	            	list.add(EnumChatFormatting.GOLD + StatCollector.translateToLocal("items.desc.drill.2_normal"));
	            	
	            }
	            
	            
	    }
	    

	    
	    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player)
	    {
	    	
	        NBTTagCompound stackCompound = item.hasTagCompound() ? item.getTagCompound() : new NBTTagCompound();
	        NBTTagCompound compound = new NBTTagCompound();

	        
	        
	    	
	    	if(player.isSneaking()){

	    		if(!HasInfo(item)){
	    			compound.setString("Mode", StatCollector.translateToLocal("items.drill.mode.2"));
	    		if(world.isRemote)
  				  player.addChatMessage(StatCollector.translateToLocal("items.drill.change.2"));
	    		}
	    		
	    		if(HasInfo(item)){
	    			  NBTTagCompound Compound = item.getTagCompound().getCompoundTag("Data");
	    			  
	    			  if(Compound.getString("Mode") == StatCollector.translateToLocal("items.drill.mode.1")){
	    				  
	    				  compound.setString("Mode", StatCollector.translateToLocal("items.drill.mode.2"));
	    		    		if(world.isRemote)
	    				  player.addChatMessage(StatCollector.translateToLocal("items.drill.change.2"));
	    				  
	    			  }else if (Compound.getString("Mode") == StatCollector.translateToLocal("items.drill.mode.2")){
	    				  compound.setString("Mode", StatCollector.translateToLocal("items.drill.mode.3"));
	    		    		if(world.isRemote)
	    				  player.addChatMessage(StatCollector.translateToLocal("items.drill.change.3"));
	    				  
	    			  }else if (Compound.getString("Mode") == StatCollector.translateToLocal("items.drill.mode.3")){
	    				  compound.setString("Mode", StatCollector.translateToLocal("items.drill.mode.1"));
	    		    		if(world.isRemote)
	    				  player.addChatMessage(StatCollector.translateToLocal("items.drill.change.1"));
	    				  
	    			  }else{
	    				  compound.setString("Mode", StatCollector.translateToLocal("items.drill.mode.2"));
	    			  }
	    		
	    		}
	    		
	    		
	    		
	    		
	    		
	    		
	            stackCompound.setCompoundTag("Data", compound);
	            item.setTagCompound(stackCompound);

	    	
	    	}
	    	
	    	return item;
	    }
	    


	    
	    @SuppressWarnings("unused")
		public boolean onBlockStartBreak(ItemStack itemstack, int x, int y, int z, EntityPlayer player)
	    {
	    	
            if(HasInfo(itemstack)){
  			  NBTTagCompound Compound = itemstack.getTagCompound().getCompoundTag("Data");
  			  
  			  
  	        World world = player.worldObj;
  	        final int blockID = world.getBlockId(x, y, z);
  	        final int meta = world.getBlockMetadata(x, y, z);
  	        final Block block = Block.blocksList[blockID];
  	      float blockHardness = block.getBlockHardness(world, x, y, z);
  	      

  	      if(itemstack.canHarvestBlock(block)){
  	        
  	        if (block == null)
  	            return super.onBlockStartBreak(itemstack, x, y, z, player);
  			  

	    			
	    			if(itemstack.getItemDamage() >= itemstack.getMaxDamage() - 9){
	    			
	    				return false;
	    				
	    			}else{
	    			 MovingObjectPosition mop = raytraceFromEntity(world, player, true, 5.0D);
	    		        if (mop == null)
	    		            return super.onBlockStartBreak(itemstack, x, y, z, player);

	    		        
	    		        int xRange = 0;
	    		        int yRange = 0;
	    		        int zRange = 0;
	    	    		
	    	    		if(Compound.getString("Mode") == StatCollector.translateToLocal("items.drill.mode.2")){
	    	    			
		    		        xRange = 1;
		    		        yRange = 1;
		    		        zRange = 1;
	    	            
	    	    		}else if (Compound.getString("Mode") == StatCollector.translateToLocal("items.drill.mode.3")){
	    	    			
		    		        xRange = 2;
		    		        yRange = 2;
		    		        zRange = 2;
	    	    		}
	    		        

	    		        switch (mop.sideHit)
	    		        {
	    		        case 0:
	    		        case 1:
	    		            yRange = 0;
	    		            break;
	    		        case 2:
	    		        case 3:
	    		            zRange = 0;
	    		            break;
	    		        case 4:
	    		        case 5:
	    		            xRange = 0;
	    		            break;
	    		        }


	    			
	    			for (int xPos = x - xRange; xPos <= x + xRange; xPos++)
	    	        {
	    	            for (int yPos = y - yRange; yPos <= y + yRange; yPos++)
	    	            {
	    	                for (int zPos = z - zRange; zPos <= z + zRange; zPos++)
	    	                {
	    	                        int localblockID = world.getBlockId(xPos, yPos, zPos);
	    	                        Block localBlock = Block.blocksList[localblockID];
	    	                        
	    	                        int localMeta = world.getBlockMetadata(xPos, yPos, zPos);
	    	                        float localHardness = localBlock == null ? Float.MAX_VALUE : localBlock.getBlockHardness(world, xPos, yPos, zPos);


	    	                        
	    	                        
	    	                                if (localBlock != null && !(localHardness < 0) && localHardness <= blockHardness)
	    	                                {
	
	    	                                            if (!player.capabilities.isCreativeMode)
	    	                                            {
	    	                                                if (localBlock.removeBlockByPlayer(world, player, xPos, yPos, zPos))
	    	                                                {
	    	                                                    localBlock.onBlockDestroyedByPlayer(world, xPos, yPos, zPos, localMeta);
	    	                                                }
	    	                                                localBlock.harvestBlock(world, player, xPos, yPos, zPos, localMeta);
	    	                                                localBlock.onBlockHarvested(world, xPos, yPos, zPos, localMeta, player);
	    	                                                if (blockHardness > 0f)
	    	                                                    onBlockDestroyed(itemstack, world, localblockID, xPos, yPos, zPos, player);
	    	                                            }
	    	                                            else
	    	                                            {
	    	                                                world.setBlockToAir(xPos, yPos, zPos);
	    	                                            
	    	                                        }
	    	                                    
	    	                                
	    	                            }
	    	                        }


	    	        }
	    	        }
            if (!world.isRemote)
                world.playAuxSFX(2001, x, y, z, blockID + (meta << 12));
            return true;
	    		
            
	    		}
            }
            }
            
	        return false;

	    }
	    
	    public boolean HasInfo(ItemStack stack) {
	        return stack.hasTagCompound() && stack.getTagCompound().hasKey("Data");
	    }
	    
	    
	    public static MovingObjectPosition raytraceFromEntity (World world, Entity player, boolean par3, double range)
	    {
	        float f = 1.0F;
	        float f1 = player.prevRotationPitch + (player.rotationPitch - player.prevRotationPitch) * f;
	        float f2 = player.prevRotationYaw + (player.rotationYaw - player.prevRotationYaw) * f;
	        double d0 = player.prevPosX + (player.posX - player.prevPosX) * (double) f;
	        double d1 = player.prevPosY + (player.posY - player.prevPosY) * (double) f + 1.62D - (double) player.yOffset;
	        double d2 = player.prevPosZ + (player.posZ - player.prevPosZ) * (double) f;
	        Vec3 vec3 = world.getWorldVec3Pool().getVecFromPool(d0, d1, d2);
	        float f3 = MathHelper.cos(-f2 * 0.017453292F - (float) Math.PI);
	        float f4 = MathHelper.sin(-f2 * 0.017453292F - (float) Math.PI);
	        float f5 = -MathHelper.cos(-f1 * 0.017453292F);
	        float f6 = MathHelper.sin(-f1 * 0.017453292F);
	        float f7 = f4 * f5;
	        float f8 = f3 * f5;
	        double d3 = range;
	        if (player instanceof EntityPlayerMP)
	        {
	            d3 = ((EntityPlayerMP) player).theItemInWorldManager.getBlockReachDistance();
	        }
	        Vec3 vec31 = vec3.addVector((double) f7 * d3, (double) f6 * d3, (double) f8 * d3);
	        return world.rayTraceBlocks_do_do(vec3, vec31, par3, !par3);
	    }
	    
	    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
	    {
	        return false;
	    }
	    
	    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
	    {
	        return false;
	    }
	  
	    

}
