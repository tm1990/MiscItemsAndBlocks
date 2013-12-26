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
		

		
		
		if(item.getItem() == ModItems.PizzaRaw)player.inventory.addItemStackToInventory(new ItemStack(Item.bucketEmpty));
		
		if(item.getItem() == ModItems.PaintBrush){
			if(item.getItemDamage() == 4){
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.PaintBrush, 1, 1));
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.PaintBrush, 1, 2));
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.PaintBrush, 1, 3));

				
				
			}else if(item.getItemDamage() == 5){
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.PaintBrush, 1, 1));
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.PaintBrush, 1, 2));
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.PaintBrush, 1, 3));
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.PaintBrush, 1, 4));

				
				
			}
		}
		
		
	}

	@Override
	public void onSmelting(EntityPlayer player, ItemStack item) {
		
	}

}
