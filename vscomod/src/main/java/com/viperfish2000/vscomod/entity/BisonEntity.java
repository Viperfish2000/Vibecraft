package com.viperfish2000.vscomod.entity;

import java.util.UUID;

import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomFlyingGoal;
import net.minecraft.entity.passive.IFlyingAnimal;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.HorseArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.pathfinding.FlyingPathNavigator;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class BisonEntity extends AbstractHorseEntity implements IFlyingAnimal{
   private static final UUID ARMOR_MODIFIER_UUID = UUID.fromString("556E1665-8B10-40C8-8F9D-CF9B1667F295");
   public float flap;
   public float flapSpeed;
   public float oFlapSpeed;
   public float oFlap;
   public float flapping = 1.0F;

   public BisonEntity(EntityType<? extends BisonEntity> p_i50238_1_, World worldIn) {
      super(p_i50238_1_, worldIn);
      this.moveController = new FlyingMovementController(this, 10, false);
   }

   protected void registerData() {
      super.registerData();
   
   }   private void calculateFlapping() {
	      this.oFlap = this.flap;
	      this.oFlapSpeed = this.flapSpeed;
	      this.flapSpeed = (float)((double)this.flapSpeed + (double)(!this.onGround && !this.isPassenger() ? 4 : -1) * 0.3D);
	      this.flapSpeed = MathHelper.clamp(this.flapSpeed, 0.0F, 1.0F);
	      if (!this.onGround && this.flapping < 1.0F) {
	         this.flapping = 1.0F;
	      }

	      this.flapping = (float)((double)this.flapping * 0.9D);
	      Vec3d vec3d = this.getMotion();
	      if (!this.onGround && vec3d.y < 0.0D) {
	         this.setMotion(vec3d.mul(1.0D, 0.6D, 1.0D));
	      }

	      this.flap += this.flapping * 2.0F;
	   }
   protected void registerGoals() {

	      this.goalSelector.addGoal(2, new WaterAvoidingRandomFlyingGoal(this, 1.0D));
	   }
   public void writeAdditional(CompoundNBT compound) {
      super.writeAdditional(compound);
         if (!this.horseChest.getStackInSlot(1).isEmpty()) {
         compound.put("ArmorItem", this.horseChest.getStackInSlot(1).write(new CompoundNBT()));
      }

   }

   public ItemStack func_213803_dV() {
      return this.getItemStackFromSlot(EquipmentSlotType.CHEST);
   }

   private void func_213805_k(ItemStack p_213805_1_) {
      this.setItemStackToSlot(EquipmentSlotType.CHEST, p_213805_1_);
      this.setDropChance(EquipmentSlotType.CHEST, 0.0F);
   }

   public void readAdditional(CompoundNBT compound) {
      super.readAdditional(compound);
       if (compound.contains("ArmorItem", 10)) {
         ItemStack itemstack = ItemStack.read(compound.getCompound("ArmorItem"));
         if (!itemstack.isEmpty() && this.isArmor(itemstack)) {
            this.horseChest.setInventorySlotContents(1, itemstack);
         }
      }

      this.updateHorseSlots();
   }

   public void fall(float distance, float damageMultiplier) {
   }

   protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
   }
   public boolean isFlying() {
	      return !this.onGround;
	   }

 
   protected void updateHorseSlots() {
      super.updateHorseSlots();
      this.func_213804_l(this.horseChest.getStackInSlot(1));
   }

   private void func_213804_l(ItemStack p_213804_1_) {
      this.func_213805_k(p_213804_1_);
      if (!this.world.isRemote) {
         this.getAttribute(SharedMonsterAttributes.ARMOR).removeModifier(ARMOR_MODIFIER_UUID);
         if (this.isArmor(p_213804_1_)) {
            int i = ((HorseArmorItem)p_213804_1_.getItem()).func_219977_e();
            if (i != 0) {
               this.getAttribute(SharedMonsterAttributes.ARMOR).applyModifier((new AttributeModifier(ARMOR_MODIFIER_UUID, "Horse armor bonus", (double)i, AttributeModifier.Operation.ADDITION)).setSaved(false));
            }
         }
      }

   }

   public void onInventoryChanged(IInventory invBasic) {
      ItemStack itemstack = this.func_213803_dV();
      super.onInventoryChanged(invBasic);
      ItemStack itemstack1 = this.func_213803_dV();
      if (this.ticksExisted > 20 && this.isArmor(itemstack1) && itemstack != itemstack1) {
         this.playSound(SoundEvents.ENTITY_HORSE_ARMOR, 0.5F, 1.0F);
      }

   }

   protected void playGallopSound(SoundType p_190680_1_) {
      super.playGallopSound(p_190680_1_);
      if (this.rand.nextInt(10) == 0) {
         this.playSound(SoundEvents.ENTITY_HORSE_BREATHE, p_190680_1_.getVolume() * 0.6F, p_190680_1_.getPitch());
      }

   }
   protected PathNavigator createNavigator(World worldIn) {
	      FlyingPathNavigator flyingpathnavigator = new FlyingPathNavigator(this, worldIn);
	      flyingpathnavigator.setCanOpenDoors(false);
	      flyingpathnavigator.setCanSwim(true);
	      flyingpathnavigator.setCanEnterDoors(true);
	      return flyingpathnavigator;
	   }
   protected void registerAttributes() {
      super.registerAttributes();
      this.getAttributes().registerAttribute(SharedMonsterAttributes.FLYING_SPEED);
      this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(25.0D);
      this.getAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue((double)1.1F);
      this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double)0.5F);
      this.getAttribute(JUMP_STRENGTH).setBaseValue(this.getModifiedJumpStrength());
   }

   public void tick() {
      super.tick();
      if (this.world.isRemote && this.dataManager.isDirty()) {
         this.dataManager.setClean();
      
      }
      ItemStack stack = this.horseChest.getStackInSlot(1);
      if (isArmor(stack)) stack.onHorseArmorTick(world, this);
   }
   public void livingTick() {
	      super.livingTick();
	      this.calculateFlapping();
	   }
   @Override
   public void travel(Vec3d p_213352_1_) {
	      if (this.isAlive()) {
	         if (this.isBeingRidden() && this.canBeSteered() && this.isHorseSaddled()) {
	            LivingEntity livingentity = (LivingEntity)this.getControllingPassenger();
	            this.rotationYaw = livingentity.rotationYaw;
	            this.prevRotationYaw = this.rotationYaw;
	            this.rotationPitch = livingentity.rotationPitch * 0.5F;
	            this.setRotation(this.rotationYaw, this.rotationPitch);
	            this.renderYawOffset = this.rotationYaw;
	            this.rotationYawHead = this.renderYawOffset;
	            float f = livingentity.moveStrafing * 0.5F;
	            float f1 = livingentity.moveForward;
	            if (f1 <= 0.0F) {
	               f1 *= 0.25F;
	               this.gallopTime = 0;
	            }

	            if (this.onGround && this.jumpPower == 0.0F && this.isRearing()) {
	               f = 0.0F;
	               f1 = 0.0F;
	            }

	            if (this.jumpPower > 0.0F && !this.isHorseJumping() && this.onGround) {
	               double d0 = this.getHorseJumpStrength() * (double)this.jumpPower;
	               double d1;
	               if (this.isPotionActive(Effects.JUMP_BOOST)) {
	                  d1 = d0 + (double)((float)(this.getActivePotionEffect(Effects.JUMP_BOOST).getAmplifier() + 1) * 0.1F);
	               } else {
	                  d1 = d0;
	               }

	               Vec3d vec3d = this.getMotion();
	               this.setMotion(vec3d.x, d1, vec3d.z);
	               this.setHorseJumping(true);
	               this.isAirBorne = true;
	               if (f1 > 0.0F) {
	                  float f2 = MathHelper.sin(this.rotationYaw * ((float)Math.PI / 180F));
	                  float f3 = MathHelper.cos(this.rotationYaw * ((float)Math.PI / 180F));
	                  this.setMotion(this.getMotion().add((double)(-0.4F * f2 * this.jumpPower), 0.0D, (double)(0.4F * f3 * this.jumpPower)));
	                  this.playJumpSound();
	               }

	               this.jumpPower = 0.0F;
	            }

	            this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1F;
	            if (this.canPassengerSteer()) {
	               this.setAIMoveSpeed((float)this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getValue());
	               super.travel(new Vec3d((double)f, p_213352_1_.y, (double)f1));
	            } else if (livingentity instanceof PlayerEntity) {
	               this.setMotion(Vec3d.ZERO);
	            }

	            if (this.onGround) {
	               this.jumpPower = 0.0F;
	               this.setHorseJumping(false);
	            }

	            this.prevLimbSwingAmount = this.limbSwingAmount;
	            double d2 = this.getPosX() - this.prevPosX;
	            double d3 = this.getPosZ() - this.prevPosZ;
	            float f4 = MathHelper.sqrt(d2 * d2 + d3 * d3) * 4.0F;
	            if (f4 > 1.0F) {
	               f4 = 1.0F;
	            }

	            this.limbSwingAmount += (f4 - this.limbSwingAmount) * 0.4F;
	            this.limbSwing += this.limbSwingAmount;
	         } else {
	            this.jumpMovementFactor = 0.02F;
	            super.travel(p_213352_1_);
	         }
	      }
	   }
   protected SoundEvent getAmbientSound() {
      super.getAmbientSound();
      return SoundEvents.ENTITY_HORSE_AMBIENT;
   }

   protected SoundEvent getDeathSound() {
      super.getDeathSound();
      return SoundEvents.ENTITY_HORSE_DEATH;
   }

   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
      super.getHurtSound(damageSourceIn);
      return SoundEvents.ENTITY_HORSE_HURT;
   }

   protected SoundEvent getAngrySound() {
      super.getAngrySound();
      return SoundEvents.ENTITY_HORSE_ANGRY;
   }

   public boolean processInteract(PlayerEntity player, Hand hand) {
      ItemStack itemstack = player.getHeldItem(hand);
      boolean flag = !itemstack.isEmpty();
      if (flag && itemstack.getItem() instanceof SpawnEggItem) {
         return super.processInteract(player, hand);
      } else {
         if (!this.isChild()) {
            if (this.isTame() && player.isSneaking()) {
               this.openGUI(player);
               return true;
            }

            if (this.isBeingRidden()) {
               return super.processInteract(player, hand);
            }
         }

         if (flag) {
            if (this.handleEating(player, itemstack)) {
               if (!player.abilities.isCreativeMode) {
                  itemstack.shrink(1);
               }

               return true;
            }

            if (itemstack.interactWithEntity(player, this, hand)) {
               return true;
            }

            if (!this.isTame()) {
               this.makeMad();
               return true;
            }

            boolean flag1 = !this.isChild() && !this.isHorseSaddled() && itemstack.getItem() == Items.SADDLE;
            if (this.isArmor(itemstack) || flag1) {
               this.openGUI(player);
               return true;
            }
         }

         if (this.isChild()) {
            return super.processInteract(player, hand);
         } else {
            this.mountTo(player);
            return true;
         }
      }
   }




   public boolean wearsArmor() {
      return true;
   }

   public boolean isArmor(ItemStack stack) {
      return stack.getItem() instanceof HorseArmorItem;
   }

   @Nullable
   public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
      spawnDataIn = super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
      int i;

      return spawnDataIn;
   }

   public static class HorseData implements ILivingEntityData {
      public final int variant;

      public HorseData(int variantIn) {
         this.variant = variantIn;
      }
   }
}