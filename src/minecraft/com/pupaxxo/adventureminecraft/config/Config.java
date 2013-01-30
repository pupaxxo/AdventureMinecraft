package com.pupaxxo.adventureminecraft.config;

import com.pupaxxo.adventureminecraft.helper.VersionHelper;

import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Config {
	public Config() {
		
	}
	public static Object[] load(FMLPreInitializationEvent event) {
		Object[] configs = new Object[1000];
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
        Property checkup = config.get(Configuration.CATEGORY_GENERAL, "Check updates", true);
        checkup.comment = "True fot check if there are new version of the mods , false if you don't want the notify.";
        configs[0] = checkup.getBoolean(true);
        configs[1] = addInt(2000,config,"BlockDarkDirt","The ID for block dark dirt",Configuration.CATEGORY_BLOCK);
        configs[2] = addInt(2001,config,"BlockAsphalt","The ID for block asphalt",Configuration.CATEGORY_BLOCK);
        configs[3] = addInt(2002,config,"ItemAsphaltator","The ID for the asphaltator",Configuration.CATEGORY_ITEM);
        configs[4] = addInt(2003,config,"BlockGlass","The ID for the glass block",Configuration.CATEGORY_BLOCK);
        configs[5] = addInt(2004,config,"BlockModernCrafting","The ID for the modern craftinf table",Configuration.CATEGORY_BLOCK);
		configs[100] = addBoolean(true , config , "BlockDarkDirt_enabled" , "True = enabled , false = disabled" , Configuration.CATEGORY_GENERAL);
		configs[101] = addBoolean(true , config , "BlockAsphalt_enabled" , "True = enabled , false = disabled" , Configuration.CATEGORY_GENERAL);
		configs[102] = addBoolean(true , config , "ItemAsphaltator_enabled" , "True = enabled , false = disabled" , Configuration.CATEGORY_GENERAL);
		configs[103] = addBoolean(true , config , "BlockGlass_enabled" , "True = enabled , false = disabled" , Configuration.CATEGORY_GENERAL);
		configs[104] = addBoolean(true , config , "BlockModernCrafting_enabled" , "True = enabled , false = disabled" , Configuration.CATEGORY_GENERAL);
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
	public static boolean addBoolean(boolean base , Configuration config , String name , String comment , String category){
		Property conf = config.get(category, name, base);
		conf.comment = comment;
        return conf.getBoolean(true);
	}
}
