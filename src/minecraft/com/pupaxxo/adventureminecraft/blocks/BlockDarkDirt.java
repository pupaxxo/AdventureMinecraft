package com.pupaxxo.adventureminecraft.blocks;

import com.pupaxxo.adventureminecraft.AdventureMinecraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockDarkDirt extends Block{

	public BlockDarkDirt(int id, int Texture) {
		super(id, Texture, Material.dragonEgg);
		this.setCreativeTab(AdventureMinecraft.tabsAM);
	}
	public String getTextureFile()
    {
            return "/com/pupaxxo/adventureminecraft/resources/terrains.png";
    }
}
