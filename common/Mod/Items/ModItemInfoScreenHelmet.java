package Mod.Items;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import Mod.Lib.Refrence;
import Mod.Main.Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModItemInfoScreenHelmet extends ModItemElArmor{

	public ModItemInfoScreenHelmet(int par1, int RenderIndex, int ArmorType) {
		super(par1, RenderIndex, ArmorType);
		this.setCreativeTab(Main.CreativeTab);
		this.setMaxDamage(152);
	}

	
	   @SideOnly(Side.CLIENT)
	    @Override
	    public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
	    {
	    	
	    		return Refrence.Mod_Id + ":" + "textures/models/armor/InfoScreenHelmet_layer_1.png";

	    		

	    	
	    }
	   
	   
	   
	    @Override
	    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
	    {
			list.add(StatCollector.translateToLocal("items.desc.infoscreen.1"));
			list.add(StatCollector.translateToLocal("items.desc.infoscreen.2"));
			list.add(StatCollector.translateToLocal("items.desc.infoscreen.3"));
			list.add(StatCollector.translateToLocal("items.desc.infoscreen.4"));
	    	int i = itemstack.getMaxDamage() - itemstack.getItemDamage();
	    	

            list.add(StatCollector.translateToLocal("items.desc.string.powerleft") + ": " + i);
            if(itemstack.getItemDamage() == itemstack.getMaxDamage())
            	list.add(EnumChatFormatting.RED + StatCollector.translateToLocal("items.desc.string.outofpowerrecharge"));
	    }
	    
	    public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack itemStack){
	    	if(itemStack.getMaxDamage() - itemStack.getItemDamage() > 0 && !player.capabilities.isCreativeMode)
    		if(player.worldObj.rand.nextInt(1000) == 1){
			itemStack.attemptDamageItem(1, world.rand);
    		}
	    }
	    
	    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	    {
	        int i = EntityLiving.getArmorPosition(par1ItemStack) - 1;
	        ItemStack itemstack1 = par3EntityPlayer.getCurrentArmor(i);

	        if (itemstack1 == null)
	        {
	            par3EntityPlayer.setCurrentItemOrArmor(i + 1, par1ItemStack.copy()); 
	            par1ItemStack.stackSize = 0;
	            
	            par2World.playSoundAtEntity(par3EntityPlayer, "random.click", 1.0F, 0.7F);
	        }

	        return par1ItemStack;
	    }


		@Override
		public int MaxPower(ItemStack stack) {
			return 152;
		}


		@Override
		public int ChargeAmount(ItemStack stack) {
			return 1;
		}
	    
		@Override
		public boolean CanBackpackRecharge(ItemStack stack) {
			return true;
		}
	 
}

