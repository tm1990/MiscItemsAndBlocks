package Mod.Proxies;

import Mod.TileEntity.TileEntityBin;
import Mod.TileEntity.TileEntityShelf;
import Mod.TileEntity.TileEntityTrap;
import Mod.TileEntityRenderer.TileEntityBinRender;
import Mod.TileEntityRenderer.TileEntityShelfRender;
import Mod.TileEntityRenderer.TileEntityTrapRenderer;
import cpw.mods.fml.client.registry.ClientRegistry;


public class ClientProxy extends ServerProxy{

	
    public void registerRenderThings() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBin.class, new TileEntityBinRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityShelf.class, new TileEntityShelfRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTrap.class, new TileEntityTrapRenderer());
}
}
