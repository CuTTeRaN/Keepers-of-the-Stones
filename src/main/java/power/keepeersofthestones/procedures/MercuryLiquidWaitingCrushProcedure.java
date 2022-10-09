package power.keepeersofthestones.procedures;

import power.keepeersofthestones.network.PowerModVariables;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

public class MercuryLiquidWaitingCrushProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		class WaitHandlerMercuryLiquidWaitingCrush1 {
			private int ticks = 0;
			private float waitTicks;
			private LevelAccessor world;

			public void start(LevelAccessor world, int waitTicks) {
				this.waitTicks = waitTicks;
				this.world = world;
				MinecraftForge.EVENT_BUS.register(WaitHandlerMercuryLiquidWaitingCrush1.this);
			}

			@SubscribeEvent
			public void tick(TickEvent.ServerTickEvent event) {
				if (event.phase == TickEvent.Phase.END) {
					WaitHandlerMercuryLiquidWaitingCrush1.this.ticks += 1;
					if (WaitHandlerMercuryLiquidWaitingCrush1.this.ticks >= WaitHandlerMercuryLiquidWaitingCrush1.this.waitTicks)
						run();
				}
			}

			private void run() {
				MinecraftForge.EVENT_BUS.unregister(WaitHandlerMercuryLiquidWaitingCrush1.this);
				if (!(entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new PowerModVariables.PlayerVariables())).mercury) {
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 1, (false), (false)));
				}
			}
		}
		new WaitHandlerMercuryLiquidWaitingCrush1().start(world, 200);
	}
}
