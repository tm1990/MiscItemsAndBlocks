package Mod.Main;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import Mod.Block.ModBlocks;
import Mod.Gui.GuiHandler;
import Mod.Items.ModItems;
import Mod.Lib.*;
import Mod.Network.PacketHandler;
import Mod.TileEntity.TileEntityXpStorage;


@Mod(modid = Refrence.Mod_Id, name = Refrence.Mod_Name, version = Refrence.Version, useMetadata = true)
@NetworkMod(clientSideRequired=true, serverSideRequired=false, channels = {"MiscItems"}, packetHandler = PacketHandler.class)
public class Main {

	
    @Instance
    public static Main instance = new Main();
    
    
	
    @PreInit
    public void preInit(FMLPreInitializationEvent event){
    	
    	
    }
    
    
    @Init
    public void Init(FMLInitializationEvent event){
    	
    	ModItems.Init();
    	ModBlocks.Init();
    	
        LanguageRegistry.instance().addStringLocalization("itemGroup."+Refrence.Mod_Name, "en_US", Refrence.Mod_Name);
        
        GameRegistry.registerTileEntity(TileEntityXpStorage.class, "XpStorage");
        
        NetworkRegistry.instance().registerGuiHandler(this, new GuiHandler());
    }
    
	@PostInit
    public void PostInit(FMLPostInitializationEvent event){
    }

	
	public static CreativeTabs CreativeTab = new CreativeTabs(Refrence.Mod_Name) {
	    public ItemStack getIconItemStack() {
	            return new ItemStack(Item.coal, 1, 0);
	    }
	};
	
	
       
	
}
