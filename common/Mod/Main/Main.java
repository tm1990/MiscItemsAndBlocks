package Mod.Main;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import Mod.Block.ModBlocks;
import Mod.Commands.ExpExtractCommand;
import Mod.Commands.GetXpCommand;
import Mod.Crafting.Crafting;
import Mod.Entity.EntitySilverArrow;
import Mod.GamePart.TileEntityGamePartBlue;
import Mod.GamePart.TileEntityGamePartGreen;
import Mod.GamePart.TileEntityGamePartNull;
import Mod.GamePart.TileEntityGamePartRed;
import Mod.GamePart.TileEntityGamePartYellow;
import Mod.Gui.GuiHandler;
import Mod.Items.ModItems;
import Mod.Lib.Messages;
import Mod.Lib.Refrence;
import Mod.Network.PacketHandler;
import Mod.Proxies.ServerProxy;
import Mod.TileEntity.TileEntityBin;
import Mod.TileEntity.TileEntityBox;
import Mod.TileEntity.TileEntityCraftingInv;
import Mod.TileEntity.TileEntityDisarmTrap;
import Mod.TileEntity.TileEntityMill;
import Mod.TileEntity.TileEntityPillar;
import Mod.TileEntity.TileEntityShelf;
import Mod.TileEntity.TileEntitySidewaysPillar;
import Mod.TileEntity.TileEntityXpStorage;
import Mod.VersionChecker.VersionChecker;
import Mod.WorldGen.SilverOreGen;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.Mod.ServerStarting;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


@Mod(modid = Refrence.Mod_Id, name = Refrence.Mod_Name, version = Refrence.Version)
@NetworkMod(clientSideRequired=true, serverSideRequired=false, channels = {"MiscItems"}, packetHandler = PacketHandler.class)
public class Main {
	
	public static final Logger Log = Logger.getLogger("MiscItems");
	
    @Instance
    public static Main instance = new Main();
    
    @SidedProxy(clientSide = "Mod.Proxies.ClientProxy", serverSide = "Mod.Proxies.ServerProxy")
    public static ServerProxy proxy;
    
    
	public static boolean VERSION_CHECK = true;
	
    public static final String RELEASE_VERSION = Refrence.Version;
    public static String LATEST_CHANGES = "[null]";
    public static String LATEST_VERSION = "[null]";
    public static String UPDATE_IMPORTANCE = "[null]";
    public static String UPDATE_URL = "http://adf.ly/U25ua";
    public static boolean UP_TO_DATE = true;
    
    
    
	
@PreInit
public void preInit(FMLPreInitializationEvent event) {
    	
    	
        Configuration configMisc = new Configuration(new File(event.getModConfigurationDirectory() + "/tm1990's mods/MiscItemsAndBlocksConfig.cfg"));
        File BlastProofCraftConfig = new File("config/tm1990's mods/BlastProofCraftConfig.cfg");    
        
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
    	
    	
    	ModItems.Init();
    	ModBlocks.Init();
    	
    	Messages.Init();
    	
        Crafting.RegisterRecipes();
    	
        proxy.registerRenderThings();
        proxy.registerClientTickHandler();
        proxy.registerServerTickHandler();
        
        EntityRegistry.registerGlobalEntityID(EntitySilverArrow.class, "SilverArrow", EntityRegistry.findGlobalUniqueEntityId());
        EntityRegistry.registerModEntity(EntitySilverArrow.class, "SilverArrow", 0, this, 128, 1, true);
    	
        LanguageRegistry.instance().addStringLocalization("itemGroup."+Refrence.Mod_Name, "en_US", Refrence.Mod_Name);
        LanguageRegistry.instance().addStringLocalization("entity.SilverArrow.name", "Silver Arrow");
        
        GameRegistry.registerTileEntity(TileEntityXpStorage.class, "XpStorage");
        GameRegistry.registerTileEntity(TileEntityBin.class, "TileEntityBin");
        GameRegistry.registerTileEntity(TileEntityShelf.class, "TileEntityShelf");
        GameRegistry.registerTileEntity(TileEntityDisarmTrap.class, "TileEntityTrap");
        GameRegistry.registerTileEntity(TileEntityBox.class, "TileEntityBox");
        GameRegistry.registerTileEntity(TileEntityCraftingInv.class, "TileEntityCraftingInv");
        GameRegistry.registerTileEntity(TileEntityMill.class, "TileEntityMill");
        
        GameRegistry.registerTileEntity(TileEntityGamePartRed.class, "TileEntityGamePartRed");
        GameRegistry.registerTileEntity(TileEntityGamePartBlue.class, "TileEntityGamePartBlue");
        GameRegistry.registerTileEntity(TileEntityGamePartGreen.class, "TileEntityGamePartGreen");
        GameRegistry.registerTileEntity(TileEntityGamePartYellow.class, "TileEntityGamePartYellow");
        GameRegistry.registerTileEntity(TileEntityGamePartNull.class, "TileEntityGamePartNull");
        GameRegistry.registerTileEntity(TileEntityPillar.class, "TileEntityPillar");
        GameRegistry.registerTileEntity(TileEntitySidewaysPillar.class, "TileEntitySidewaysPillar");
        
        
        GameRegistry.registerWorldGenerator(new SilverOreGen());
        
        MinecraftForge.addGrassSeed(new ItemStack(ModItems.TomatoSeeds), 10);
        

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
	
	  @ServerStarting
	  public void serverLoad(FMLServerStartingEvent event)
	  {
	    event.registerServerCommand(new ExpExtractCommand());
	    event.registerServerCommand(new GetXpCommand());
	  }
	
	
       
	
}
