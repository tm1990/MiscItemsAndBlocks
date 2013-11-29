package Mod.Items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.Icon;
import Mod.Lib.Refrence;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModItemUpgrades extends ModItemUpgradeItem{

	Icon[] icons = new Icon[10];
	
	public ModItemUpgrades(int par1) {
		super(par1);
		this.maxStackSize = 16;

	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		
	    
	    this.icons[0] = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "PowerUpgrade");


	}

	public Icon getIconFromDamage(int meta)
	{
			return icons[meta];

	}

	public String getItemDisplayName(ItemStack stack)
	{
		int meta = stack.getItemDamage();

		
		if(meta == 0)return "Power Upgrade";
		
		
		
		return null;
	}

	public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List list)
	{
	    super.getSubItems(par1, par2CreativeTabs, list);
	    
//	    list.add(new ItemStack(par1, 1, 1));
//	    list.add(new ItemStack(par1, 1, 2));
//	    list.add(new ItemStack(par1, 1, 3));
	    
	}


}
