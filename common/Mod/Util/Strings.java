package Mod.Util;

import Mod.Lib.Refrence;

public class Strings {

    /* General keys */
    public static final String TRUE = "true";
    public static final String FALSE = "false";
    public static final String TOKEN_DELIMITER = ".";
    
    /* Localization Prefixes */
    public static final String RESOURCE_PREFIX = Refrence.Mod_Id.toLowerCase() + ":";

    /* Fingerprint check related constants */
    public static final String NO_FINGERPRINT_MESSAGE = "The copy of Equivalent Exchange 3 that you are running is a development version of the mod, and as such may be unstable and/or incomplete.";
    public static final String INVALID_FINGERPRINT_MESSAGE = "The copy of Equivalent Exchange 3 that you are running has been modified from the original, and unpredictable things may happen. Please consider re-downloading the original version of the mod.";

    /* Version check related constants */
    public static final String VERSION_CHECK_INIT_LOG_MESSAGE = "version.init_log_message";
    public static final String UNINITIALIZED_MESSAGE = "version.uninitialized";
    public static final String CURRENT_MESSAGE = "version.current";
    public static final String OUTDATED_MESSAGE = "version.outdated";
    public static final String GENERAL_ERROR_MESSAGE = "version.general_error";
    public static final String FINAL_ERROR_MESSAGE = "version.final_error";
    public static final String MC_VERSION_NOT_FOUND = "version.mc_version_not_found";
    
    public static final String COMMAND_VERSION = "version";
    public static final String COMMAND_CHANGELOG = "changelog";
    
    public static final String COMMAND_VERSION_USAGE = "/MiscVersion";
}

