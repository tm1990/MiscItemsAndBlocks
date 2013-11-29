package Mod.LibMisc;

import net.minecraft.item.ItemStack;

public interface IStackFilter {

    public boolean matches(ItemStack stack);
}