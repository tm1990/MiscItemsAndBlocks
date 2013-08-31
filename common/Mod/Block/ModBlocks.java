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
	
	public static Block GamePartRed;
	public static Block GamePartBlue;
	public static Block GamePartGreen;
	public static Block GamePartYellow;
	public static Block GamePartNull;
	
	
	public static ModBlockStair StoneStair;
	
	
	
	public static void Init(){
		
		XpStorage = new ModBlockXpStorage(ModConfig.XpStorageBlock);
		Register(XpStorage, "Xp Storage Block");
		
		Bin = new ModBlockBin(ModConfig.Bins);
		Register(Bin, "Trash Bin");
		
		Shelf = new ModBlockShelf(ModConfig.Shelf);
	    Register(Shelf, "Shelf"); 
		
		DisarmTrap = new ModBlockDisarmTrap(ModConfig.Trap);
		Register(DisarmTrap, "Disarm Trap");
		
		SilverOre = new ModBlockSilverOre(ModConfig.SilverOre);
		Register(SilverOre, "Silver Ore");
        RegisterHarvestLevel(SilverOre, "pickaxe", 3);

        StoneStair = new ModBlockStair(ModConfig.StoneStair, Block.stone, 0, "StoneStair");
        Register(StoneStair, "Stone Stair");
        
        Box = new ModBlockBox(ModConfig.Box);
        Register(Box, "Cardboard Box");
        
        CraftingInv = new ModBlockCraftingInv(ModConfig.CraftingInv);
        Register(CraftingInv, "Worktable");
        
        Dice = new ModBlockDice(ModConfig.Dice).setUnlocalizedName("Dice");
        Register(Dice, "Dice");
        
        SpeedBlock = new ModBlockSpeedBlock(ModConfig.SpeedBlock).setUnlocalizedName("SpeedBlock");
        Register(SpeedBlock, "Speed Block");
        
        GamePartRed = new ModBlockGamePart(ModConfig.GamePartRed, "Red").setUnlocalizedName("GamePieceRed");
        Register(GamePartRed, "Game Piece [Red]");
        
        GamePartBlue = new ModBlockGamePart(ModConfig.GamePartBlue, "Blue").setUnlocalizedName("GamePieceBlue");
        Register(GamePartBlue, "Game Piece [Blue]");
        
        GamePartGreen = new ModBlockGamePart(ModConfig.GamePartGreen, "Green").setUnlocalizedName("GamePieceGreen");
        Register(GamePartGreen, "Game Piece [Green]");
        
        GamePartYellow = new ModBlockGamePart(ModConfig.GamePartYellow, "Yellow").setUnlocalizedName("GamePieceYellow");
        Register(GamePartYellow, "Game Piece [Yellow]");
        
        GamePartNull = new ModBlockGamePart(ModConfig.GamePartNull, "").setUnlocalizedName("GamePieceNull");
        Register(GamePartNull, "Game Piece [Default]");
        
        Pillar = new ModBlockPillar(ModConfig.Pillar).setUnlocalizedName("Pillar");
        Register(Pillar, "Pillar");

        
		RegisterOreDictionary(new ItemStack(SilverOre), "oreSilver");
		
		RegisterHarvestLevel(Box, "axe", 1);
		
		
		
		
	}
	
	
	
	
	  public static void RegisterHarvestLevel(Block block, String tool, int Level){
	    	

	    	MinecraftForge.setBlockHarvestLevel(block, tool, Level);
	    }
	    
		public static void Register(Block Block, String Name){
			
			
	        LanguageRegistry.addName(Block, Name);
	        if(Name.contains(" ")){
		        GameRegistry.registerBlock(Block, Name.toLowerCase().replace(" ", ""));
	        }else{
		        GameRegistry.registerBlock(Block, Name.toLowerCase());
	        }
	        
	        Block.setCreativeTab(Main.CreativeTab);

		}
		
		public static void RegisterOreDictionary(ItemStack Block, String dictonaryName){
			
			OreDictionary.registerOre(dictonaryName, Block);
			
		}
}

