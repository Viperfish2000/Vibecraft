package com.viperfish2000.vscomod.client.models;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.viperfish2000.vscomod.entity.HedgehogEntity;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


public class HedgehogModel <T extends HedgehogEntity> extends EntityModel<T>  {
	private final ModelRenderer body;
	private final ModelRenderer leg1;
	private final ModelRenderer leg2;
	private final ModelRenderer leg3;
	private final ModelRenderer leg4;
	private final ModelRenderer head;

	public HedgehogModel() {
		textureWidth = 32;
		textureHeight = 32;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 21.5F, -0.75F);
		body.setTextureOffset(0, 0).addBox(-3.0F, -3.0F, -2.5F, 6.0F, 4.0F, 6.0F, 0.0F, false);
		body.setTextureOffset(13, 13).addBox(-2.0F, 0.75F, -2.0F, 4.0F, 1.0F, 5.0F, 0.0F, false);
		body.setTextureOffset(0, 10).addBox(-2.0F, -3.5F, -2.0F, 4.0F, 1.0F, 5.0F, 0.0F, false);
		body.setTextureOffset(14, 19).addBox(-2.5F, -2.5F, 3.0F, 5.0F, 3.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(18, 0).addBox(-2.5F, -2.5F, -3.0F, 5.0F, 3.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(7, 19).addBox(2.5F, -2.5F, -2.0F, 1.0F, 3.0F, 5.0F, 0.0F, false);
		body.setTextureOffset(0, 16).addBox(-3.5F, -2.5F, -2.0F, 1.0F, 3.0F, 5.0F, 0.0F, false);

		leg1 = new ModelRenderer(this);
		leg1.setRotationPoint(-1.25F, 1.75F, -1.25F);
		body.addChild(leg1);
		leg1.setTextureOffset(0, 12).addBox(-0.5F, -0.15F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		leg2 = new ModelRenderer(this);
		leg2.setRotationPoint(1.25F, 1.75F, 2.25F);
		body.addChild(leg2);
		leg2.setTextureOffset(0, 10).addBox(-0.5F, -0.15F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		leg3 = new ModelRenderer(this);
		leg3.setRotationPoint(-1.25F, 1.75F, 2.25F);
		body.addChild(leg3);
		leg3.setTextureOffset(13, 13).addBox(-0.5F, -0.15F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		leg4 = new ModelRenderer(this);
		leg4.setRotationPoint(1.25F, 1.75F, -1.25F);
		body.addChild(leg4);
		leg4.setTextureOffset(0, 3).addBox(-0.5F, -0.15F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, -2.0F);
		body.addChild(head);
		setRotationAngle(head, 0.0873F, 0.0F, 0.0F);
		head.setTextureOffset(22, 8).addBox(-1.5F, -1.6338F, -1.5988F, 3.0F, 3.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(13, 10).addBox(-1.0F, -0.0574F, -2.0836F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(-0.5F, 0.1936F, -2.7519F, 1.0F, 1.0F, 2.0F, 0.0F, false);
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
	     
	      if (entityIn.isSitting()) {
	    	 //  this.head.rotateAngleX = - headPitch * ((float)Math.PI / 180F);
	    	  this.head.rotateAngleX = ((float)Math.PI/3F);
	      }
	      else {
	    	  
	 
	      this.head.rotateAngleX = 0.5F* headPitch * ((float)Math.PI / 180F);
	      this.head.rotateAngleY = 0.5F* netHeadYaw * ((float)Math.PI / 180F);
	   //   this.tail.rotateAngleX = ageInTicks;
	      }
		
	}
	
	
	 public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {

	      if (entityIn.isSitting()) {
	         //this.mane.setRotationPoint(-1.0F, 16.0F, -3.0F);
	         //this.mane.rotateAngleX = 1.2566371F;
	         //this.mane.rotateAngleY = 0.0F;
	        // this.body.setRotationPoint(0.0F, 18.0F, 0.0F);
	    	  this.head.rotateAngleX = ((float)Math.PI/1.5F);
			     
	    	  this.body.rotateAngleZ = ((float)Math.PI);
	    	  this.body.rotateAngleY = ((float)Math.PI);
	        // this.tail.setRotationPoint(-1.0F, 21.0F, 6.0F);
	       //  this.leg3.setRotationPoint(-2.5F, 22.0F, 2.0F);
	         this.leg3.rotateAngleX = 0.261799F;
	     //    this.leg2.setRotationPoint(0.5F, 22.0F, 2.0F);
	         this.leg2.rotateAngleX = 0.261799F;
	         this.leg1.rotateAngleX = 0.261799F;
	   //      this.leg1.setRotationPoint(-2.49F, 17.0F, -4.0F);
	         this.leg4.rotateAngleX = 0.261799F;
	   //      this.leg4.setRotationPoint(0.51F, 17.0F, -4.0F);
	      } else {
	    	
	    	  this.head.rotateAngleX = 0.0873F;
	    	  this.body.rotateAngleY = 0; 
	    	  this.body.setRotationPoint(0.0F, 21.5F, -0.75F);
	    	  this.body.rotateAngleZ = 0F;
	        // this.mane.setRotationPoint(-1.0F, 14.0F, -3.0F);
	      //   this.mane.rotateAngleX = this.body.rotateAngleX;
	     //    this.tail.setRotationPoint(-1.0F, 12.0F, 8.0F);
	     //    this.leg3.setRotationPoint(-2.5F, 16.0F, 7.0F);
	    //     this.leg2.setRotationPoint(0.5F, 16.0F, 7.0F);
	    //     this.leg1.setRotationPoint(-2.5F, 16.0F, -4.0F);
	   //      this.leg4.setRotationPoint(0.5F, 16.0F, -4.0F);
	         this.leg3.rotateAngleX = MathHelper.cos(limbSwing * 0.96662F) * 6.4F * limbSwingAmount;
	         this.leg2.rotateAngleX = MathHelper.cos(limbSwing * 0.96662F + (float)Math.PI) * 6.4F * limbSwingAmount;
	         this.leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.96662F + (float)Math.PI) * 6.4F * limbSwingAmount;
	         this.leg4.rotateAngleX = MathHelper.cos(limbSwing * 0.96662F) * 6.4F * limbSwingAmount;
	         
	      }

	      this.head.rotateAngleZ = 0.5F*entityIn.getInterestedAngle(partialTick);
	  //    this.mane.rotateAngleZ = entityIn.getShakeAngle(partialTick, -0.08F);
	   //   this.body.rotateAngleZ = entityIn.getShakeAngle(partialTick, -0.16F);
	     // this.tail.rotateAngleZ = entityIn.getShakeAngle(partialTick, -0.2F);
	   }

}