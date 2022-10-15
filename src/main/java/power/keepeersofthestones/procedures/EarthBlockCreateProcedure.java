package power.keepeersofthestones.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class EarthBlockCreateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		class EarthBlockCreateWait1 {
			private int ticks = 0;
			private float waitTicks;
			private LevelAccessor world;

			public void start(LevelAccessor world, int waitTicks) {
				this.waitTicks = waitTicks;
				this.world = world;
				MinecraftForge.EVENT_BUS.register(EarthBlockCreateWait1.this);
			}

			@SubscribeEvent
			public void tick(TickEvent.ServerTickEvent event) {
				if (event.phase == TickEvent.Phase.END) {
					EarthBlockCreateWait1.this.ticks += 1;
					if (EarthBlockCreateWait1.this.ticks >= EarthBlockCreateWait1.this.waitTicks)
						run();
				}
			}

			private void run() {
				MinecraftForge.EVENT_BUS.unregister(EarthBlockCreateWait1.this);
				world.setBlock(new BlockPos(x, y + 1, z), Blocks.DIRT.defaultBlockState(), 3);
			}
		}
		new EarthBlockCreateWait1().start(world, 3);
	}
}
