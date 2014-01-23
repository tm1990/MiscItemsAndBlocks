package Mod.Items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import Mod.Entity.EntityPowerArrow;
import Mod.Lib.Refrence;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModItemElectricBow extends ModItemPowerTool{

	
private Icon _icon1;
private Icon _icon2;
private Icon _icon3;
private Icon _icon4;


	public ModItemElectricBow(int par1) {
		super(par1, 1, EnumToolMaterial.IRON, new Block[]{});
		this.setMaxStackSize(1);
		this.setMaxDamage(580);
	}
	
	   public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4)
	    {
		   int i = par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage();
		   
		   if(i > 0){
		   
	        int j = this.getMaxItemUseDuration(par1ItemStack) - par4;

	        ArrowLooseEvent event = new ArrowLooseEvent(par3EntityPlayer, par1ItemStack, j);
	        MinecraftForge.EVENT_BUS.post(event);
	        if (event.isCanceled())
	        {
	            return;
	        }
	        j = event.charge;

	            float f = (float)j / 20.0F;
	            f = (f * f + f * 2.0F) / 3.0F;

	            if ((double)f < 0.1D)
	            {
	                return;
	            }

	            if (f > 1.0F)
	            {
	                f = 1.0F;
	            }

	            EntityPowerArrow entityarrow = new EntityPowerArrow(par2World, par3EntityPlayer, f * 2.0F);

	            if (f == 1.0F)
	            {
	                entityarrow.setIsCritical(true);
	            }

	            int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, par1ItemStack);

	            if (k > 0)
	            {
	                entityarrow.setDamage(entityarrow.getDamage() + (double)k * 0.5D + 0.5D);
	            }

	            int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, par1ItemStack);

	            if (l > 0)
	            {
	                entityarrow.setKnockbackStrength(l);
	            }

	            if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, par1ItemStack) > 0)
	            {
	                entityarrow.setFire(100);
	            }

	            par1ItemStack.damageItem(1, par3EntityPlayer);
	            par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);


	            if (!par2World.isRemote)
	            {
	                par2World.spawnEntityInWorld(entityarrow);
	            }
		   }
	        
	    }


	    public int getMaxItemUseDuration(ItemStack par1ItemStack)
	    {
	        return 72000;
	    }


	    public EnumAction getItemUseAction(ItemStack par1ItemStack)
	    {
	        return EnumAction.bow;
	    }


	    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	    {
			   int i = par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage();
			   
			   if(i > 0){
	        ArrowNockEvent event = new ArrowNockEvent(par3EntityPlayer, par1ItemStack);
	        MinecraftForge.EVENT_BUS.post(event);
	        if (event.isCanceled())
	        {
	            return event.result;
	        }

	            par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
	        

			   }
	        return par1ItemStack;
	    }


	    public int getItemEnchantability()
	    {
	        return 15;
	    }

	    @SideOnly(Side.CLIENT)
	    public void registerIcons(IconRegister par1IconRegister)
	    {
	    	
	    	_icon1 = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + getUnlocalizedName().substring(5) + "_normal");
	    	_icon2 = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + getUnlocalizedName().substring(5) + "_1");
	    	_icon3 = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + getUnlocalizedName().substring(5) + "_2");
	    	_icon4 = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + getUnlocalizedName().substring(5) + "_3");
	    	
	    	itemIcon = _icon1;
	    }

		@Override

		public Icon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)

		{
			
			//TODO Look at this before 1.7

			if(usingItem != null && usingItem.itemID == itemID)

			{


				if(useRemaining > 71999)  return _icon1;

				if(useRemaining > 71980) return _icon2;
				
				if(useRemaining > 71972) return _icon3;
				
				return _icon4;
	            

			}

			return _icon1;

		}
		
		
		@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player)
	{

		return stack;

			
	}
		
		
	    @Override
	    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
	    {
	    	list.add(StatCollector.translateToLocal("items.desc.electricbow"));
	    	int Damage = itemstack.getMaxDamage() - itemstack.getItemDamage();
	    	
	    	list.add(StatCollector.translateToLocal("words.power") + ": " + Damage);
	    	
	    	
	    }
	    
	    
	}



