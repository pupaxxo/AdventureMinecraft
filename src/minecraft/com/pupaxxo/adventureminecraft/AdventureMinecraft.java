package com.pupaxxo.adventureminecraft;

import net.minecraft.creativetab.CreativeTabs;

import com.pupaxxo.adventureminecraft.blocks.Blocks;
import com.pupaxxo.adventureminecraft.config.Config;
import com.pupaxxo.adventureminecraft.core.Reference;
import com.pupaxxo.adventureminecraft.crafting.CraftingManager;
import com.pupaxxo.adventureminecraft.creativetab.CreativeTabAM;
import com.pupaxxo.adventureminecraft.dimension.Dimension;
import com.pupaxxo.adventureminecraft.item.Items;
import com.pupaxxo.adventureminecraft.proxy.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = Reference.modid, name = Reference.modname, version = Reference.version)
@NetworkMod(clientSideRequired = Reference.clientSideRequired, serverSideRequired = Reference.serverSideRequired)
public class AdventureMinecraft {
	@SidedProxy(clientSide = Reference.clientProxy, serverSide = Reference.commondProxy)
	//@Instance("AdventureMinecraft")
	//public static AdventureMinecraft instance = new AdventureMinecraft();
	public static CommonProxy proxy;
	public Object[] configs;
	public boolean checkUpdates;
	public static CreativeTabs tabsAM = new CreativeTabAM(CreativeTabs.getNextID(), Reference.modid);
	
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
		//Register lang for creative tabs
		LanguageRegistry.instance().addStringLocalization("itemGroup." + Reference.modid, "en_US", "Adventure Minecraft");
		//Register proxy
		proxy.registerRenderThings();
		//Register blocks
		Blocks.registerBlocks(configs);
		//Register items
		Items.registerItems(configs);
		//Crafing
		CraftingManager.Crafting();
		//Dimension
		//Dimension.DimensionInit();
	}
}
