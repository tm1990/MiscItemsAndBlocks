package Mod.Items;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import Mod.Lib.Refrence;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModItemElectricShear extends ModItemPowerTool{

	public ModItemElectricShear(int par1) {
		super(par1, 0, EnumToolMaterial.IRON, new Block[]{Block.web, Block.redstoneWire, Block.tripWire});

		this.setMaxDamage(430);
		this.setMaxStackSize(1);
		this.damageVsEntity = 0;
	}
	
	@Override
    public boolean itemInteractionForEntity(ItemStack itemstack, EntityPlayer player, EntityLivingBase entity)
    {
    	if(itemstack.getItemDamage() != itemstack.getMaxDamage()){
		
        if (entity.worldObj.isRemote)
        {
            return false;
        }
        if (entity instanceof IShearable)
        {
            IShearable target = (IShearable)entity;
            if (target.isShearable(itemstack, entity.worldObj, (int)entity.posX, (int)entity.posY, (int)entity.posZ))
            {
                ArrayList<ItemStack> drops = target.onSheared(itemstack, entity.worldObj, (int)entity.posX, (int)entity.posY, (int)entity.posZ,
                        EnchantmentHelper.getEnchantmentLevel(Enchantment.fortune.effectId, itemstack));

                Random rand = new Random();
                for(ItemStack stack : drops)
                {
                    EntityItem ent = entity.entityDropItem(stack, 1.0F);
                    ent.motionY += rand.nextFloat() * 0.05F;
                    ent.motionX += (rand.nextFloat() - rand.nextFloat()) * 0.1F;
                    ent.motionZ += (rand.nextFloat() - rand.nextFloat()) * 0.1F;
                }
                itemstack.damageItem(1, entity);
            }
            return true;
        }
    	}
        return false;
    }

    @Override
    public boolean onBlockStartBreak(ItemStack itemstack, int x, int y, int z, EntityPlayer player)
    {
    	if(itemstack.getItemDamage() != itemstack.getMaxDamage()){
    	
        if (player.worldObj.isRemote)
        {
            return false;
        }
        int id = player.worldObj.getBlockId(x, y, z);
        if (Block.blocksList[id] instanceof IShearable)
        {
            IShearable target = (IShearable)Block.blocksList[id];
            if (target.isShearable(itemstack, player.worldObj, x, y, z))
            {
                ArrayList<ItemStack> drops = target.onSheared(itemstack, player.worldObj, x, y, z,
                        EnchantmentHelper.getEnchantmentLevel(Enchantment.fortune.effectId, itemstack));
                Random rand = new Random();

                for(ItemStack stack : drops)
                {
                    float f = 0.7F;
                    double d  = (double)(rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
                    double d1 = (double)(rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
                    double d2 = (double)(rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
                    EntityItem entityitem = new EntityItem(player.worldObj, (double)x + d, (double)y + d1, (double)z + d2, stack);
                    entityitem.delayBeforeCanPickup = 10;
                    player.worldObj.spawnEntityInWorld(entityitem);
                }

                itemstack.damageItem(1, player);
                player.addStat(StatList.mineBlockStatArray[id], 1);
            }
        }
    	}
        return false;
    }
    
    public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
    {
    	if(par1ItemStack.getItemDamage() != par1ItemStack.getMaxDamage()){
    	
        return par2Block.blockID != Block.web.blockID && par2Block.blockID != Block.leaves.blockID ? (par2Block.blockID == Block.cloth.blockID ? 5.0F : super.getStrVsBlock(par1ItemStack, par2Block)) : 15.0F;
    	}else{
    		return 0;
    	}
    	
    	}
    	
    
    public boolean canHarvestBlock(Block par1Block)
    {
        return par1Block.blockID == Block.web.blockID || par1Block.blockID == Block.redstoneWire.blockID || par1Block.blockID == Block.tripWire.blockID;
    }
    
    public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, int par3, int par4, int par5, int par6, EntityLivingBase par7EntityLivingBase)
    {
    	if(par1ItemStack.getItemDamage() != par1ItemStack.getMaxDamage()){
    	
        if (par3 != Block.leaves.blockID && par3 != Block.web.blockID && par3 != Block.tallGrass.blockID && par3 != Block.vine.blockID && par3 != Block.tripWire.blockID && !(Block.blocksList[par3] instanceof IShearable))
        {
            return super.onBlockDestroyed(par1ItemStack, par2World, par3, par4, par5, par6, par7EntityLivingBase);
        }
        else
        {
            return true;
        }
    	}else{
    		return false;
    	}
    }
    
	   @SideOnly(Side.CLIENT)
	   public void registerIcons(IconRegister par1IconRegister)
	   {
		   this.itemIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":ElShears");
		  
		   
	   }
	   
	   
	    @Override
	    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
	    {
	    	int i = itemstack.getMaxDamage() - itemstack.getItemDamage();
	    	
	    	list.add(StatCollector.translateToLocal("words.power") + ": " + i);
	    	
	    }
	    
	    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
	    {
	        return false;
	    }

}
