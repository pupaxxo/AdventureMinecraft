package com.pupaxxo.adventureminecraft.proxy;
import net.minecraftforge.client.MinecraftForgeClient;


import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxyTutorial extends CommonProxyTutorial
{
 @Override
    public void registerRenderThings()
    {
	 MinecraftForgeClient.preloadTexture("/com/pupaxxo/adventureminecraft/resources/terrains.png");
    }
 
}