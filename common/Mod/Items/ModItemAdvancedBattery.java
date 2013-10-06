package Mod.Items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import Mod.Lib.Refrence;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModItemAdvancedBattery extends ModItemPowerStorage{

	public ModItemAdvancedBattery(int par1) {
		super(par1, 64);
	}

	
	Icon Icon1;
	Icon Icon2;
	Icon Icon3;
	Icon Icon4;
	Icon Icon5;
	
	   @SideOnly(Side.CLIENT)
	   public void registerIcons(IconRegister par1IconRegister)
	   {
		   
		   Icon1 = par1IconRegister.registerIcon(Refrence.Mod_Id + ":AdvancedBatteryEmpty");
		   Icon2 = par1IconRegister.registerIcon(Refrence.Mod_Id + ":AdvancedBattery1");
		   Icon3 = par1IconRegister.registerIcon(Refrence.Mod_Id + ":AdvancedBattery2");
		   Icon4 = par1IconRegister.registerIcon(Refrence.Mod_Id + ":AdvancedBattery3");
		   Icon5 = par1IconRegister.registerIcon(Refrence.Mod_Id + ":AdvancedBatteryFull");
		   
	   }
	   
		@Override
	    public Icon getIconFromDamage(int Damage)
	    {
			if(Damage == 64) {
				return Icon1;
			}
			
			if(Damage > 32 && Damage <= 63) {
				return Icon2;
			}
			
			if(Damage > 16 && Damage <= 32) {
				return Icon3;
			}
			
			if(Damage > 0 && Damage <= 16) {
				return Icon4;
			}

			if(Damage == 0) {
				return Icon5;
			}
			
			
			
			
			
			return Icon1;
			
	    } 

}
