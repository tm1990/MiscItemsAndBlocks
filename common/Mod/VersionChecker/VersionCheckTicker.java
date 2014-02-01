package Mod.VersionChecker;

import java.util.EnumSet;

import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import Mod.Lib.Refrence;
import Mod.Main.Main;
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
if(!Main.UP_TO_DATE){
	Main.UpdateMessage = StatCollector.translateToLocal("string.versioncheck.newversion").replace("%EnumRed", EnumChatFormatting.RED + "").replace("%EnumYellow", EnumChatFormatting.YELLOW + "").replace("%EnumBlue", EnumChatFormatting.BLUE + "").replace("%EnumGold", EnumChatFormatting.GOLD + "").replace("%ModName", Refrence.Mod_Name).replace("%NewVersion", Main.LATEST_VERSION).replace("%DowLink", Main.UPDATE_URL).replace("%Changes", Main.LATEST_CHANGES);
FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(Main.UpdateMessage);

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
return Refrence.Mod_Id + ": " +this.getClass().getSimpleName();
}

}