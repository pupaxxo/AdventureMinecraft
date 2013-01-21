package com.pupaxxo.adventureminecraft.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.pupaxxo.adventureminecraft.blocks.BlockAsphalt;
import com.pupaxxo.adventureminecraft.blocks.BlockDarkDirt;
import com.pupaxxo.adventureminecraft.blocks.itemBlock.ItemBlockAsphalt;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Items {
	public static Item asphaltator;
	public static void registerItems(Object[] configs){
		//ID
		int id1 = Integer.parseInt(configs[1].toString());
		int id2 = Integer.parseInt(configs[2].toString());
		int id3 = Integer.parseInt(configs[3].toString());
		//Asphaltator
		asphaltator = new ItemAsphaltator(id3).setItemName("Asphaltator");
		GameRegistry.registerItem(asphaltator, "Asphaltator");
		LanguageRegistry.addName(asphaltator, "Asphaltator");
	}
}
