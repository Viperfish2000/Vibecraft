package com.viperfish2000.vscomod.client.renderer;

import com.viperfish2000.vscomod.client.models.BisonModel;
import com.viperfish2000.vscomod.entity.BisonEntity;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class BisonRenderer  extends MobRenderer<BisonEntity, BisonModel<BisonEntity>> {
	   private static final ResourceLocation BISON_TEXTURE = new ResourceLocation("vscomod:textures/entity/appa.png");
	private static int scale;
	private static float height;
	 

	   public BisonRenderer(EntityRendererManager renderManagerIn) {
	      super(renderManagerIn, new BisonModel<>(), 4.2F);
	    
	   }

	   protected float handleRotationFloat(WolfEntity livingBase, float partialTicks) {
	      return livingBase.getTailRotation();
	   }

	  

	   public ResourceLocation getEntityTexture(BisonEntity entity) {
		return BISON_TEXTURE;
	    
	
	   
	   }
   
   public static class RenderFactory implements IRenderFactory<BisonEntity>{

	@Override
	public EntityRenderer<? super BisonEntity> createRenderFor(EntityRendererManager manager) {
	
		return new BisonRenderer(manager);
	}
	   
   }
}