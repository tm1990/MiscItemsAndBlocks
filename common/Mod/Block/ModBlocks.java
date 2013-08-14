package Mod.Block;

import Mod.Main.Config;
import Mod.Main.Main;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBed;
import net.minecraft.block.BlockStairs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

public class ModBlocks {

	
	
	public static Block XpStorage;
	public static Block Bin;
	public static Block Shelf;
	public static Block Trap;
	public static Block TestStair;
	
	public static void Init(){
		
		XpStorage = new BlockXpStorage(Config.XpStorageBlockId);
		Register(XpStorage, "Xp Storage Block");
		
		Bin = new ModBlockBin(Config.BinsId);
		Register(Bin, "Trash Bin");
		
		Shelf = new ModBlockShelf(Config.ShelfId);
		Register(Shelf, "Shelf Block");
		
		Trap = new ModBlockTrap(Config.TrapId);
		Register(Trap, "Disarm Trap");

		
		
		
		
		
		
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

		}
		
		public static void RegisterOreDictionary(ItemStack Block, String dictonaryName){
			
			OreDictionary.registerOre(dictonaryName, Block);
			
		}
}

