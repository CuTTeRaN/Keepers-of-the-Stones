
package power.keepeersofthestones.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class RechargeSilverDustStoneMobEffect extends MobEffect {
	public RechargeSilverDustStoneMobEffect() {
		super(MobEffectCategory.NEUTRAL, -3355444);
	}

	@Override
	public String getDescriptionId() {
		return "effect.power.recharge_silver_dust_stone";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
