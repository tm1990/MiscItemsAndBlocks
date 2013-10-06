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
			GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.PizzaOven), new Object[] {"SSS", "SFS", "SSS", 'S', Block.stone, 'F', Block.furnaceIdle});
			
			GameRegistry.addShapedRecipe(new ItemStack(ModItems.Drill), new Object[]{"DD ", "DSI", " IP", 'D', Item.diamond, 'P', ModItems.Battery, 'I', Item.ingotIron, 'S', new ItemStack(ModItems.Circuit, 1, 0)});
			GameRegistry.addShapedRecipe(new ItemStack(ModItems.Battery, 1, 16), new Object[]{" C ", "IRI", "IRI", 'C', new ItemStack(ModItems.Circuit, 1, 0), 'I', Item.ingotIron, 'R', Item.redstone});
			GameRegistry.addShapedRecipe(new ItemStack(ModItems.ElectricShears), new Object[]{"ISI", "IBI", "ICI", 'I', Item.ingotIron, 'S', Item.shears, 'B', ModItems.Battery, 'C', new ItemStack(ModItems.Circuit, 1, 0)});
			GameRegistry.addShapedRecipe(new ItemStack(ModItems.ElectricBow), new Object[]{" IS", "ICB", " IS", 'I', Item.ingotIron, 'S', Item.silk, 'C', new ItemStack(ModItems.Circuit), 'B', ModItems.Battery});
			
			GameRegistry.addShapedRecipe(new ItemStack(ModItems.Circuit, 1, 1), new Object[]{"ICI", "RDR", "ICI", 'I', Item.ingotIron, 'C', new ItemStack(ModItems.Circuit, 1, 0), 'R', Item.redstone, 'D', Item.diamond});
			GameRegistry.addShapedRecipe(new ItemStack(ModItems.Circuit, 1, 0), new Object[]{"WIW", "IRI", "WIW", 'W', new ItemStack(Block.cloth, 1, 13), 'I', Item.ingotIron, 'R', Item.redstone});
			GameRegistry.addShapedRecipe(new ItemStack(ModItems.ModuleConnecter), new Object[]{"III", "ICI", "III", 'I', Item.ingotIron, 'C', new ItemStack(ModItems.Circuit, 1, 0)});
			GameRegistry.addShapedRecipe(new ItemStack(ModItems.SolarCells), new Object[]{"IGI", "GCG", "IGI", 'I', Item.ingotIron, 'G', Block.glass, 'C', new ItemStack(ModItems.Circuit, 1, 0)});
			GameRegistry.addShapedRecipe(new ItemStack(ModItems.Turbine), new Object[]{"S S", " P ", "S S", 'S', Item.stick, 'P', Block.planks});
			
			GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.Charger), new Object[]{"IMI", "RCR", "IRI", 'I', Item.ingotIron, 'R', new ItemStack(ModItems.Battery, 1, 16), 'C', new ItemStack(ModItems.Circuit, 1, 0), 'M', ModItems.ModuleConnecter});
			GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.SolarPanel), new Object[]{"IGI", "GCG", "IMI", 'I', Item.ingotIron, 'G', ModItems.SolarCells, 'C', new ItemStack(ModItems.Circuit, 1, 1), 'M', ModItems.ModuleConnecter});
			GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.WindMill), new Object[]{"III", "SCS", "IMI", 'I', Item.ingotIron, 'S', ModItems.Turbine, 'C', new ItemStack(ModItems.Circuit, 1, 0), 'M', ModItems.ModuleConnecter});
			GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.Generator), new Object[]{"III", "ICI", "IMI", 'I', Item.ingotIron, 'C', new ItemStack(ModItems.Circuit, 1, 0), 'M', ModItems.ModuleConnecter});
			GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.PowerCable, 32), new Object[]{"IGI", "RDR", "IGI", 'I', Item.ingotIron, 'G', new ItemStack(ModItems.Circuit, 1, 1), 'R', Item.redstone, 'D', Item.diamond});
			
			
	        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.Pillar, 4), new Object[]{"QQQ", " Q ", "QQQ", 'Q', Block.blockNetherQuartz});
	        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.SidewaysPillar, 4), new Object[]{"Q Q", "QQQ", "Q Q", 'Q', Block.blockNetherQuartz});
	        
	        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.GamePartNull, 4), new Object[]{"III", " I ", "III", 'I', Item.ingotIron});
	        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.GamePartGreen), new Object[]{ModBlocks.GamePartNull, new ItemStack(Item.dyePowder, 1, 2)});
	        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.GamePartRed), new Object[]{ModBlocks.GamePartNull, new ItemStack(Item.dyePowder, 1, 1)});
	        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.GamePartYellow), new Object[]{ModBlocks.GamePartNull, new ItemStack(Item.dyePowder, 1, 11)});
	        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.GamePartBlue), new Object[]{ModBlocks.GamePartNull, new ItemStack(Item.dyePowder, 1, 4)});
			
	        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.PizzaRaw), ModItems.Cheese, ModItems.PizzaBottom, new ItemStack(ModItems.Liquid, 1, 1), Item.fishCooked);
	        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.PizzaRaw, 1, 1), ModItems.Cheese, ModItems.PizzaBottom, new ItemStack(ModItems.Liquid, 1, 1), Item.porkCooked);
	        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.PizzaRaw, 1, 2), ModItems.Cheese, ModItems.PizzaBottom, new ItemStack(ModItems.Liquid, 1, 1), Item.beefCooked);
	        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.PizzaRaw, 1, 3), ModItems.Cheese, ModItems.PizzaBottom, new ItemStack(ModItems.Liquid, 1, 1), Item.chickenCooked);

			
	        
	        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.OrangePlanks, 4), ModBlocks.OrangeLog);
	        GameRegistry.addRecipe(new ItemStack(Item.stick, 4), new Object[]{"P", "P", 'P', ModBlocks.OrangePlanks});
	        GameRegistry.addRecipe(new ItemStack(Block.chest), new Object[]{"PPP", "P P", "PPP", 'P', ModBlocks.OrangePlanks});
	        GameRegistry.addRecipe(new ItemStack(Item.doorWood), new Object[]{"PP", "PP", "PP", 'P', ModBlocks.OrangePlanks});
	        GameRegistry.addRecipe(new ItemStack(Block.trapdoor, 2), new Object[]{"PPP", "PPP", 'P', ModBlocks.OrangePlanks});
	        GameRegistry.addRecipe(new ItemStack(Block.workbench), new Object[]{"PP", "PP", 'P', ModBlocks.OrangePlanks});
	        GameRegistry.addRecipe(new ItemStack(Item.bed), new Object[]{"WWW", "PPP", 'W', Block.cloth, 'P', ModBlocks.OrangePlanks});

	        
	        
	        
			
			GameRegistry.addShapelessRecipe(new ItemStack(ModItems.SilverNugget, 9), ModItems.SilverIngot);
			
			
			GameRegistry.addSmelting(ModBlocks.SilverOre.blockID, new ItemStack(ModItems.SilverIngot), 2.0F);
			GameRegistry.addSmelting(ModBlocks.OrangeLog.blockID, new ItemStack(Item.coal, 1, 1), 1.2F);
			GameRegistry.addSmelting(ModItems.Flour.itemID, new ItemStack(Item.bread), 1F);
	}
}
