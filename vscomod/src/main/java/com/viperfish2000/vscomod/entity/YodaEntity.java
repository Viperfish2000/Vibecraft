package com.viperfish2000.vscomod.entity;

import java.util.UUID;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import com.viperfish2000.vscomod.item.ItemList;
import com.viperfish2000.vscomod.sounds.SoundMod;

import net.minecraft.block.BlockState;
import net.minecraft.client.audio.Sound;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.SitGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.GhastEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;
import net.minecraft.entity.passive.horse.LlamaEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.DyeColor;
import net.minecraft.item.DyeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class YodaEntity extends AnimalEntity {
	   private static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(ItemList.frog);
	private static final DataParameter<Float> DATA_HEALTH_ID = EntityDataManager.createKey(YodaEntity.class, DataSerializers.FLOAT);
   private static final DataParameter<Boolean> BEGGING = EntityDataManager.createKey(YodaEntity.class, DataSerializers.BOOLEAN);
   private static final DataParameter<Integer> COLLAR_COLOR = EntityDataManager.createKey(YodaEntity.class, DataSerializers.VARINT);
   public static final Predicate<LivingEntity> field_213441_bD = (p_213440_0_) -> {
      EntityType<?> entitytype = p_213440_0_.getType();
      return entitytype == EntityType.SHEEP || entitytype == EntityType.RABBIT || entitytype == EntityType.FOX;
   };
   private float headRotationCourse;
   private float headRotationCourseOld;


   public YodaEntity(EntityType<? extends YodaEntity> type, World worldIn) {
      super(type, worldIn);
      
   }

   protected void registerGoals() {
   
      this.goalSelector.addGoal(1, new SwimGoal(this));
     
   //   this.goalSelector.addGoal(3, new YodaEntity.AvoidEntityGoal(this, LlamaEntity.class, 24.0F, 1.5D, 1.5D));
   //   this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, 0.4F));
    //  this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D, true));
   
      this.goalSelector.addGoal(7, new BreedGoal(this, 1.0D));
      this.goalSelector.addGoal(8, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
 //     this.goalSelector.addGoal(9, new BegGoal(this, 8.0F));
      this.goalSelector.addGoal(10, new LookAtGoal(this, PlayerEntity.class, 8.0F));
      this.goalSelector.addGoal(10, new LookRandomlyGoal(this));
//      this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
//      this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
   //   this.targetSelector.addGoal(3, (new HurtByTargetGoal(this)).setCallsForHelp());
 //     this.targetSelector.addGoal(4, new NonTamedTargetGoal<>(this, AnimalEntity.class, false, field_213441_bD));
 //     this.targetSelector.addGoal(4, new NonTamedTargetGoal<>(this, TurtleEntity.class, false, TurtleEntity.TARGET_DRY_BABY));
  //    this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, AbstractSkeletonEntity.class, false));
   }

   protected void registerAttributes() {
      super.registerAttributes();
      this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double)0.18F);
     
         this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0D);
     

      this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0.0D);
   }

   /**
    * Sets the active target the Task system uses for tracking
    */
 

   protected void updateAITasks() {
      this.dataManager.set(DATA_HEALTH_ID, this.getHealth());
   }

   protected void registerData() {
      super.registerData();
      this.dataManager.register(DATA_HEALTH_ID, this.getHealth());
      this.dataManager.register(BEGGING, false);

   }

   protected void playStepSound(BlockPos pos, BlockState blockIn) {
      this.playSound(SoundEvents.ENTITY_WOLF_STEP, 0.15F, 1.0F);
   }



   /**
    * (abstract) Protected helper method to read subclass entity data from NBT.
    */


   protected SoundEvent getAmbientSound() {
     
	   return SoundMod.ENTITY_YODA_LIVING;
     
      
   }
   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
      return SoundEvents.ENTITY_PLAYER_HURT;
   }

   protected SoundEvent getDeathSound() {
      return SoundEvents.ENTITY_PLAYER_DEATH;
   }

   /**
    * Returns the volume for the sounds this mob makes.
    */
   protected float getSoundVolume() {
      return 0.6F;
   }

   /**
    * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
    * use this to react to sunlight and start to burn.
    */
  

   /**
    * Called to update the entity's position/logic.
    */
   
   public void tick() {
      super.tick();
      if (this.isAlive()) {
         this.headRotationCourseOld = this.headRotationCourse;
         if (this.isBegging()) {
            this.headRotationCourse += (1.0F - this.headRotationCourse) * 0.4F;
         } else {
            this.headRotationCourse += (0.0F - this.headRotationCourse) * 0.4F;
         }
/**
         if (this.isInWaterRainOrBubbleColumn()) {
            this.isWet = true;
            this.isShaking = false;
            this.timeWolfIsShaking = 0.0F;
            this.prevTimeWolfIsShaking = 0.0F;
         } else if ((this.isWet || this.isShaking) && this.isShaking) {
            if (this.timeWolfIsShaking == 0.0F) {
               this.playSound(SoundEvents.ENTITY_WOLF_SHAKE, this.getSoundVolume(), (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
            }

            this.prevTimeWolfIsShaking = this.timeWolfIsShaking;
            this.timeWolfIsShaking += 0.05F;
            if (this.prevTimeWolfIsShaking >= 2.0F) {
               this.isWet = false;
               this.isShaking = false;
               this.prevTimeWolfIsShaking = 0.0F;
               this.timeWolfIsShaking = 0.0F;
            }

            if (this.timeWolfIsShaking > 0.4F) {
               float f = (float)this.getBoundingBox().minY;
               int i = (int)(MathHelper.sin((this.timeWolfIsShaking - 0.4F) * (float)Math.PI) * 7.0F);
               Vec3d vec3d = this.getMotion();

               for(int j = 0; j < i; ++j) {
                  float f1 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.getWidth() * 0.5F;
                  float f2 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.getWidth() * 0.5F;
                  this.world.addParticle(ParticleTypes.SPLASH, this.posX + (double)f1, (double)(f + 0.8F), this.posZ + (double)f2, vec3d.x, vec3d.y, vec3d.z);
               }
            }
         }
  **/
      }
    
   }

   /**
    * Called when the mob's health reaches 0.
    */
   public void onDeath(DamageSource cause) {
     
      super.onDeath(cause);
   }

   /**
    * True if the wolf is wet
    */


   /**
    * Used when calculating the amount of shading to apply while the wolf is wet.
    */
/**
   @OnlyIn(Dist.CLIENT)
   public float getShadingWhileWet(float p_70915_1_) {
     return 0.75F + MathHelper.lerp(p_70915_1_, this.prevTimeWolfIsShaking, this.timeWolfIsShaking) / 2.0F * 0.25F;
   }

   @OnlyIn(Dist.CLIENT)
   public float getShakeAngle(float p_70923_1_, float p_70923_2_) {
      float f = (MathHelper.lerp(p_70923_1_, this.prevTimeWolfIsShaking, this.timeWolfIsShaking) + p_70923_2_) / 1.8F;
      if (f < 0.0F) {
         f = 0.0F;
      } else if (f > 1.0F) {
         f = 1.0F;
      }

      return MathHelper.sin(f * (float)Math.PI) * MathHelper.sin(f * (float)Math.PI * 11.0F) * 0.15F * (float)Math.PI;
   }
**/
   @OnlyIn(Dist.CLIENT)
   public float getInterestedAngle(float p_70917_1_) {
      return 0.5F*MathHelper.lerp(p_70917_1_, this.headRotationCourseOld, this.headRotationCourse) * 0.15F * (float)Math.PI  ;
   }

   protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
      return sizeIn.height * 0.4F;
   }

   /**
    * The speed it takes to move the entityliving's rotationPitch through the faceEntity method. This is only currently
    * use in wolves.
    */
   public int getVerticalFaceSpeed() {
      return super.getVerticalFaceSpeed();
   }

   /**
    * Called when the entity is attacked.
    */

   public boolean attackEntityAsMob(Entity entityIn) {
      boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float)((int)this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue()));
      if (flag) {
         this.applyEnchantments(this, entityIn);
      }

      return flag;
   }

  

 
   /**
    * Handler for {@link World#setEntityState}
    */
   @OnlyIn(Dist.CLIENT)
   public void handleStatusUpdate(byte id) {
      if (id == 8) {
       
      } else {
         super.handleStatusUpdate(id);
      }

   }

 

   /**
    * Checks if the parameter is an item which this animal can be fed to breed it (wheat, carrots or seeds depending on
    * the animal type)
    */
   public boolean isBreedingItem(ItemStack stack) {
	      return TEMPTATION_ITEMS.test(stack);
	   }
   /**
    * Will return how many at most can spawn in a chunk at once.
    */
   public int getMaxSpawnedInChunk() {
      return 8;
   }

   /**
    * Determines whether this wolf is angry or not.
    */

   /**
    * Sets whether this wolf is angry or not.
    */


   public DyeColor getCollarColor() {
      return DyeColor.byId(this.dataManager.get(COLLAR_COLOR));
   }

   public void setCollarColor(DyeColor collarcolor) {
      this.dataManager.set(COLLAR_COLOR, collarcolor.getId());
   }

   public YodaEntity createChild(AgeableEntity ageable) {
      YodaEntity YodaEntity = EntityRegistry.YODA.create(this.world);
     

      return YodaEntity;
   }

   public void setBegging(boolean beg) {
      this.dataManager.set(BEGGING, beg);
   }

   /**
    * Returns true if the mob is currently able to mate with the specified mob.
    */
   public boolean canMateWith(AnimalEntity otherAnimal) {
      if (otherAnimal == this) {
         return false;
      }  else if (!(otherAnimal instanceof YodaEntity)) {
         return false;
      } else {
         YodaEntity YodaEntity = (YodaEntity)otherAnimal;
 
            return this.isInLove() && YodaEntity.isInLove();
         
      }
   }

   public boolean isBegging() {
      return this.dataManager.get(BEGGING);
   }


   public boolean canBeLeashedTo(PlayerEntity player) {
      return  super.canBeLeashedTo(player);
   }

   class AvoidEntityGoal<T extends LivingEntity> extends net.minecraft.entity.ai.goal.AvoidEntityGoal<T> {
      private final YodaEntity wolf;

      public AvoidEntityGoal(YodaEntity wolfIn, Class<T> p_i47251_3_, float p_i47251_4_, double p_i47251_5_, double p_i47251_7_) {
         super(wolfIn, p_i47251_3_, p_i47251_4_, p_i47251_5_, p_i47251_7_);
         this.wolf = wolfIn;
      }

      /**
       * Returns whether the EntityAIBase should begin execution.
       */

   }
}