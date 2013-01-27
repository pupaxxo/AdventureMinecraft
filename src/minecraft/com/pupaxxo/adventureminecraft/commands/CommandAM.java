package com.pupaxxo.adventureminecraft.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;

import com.pupaxxo.adventureminecraft.core.Reference;

public class CommandAM extends CommandBase
{

	@Override
	public String getCommandName() {
		return "av";
	}

	@Override
	public void processCommand(ICommandSender var1, String[] var2) {
		if (var2.length < 1) {
			var1.sendChatToPlayer("This is AdventureMinecraft command , used for get version.");
		} else if (var2[0].equals("version")){
			var1.sendChatToPlayer("Adventure minecraft version: " + Reference.version);
		} else {
	        throw new WrongUsageException("/av version", new Object[0]);
	    }
	}

}
