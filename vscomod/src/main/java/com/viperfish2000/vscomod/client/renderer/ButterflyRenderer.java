package com.viperfish2000.vscomod.client.renderer;

import com.viperfish2000.vscomod.client.models.ButterflyModel;
import com.viperfish2000.vscomod.entity.ButterflyEntity;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class ButterflyRenderer extends MobRenderer<ButterflyEntity, ButterflyModel<ButterflyEntity>> {
   private static final ResourceLocation MORPHO = new ResourceLocation("vscomod:textures/entity/morpho.png");
   private static final ResourceLocation CABBAGE = new ResourceLocation("vscomod:textures/entity/cabbage.png");
   private static final ResourceLocation MONARCH = new ResourceLocation("vscomod:textures/entity/monarch.png");
   private static final ResourceLocation SWALLOWTAIL = new ResourceLocation("vscomod:textures/entity/swallowtail.png");


   public ButterflyRenderer(EntityRendererManager renderManagerIn) {
      super(renderManagerIn, new ButterflyModel<>(), 0.3F);
   }

 
   /** public static final ResourceLocation[] BUTTERFLY_TEXTURES = new ResourceLocation[]{new ResourceLocation("vscomod:textures/entity/morpho.png"), new ResourceLocation("vscomod:textures/entity/cabbage.png"), new ResourceLocation("vscomod:textures/entity/monarch.png"), new ResourceLocation("vscomod:textures/entity/swallowtail.png")};
   protected ResourceLocation getEntityTexture(ButterflyEntity entity) {
	      return BUTTERFLY_TEXTURES[entity.getVariant()];
}   
   **/
   public ResourceLocation getEntityTexture(ButterflyEntity entity) {
      String s = TextFormatting.getTextWithoutFormattingCodes(entity.getName().getString());
      if (s != null && "Toast".equals(s)) {
         return SWALLOWTAIL;
      } else {
         switch(entity.getButterflyType()) {
         case 0:
         default:
            return MORPHO;
         case 1:
            return CABBAGE;
         case 2:
            return MONARCH;
         case 3:
        	 return SWALLOWTAIL;
        
         }}
      }
 
   public static class RenderFactory implements IRenderFactory<ButterflyEntity>{

	@Override
	public EntityRenderer<? super ButterflyEntity> createRenderFor(EntityRendererManager manager) {
	
		return new ButterflyRenderer(manager);
	}
	   
   }
}