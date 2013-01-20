package com.pupaxxo.adventureminecraft;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = "AdventureMinecraft_pupaxxo", name = "AdventureMinecraft", version = "0.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class AdventureMinecraft {
	@PreInit
    public void preInit(FMLPreInitializationEvent event) {
		
	}
	@Init
	public void load(FMLInitializationEvent event) 
	{
	
	}
}
