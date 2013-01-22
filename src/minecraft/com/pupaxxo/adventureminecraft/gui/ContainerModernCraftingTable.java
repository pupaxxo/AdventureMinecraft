package com.pupaxxo.adventureminecraft.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.pupaxxo.adventureminecraft.tile.TileModernCraftingTable;

public class ContainerModernCraftingTable extends Container {
	protected TileModernCraftingTable tile_entity;
	public ContainerModernCraftingTable(TileModernCraftingTable tile_entity, InventoryPlayer player_inventory)
	{
		this.tile_entity = tile_entity;
		addSlotToContainer(new Slot(tile_entity, 0, 76, 27));
		bindPlayerInventory(player_inventory);
	}
	@Override
	public boolean canInteractWith(EntityPlayer var1) {
		return tile_entity.isUseableByPlayer(var1);
	}
	protected void bindPlayerInventory(InventoryPlayer player_inventory){
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 9; j++){
				addSlotToContainer(new Slot(player_inventory, j + i * 9 + 9, 9 + j * 18, 64 + i * 16));
			}
		}

			for(int i = 0; i < 9; i++){
				addSlotToContainer(new Slot(player_inventory, i, 6 + i * 16, 142));
			}
		}
	/**	@Override
	public ItemStack transferStackInSlot(int slot_index){
		ItemStack stack = null;
		Slot slot_object = (Slot) inventorySlots.get(slot_index);
			if(slot_object != null && slot_object.getHasStack()){
				ItemStack stack_in_slot = slot_object.getStack();
				stack = stack_in_slot.copy();
				if(slot_index == 0){
						if(!mergeItemStack(stack_in_slot, 1, inventorySlots.size(), true)){
							return null;
						}
				} else if(!mergeItemStack(stack_in_slot, 0, 1, false)){
					return null;
				}

				if(stack_in_slot.stackSize == 0){
					slot_object.putStack(null);
				} else{
					slot_object.onSlotChanged();
				}
			}
		return stack;
	} */
}
