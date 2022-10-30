package com.viperfish2000.vscomod.item;

import javax.annotation.Nullable;

import com.viperfish2000.vscomod.client.models.HatModel;

import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class HatItem extends ArmorItem
{
public HatItem(IArmorMaterial material, EquipmentSlotType equipmentSlot, Item.Properties properties) { super(material, equipmentSlot, properties); }


	   
   /** @Override
    public void onArmorTick(World world, PlayerEntity player, ItemStack itemStack) {
        if(player.inventory.armorItemInSlot(3) !=null
            && player.inventory.armorItemInSlot(2) !=null && player.inventory.armorItemInSlot(2).getItem() == ItemMod.backpack)
       
            {
        this.effectPlayer(player, MobEffects.JUMP_BOOST ,0);
       
        }
       
    }
   
    private void effectPlayer(EntityPlayer player, Potion potion, int amplifier) {
        if(player.getActivePotionEffect(potion) == null || player.getActivePotionEffect(potion).getDuration() <= 1)
            player.addPotionEffect(new PotionEffect(potion, 159, amplifier, true, false));
 
        // TODO Auto-generated method stub
       
    }
    
    
@Override  
public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        if (slot == EquipmentSlotType.LEGS) {
            return"examplemod:textures/models/armor/scientist_layer_2.png" ;
        }
        /**
        if (stack == new ItemStack(ItemList.cyan_backpack)) {
        	 return"vscomod:textures/entity/armor/backpack_cyan.png" ;
        }
     
        return"vscomod:textures/entity/armor/backpack_cyan.png" ;   
    }
  **/ 

   


  @Nullable
  @OnlyIn(Dist.CLIENT)
  @Override
	public <A extends net.minecraft.client.renderer.entity.model.BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A _default) 
    {
		HatModel model = new HatModel(0f, 0, 128, 128);
            //	 A model = _default;
                 
        //      ModelLegs modelLegs = new ModelLegs(0.1f);
    		model.bipedHead.showModel = armorSlot == EquipmentSlotType.HEAD;
    		model.bipedHeadwear.showModel = armorSlot == EquipmentSlotType.HEAD;  
    		
            model.isChild = _default.isChild;
            model.isSneak = _default.isSneak;
            model.isSitting = _default.isSitting;
            model.rightArmPose = _default.rightArmPose;
            model.leftArmPose = _default.leftArmPose;
                return (A) model;

    }

}