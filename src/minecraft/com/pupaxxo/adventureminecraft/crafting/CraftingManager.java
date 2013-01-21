package com.pupaxxo.adventureminecraft.crafting;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

import com.pupaxxo.adventureminecraft.blocks.Blocks;
import com.pupaxxo.adventureminecraft.item.Items;

import cpw.mods.fml.common.registry.GameRegistry;

public class CraftingManager {
	public static void Crafting() {
		//Crafting for asphalt
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.asphalt,1), new ItemStack(Block.stone) , new ItemStack(Item.coal), new ItemStack(Item.coal));
		//Crafting for white asphalt
		FurnaceRecipes.smelting().addSmelting(Blocks.asphalt.blockID, 0, new ItemStack(Blocks.asphalt.blockID, 1, 1), 0f);
		//Crafting for asphaltator
		GameRegistry.addRecipe(new ItemStack(Items.asphaltator), "QWE", "WRT", "RTY",'Q', new ItemStack(Block.stone), 'W', new ItemStack(Item.coal) , 'E' , new ItemStack(Item.diamond) , 'R' , new ItemStack(Item.stick) , 'T' , new ItemStack(287 , 1 ,0) , 'Y' , new ItemStack(351 , 1 ,14));
	}
}
