package com.viperfish2000.vscomod.client.models;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.viperfish2000.vscomod.entity.ButterflyEntity;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


public class ButterflyModel  <T extends ButterflyEntity> extends EntityModel<T>{
	private final ModelRenderer body;
	private final ModelRenderer bone2;
	private final ModelRenderer bone;
	private final ModelRenderer mouth;
	private final ModelRenderer rightwing_bone;
	private final ModelRenderer leftwing_bone;
	private final ModelRenderer leg_front;
	private final ModelRenderer leg_mid;
	private final ModelRenderer leg_back;

	public ButterflyModel() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(-0.5F, 20.5F, 0.0F);
		body.setTextureOffset(9, 33).addBox(-1.5F, -1.0F, -4.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);
		body.setTextureOffset(23, 44).addBox(-1.0F, -0.5F, -2.0F, 2.0F, 2.0F, 7.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(1.5F, -1.0F, -4.0F);
		body.addChild(bone2);
		setRotationAngle(bone2, 0.0F, 0.0F, 0.7854F);
		bone2.setTextureOffset(0, 5).addBox(0.0F, -2.0F, -3.0F, 1.0F, 2.0F, 3.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(-1.5F, -1.0F, -4.0F);
		body.addChild(bone);
		setRotationAngle(bone, 0.0F, 0.0F, -0.7854F);
		bone.setTextureOffset(0, 0).addBox(-1.0F, -2.0F, -3.0F, 1.0F, 2.0F, 3.0F, 0.0F, false);

		mouth = new ModelRenderer(this);
		mouth.setRotationPoint(-0.5F, -3.0F, -3.25F);
		body.addChild(mouth);
		setRotationAngle(mouth, 1.2217F, 0.0F, 0.0F);
		mouth.setTextureOffset(0, 5).addBox(0.5F, -0.4284F, -6.1346F, 1.0F, 2.0F, 3.0F, 0.0F, false);

		rightwing_bone = new ModelRenderer(this);
		rightwing_bone.setRotationPoint(-0.5F, -0.5F, -1.0F);
		body.addChild(rightwing_bone);
		rightwing_bone.setTextureOffset(0, 0).addBox(-14.0F, 0.0F, -8.2562F, 14.0F, 0.0F, 20.0F, 0.0F, false);
		rightwing_bone.setTextureOffset(0, 20).addBox(-14.0F, 0.05F, -8.2562F, 14.0F, 0.0F, 20.0F, 0.0F, false);

		leftwing_bone = new ModelRenderer(this);
		leftwing_bone.setRotationPoint(0.5F, -0.5F, -1.0F);
		body.addChild(leftwing_bone);
		leftwing_bone.setTextureOffset(0, 0).addBox(0.0F, 0.0F, -8.2562F, 14.0F, 0.0F, 20.0F, 0.0F, true);
		leftwing_bone.setTextureOffset(0, 20).addBox(0.0F, 0.05F, -8.2562F, 14.0F, 0.0F, 20.0F, 0.0F, true);

		leg_front = new ModelRenderer(this);
		leg_front.setRotationPoint(1.5F, 3.0F, -2.0F);
		body.addChild(leg_front);
		leg_front.setTextureOffset(0, 14).addBox(-4.0F, -1.5F, 0.25F, 5.0F, 2.0F, 0.0F, 0.0F, false);

		leg_mid = new ModelRenderer(this);
		leg_mid.setRotationPoint(1.5F, 3.0F, 0.0F);
		body.addChild(leg_mid);
		leg_mid.setTextureOffset(0, 12).addBox(-4.0F, -1.5F, -0.5F, 5.0F, 2.0F, 0.0F, 0.0F, false);

		leg_back = new ModelRenderer(this);
		leg_back.setRotationPoint(1.5F, 3.0F, 2.0F);
		body.addChild(leg_back);
		leg_back.setTextureOffset(0, 10).addBox(-4.0F, -1.5F, -1.25F, 5.0F, 2.0F, 0.0F, 0.0F, false);
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
		 this.rightwing_bone.rotateAngleZ= 1.1F*MathHelper.cos(ageInTicks * 0.7F) * (float)Math.PI * 0.25F;
         this.leftwing_bone.rotateAngleZ = -this.rightwing_bone.rotateAngleZ;
		
	}
}