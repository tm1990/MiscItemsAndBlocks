package Mod.Block;

import Mod.Main.Config;
import Mod.Main.Main;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

public class ModBlocks {

	
	
	public static Block XpStorage;
	public static Block Bin;
	public static Block Shelf;
	
	public static void Init(){
		
		XpStorage = new BlockXpStorage(Config.XpStorageBlockId);
		Register(XpStorage, "Xp Storage Block");
		
		Bin = new ModBlockBin(Config.BinsId);
		Register(Bin, "Trash Bin");
		
		Shelf = new ModBlockShelf(Config.ShelfId);
		Register(Shelf, "Shelf");
		
		
		
		
		
	}
	
	
	
	
	  public static void RegisterHarvestLevel(Block block, String tool, int Level){
	    	

	    	MinecraftForge.setBlockHarvestLevel(block, tool, Level);
	    }
	    
		public static void Register(Block Block, String Name){
			
			Block.setCreativeTab(Main.CreativeTab);
			
	        LanguageRegistry.addName(Block, Name);
	        GameRegistry.registerBlock(Block, Name.toLowerCase().replace(" ", ""));
		}
		
		public static void RegisterOreDictionary(ItemStack Block, String dictonaryName){
			
			OreDictionary.registerOre(dictonaryName, Block);
			
		}
}

