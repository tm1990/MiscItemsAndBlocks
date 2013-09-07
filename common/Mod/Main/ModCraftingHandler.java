package Mod.Main;

import Mod.Items.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ICraftingHandler;

public class ModCraftingHandler implements ICraftingHandler{

	@Override
	public void onCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix) {
		
		
		if(item.itemID == ModItems.Cheese.itemID)player.inventory.addItemStackToInventory(new ItemStack(Item.bucketEmpty));
		
		
	}

	@Override
	public void onSmelting(EntityPlayer player, ItemStack item) {
		
	}

}
