package com.pupaxxo.adventureminecraft.creativetab;

import net.minecraft.creativetab.CreativeTabs;

import com.pupaxxo.adventureminecraft.item.Items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CreativeTabAM extends CreativeTabs{
	public CreativeTabAM(int par1, String par2Str) 
	{
       super(par1, par2Str);
    }

    @SideOnly(Side.CLIENT)
    /**
     * the itemID for the item to be displayed on the tab
     */
    public int getTabIconItemIndex() {

        return Items.asphaltator.itemID;
    }
}
