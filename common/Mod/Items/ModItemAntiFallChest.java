package Mod.Items;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import Mod.Lib.Refrence;
import Mod.Main.Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModItemAntiFallChest extends ModItemElArmor{

	public ModItemAntiFallChest(int par1, int RenderIndex, int ArmorType) {
		super(par1, RenderIndex, ArmorType);
		this.setCreativeTab(Main.CreativeTab);
		this.setMaxDamage(2453);
	}

	
	   @SideOnly(Side.CLIENT)
	    @Override
	    public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
	    {
	    	
	    		return Refrence.Mod_Id + ":" + "textures/models/armor/AntiFallArmor_layer_1.png";

	    	
	    }
	   
	   
	   
	    @Override
	    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
	    {
			list.add("Prevents fall damage as long as it has power.");
			list.add("Hold shift to fall faster.");
			list.add("Hold the flight key to fly upwards (default to f)");
	    	int i = itemstack.getMaxDamage() - itemstack.getItemDamage();
	    	

            list.add("Power left: " + i);
            if(itemstack.getItemDamage() == itemstack.getMaxDamage())
            	list.add(EnumChatFormatting.RED + "Out of power recharge!");
	    }
	    
	    
	    public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack itemStack){
	    	
	    	super.onArmorTickUpdate(world, player, itemStack);
	    	
			if(player.inventory.armorInventory[2] != null && player.inventory.armorInventory[2].getItem() instanceof ModItemAntiFallChest)
			if(player.capabilities.isCreativeMode == false){
				int Left = player.inventory.armorInventory[2].getMaxDamage() - player.inventory.armorInventory[2].getItemDamage();
				if(Left > 0){
						if(player.fallDistance > 2){
					player.fallDistance = 2;
					if(!player.isSneaking())
					player.motionY = -0.35;
					if(player.worldObj.rand.nextInt(5) == 1)
					player.inventory.armorInventory[2].attemptDamageItem(1, player.worldObj.rand);
						}
					

				}
				
			}
	    	
	    }
}