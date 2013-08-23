package Mod.Items;

import Mod.Main.Main;
import Mod.Main.ModConfig;
import net.minecraft.item.EnumArmorMaterial;
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
	public static Item Cardboard;
	public static Item CraftingUpgrade;
	
	
	public static Item DivingHelmet;
	public static Item FlightChestPlate;
	public static Item RunningLeggings;
	public static Item JumpingBoots;
	
	
	
	
	
    public static EnumToolMaterial SilverMaterial = EnumHelper.addToolMaterial("Silver", 5, 527, 13.0F, 0.0F, 45);
    public static EnumArmorMaterial PowerArmor = EnumHelper.addArmorMaterial("PowerArmor", 37, new int[] {2, 4, 3, 2} , 30);
	
	public static void Init(){
		
		XpExtractor = new ModItemXpExtractor(ModConfig.XpExtractor);
		Register(XpExtractor, "Xp Extractor");
		
		SilverIngot = new ModItemSilverIngot(ModConfig.SilverIngot).setUnlocalizedName("SilverIngot");
		Register(SilverIngot, "Silver Ingot");
		
		SilverNugget = new ModItemSilverNugget(ModConfig.SilverNugget).setUnlocalizedName("SilverNugget");
		Register(SilverNugget, "Silver Nugget");
		
		SilverSword = new ModItemSilverSword(ModConfig.SilverSword, SilverMaterial).setUnlocalizedName("SilverSword");
		Register(SilverSword, "Silver Sword");
		
		SilverBow = new ModItemSilverBow(ModConfig.SilverBow).setUnlocalizedName("SilverBow");
		Register(SilverBow, "Silver Bow");
		
		SilverArrow = new ModItemSilverArrow(ModConfig.SilverArrow).setUnlocalizedName("SilverArrow");
		Register(SilverArrow, "Silver Arrow");
		
        DivingHelmet = (new ModItemPowerArmor(ModConfig.DivingHelmet, PowerArmor, Main.proxy.addArmor("Power"), 0, 1)).setUnlocalizedName("DivingHelmet");
        Register(DivingHelmet, "Diving Helmet");
		
        FlightChestPlate = (new ModItemPowerArmor(ModConfig.FlightChestPlate, PowerArmor, Main.proxy.addArmor("Power"), 1, 2)).setUnlocalizedName("FlightChestplate");
        Register(FlightChestPlate, "Flight Chestplate");
        
        RunningLeggings = (new ModItemPowerArmor(ModConfig.RunningLeggings, PowerArmor, Main.proxy.addArmor("Power"), 2, 3)).setUnlocalizedName("RunningLeggings");
        Register(RunningLeggings, "Speed Leggings");
        
        JumpingBoots = (new ModItemPowerArmor(ModConfig.JumpingBoots, PowerArmor, Main.proxy.addArmor("Power"), 3, 4)).setUnlocalizedName("JumpingBoots");
        Register(JumpingBoots, "Jumping Boots");
        
        Cardboard = new ModItemCardboard(ModConfig.Cardboard).setUnlocalizedName("Cardboard");
        Register(Cardboard, "Cardboard");
        
        CraftingUpgrade = new ModItemCraftingChestUpgrade(ModConfig.CraftingUpgrade).setUnlocalizedName("CraftingUpgrade");
        Register(CraftingUpgrade, "Crafting Table Chest Upgrade");
		
		
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
