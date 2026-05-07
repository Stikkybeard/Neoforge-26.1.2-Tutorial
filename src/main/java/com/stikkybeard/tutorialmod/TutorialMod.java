package com.stikkybeard.tutorialmod;

import com.stikkybeard.tutorialmod.blocks.ModBlocks;
import com.stikkybeard.tutorialmod.items.ModItems;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(TutorialMod.MOD_ID)
public class TutorialMod {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "tutorialmod";


    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();


    public TutorialMod(IEventBus modEventBus, ModContainer modContainer) {

        modEventBus.addListener(this::commonSetup);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);


        modEventBus.addListener(this::addCreative);


        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {

        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.AZURITE);
            event.accept(ModItems.RAW_AZURITE);
            event.accept(ModItems.AZURITE_INGOT);
        }

        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {

    event.accept(ModBlocks.AZURITE_BLOCK);
    event.accept(ModBlocks.RAW_AZURITE_BLOCK);
    event.accept(ModBlocks.AZURITE_ORE);
    event.accept(ModBlocks.AZURITE_NETHER_ORE);
    event.accept(ModBlocks.AZURITE_END_ORE);
    event.accept(ModBlocks.AZURITE_DEEPSLATE_ORE);



        }


    }


    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }
}
