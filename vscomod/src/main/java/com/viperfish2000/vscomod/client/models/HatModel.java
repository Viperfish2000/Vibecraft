package com.viperfish2000.vscomod.client.models;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


@OnlyIn(Dist.CLIENT)
public class HatModel extends BipedModel<LivingEntity> {

	private final ModelRenderer bone3;

	public HatModel(float modelSize, float yOffsetIn, int textureWidthIn, int textureHeightIn) {
		super(modelSize, yOffsetIn, textureWidthIn, textureHeightIn);
		 
		textureWidth = 128;
		textureHeight = 128;

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(4.0F, -4.0F, -0.5F);
		bone3.setTextureOffset(0, 114).addBox(-8.5F, -6.1F, -4.25F, 9.0F, 5.0F, 9.0F, 0.0F, false);
		bone3.setTextureOffset(13, 105).addBox(-15.5F, -1.0F, -11.25F, 23.0F, 0.0F, 23.0F, 0.0F, false);
		bone3.setTextureOffset(13, 82).addBox(-15.5F, -0.93F, -11.25F, 23.0F, 0.0F, 23.0F, 0.0F, false);
		bone3.setTextureOffset(13, 105).addBox(-15.5F, -1.0F, -11.25F, 23.0F, 0.0F, 23.0F, 0.0F, false);
		this.bipedHead.addChild(bone3);
	}


	@Override
	public void setRotationAngles(LivingEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		super.setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		
		
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		super.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	
	}
    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
