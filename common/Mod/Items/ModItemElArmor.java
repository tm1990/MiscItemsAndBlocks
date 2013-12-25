package Mod.Items;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ModItemElArmor extends ItemArmor{

	public ModItemElArmor(int par1, int RenderIndex, int ArmorType) {
		super(par1, EnumArmorMaterial.IRON, RenderIndex, ArmorType);
		this.canRepair = false;

	}
	
    public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack itemStack){
    	
    	
    }

}
