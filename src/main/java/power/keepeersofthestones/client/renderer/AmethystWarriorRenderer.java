
package power.keepeersofthestones.client.renderer;

import power.keepeersofthestones.entity.AmethystWarriorEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

public class AmethystWarriorRenderer extends HumanoidMobRenderer<AmethystWarriorEntity, HumanoidModel<AmethystWarriorEntity>> {
	public AmethystWarriorRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)),
				new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR))));
		this.addLayer(new EyesLayer<AmethystWarriorEntity, HumanoidModel<AmethystWarriorEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("power:textures/entities/amethyst_warrior.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(AmethystWarriorEntity entity) {
		return new ResourceLocation("power:textures/entities/amethyst_warrior.png");
	}
}
