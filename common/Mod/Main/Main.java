package Mod.Main;

import java.io.File;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
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
import Mod.TileEntity.TileEntityShelf;
import Mod.TileEntity.TileEntityXpStorage;
import Mod.WorldGen.SilverOreGen;
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
	
    @Instance
    public static Main instance = new Main();
    
    @SidedProxy(clientSide = "Mod.Proxies.ClientProxy", serverSide = "Mod.Proxies.ServerProxy")
    public static ServerProxy proxy;
    
    

public static boolean DEV_ENV = false;
    
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
        
        GameRegistry.registerTileEntity(TileEntityGamePartRed.class, "TileEntityGamePartRed");
        GameRegistry.registerTileEntity(TileEntityGamePartBlue.class, "TileEntityGamePartBlue");
        GameRegistry.registerTileEntity(TileEntityGamePartGreen.class, "TileEntityGamePartGreen");
        GameRegistry.registerTileEntity(TileEntityGamePartYellow.class, "TileEntityGamePartYellow");
        GameRegistry.registerTileEntity(TileEntityGamePartNull.class, "TileEntityGamePartNull");
        
        
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
