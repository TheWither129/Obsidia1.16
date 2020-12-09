/*package com.wither.obsidia.blocks;

import com.wither.obsidia.registry.ModBlocks;
import com.wither.obsidia.registry.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;

public abstract class HellfireLava extends BrimstoneLava
{
    @Override
    public Fluid getStill()
    {
        return ModBlocks.HELLFIRE_LAVA;
    }

    @Override
    public Fluid getFlowing()
    {
        return ModBlocks.FLOWING_HELLFIRE_LAVA;
    }

    @Override
    public Item getBucketItem()
    {
        return ModItems.HELLFIRE_LAVA_BUCKET;
    }

    @Override
    protected BlockState toBlockState(FluidState fluidState)
    {
        // method_15741 converts the LEVEL_1_8 of the fluid state to the LEVEL_15 the fluid block uses
        return ModBlocks.HELLFIRELAVA.getDefaultState().with(Properties.LEVEL_15, method_15741(fluidState));
    }

    public static class Flowing extends BrimstoneLava
    {
        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder)
        {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getLevel(FluidState fluidState)
        {
            return fluidState.get(LEVEL);
        }

        @Override
        public boolean isStill(FluidState fluidState)
        {
            return false;
        }
    }

    public static class Still extends BrimstoneLava
    {
        @Override
        public int getLevel(FluidState fluidState)
        {
            return 8;
        }

        @Override
        public boolean isStill(FluidState fluidState)
        {
            return true;
        }
    }

}
*/