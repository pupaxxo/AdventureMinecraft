package com.pupaxxo.adventureminecraft.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.pupaxxo.adventureminecraft.container.ContainerModernCrafting;
import com.pupaxxo.adventureminecraft.gui.GuiModernCrafting;
import com.pupaxxo.adventureminecraft.tileentity.TileEntityModernCrafting;

import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
    //returns an instance of the Container you made earlier
    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world,
                    int x, int y, int z) {
            TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
            if(tileEntity instanceof TileEntityModernCrafting){
                    return new ContainerModernCrafting(player.inventory, (TileEntityModernCrafting) tileEntity);
            }
            return null;
    }

    //returns an instance of the Gui you made earlier
    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world,
                    int x, int y, int z) {
            TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
            if(tileEntity instanceof TileEntityModernCrafting){
                    return new GuiModernCrafting(player.inventory, (TileEntityModernCrafting) tileEntity);
            }
            return null;

    }
}