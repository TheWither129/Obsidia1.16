package com.wither.obsidia.registry;

import com.wither.obsidia.Obsidia;
//import com.wither.obsidia.blocks.BrimstoneLava;
//import com.wither.obsidia.blocks.HellfireLava;
import com.wither.obsidia.blocks.ModOreBlock;
import com.wither.obsidia.blocks.ObsEndLichenBlock;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tools.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks{

    public static final Block END_DIAMOND_ORE = new ModOreBlock(FabricBlockSettings.of(Material.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 4).sounds(BlockSoundGroup.STONE).strength(50, 1200f).build());
    public static  final Block RUBY_ORE = new ModOreBlock(FabricBlockSettings.of(Material.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 2).sounds(BlockSoundGroup.STONE).strength(3, 3f).build());
    public static final Block DUSKITE = new Block(FabricBlockSettings.of(Material.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.GILDED_BLACKSTONE).strength(3, 9f).build());
    public static final Block BRIMSTONE = new Block(FabricBlockSettings.of(Material.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.NETHERRACK).strength(0.8f, 6f).build());
    public static final Block SULFUR_ORE = new Block(FabricBlockSettings.of(Material.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.NETHER_GOLD_ORE).strength(1f, 6f).build());
    public static final Block HELLFIRE_MAGMA = new Block(AbstractBlock.Settings.of(Material.STONE, MaterialColor.NETHER).requiresTool().luminance((state) -> {
        return 10;
    }).ticksRandomly().strength(0.5F).allowsSpawning((state, world, pos, entityType) -> {
        return entityType.isFireImmune();
    }));
    public static final Block CHORUS_LICHEN = new ObsEndLichenBlock(FabricBlockSettings.of(Material.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.NYLIUM).strength(3f, 9f).build());

    public static final void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(Obsidia.MOD_ID, "end_diamond_ore"), END_DIAMOND_ORE);
        Registry.register(Registry.BLOCK, new Identifier(Obsidia.MOD_ID, "ruby_ore"), RUBY_ORE);
        Registry.register(Registry.BLOCK, new Identifier(Obsidia.MOD_ID, "duskite"), DUSKITE);
        Registry.register(Registry.BLOCK, new Identifier(Obsidia.MOD_ID, "brimstone"), BRIMSTONE);
        Registry.register(Registry.BLOCK, new Identifier(Obsidia.MOD_ID, "hellfire_magma"), HELLFIRE_MAGMA);
        Registry.register(Registry.BLOCK, new Identifier(Obsidia.MOD_ID, "chorus_lichen"), CHORUS_LICHEN);
        Registry.register(Registry.BLOCK, new Identifier(Obsidia.MOD_ID, "sulfur_ore"), SULFUR_ORE);
    }
}
