package Mod.Items;

import Mod.Main.Main;
import Mod.Main.ModConfig;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModItems {

	
	public static Item XpExtractor;
	public static Item SilverIngot;
	public static Item SilverNugget;
	public static Item SilverSword;
	public static Item SilverBow;
	public static Item SilverArrow;
	
	
	
    public static EnumToolMaterial SilverMaterial = EnumHelper.addToolMaterial("Silver", 5, 527, 13.0F, 4.0F, 45);
	
	public static void Init(){
		
		XpExtractor = new ModItemXpExtractor(ModConfig.XpExtractor);
		Register(XpExtractor, "Xp Extractor");
		
		SilverIngot = new ModItemSilverIngot(ModConfig.SilverIngot);
		Register(SilverIngot, "Silver Ingot");
		
		SilverNugget = new ModItemSilverNugget(ModConfig.SilverNugget);
		Register(SilverNugget, "Silver Nugget");
		
		SilverSword = new ModItemSilverSword(ModConfig.SilverSword, SilverMaterial);
		Register(SilverSword, "Silver Sword");
		
		SilverBow = new ModItemSilverBow(ModConfig.SilverBow).setUnlocalizedName("SilverBow");
		Register(SilverBow, "Silver Bow");
		
		SilverArrow = new ModItemSilverArrow(ModConfig.SilverArrow);
		Register(SilverArrow, "Silver Arrow");
		

		
		
	RegisterOreDictionary(new ItemStack(SilverIngot), "ingotSilver");
	RegisterOreDictionary(new ItemStack(SilverNugget), "nuggetSilver");
		
		
		
		
		
	}
	
	
	public static void RegisterOreDictionary(ItemStack Item, String dictonaryName){
		
		OreDictionary.registerOre(dictonaryName, Item);
		
	}
	
	public static void Register(Item Item, String Name){
		
		
        LanguageRegistry.addName(Item, Name);
        GameRegistry.registerItem(Item, Name.toLowerCase().replace(" ", ""));
        Item.setCreativeTab(Main.CreativeTab);
	}
}
