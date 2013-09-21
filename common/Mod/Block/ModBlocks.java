package Mod.Block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import Mod.GamePart.ModBlockGamePart;
import Mod.Main.Main;
import Mod.Main.ModConfig;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModBlocks {

	
	
	public static Block XpStorage;
	public static Block Bin;
	public static Block Shelf;
	public static Block DisarmTrap;
	public static Block SilverOre;
	public static Block Box;
	public static Block CraftingInv;
	public static Block Dice;
	public static Block SpeedBlock;
	public static Block Pillar;
	public static Block SidewaysPillar;
	public static Block TomatoPlant;
	public static Block Mill;
	public static Block Squezer;
	public static Block OrangeSapling;
	public static Block OrangeLeaf;
	public static Block PizzaOven;
	public static Block OrangeLog;
	public static Block OrangePlanks;
	
	public static Block GamePartRed;
	public static Block GamePartBlue;
	public static Block GamePartGreen;
	public static Block GamePartYellow;
	public static Block GamePartNull;
	
	
	public static ModBlockStair StoneStair;
	
	
	
	public static void Init(){
		
		XpStorage = new ModBlockXpStorage(ModConfig.XpStorageBlock).setUnlocalizedName("XpStorage");
		Register(XpStorage, "Xp Storage Block", true);
		
		Bin = new ModBlockBin(ModConfig.Bins).setUnlocalizedName("TrashBin");
		Register(Bin, "Trash Bin", true);
		
		Shelf = new ModBlockShelf(ModConfig.Shelf).setUnlocalizedName("Shelf");
	    Register(Shelf, "Shelf", true); 
		
		DisarmTrap = new ModBlockDisarmTrap(ModConfig.Trap).setUnlocalizedName("DisamrTrap");
		Register(DisarmTrap, "Disarm Trap", true);
		
		SilverOre = new ModBlockSilverOre(ModConfig.SilverOre).setUnlocalizedName("SilverPre");
		Register(SilverOre, "Silver Ore", true);
        RegisterHarvestLevel(SilverOre, "pickaxe", 3);

        StoneStair = new ModBlockStair(ModConfig.StoneStair, Block.stone, 0, "StoneStair");
        Register(StoneStair, "Stone Stair", true);
        
        Box = new ModBlockBox(ModConfig.Box).setUnlocalizedName("Box");
        Register(Box, "Cardboard Box", true);
        
        CraftingInv = new ModBlockCraftingInv(ModConfig.CraftingInv).setUnlocalizedName("CraftingInv");
        Register(CraftingInv, "Worktable", true);
        
        Dice = new ModBlockDice(ModConfig.Dice).setUnlocalizedName("Dice");
        Register(Dice, "Dice", true);
        
        SpeedBlock = new ModBlockSpeedBlock(ModConfig.SpeedBlock).setUnlocalizedName("SpeedBlock");
        Register(SpeedBlock, "Speed Block", true);
        
        GamePartRed = new ModBlockGamePart(ModConfig.GamePartRed, "Red").setUnlocalizedName("GamePieceRed");
        Register(GamePartRed, "Game Piece [Red]", true);
        
        GamePartBlue = new ModBlockGamePart(ModConfig.GamePartBlue, "Blue").setUnlocalizedName("GamePieceBlue");
        Register(GamePartBlue, "Game Piece [Blue]", true);
        
        GamePartGreen = new ModBlockGamePart(ModConfig.GamePartGreen, "Green").setUnlocalizedName("GamePieceGreen");
        Register(GamePartGreen, "Game Piece [Green]", true);
        
        GamePartYellow = new ModBlockGamePart(ModConfig.GamePartYellow, "Yellow").setUnlocalizedName("GamePieceYellow");
        Register(GamePartYellow, "Game Piece [Yellow]", true);
        
        GamePartNull = new ModBlockGamePart(ModConfig.GamePartNull, "").setUnlocalizedName("GamePieceNull");
        Register(GamePartNull, "Game Piece [Default]", true);
        
        Pillar = new ModBlockPillar(ModConfig.Pillar).setUnlocalizedName("Pillar");
        Register(Pillar, "Pillar", true);
        
        SidewaysPillar = new ModBlockSidewaysPillar(ModConfig.SidewaysPillar).setUnlocalizedName("SidewaysPillar");
        Register(SidewaysPillar, "Sideways Pillar", true);
        
        TomatoPlant = new ModBlockTomatoPlant(ModConfig.TomatoPlant).setUnlocalizedName("TomatoPlant");
        Register(TomatoPlant, "Tomato Plant", false);

        Mill = new ModBlockMill(ModConfig.Mill).setUnlocalizedName("Mill");
        Register(Mill, "Mill", true);

        Squezer = new ModBlockSquezer(ModConfig.Squezer).setUnlocalizedName("Squezer");
        Register(Squezer, "Squezer", true);
        
        OrangeLeaf = new ModBlockOrangeLeaf(ModConfig.OrangeLeaf).setUnlocalizedName("OrangeLeaf");
        Register(OrangeLeaf, "Orange Leaves", true);
        
        OrangeSapling = new ModBlockOrangeSapling(ModConfig.OrangeSapling).setUnlocalizedName("OrangeSapling");
        Register(OrangeSapling, "Orange Sapling", true);
        
        
        //Renamed to Oven
        PizzaOven = new ModBlockOvenCore(ModConfig.PizzaOven).setUnlocalizedName("PizzaOven");
        Register(PizzaOven, "Oven", true);
        
        OrangeLog = new ModBlockOrangeLog(ModConfig.OrangeLog).setUnlocalizedName("OrangeLog");
        Register(OrangeLog, "Orange Tree Wood", true);
        
        OrangePlanks = new ModBlockOrangePlanks(ModConfig.OrangePlanks).setUnlocalizedName("OrangePlanks");
        Register(OrangePlanks, "Orange Tree Planks", true);
        
        
        
        
        
		RegisterOreDictionary(new ItemStack(SilverOre), "oreSilver");
		RegisterOreDictionary(new ItemStack(OrangeLog), "log");
		RegisterOreDictionary(new ItemStack(OrangePlanks), "planks");
		
		RegisterHarvestLevel(Box, "axe", 1);
		
		
		
		
	}
	
	
	
	
	  public static void RegisterHarvestLevel(Block block, String tool, int Level){
	    	

	    	MinecraftForge.setBlockHarvestLevel(block, tool, Level);
	    }
	    
		public static void Register(Block Block, String Name, boolean AddTab){
			
			
	        LanguageRegistry.addName(Block, Name);
	        if(Name.contains(" ")){
		        GameRegistry.registerBlock(Block, Name.toLowerCase().replace(" ", ""));
	        }else{
		        GameRegistry.registerBlock(Block, Name.toLowerCase());
	        }
	        
	        if(AddTab)
	        Block.setCreativeTab(Main.CreativeTab);

		}
		
		public static void RegisterOreDictionary(ItemStack Block, String dictonaryName){
			
			OreDictionary.registerOre(dictonaryName, Block);
			
		}
}

