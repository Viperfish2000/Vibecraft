package com.viperfish2000.vscomod.client.models;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;

// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


public class PonytailModel extends BipedModel<LivingEntity>  {
	private final ModelRenderer band;
	private final ModelRenderer pontail;
	private final ModelRenderer pontail2;


	public PonytailModel(float modelSize, float yOffsetIn, int textureWidthIn, int textureHeightIn) {
		super(modelSize, yOffsetIn, textureWidthIn, textureHeightIn);
		textureWidth = 64;
		textureHeight = 64;

		band = new ModelRenderer(this);
		band.setRotationPoint(0.0F, -0.6F, 0.0F);
		setRotationAngle(band, -0.2321F, 0.0F, 0.0F);
		band.setTextureOffset(12, 60).addBox(-1.0F, -7.0F, 2.2F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		pontail = new ModelRenderer(this);
		pontail.setRotationPoint(2.0F, -2.0F, -0.2F);
		setRotationAngle(pontail, 0.0257F, 0.0F, 0.0F);
		pontail.setTextureOffset(0, 50).addBox(-4.0F, -3.8F, 5.0F, 4.0F, 12.0F, 2.0F, 0.0F, false);

		pontail2 = new ModelRenderer(this);
		pontail2.setRotationPoint(2.5F, 9.8F, 0.1F);
		pontail2.setTextureOffset(20, 62).addBox(-4.0F, -3.8F, 5.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		bipedHead.addChild(band);
		bipedHead.addChild(pontail);
		bipedHead.addChild(pontail2);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLight, int packedOverlayIn, float red, float green, float blue, float alpha){
		super.render(matrixStackIn, bufferIn, packedLight, packedOverlayIn, red, green, blue, alpha);

	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}