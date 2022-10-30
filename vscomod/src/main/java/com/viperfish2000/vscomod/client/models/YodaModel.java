package com.viperfish2000.vscomod.client.models;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.viperfish2000.vscomod.entity.YodaEntity;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


public class YodaModel  <T extends YodaEntity> extends EntityModel<T> {
	private final ModelRenderer yoda;
	private final ModelRenderer head;
	private final ModelRenderer left_ear;
	private final ModelRenderer right_ear;
	private final ModelRenderer body;
	private final ModelRenderer right_arm;
	private final ModelRenderer left_arm;
	private final ModelRenderer right_leg;
	private final ModelRenderer left_leg;

	public YodaModel() {
		textureWidth = 64;
		textureHeight = 64;

		yoda = new ModelRenderer(this);
		yoda.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -16.0F, 0.0F);
		yoda.addChild(head);
		head.setTextureOffset(0, 0).addBox(-4.0F, -5.0F, -3.5F, 8.0F, 5.0F, 7.0F, 0.0F, false);
		head.setTextureOffset(14, 19).addBox(-3.0F, -5.75F, -3.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);

		left_ear = new ModelRenderer(this);
		left_ear.setRotationPoint(0.0F, 16.5F, 0.0F);
		head.addChild(left_ear);
		setRotationAngle(left_ear, 0.0F, 0.0F, -0.0873F);
		left_ear.setTextureOffset(16, 12).addBox(5.0142F, -20.3247F, -1.75F, 7.0F, 4.0F, 0.0F, 0.0F, false);
		left_ear.setTextureOffset(20, 16).addBox(4.9488F, -20.5776F, -2.5F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		left_ear.setTextureOffset(0, 0).addBox(4.8617F, -19.5814F, -2.25F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		right_ear = new ModelRenderer(this);
		right_ear.setRotationPoint(-19.0F, 15.0F, 0.0F);
		head.addChild(right_ear);
		setRotationAngle(right_ear, 0.0F, 0.0F, 0.0873F);
		right_ear.setTextureOffset(16, 12).addBox(6.9706F, -20.3247F, -1.75F, 7.0F, 4.0F, 0.0F, 0.0F, true);
		right_ear.setTextureOffset(20, 16).addBox(5.9488F, -20.5776F, -2.5F, 8.0F, 1.0F, 1.0F, 0.0F, true);
		right_ear.setTextureOffset(0, 0).addBox(11.8786F, -19.6934F, -2.25F, 2.0F, 1.0F, 1.0F, 0.0F, true);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, -0.5F, 0.0F);
		yoda.addChild(body);
		body.setTextureOffset(0, 41).addBox(-3.5F, -15.5F, -2.5F, 7.0F, 12.0F, 5.0F, 0.0F, false);

		right_arm = new ModelRenderer(this);
		right_arm.setRotationPoint(-4.5F, -12.0F, -0.5F);
		yoda.addChild(right_arm);
		setRotationAngle(right_arm, -0.6981F, 0.0F, 0.0F);
		right_arm.setTextureOffset(40, 39).addBox(-1.5F, -2.7144F, -3.0321F, 3.0F, 6.0F, 3.0F, 0.0F, true);
		right_arm.setTextureOffset(28, 51).addBox(1.5F, 0.2856F, -3.0321F, 6.0F, 3.0F, 3.0F, 0.0F, false);

		left_arm = new ModelRenderer(this);
		left_arm.setRotationPoint(9.5F, -12.0F, -0.5F);
		yoda.addChild(left_arm);
		setRotationAngle(left_arm, -0.6981F, 0.0F, 0.0F);
		left_arm.setTextureOffset(40, 39).addBox(-6.5F, -2.7144F, -3.0321F, 3.0F, 6.0F, 3.0F, 0.0F, false);

		right_leg = new ModelRenderer(this);
		right_leg.setRotationPoint(0.0F, -4.5F, 0.0F);
		yoda.addChild(right_leg);
		right_leg.setTextureOffset(24, 26).addBox(-3.0F, -3.5F, -1.5F, 3.0F, 8.0F, 3.0F, 0.0F, false);

		left_leg = new ModelRenderer(this);
		left_leg.setRotationPoint(0.0F, -0.5F, 0.0F);
		yoda.addChild(left_leg);
		left_leg.setTextureOffset(24, 26).addBox(0.0F, -7.5F, -1.5F, 3.0F, 8.0F, 3.0F, 0.0F, true);
	}


	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		yoda.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		   this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
		      this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
		   
		         this.head.rotateAngleZ = 0.0F;
		      

		   //   this.bipedLeftArm.rotationPointY = 3.0F;
		  //    this.bipedLeftArm.rotationPointZ = -1.0F;
		      this.left_arm.rotateAngleX = -0.75F;
		    //  this.bipedRightArm.rotationPointY = 3.0F;
		  //   this.bipedRightArm.rotationPointZ = -1.0F;
		      this.right_arm.rotateAngleX = -0.75F;
		      this.right_leg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
		      this.left_leg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount * 0.5F;
		      this.right_leg.rotateAngleY = 0.0F;
		      this.left_leg.rotateAngleY = 0.0F;
		
	}
}