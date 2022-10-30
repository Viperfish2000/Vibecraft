package com.viperfish2000.vscomod.world.feature;

import com.google.common.collect.ImmutableList;
import com.viperfish2000.vscomod.block.BlockList;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.DoublePlantBlockPlacer;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.NoiseDependant;
import net.minecraft.world.gen.placement.Placement;

public class BiomeFeatures {
	private final static BlockState POPPY = BlockList.desert_poppy.getDefaultState();
	private final static BlockState CALLUNA = BlockList.calluna.getDefaultState();
	private final static BlockState PETUNIA = BlockList.petunia.getDefaultState();
	private final static BlockState AZURE_BLUET = Blocks.AZURE_BLUET.getDefaultState();
	private final static BlockState OXEYE_DAISY = Blocks.OXEYE_DAISY.getDefaultState();
	private final static BlockState PURPLE_CONEFLOWER = BlockList.purple_coneflower.getDefaultState();
	private final static BlockState SUNFLOWER = BlockList.sunflower.getDefaultState();
	private final static BlockState PALE_ROSE_BUSH = BlockList.pale_rose_bush.getDefaultState();
	
	
	public static final BlockClusterFeatureConfig POPPY_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(POPPY), new SimpleBlockPlacer())).tries(32).build();
	public static final BlockClusterFeatureConfig SUNFLOWER_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(SUNFLOWER), new DoublePlantBlockPlacer())).tries(64).func_227317_b_().build();
	public static final BlockClusterFeatureConfig PALE_ROSE_BUSH_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PALE_ROSE_BUSH), new DoublePlantBlockPlacer())).tries(64).func_227317_b_().build();
	  

	public static final BlockClusterFeatureConfig POPPY_FLOWER_CONFIG = (new BlockClusterFeatureConfig.Builder(
			(new WeightedBlockStateProvider()).addWeightedBlockstate(CALLUNA, 2)
					.addWeightedBlockstate(PETUNIA, 1).addWeightedBlockstate(AZURE_BLUET, 2)
					.addWeightedBlockstate(OXEYE_DAISY, 1).addWeightedBlockstate(PURPLE_CONEFLOWER, 1),
			new SimpleBlockPlacer())).tries(64).build();
	
	public static final BlockClusterFeatureConfig PRAIRIE_FLOWER_CONFIG = (new BlockClusterFeatureConfig.Builder(
			(new WeightedBlockStateProvider()).addWeightedBlockstate(CALLUNA, 2)
					.addWeightedBlockstate(PETUNIA, 1).addWeightedBlockstate(AZURE_BLUET, 2)
					.addWeightedBlockstate(OXEYE_DAISY, 1).addWeightedBlockstate(PURPLE_CONEFLOWER, 1),
			new SimpleBlockPlacer())).tries(64).build();
	
	
	   public static void addPrairiePlants(Biome biomeIn) {
		      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.FANCY_TREE.withConfiguration(DefaultBiomeFeatures.FANCY_TREE_WITH_MORE_BEEHIVES_CONFIG).withChance(0.33333334F)), Feature.NORMAL_TREE.withConfiguration(DefaultBiomeFeatures.OAK_TREE_WITH_MORE_BEEHIVES_CONFIG))).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(0, 0.05F, 1))));
		      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.FLOWER.withConfiguration(PRAIRIE_FLOWER_CONFIG).withPlacement(Placement.NOISE_HEIGHTMAP_32.configure(new NoiseDependant(-0.8D, 15, 4))));
		      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.GRASS_CONFIG).withPlacement(Placement.NOISE_HEIGHTMAP_DOUBLE.configure(new NoiseDependant(-0.8D, 5, 10))));
		   }
}
