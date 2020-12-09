package com.wither.obsidia;

import com.wither.obsidia.registry.ModBiomes;
import com.wither.obsidia.registry.ModBlocks;
import com.wither.obsidia.registry.ModFeatures;
import com.wither.obsidia.registry.ModItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public class Obsidia implements ModInitializer {

    public static final String MOD_ID = "obsidia";

    public static final ConfiguredSurfaceBuilder<TernarySurfaceConfig> BRIMSTONE_BUILDER = SurfaceBuilder.NETHER
            .withConfig(new TernarySurfaceConfig(
                    ModBlocks.BRIMSTONE.getDefaultState(),
                    ModBlocks.BRIMSTONE.getDefaultState(),
                    Blocks.GRAVEL.getDefaultState()));
    public static final ConfiguredSurfaceBuilder<TernarySurfaceConfig> CHORUS_BUILDER = SurfaceBuilder.NETHER_FOREST
            .withConfig(new TernarySurfaceConfig(
                    ModBlocks.CHORUS_LICHEN.getDefaultState(),
                    Blocks.END_STONE.getDefaultState(),
                    Blocks.END_STONE.getDefaultState()));

    @Override
    public void onInitialize() {
        ModItems.registerItems();
        ModBlocks.registerBlocks();
        ModBiomes.registerBiomes();
        ModFeatures.registerFeatures();
        Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, new Identifier(Obsidia.MOD_ID, "brimstone_caverns"), BRIMSTONE_BUILDER);
        Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, new Identifier(Obsidia.MOD_ID, "chorus_forest"), CHORUS_BUILDER);

    }
}
