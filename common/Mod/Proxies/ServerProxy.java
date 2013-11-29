package Mod.Proxies;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import Mod.Tick.ClientTickHandler;
import Mod.Tick.ServerTickHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class ServerProxy {

	
    public void registerRenderThings(){
        
    }
    
    
    public int addArmor(String armor){
        return 0;
    }
    
	public void registerServerTickHandler()
	 {
	  TickRegistry.registerTickHandler(new ServerTickHandler(), Side.SERVER);
	 }


	public void registerClientTickHandler() {

		
		  TickRegistry.registerTickHandler(new ClientTickHandler(), Side.CLIENT);
		
		
	}
	
	public String getMinecraftVersion() {
return Loader.instance().getMinecraftModContainer().getVersion();
}



public void sendRequestEventPacket(byte eventType, int originX, int originY, int originZ, byte sideHit, byte rangeX, byte rangeY, byte rangeZ, String data) {

}

public void handleTileEntityPacket(int x, int y, int z, ForgeDirection orientation, byte state, String customName) {

}

public void handleTileWithItemPacket(int x, int y, int z, ForgeDirection orientation, byte state, String customName, int itemID, int metaData, int stackSize, int color) {

}

}
