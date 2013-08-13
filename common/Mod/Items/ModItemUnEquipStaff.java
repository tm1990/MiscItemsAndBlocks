package Mod.Items;

import Mod.Main.Main;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModItemUnEquipStaff extends Item{

	public ModItemUnEquipStaff(int par1) {
		super(par1);
		setCreativeTab(Main.CreativeTab);
		setUnlocalizedName("UnEquipStaff");
	}
	
	
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase EntityHit, EntityLivingBase EntityAttacker)
    {
    	

    	
        return false;
    }
	

}
