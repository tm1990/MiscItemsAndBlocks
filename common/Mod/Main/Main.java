package Mod.Main;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import Mod.Block.ModBlocks;
import Mod.Entity.EntityPowerArrow;
import Mod.Entity.EntitySilverArrow;
import Mod.GamePart.TileEntityGamePartBlue;
import Mod.GamePart.TileEntityGamePartGreen;
import Mod.GamePart.TileEntityGamePartNull;
import Mod.GamePart.TileEntityGamePartRed;
import Mod.GamePart.TileEntityGamePartYellow;
import Mod.Gui.GuiHandler;
import Mod.Items.ModItems;
import Mod.Lib.Crafting;
import Mod.Lib.Messages;
import Mod.Lib.Refrence;
import Mod.Misc.BoneMealEvent;
import Mod.Misc.KeyBindings;
import Mod.Network.PacketHandler;
import Mod.Proxies.ServerProxy;
import Mod.Render.CapeRender;
import Mod.TileEntity.TileEntityBin;
import Mod.TileEntity.TileEntityBox;
import Mod.TileEntity.TileEntityCharger;
import Mod.TileEntity.TileEntityCraftingInv;
import Mod.TileEntity.TileEntityDisarmTrap;
import Mod.TileEntity.TileEntityElectricFurnace;
import Mod.TileEntity.TileEntityGenerator;
import Mod.TileEntity.TileEntityItemPedestal;
import Mod.TileEntity.TileEntityMill;
import Mod.TileEntity.TileEntityMiningChamber;
import Mod.TileEntity.TileEntityOvenCore;
import Mod.TileEntity.TileEntityPaintBlock;
import Mod.TileEntity.TileEntityPillar;
import Mod.TileEntity.TileEntityPowerCable;
import Mod.TileEntity.TileEntitySolarPanel;
import Mod.TileEntity.TileEntitySquezer;
import Mod.TileEntity.TileEntityTable;
import Mod.TileEntity.TileEntityTimedBlock;
import Mod.TileEntity.TileEntityWindMill;
import Mod.TileEntity.TileEntityXpStorage;
import Mod.VersionChecker.VersionChecker;
import Mod.WorldGen.ModWorldGenerator;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;


@Mod(modid = Refrence.Mod_Id, name = Refrence.Mod_Name, version = Refrence.Version)
@NetworkMod(clientSideRequired=true, serverSideRequired=false, channels = Refrence.Channel, packetHandler = PacketHandler.class)
public class Main {
	
	public static final Logger Log = Logger.getLogger("MiscItems");
	
    @Instance
    public static Main instance = new Main();
    
    @SidedProxy(clientSide = "Mod.Proxies.ClientProxy", serverSide = "Mod.Proxies.ServerProxy")
    public static ServerProxy proxy;
    
    
	public static boolean VERSION_CHECK = true;
	
    public static final String RELEASE_VERSION = Refrence.Version;
    public static String LATEST_CHANGES = "[nothing]";
    public static String LATEST_VERSION = "[nothing]";
    public static String UPDATE_URL = "http://adf.ly/U25ua";
    public static boolean UP_TO_DATE = true;
    
    public static String UpdateMessage = StatCollector.translateToLocal("string.versioncheck.newversion").replace("%EnumRed", EnumChatFormatting.RED + "").replace("%EnumYellow", EnumChatFormatting.YELLOW + "").replace("%EnumBlue", EnumChatFormatting.BLUE + "").replace("%EnumGold", EnumChatFormatting.GOLD + "").replace("%ModName", Refrence.Mod_Name).replace("%NewVersion", Main.LATEST_VERSION).replace("%DowLink", Main.UPDATE_URL).replace("%Changes", Main.LATEST_CHANGES);
    
	
@PreInit
public void preInit(FMLPreInitializationEvent event) {
    	
	
	//TODO Continue locolazation support. 
	
    	
	GameRegistry.registerCraftingHandler(new ModCraftingHandler());
	
        Configuration configMisc = new Configuration(new File(event.getModConfigurationDirectory() + "/tm1990's mods/MiscItemsAndBlocksConfig.cfg")); 
        
    	try
    	{
        
    	ModConfig.Init(configMisc);
    	
    	} catch(Exception ex)
    	{
    	FMLLog.log(Level.SEVERE, ex, Refrence.Mod_Id + ": Error encountered while loading config file.");
    	} finally
    	{
    	configMisc.save();
    	}
    	
    	if(VERSION_CHECK)
    		VersionChecker.go();



    	
    }
    
    
    @Init
    public void Init(FMLInitializationEvent event){
    	
    	if(event.getSide() == Side.CLIENT)
        MinecraftForge.EVENT_BUS.register(new CapeRender());
    	
    	ModItems.Init();
    	ModBlocks.Init();
    	
    	Messages.Init();
    	
        Crafting.RegisterRecipes();
    	
        proxy.registerRenderThings();
        proxy.registerClientTickHandler();
        proxy.registerServerTickHandler();
        proxy.RegisterListeners();
    	if(event.getSide() == Side.CLIENT)
        KeyBindingRegistry.registerKeyBinding(new KeyBindings());
        
        EntityRegistry.registerGlobalEntityID(EntitySilverArrow.class, "SilverArrow", EntityRegistry.findGlobalUniqueEntityId());
        EntityRegistry.registerModEntity(EntitySilverArrow.class, "SilverArrow", 0, this, 128, 1, true);
        
        EntityRegistry.registerGlobalEntityID(EntityPowerArrow.class, "PowerArrow", EntityRegistry.findGlobalUniqueEntityId());
        EntityRegistry.registerModEntity(EntityPowerArrow.class, "PowerArrow", 1, this, 128, 1, true);
    	
        LanguageRegistry.instance().addStringLocalization("itemGroup."+Refrence.Mod_Name, "en_US", Refrence.Mod_Name);
        LanguageRegistry.instance().addStringLocalization("entity.SilverArrow.name", "Silver Arrow");
        LanguageRegistry.instance().addStringLocalization("entity.PowerArrow.name", "Power Arrow");
        
        GameRegistry.registerTileEntity(TileEntityXpStorage.class, "XpStorage");
        GameRegistry.registerTileEntity(TileEntityBin.class, "TileEntityBin");
        GameRegistry.registerTileEntity(TileEntityDisarmTrap.class, "TileEntityTrap");
        GameRegistry.registerTileEntity(TileEntityBox.class, "TileEntityBox");
        GameRegistry.registerTileEntity(TileEntityCraftingInv.class, "TileEntityCraftingInv");
        GameRegistry.registerTileEntity(TileEntityMill.class, "TileEntityMill");
        GameRegistry.registerTileEntity(TileEntitySquezer.class, "TileEntitySquezer");
        GameRegistry.registerTileEntity(TileEntityOvenCore.class, "TileEntityOvenCore");
        
        GameRegistry.registerTileEntity(TileEntityItemPedestal.class, "TileEntityItemPedestal");
        GameRegistry.registerTileEntity(TileEntityMiningChamber.class, "TileEntityMiningChamber");
        
        GameRegistry.registerTileEntity(TileEntityCharger.class, "TileEntityCharger");
        GameRegistry.registerTileEntity(TileEntitySolarPanel.class, "TileEntitySolarPanel");
        GameRegistry.registerTileEntity(TileEntityWindMill.class, "TileEntityWindMill");
        GameRegistry.registerTileEntity(TileEntityGenerator.class, "TileEntityGenerator");
        GameRegistry.registerTileEntity(TileEntityPowerCable.class, "TileEntityPowerCable");
        
        GameRegistry.registerTileEntity(TileEntityGamePartRed.class, "TileEntityGamePartRed");
        GameRegistry.registerTileEntity(TileEntityGamePartBlue.class, "TileEntityGamePartBlue");
        GameRegistry.registerTileEntity(TileEntityGamePartGreen.class, "TileEntityGamePartGreen");
        GameRegistry.registerTileEntity(TileEntityGamePartYellow.class, "TileEntityGamePartYellow");
        GameRegistry.registerTileEntity(TileEntityGamePartNull.class, "TileEntityGamePartNull");
        GameRegistry.registerTileEntity(TileEntityPillar.class, "TileEntityPillar");
        GameRegistry.registerTileEntity(TileEntityTimedBlock.class, "TileEntityTimedBLock");
        GameRegistry.registerTileEntity(TileEntityElectricFurnace.class, "TileEntityElectricFurnace");
        GameRegistry.registerTileEntity(TileEntityTable.class, "TileEntityTable");
        GameRegistry.registerTileEntity(TileEntityPaintBlock.class, "TileEntityPaintBlock");
        
        
        GameRegistry.registerWorldGenerator(new ModWorldGenerator());
        
        MinecraftForge.addGrassSeed(new ItemStack(ModItems.TomatoSeeds), 10);
        
        MinecraftForge.EVENT_BUS.register(new BoneMealEvent());
        

        NetworkRegistry.instance().registerGuiHandler(this, new GuiHandler());
        

    }
    
	@PostInit
    public void PostInit(FMLPostInitializationEvent event){

	}

	
	public static CreativeTabs CreativeTab = new CreativeTabs(Refrence.Mod_Name) {
	    public ItemStack getIconItemStack() {
	            return new ItemStack(ModItems.XpExtractor, 1, 0);
	    }
	};
	
	
       
	
}
