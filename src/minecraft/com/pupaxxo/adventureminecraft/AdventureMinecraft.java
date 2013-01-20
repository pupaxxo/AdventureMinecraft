package com.pupaxxo.adventureminecraft;

import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = "AdventureMinecraft_pupaxxo", name = "AdventureMinecraft", version = "0.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = true)
public class AdventureMinecraft {
	public boolean checkUpdates;
	@PreInit
    public void preInit(FMLPreInitializationEvent event) 
	{
		//Create configuration file 
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
        Property checkup = config.get(Configuration.CATEGORY_GENERAL, "Check updates", true);
        checkup.comment = "True fot check if there are new version of the mods , false if you don't want the notify.";
        checkUpdates = checkup.getBoolean(true);
		config.save();
	}
	
	@Init
	public void load(FMLInitializationEvent event) 
	{
		
	}
}
