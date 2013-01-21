package com.pupaxxo.adventureminecraft.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockAsphalt extends Block{

	public BlockAsphalt(int id) {
		super(id, Material.rock);
		this.setHardness(100.0F);
		this.setResistance(4000.0F);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	public String getTextureFile()
    {
        return "/com/pupaxxo/adventureminecraft/resources/terrains.png";
    }
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
	{
	    for (int var4 = 0; var4 < 2; ++var4)
	    {
	    	par3List.add(new ItemStack(par1, 1, var4));
	    }
	}
	@Override
	public int damageDropped (int metadata) {
		return metadata;
	}
	public int getBlockTextureFromSideAndMetadata(int par1, int par2)
	{
		switch(par2) 
		{
		case 0:
			return 1;
		case 1:
			return 2;
		default:
			return 1;
		}
	}
}
