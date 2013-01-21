package com.pupaxxo.adventureminecraft.dimension;

import net.minecraftforge.common.DimensionManager;

public class Dimension {
	public static int dim1ID;
	public static void DimensionInit() {
		dim1ID = DimensionManager.getNextFreeDimId();
		DimensionManager.registerProviderType(dim1ID, WorldProviderDim1.class, false);
		DimensionManager.registerDimension(dim1ID, dim1ID);
	}
}
