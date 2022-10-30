package com.viperfish2000.vscomod.client.renderer;

import com.mojang.blaze3d.platform.GLX;
import com.mojang.blaze3d.platform.GlStateManager;
import com.viperfish2000.vscomod.client.models.YodaModel;
import com.viperfish2000.vscomod.entity.YodaEntity;
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
public class YodaRenderer  extends MobRenderer<YodaEntity, YodaModel<YodaEntity>> {
	   private static final ResourceLocation YODA_TEXTURES = new ResourceLocation("vscomod:textures/entity/yoda.png");
	   private static final ResourceLocation TAMED_YODA_TEXTURES = new ResourceLocation("vscomod:textures/entity/hedgehog_tame.png");
	   private static final ResourceLocation TAMED_YODA_CHILD_TEXTURES = new ResourceLocation("vscomod:textures/entity/hedgehog_tame_child.png");
	   private static final ResourceLocation YODA_CHILD_TEXTURES = new ResourceLocation("vscomod:textures/entity/hedgehog_child.png");

	   public YodaRenderer(EntityRendererManager renderManagerIn) {
	      super(renderManagerIn, new YodaModel<>(), 0.2F);
	      //this.addLayer(new WolfCollarLayer(this));
	   }

	   protected float handleRotationFloat(WolfEntity livingBase, float partialTicks) {
	      return livingBase.getTailRotation();
	   }

	
	   public ResourceLocation getEntityTexture(YodaEntity entity) {
	    
	    		  return YODA_TEXTURES;		
	    
	   }
   
   public static class RenderFactory implements IRenderFactory<YodaEntity>{

	@Override
	public EntityRenderer<? super YodaEntity> createRenderFor(EntityRendererManager manager) {
	
		return new YodaRenderer(manager);
	}
	   
   }
}