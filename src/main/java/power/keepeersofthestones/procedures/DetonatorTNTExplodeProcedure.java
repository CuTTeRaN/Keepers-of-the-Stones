package power.keepeersofthestones.procedures;

import power.keepeersofthestones.init.PowerModBlocks;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Explosion;
import net.minecraft.core.BlockPos;

public class DetonatorTNTExplodeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		class DetonatorTNTExplodeWait4 {
			private int ticks = 0;
			private float waitTicks;
			private LevelAccessor world;

			public void start(LevelAccessor world, int waitTicks) {
				this.waitTicks = waitTicks;
				this.world = world;
				MinecraftForge.EVENT_BUS.register(DetonatorTNTExplodeWait4.this);
			}

			@SubscribeEvent
			public void tick(TickEvent.ServerTickEvent event) {
				if (event.phase == TickEvent.Phase.END) {
					DetonatorTNTExplodeWait4.this.ticks += 1;
					if (DetonatorTNTExplodeWait4.this.ticks >= DetonatorTNTExplodeWait4.this.waitTicks)
						run();
				}
			}

			private void run() {
				MinecraftForge.EVENT_BUS.unregister(DetonatorTNTExplodeWait4.this);
				if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == PowerModBlocks.DETONATOR_TNT.get()) {
					world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
					if (world instanceof Level _level && !_level.isClientSide())
						_level.explode(null, x, y, z, 3, Explosion.BlockInteraction.BREAK);
				}
			}
		}
		new DetonatorTNTExplodeWait4().start(world, 200);
	}
}
