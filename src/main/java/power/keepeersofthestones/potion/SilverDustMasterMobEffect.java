
package power.keepeersofthestones.potion;

import power.keepeersofthestones.procedures.SilverDustMasterKoghdaEffiektZakanchivaietsiaProcedure;
import power.keepeersofthestones.procedures.SilverDustMasterKoghdaEffiektNachatprimienienProcedure;
import power.keepeersofthestones.procedures.SilverDustMasterKazhdyiTikVoVriemiaEffiektaProcedure;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class SilverDustMasterMobEffect extends MobEffect {
	public SilverDustMasterMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -3355444);
	}

	@Override
	public String getDescriptionId() {
		return "effect.power.silver_dust_master";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		SilverDustMasterKoghdaEffiektNachatprimienienProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		SilverDustMasterKazhdyiTikVoVriemiaEffiektaProcedure.execute(entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		SilverDustMasterKoghdaEffiektZakanchivaietsiaProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
