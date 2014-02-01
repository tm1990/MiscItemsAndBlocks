package Mod.Lib;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.ShapedOreRecipe;
import Mod.Block.ModBlocks;
import Mod.Items.ModItems;
import cpw.mods.fml.common.registry.GameRegistry;

public class Crafting {

	
	
	public static void RegisterRecipes(){
		
		
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.DiceHolder), new Object[]{ModBlocks.ItemPedestal, ModBlocks.Dice});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.DataChip, 2), new Object[]{"CCC", "CGC", "III", 'C', ModItems.Cardboard, 'G', new ItemStack(ModItems.Circuit, 1, 0), 'I', Item.ingotIron});
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.Teleporter), new Object[]{"HCH", "BEB", "HCH", 'H', new ItemStack(ModItems.IronPlate, 1, 2), 'C', new ItemStack(ModItems.Circuit, 1, 1), 'B', new ItemStack(ModItems.AdvancedBattery, 1, 0), 'E', Item.enderPearl});
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.WireLessRedstone, 2), new Object[]{"IEI", "ERE", "ICI", 'I', new ItemStack(ModItems.IronPlate, 1, 0), 'E', Item.enderPearl, 'R', Block.blockRedstone, 'C', new ItemStack(ModItems.Circuit, 1, 1)});
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.WirelessItemTrans, 2), new Object[]{"POP", "CEC", "POP", 'P', new ItemStack(ModItems.IronPlate, 1, 2), 'O', Block.obsidian, 'C', new ItemStack(ModItems.Circuit, 1, 1), 'E', Item.enderPearl});
		
		
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.SilverBlock), new Object[]{"SSS", "SSS", "SSS", 'S', ModItems.SilverIngot});
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.SilverIngot, 9), new Object[]{ModBlocks.SilverBlock});
		
		
		GameRegistry.addRecipe(new ItemStack(ModBlocks.Computer), new Object[]{"IBI", "PCB", "IBT", 'I', Item.ingotIron, 'B', Block.blockIron, 'P', Block.thinGlass, 'C', new ItemStack(ModItems.Circuit, 1, 1), 'R', Item.redstone, 'T', Block.blockRedstone});
		GameRegistry.addRecipe(new ItemStack(ModBlocks.StorageBlock), new Object[]{"ICI", "CBC", "ICI", 'I', Block.blockIron, 'C', Block.chest, 'B', ModBlocks.Box});
		
        GameRegistry.addRecipe(new ShapedOreRecipe(ModBlocks.CraftingInv, new Object[] {"WWW", "PIP", "PCP", 'W', Block.cloth, Character.valueOf('P'), "plankWood", 'C', Block.chest, 'I', Block.workbench}));
		GameRegistry.addRecipe(new ShapedOreRecipe(ModBlocks.Dice, new Object[]{"PPP", "PDP", "PPP", Character.valueOf('P'), "plankWood", 'D', Item.dyePowder}));
		GameRegistry.addRecipe(new ShapedOreRecipe(ModBlocks.Table, new Object[]{"CCC", "HHH", "P P", 'C', new ItemStack(Block.carpet, 1, 14), Character.valueOf('P'), "plankWood", Character.valueOf('H'), "slabWood"}));	
		GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.Turbine, new Object[]{"S S", " P ", "S S", 'S', Item.stick, Character.valueOf('P'), "plankWood"}));

		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.OneWayGlass, 8), new Object[]{"SSS", "GES", "SSS", 'S', Block.stone, 'G', Block.glass, 'E', Item.enderPearl});
		
			GameRegistry.addShapedRecipe(new ItemStack(ModItems.XpExtractor), new Object[] {" D ", "IGI", "IGI", 'I', Item.ingotIron, 'G', Block.glass, 'D', Item.diamond});
			GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.XpStorage), new Object[] {"BIB", "IEI", "BIB", 'I', Block.obsidian, 'B', Block.blockIron, 'E', ModItems.XpExtractor});
	        GameRegistry.addShapedRecipe(new ItemStack(ModItems.SilverIngot), new Object[] {"NNN", "NNN", "NNN", 'N', ModItems.SilverNugget});
			GameRegistry.addShapedRecipe(new ItemStack(ModItems.SilverSword), new Object[] {" I ", " I ", " S ", 'I', ModItems.SilverIngot, 'S', Item.stick});
			GameRegistry.addShapedRecipe(new ItemStack(ModItems.SilverBow), new Object[] {" IS", "I S", " IS", 'I', ModItems.SilverIngot, 'S', Item.silk});
	        GameRegistry.addShapedRecipe(new ItemStack(ModItems.SilverBow), new Object[] {"SI ", "S I", "SI ", 'I', ModItems.SilverIngot, 'S', Item.silk});
	        GameRegistry.addShapedRecipe(new ItemStack(ModItems.SilverArrow, 8), new Object[] {" N ", " S ", " F ", 'N', ModItems.SilverNugget, 'S', Item.stick, 'F', Item.feather});
			GameRegistry.addRecipe(new ItemStack(ModBlocks.StoneStair, 4), new Object[]{"S  ", "SS ", "SSS", 'S', Block.stone});
			GameRegistry.addRecipe(new ItemStack(ModBlocks.StoneStair, 4), new Object[]{"  S", " SS", "SSS", 'S', Block.stone});
	      
			if(ModConfig.AllowFlightChest)
			GameRegistry.addRecipe(new ItemStack(ModItems.FlightChestPlate), new Object[] {"IFI", "ISI", "III", 'I', ModItems.SilverIngot, 'S', Item.netherStar, 'F', Item.feather});
			
	        GameRegistry.addRecipe(new ItemStack(ModBlocks.DisarmTrap), new Object[] {"IHI", "HPH", "IDI", 'I', Item.ingotIron, 'H', Block.hopperBlock, 'P', Block.pressurePlateIron, 'D', Block.dispenser});
	        GameRegistry.addRecipe(new ItemStack(ModBlocks.Bin), new Object[] {"I I", "IBI", " I ", 'I', Item.ingotIron, 'B', Item.bucketEmpty});
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.Cardboard, 2), new Object[]{Item.paper, Item.paper, Item.paper});
			GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.Box), new Object[]{"CCC", "C C", "CCC", 'C', ModItems.Cardboard});
			GameRegistry.addRecipe(new ItemStack(ModItems.DivingHelmet), new Object[] {"SNS", "SGS", "   ", 'S', ModItems.SilverIngot, 'N', Item.netherStar, 'G', Block.glass});
			GameRegistry.addRecipe(new ItemStack(ModItems.RunningLeggings), new Object[]{"SNS", "S S", "S S", 'S', ModItems.SilverIngot, 'N', Item.netherStar});
			GameRegistry.addRecipe(new ItemStack(ModItems.JumpingBoots), new Object[] {"   ", "S S", "D D", 'D', Item.diamond, 'S', ModItems.SilverIngot});

			GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.PaintBlock, 8), new Object[]{"CCC", "CSC", "CCC", 'C', Block.cloth, 'S', Item.stick});

			GameRegistry.addShapelessRecipe(new ItemStack(ModItems.TomatoSeeds, 4), ModItems.Tomato);
			GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.SpeedBlock, 8), new Object[]{"III", "BDB", "BBB", 'I', Block.ice, 'B', Block.blockIron, 'D', Item.diamond});
			GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.Mill), new Object[]{"CSC", "SPS", "CCC", 'C', Block.cobblestone, 'S', Block.stone, 'P', Block.pistonBase});
			GameRegistry.addShapedRecipe(new ItemStack(ModItems.PizzaBottom), new Object[]{"FFF", 'F', ModItems.Flour});
			GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.Squezer), new Object[]{"CIC", "IPI", "CCC", 'C', Block.cobblestone, 'I', Item.ingotIron, 'P', Block.pistonBase});
			GameRegistry.addShapelessRecipe(new ItemStack(ModItems.Cheese), Item.bucketMilk);
			GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.PizzaOven), new Object[] {"SSS", "SFS", "SSS", 'S', Block.stone, 'F', Block.furnaceIdle});		
			GameRegistry.addShapedRecipe(new ItemStack(ModItems.PaintBrush), new Object[]{"  C", " S ", "S  ", 'C', Block.cloth, 'S', Item.stick});
			
			GameRegistry.addShapelessRecipe(new ItemStack(ModItems.PaintBrush, 1, 1), new Object[]{new ItemStack(ModItems.PaintBrush, 1, 0), new ItemStack(Item.dyePowder, 1, 1)});
			GameRegistry.addShapelessRecipe(new ItemStack(ModItems.PaintBrush, 1, 2), new Object[]{new ItemStack(ModItems.PaintBrush, 1, 0), new ItemStack(Item.dyePowder, 1, 2)});
			GameRegistry.addShapelessRecipe(new ItemStack(ModItems.PaintBrush, 1, 3), new Object[]{new ItemStack(ModItems.PaintBrush, 1, 0), new ItemStack(Item.dyePowder, 1, 4)});
			
			GameRegistry.addShapedRecipe(new ItemStack(ModItems.PaintBrush, 1, 4), new Object[]{" R ", "GPB", " F ", 'R', new ItemStack(ModItems.PaintBrush, 1, 1 ), 'G', new ItemStack(ModItems.PaintBrush, 1, 2 ), 'B', new ItemStack(ModItems.PaintBrush, 1, 3 ), 'P', Item.paper, 'F', new ItemStack(ModItems.PaintBrush, 1, 0)});
			GameRegistry.addShapedRecipe(new ItemStack(ModItems.PaintBrush, 1, 5), new Object[]{" R ", "GPB", " F ", 'R', new ItemStack(ModItems.PaintBrush, 1, 1 ), 'G', new ItemStack(ModItems.PaintBrush, 1, 2 ), 'B', new ItemStack(ModItems.PaintBrush, 1, 3 ), 'P', Item.paper, 'F', new ItemStack(ModItems.PaintBrush, 1, 4)});
			
			
			GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.MachinePart), new Object[]{"PPP", "P P", "PPP", 'P', new ItemStack(ModItems.IronPlate, 1, 0)});
			GameRegistry.addShapedRecipe(new ItemStack(ModItems.IronPlate, 2, 0), new Object[]{"II", "II", 'I', Item.ingotIron});
			GameRegistry.addShapedRecipe(new ItemStack(ModItems.IronPlate, 1, 2), new Object[]{"II", "II", 'I', new ItemStack(ModItems.IronPlate, 1, 1)});
			
		
			GameRegistry.addShapedRecipe(new ItemStack(ModItems.Wrench), new Object[]{"P P", " P ", " P ", 'P', new ItemStack(ModItems.IronPlate, 1, 0)});
			
			GameRegistry.addShapedRecipe(new ItemStack(ModItems.Upgrades, 1, 0), new Object[]{"PPP", "BBB", "PPP", 'P', new ItemStack(ModItems.IronPlate, 1, 2), 'B', ModItems.BigBattery});
			
            GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.ItemPedestal, 2), new Object[]{"I I", " S ", "SSS", 'I', Item.ingotIron, 'S', Block.stone});
			GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.MiningChamber), new Object[]{"ICI", "IMI", " P ", 'I', new ItemStack(ModItems.IronPlate, 1, 2), 'P', Item.pickaxeDiamond, 'C', new ItemStack(ModItems.Circuit, 1, 1), 'M', ModBlocks.MachinePart});
			
			GameRegistry.addShapedRecipe(new ItemStack(ModItems.Drill), new Object[]{"DD ", "DSI", " IP", 'D', Item.diamond, 'P', ModItems.Battery, 'I', new ItemStack(ModItems.IronPlate, 1, 0), 'S', new ItemStack(ModItems.Circuit, 1, 0)});
			GameRegistry.addShapedRecipe(new ItemStack(ModItems.HeatDrill), new Object[]{"CFP", "FDF", "PFK", 'C', new ItemStack(ModItems.Circuit, 1, 1), 'F', Item.fireballCharge, 'D', ModItems.Drill, 'K', Block.furnaceIdle, 'P', new ItemStack(ModItems.IronPlate, 1, 2)});
		
			
			GameRegistry.addShapedRecipe(new ItemStack(ModItems.Battery, 1, 16), new Object[]{" C ", "IRI", "IRI", 'C', new ItemStack(ModItems.Circuit, 1, 0), 'I', new ItemStack(ModItems.IronPlate, 1, 0), 'R', Item.redstone});
			
			GameRegistry.addShapedRecipe(new ItemStack(ModItems.BigBattery, 1, 32), new Object[]{"BCB", 'B', new ItemStack(ModItems.Battery, 1, 16), 'C', new ItemStack(ModItems.Circuit, 1, 1)});
			GameRegistry.addShapedRecipe(new ItemStack(ModItems.BigBattery, 1, 0), new Object[]{"BCB", 'B', new ItemStack(ModItems.Battery, 1, 0), 'C', new ItemStack(ModItems.Circuit, 1, 1)});
			
			GameRegistry.addShapedRecipe(new ItemStack(ModItems.AdvancedBattery, 1, 64), new Object[]{"BCB", 'B', new ItemStack(ModItems.BigBattery, 1, 32), 'C', new ItemStack(ModItems.Circuit, 1, 1)});
			GameRegistry.addShapedRecipe(new ItemStack(ModItems.AdvancedBattery, 1, 0), new Object[]{"BCB", 'B', new ItemStack(ModItems.BigBattery, 1, 0), 'C', new ItemStack(ModItems.Circuit, 1, 1)});
			
			GameRegistry.addShapedRecipe(new ItemStack(ModItems.ElectricShears), new Object[]{"ISI", "IBI", "ICI", 'I', new ItemStack(ModItems.IronPlate, 1, 0), 'S', Item.shears, 'B', ModItems.Battery, 'C', new ItemStack(ModItems.Circuit, 1, 0)});
			GameRegistry.addShapedRecipe(new ItemStack(ModItems.ElectricBow), new Object[]{" IS", "ICB", " IS", 'I', new ItemStack(ModItems.IronPlate, 1, 0), 'S', Item.silk, 'C', new ItemStack(ModItems.Circuit), 'B', ModItems.Battery});
			
			GameRegistry.addShapedRecipe(new ItemStack(ModItems.Circuit, 1, 1), new Object[]{"IGI", "RCR", "IGI", 'I', new ItemStack(Item.dyePowder, 1, 4), 'C', new ItemStack(ModItems.Circuit, 1, 0), 'R', Item.redstone, 'G', Item.glowstone});
			GameRegistry.addShapedRecipe(new ItemStack(ModItems.Circuit, 1, 0), new Object[]{"WIW", "IRI", "WIW", 'W', ModItems.Cardboard, 'I', new ItemStack(ModItems.IronPlate, 1, 0), 'R', Item.redstone});
			GameRegistry.addShapedRecipe(new ItemStack(ModItems.ModuleConnecter), new Object[]{"III", "ICI", "III", 'I', new ItemStack(ModItems.IronPlate, 1, 0), 'C', new ItemStack(ModItems.Circuit, 1, 0)});
			GameRegistry.addShapedRecipe(new ItemStack(ModItems.SolarCells), new Object[]{"IGI", "GCG", "IGI", 'I', new ItemStack(ModItems.IronPlate, 1, 0), 'G', Block.glass, 'C', new ItemStack(ModItems.Circuit, 1, 0)});
			
			GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.Charger), new Object[]{"ICI", "RMR", "IRI", 'I', new ItemStack(ModItems.IronPlate, 1, 2), 'R', new ItemStack(ModItems.Battery, 1, 16), 'C', new ItemStack(ModItems.Circuit, 1, 0), 'M', ModBlocks.MachinePart});
			GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.SolarPanel), new Object[]{"IGI", "GMG", "ICI", 'I', new ItemStack(ModItems.IronPlate, 1, 2), 'G', ModItems.SolarCells, 'C', new ItemStack(ModItems.Circuit, 1, 1), 'M', ModBlocks.MachinePart});
			GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.WindMill), new Object[]{"III", "SMS", "ICI", 'I', new ItemStack(ModItems.IronPlate, 1, 2), 'S', ModItems.Turbine, 'C', new ItemStack(ModItems.Circuit, 1, 0), 'M', ModBlocks.MachinePart});
			GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.Generator), new Object[]{"III", "FMF", "ICI", 'I', new ItemStack(ModItems.IronPlate, 1, 2), 'C', new ItemStack(ModItems.Circuit, 1, 0), 'M', ModBlocks.MachinePart, 'F', Block.furnaceIdle});
			GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.PowerCable, 32), new Object[]{"IGI", "RDR", "IGI", 'I', new ItemStack(ModItems.IronPlate, 1, 2), 'G', new ItemStack(ModItems.Circuit, 1, 1), 'R', ModItems.ModuleConnecter, 'D', new ItemStack(ModItems.BigBattery, 1, 32)});
			GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.PowerCable, 48), new Object[]{"IGI", "RDR", "IGI", 'I', new ItemStack(ModItems.IronPlate, 1, 2), 'G', new ItemStack(ModItems.Circuit, 1, 1), 'R', ModItems.ModuleConnecter, 'D', new ItemStack(ModItems.BigBattery, 1, 0)});
			
			GameRegistry.addShapedRecipe(new ItemStack(ModItems.FloatBlockPlacer), new Object[]{"GDP", "DRC", "PCB", 'G', Block.glass, 'D', Item.diamond, 'P', new ItemStack(ModItems.IronPlate, 1, 2), 'R', Block.blockRedstone, 'C', new ItemStack(ModItems.Circuit, 1, 1), 'B', new ItemStack(ModItems.AdvancedBattery, 1, 0)});
			GameRegistry.addShapedRecipe(new ItemStack(ModItems.AntiFallChestPlate), new Object[]{"PUP", "FCF", "PBP", 'P', new ItemStack(ModItems.IronPlate, 1, 2), 'U', new ItemStack(ModItems.Upgrades, 1, 0), 'F', ModItems.FloatBlockPlacer, 'C', Item.plateIron, 'B', new ItemStack(ModItems.AdvancedBattery, 1, 0)});
			GameRegistry.addShapedRecipe(new ItemStack(ModItems.InfoScreenHelmet), new Object[]{"IIP", "GCB", "IIP", 'I', new ItemStack(ModItems.IronPlate, 1 ,0), 'P', new ItemStack(ModItems.IronPlate, 1, 2), 'G', Block.thinGlass, 'C', new ItemStack(ModItems.Circuit, 1, 1), 'B', new ItemStack(ModItems.Battery, 1, 0)});
			
			
			
			GameRegistry.addShapedRecipe(new ItemStack(Item.saddle), new Object[]{"LLL", "LSL", " I ", 'L', Item.leather, 'S', Item.silk, 'I', Item.ingotIron});
			
	        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.Pillar, 4), new Object[]{"QQQ", " Q ", "QQQ", 'Q', Block.blockNetherQuartz});

	        GameRegistry.addRecipe(new ItemStack(ModBlocks.ElectricFurnace), new Object[]{"PMP", "PFP", "PCP", 'P', new ItemStack(ModItems.IronPlate, 1, 2), 'M', ModBlocks.MachinePart, 'F', Block.furnaceIdle, 'C', new ItemStack(ModItems.Circuit, 1, 1)});
	        
	        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.GamePart, 4), new Object[]{"III", " I ", "III", 'I', Item.ingotIron});
	        
	        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.GamePart, 1, 1), new Object[]{new ItemStack(Item.dyePowder, 1, 1), ModBlocks.GamePart});
	        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.GamePart, 1, 2), new Object[]{new ItemStack(Item.dyePowder, 1, 4), ModBlocks.GamePart});
	        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.GamePart, 1, 3), new Object[]{new ItemStack(Item.dyePowder, 1, 2), ModBlocks.GamePart});
	        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.GamePart, 1, 4), new Object[]{new ItemStack(Item.dyePowder, 1, 11), ModBlocks.GamePart});

	        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.PizzaRaw), ModItems.Cheese, ModItems.PizzaBottom, new ItemStack(ModItems.Liquid, 1, 1), Item.fishCooked);
	        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.PizzaRaw, 1, 1), ModItems.Cheese, ModItems.PizzaBottom, new ItemStack(ModItems.Liquid, 1, 1), Item.porkCooked);
	        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.PizzaRaw, 1, 2), ModItems.Cheese, ModItems.PizzaBottom, new ItemStack(ModItems.Liquid, 1, 1), Item.beefCooked);
	        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.PizzaRaw, 1, 3), ModItems.Cheese, ModItems.PizzaBottom, new ItemStack(ModItems.Liquid, 1, 1), Item.chickenCooked);

			
	        
	        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.OrangePlanks, 4), ModBlocks.OrangeLog);

	        
	        
	        
			
			GameRegistry.addShapelessRecipe(new ItemStack(ModItems.SilverNugget, 9), ModItems.SilverIngot);
			
			
			FurnaceRecipes.smelting().addSmelting(ModItems.IronPlate.itemID, 0, new ItemStack(ModItems.IronPlate, 1, 1), 0.1f);
			
			GameRegistry.addSmelting(ModBlocks.SilverOre.blockID, new ItemStack(ModItems.SilverIngot), 2.0F);
			GameRegistry.addSmelting(ModBlocks.OrangeLog.blockID, new ItemStack(Item.coal, 1, 1), 1.2F);
			GameRegistry.addSmelting(ModItems.Flour.itemID, new ItemStack(Item.bread), 1F);
	}
}
