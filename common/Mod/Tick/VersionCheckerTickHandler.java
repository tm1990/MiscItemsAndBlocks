package Mod.Tick;

import java.lang.ref.Reference;
import java.util.EnumSet;

import net.minecraftforge.common.Configuration;
import Mod.Lib.Refrence;
import Mod.Main.ModConfig;
import Mod.Main.ModSettings;
import Mod.Util.Strings;
import Mod.VersionChecker.VersionChecker;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class VersionCheckerTickHandler implements ITickHandler {

    private static boolean initialized = false;

    @Override
    public void tickStart(EnumSet<TickType> type, Object... tickData) {

    }

    @Override
    public void tickEnd(EnumSet<TickType> type, Object... tickData) {

        if (ModSettings.DISPLAY_VERSION_RESULT) {
            if (!initialized) {
                for (TickType tickType : type) {
                    if (tickType == TickType.CLIENT) {
                        if (FMLClientHandler.instance().getClient().currentScreen == null) {
                            if (VersionChecker.getResult() != VersionChecker.UNINITIALIZED || VersionChecker.getResult() != VersionChecker.FINAL_ERROR) {

                                initialized = true;

                                if (VersionChecker.getResult() == VersionChecker.OUTDATED) {
                                    FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(VersionChecker.getResultMessageForClient());
                                    ModConfig.set(Configuration.CATEGORY_GENERAL, ModSettings.DISPLAY_VERSION_RESULT_CONFIGNAME, Strings.FALSE);
                                }
                            }
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

        return Refrence.Mod_Name + ": " + this.getClass().getSimpleName();
    }

}
