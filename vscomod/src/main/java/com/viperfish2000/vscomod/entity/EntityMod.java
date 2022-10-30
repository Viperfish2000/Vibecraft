package com.viperfish2000.vscomod.entity;

import com.viperfish2000.vscomod.VSCOMod;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.HangingEntity;
import net.minecraft.entity.item.PaintingEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.event.RegistryEvent;
import com.viperfish2000.vscomod.item.ItemList;

public class EntityMod {
//	public static EntityType<?> VASCO_DECAL = EntityType.Builder.<VSCODecal2>create(VSCODecal2::new, EntityClassification.MISC).build(VSCOMod.modid + ":vsco_decal").setRegistryName(VSCOMod.location("vsco_decal"));
	public static void registerEntitySpawnEggs(final RegistryEvent.Register<Item> event)
	{
		
		event.getRegistry().registerAll
		(
		//	ItemList.vsco_decal_egg = registerEntitySpawnEgg(VASCO_DECAL, 0xffffff, 0xffffff, "vsco_decal_egg" )
			
		);
	}
	public static Item registerEntitySpawnEgg(EntityType<?> type, int color1, int color2, String name)
	{
		SpawnEggItem item = new SpawnEggItem(type, color1, color2, new Item.Properties());
		item.setRegistryName(VSCOMod.location(name));
		return item;
	}
	
	public static void RegisterEntityWorldSpawn()
	{
		registerEntityWorldSpawn(EntityRegistry.HEDGEHOG, EntityClassification.CREATURE, Biomes.SUNFLOWER_PLAINS, Biomes.FLOWER_FOREST);
		registerEntityWorldSpawns(EntityRegistry.BUTTERFLY, EntityClassification.CREATURE, Biomes.PLAINS);
		registerEntityWorldSpawns(EntityRegistry.BUTTERFLY, EntityClassification.CREATURE, Biomes.JUNGLE);
		registerEntityWorldSpawns(EntityRegistry.BUTTERFLY, EntityClassification.CREATURE, Biomes.FOREST);
		registerEntityWorldSpawns(EntityRegistry.BUTTERFLY, EntityClassification.CREATURE, Biomes.MOUNTAINS);
		registerEntityWorldSpawns(EntityRegistry.BUTTERFLY, EntityClassification.CREATURE, Biomes.FLOWER_FOREST);
		registerEntityWorldSpawns(EntityRegistry.BUTTERFLY, EntityClassification.CREATURE, Biomes.SUNFLOWER_PLAINS);
		registerKoiWorldSpawn(EntityRegistry.KOI, EntityClassification.WATER_CREATURE, Biomes.RIVER);
	}
	public static void registerEntityWorldSpawns(EntityType<?> entity, EntityClassification classification, Biome...biomes) {
		for(Biome biome : biomes)
		{
			if(biome != null)
			{
				biome.getSpawns(classification).add(new SpawnListEntry(entity, 20, 3 ,6));
			}
		}
	}
	public static void registerEntityWorldSpawn(EntityType<?> entity, EntityClassification classification, Biome...biomes) {
		for(Biome biome : biomes)
		{
			if(biome != null)
			{
				biome.getSpawns(classification).add(new SpawnListEntry(entity, 20, 2 ,4));
			}
		}
	}
	public static void registerKoiWorldSpawn(EntityType<?> entity, EntityClassification classification, Biome...biomes) {
		for(Biome biome : biomes)
		{
			if(biome != null)
			{
				biome.getSpawns(classification).add(new SpawnListEntry(entity, 5, 1, 5));
			}
		}
	}
}
