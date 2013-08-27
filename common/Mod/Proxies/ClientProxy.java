package Mod.Proxies;

import Mod.Entity.EntitySilverArrow;
import Mod.GamePart.TileEntityGamePartBlue;
import Mod.GamePart.TileEntityGamePartGreen;
import Mod.GamePart.TileEntityGamePartRed;
import Mod.GamePart.TileEntityGamePartNull;
import Mod.GamePart.TileEntityGamePartYellow;
import Mod.Models.SilverArrowRender;
import Mod.Tick.ClientTickHandler;
import Mod.TileEntity.TileEntityBin;
import Mod.TileEntity.TileEntityDisarmTrap;
import Mod.TileEntity.TileEntityShelf;
import Mod.TileEntityRenderer.TileEntityBinRender;
import Mod.TileEntityRenderer.TileEntityDisarmTrapRenderer;
import Mod.TileEntityRenderer.TileEntityGamePartRender;
import Mod.TileEntityRenderer.TileEntityShelfRender;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class ClientProxy extends ServerProxy{

	
    public void registerRenderThings() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBin.class, new TileEntityBinRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityShelf.class, new TileEntityShelfRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDisarmTrap.class, new TileEntityDisarmTrapRenderer());
        
        
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGamePartRed.class, new TileEntityGamePartRender("red"));
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGamePartBlue.class, new TileEntityGamePartRender("blue"));
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGamePartGreen.class, new TileEntityGamePartRender("green"));
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGamePartYellow.class, new TileEntityGamePartRender("yellow"));
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGamePartNull.class, new TileEntityGamePartRender("null"));
        
        RenderingRegistry.registerEntityRenderingHandler(EntitySilverArrow.class, new SilverArrowRender());
}
    
    
    @SideOnly(Side.CLIENT)
    @Override
    public int addArmor(String armor){
        return RenderingRegistry.addNewArmourRendererPrefix(armor);
    }
    
    @Override
    public void registerClientTickHandler()
    {
    	
    TickRegistry.registerTickHandler(new ClientTickHandler(), Side.CLIENT);

    }
}
