package com.viperfish2000.vscomod.client.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.viperfish2000.vscomod.client.models.KoiModel;
import com.viperfish2000.vscomod.entity.KoiEntity;

import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.entity.passive.BatEntity;
import net.minecraft.entity.passive.fish.SalmonEntity;
import net.minecraft.entity.passive.fish.TropicalFishEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class KoiRenderer extends MobRenderer<KoiEntity, KoiModel<KoiEntity>> {
   private static final ResourceLocation TUI = new ResourceLocation("vscomod:textures/entity/koi/tui.png");
   private static final ResourceLocation LA = new ResourceLocation("vscomod:textures/entity/koi/la.png");
   private static final ResourceLocation HIKARI = new ResourceLocation("vscomod:textures/entity/koi/hikari.png");
   private static final ResourceLocation TANCHO = new ResourceLocation("vscomod:textures/entity/koi/tancho.png");
   private static final ResourceLocation DOITSU = new ResourceLocation("vscomod:textures/entity/koi/doitsu.png");
   private static final ResourceLocation YAMABUKI_OGON = new ResourceLocation("vscomod:textures/entity/koi/yamabuki_ogon.png");
   private static final ResourceLocation ASAGI = new ResourceLocation("vscomod:textures/entity/koi/asagi.png");
   private static final ResourceLocation HAJIRO = new ResourceLocation("vscomod:textures/entity/koi/hajiro.png");
   private static final ResourceLocation KOHAKU = new ResourceLocation("vscomod:textures/entity/koi/kohaku.png");
   private static final ResourceLocation BENIGOI = new ResourceLocation("vscomod:textures/entity/koi/benigoi.png");

   public KoiRenderer(EntityRendererManager renderManagerIn) {
      super(renderManagerIn, new KoiModel<>(), 0.3F);
   }

 
   /** public static final ResourceLocation[] BUTTERFLY_TEXTURES = new ResourceLocation[]{new ResourceLocation("vscomod:textures/entity/morpho.png"), new ResourceLocation("vscomod:textures/entity/cabbage.png"), new ResourceLocation("vscomod:textures/entity/monarch.png"), new ResourceLocation("vscomod:textures/entity/swallowtail.png")};
   protected ResourceLocation getEntityTexture(KoiEntity entity) {
	      return BUTTERFLY_TEXTURES[entity.getVariant()];
}   
   **/
   public ResourceLocation getEntityTexture(KoiEntity entity) {
      String s = TextFormatting.getTextWithoutFormattingCodes(entity.getName().getString());
      if (s != null && "Tui".equals(s)) {
         return TUI;
      }
      else if (s != null && "La".equals(s)) {
          return LA;
       } 
      else {
         switch(entity.getVariant()) {
         case 0:
         default:
            return HIKARI;
         case 1:
            return TANCHO;
         case 2:
            return DOITSU;
         case 3:
        	 return YAMABUKI_OGON;
         case 4:
        	 return HAJIRO;
         case 5:
        	 return KOHAKU;
         case 6:
        	 return BENIGOI;
         case 7:
        	 return ASAGI;
         }}
      }
   /**
   protected void preRenderCallback(KoiEntity entitylivingbaseIn, float partialTickTime) {
	      GlStateManager.scalef(0.09F, 0.09F, 0.09F);
	   }
 **/
   protected void applyRotations(KoiEntity entityLiving, MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
	      super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
	      float f = 1.0F;
	      float f1 = 1.0F;
	      if (!entityLiving.isInWater()) {
	         f = 1.3F;
	         f1 = 1.7F;
	      }

	      float f2 = f * 4.3F * MathHelper.sin(f1 * 0.6F * ageInTicks);
	      matrixStackIn.rotate(Vector3f.YP.rotationDegrees(f2));
	      matrixStackIn.translate(0.0D, 0.0D, (double)-0.4F);
	      if (!entityLiving.isInWater()) {
	         matrixStackIn.translate((double)0.2F, (double)0.1F, 0.0D);
	         matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90.0F));
	      }

	   }
   public static class RenderFactory implements IRenderFactory<KoiEntity>{

	@Override
	public EntityRenderer<? super KoiEntity> createRenderFor(EntityRendererManager manager) {
	
		return new KoiRenderer(manager);
	}
	   
   }
}