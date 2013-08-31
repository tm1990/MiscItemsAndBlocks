package Mod.Proxies;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
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

/* INSTANCES */
public Object getClient() {
return null;
}

public World getClientWorld() {
return null;
}

public EntityPlayer getPlayer() {
return null;
}

/* SIMULATION */
public boolean isSimulating(World world) {
return !world.isRemote;
}

public boolean isRenderWorld(World world) {
return world.isRemote;
}

public String getCurrentLanguage() {
return null;
}
}
