package com.pupaxxo.adventureminecraft.item;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.pupaxxo.adventureminecraft.AdventureMinecraft;
import com.pupaxxo.adventureminecraft.blocks.Blocks;

public class ItemAsphaltator extends Item{
	 public ItemAsphaltator(int id)
     {
           super(id);
           this.setMaxDamage(64);
           this.maxStackSize = 1;
           this.setIconIndex(3);
           setHasSubtypes(true);
           this.setCreativeTab(AdventureMinecraft.tabsAM);
     }
    
     public String getTextureFile()
     {
          return "/com/pupaxxo/adventureminecraft/resources/terrains.png";
     }
     public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
     {
    	 if (par3World.getBlockId(par4, par5, par6) != Blocks.asphalt.blockID) {
    	par2EntityPlayer.dropItem(par3World.getBlockId(par4, par5, par6), 1);
    	 par1ItemStack.damageItem(1, par2EntityPlayer);
    	 par3World.setBlock(par4, par5, par6, Blocks.asphalt.blockID);
         return true; } else {
        	 return false;
         }
     }
     public void getSubBlocks(int i,CreativeTabs tab, List list)
     {
    	 list.add(new ItemStack(i,1,0));
    	 list.add(new ItemStack(i,1,1));
    	 list.add(new ItemStack(i,1,2));
    	 list.add(new ItemStack(i,1,3));
     } 
     public int getMetadata(int i)
     {
    	 return i;
     }
     public int getIconFromDamage(int metadata)
     {
    	 switch (metadata)
    	 {
    	 	default: return 3;
    	 }
     }
     
}
