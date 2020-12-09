package com.wither.obsidia.registry;

import com.wither.obsidia.Obsidia;
import net.fabricmc.fabric.impl.biome.InternalBiomeData;
import net.minecraft.block.Blocks;
import net.minecraft.client.sound.MusicType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BiomeAdditionsSound;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.ConfiguredCarvers;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.ConfiguredStructureFeatures;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public class ModBiomes {

    public static final RegistryKey<Biome> BRIMSTONE_KEY = RegistryKey.of(Registry.BIOME_KEY, new Identifier(Obsidia.MOD_ID, "brimstone_caverns"));
    public static final RegistryKey<Biome> CHORUS_KEY = RegistryKey.of(Registry.BIOME_KEY, new Identifier(Obsidia.MOD_ID, "chorus_forest"));

    private static final Biome BRIMSTONE_CAVERNS = createBrimstone();
    public static final Biome.MixedNoisePoint BRIMSTONE_NOISE = new Biome.MixedNoisePoint(-0.35F, 0.0F, 0.35F, 0.0F, 0.2F);
    private static final Biome CHORUS_FOREST = createChorus();
    //public static final Biome.MixedNoisePoint CHORUS_NOISE = new Biome.MixedNoisePoint(0.0F, 1.0F, 1.0F, 1.0F, 0.2F);

    private static Biome createBrimstone() {
        SpawnSettings spawnSettings = (new SpawnSettings.Builder()).spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SKELETON, 20, 5, 5)).spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.GHAST, 50, 4, 4)).spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ENDERMAN, 1, 4, 4)).spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.STRIDER, 60, 1, 2)).spawnCost(EntityType.SKELETON, 0.7D, 0.15D).spawnCost(EntityType.GHAST, 0.7D, 0.15D).spawnCost(EntityType.ENDERMAN, 0.7D, 0.15D).spawnCost(EntityType.STRIDER, 0.7D, 0.15D).build();
        GenerationSettings.Builder builder = (new GenerationSettings.Builder()).surfaceBuilder(ModSurfaces.BRIMSTONE_BUILDER).structureFeature(ConfiguredStructureFeatures.FORTRESS).structureFeature(ConfiguredStructureFeatures.NETHER_FOSSIL).structureFeature(ConfiguredStructureFeatures.RUINED_PORTAL_NETHER).structureFeature(ConfiguredStructureFeatures.BASTION_REMNANT).carver(GenerationStep.Carver.AIR, ConfiguredCarvers.NETHER_CAVE).feature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.SPRING_LAVA).feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.SPRING_DELTA).feature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.SPRING_LAVA_DOUBLE).feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.SPRING_OPEN).feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.GLOWSTONE_EXTRA).feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.GLOWSTONE).feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.PATCH_CRIMSON_ROOTS).feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.PATCH_FIRE).feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.PATCH_SOUL_FIRE).feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.ORE_MAGMA).feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.SPRING_CLOSED).feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.ORE_SOUL_SAND);
        DefaultBiomeFeatures.addNetherMineables(builder);
        return (new Biome.Builder()).precipitation(Biome.Precipitation.NONE).category(Biome.Category.NETHER).depth(0.1F).scale(0.2F).temperature(2.0F).downfall(0.0F).effects((new BiomeEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(1705242).skyColor(1705242).particleConfig(new BiomeParticleConfig(ParticleTypes.ASH, 0.00625F)).loopSound(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_LOOP).moodSound(new BiomeMoodSound(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_MOOD, 6000, 8, 2.0D)).additionsSound(new BiomeAdditionsSound(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_ADDITIONS, 0.0111D)).music(MusicType.createIngameMusic(SoundEvents.MUSIC_NETHER_SOUL_SAND_VALLEY)).build()).spawnSettings(spawnSettings).generationSettings(builder.build()).build();
    }
    private static Biome createChorus() {
        SpawnSettings spawnSettings = (new SpawnSettings.Builder()).spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ENDERMAN, 20, 2, 2)).spawnCost(EntityType.ENDERMAN, 0.7D, 0.15D).build();
        GenerationSettings.Builder builder = (new GenerationSettings.Builder()).surfaceBuilder(ModSurfaces.CHORUS_BUILDER).structureFeature(ConfiguredStructureFeatures.END_CITY).feature(GenerationStep.Feature.SURFACE_STRUCTURES, ConfiguredFeatures.END_GATEWAY).feature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.CHORUS_PLANT);
        return (new Biome.Builder()).precipitation(Biome.Precipitation.NONE).category(Biome.Category.THEEND).depth(0.1F).scale(0.2F).temperature(1.0F).downfall(0.0F).effects((new BiomeEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(10518688).skyColor(0).particleConfig(new BiomeParticleConfig(ParticleTypes.WARPED_SPORE, 0.00625F)).loopSound(SoundEvents.AMBIENT_WARPED_FOREST_LOOP).moodSound(new BiomeMoodSound(SoundEvents.AMBIENT_WARPED_FOREST_MOOD, 6000, 8, 2.0D)).additionsSound(new BiomeAdditionsSound(SoundEvents.AMBIENT_WARPED_FOREST_ADDITIONS, 0.0111D)).music(MusicType.createIngameMusic(SoundEvents.MUSIC_END)).build()).spawnSettings(spawnSettings).generationSettings(builder.build()).build();

    }


    public static final void registerBiomes() {
        Registry.register(BuiltinRegistries.BIOME, BRIMSTONE_KEY.getValue(), BRIMSTONE_CAVERNS);
        Registry.register(BuiltinRegistries.BIOME, CHORUS_KEY.getValue(), CHORUS_FOREST);

        InternalBiomeData.addNetherBiome(BRIMSTONE_KEY, BRIMSTONE_NOISE);
        InternalBiomeData.addEndBiomeReplacement(BiomeKeys.END_HIGHLANDS, CHORUS_KEY, 2.0);
        InternalBiomeData.addEndBiomeReplacement(BiomeKeys.END_MIDLANDS, CHORUS_KEY, 2.0);
    }
}
