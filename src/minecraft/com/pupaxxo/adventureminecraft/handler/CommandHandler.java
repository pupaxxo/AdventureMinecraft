package com.pupaxxo.adventureminecraft.handler;

import com.pupaxxo.adventureminecraft.commands.CommandAM;

import cpw.mods.fml.common.event.FMLServerStartingEvent;

public class CommandHandler {
	public static void initCommands(FMLServerStartingEvent event) {
		event.registerServerCommand(new CommandAM());
    }
}
