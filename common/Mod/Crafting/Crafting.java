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
			GameRegistry.addShapedRecipe(new ItemStack(ModItems.SilverBow), new Object[] {" IS", "I S", " IS", 'I', ModItems.SilverIngot, 'S', Item.silk});
	        GameRegistry.addShapedRecipe(new ItemStack(ModItems.SilverBow), new Object[] {"SI ", "S I", "SI ", 'I', ModItems.SilverIngot, 'S', Item.silk});
	        GameRegistry.addShapedRecipe(new ItemStack(ModItems.SilverArrow, 8), new Object[] {" N ", " S ", " F ", 'N', ModItems.SilverNugget, 'S', Item.stick, 'F', Item.feather});
			GameRegistry.addRecipe(new ItemStack(ModBlocks.StoneStair, 4), new Object[]{"S  ", "SS ", "SSS", 'S', Block.stone});
			GameRegistry.addRecipe(new ItemStack(ModBlocks.StoneStair, 4), new Object[]{"  S", " SS", "SSS", 'S', Block.stone});
	        GameRegistry.addRecipe(new ItemStack(ModItems.FlightChestPlate), new Object[] {"IFI", "ISI", "III", 'I', ModItems.SilverIngot, 'S', Item.netherStar, 'F', Item.feather});
			GameRegistry.addRecipe(new ItemStack(ModBlocks.DisarmTrap), new Object[] {"ISI", "SPS", "ISI", 'I', Item.ingotIron, 'S', ModItems.SilverIngot, 'P', Block.pressurePlateIron});
	        GameRegistry.addRecipe(new ItemStack(ModBlocks.Bin), new Object[] {"I I", "IBI", " I ", 'I', Item.ingotIron, 'B', Item.bucketEmpty});
	        GameRegistry.addRecipe(new ItemStack(ModBlocks.Shelf), new Object[] {"SPS", "SPS", "SPS", 'S', Item.stick, 'P', Block.pressurePlatePlanks});
			
			
			
			
			GameRegistry.addShapelessRecipe(new ItemStack(ModItems.SilverNugget, 9), ModItems.SilverIngot);
			
			
			GameRegistry.addSmelting(ModBlocks.SilverOre.blockID, new ItemStack(ModItems.SilverIngot), 2.0F);
	}
}
