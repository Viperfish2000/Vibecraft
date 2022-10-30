package com.viperfish2000.vscomod.client.models;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.viperfish2000.vscomod.entity.BisonEntity;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


public class BisonModel<T extends BisonEntity> extends EntityModel<T> {
	private final ModelRenderer bone;
	private final ModelRenderer bone11;
	private final ModelRenderer bone2;
	private final ModelRenderer bone3;
	private final ModelRenderer bone10;
	private final ModelRenderer bone12;
	private final ModelRenderer bone4;
	private final ModelRenderer bone5;
	private final ModelRenderer bone6;
	private final ModelRenderer bone7;
	private final ModelRenderer bone8;
	private final ModelRenderer bone9;
	private final ModelRenderer bb_main;
	private final ModelRenderer bone13;

	public BisonModel() {
		textureWidth = 512;
		textureHeight = 512;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, -25.0F, 57.0F);
		bone.setTextureOffset(102, 115).addBox(-15.0F, 1.0F, -3.0F, 30.0F, 11.0F, 52.0F, 0.0F, false);

		bone11 = new ModelRenderer(this);
		bone11.setRotationPoint(0.0F, 12.0F, 49.0F);
		bone.addChild(bone11);
		bone11.setTextureOffset(214, 111).addBox(-11.0F, -11.0F, -0.0986F, 22.0F, 11.0F, 24.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone2.setTextureOffset(0, 93).addBox(-23.0F, -65.0F, -28.0F, 46.0F, 43.0F, 31.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(0.0F, -40.0F, -32.0F);
		bone2.addChild(bone3);
		bone3.setTextureOffset(0, 167).addBox(-15.0F, -14.0F, -22.0F, 30.0F, 29.0F, 26.0F, 0.0F, false);
		bone3.setTextureOffset(138, 0).addBox(-18.0F, -17.0F, -25.0F, 36.0F, 18.0F, 31.0F, 0.0F, false);
		bone3.setTextureOffset(0, 0).addBox(-7.0F, 3.0F, -26.0F, 13.0F, 5.0F, 9.0F, 0.0F, false);

		bone10 = new ModelRenderer(this);
		bone10.setRotationPoint(17.0F, 24.0F, -18.0F);
		bone3.addChild(bone10);
		setRotationAngle(bone10, 0.1745F, 0.0F, 0.0873F);
		bone10.setTextureOffset(0, 16).addBox(-3.3119F, -50.2803F, 7.5735F, 4.0F, 20.0F, 4.0F, 0.0F, false);

		bone12 = new ModelRenderer(this);
		bone12.setRotationPoint(-17.0F, 24.0F, -18.0F);
		bone3.addChild(bone12);
		setRotationAngle(bone12, 0.1745F, 0.0F, -0.0873F);
		bone12.setTextureOffset(0, 16).addBox(-0.6881F, -50.2803F, 7.5735F, 4.0F, 20.0F, 4.0F, 0.0F, true);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(-19.0F, -12.0F, -5.0F);
		bone4.setTextureOffset(192, 49).addBox(-10.0F, -8.0F, -9.0F, 18.0F, 44.0F, 18.0F, 0.0F, true);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(-19.0F, -12.0F, 21.0F);
		bone5.setTextureOffset(192, 49).addBox(-10.0F, -8.0F, -9.0F, 18.0F, 44.0F, 18.0F, 0.0F, true);

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(-19.0F, -12.0F, 44.0F);
		bone6.setTextureOffset(192, 49).addBox(-10.0F, -8.0F, -8.0F, 18.0F, 44.0F, 18.0F, 0.0F, true);

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(19.0F, -12.0F, 44.0F);
		bone7.setTextureOffset(192, 49).addBox(-8.0F, -8.0F, -8.0F, 18.0F, 44.0F, 18.0F, 0.0F, false);

		bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(19.0F, -12.0F, 19.0F);
		bone8.setTextureOffset(192, 49).addBox(-8.0F, -8.0F, -7.0F, 18.0F, 44.0F, 18.0F, 0.0F, false);

		bone9 = new ModelRenderer(this);
		bone9.setRotationPoint(19.0F, -12.0F, -6.0F);
		bone9.setTextureOffset(192, 49).addBox(-7.0F, -8.0F, -8.0F, 18.0F, 44.0F, 18.0F, 0.0F, false);

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		bone13 = new ModelRenderer(this);
		bone13.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone13.setTextureOffset(0, 0).addBox(-21.0F, -61.0F, 3.0F, 42.0F, 39.0F, 54.0F, 0.0F, false);
	}



	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		bone.render(matrixStack, buffer, packedLight, packedOverlay);
		bone2.render(matrixStack, buffer, packedLight, packedOverlay);
		bone4.render(matrixStack, buffer, packedLight, packedOverlay);
		bone5.render(matrixStack, buffer, packedLight, packedOverlay);
		bone6.render(matrixStack, buffer, packedLight, packedOverlay);
		bone7.render(matrixStack, buffer, packedLight, packedOverlay);
		bone8.render(matrixStack, buffer, packedLight, packedOverlay);
		bone9.render(matrixStack, buffer, packedLight, packedOverlay);
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
		bone13.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	private void setRotationAngles(BisonModel.State p_217162_1_, float ticksExisted, float limbSwing,
			float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		switch (p_217162_1_) {

		case STANDING:
			this.bone3.rotateAngleX = headPitch * ((float) Math.PI / 180F);
			this.bone3.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
			// this.body.rotateAngleX = ((float) Math.PI / 2F);
			this.bone6.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.bone7.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
			this.bone4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
			this.bone9.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.bone5.rotateAngleX = -MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
			this.bone8.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			setRotationAngle(bone, -0.7854F, 0.0F, 0.0F);
			setRotationAngle(bone11, 0.5236F, 0.0F, 0.0F);

		case FLYING:
			this.bone3.rotateAngleX = headPitch * ((float) Math.PI / 180F);
			this.bone3.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
			// this.body.rotateAngleX = ((float) Math.PI / 2F);
			this.bone4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F * 0.6662F + (float) Math.PI) * 0.4F
					* limbSwingAmount;
			this.bone5.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F * 0.6662F + (float) Math.PI) * 0.4F
					* limbSwingAmount;
			this.bone6.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F * 0.6662F + (float) Math.PI) * 0.4F
					* limbSwingAmount;
			this.bone7.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F * 0.6662F + (float) Math.PI) * 0.4F
					* limbSwingAmount;
			this.bone8.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F * 0.6662F + (float) Math.PI) * 0.4F
					* limbSwingAmount;
			this.bone9.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F * 0.6662F + (float) Math.PI) * 0.4F
					* limbSwingAmount;
			this.bone11.rotateAngleX = -0.2F * MathHelper.cos(ageInTicks * 0.6662F * 0.1662F);
			this.bone.rotateAngleX = -0.2F * MathHelper.cos(ageInTicks * 0.6662F * 0.1662F);
	
		}

	}

	private static BisonModel.State getBisonState(BisonEntity p_217158_0_) {
		if (p_217158_0_.isFlying()) {
			return BisonModel.State.FLYING;
		} else {
			return BisonModel.State.STANDING;
		}
	}

	@OnlyIn(Dist.CLIENT)
		   public static enum State {
		      FLYING,
		      STANDING,
		
}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		this.setRotationAngles(getBisonState(entityIn), entityIn.ticksExisted, limbSwing, limbSwingAmount, ageInTicks,
				netHeadYaw, headPitch);
	}
}