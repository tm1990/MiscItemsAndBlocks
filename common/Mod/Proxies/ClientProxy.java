package Mod.Proxies;

import Mod.Entity.EntitySilverArrow;
import Mod.Render.SilverArrowRender;
import Mod.Tick.ClientTickHandler;
import Mod.TileEntity.TileEntityBin;
import Mod.TileEntity.TileEntityShelf;
import Mod.TileEntity.TileEntityDisarmTrap;
import Mod.TileEntityRenderer.TileEntityBinRender;
import Mod.TileEntityRenderer.TileEntityShelfRender;
import Mod.TileEntityRenderer.TileEntityDisarmTrapRenderer;
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
