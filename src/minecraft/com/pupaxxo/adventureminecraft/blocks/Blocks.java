package com.pupaxxo.adventureminecraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.pupaxxo.adventureminecraft.blocks.itemBlock.ItemBlockAsphalt;
import com.pupaxxo.adventureminecraft.item.ItemAsphaltator;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Blocks {
	private final static String[] subNames ={"Asphalt", "White Aspahlt"};
	public static Block darkDirt , asphalt;
	public static Item asphaltator;
	public static void registerBlock(Object[] configs){
		//ID
		int id1 = Integer.parseInt(configs[1].toString());
		int id2 = Integer.parseInt(configs[2].toString());
		//DarkDirt
		darkDirt = new BlockDarkDirt(id1,0).setBlockName("DarkDirt");
		GameRegistry.registerBlock(darkDirt);
		LanguageRegistry.addName(darkDirt, "Dark Dirt");
		//Asphalt
		asphalt = new BlockAsphalt(id2).setBlockName("BlockAsphalt");
		GameRegistry.registerBlock(asphalt);
		Item.itemsList[id2]= new ItemBlockAsphalt(id2-256, asphalt).setItemName("BlockAsphalt");
		for (int ix = 0; ix < 2; ix++) {
			ItemStack multiBlockStack = new ItemStack(asphalt, 1, ix);
			LanguageRegistry.addName(multiBlockStack, subNames[multiBlockStack.getItemDamage()]);
		}
		//Asphaltator
		asphaltator = new ItemAsphaltator(2003);
		GameRegistry.registerItem(asphaltator, "Asphaltator");
	}
}
