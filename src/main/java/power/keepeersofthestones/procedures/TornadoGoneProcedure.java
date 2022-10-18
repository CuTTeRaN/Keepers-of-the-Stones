package power.keepeersofthestones.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class TornadoGoneProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		class TornadoGoneWait1 {
			private int ticks = 0;
			private float waitTicks;
			private LevelAccessor world;

			public void start(LevelAccessor world, int waitTicks) {
				this.waitTicks = waitTicks;
				this.world = world;
				MinecraftForge.EVENT_BUS.register(TornadoGoneWait1.this);
			}

			@SubscribeEvent
			public void tick(TickEvent.ServerTickEvent event) {
				if (event.phase == TickEvent.Phase.END) {
					TornadoGoneWait1.this.ticks += 1;
					if (TornadoGoneWait1.this.ticks >= TornadoGoneWait1.this.waitTicks)
						run();
				}
			}

			private void run() {
				MinecraftForge.EVENT_BUS.unregister(TornadoGoneWait1.this);
				if (!entity.level.isClientSide())
					entity.discard();
			}
		}
		new TornadoGoneWait1().start(world, 400);
	}
}
