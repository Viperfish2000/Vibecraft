package com.viperfish2000.vscomod.item;

import com.viperfish2000.vscomod.VSCOMod;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public enum ArmorMaterialList implements IArmorMaterial
{
	backpack("backpack", 0, new int[] {8, 10, 0, 7}, 25, Items.CYAN_WOOL, "item.armor.equip_leather", 0.0f),
	backpack_red("backpack_red", 0, new int[] {8, 10, 0, 7}, 25, Items.RED_WOOL, "item.armor.equip_leather", 0.0f),
	backpack_pink("backpack_pink", 0, new int[] {8, 10, 0, 7}, 25, Items.PINK_WOOL, "item.armor.equip_leather", 0.0f),
	backpack_light_blue("backpack_light_blue", 0, new int[] {8, 10, 0, 7}, 25, Items.LIGHT_BLUE_WOOL, "item.armor.equip_leather", 0.0f),
	backpack_yellow("backpack_yellow", 0, new int[] {8, 10, 0, 7}, 25, Items.YELLOW_WOOL, "item.armor.equip_leather", 0.0f),
	backpack_black("backpack_black", 0, new int[] {8, 10, 0, 7}, 25, Items.BLACK_WOOL, "item.armor.equip_leather", 0.0f),
	backpack_gray("backpack_gray", 0, new int[] {8, 10, 0, 7}, 25, Items.GRAY_WOOL, "item.armor.equip_leather", 0.0f),
	backpack_green("backpack_green", 0, new int[] {8, 10, 0, 7}, 25, Items.GREEN_WOOL, "item.armor.equip_leather", 0.0f),
	backpack_violet("backpack_violet", 0, new int[] {8, 10, 0, 7}, 25, Items.PURPLE_WOOL, "item.armor.equip_leather", 0.0f),
	backpack_rose("backpack_rose", 0, new int[] {8, 10, 0, 7}, 25, Items.MAGENTA_WOOL, "item.armor.equip_leather", 0.0f),
	bun("bun", 0, new int[] {8, 10, 0, 0}, 25, Items.WHITE_WOOL, "item.armor.equip_leather", 0.0f),
	ponytail("ponytail", 0, new int[] {8, 10, 0, 0}, 25, Items.WHITE_WOOL, "item.armor.equip_leather", 0.0f),
	airpods("airpods", 0, new int[] {8, 10, 0, 0}, 25, Items.WHITE_WOOL, "item.armor.equip_iron", 0.0f),
	blackpods("blackpods", 0, new int[] {8, 10, 0, 0}, 25, Items.WHITE_WOOL, "item.armor.equip_iron", 0.0f),
	sunglasses("sunglasses", 0, new int[] {8, 10, 0, 0}, 25, Items.WHITE_WOOL, "item.armor.equip_iron", 0.0f),
	necklace("necklace", 0, new int[] {8, 10, 0, 0}, 25, Items.WHITE_WOOL, "item.armor.equip_leather", 0.0f),
	hat("hat", 0, new int[] {8, 10, 0, 0}, 25, Items.WHEAT, "item.armor.equip_leather", 0.0f),
	azure_bluet_flower_crown("azure_bluet_flower_crown", 0, new int[] {8, 10, 0, 0}, 25, Items.AZURE_BLUET, "item.armor.equip_leather", 0.0f),
	dandelion_flower_crown("dandelion_flower_crown", 0, new int[] {8, 10, 0, 0}, 25, Items.DANDELION, "item.armor.equip_leather", 0.0f),
	petunia_flower_crown("petunia_flower_crown", 0, new int[] {8, 10, 0, 0}, 25, ItemList.petunia, "item.armor.equip_leather", 0.0f),
	oxeye_daisy_flower_crown("oxeye_daisy_flower_crown", 0, new int[] {8, 10, 0, 0}, 25, Items.OXEYE_DAISY, "item.armor.equip_leather", 0.0f),
	pink_and_white_flower_crown("pink_and_white_flower_crown", 0, new int[] {8, 10, 0, 0}, 25, Items.WHITE_TULIP, "item.armor.equip_leather", 0.0f);
	
	private static final int[] max_damage_array = new int[]{13, 15, 16, 11};
	private String name, equipSound;
	private int durability, enchantability;
	private Item repairItem;
	private int[] damageReductionAmounts;
	private float toughness;
	
	private ArmorMaterialList(String name, int durability, int[] damageReductionAmounts, int enchantability, Item repairItem, String equipSound, float toughness) 
	{
		this.name = name;
		this.equipSound = equipSound;
		this.durability = durability;
		this.enchantability = enchantability;
		this.repairItem = repairItem;
		this.damageReductionAmounts = damageReductionAmounts;
		this.toughness = toughness;
	}

	@Override
	public int getDamageReductionAmount(EquipmentSlotType slot) 
	{
		return this.damageReductionAmounts[slot.getIndex()];
	}

	@Override
	public int getDurability(EquipmentSlotType slot) 
	{
		return max_damage_array[slot.getIndex()] * this.durability;
	}

	@Override
	public int getEnchantability() 
	{
		return this.enchantability;
	}

	@Override
	public String getName() 
	{
		return VSCOMod.modid + ":" + this.name;
	}

	@Override
	public Ingredient getRepairMaterial() 
	{
		return Ingredient.fromItems(this.repairItem);
	}

	@Override
	public SoundEvent getSoundEvent() 
	{
		return new SoundEvent(new ResourceLocation(equipSound));
	}

	@Override
	public float getToughness() 
	{
		return this.toughness;
	}
}