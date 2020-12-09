package com.wither.obsidia;

import com.wither.obsidia.registry.*;
import net.fabricmc.api.ModInitializer;


public class Obsidia implements ModInitializer {

    public static final String MOD_ID = "obsidia";

    @Override
    public void onInitialize() {
        ModItems.registerItems();
        ModBlocks.registerBlocks();
        ModSurfaces.registerSurface();
        ModBiomes.registerBiomes();
        ModFeatures.registerFeatures();
    }
}
