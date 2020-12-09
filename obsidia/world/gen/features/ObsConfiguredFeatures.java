/**package com.wither.obsidia.world.gen.features;

import com.google.common.collect.ImmutableList;
import com.wither.obsidia.registry.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.UniformIntDistribution;
import net.minecraft.world.gen.decorator.CountExtraDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.AcaciaFoliagePlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.trunk.ForkingTrunkPlacer;

public class ObsConfiguredFeatures {
    //public static final ConfiguredFeature<TreeFeatureConfig, ?> CHORUS;
    //public static final ConfiguredFeature<?, ?> TREES_CHORUS;
    public static final ConfiguredFeature<?, ?> BRIMSTONE_BLOBS;

    private static <FC extends FeatureConfig> ConfiguredFeature<FC, ?> register(String id, ConfiguredFeature<FC, ?> configuredFeature) {
        return (ConfiguredFeature) Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, (String) id, configuredFeature);
    }

    static {
        //CHORUS = register("chorus", Feature.TREE.configure((new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(ObsConfiguredFeatures.CHORUS_LOG), new SimpleBlockStateProvider(ObsConfiguredFeatures.CHORUS_LEAVES), new ChorusFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0)), new ForkingTrunkPlacer(5, 2, 2), new TwoLayersFeatureSize(1, 0, 2))).ignoreVines().build()));
        //TREES_CHORUS = register("trees_chorus", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(CHORUS.withChance(0.8F)), CHORUS)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.1F, 1))));
        BRIMSTONE_BLOBS = register("brimstone_blobs", (ConfiguredFeature)((ConfiguredFeature)((ConfiguredFeature)Feature.NETHERRACK_REPLACE_BLOBS.configure(new NetherrackReplaceBlobsFeatureConfig(ObsConfiguredFeatures.NETHERRACK, ObsConfiguredFeatures.BRIMSTONE, UniformIntDistribution.of(3, 4))).rangeOf(128)).spreadHorizontally()).repeat(100));

    }


    //protected static final BlockState CHORUS_LOG;
    //protected static final BlockState CHORUS_LEAVES;
    protected static final BlockState BRIMSTONE;
    protected static final BlockState NETHERRACK;

    static {
        //CHORUS_LOG = Blocks.ACACIA_LOG.getDefaultState();
        //CHORUS_LEAVES = Blocks.ACACIA_LEAVES.getDefaultState();
        BRIMSTONE = ModBlocks.BRIMSTONE.getDefaultState();
        NETHERRACK = Blocks.NETHERRACK.getDefaultState();
    }
}*/