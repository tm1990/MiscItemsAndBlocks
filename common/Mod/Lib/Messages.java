package Mod.Lib;

public class Messages {

	
	public static String[] XpStorageTips = new String[10];
	public static String[] TrashBinTips = new String[10];
	public static String[] WorktableTips = new String[10];
	public static String[] CardboardBoxTipes = new String[10];
	public static String[] ShelfTipes = new String[10];
	public static String[] MillTips = new String[10];
	
	public static void Init(){
		
		XpStorageTips[0] = "This is a Xp Storage block you can store and take xp levels from it at any time";
		XpStorageTips[1] = "You can save levels then earn more quicker";
		XpStorageTips[2] = "Use the XpStored button to check the amount stored in the xp storage block on Multiplayer";
		
		TrashBinTips[0] = "When putting items into the trash bin they get deleted";
		
		WorktableTips[0] = "The worktable will save the crafting grid";
		WorktableTips[1] = "The worktable can use resources from the internal chest";
		
		CardboardBoxTipes[0] = "The cardboard box is a cheaper type of item storage";
		
		ShelfTipes[0] = "The shelf is a block where you can store items for display";
		ShelfTipes[1] = "The shelf is still in a early Work In Progress state";
		
		MillTips[0] = "The mill is used to make flour out of wheat";
		
	}
}
