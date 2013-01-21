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
        configs[1] = addInt(2000,config,"BlockDarkDirt","The ID for block dark dirt",Configuration.CATEGORY_BLOCK);
        configs[2] = addInt(2001,config,"BlockAsphalt","The ID for block asphalt",Configuration.CATEGORY_BLOCK);
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
	public static int addInt(int base , Configuration config , String name , String comment , String category){
		Property conf = config.get(category, name, base);
		conf.comment = comment;
        return conf.getInt();
	}
}
