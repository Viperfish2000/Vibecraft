package com.viperfish2000.vscomod.client.renderer;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderRegistry {
@OnlyIn(Dist.CLIENT)
	public static void registryEntityRenderers()
	{
		//RenderingRegistry.registerEntityRenderingHandler(VSCODecal2.class, new VSCODecalRenderer.RenderFactory());
	}
}
