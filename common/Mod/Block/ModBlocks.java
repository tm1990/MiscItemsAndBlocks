package Mod.Block;

import Mod.Main.ModConfig;
import Mod.Main.Main;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBed;
import net.minecraft.block.BlockColored;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

public class ModBlocks {

	
	
	public static Block XpStorage;
	public static Block Bin;
	public static Block Shelf;
	public static Block DisarmTrap;
	public static Block SilverOre;
	public static Block Box;
	public static Block CraftingInv;
	
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

