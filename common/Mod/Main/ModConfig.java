package Mod.Main;

import net.minecraftforge.common.Configuration;

public class ModConfig {

	
	
	
	/** Blocks **/ 
	public static int XpStorageBlock;
	public static int Bins;
	public static int Shelf;
	public static int Trap;
	public static int SilverOre;
	public static int StoneStair;
	public static int Box;
	public static int CraftingInv;
	
	/** Items **/
	public static int XpExtractor;
	public static int SilverIngot;
	public static int SilverNugget;
	public static int SilverSword;
	public static int SilverBow;
	public static int SilverArrow;
	public static int Cardboard;
	public static int CraftingUpgrade;
	
	public static int DivingHelmet;
	public static int FlightChestPlate;
	public static int RunningLeggings;
	public static int JumpingBoots;

	/** Booleans **/
	public static boolean BlastProofOverRe;
	
	
	public static int XpStorageGuiId = 1;
	public static int BinGuiId = 2;
	public static int ShelfGuiId = 3;
	public static int BoxGuiId = 4;
	public static int CraftingInvGuiId = 5;
	
	
	
	
	
	
	
	
	public static void Init(Configuration config){
		
        config.load();
		
		XpStorageBlock = config.getBlock("Blocks","Xp Storage Block Id", 600).getInt();
		Bins = config.getBlock("Blocks","Trash Bin Block Id", 601).getInt();
		Shelf = config.getBlock("Blocks","Shelf Block Id", 602).getInt();
		Trap = config.getBlock("Blocks","Disarm Trap Block Id", 603).getInt();
		SilverOre = config.getBlock("Blocks", "Silver Ore Id", 604).getInt();
		StoneStair = config.getBlock("Blocks", "Stone Stair Id", 605).getInt();
		Box = config.getBlock("Blocks", "Box Id", 606).getInt();
		CraftingInv = config.getBlock("Blocks", "Crafting table with inv Id", 607).getInt();
		
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
        CraftingUpgrade = config.getItem("Items", "CraftingTable Chest Upgrade Id", 22011).getInt();
		
        
        config.save();
		
	}
	
	
}
