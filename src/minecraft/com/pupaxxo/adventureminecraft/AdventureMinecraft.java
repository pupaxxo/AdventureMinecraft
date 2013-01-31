package com.pupaxxo.adventureminecraft;

import net.minecraft.creativetab.CreativeTabs;

import com.pupaxxo.adventureminecraft.blocks.Blocks;
import com.pupaxxo.adventureminecraft.config.Config;
import com.pupaxxo.adventureminecraft.core.Reference;
import com.pupaxxo.adventureminecraft.crafting.CraftingManager;
import com.pupaxxo.adventureminecraft.creativetab.CreativeTabAM;
import com.pupaxxo.adventureminecraft.handler.CommandHandler;
import com.pupaxxo.adventureminecraft.handler.GuiHandler;
import com.pupaxxo.adventureminecraft.helper.LogHelper;
import com.pupaxxo.adventureminecraft.helper.VersionHelper;
import com.pupaxxo.adventureminecraft.item.Items;
import com.pupaxxo.adventureminecraft.proxy.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.Mod.ServerStarting;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = Reference.MODID, name = Reference.MODNAME, version = Reference.VERSION)
@NetworkMod(clientSideRequired = Reference.clientSideRequired, serverSideRequired = Reference.serverSideRequired)
public class AdventureMinecraft {
	@SidedProxy(clientSide = Reference.clientProxy, serverSide = Reference.commondProxy)
	public static CommonProxy proxy;
	public Object[] configs;
	public boolean checkUpdates;
	public static CreativeTabs tabsAM = new CreativeTabAM(CreativeTabs.getNextID(), Reference.MODID);
	
	@Instance(Reference.MODID)
	public static AdventureMinecraft instance = new AdventureMinecraft();
	
	@PreInit
    public void preInit(FMLPreInitializationEvent event) 
	{
		//Load configuration file 
		configs = Config.load(event);
		checkUpdates = Config.toBoolean(configs[0].toString());
		//Log helper
		LogHelper.init();
		//Check updates
		//if (checkUpdates) {
			VersionHelper.execute();
		//}
	}
	
	@Init
	public void load(FMLInitializationEvent event) 
	{
		//Register lang for creative tabs
		LanguageRegistry.instance().addStringLocalization("itemGroup." + Reference.MODID, "en_US", "Adventure Minecraft");
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
	@ServerStarting
	public void serverStarting(FMLServerStartingEvent event) 
	{
	    // Initialize custom commands
	    CommandHandler.initCommands(event);
	}
	@Init
    public void init(FMLInitializationEvent event) {
		//Register guis
		NetworkRegistry.instance().registerGuiHandler(this, new GuiHandler());
    }
}	
