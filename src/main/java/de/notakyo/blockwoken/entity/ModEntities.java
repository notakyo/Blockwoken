package de.notakyo.blockwoken.entity;

import de.notakyo.blockwoken.Blockwoken;
import de.notakyo.blockwoken.entity.custom.LootChestEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(Registries.ENTITY_TYPE, Blockwoken.MODID);

    public static final DeferredHolder<EntityType<?>, EntityType<LootChestEntity>> LOOTCHEST =
            ENTITY_TYPES.register("lootchest", () ->
                    EntityType.Builder.<LootChestEntity>of(
                                    LootChestEntity::new,
                                    MobCategory.MISC
                            )
                            .sized(0.75F, 0.35F)
                            .build("blockwoken:lootchest")
            );

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
