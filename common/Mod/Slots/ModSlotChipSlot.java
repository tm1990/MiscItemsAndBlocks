package Mod.Slots;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import Mod.Items.ModItemDataChip;
import Mod.Items.ModItemUpgrades;

public class ModSlotChipSlot extends Slot{

	public ModSlotChipSlot(IInventory par1iInventory, int par2, int par3,
			int par4) {
		super(par1iInventory, par2, par3, par4);
	}
	
	public boolean isItemValid(ItemStack stack)
    {
        return stack.getItem() instanceof ModItemDataChip;
    }
    
    public Icon getBackgroundIconIndex()
    {
        return ModItemUpgrades.ChipSlot;
    }
    
    public int getSlotStackLimit()
    {
        return 1;
    }

}
