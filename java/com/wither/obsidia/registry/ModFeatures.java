package com.wither.obsidia.registry;

import com.wither.obsidia.Obsidia;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.CountConfig;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.UniformIntDistribution;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DeltaFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import static com.wither.obsidia.registry.ModBiomes.BRIMSTONE_KEY;

public class ModFeatures {
    private static ConfiguredFeature<?, ?> RUBY_ORE = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    ModBlocks.RUBY_ORE.getDefaultState(),
                    6)) // vein size
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
                    5, // bottom offset
                    5, // min y level
                    32))) // max y level
            .spreadHorizontally()
            .repeat(5); // number of veins per chunk

    private static ConfiguredFeature<?, ?> END_DIAMOND_ORE_GEN = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.END_STONE), // base block is endstone in the end biomes
                    ModBlocks.END_DIAMOND_ORE.getDefaultState(),
                    5))
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
                    0,
                    0,
                    64)))
            .spreadHorizontally()
            .repeat(1);

    private static ConfiguredFeature<?, ?> DUSKITE_VEIN = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.END_STONE), // base block is endstone in the end biomes
                    ModBlocks.DUSKITE.getDefaultState(),
                    33))
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
                    0,
                    0,
                    256)))
            .spreadHorizontally()
            .repeat(10);

    private static ConfiguredFeature<?, ?> BRIMSTONE_BLOBS = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.NETHERRACK),
                    ModBlocks.BRIMSTONE.getDefaultState(),
                    64))
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
                    0,
                    0,
                    256)))
            .spreadHorizontally()
            .repeat(128);

    private static ConfiguredFeature<?, ?> SULFUR_VEIN = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(ModBlocks.BRIMSTONE),
                    ModBlocks.SULFUR_ORE.getDefaultState(),
                    17))
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
                    0,
                    0,
                    256)))
            .spreadHorizontally()
            .repeat(16);

    private static ConfiguredFeature<?, ?> HELLFIRE_DELTAS = Feature.DELTA_FEATURE
            .configure(new DeltaFeatureConfig(ModFeatures.LAVA_BLOCK, ModFeatures.HELLFIRE_MAGMA_BLOCK, UniformIntDistribution.of(3, 4), UniformIntDistribution.of(0, 2)))
            .decorate(Decorator.COUNT_MULTILAYER.configure(new CountConfig(40)));

    public static final void registerFeatures() {
        RegistryKey<ConfiguredFeature<?, ?>> rubyOre = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
                new Identifier(Obsidia.MOD_ID, "ruby_vein"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, rubyOre.getValue(), RUBY_ORE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, rubyOre);

        RegistryKey<ConfiguredFeature<?, ?>> endDiamondOre = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
                new Identifier(Obsidia.MOD_ID, "end_diamond_vein"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, endDiamondOre.getValue(), END_DIAMOND_ORE_GEN);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, endDiamondOre);

        RegistryKey<ConfiguredFeature<?, ?>> duskiteVein = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
                new Identifier(Obsidia.MOD_ID, "duskite_vein"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, duskiteVein.getValue(), DUSKITE_VEIN);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, duskiteVein);

        RegistryKey<ConfiguredFeature<?, ?>> brimstoneBlob = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
                new Identifier(Obsidia.MOD_ID, "brimstone_blobs"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, brimstoneBlob.getValue(), BRIMSTONE_BLOBS);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BRIMSTONE_KEY), GenerationStep.Feature.UNDERGROUND_ORES, brimstoneBlob);

        RegistryKey<ConfiguredFeature<?, ?>> sulfurVein = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
                new Identifier(Obsidia.MOD_ID, "sulfur_vein"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, sulfurVein.getValue(), SULFUR_VEIN);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BRIMSTONE_KEY), GenerationStep.Feature.UNDERGROUND_ORES, sulfurVein);

        RegistryKey<ConfiguredFeature<?, ?>> hellfireDelta = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
                new Identifier(Obsidia.MOD_ID, "hellfire_deltas"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, hellfireDelta.getValue(), HELLFIRE_DELTAS);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BRIMSTONE_KEY), GenerationStep.Feature.UNDERGROUND_ORES, hellfireDelta);
    }

    protected static final BlockState LAVA_BLOCK;
    protected static final BlockState HELLFIRE_MAGMA_BLOCK;

    static {
        LAVA_BLOCK = Blocks.LAVA.getDefaultState();
        HELLFIRE_MAGMA_BLOCK = ModBlocks.HELLFIRE_MAGMA.getDefaultState();
    }
}
