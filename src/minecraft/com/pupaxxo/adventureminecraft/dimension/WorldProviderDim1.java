package com.pupaxxo.adventureminecraft.dimension;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderDim1 extends WorldProvider
{
	 public void registerWorldChunkManager()
	 {
	  this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.beach, 0.8F, 0.1F);
	  this.dimensionId = Dimension.dim1ID;
	 }
	 
	 public String getDimensionName() 
	 {
	  return "Tutorial";
	 }
	 
	 public boolean canRespawnHere()
	 {
	  return true;
	 }
	 
	 @Override
	 public IChunkProvider createChunkGenerator()
	 {
	  return new ChunkProviderDim1(worldObj, worldObj.getSeed(), true);
	 }
	}
