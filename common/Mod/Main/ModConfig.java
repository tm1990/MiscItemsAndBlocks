package Mod.Main;

import net.minecraftforge.common.Configuration;

public class ModConfig {

	
	
	
	/** Blocks **/ 
	public static int XpStorageBlock;
	public static int Bins;
	public static int Shelf;
	public static int Trap;
	public static int SilverOre;
	
	/** Items **/
	public static int XpExtractor;
	public static int SilverIngot;
	public static int SilverNugget;
	public static int SilverSword;
	public static int SilverBow;
	public static int SilverArrow;
	
	/** Booleans **/
	public static boolean BlastProofOverRe;
	
	
	public static int XpStorageGuiId = 1;
	public static int BinGuiId = 2;
	public static int ShelfGuiId = 3;
	
	
	
	
	
	
	
	
	public static void Init(Configuration config){
		
        config.load();
		
		XpStorageBlock = config.getBlock("Blocks","Xp Storage Block Id", 600).getInt();
		Bins = config.getBlock("Blocks","Trash Bin Block Id", 601).getInt();
		Shelf = config.getBlock("Blocks","Shelf Block Id", 602).getInt();
		Trap = config.getBlock("Blocks","Disarm Trap Block Id", 603).getInt();
		SilverOre = config.getBlock("Blocks", "Silver Ore Id", 604).getInt();
		
        XpExtractor = config.getItem("Items","Xp Extractor Id", 22000).getInt();
        SilverIngot = config.getItem("Items", "Silver Ingot Id", 22001).getInt();
        SilverNugget = config.getItem("Items", "Silver Nugget Id", 22002).getInt();
        SilverSword = config.getItem("Items", "Silver Sword Id", 22003).getInt();
        SilverArrow = config.getItem("Items", "Silver Arrow Id", 22004).getInt();
        SilverBow = config.getItem("Items", "Silver Bow Id", 22005).getInt();
        
		
        
        config.save();
		
	}
	
	
}
