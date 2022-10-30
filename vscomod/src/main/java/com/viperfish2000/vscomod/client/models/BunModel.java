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


public class BunModel extends BipedModel<LivingEntity>  {
	private final ModelRenderer bun1;
	private final ModelRenderer bun2;


	public BunModel(float modelSize, float yOffsetIn, int textureWidthIn, int textureHeightIn) {
		super(modelSize, yOffsetIn, textureWidthIn, textureHeightIn);
		textureWidth = 64;
		textureHeight = 64;

		bun1 = new ModelRenderer(this);
		bun1.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(bun1, -0.7285F, 0.0F, 0.0F);
		bun1.setTextureOffset(0, 52).addBox(-2.0F, -10.0F, -4.5F, 4.0F, 1.0F, 4.0F, 0.0F, false);

		bun2 = new ModelRenderer(this);
		bun2.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(bun2, -0.7285F, 0.0F, 0.0F);
		bun2.setTextureOffset(0, 57).addBox(-2.5F, -9.4F, -5.0F, 5.0F, 2.0F, 5.0F, 0.0F, false);
		this.bipedHead.addChild(bun1);
		this.bipedHead.addChild(bun2);
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