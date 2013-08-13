package Mod.Main;

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
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import Mod.Block.ModBlocks;
import Mod.Commands.ExpExtractCommand;
import Mod.Crafting.Crafting;
import Mod.Gui.GuiHandler;
import Mod.Items.ModItems;
import Mod.Lib.*;
import Mod.Network.PacketHandler;
import Mod.Proxies.ClientProxy;
import Mod.Proxies.ServerProxy;
import Mod.TileEntity.TileEntityBin;
import Mod.TileEntity.TileEntityShelf;
import Mod.TileEntity.TileEntityXpStorage;


@Mod(modid = Refrence.Mod_Id, name = Refrence.Mod_Name, version = Refrence.Version, useMetadata = true)
@NetworkMod(clientSideRequired=true, serverSideRequired=false, channels = {"MiscItems"}, packetHandler = PacketHandler.class)
public class Main {

	
	public static boolean IsBlastproofLoaded = false;
	
    @Instance
    public static Main instance = new Main();
    
    @SidedProxy(clientSide = "Mod.Proxies.ClientProxy", serverSide = "Mod.Proxies.ServerProxy")

    public static ServerProxy proxy;
    
    
	
    @PreInit
    public void preInit(FMLPreInitializationEvent event){
    	
    	
        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
    	
    	Config.Init(config);
    	
    }
    
    
    @Init
    public void Init(FMLInitializationEvent event){
    	
    	ModItems.Init();
    	ModBlocks.Init();
    	
        Crafting.RegisterRecipes();
    	
        proxy.registerRenderThings();
    	
        LanguageRegistry.instance().addStringLocalization("itemGroup."+Refrence.Mod_Name, "en_US", Refrence.Mod_Name);
        
        GameRegistry.registerTileEntity(TileEntityXpStorage.class, "XpStorage");
        GameRegistry.registerTileEntity(TileEntityBin.class, "TileEntityBin");
        GameRegistry.registerTileEntity(TileEntityShelf.class, "TileEntityShelf");
        

        NetworkRegistry.instance().registerGuiHandler(this, new GuiHandler());

    }
    
	@PostInit
    public void PostInit(FMLPostInitializationEvent event){
		
		if(!Config.BlastProofOverRide){
		
	     if (Loader.isModLoaded("BlastProofCraft")) {
	    	 
	    	 IsBlastproofLoaded = true;
	    	 
	     }
	     

    }
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
	  }
	
	
       
	
}
