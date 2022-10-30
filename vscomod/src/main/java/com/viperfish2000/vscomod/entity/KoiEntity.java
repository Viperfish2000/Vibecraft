package com.viperfish2000.vscomod.entity;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import javax.annotation.Nullable;

import com.viperfish2000.vscomod.item.ItemList;

import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.FollowSchoolLeaderGoal;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.passive.fish.AbstractGroupFishEntity;
import net.minecraft.entity.passive.fish.TropicalFishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;


	public class KoiEntity extends AbstractFishEntity {
		   private static final DataParameter<Integer> KOI_TYPE = EntityDataManager.createKey(KoiEntity.class, DataSerializers.VARINT);
			private static final Random rand = new Random();

		   public KoiEntity(EntityType<? extends KoiEntity> p_i50279_1_, World p_i50279_2_) {
		      super(p_i50279_1_, p_i50279_2_);
		   }


		   protected ItemStack getFishBucket() {
			      return new ItemStack(ItemList.koi_bucket);
			   }

	   protected SoundEvent getAmbientSound() {
	      return SoundEvents.ENTITY_COD_AMBIENT;
	   }

	   protected SoundEvent getDeathSound() {
	      return SoundEvents.ENTITY_COD_DEATH;
	   }
	
	   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
	      return SoundEvents.ENTITY_COD_HURT;
	   }

	   protected SoundEvent getFlopSound() {
	      return SoundEvents.ENTITY_COD_FLOP;
	   }
	   
	   protected void registerData() {
		      super.registerData();
		      this.dataManager.register(KOI_TYPE, 0);
		   }

	   public void writeAdditional(CompoundNBT compound) {
		      super.writeAdditional(compound);
		      compound.putInt("KoiType", this.getVariant());
		   }

		   public void readAdditional(CompoundNBT compound) {
		      super.readAdditional(compound);
		      this.setKoiType(compound.getInt("KoiType"));
		   }
		   public void setVariant(int p_204215_1_) {
		      this.dataManager.set(KOI_TYPE, p_204215_1_);
		   }

		  

		   public int getVariant() {
		      return this.dataManager.get(KOI_TYPE);
		   }

		   protected void setBucketData(ItemStack bucket) {
		      super.setBucketData(bucket);
		      CompoundNBT compoundnbt = bucket.getOrCreateTag();
		      compoundnbt.putInt("BucketVariantTag", this.getVariant());
		   }

	
	   public void setKoiType(int koiTypeId) {
		      this.dataManager.set(KOI_TYPE, koiTypeId);
	   }
	   private int getRandomKoiType(IWorld p_213610_1_) {
	         return rand.nextInt(8)+1;
	   }
/**	
	   @Nullable
	   public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
		   if (dataTag != null && dataTag.contains("BucketVariantTag", 3)) {
		         this.setKoiType(dataTag.getInt("BucketVariantTag"));
		         return spawnDataIn;
		      } else {
		   spawnDataIn = super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	      int i = this.getRandomKoiType(worldIn);
	     this.setKoiType(i);
		return spawnDataIn;
		      }
	   }
**/
	   @Nullable
	   public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
		   spawnDataIn = super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
		      if (dataTag != null && dataTag.contains("BucketVariantTag", 3)) {
		         this.setVariant(dataTag.getInt("BucketVariantTag"));
		         return spawnDataIn;
		      } else {
		         int i = getRandomKoiType(worldIn);
		         this.setVariant(i);
		         return spawnDataIn;
		      }
	   }
	   public static class KoiData implements ILivingEntityData {
		      public final int typeData;

		      public KoiData(int type) {
		         this.typeData = type;
		      }
		   }


	
	 

	}