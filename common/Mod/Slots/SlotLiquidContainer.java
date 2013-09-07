package Mod.Slots;

import Mod.Block.ModBlockSquezer;
import net.minecraft.block.Block;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class SlotLiquidContainer extends Slot{

	public SlotLiquidContainer(IInventory par1iInventory, int par2, int par3,
			int par4) {
		super(par1iInventory, par2, par3, par4);
	}
	
    public boolean isItemValid(ItemStack itemstack)
    {
        return itemstack.itemID == Item.bucketEmpty.itemID || itemstack.itemID == Item.glassBottle.itemID;
    }

}
