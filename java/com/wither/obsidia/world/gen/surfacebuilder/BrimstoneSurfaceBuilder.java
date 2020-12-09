/**package com.wither.obsidia.world.gen.surfacebuilder;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.wither.obsidia.registry.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.AbstractNetherSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public class BrimstoneSurfaceBuilder extends AbstractNetherSurfaceBuilder {
    private static final BlockState BRIMSTONE;
    private static final BlockState GRAVEL;
    private static final ImmutableList<BlockState> SURFACE_STATES;

    public BrimstoneSurfaceBuilder(Codec<TernarySurfaceConfig> codec) {
        super(codec);
    }

    protected ImmutableList<BlockState> getSurfaceStates() {
        return SURFACE_STATES;
    }

    protected ImmutableList<BlockState> getUnderLavaStates() {
        return SURFACE_STATES;
    }

    protected BlockState getLavaShoreState() {
        return GRAVEL;
    }

    static {
        BRIMSTONE = ModBlocks.BRIMSTONE.getDefaultState();
        GRAVEL = Blocks.GRAVEL.getDefaultState();
        SURFACE_STATES = ImmutableList.of(BRIMSTONE);
    }
}
*/