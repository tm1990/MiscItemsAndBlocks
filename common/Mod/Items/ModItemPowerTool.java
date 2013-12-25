package Mod.Items;

import net.minecraft.block.Block;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTool;

public abstract class ModItemPowerTool extends ItemTool{

	public ModItemPowerTool(int par1, float damage, EnumToolMaterial material, Block[] blocks) {
		super(par1, damage, material, blocks);
		this.canRepair = false;
	}

}
