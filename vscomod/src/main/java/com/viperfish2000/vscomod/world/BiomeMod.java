package com.viperfish2000.vscomod.world;

import com.viperfish2000.vscomod.VSCOMod;
import com.viperfish2000.vscomod.world.biomes.PoppyFieldsBiome;
import com.viperfish2000.vscomod.world.biomes.PrairieBiome;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
//@ObjectHolder(Voyage.MODID)
public class BiomeMod {
public static Biome poppy_fields;
public static Biome prairie;
	@SubscribeEvent
	public static void registerBiomes(final RegistryEvent.Register<Biome> event) {
		IForgeRegistry<Biome> reg = event.getRegistry();
		poppy_fields = register(reg, new PoppyFieldsBiome(), "poppy_biome", 10, true, BiomeType.DESERT, Type.HOT, Type.DRY);
		prairie = register(reg, new PrairieBiome(), "prairie_biome", 10, true, BiomeType.WARM, Type.PLAINS);
		//register(reg, new PoppyFieldsBiome(), "ughh", 10, true, BiomeType.WARM, Type.HOT, Type.DRY);
	}
	
	//Convenience
	private static Biome register(IForgeRegistry<Biome> reg, Biome biome, String name, int weight, boolean canSpawn, BiomeType managerType, Type... dictTypes) {
		reg.register(biome.setRegistryName(VSCOMod.location(name)));
		BiomeManager.addBiome(managerType, new BiomeManager.BiomeEntry(biome, weight));
		if (canSpawn) BiomeManager.addSpawnBiome(biome);
		BiomeDictionary.addTypes(biome, dictTypes);
		return biome;
	}
}