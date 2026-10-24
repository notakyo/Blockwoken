package de.notakyo.blockwoken.event;

import de.notakyo.blockwoken.*;
import de.notakyo.blockwoken.entity.ModEntities;
import de.notakyo.blockwoken.entity.client.LootChestModel;
import de.notakyo.blockwoken.entity.custom.LootChestEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = Blockwoken.MODID, bus = EventBusSubscriber.Bus.MOD)

public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(LootChestModel.LAYER_LOCATION, LootChestModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.LOOTCHEST.get(), LootChestEntity.createAttributes().build());
    }
}
