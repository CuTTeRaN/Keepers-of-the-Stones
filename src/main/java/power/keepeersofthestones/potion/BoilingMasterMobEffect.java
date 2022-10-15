
package power.keepeersofthestones.potion;

import power.keepeersofthestones.procedures.BoilingMasterKoghdaEffiektZakanchivaietsiaProcedure;
import power.keepeersofthestones.procedures.BoilingMasterKoghdaEffiektNachatprimienienProcedure;
import power.keepeersofthestones.procedures.BoilingMasterKazhdyiTikVoVriemiaEffiektaProcedure;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class BoilingMasterMobEffect extends MobEffect {
	public BoilingMasterMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -26215);
	}

	@Override
	public String getDescriptionId() {
		return "effect.power.boiling_master";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		BoilingMasterKoghdaEffiektNachatprimienienProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		BoilingMasterKazhdyiTikVoVriemiaEffiektaProcedure.execute(entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		BoilingMasterKoghdaEffiektZakanchivaietsiaProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
