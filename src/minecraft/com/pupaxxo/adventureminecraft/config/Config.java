package com.pupaxxo.adventureminecraft.config;

import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Config {
	public Config() {
		
	}
	public static Object[] load(FMLPreInitializationEvent event) {
		Object[] configs = new Object[100];
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
        Property checkup = config.get(Configuration.CATEGORY_GENERAL, "Check updates", true);
        checkup.comment = "True fot check if there are new version of the mods , false if you don't want the notify.";
        configs[0] = checkup.getBoolean(true);
        Property id1 = config.get(Configuration.CATEGORY_GENERAL, "BlockDarkDirt", 2000);
        id1.comment = "The ID for block dark dirt";
        configs[1] = id1.getInt();
		config.save();
		return configs;
	}
	public static Boolean toBoolean(String text) {
		if (text.equals("true")) {
			return true;
		} else {
			return false;
		}
	}
}
