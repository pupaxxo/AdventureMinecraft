package com.pupaxxo.adventureminecraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockWall;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.pupaxxo.adventureminecraft.blocks.itemBlock.ItemBlockAsphalt;
import com.pupaxxo.adventureminecraft.config.Config;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Blocks {
	private final static String[] subNames ={"Asphalt", "White Aspahlt"};
	public static Block darkDirt , asphalt , portal , glassModified , modernCrafting , wall;
	public static void registerBlocks(Object[] configs){
		//ID
		int id1 = Integer.parseInt(configs[1].toString());
		int id2 = Integer.parseInt(configs[2].toString());
		int id3 = Integer.parseInt(configs[3].toString());
		int id4 = Integer.parseInt(configs[4].toString());
		int id5 = Integer.parseInt(configs[5].toString());
		if (Config.toBoolean(configs[100].toString())) {
		//DarkDirt
		darkDirt = new BlockDarkDirt(id1,0).setBlockName("DarkDirt");
		GameRegistry.registerBlock(darkDirt);
		LanguageRegistry.addName(darkDirt, "Dark Dirt");
		}
		if (Config.toBoolean(configs[101].toString())) {
		//Asphalt
		asphalt = new BlockAsphalt(id2).setBlockName("BlockAsphalt");
		GameRegistry.registerBlock(asphalt);
		Item.itemsList[id2]= new ItemBlockAsphalt(id2-256, asphalt).setItemName("BlockAsphalt");
		for (int ix = 0; ix < 2; ix++) {
			ItemStack multiBlockStack = new ItemStack(asphalt, 1, ix);
			LanguageRegistry.addName(multiBlockStack, subNames[multiBlockStack.getItemDamage()]);
		}
		}
		//Portal Block
		//portal = new BlockCustomPortal(251, 4).setBlockName("Portal1");
		//GameRegistry.registerBlock(portal, "Portal1");
		//LanguageRegistry.addName(portal, "Portal");
		if (Config.toBoolean(configs[103].toString())) {
		//Glass Block
		glassModified = new BlockGlassModified(id4, 4, Material.glass, false).setHardness(0.3F).setBlockName("glassmodified");
		GameRegistry.registerBlock(glassModified);
		LanguageRegistry.addName(glassModified, "Industrial glass");
		}
		if (Config.toBoolean(configs[104].toString())) {
		//ModernCrafting
		modernCrafting = new BlockModernCrafting(id5 , 1).setBlockName("modernCrafting");
		GameRegistry.registerBlock(modernCrafting);
		LanguageRegistry.addName(modernCrafting, "Modern Crafting Table");
		}
	}
	
}
