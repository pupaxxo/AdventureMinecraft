package com.pupaxxo.adventureminecraft;

import com.pupaxxo.adventureminecraft.blocks.Blocks;
import com.pupaxxo.adventureminecraft.config.Config;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = "AdventureMinecraft_pupaxxo", name = "AdventureMinecraft", version = "0.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = true)
public class AdventureMinecraft {
	public Object[] configs;
	public boolean checkUpdates;
	@PreInit
    public void preInit(FMLPreInitializationEvent event) 
	{
		//Load configuration file 
		configs = Config.load(event);
		checkUpdates = Config.toBoolean(configs[0].toString());
	}
	
	@Init
	public void load(FMLInitializationEvent event) 
	{
		Blocks.registerBlock(configs);
	}
}
