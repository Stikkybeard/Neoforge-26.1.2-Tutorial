package com.stikkybeard.tutorialmod.items;

import com.stikkybeard.tutorialmod.TutorialMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TutorialMod.MOD_ID);
    public static final DeferredItem<Item> AZURITE = ITEMS.registerSimpleItem("azurite");





    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }



}
