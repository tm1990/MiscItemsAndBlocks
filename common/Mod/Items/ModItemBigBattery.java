package Mod.Items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import Mod.Lib.Refrence;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModItemBigBattery extends ModItemPowerStorage{

	public ModItemBigBattery(int par1) {
		super(par1);
		this.setMaxDamage(32);
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
	   
		
		@Override
		public int MaxPower(ItemStack stack) {
			return 32;
		}

		@Override
		public int ChargeAmount(ItemStack stack) {
			return 1;
		}

		@Override
		public boolean CanBackpackRecharge(ItemStack stack) {
			return false;
		}
}
