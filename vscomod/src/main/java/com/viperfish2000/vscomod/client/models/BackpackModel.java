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


public class BackpackModel extends BipedModel<LivingEntity>  {
	private final ModelRenderer back;
	private final ModelRenderer back_1;
	private final ModelRenderer back_2;
	private final ModelRenderer back_3;
	private final ModelRenderer back_4;
	private final ModelRenderer back_5;
	private final ModelRenderer back_6;
	private final ModelRenderer back_7;
	private final ModelRenderer back_9;
	private final ModelRenderer back_10;
	private final ModelRenderer back_11;

	public BackpackModel(float modelSize, float yOffsetIn, int textureWidthIn, int textureHeightIn) {
		super(modelSize, yOffsetIn, textureWidthIn, textureHeightIn);
		textureWidth = 64;
		textureHeight = 64;
		back = new ModelRenderer(this);
		back.setRotationPoint(2.0F, 9.8F, 5.4F);
		setRotationAngle(back, -2.0033F, 0.0F, 0.0F);
		back.setTextureOffset(19, 3).addBox(-4.0F, 0.0F, -2.0F, 4.0F, 2.0F, 3.0F, 0.0F, false);

		back_1 = new ModelRenderer(this);
		back_1.setRotationPoint(1.5F, 10.0F, 4.0F);
		back_1.setTextureOffset(29, 11).addBox(-4.0F, 0.0F, -2.0F, 5.0F, 1.0F, 2.0F, 0.0F, false);

		back_2 = new ModelRenderer(this);
		back_2.setRotationPoint(1.5F, 0.9F, 6.3F);
		setRotationAngle(back_2, 0.182F, 0.0F, 0.0F);
		back_2.setTextureOffset(5, 9).addBox(-4.0F, 0.0F, -2.0F, 5.0F, 6.0F, 0.0F, 0.0F, false);

		back_3 = new ModelRenderer(this);
		back_3.setRotationPoint(1.5F, 2.8F, 6.1F);
		setRotationAngle(back_3, -0.6145F, 0.0F, 0.0F);
		back_3.setTextureOffset(16, 11).addBox(-4.0F, 0.0F, -2.0F, 5.0F, 2.0F, 0.0F, 0.0F, false);

		back_4 = new ModelRenderer(this);
		back_4.setRotationPoint(0.0F, 0.0F, 4.01F);
		back_4.setTextureOffset(16, 31).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 0.0F, 0.0F, false);

		back_5 = new ModelRenderer(this);
		back_5.setRotationPoint(0.0F, 0.0F, 0.0F);
		back_5.setTextureOffset(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 0.0F, 0.0F, false);

		back_6 = new ModelRenderer(this);
		back_6.setRotationPoint(6.01F, 0.0F, -2.0F);
		setRotationAngle(back_6, 0.0F, 1.5708F, 0.0F);
		back_6.setTextureOffset(6, 16).addBox(-4.0F, 0.0F, -2.0F, 4.0F, 12.0F, 0.0F, 0.0F, true);

		back_7 = new ModelRenderer(this);
		back_7.setRotationPoint(-2.01F, 0.0F, -2.0F);
		setRotationAngle(back_7, 0.0F, 1.5708F, 0.0F);
		back_7.setTextureOffset(6, 16).addBox(-4.0F, 0.0F, -2.0F, 4.0F, 12.0F, 0.0F, 0.0F, true);

		back_9 = new ModelRenderer(this);
		back_9.setRotationPoint(1.5F, 3.0F, 4.0F);
		back_9.setTextureOffset(3, 4).addBox(-4.0F, 0.0F, -2.0F, 5.0F, 2.0F, 2.0F, 0.0F, false);

		back_10 = new ModelRenderer(this);
		back_10.setRotationPoint(3.5F, 5.0F, 7.1F);
		back_10.setTextureOffset(49, 32).addBox(-4.0F, 0.0F, -2.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);

		back_11 = new ModelRenderer(this);
		back_11.setRotationPoint(1.0F, 5.0F, 4.0F);
		back_11.setTextureOffset(35, 0).addBox(-4.0F, 0.0F, -2.0F, 6.0F, 5.0F, 3.0F, 0.0F, false);
	}


	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		super.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		back.render(matrixStack, buffer, packedLight, packedOverlay);
		back_1.render(matrixStack, buffer, packedLight, packedOverlay);
		back_2.render(matrixStack, buffer, packedLight, packedOverlay);
		back_3.render(matrixStack, buffer, packedLight, packedOverlay);
		back_4.render(matrixStack, buffer, packedLight, packedOverlay);
		back_5.render(matrixStack, buffer, packedLight, packedOverlay);
		back_6.render(matrixStack, buffer, packedLight, packedOverlay);
		back_7.render(matrixStack, buffer, packedLight, packedOverlay);
		back_9.render(matrixStack, buffer, packedLight, packedOverlay);
		back_10.render(matrixStack, buffer, packedLight, packedOverlay);
		back_11.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}