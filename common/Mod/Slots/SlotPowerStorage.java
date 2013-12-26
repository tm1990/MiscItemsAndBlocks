package Mod.Slots;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import Mod.Items.ModItemElArmor;
import Mod.Items.ModItemPowerTool;

public class SlotPowerStorage extends Slot{

	public SlotPowerStorage(IInventory par1iInventory, int par2, int par3,int par4) {
		super(par1iInventory, par2, par3, par4);
	}

    public boolean isItemValid(ItemStack item)
    {
    	

    	
    	return item.getItem() instanceof ModItemPowerTool || item.getItem() instanceof ModItemElArmor;
    	
    }
	
}
