package Mod.Crafting;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import Mod.Block.ModBlocks;
import Mod.Items.ModItems;
import Mod.Main.Main;
import cpw.mods.fml.common.registry.GameRegistry;

public class Crafting {

	
	
	public static void RegisterRecipes(){
		

		
			
			GameRegistry.addShapedRecipe(new ItemStack(ModItems.XpExtractor), new Object[] {" D ", "IGI", "IGI", 'I', Item.ingotIron, 'G', Block.glass, 'D', Item.diamond});
			GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.XpStorage), new Object[] {"BIB", "IEI", "BIB", 'I', Block.obsidian, 'B', Block.blockIron, 'E', ModItems.XpExtractor});
	        GameRegistry.addShapedRecipe(new ItemStack(ModItems.SilverIngot), new Object[] {"NNN", "NNN", "NNN", 'N', ModItems.SilverNugget});
			GameRegistry.addShapedRecipe(new ItemStack(ModItems.SilverSword), new Object[] {" I ", " I ", " S ", 'I', ModItems.SilverIngot, 'S', Item.stick});
	        
			GameRegistry.addShapelessRecipe(new ItemStack(ModItems.SilverNugget, 9), ModItems.SilverIngot);
			
			
			GameRegistry.addSmelting(ModBlocks.SilverOre.blockID, new ItemStack(ModItems.SilverIngot), 2.0F);
	}
}
