package power.keepeersofthestones.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class WaterCreateOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.setBlock(new BlockPos(x, y + 1, z), Blocks.WATER.defaultBlockState(), 3);
		class WaitHandlerWaterCreateOnBlock2 {
			private int ticks = 0;
			private float waitTicks;
			private LevelAccessor world;

			public void start(LevelAccessor world, int waitTicks) {
				this.waitTicks = waitTicks;
				this.world = world;
				MinecraftForge.EVENT_BUS.register(WaitHandlerWaterCreateOnBlock2.this);
			}

			@SubscribeEvent
			public void tick(TickEvent.ServerTickEvent event) {
				if (event.phase == TickEvent.Phase.END) {
					WaitHandlerWaterCreateOnBlock2.this.ticks += 1;
					if (WaitHandlerWaterCreateOnBlock2.this.ticks >= WaitHandlerWaterCreateOnBlock2.this.waitTicks)
						run();
				}
			}

			private void run() {
				MinecraftForge.EVENT_BUS.unregister(WaitHandlerWaterCreateOnBlock2.this);
				world.setBlock(new BlockPos(x, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
			}
		}
		new WaitHandlerWaterCreateOnBlock2().start(world, 100);
	}
}
