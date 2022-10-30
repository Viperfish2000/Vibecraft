package com.viperfish2000.vscomod.client.renderer;

import com.viperfish2000.vscomod.client.models.StrawberryBeeModel;
import com.viperfish2000.vscomod.entity.StrawberryBeeEntity;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class StrawberryBeeRenderer  extends MobRenderer<StrawberryBeeEntity, StrawberryBeeModel<StrawberryBeeEntity>> {
	   private static final ResourceLocation StrawberryBee_TEXTURE = new ResourceLocation("vscomod:textures/entity/strawberry_bee.png");


	   public StrawberryBeeRenderer(EntityRendererManager renderManagerIn) {
	      super(renderManagerIn, new StrawberryBeeModel<>(), 0.4F);
	    
	   }

	   public ResourceLocation getEntityTexture(StrawberryBeeEntity entity) {
		return StrawberryBee_TEXTURE;
	   }
   
   public static class RenderFactory implements IRenderFactory<StrawberryBeeEntity>{

	@Override
	public EntityRenderer<? super StrawberryBeeEntity> createRenderFor(EntityRendererManager manager) {
	
		return new StrawberryBeeRenderer(manager);
	}
	   
   }
}