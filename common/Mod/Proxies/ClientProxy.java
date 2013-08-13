package Mod.Proxies;

import Mod.TileEntity.TileEntityBin;
import Mod.TileEntity.TileEntityBinRender;
import Mod.TileEntity.TileEntityShelf;
import Mod.TileEntity.TileEntityShelfRender;
import cpw.mods.fml.client.registry.ClientRegistry;


public class ClientProxy extends ServerProxy{

	
    public void registerRenderThings() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBin.class, new TileEntityBinRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityShelf.class, new TileEntityShelfRender());
}
}
