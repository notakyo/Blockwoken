package de.notakyo.blockwoken.item;

import de.notakyo.blockwoken.Blockwoken;
import de.notakyo.blockwoken.item.custom.DarksteelGreatswordItem;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.world.item.component.ItemAttributeModifiers;

public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(Blockwoken.MODID);

    public static final DeferredItem<Item> DARKSTEEL_GREATSWORD = ITEMS.registerItem("darksteel_greatsword",
            properties -> new DarksteelGreatswordItem(properties
                    .durability(500)
                    .attributes(
                            ItemAttributeModifiers.builder().add(
                                    Attributes.ATTACK_DAMAGE,
                                    new AttributeModifier(
                                            Item.BASE_ATTACK_DAMAGE_ID,
                                            11.0,
                                            AttributeModifier.Operation.ADD_VALUE
                                    ),
                                    EquipmentSlotGroup.MAINHAND
                            )
                                    .add(
                                            Attributes.ATTACK_SPEED,
                                            new AttributeModifier(
                                                    Item.BASE_ATTACK_SPEED_ID,
                                                    -3.0,
                                                    AttributeModifier.Operation.ADD_VALUE
                                            ),
                                            EquipmentSlotGroup.MAINHAND
                                    )
                                    .build()
                    )
            ));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
