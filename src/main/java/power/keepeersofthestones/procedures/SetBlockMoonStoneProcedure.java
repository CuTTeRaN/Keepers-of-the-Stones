package power.keepeersofthestones.procedures;

import power.keepeersofthestones.network.PowerModVariables;
import power.keepeersofthestones.init.PowerModBlocks;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class SetBlockMoonStoneProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).battery) {
			class SetBlockMoonStoneWait1 {
				private int ticks = 0;
				private float waitTicks;
				private LevelAccessor world;

				public void start(LevelAccessor world, int waitTicks) {
					this.waitTicks = waitTicks;
					this.world = world;
					MinecraftForge.EVENT_BUS.register(SetBlockMoonStoneWait1.this);
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						SetBlockMoonStoneWait1.this.ticks += 1;
						if (SetBlockMoonStoneWait1.this.ticks >= SetBlockMoonStoneWait1.this.waitTicks)
							run();
					}
				}

				private void run() {
					MinecraftForge.EVENT_BUS.unregister(SetBlockMoonStoneWait1.this);
					world.setBlock(new BlockPos(x, y, z), PowerModBlocks.MOON_STONES_BLOCK.get().defaultBlockState(), 3);
				}
			}
			new SetBlockMoonStoneWait1().start(world, 3);
		}
	}
}
