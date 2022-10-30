package com.viperfish2000.vscomod.client.models;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.viperfish2000.vscomod.entity.KoiEntity;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


public class KoiModel<T extends KoiEntity> extends EntityModel<T>  {
	private final ModelRenderer body;
	private final ModelRenderer tailfin;
	private final ModelRenderer leftFin2;
	private final ModelRenderer leftFin;
	private final ModelRenderer rightFin;
	private final ModelRenderer rightFin2;

	public KoiModel() {
		textureWidth = 32;
		textureHeight = 32;

		body = new ModelRenderer(this);
		body.setRotationPoint(-0.5F, 23.0F, 0.0F);
		body.setTextureOffset(0, 0).addBox(-0.5F, -3.0F, -7.0F, 3.0F, 4.0F, 13.0F, 0.0F, false);
		body.setTextureOffset(0, 10).addBox(1.0F, -6.0F, -1.9992F, 0.0F, 3.0F, 7.0F, 0.0F, false);
		body.setTextureOffset(0, 6).addBox(1.0F, 1.0F, 2.0008F, 0.0F, 2.0F, 4.0F, 0.0F, false);

		tailfin = new ModelRenderer(this);
		tailfin.setRotationPoint(0.5F, -1.0F, 6.0F);
		body.addChild(tailfin);
		tailfin.setTextureOffset(0, 0).addBox(0.5F, -2.5F, 0.0F, 0.0F, 5.0F, 5.0F, 0.0F, false);

		leftFin2 = new ModelRenderer(this);
		leftFin2.setRotationPoint(2.5F, 1.0F, 1.0F);
		body.addChild(leftFin2);
		setRotationAngle(leftFin2, 0.0F, -1.5708F, -0.7854F);
		leftFin2.setTextureOffset(4, 3).addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);

		leftFin = new ModelRenderer(this);
		leftFin.setRotationPoint(2.5F, 1.0F, 1.0F);
		body.addChild(leftFin);
		setRotationAngle(leftFin, 0.0F, -1.5708F, -0.7854F);
		leftFin.setTextureOffset(9, 10).addBox(-5.0F, -0.7071F, -0.7071F, 2.0F, 3.0F, 0.0F, 0.0F, false);

		rightFin = new ModelRenderer(this);
		rightFin.setRotationPoint(-0.5F, 0.0F, -4.0F);
		body.addChild(rightFin);
		setRotationAngle(rightFin, 0.0F, -1.5708F, 0.7854F);
		rightFin.setTextureOffset(9, 7).addBox(0.0F, 0.0F, 0.0F, 2.0F, 3.0F, 0.0F, 0.0F, false);

		rightFin2 = new ModelRenderer(this);
		rightFin2.setRotationPoint(-0.5F, 1.0F, 2.0F);
		body.addChild(rightFin2);
		setRotationAngle(rightFin2, 0.0F, -1.5708F, 0.7854F);
		rightFin2.setTextureOffset(4, 1).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);
	}



	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		body.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		   float f = 1.0F;
		      if (!entityIn.isInWater()) {
		         f = 1.5F;
		      }

		      this.tailfin.rotateAngleY = -f * 0.45F * MathHelper.sin(0.6F * ageInTicks);
		
	}
}