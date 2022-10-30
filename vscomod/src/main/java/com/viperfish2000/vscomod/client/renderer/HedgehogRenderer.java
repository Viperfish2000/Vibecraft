package com.viperfish2000.vscomod.client.renderer;

import com.mojang.blaze3d.platform.GLX;
import com.mojang.blaze3d.platform.GlStateManager;
import com.viperfish2000.vscomod.client.models.HedgehogModel;
import com.viperfish2000.vscomod.entity.HedgehogEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.WolfCollarLayer;
import net.minecraft.client.renderer.entity.model.WolfModel;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.texture.PaintingSpriteUploader;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.item.PaintingType;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class HedgehogRenderer  extends MobRenderer<HedgehogEntity, HedgehogModel<HedgehogEntity>> {
	   private static final ResourceLocation HEDGEHOG_TEXTURES = new ResourceLocation("vscomod:textures/entity/hedgehog.png");
	   private static final ResourceLocation TAMED_HEDGEHOG_TEXTURES = new ResourceLocation("vscomod:textures/entity/hedgehog_tame.png");
	   private static final ResourceLocation TAMED_HEDGEHOG_CHILD_TEXTURES = new ResourceLocation("vscomod:textures/entity/hedgehog_tame_child.png");
	   private static final ResourceLocation HEDGEHOG_CHILD_TEXTURES = new ResourceLocation("vscomod:textures/entity/hedgehog_child.png");

	   public HedgehogRenderer(EntityRendererManager renderManagerIn) {
	      super(renderManagerIn, new HedgehogModel<>(), 0.2F);
	      //this.addLayer(new WolfCollarLayer(this));
	   }

	   protected float handleRotationFloat(WolfEntity livingBase, float partialTicks) {
	      return livingBase.getTailRotation();
	   }


	   public ResourceLocation getEntityTexture(HedgehogEntity entity) {
	      if (entity.isTamed()) {
	        if (entity.isChild()){
	    	  return TAMED_HEDGEHOG_CHILD_TEXTURES;
	        }
	        else {
	        return TAMED_HEDGEHOG_TEXTURES;
	        }
	      }
	      
	      else {
	    	  if (entity.isChild()) {
	    		   return HEDGEHOG_CHILD_TEXTURES;		  
	    	  }
	    	  else {
	    		  return HEDGEHOG_TEXTURES;		
	    	  }
	      }
	   
	   }
   
   public static class RenderFactory implements IRenderFactory<HedgehogEntity>{

	@Override
	public EntityRenderer<? super HedgehogEntity> createRenderFor(EntityRendererManager manager) {
	
		return new HedgehogRenderer(manager);
	}
	   
   }
}