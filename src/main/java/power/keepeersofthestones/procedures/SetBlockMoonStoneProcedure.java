package power.keepeersofthestones.procedures;

import power.keepeersofthestones.init.PowerModBlocks;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class SetBlockMoonStoneProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		class WaitHandlerSetBlockMoonStone1 {
			private int ticks = 0;
			private float waitTicks;
			private LevelAccessor world;

			public void start(LevelAccessor world, int waitTicks) {
				this.waitTicks = waitTicks;
				this.world = world;
				MinecraftForge.EVENT_BUS.register(WaitHandlerSetBlockMoonStone1.this);
			}

			@SubscribeEvent
			public void tick(TickEvent.ServerTickEvent event) {
				if (event.phase == TickEvent.Phase.END) {
					WaitHandlerSetBlockMoonStone1.this.ticks += 1;
					if (WaitHandlerSetBlockMoonStone1.this.ticks >= WaitHandlerSetBlockMoonStone1.this.waitTicks)
						run();
				}
			}

			private void run() {
				MinecraftForge.EVENT_BUS.unregister(WaitHandlerSetBlockMoonStone1.this);
				world.setBlock(new BlockPos(x, y, z), PowerModBlocks.MOON_STONES_BLOCK.get().defaultBlockState(), 3);
			}
		}
		new WaitHandlerSetBlockMoonStone1().start(world, 3);
	}
}
