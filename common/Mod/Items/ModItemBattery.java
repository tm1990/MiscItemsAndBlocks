package Mod.Items;

import java.util.List;

import Mod.Block.ModBlockCharger;
import Mod.Block.ModBlocks;
import Mod.Lib.Refrence;
import Mod.TileEntity.TileEntityCharger;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class ModItemBattery extends ModItemPowerStorage{

	public ModItemBattery(int par1) {
		super(par1, 16);

	}
	
	Icon Icon1;
	Icon Icon2;
	Icon Icon3;
	Icon Icon4;
	Icon Icon5;
	
	   @SideOnly(Side.CLIENT)
	   public void registerIcons(IconRegister par1IconRegister)
	   {
		   
		   Icon1 = par1IconRegister.registerIcon(Refrence.Mod_Id + ":BatteryEmpty");
		   Icon2 = par1IconRegister.registerIcon(Refrence.Mod_Id + ":Battery1");
		   Icon3 = par1IconRegister.registerIcon(Refrence.Mod_Id + ":Battery2");
		   Icon4 = par1IconRegister.registerIcon(Refrence.Mod_Id + ":Battery3");
		   Icon5 = par1IconRegister.registerIcon(Refrence.Mod_Id + ":BatteryFull");
		   
	   }
	   
		@Override
	    public Icon getIconFromDamage(int Damage)
	    {
			if(Damage == 16) {
				return Icon1;
			}
			
			if(Damage > 8 && Damage <= 15) {
				return Icon2;
			}
			
			if(Damage > 4 && Damage <= 8) {
				return Icon3;
			}
			
			if(Damage > 0 && Damage <= 4) {
				return Icon4;
			}

			if(Damage == 0) {
				return Icon5;
			}
			
			
			
			
			
			return Icon1;
			
	    }
	   

}
