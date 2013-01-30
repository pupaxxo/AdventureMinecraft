package com.pupaxxo.adventureminecraft.helper;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.pupaxxo.adventureminecraft.core.Reference;

import cpw.mods.fml.common.FMLLog;

public class LogHelper {
	 	private static Logger avLogger = Logger.getLogger(Reference.MODID);

	    public static void init() {
	    	avLogger.setParent(FMLLog.getLogger());
	    }

	    public static void log(Level logLevel, String message) {
	    	avLogger.log(logLevel, message);
	    }
}
