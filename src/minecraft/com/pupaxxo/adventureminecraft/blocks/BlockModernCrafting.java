package com.pupaxxo.adventureminecraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.pupaxxo.adventureminecraft.AdventureMinecraft;

public class BlockModernCrafting extends Block{

	public BlockModernCrafting(int par1, int par2) {
		super(par1, par2, Material.rock);
		this.setCreativeTab(AdventureMinecraft.tabsAM);
	}
	public String getTextureFile() {
	    return "/com/pupaxxo/adventureminecraft/resources/terrainsHD.png";
	}
	public int getBlockTextureFromSideAndMetadata(int par1, int par2){
		switch (par1) {
		case 1:
			return 1;
		case 0:
			return 1;
		default:
			return 0;
		}
	}

    @Override
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
            par5EntityPlayer.displayGUIWorkbench(par2, par3, par4);
            return true;
        
    }
}
