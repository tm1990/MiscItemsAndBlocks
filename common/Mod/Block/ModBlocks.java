package Mod.Block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import Mod.GamePart.ModBlockGamePart;
import Mod.ItemBlock.ModItemBlockDisarmTrap;
import Mod.ItemBlock.ModItemBlockGamePiece;
import Mod.ItemBlock.ModItemBlockItemPedestal;
import Mod.ItemBlock.ModItemBlockMiningChamber;
import Mod.ItemBlock.ModItemBlockPowerCable;
import Mod.ItemBlock.ModItemBlockTable;
import Mod.ItemBlock.ModItemBlockTrashBin;
import Mod.Main.Main;
import Mod.Main.ModConfig;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModBlocks {

	
	
	public static Block XpStorage;
	public static Block Bin;
	public static Block DisarmTrap;
	public static Block SilverOre;
	public static Block Box;
	public static Block CraftingInv;
	public static Block Dice;
	public static Block SpeedBlock;
	public static Block Pillar;
	public static Block TomatoPlant;
	public static Block Mill;
	public static Block Squezer;
	public static Block OrangeSapling;
	public static Block OrangeLeaf;
	public static Block PizzaOven;
	public static Block OrangeLog;
	public static Block OrangePlanks;
	public static Block Table;
	public static Block TimedBlock;
	
	public static Block PaintBlock;
	
	public static Block ElectricFurnace;
	
	public static Block ItemPedestal;
	public static Block MiningChamber;
	
	public static Block PowerCable;
	public static Block Charger;
	public static Block SolarPanel;
	public static Block WindMill;
	public static Block Generator;
	
	public static Block MachinePart;

	
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
		Register(Bin, ModItemBlockTrashBin.class,"Trash Bin", true);
		
		DisarmTrap = new ModBlockDisarmTrap(ModConfig.Trap).setUnlocalizedName("DisamrTrap");
		Register(DisarmTrap, ModItemBlockDisarmTrap.class,"Disarm Trap", true);
		
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
        Register(GamePartRed, ModItemBlockGamePiece.class, "Game Piece [Red]", true);
        
        GamePartBlue = new ModBlockGamePart(ModConfig.GamePartBlue, "Blue").setUnlocalizedName("GamePieceBlue");
        Register(GamePartBlue, ModItemBlockGamePiece.class,"Game Piece [Blue]", true);
        
        GamePartGreen = new ModBlockGamePart(ModConfig.GamePartGreen, "Green").setUnlocalizedName("GamePieceGreen");
        Register(GamePartGreen, ModItemBlockGamePiece.class, "Game Piece [Green]", true);
        
        GamePartYellow = new ModBlockGamePart(ModConfig.GamePartYellow, "Yellow").setUnlocalizedName("GamePieceYellow");
        Register(GamePartYellow, ModItemBlockGamePiece.class, "Game Piece [Yellow]", true);
        
        GamePartNull = new ModBlockGamePart(ModConfig.GamePartNull, "").setUnlocalizedName("GamePieceNull");
        Register(GamePartNull, ModItemBlockGamePiece.class, "Game Piece [Default]", true);
        
        Pillar = new ModBlockPillar(ModConfig.Pillar).setUnlocalizedName("Pillar");
        Register(Pillar, ModItemBlockPillar.class,"Pillar", true);
        
        TomatoPlant = new ModBlockTomatoPlant(ModConfig.TomatoPlant).setUnlocalizedName("TomatoPlant");
        Register(TomatoPlant, "Tomato Plant", false);

        Mill = new ModBlockMill(ModConfig.Mill).setUnlocalizedName("Mill");
        Register(Mill, "Mill", true);

        Squezer = new ModBlockSquezer(ModConfig.Squezer).setUnlocalizedName("Squezer");
        Register(Squezer, "Squeezer", true);
        
        OrangeLeaf = new ModBlockOrangeLeaf(ModConfig.OrangeLeaf).setUnlocalizedName("OrangeLeaf");
        Register(OrangeLeaf, "Orange Tree Leaves", true);
        
        OrangeSapling = new ModBlockOrangeSapling(ModConfig.OrangeSapling).setUnlocalizedName("OrangeSapling");
        Register(OrangeSapling, "Orange Tree Sapling", true);
        
        
        //Renamed to Oven
        PizzaOven = new ModBlockOvenCore(ModConfig.PizzaOven).setUnlocalizedName("PizzaOven");
        Register(PizzaOven, "Oven", true);
        
        OrangeLog = new ModBlockOrangeLog(ModConfig.OrangeLog).setUnlocalizedName("OrangeLog");
        Register(OrangeLog, "Orange Tree Wood", true);
        
        OrangePlanks = new ModBlockOrangePlanks(ModConfig.OrangePlanks).setUnlocalizedName("OrangePlanks");
        Register(OrangePlanks, "Orange Tree Planks", true);
        
        Charger = new ModBlockCharger(ModConfig.Charger).setUnlocalizedName("Charger");
        Register(Charger, "Charger", true);
        
        SolarPanel = new ModBlockSolarPanel(ModConfig.SolarPanel).setUnlocalizedName("SolarPanel");
        Register(SolarPanel, "Solar Panel", true);
        
        WindMill = new ModBlockWindMill(ModConfig.WindMill).setUnlocalizedName("WindMill");
        Register(WindMill, "Wind Mill", true);
        
        Generator = new ModBlockGenerator(ModConfig.Generator).setUnlocalizedName("Generator");
        Register(Generator, "Coal Generator", true);
        
        PowerCable = new ModBlockPowerCable(ModConfig.PowerCable).setUnlocalizedName("PowerCable").setCreativeTab(Main.CreativeTab);
        Register(PowerCable, ModItemBlockPowerCable.class, "Power Cable", true);
        
        
        ItemPedestal = new ModBlockItemPedestal(ModConfig.ItemPedestal).setUnlocalizedName("ItemPedestal").setCreativeTab(Main.CreativeTab);
        Register(ItemPedestal, ModItemBlockItemPedestal.class, "Item Pedestal", true);
        
        MiningChamber = new ModBlockMiningChamber(ModConfig.MiningChamber).setUnlocalizedName("MiningChamber").setCreativeTab(Main.CreativeTab);
        Register(MiningChamber, ModItemBlockMiningChamber.class, "Mining Station", true);
        
        Table = new ModBlockTable(ModConfig.Table).setUnlocalizedName("Table");
        Register(Table, ModItemBlockTable.class ,"Table", true);
        
        MachinePart = new ModBlockMachinePart(ModConfig.MachinePart).setUnlocalizedName("MachinePart");
        Register(MachinePart, "Machine Part", true);
        
        PaintBlock = new ModBlockPaintBlock(ModConfig.PaintBlock).setUnlocalizedName("PaintBlock");
        Register(PaintBlock, "Paint Block", true);
        
        ElectricFurnace = new ModBlockElectricFurnace(ModConfig.ElFurnace).setUnlocalizedName("ElFurnace");
        Register(ElectricFurnace, "Electric Furnace", true);
        
        TimedBlock = new ModBlockTimedBlock(ModConfig.TimedBlock).setUnlocalizedName("TimedBlock");
        Register(TimedBlock, "Float Block", false);
        
        
        
        
		RegisterOreDictionary(new ItemStack(SilverOre), "oreSilver");
		RegisterOreDictionary(new ItemStack(OrangeLog), "logWood");
		RegisterOreDictionary(new ItemStack(OrangePlanks), "plankWood");
		//OreDictionary.registerOre("plankWood", ModBlocks.OrangePlanks);
		
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
		
public static void Register(Block Block, Class<? extends ItemBlock> itemclass, String Name, boolean AddTab){
			
			
	        LanguageRegistry.addName(Block, Name);
	        if(Name.contains(" ")){
		        GameRegistry.registerBlock(Block, itemclass, Name.toLowerCase().replace(" ", ""));
	        }else{
		        GameRegistry.registerBlock(Block, itemclass, Name.toLowerCase());
	        }
	        
	        if(AddTab)
	        Block.setCreativeTab(Main.CreativeTab);

		}
		
		public static void RegisterOreDictionary(ItemStack Block, String dictonaryName){
			
			OreDictionary.registerOre(dictonaryName, Block);
			
		}
}

