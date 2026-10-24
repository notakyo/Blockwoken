package de.notakyo.blockwoken.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import de.notakyo.blockwoken.Blockwoken;
import de.notakyo.blockwoken.entity.custom.LootChestEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class LootChestModel<T extends LootChestEntity> extends HierarchicalModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Blockwoken.MODID, "lootchest"), "main");
    private final ModelPart Body;
    private final ModelPart Lid;
    private final ModelPart Bottom;

    public LootChestModel(ModelPart root) {
        this.Body = root.getChild("Body");
        this.Lid = this.Body.getChild("Lid");
        this.Bottom = this.Body.getChild("Bottom");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition Lid = Body.addOrReplaceChild("Lid", CubeListBuilder.create().texOffs(0, 7).addBox(-4.0F, -6.0F, -2.0F, 8.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 12).addBox(-4.0F, -5.0F, 1.0F, 8.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 15).addBox(-4.0F, -5.0F, -3.0F, 8.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Bottom = Body.addOrReplaceChild("Bottom", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -1.0F, -3.0F, 8.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 18).addBox(-4.0F, -4.0F, -3.0F, 8.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(18, 18).addBox(-4.0F, -4.0F, 2.0F, 8.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(20, 12).addBox(-4.0F, -5.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(20, 15).addBox(3.0F, -5.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 22).addBox(3.0F, -4.0F, -2.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(10, 22).addBox(-4.0F, -4.0F, -2.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(LootChestEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    private void applyHeadRotation(float headYaw, float headPitch) {
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return Body;
    }
}
