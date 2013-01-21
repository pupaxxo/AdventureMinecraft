package com.pupaxxo.adventureminecraft.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;

public class Blocks {
	public static Block darkDirt;
	public static void registerBlock(Object[] configs){
		int id1 = Integer.parseInt(configs[1].toString());
		darkDirt = new BlockDarkDirt(id1,0);
		GameRegistry.registerBlock(darkDirt);
		LanguageRegistry.addName(darkDirt, "Dark Dirt");
	}
}
