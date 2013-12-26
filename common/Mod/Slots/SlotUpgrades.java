package Mod.Slots;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import Mod.Items.ModItemUpgradeItem;
import Mod.Items.ModItemUpgrades;

public class SlotUpgrades extends Slot{

	public SlotUpgrades(IInventory par1iInventory, int par2, int par3,int par4) {
		super(par1iInventory, par2, par3, par4);
	}

    public boolean isItemValid(ItemStack item)
    {
    	
    	
    	return item.getItem() instanceof ModItemUpgradeItem;
    	
    }
    
    public Icon getBackgroundIconIndex()
    {
        return ModItemUpgrades.EmptySlot;
    }

	
}