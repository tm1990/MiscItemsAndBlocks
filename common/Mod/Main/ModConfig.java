package Mod.Main;

import net.minecraft.block.Block;
import net.minecraftforge.common.Configuration;

public class ModConfig {

	
	public static Configuration configuration;
	
	
	/** Blocks **/ 
	public static int XpStorageBlock;
	public static int Bins;
	public static int Trap;
	public static int SilverOre;
	public static int StoneStair;
	public static int Box;
	public static int CraftingInv;
	public static int Dice;
	public static int SpeedBlock;
	public static int Pillar;
	public static int Mill;
	public static int TomatoPlant;
	public static int Squezer;
	public static int PizzaOven;
	public static int OrangeLog;
	public static int OrangePlanks;
	public static int Table;
	public static int MachinePart;
	public static int TimedBlock;
	
	public static int Computer;
	
	public static int PaintBlock;
	
	public static int ElFurnace;
	
	public static int ItemPedestal;
	public static int MiningChamber;
	
	public static int OneWayGlass;

	
	
	public static int PowerCable;
	public static int Charger;
	public static int SolarPanel;
	public static int WindMill;
	public static int Generator;
	
	public static int OrangeSapling;
	public static int OrangeLeaf;
	
	
	public static int GamePartRed;
	public static int GamePartBlue;
	public static int GamePartYellow;
	public static int GamePartGreen;
	public static int GamePartNull;
	
	/** Items **/
	public static int XpExtractor;
	public static int SilverIngot;
	public static int SilverNugget;
	public static int SilverSword;
	public static int SilverBow;
	public static int SilverArrow;
	public static int Cardboard;
	public static int Tomato;
	public static int Flour;
	public static int TomatoSeeds;
	public static int PizzaBottom;
	public static int Cheese;
	public static int Liquid;
	public static int DisarmStick;
	
	public static int Battery;
	public static int BigBattery;
	public static int AdvancedBattery;
	public static int CreativeBattery;
	
	public static int Drill;
	public static int ElectricShears;
	public static int ElectricBow;
	
	public static int ModuleConnecter;
	public static int Circuit;
	public static int SolarCells;
	public static int Turbine;
	
	public static int Upgrades;
	
	public static int Wrench;
	public static int IronPlate;
	
	public static int HeatDrill;
	
	
	public static int Orange;
	
	public static int PizzaRaw;
	public static int Pizza;
	
	public static int DivingHelmet;
	public static int FlightChestPlate;
	public static int RunningLeggings;
	public static int JumpingBoots;
	
	public static int PaintBrush;
	
	public static int FloatBlockPlacer;
	public static int AntiFallChest;
	public static int InfoScreenHelmet;

	/** Booleans **/
	public static boolean BlastProofOverRe;
	
	public static boolean SpawnParticles;

	

	
	
	
	
	
	
	
	
	public static void Init(Configuration config){
		
		configuration = config;
		
        config.load();
		
		XpStorageBlock = config.getBlock("Blocks","Xp Storage Block Id", 601).getInt();
		Bins = config.getBlock("Blocks","Trash Bin Block Id", 602).getInt();
		Trap = config.getBlock("Blocks","Disarm Trap Block Id", 603).getInt();
		SilverOre = config.getBlock("Blocks", "Silver Ore Id", 604).getInt();
		StoneStair = config.getBlock("Blocks", "Stone Stair Id", 605).getInt();
		Box = config.getBlock("Blocks", "Box Id", 606).getInt();
		CraftingInv = config.getBlock("Blocks", "Crafting table with inv Id", 607).getInt();
		Dice = config.getBlock("Blocks", "Dice Id", 608).getInt();
		
		GamePartRed = config.getBlock("Blocks", "Game piece Red Id", 609).getInt();
		GamePartBlue = config.getBlock("Blocks", "Game piece Blue Id", 610).getInt();
		GamePartGreen = config.getBlock("Blocks", "Game piece Green Id", 611).getInt();
		GamePartYellow = config.getBlock("Blocks", "Game piece Yellow Id", 612).getInt();
		GamePartNull = config.getBlock("Blocks", "Game piece Default Id", 613).getInt();
		
		SpeedBlock = config.getBlock("Blocks", "Speed Block Id", 614).getInt();
		Pillar = config.getBlock("Blocks", "Pillar Block Id", 615).getInt();
		TomatoPlant = config.getBlock("Blocks", "Tomato Plant Block Id", 617).getInt();
		Mill = config.getBlock("Blocks", "Mill Block Id", 618).getInt();
		Squezer = config.getBlock("Blocks", "Squezer Block Id", 619).getInt();
		OrangeSapling = config.getBlock("Blocks", "Orange Sapling Block Id", 620).getInt();
		OrangeLeaf = config.getBlock("Blocks", "Orange Leaf Block Id", 621).getInt();
		PizzaOven = config.getBlock("Blocks", "Oven Block Id", 622).getInt();
		OrangeLog = config.getBlock("Blocks", "Orange Log Block Id", 623).getInt();
		OrangePlanks = config.getBlock("Blocks", "Orange Planks Block Id", 624).getInt();
		
		Charger = config.getBlock("Blocks", "Charger Block Id", 625).getInt();
		SolarPanel = config.getBlock("Blocks", "Solar Panel Block Id", 626).getInt();
		WindMill = config.getBlock("Blocks", "Wind Mill Block Id", 627).getInt();
		Generator = config.getBlock("Blocks", "Generator Block Id", 628).getInt();
		PowerCable = config.getBlock("Blocks", "Power Cable Block Id", 629).getInt();
		
		
		ItemPedestal = config.getBlock("Blocks", "Item Pedestal Block Id", 630).getInt();
		MiningChamber = config.getBlock("Blocks", "Mining Chamber Block Id", 631).getInt();
		
		Table = config.getBlock("Blocks", "Table Block Id", 632).getInt();
		MachinePart = config.getBlock("Blocks", "Machine Part Block Id", 633).getInt();
		
		PaintBlock = config.getBlock("Blocks", "Paint Block Id", 634).getInt();
		ElFurnace = config.getBlock("Blocks", "Electric furance Block Id", 635).getInt();
		TimedBlock = config.getBlock("Blocks", "Timed Block Id", 636).getInt();
		
		OneWayGlass = config.getBlock("Blocks", "One Way Glass Block Id", 637).getInt();
		Computer = config.getBlock("Blocks", "Computer Block Id", 638).getInt();
		
		
		
        XpExtractor = config.getItem("Items","Xp Extractor Id", 22000).getInt();
        SilverIngot = config.getItem("Items", "Silver Ingot Id", 22001).getInt();
        SilverNugget = config.getItem("Items", "Silver Nugget Id", 22002).getInt();
        SilverSword = config.getItem("Items", "Silver Sword Id", 22003).getInt();
        SilverArrow = config.getItem("Items", "Silver Arrow Id", 22004).getInt();
        SilverBow = config.getItem("Items", "Silver Bow Id", 22005).getInt();
        DivingHelmet = config.getItem("Items", "Diving Helmet Id", 22006).getInt();
        FlightChestPlate = config.getItem("Items", "Flight Chest Plate Id", 22007).getInt();
        RunningLeggings = config.getItem("Items", "Running Leggings Id", 22008).getInt();
        JumpingBoots = config.getItem("Items", "Jumping Boots Id", 22009).getInt();
        Cardboard = config.getItem("Items", "Cardboard Id", 22010).getInt();
        Tomato = config.getItem("Items", "Tomato Id", 22012).getInt();
        Flour = config.getItem("Items", "Flour Id", 22013).getInt();
        TomatoSeeds = config.getItem("Items", "Tomato Seeds Id", 22014).getInt();
        PizzaBottom = config.getItem("Items", "Pizza Bottom Id", 22015).getInt();
        Cheese = config.getItem("Items", "Cheese Id", 22016).getInt();
        Liquid = config.getItem("Items", "Liquid Id", 22017).getInt();
        
        PizzaRaw = config.getItem("Items", "PizzaRaw Id", 22018).getInt();
        Pizza = config.getItem("Items", "Pizza Id", 22019).getInt();
        
        Orange = config.getItem("Items", "Orange Id", 22020).getInt();
        DisarmStick = config.getItem("Items", "Disarm stick Id", 22021).getInt();
        Drill = config.getItem("Items", "Drill Id", 22022).getInt();
        
        Circuit = config.getItem("Item", "Circuit Id",  22023).getInt();
        ModuleConnecter = config.getItem("Item", "Module Connecter Id",  22024).getInt();
        SolarCells = config.getItem("Items", "Solar cells Id", 22025).getInt();
        Turbine = config.getItem("Items", "Turbine Id", 22026).getInt();
        
        Battery = config.getItem("Items", "Battery Id", 22027).getInt();
        BigBattery = config.getItem("Items", "Big Battery Id", 22028).getInt();
        AdvancedBattery = config.getItem("Items", "Advanced Battery Id", 22029).getInt();
        
        ElectricShears = config.getItem("Items", "Electric Shears Id", 22030).getInt();
        ElectricBow = config.getItem("Items", "Electric Bow Id", 22031).getInt();
        
        Upgrades = config.getItem("Item", "Upgrades Id", 22032).getInt();
        Wrench = config.getItem("Item", "Wrench Id", 22033).getInt();
        IronPlate = config.getItem("Item", "Iron Plate Id", 22034).getInt();
        HeatDrill = config.getItem("Item", "Heat Drill Id", 22035).getInt();
        PaintBrush = config.getItem("Item", "Paint Brush Id", 22036).getInt();
        FloatBlockPlacer = config.getItem("Item", "Float Block Placer Id", 22037).getInt();
        AntiFallChest = config.getItem("Item", "Anti Fall Chestplate Id", 22038).getInt();
        InfoScreenHelmet = config.getItem("Item", "Info Screen Helmet Id", 22039).getInt();

        
        SpawnParticles = config.get("Settings", "Spawn particles?", true).getBoolean(true);
        
        
        config.save();
		
	}
	
    public static void set(String categoryName, String propertyName, String newValue) {

        configuration.load();
        if (configuration.getCategoryNames().contains(categoryName)) {
            if (configuration.getCategory(categoryName).containsKey(propertyName)) {
                configuration.getCategory(categoryName).get(propertyName).set(newValue);
            }
        }
        configuration.save();
    }
	
	
}
