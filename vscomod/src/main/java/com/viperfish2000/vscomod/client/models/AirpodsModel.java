package com.viperfish2000.vscomod.client.models;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * ModelPlayer - Either Mojang or a mod author
 * Created using Tabula 7.0.1
 */
@OnlyIn(Dist.CLIENT)
public class AirpodsModel extends BipedModel<LivingEntity> {
	public final ModelRenderer bone;
	public final ModelRenderer bone2;

	public AirpodsModel(float modelSize, float yOffsetIn, int textureWidthIn, int textureHeightIn) {
		super(modelSize, yOffsetIn, textureWidthIn, textureHeightIn);
		textureWidth = 16;
		textureHeight = 16;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(-4.0F, -4.0F, -0.5F);
		setRotationAngle(bone, -0.4363F, -0.5236F, -0.0524F);
		bone.setTextureOffset(0, 14).addBox(-0.356F, -0.355F, 0.5723F, 1.0F, 1.0F, 1.0F, -0.15F, false);
		bone.setTextureOffset(0, 11).addBox(-0.606F, -0.105F, 0.6723F, 1.0F, 2.0F, 1.0F, -0.37F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(4.0F, -4.0F, -0.5F);
		setRotationAngle(bone2, -0.4363F, 0.3491F, 0.0349F);
		bone2.setTextureOffset(0, 14).addBox(-0.4487F, -0.4421F, 0.2583F, 1.0F, 1.0F, 1.0F, -0.15F, true);
		bone2.setTextureOffset(0, 11).addBox(-0.1987F, -0.1921F, 0.3649F, 1.0F, 2.0F, 1.0F, -0.37F, true);
		bipedHead.addChild(bone);
		bipedHead.addChild(bone2);
	}


	@Override
	public void setRotationAngles(LivingEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		super.setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		
		
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		super.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		this.bipedHead.showModel = false;
		this.bipedHeadwear.showModel = false;
	}
    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
 

}//Made with Blockbench
