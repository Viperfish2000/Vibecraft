package com.viperfish2000.vscomod.client.models;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.model.ModelRenderer.ModelBox;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * ModelPlayer - Either Mojang or a mod author
 * Created using Tabula 7.0.1
 */
@OnlyIn(Dist.CLIENT)
public class FlowerCrownModel extends BipedModel<LivingEntity> {
	private final ModelRenderer Head;
	private final ModelRenderer bone;
	private final ModelRenderer bone6;
	private final ModelRenderer bone7;
	private final ModelRenderer bone2;
	private final ModelRenderer bone3;
	private final ModelRenderer bone4;
	private final ModelRenderer bone5;
	private final ModelRenderer bone8;
	private final ModelRenderer bone9;

	public FlowerCrownModel(float modelSize, float yOffsetIn, int textureWidthIn, int textureHeightIn) {
		super(modelSize, yOffsetIn, textureWidthIn, textureHeightIn);
		textureWidth = 32;
		textureHeight = 32;

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 0.0F, 0.0F);
		

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, -8.0F, 0.0F);
		Head.addChild(bone);
		bone.setTextureOffset(0, 19).addBox(-5.0F, -2.0F, -3.0F, 0.0F, 3.0F, 6.0F, 0.0F, false);

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(0.0F, -8.0F, 0.0F);
		Head.addChild(bone6);
		setRotationAngle(bone6, 0.0F, -0.7854F, 0.0F);
		bone6.setTextureOffset(0, 19).addBox(-5.0F, -2.0F, -3.0F, 0.0F, 3.0F, 6.0F, 0.0F, false);

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(0.0F, -8.0F, 0.0F);
		Head.addChild(bone7);
		setRotationAngle(bone7, 0.0F, -1.5708F, 0.0F);
		bone7.setTextureOffset(0, 19).addBox(-5.0F, -2.0F, -3.0F, 0.0F, 3.0F, 6.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, -8.0F, 0.0F);
		Head.addChild(bone2);
		setRotationAngle(bone2, 0.0F, -1.5708F, 0.0F);
		bone2.setTextureOffset(0, 19).addBox(-5.0F, -2.0F, -3.0F, 0.0F, 3.0F, 6.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(0.0F, -8.0F, 0.0F);
		Head.addChild(bone3);
		setRotationAngle(bone3, 0.0F, -2.3562F, 0.0F);
		bone3.setTextureOffset(0, 19).addBox(-5.0F, -2.0F, -3.0F, 0.0F, 3.0F, 6.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(0.0F, -8.0F, 0.0F);
		Head.addChild(bone4);
		setRotationAngle(bone4, 0.0F, 3.1416F, 0.0F);
		bone4.setTextureOffset(0, 19).addBox(-5.0F, -2.0F, -3.0F, 0.0F, 3.0F, 6.0F, 0.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(0.0F, -8.0F, 0.0F);
		Head.addChild(bone5);
		setRotationAngle(bone5, 0.0F, 2.3562F, 0.0F);
		bone5.setTextureOffset(0, 19).addBox(-5.0F, -2.0F, -3.0F, 0.0F, 3.0F, 6.0F, 0.0F, false);

		bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(0.0F, -8.0F, 0.0F);
		Head.addChild(bone8);
		setRotationAngle(bone8, 0.0F, 1.5708F, 0.0F);
		bone8.setTextureOffset(0, 19).addBox(-5.0F, -2.0F, -3.0F, 0.0F, 3.0F, 6.0F, 0.0F, false);

		bone9 = new ModelRenderer(this);
		bone9.setRotationPoint(0.0F, -8.0F, 0.0F);
		Head.addChild(bone9);
		setRotationAngle(bone9, 0.0F, 0.7854F, 0.0F);
		bone9.setTextureOffset(0, 19).addBox(-5.0F, -2.0F, -3.0F, 0.0F, 3.0F, 6.0F, 0.0F, false);
		this.bipedHead.addChild(Head);
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
