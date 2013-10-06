package Mod.ItemBlock;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ModItemBlockLockableChest extends ItemBlock{

	public ModItemBlockLockableChest(int par1) {
		super(par1);
	}
	
    @Override
    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
    {
            list.add("A chest that can be locked with a key.");
    }

}
