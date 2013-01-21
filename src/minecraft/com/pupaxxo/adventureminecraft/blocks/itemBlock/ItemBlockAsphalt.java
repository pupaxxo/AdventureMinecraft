package com.pupaxxo.adventureminecraft.blocks.itemBlock;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockAsphalt extends ItemBlock{
	private final static String[] subNames ={"Asphalt", "White Aspahlt"};
	public ItemBlockAsphalt(int id, Block block) {
		super(id);
		setHasSubtypes(true);
		setItemName("BlockAsphalt");
	}
	
	@Override
	public int getMetadata (int damageValue) {
		return damageValue;
	}
	
	@Override
	public String getItemNameIS(ItemStack itemstack) {
		return getItemName() + "." + subNames[itemstack.getItemDamage()];
	}
}
