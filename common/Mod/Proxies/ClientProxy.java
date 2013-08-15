package Mod.Proxies;

import Mod.Entity.EntitySilverArrow;
import Mod.Renders.SilverArrowRender;
import Mod.TileEntity.TileEntityBin;
import Mod.TileEntity.TileEntityShelf;
import Mod.TileEntity.TileEntityDisarmTrap;
import Mod.TileEntityRenderer.TileEntityBinRender;
import Mod.TileEntityRenderer.TileEntityShelfRender;
import Mod.TileEntityRenderer.TileEntityDisarmTrapRenderer;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;


public class ClientProxy extends ServerProxy{

	
    public void registerRenderThings() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBin.class, new TileEntityBinRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityShelf.class, new TileEntityShelfRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDisarmTrap.class, new TileEntityDisarmTrapRenderer());
        
        
        RenderingRegistry.registerEntityRenderingHandler(EntitySilverArrow.class, new SilverArrowRender());
}
}
