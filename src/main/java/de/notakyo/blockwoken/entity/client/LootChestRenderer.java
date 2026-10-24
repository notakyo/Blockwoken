package de.notakyo.blockwoken.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import de.notakyo.blockwoken.Blockwoken;
import de.notakyo.blockwoken.entity.custom.LootChestEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class LootChestRenderer extends MobRenderer<LootChestEntity, LootChestModel<LootChestEntity>> {
    public LootChestRenderer(EntityRendererProvider.Context context) {
        super(context, new LootChestModel<>(context.bakeLayer(LootChestModel.LAYER_LOCATION)), .25F);
    }

    @Override
    public ResourceLocation getTextureLocation(LootChestEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(Blockwoken.MODID,"textures/entity/lootchest/lootchest.png");
    }

    @Override
    public void render(LootChestEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        super.render(entity,entityYaw,partialTicks,poseStack,buffer,packedLight);
    }
}
