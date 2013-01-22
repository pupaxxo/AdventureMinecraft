package com.pupaxxo.adventureminecraft.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.pupaxxo.adventureminecraft.gui.ContainerModernCraftingTable;
import com.pupaxxo.adventureminecraft.gui.GuiModernCraftingTable;
import com.pupaxxo.adventureminecraft.tile.TileModernCraftingTable;

import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{
	// This is a required method to open you Gui and has 6 params
	// @param int id, this is the Gui Id
	// @param EntityPlayer, this is the player declaration
	// @param World, this is the world declaration
	// @param int x, y, z this is the players current x, y, z coords
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z){
	// This gets the TileEntity the player is currently activating
	TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
	// This checks if the TileEntity is the TileTutorial
	if(tile_entity instanceof TileModernCraftingTable){
	// If it is it returns a new ContainerTutorial instance
	return new ContainerModernCraftingTable((TileModernCraftingTable) tile_entity, player.inventory);
	}

	// Returns null if not
	return null;
	}

	// This is another required method to open the Gui and has 6 params
	// @param int id, this is the Gui Id
	// @param EntityPlayer, this is the player declaration
	// @param World, this is the world declaration,
	// @param int x, y, z this is the players current x, y, z coords
	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z){
	// This gets the TIleEntity the player is currently activating
	TileEntity tile_entity = world.getBlockTileEntity(x, y, z);

	// This checks if the TileEntity is the TileTutorial
	if(tile_entity instanceof TileModernCraftingTable){
	// If it is it returns a new GuiTutorial instance
	return new GuiModernCraftingTable(player.inventory, (TileModernCraftingTable) tile_entity);
	}

	// Returns null if not
	return null;
	}
	}
