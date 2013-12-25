package Mod.Items;

import net.minecraft.block.Block;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;
import Mod.Lib.Refrence;
import Mod.Main.Main;
import Mod.Main.ModConfig;
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
	public static Item Tomato;
	public static Item Flour;
	public static ItemSeeds TomatoSeeds;
	public static Item Liquid;
	public static Item Cheese;
	public static Item Orange;
	public static Item DisarmStick;
	
	public static Item Drill;
	public static Item ElectricShears;
	public static Item ElectricBow;
	
	public static Item Battery;
	public static Item BigBattery;
	public static Item AdvancedBattery;
	
	public static Item Circuit;
	public static Item ModuleConnecter;
	public static Item SolarCells;
	public static Item Turbine;
	
	
	public static Item PizzaBottom;
	public static Item PizzaRaw;
	public static Item Pizza;
	
	public static Item Upgrades;
	public static Item Wrench;
	public static Item IronPlate;
	public static Item HeatDrill;
	
	public static Item PaintBrush;
	
	
	public static Item DivingHelmet;
	public static Item FlightChestPlate;
	public static Item RunningLeggings;
	public static Item JumpingBoots;
	
	public static Item FloatBlockPlacer;
	
	public static Item AntiFallChestPlate;
	
	
	
	
	
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
        
        Tomato = new ModItemTomato(ModConfig.Tomato, 3, 1F, false).setUnlocalizedName("Tomato");
        Register(Tomato, "Tomato");
        
        Flour = new ModItemFlour(ModConfig.Flour).setUnlocalizedName("Flour");
        Register(Flour, "Flour");
        
        TomatoSeeds = new ModItemTomatoSeeds(ModConfig.TomatoSeeds, ModConfig.TomatoPlant, Block.tilledField.blockID);
        Register(TomatoSeeds, "Tomato Seeds");
        
        PizzaBottom = new ModItemPizzaBottom(ModConfig.PizzaBottom).setUnlocalizedName("PizzaBottom");
        Register(PizzaBottom, "Pizza Base");
        
        Liquid = new ModItemLiquid(ModConfig.Liquid).setUnlocalizedName("Liquid");
        RegisterOutName(Liquid, "Liquid");
        
        Cheese = new ModItemCheese(ModConfig.Cheese).setUnlocalizedName("Cheese");
        Register(Cheese, "Cheese");
        
        PizzaRaw = new ModItemPizzaRaw(ModConfig.PizzaRaw).setUnlocalizedName("PizzaRaw");
        RegisterOutName(PizzaRaw, "Pizza Raw");
        
        Pizza = new ModItemPizza(ModConfig.Pizza).setUnlocalizedName("Pizza");
        RegisterOutName(Pizza, "Pizza");
        
        Orange = new ModItemOrange(ModConfig.Orange).setUnlocalizedName("Orange");
        Register(Orange, "Orange");
        
        DisarmStick = new ModItemDisarmStick(ModConfig.DisarmStick).setUnlocalizedName("DisarmStick");
        Register(DisarmStick, "Disarm Stick");
        
        Drill = new ModItemDrill(ModConfig.Drill, EnumToolMaterial.EMERALD).setUnlocalizedName("Drill");
        Register(Drill, "Drill");
        
        Circuit = new ModItemCircuit(ModConfig.Circuit).setUnlocalizedName("Circuit");
        Register(Circuit, "Circuit Board");
        
        ModuleConnecter = new ModItemModuleConnecter(ModConfig.ModuleConnecter).setUnlocalizedName("ModuleConnecter");
        Register(ModuleConnecter, "Module Connecter Part");
        
        SolarCells = new ModItemSolarCells(ModConfig.SolarCells).setUnlocalizedName("SolarCells");
        Register(SolarCells, "Solar Cells");
        
        Turbine = new ModItemTurbine(ModConfig.Turbine).setUnlocalizedName("Turbine");
        Register(Turbine, "Turbine");
        
        Battery = new ModItemBattery(ModConfig.Battery).setUnlocalizedName("Battery");
        Register(Battery, "Battery");
        
        BigBattery = new ModItemBigBattery(ModConfig.BigBattery).setUnlocalizedName("BigBattery");
        Register(BigBattery, "Big Battery");
        
        AdvancedBattery = new ModItemAdvancedBattery(ModConfig.AdvancedBattery).setUnlocalizedName("AdvancedBattery");
        Register(AdvancedBattery, "Advanced Battery");
        
        ElectricShears = new ModItemElectricShear(ModConfig.ElectricShears).setUnlocalizedName("ELShears");
        Register(ElectricShears, "Electric Shears");
        
        ElectricBow = new ModItemElectricBow(ModConfig.ElectricBow).setUnlocalizedName("ElBow");
        Register(ElectricBow, "Electric Bow");
        
       Upgrades = new ModItemUpgrades(ModConfig.Upgrades).setUnlocalizedName("Upgrades");
        RegisterOutName(Upgrades, "Upgrades");
        
        Wrench = new ModItemWrench(ModConfig.Wrench).setUnlocalizedName("Wrench");
        Register(Wrench, "Wrench");
        
        IronPlate = new ModItemIronPlate(ModConfig.IronPlate).setUnlocalizedName("IronPlate");
        Register(IronPlate, "Iron Plate");
        
        HeatDrill = new ModItemHeatDrill(ModConfig.HeatDrill).setUnlocalizedName("HeatDrill");
        Register(HeatDrill, "Heat Drill");
        
        PaintBrush = new ModItemPaintBrush(ModConfig.PaintBrush).setUnlocalizedName("PaintBrush");
        RegisterOutName(PaintBrush, "Paint Brush");
        
        FloatBlockPlacer = new ModItemFloatBlockPlacer(ModConfig.FloatBlockPlacer).setUnlocalizedName("FloatPlacer").setTextureName(Refrence.Mod_Id + ":FloatBlockPlacer");
        Register(FloatBlockPlacer, "Floating Platform Placer");
        
        Main.proxy.addArmor("AntiFall");
        
        AntiFallChestPlate = (new ModItemAntiFallChest(ModConfig.AntiFallChest, 1, 1)).setUnlocalizedName("AntiFallChestPlate").setTextureName(Refrence.Mod_Id + ":AntiFallChest");
        Register(AntiFallChestPlate, "Anti-fall and flight Chestplate");
        
		
		
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
	
	public static void RegisterOutName(Item Item, String Name){
		
		
        GameRegistry.registerItem(Item, Name.toLowerCase().replace(" ", ""));
        Item.setCreativeTab(Main.CreativeTab);
	}
}
