
package power.keepeersofthestones.potion;

import power.keepeersofthestones.procedures.PolarisEffectStartProcedure;
import power.keepeersofthestones.procedures.PolarisEffectEndProcedure;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class PowerOfPolarisMobEffect extends MobEffect {
	public PowerOfPolarisMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -13369396);
	}

	@Override
	public String getDescriptionId() {
		return "effect.power.power_of_polaris";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		PolarisEffectStartProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		PolarisEffectEndProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
