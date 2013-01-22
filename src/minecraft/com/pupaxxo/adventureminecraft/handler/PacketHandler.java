package com.pupaxxo.adventureminecraft.handler;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;

public class PacketHandler implements IPacketHandler{
	@Override
    public void onPacketData(INetworkManager manager,Packet250CustomPayload packet, Player playerEntity) 
	{
		Side side = FMLCommonHandler.instance().getEffectiveSide();
		if (side == Side.SERVER) {
			DataInputStream data = new DataInputStream(new ByteArrayInputStream(packet.data));
			EntityPlayer sender = (EntityPlayer) playerEntity;
		} else if (side == Side.CLIENT) {
			DataInputStream data = new DataInputStream(new ByteArrayInputStream(packet.data));
		} else {
		}
    }

}
