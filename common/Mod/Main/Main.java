package Mod.Main;

import java.io.File;
import java.util.logging.Level;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.Mod.ServerStarting;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import Mod.Block.ModBlocks;
import Mod.Commands.ExpExtractCommand;
import Mod.Commands.GetXpCommand;
import Mod.Crafting.Crafting;
import Mod.Entity.EntitySilverArrow;
import Mod.Gui.GuiHandler;
import Mod.Items.ModItems;
import Mod.Lib.*;
import Mod.Network.PacketHandler;
import Mod.Proxies.ClientProxy;
import Mod.Proxies.ServerProxy;
import Mod.TileEntity.TileEntityBin;
import Mod.TileEntity.TileEntityShelf;
import Mod.TileEntity.TileEntityDisarmTrap;
import Mod.TileEntity.TileEntityXpStorage;
import Mod.WorldGen.SilverOreGen;


@Mod(modid = Refrence.Mod_Id, name = Refrence.Mod_Name, version = Refrence.Version)
@NetworkMod(clientSideRequired=true, serverSideRequired=false, channels = {"MiscItems"}, packetHandler = PacketHandler.class)
public class Main {
	
    @Instance
    public static Main instance = new Main();
    
    @SidedProxy(clientSide = "Mod.Proxies.ClientProxy", serverSide = "Mod.Proxies.ServerProxy")
    public static ServerProxy proxy;
    
    
    
    File BlastProofCraftConfig = new File("config/tm1990's mods/BlastProofCraftConfig.cfg");
	
    @PreInit
    public void preInit(FMLPreInitializationEvent event){
    	
    	
        Configuration configMisc = new Configuration(new File("config/tm1990's mods/MiscItemsAndBlocksConfig.cfg"));
    	
    	ModConfig.Init(configMisc);
    	
    }
    
    
    @Init
    public void Init(FMLInitializationEvent event){
    	
    	
    	ModItems.Init();
    	ModBlocks.Init();
    	
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
        
        
        GameRegistry.registerWorldGenerator(new SilverOreGen());
        

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
