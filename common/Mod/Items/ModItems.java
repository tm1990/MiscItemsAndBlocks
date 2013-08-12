package Mod.Items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModItems {

	
	public static Item XpExtractor;
	
	
	public static void Init(){
		
		XpExtractor = new ModItemXpExtractor(1000);
		Register(XpExtractor, "Xp Extractor");
		
		
	}
	
	
	public static void RegisterOreDictionary(ItemStack Item, String dictonaryName){
		
		OreDictionary.registerOre(dictonaryName, Item);
		
	}
	
	public static void Register(Item Item, String Name){
		
		
        LanguageRegistry.addName(Item, Name);
        GameRegistry.registerItem(Item, Name.toLowerCase().replace(" ", ""));
	}
}
