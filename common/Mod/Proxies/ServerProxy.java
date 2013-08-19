package Mod.Proxies;

import Mod.Tick.ServerTickHandler;
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

		
		
		
	}
}
