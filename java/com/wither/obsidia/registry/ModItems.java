package com.wither.obsidia.registry;

import com.wither.obsidia.Obsidia;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

//import static com.wither.obsidia.registry.ModBlocks.HELLFIRE_LAVA;

public class ModItems {

    public static final Item CORRUPT_DIAMOND = new Item(new Item.Settings().fireproof().group(ItemGroup.MATERIALS));
    public static final Item RUBY = new Item(new Item.Settings().group(ItemGroup.MATERIALS));

   // public static Item HELLFIRE_LAVA_BUCKET;

    public static final void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(Obsidia.MOD_ID, "corrupt_diamond"), CORRUPT_DIAMOND);
        Registry.register(Registry.ITEM, new Identifier(Obsidia.MOD_ID, "ruby"), RUBY);

        Registry.register(Registry.ITEM, new Identifier(Obsidia.MOD_ID, "end_diamond_ore"),
                new BlockItem(ModBlocks.END_DIAMOND_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(Obsidia.MOD_ID, "ruby_ore"),
                new BlockItem(ModBlocks.RUBY_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(Obsidia.MOD_ID, "duskite"),
                new BlockItem(ModBlocks.DUSKITE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(Obsidia.MOD_ID, "brimstone"),
                new BlockItem(ModBlocks.BRIMSTONE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(Obsidia.MOD_ID, "hellfire_magma"),
                new BlockItem(ModBlocks.HELLFIRE_MAGMA, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(Obsidia.MOD_ID, "chorus_lichen"),
                new BlockItem(ModBlocks.CHORUS_LICHEN, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(Obsidia.MOD_ID, "sulfur_ore"),
                new BlockItem(ModBlocks.SULFUR_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier("minecraft", "monster_spawner"),
                new BlockItem(Blocks.SPAWNER, new Item.Settings().group(ItemGroup.DECORATIONS)));
    }
}
