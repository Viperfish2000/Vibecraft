package com.viperfish2000.vscomod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BreakableBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class TrampolineBlock extends BreakableBlock {
   public TrampolineBlock(Block.Properties properties) {
      super(properties);
   }

   /**
    * Gets the render layer this block will render on. SOLID for solid blocks, CUTOUT or CUTOUT_MIPPED for on-off
    * transparency (glass, reeds), TRANSLUCENT for fully blended transparency (stained glass)
    */


   /**
    * Block's chance to react to a living entity falling on it.
    */
   public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance) {
	      if (entityIn.isSuppressingBounce()) {
	         super.onFallenUpon(worldIn, pos, entityIn, fallDistance);
	      } else {
	         entityIn.onLivingFall(fallDistance, 0.0F);
	      }

	   }

   public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
	      if (!worldIn.isRemote) {
	         if (entityIn instanceof LivingEntity) {
	            LivingEntity livingentity = (LivingEntity)entityIn;
	         
	               livingentity.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 1, 1, false, false));
	            
	         }

	      }
	   }
   /**
    * Called when an Entity lands on this Block. This method *must* update motionY because the entity will not do that
    * on its own
    */
   public void onLanded(IBlockReader worldIn, Entity entityIn) {
      if (entityIn.isSneaking()) {
         super.onLanded(worldIn, entityIn);
      } else {
         Vec3d vec3d = entityIn.getMotion();
         if (vec3d.y < 0.0D) {
            double d0 = entityIn instanceof LivingEntity ? 1.0D : 0.95D;
            double i=1.214;
            double verticle = -vec3d.y*d0*i;
            double verticleb = -vec3d.y*d0;
            if (verticle <= 1.2) {
            	entityIn.setMotion(vec3d.x, verticle, vec3d.z); 
            	 System.out.println("i = " + i);
            	 System.out.println("verticle = " +verticle); 
            }
            else {
            	entityIn.setMotion(vec3d.x, verticleb, vec3d.z); 
            	
            	System.out.println("i = " + i);
            	 System.out.println("verticleb = " +verticleb); 
            }
            	  
            	
        
            
           
         }
      }

   }

   /**
    * Called when the given entity walks on this Block
    */
   public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
      double d0 = Math.abs(entityIn.getMotion().y);
      if (d0 < 0.1D && !entityIn.isSneaking()) {
         double d1 = 0.4D + d0 * 0.3D;
         entityIn.setMotion(entityIn.getMotion().mul(d1, 1.0D, d1));
      }

      super.onEntityWalk(worldIn, pos, entityIn);
   }
}