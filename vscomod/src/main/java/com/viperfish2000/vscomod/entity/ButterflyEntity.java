package com.viperfish2000.vscomod.entity;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.Random;

import javax.annotation.Nullable;

import com.viperfish2000.vscomod.world.BiomeMod;

import net.minecraft.block.BlockState;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;

public class ButterflyEntity extends CreatureEntity {
	   private BlockPos spawnPosition;
	   private static final DataParameter<Integer> BUTTERFLY_TYPE = EntityDataManager.createKey(ButterflyEntity.class, DataSerializers.VARINT);
	private static final Random rand = new Random();
	   public ButterflyEntity(EntityType<? extends ButterflyEntity> p_i50290_1_, World p_i50290_2_) {
	      super(p_i50290_1_, p_i50290_2_);
	     
	   }

	   protected void registerData() {
	      super.registerData();
	     this.dataManager.register(BUTTERFLY_TYPE, 0);
	       
	   }
	   public boolean canDespawn(double distanceToClosestPlayer) {
		      return false;
		   }
	   protected float getSoundVolume() {
	      return 0.1F;
	   }

	   protected float getSoundPitch() {
	      return super.getSoundPitch() * 0.95F;
	   }

	   @Nullable
	   public SoundEvent getAmbientSound() {
	      return null;
	   }

	   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
	      return null;
	   }

	   protected SoundEvent getDeathSound() {
	      return null;
	   }

	   public boolean canBePushed() {
	      return false;
	   }

	   protected void collideWithEntity(Entity entityIn) {
	   }

	   protected void collideWithNearbyEntities() {
	   }

	   protected void registerAttributes() {
	      super.registerAttributes();
	      this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(6.0D);
	   }
	   public int getButterflyType() {
		      return this.dataManager.get(BUTTERFLY_TYPE);
		   }
	   public int getVariant() {
		      return MathHelper.clamp(this.dataManager.get(BUTTERFLY_TYPE), 0, 3);
		   }
		   public void setButterflyType(int butterflyTypeId) {

		      this.dataManager.set(BUTTERFLY_TYPE, butterflyTypeId);
		   }

	   

	   private int getRandomButterflyType(IWorld p_213610_1_) {
	      Biome biome = p_213610_1_.getBiome(new BlockPos(this));
	      int i = this.rand.nextInt(99);
	      
	      if (biome.getCategory() == Biome.Category.JUNGLE) {
	    	  	return 0;
	      } else if (biome.getCategory() == Biome.Category.PLAINS) {
	    	  	return 2;
	      } else if (biome.getCategory() == Biome.Category.EXTREME_HILLS) {
		        return 1;
	      } else if (biome.getCategory() == Biome.Category.FOREST) {
		        return 3;	
	      } else if (biome == BiomeMod.poppy_fields) {
			  if (rand.nextInt()<2) {
				  return 1;
			  }
			  else {
	    	  return 2;
			  }
	      } else {
	         return rand.nextInt(4)+1;
	      } 
	   }
	 
	   @Nullable
	   public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
		   if (dataTag != null && dataTag.contains("BucketVariantTag", 3)) {
		         this.setButterflyType(dataTag.getInt("BucketVariantTag"));
		         return spawnDataIn;
		      } else {
		   spawnDataIn = super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	      int i = this.getRandomButterflyType(worldIn);
	     this.setButterflyType(i);

	      return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	   }}
	   /**
	   public static boolean func_223321_c(EntityType<ButterflyEntity> p_223321_0_, IWorld p_223321_1_, SpawnReason reason, BlockPos p_223321_3_, Random p_223321_4_) {
	      Block block = p_223321_1_.getBlockState(p_223321_3_.down()).getBlock();
	      return (block == Blocks.GRASS_BLOCK || block == Blocks.OAK_LEAVES || block == Blocks.BIRCH_LEAVES|| block == Blocks.JUNGLE_LEAVES) && p_223321_1_.getLightSubtracted(p_223321_3_, 0) > 8;
	   }
	   **/

	   public void tick() {
		      super.tick();
		     
		         this.setMotion(this.getMotion().mul(1.0D, 0.6D, 1.0D));
		      

		   }

		   protected void updateAITasks() {
		      super.updateAITasks();
		      BlockPos blockpos = new BlockPos(this);
		      BlockPos blockpos1 = blockpos.up();
		  
		         if (this.spawnPosition != null && (!this.world.isAirBlock(this.spawnPosition) || this.spawnPosition.getY() < 1)) {
		            this.spawnPosition = null;
		         }

		         if (this.spawnPosition == null || this.rand.nextInt(30) == 0 || this.spawnPosition.withinDistance(this.getPositionVec(), 2.0D)) {
		            this.spawnPosition = new BlockPos(this.getPosX() + (double)this.rand.nextInt(7) - (double)this.rand.nextInt(7), this.getPosY() + (double)this.rand.nextInt(6) - 2.0D, this.getPosZ() + (double)this.rand.nextInt(7) - (double)this.rand.nextInt(7));
		         }

		         double d0 = (double)this.spawnPosition.getX() + 0.5D - this.getPosX();
		         double d1 = (double)this.spawnPosition.getY() + 0.1D - this.getPosY();
		         double d2 = (double)this.spawnPosition.getZ() + 0.5D - this.getPosZ();
		         Vec3d vec3d = this.getMotion();
		         Vec3d vec3d1 = vec3d.add((Math.signum(d0) * 0.5D - vec3d.x) * (double)0.1F, (Math.signum(d1) * (double)0.7F - vec3d.y) * (double)0.1F, (Math.signum(d2) * 0.5D - vec3d.z) * (double)0.1F);
		         this.setMotion(vec3d1);
		         float f = (float)(MathHelper.atan2(vec3d1.z, vec3d1.x) * (double)(180F / (float)Math.PI)) - 90.0F;
		         float f1 = MathHelper.wrapDegrees(f - this.rotationYaw);
		         this.moveForward = 0.5F;
		         this.rotationYaw += f1;
		        
		         
		      }

		   

	   

	   public void writeAdditional(CompoundNBT compound) {
		      super.writeAdditional(compound);
		      compound.putInt("ButterflyType", this.getButterflyType());
		   }

		   public void readAdditional(CompoundNBT compound) {
		      super.readAdditional(compound);
		      this.setButterflyType(compound.getInt("ButterflyType"));
		   }
	   protected boolean canTriggerWalking() {
	      return false;
	   }

	   public void fall(float distance, float damageMultiplier) {
	   }

	   protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
	   }

	   public boolean doesEntityNotTriggerPressurePlate() {
	      return true;
	   }

	  
	   public static class ButterflyData implements ILivingEntityData {
		      public final int typeData;

		      public ButterflyData(int type) {
		         this.typeData = type;
		      }
		   }


	   public static boolean func_223369_b(EntityType<ButterflyEntity> p_223369_0_, IWorld p_223369_1_, SpawnReason reason, BlockPos p_223369_3_, Random p_223369_4_) {
	      if (p_223369_3_.getY() >= p_223369_1_.getSeaLevel()) {
	         return false;
	      } else {
	         int i = p_223369_1_.getLight(p_223369_3_);
	         int j = 4;
	         if (isNearHalloween()) {
	            j = 7;
	         } else if (p_223369_4_.nextBoolean()) {
	            return false;
	         }

	         return i > p_223369_4_.nextInt(j) ? false : canSpawnOn(p_223369_0_, p_223369_1_, reason, p_223369_3_, p_223369_4_);
	      }
	   }

	   private static boolean isNearHalloween() {
	      LocalDate localdate = LocalDate.now();
	      int i = localdate.get(ChronoField.DAY_OF_MONTH);
	      int j = localdate.get(ChronoField.MONTH_OF_YEAR);
	      return j == 10 && i >= 20 || j == 11 && i <= 3;
	   }

	   protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
	      return sizeIn.height / 2.0F;
	   }
	}