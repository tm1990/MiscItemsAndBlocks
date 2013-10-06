package Mod.Items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import Mod.Lib.Refrence;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModItemBigBattery extends ModItemPowerStorage{

	public ModItemBigBattery(int par1) {
		super(par1, 32);
	}

	
	Icon Icon1;
	Icon Icon2;
	Icon Icon3;
	Icon Icon4;
	Icon Icon5;
	
	   @SideOnly(Side.CLIENT)
	   public void registerIcons(IconRegister par1IconRegister)
	   {
		   
		   Icon1 = par1IconRegister.registerIcon(Refrence.Mod_Id + ":BigBatteryEmpty");
		   Icon2 = par1IconRegister.registerIcon(Refrence.Mod_Id + ":BigBattery1");
		   Icon3 = par1IconRegister.registerIcon(Refrence.Mod_Id + ":BigBattery2");
		   Icon4 = par1IconRegister.registerIcon(Refrence.Mod_Id + ":BigBattery3");
		   Icon5 = par1IconRegister.registerIcon(Refrence.Mod_Id + ":BigBatteryFull");
		   
	   }
	   
		@Override
	    public Icon getIconFromDamage(int Damage)
	    {
			if(Damage == 32) {
				return Icon1;
			}
			
			if(Damage > 12 && Damage <= 31) {
				return Icon2;
			}
			
			if(Damage > 6 && Damage <= 12) {
				return Icon3;
			}
			
			if(Damage > 0 && Damage <= 6) {
				return Icon4;
			}

			if(Damage == 0) {
				return Icon5;
			}
			
			
			
			
			
			return Icon1;
			
	    }
	   
}
