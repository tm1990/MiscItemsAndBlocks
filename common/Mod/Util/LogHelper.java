package Mod.Util;

import java.util.logging.Level;
import java.util.logging.Logger;

import Mod.Lib.Refrence;
import cpw.mods.fml.common.FMLLog;

public class LogHelper {

    private static Logger eeLogger = Logger.getLogger(Refrence.Mod_Id);

    public static void init() {

        eeLogger.setParent(FMLLog.getLogger());
    }

    public static void log(Level logLevel, String message) {

        eeLogger.log(logLevel, message);
    }

    public static void severe(String message) {

        log(Level.SEVERE, message);
    }

    public static void debug(String message) {

        log(Level.WARNING, "[DEBUG] " + message);
    }

    public static void warning(String message) {

        log(Level.WARNING, message);
    }

    public static void info(String message) {

        log(Level.INFO, message);
    }

    public static void config(String message) {

        log(Level.CONFIG, message);
    }

    public static void fine(String message) {

        log(Level.FINE, message);
    }

    public static void finer(String message) {

        log(Level.FINER, message);
    }

    public static void finest(String message) {

        log(Level.FINEST, message);
    }
}