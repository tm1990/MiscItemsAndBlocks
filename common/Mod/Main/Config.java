package Mod.Main;

import net.minecraftforge.common.Configuration;

public class Config {

	
	
	public static int StartBlockId = 600;
	public static int StartItemId = 22000;
	
	
	/** Blocks **/ 
	public static int XpStorageBlockId;
	public static int BinsId;
	public static int ShelfId;
	public static int TrapId;
	
	/** Items **/
	public static int XpExtractorId;
	public static int ShelfItemId;
	
	/** Booleans **/
	public static boolean BlastProofOverRide;
	
	public static int XpStorageGuiId = 1;
	public static int BinGuiId = 2;
	public static int ShelfGuiId = 3;
	
	
	
	
	
	
	
	
	public static void Init(Configuration config){
		
		XpStorageBlockId = config.get("Blocks","Xp Storage Block ID", StartBlockId).getInt();
		BinsId = config.get("Blocks","Bins Block ID", XpStorageBlockId + 1).getInt();
		ShelfId = config.get("Blocks","Shelf Block ID", BinsId + 1).getInt();
		TrapId = config.get("Blocks","Trap Block ID", ShelfId + 1).getInt();
		
        XpExtractorId = config.get("Items","Xp Extractor ID", StartItemId).getInt();
        ShelfItemId = config.get("Items","Shelf Item ID", XpExtractorId + 1).getInt();
        
        BlastProofOverRide = config.get("Settings","Should use Blast proof craft items : ", false).getBoolean(false);
        
		
		
	}
	
	
}
