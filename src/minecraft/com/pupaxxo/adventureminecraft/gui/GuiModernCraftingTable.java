package com.pupaxxo.adventureminecraft.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import com.pupaxxo.adventureminecraft.tile.TileModernCraftingTable;

public class GuiModernCraftingTable extends GuiContainer{



	public GuiModernCraftingTable(InventoryPlayer par1Container,TileModernCraftingTable tile_entity) {
		super(new ContainerModernCraftingTable(tile_entity, par1Container));
	}

	//@Override
	protected void drawGuiContainerForegroundLayer(){
		fontRenderer.drawString("Tutorial Gui", 6, 6, 0xffffff);
		fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 6, ySize - 96 + 2, 0xffffff);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2,int var3) 
	{
		int picture = mc.renderEngine.getTexture("<path>");
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.renderEngine.bindTexture(picture);
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}
}
