package Mod.Items;

import MiscItemsApi.Electric.IPowerItem;
import net.minecraft.block.Block;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public abstract class ModItemPowerTool extends ItemTool implements IPowerItem{

	public ModItemPowerTool(int par1, float damage, EnumToolMaterial material, Block[] blocks) {
		super(par1, damage, material, blocks);
		this.canRepair = false;
	}
    public int getItemEnchantability()
    {
        return 0;
    }
    
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
        return false;
    }
}
