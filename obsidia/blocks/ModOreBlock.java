package com.wither.obsidia.blocks;

import com.wither.obsidia.registry.ModBlocks;
import net.minecraft.block.OreBlock;
import net.minecraft.util.math.MathHelper;

import java.util.Random;

public class ModOreBlock extends OreBlock {
    public ModOreBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected int getExperienceWhenMined(Random random) {
        if (this == ModBlocks.END_DIAMOND_ORE) {
            return MathHelper.nextInt(random, 5, 10);
        } else {return this == ModBlocks.RUBY_ORE ? MathHelper.nextInt(random, 3, 7) : 3;}
    }
}
