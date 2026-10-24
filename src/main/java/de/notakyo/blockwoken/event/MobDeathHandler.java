
package de.notakyo.blockwoken.event;

import de.notakyo.blockwoken.Blockwoken;
import de.notakyo.blockwoken.entity.ModEntities;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;

@EventBusSubscriber(modid = Blockwoken.MODID)
public class MobDeathHandler {

    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        LivingEntity mob = event.getEntity();
        if (mob.getMaxHealth() <= 50.0F) {
            return;
        }

        if (!(event.getSource().getEntity() instanceof Player)) {
            return;
        }

        if (!(mob.level() instanceof ServerLevel level)) {
            return;
        }

        var chest = ModEntities.LOOTCHEST.get().create(level);

        if (chest == null) {
            return;
        }

        chest.moveTo(
                mob.getX(),
                mob.getY(),
                mob.getZ(),
                mob.getYRot(),
                0.0F
        );

        level.addFreshEntity(chest);
    }
}
