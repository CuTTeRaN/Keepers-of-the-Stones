package power.keepeersofthestones.procedures;

import power.keepeersofthestones.init.PowerModBlocks;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class VacuumWebUseProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		class VacuumWebUseWait1 {
			private int ticks = 0;
			private float waitTicks;
			private LevelAccessor world;

			public void start(LevelAccessor world, int waitTicks) {
				this.waitTicks = waitTicks;
				this.world = world;
				MinecraftForge.EVENT_BUS.register(VacuumWebUseWait1.this);
			}

			@SubscribeEvent
			public void tick(TickEvent.ServerTickEvent event) {
				if (event.phase == TickEvent.Phase.END) {
					VacuumWebUseWait1.this.ticks += 1;
					if (VacuumWebUseWait1.this.ticks >= VacuumWebUseWait1.this.waitTicks)
						run();
				}
			}

			private void run() {
				MinecraftForge.EVENT_BUS.unregister(VacuumWebUseWait1.this);
				world.setBlock(new BlockPos(x, y + 1, z), PowerModBlocks.VACUUM_WEB_BLOCK.get().defaultBlockState(), 3);
			}
		}
		new VacuumWebUseWait1().start(world, 3);
	}
}
