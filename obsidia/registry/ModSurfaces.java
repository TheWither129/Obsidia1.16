package com.wither.obsidia.registry;

import com.wither.obsidia.Obsidia;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public class ModSurfaces {

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

       public static final void registerSurface() {
              Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, new Identifier(Obsidia.MOD_ID, "brimstone_caverns"), ModSurfaces.BRIMSTONE_BUILDER);
              Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, new Identifier(Obsidia.MOD_ID, "chorus_forest"), ModSurfaces.CHORUS_BUILDER);

       }

}
