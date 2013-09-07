package Mod.Lib;

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
			GameRegistry.addShapelessRecipe(new ItemStack(ModItems.Cardboard, 2), new Object[]{Item.paper, Item.paper, Item.paper});
			GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.Box), new Object[]{"CCC", "C C", "CCC", 'C', ModItems.Cardboard});
			GameRegistry.addRecipe(new ItemStack(ModItems.DivingHelmet), new Object[] {"SNS", "SGS", "   ", 'S', ModItems.SilverIngot, 'N', Item.netherStar, 'G', Block.glass});
			GameRegistry.addRecipe(new ItemStack(ModItems.RunningLeggings), new Object[]{"SNS", "S S", "S S", 'S', ModItems.SilverIngot, 'N', Item.netherStar});
			GameRegistry.addRecipe(new ItemStack(ModItems.JumpingBoots), new Object[] {"   ", "S S", "D D", 'D', Item.diamond, 'S', ModItems.SilverIngot});
	        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.CraftingInv), new Object[] {"WWW", "PIP", "PCP", 'W', Block.cloth, 'P', Block.planks, 'C', Block.chest, 'I', Block.workbench});
	        GameRegistry.addShapedRecipe(new ItemStack(ModItems.CraftingUpgrade), new Object[]{"WWW", "PBP", "PCP", 'W', Block.cloth, 'P', Block.planks, 'B', ModItems.Cardboard, 'C', Block.chest});
			GameRegistry.addShapelessRecipe(new ItemStack(ModItems.TomatoSeeds, 4), ModItems.Tomato);
			GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.SpeedBlock, 8), new Object[]{"III", "BDB", "BBB", 'I', Block.ice, 'B', Block.blockIron, 'D', Item.diamond});
			GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.Dice), new Object[]{"PPP", "PDP", "PPP", 'P', Block.planks, 'D', Item.dyePowder});
			GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.Mill), new Object[]{"CSC", "SPS", "CCC", 'C', Block.cobblestone, 'S', Block.stone, 'P', Block.pistonBase});
			GameRegistry.addShapedRecipe(new ItemStack(ModItems.PizzaBottom), new Object[]{"FFF", 'F', ModItems.Flour});
			GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.Squezer), new Object[]{"CIC", "IPI", "CCC", 'C', Block.cobblestone, 'I', Item.ingotIron, 'P', Block.pistonBase});
			GameRegistry.addShapelessRecipe(new ItemStack(ModItems.Cheese), Item.bucketMilk);
			
	        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.Pillar, 4), new Object[]{"QQQ", " Q ", "QQQ", 'Q', Block.blockNetherQuartz});
	        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.SidewaysPillar, 4), new Object[]{"Q Q", "QQQ", "Q Q", 'Q', Block.blockNetherQuartz});
	        
	        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.GamePartNull, 4), new Object[]{"III", " I ", "III", 'I', Item.ingotIron});
	        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.GamePartGreen), new Object[]{ModBlocks.GamePartNull, new ItemStack(Item.dyePowder, 1, 2)});
	        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.GamePartRed), new Object[]{ModBlocks.GamePartNull, new ItemStack(Item.dyePowder, 1, 1)});
	        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.GamePartYellow), new Object[]{ModBlocks.GamePartNull, new ItemStack(Item.dyePowder, 1, 11)});
	        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.GamePartBlue), new Object[]{ModBlocks.GamePartNull, new ItemStack(Item.dyePowder, 1, 4)});
			
			
			
			GameRegistry.addShapelessRecipe(new ItemStack(ModItems.SilverNugget, 9), ModItems.SilverIngot);
			
			
			GameRegistry.addSmelting(ModBlocks.SilverOre.blockID, new ItemStack(ModItems.SilverIngot), 2.0F);
	}
}
