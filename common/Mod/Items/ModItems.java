package Mod.Items;

import net.minecraft.block.Block;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;
import Mod.Lib.ModConfig;
import Mod.Lib.Refrence;
import Mod.Main.Main;
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
	public static Item DataChip;
	
	public static Item DivingHelmet;
	public static Item FlightChestPlate;
	public static Item RunningLeggings;
	public static Item JumpingBoots;
	
	public static Item FloatBlockPlacer;
	public static Item AntiFallChestPlate;
	public static Item InfoScreenHelmet;
	
	
	
	
	
    public static EnumToolMaterial SilverMaterial = EnumHelper.addToolMaterial("Silver", 5, 257, 13.0F, 0.0F, 45);
    public static EnumArmorMaterial PowerArmor = EnumHelper.addArmorMaterial("PowerArmor", 37, new int[] {2, 4, 3, 2} , 30);
	
	public static void Init(){
		
		XpExtractor = new ModItemXpExtractor(ModConfig.XpExtractor);
		Register(XpExtractor, StatCollector.translateToLocal("items.name.xpextractor"));
		
		SilverIngot = new ModItemSilverIngot(ModConfig.SilverIngot).setUnlocalizedName("SilverIngot");
		Register(SilverIngot, StatCollector.translateToLocal("items.name.silveringot"));
		
		SilverNugget = new ModItemSilverNugget(ModConfig.SilverNugget).setUnlocalizedName("SilverNugget");
		Register(SilverNugget, StatCollector.translateToLocal("items.name.silvernugget"));
		
		SilverSword = new ModItemSilverSword(ModConfig.SilverSword, SilverMaterial).setUnlocalizedName("SilverSword");
		Register(SilverSword, StatCollector.translateToLocal("items.name.silversword"));
		
		SilverBow = new ModItemSilverBow(ModConfig.SilverBow).setUnlocalizedName("SilverBow");
		Register(SilverBow, StatCollector.translateToLocal("items.name.silverbow"));
		
		SilverArrow = new ModItemSilverArrow(ModConfig.SilverArrow).setUnlocalizedName("SilverArrow");
		Register(SilverArrow, StatCollector.translateToLocal("items.name.silverarrow"));
		
        DivingHelmet = (new ModItemPowerArmor(ModConfig.DivingHelmet, PowerArmor, Main.proxy.addArmor("Power"), 0, 1)).setUnlocalizedName("DivingHelmet");
        Register(DivingHelmet, StatCollector.translateToLocal("items.name.powerarmor.helmet"));
		
        FlightChestPlate = (new ModItemPowerArmor(ModConfig.FlightChestPlate, PowerArmor, Main.proxy.addArmor("Power"), 1, 2)).setUnlocalizedName("FlightChestplate");
        Register(FlightChestPlate, StatCollector.translateToLocal("items.name.powerarmor.chestplate"));
        
        RunningLeggings = (new ModItemPowerArmor(ModConfig.RunningLeggings, PowerArmor, Main.proxy.addArmor("Power"), 2, 3)).setUnlocalizedName("RunningLeggings");
        Register(RunningLeggings, StatCollector.translateToLocal("items.name.powerarmor.leggings"));
        
        JumpingBoots = (new ModItemPowerArmor(ModConfig.JumpingBoots, PowerArmor, Main.proxy.addArmor("Power"), 3, 4)).setUnlocalizedName("JumpingBoots");
        Register(JumpingBoots, StatCollector.translateToLocal("items.name.powerarmor.boots"));
        
        Cardboard = new ModItemCardboard(ModConfig.Cardboard).setUnlocalizedName("Cardboard");
        Register(Cardboard, StatCollector.translateToLocal("items.name.cardboard"));
        
        Tomato = new ModItemTomato(ModConfig.Tomato, 3, 1F, false).setUnlocalizedName("Tomato");
        Register(Tomato, StatCollector.translateToLocal("items.name.tomato"));
        
        Flour = new ModItemFlour(ModConfig.Flour).setUnlocalizedName("Flour");
        Register(Flour, StatCollector.translateToLocal("items.name.flour"));
        
        TomatoSeeds = new ModItemTomatoSeeds(ModConfig.TomatoSeeds, ModConfig.TomatoPlant, Block.tilledField.blockID);
        Register(TomatoSeeds, StatCollector.translateToLocal("items.name.tomatoseeds"));
        
        PizzaBottom = new ModItemPizzaBottom(ModConfig.PizzaBottom).setUnlocalizedName("PizzaBottom");
        Register(PizzaBottom, StatCollector.translateToLocal("items.name.pizzabase"));
        
        Liquid = new ModItemLiquid(ModConfig.Liquid).setUnlocalizedName("Liquid");
        RegisterOutName(Liquid, "Liquid");
        
        Cheese = new ModItemCheese(ModConfig.Cheese).setUnlocalizedName("Cheese");
        Register(Cheese, StatCollector.translateToLocal("items.name.cheese"));
        
        PizzaRaw = new ModItemPizzaRaw(ModConfig.PizzaRaw).setUnlocalizedName("PizzaRaw");
        RegisterOutName(PizzaRaw, "Pizza Raw");
        
        Pizza = new ModItemPizza(ModConfig.Pizza).setUnlocalizedName("Pizza");
        RegisterOutName(Pizza, "Pizza");
        
        Orange = new ModItemOrange(ModConfig.Orange).setUnlocalizedName("Orange");
        Register(Orange, StatCollector.translateToLocal("items.name.orange"));
        
        DisarmStick = new ModItemDisarmStick(ModConfig.DisarmStick).setUnlocalizedName("DisarmStick");
        Register(DisarmStick, StatCollector.translateToLocal("items.name.disarmstick"));
        
        Drill = new ModItemDrill(ModConfig.Drill, EnumToolMaterial.EMERALD).setUnlocalizedName("Drill");
        Register(Drill, StatCollector.translateToLocal("items.name.drill"));
        
        Circuit = new ModItemCircuit(ModConfig.Circuit).setUnlocalizedName("Circuit");
        RegisterOutName(Circuit, "Circuit Board");
        
        ModuleConnecter = new ModItemModuleConnecter(ModConfig.ModuleConnecter).setUnlocalizedName("ModuleConnecter");
        Register(ModuleConnecter, StatCollector.translateToLocal("items.name.moduleconnecter"));
        
        SolarCells = new ModItemSolarCells(ModConfig.SolarCells).setUnlocalizedName("SolarCells");
        Register(SolarCells, StatCollector.translateToLocal("items.name.solarcells"));
        
        Turbine = new ModItemTurbine(ModConfig.Turbine).setUnlocalizedName("Turbine");
        Register(Turbine, StatCollector.translateToLocal("items.name.turbine"));
        
        Battery = new ModItemBattery(ModConfig.Battery).setUnlocalizedName("Battery");
        Register(Battery, StatCollector.translateToLocal("items.name.battery"));
        
        BigBattery = new ModItemBigBattery(ModConfig.BigBattery).setUnlocalizedName("BigBattery");
        Register(BigBattery, StatCollector.translateToLocal("items.name.bigbattery"));
        
        AdvancedBattery = new ModItemAdvancedBattery(ModConfig.AdvancedBattery).setUnlocalizedName("AdvancedBattery");
        Register(AdvancedBattery, StatCollector.translateToLocal("items.name.advancedbattery"));
        
        ElectricShears = new ModItemElectricShear(ModConfig.ElectricShears).setUnlocalizedName("ELShears");
        Register(ElectricShears, StatCollector.translateToLocal("items.name.electricshears"));
        
        ElectricBow = new ModItemElectricBow(ModConfig.ElectricBow).setUnlocalizedName("ElBow");
        Register(ElectricBow, StatCollector.translateToLocal("items.name.electricbow"));
        
       Upgrades = new ModItemUpgrades(ModConfig.Upgrades).setUnlocalizedName("Upgrades");
        RegisterOutName(Upgrades, "Upgrades");
        
        Wrench = new ModItemWrench(ModConfig.Wrench).setUnlocalizedName("Wrench");
        Register(Wrench, StatCollector.translateToLocal("items.name.wrench"));
        
        IronPlate = new ModItemIronPlate(ModConfig.IronPlate).setUnlocalizedName("IronPlate");
        Register(IronPlate, "Iron Plate");
        
        HeatDrill = new ModItemHeatDrill(ModConfig.HeatDrill).setUnlocalizedName("HeatDrill");
        Register(HeatDrill, StatCollector.translateToLocal("items.name.heatdrill"));
        
        PaintBrush = new ModItemPaintBrush(ModConfig.PaintBrush).setUnlocalizedName("PaintBrush");
        RegisterOutName(PaintBrush, "Paint Brush");
        
        FloatBlockPlacer = new ModItemFloatBlockPlacer(ModConfig.FloatBlockPlacer).setUnlocalizedName("FloatPlacer").setTextureName(Refrence.Mod_Id + ":FloatBlockPlacer");
        Register(FloatBlockPlacer, StatCollector.translateToLocal("items.name.floatblockplacer"));
        
        Main.proxy.addArmor("AntiFall");
        
        AntiFallChestPlate = (new ModItemAntiFallChest(ModConfig.AntiFallChest, 1, 1)).setUnlocalizedName("AntiFallChestPlate").setTextureName(Refrence.Mod_Id + ":AntiFallChest");
        Register(AntiFallChestPlate, StatCollector.translateToLocal("items.name.antifallchestplate"));
        
        InfoScreenHelmet = new ModItemInfoScreenHelmet(ModConfig.InfoScreenHelmet, 1, 0).setUnlocalizedName("InfoScreenHelmet").setTextureName(Refrence.Mod_Id + ":InfoScreenHelmet");
        Register(InfoScreenHelmet, StatCollector.translateToLocal("items.name.infoscreen"));
        
        DataChip = new ModItemDataChip(ModConfig.DataChip).setUnlocalizedName("DataChip");
        Register(DataChip, "Data Chip");
		
		
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
