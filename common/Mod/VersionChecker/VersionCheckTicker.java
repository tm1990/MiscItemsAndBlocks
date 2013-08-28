package Mod.VersionChecker;

import java.util.EnumSet;

import Mod.Lib.Refrence;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class VersionCheckTicker implements ITickHandler {

private boolean init = true;

@Override
public void tickStart(EnumSet<TickType> type, Object... tickData) {

}

@Override
public void tickEnd(EnumSet<TickType> type, Object... tickData) {
if(init){
for(TickType tickType: type){
if(tickType == TickType.CLIENT){
if(FMLClientHandler.instance().getClient().currentScreen == null){
init = false;
if(!Refrence.UP_TO_DATE){
FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage("A new version of MiscItemsAndBlocks is available.\n Version: " +Refrence.LATEST_VERSION +": " +Refrence.LATEST_CHANGES);
FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage("This update is " +Refrence.UPDATE_IMPORTANCE +" - " +Refrence.UPDATE_URL);
}else{
	System.out.println("Mod up to date!");
}

}
}
}
}
}

@Override
public EnumSet<TickType> ticks() {
return EnumSet.of(TickType.CLIENT);
}

@Override
public String getLabel() {
return "ProjectBench: " +this.getClass().getSimpleName();
}

}