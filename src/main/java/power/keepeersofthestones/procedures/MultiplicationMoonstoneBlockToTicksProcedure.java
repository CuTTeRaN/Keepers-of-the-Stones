package power.keepeersofthestones.procedures;

import power.keepeersofthestones.init.PowerModBlocks;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class MultiplicationMoonstoneBlockToTicksProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Math.random() < 0.5) {
			class MultiplicationMoonstoneBlockToTicksWait10 {
				private int ticks = 0;
				private float waitTicks;
				private LevelAccessor world;

				public void start(LevelAccessor world, int waitTicks) {
					this.waitTicks = waitTicks;
					this.world = world;
					MinecraftForge.EVENT_BUS.register(MultiplicationMoonstoneBlockToTicksWait10.this);
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						MultiplicationMoonstoneBlockToTicksWait10.this.ticks += 1;
						if (MultiplicationMoonstoneBlockToTicksWait10.this.ticks >= MultiplicationMoonstoneBlockToTicksWait10.this.waitTicks)
							run();
					}
				}

				private void run() {
					MinecraftForge.EVENT_BUS.unregister(MultiplicationMoonstoneBlockToTicksWait10.this);
					if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == PowerModBlocks.MOON_STONES_BLOCK.get()) {
						world.setBlock(new BlockPos(x, y, z), PowerModBlocks.MOON_STONES_BLOCK.get().defaultBlockState(), 3);
						world.setBlock(new BlockPos(x, y + 1, z), PowerModBlocks.MOON_STONES_BLOCK.get().defaultBlockState(), 3);
						world.setBlock(new BlockPos(x + 1, y, z + 1), PowerModBlocks.MOON_STONES_BLOCK.get().defaultBlockState(), 3);
						world.setBlock(new BlockPos(x, y, z + 1), PowerModBlocks.MOON_STONES_BLOCK.get().defaultBlockState(), 3);
						world.setBlock(new BlockPos(x + 1, y, z), PowerModBlocks.MOON_STONES_BLOCK.get().defaultBlockState(), 3);
						world.setBlock(new BlockPos(x - 1, y, z - 1), PowerModBlocks.MOON_STONES_BLOCK.get().defaultBlockState(), 3);
						world.setBlock(new BlockPos(x, y, z - 1), PowerModBlocks.MOON_STONES_BLOCK.get().defaultBlockState(), 3);
						world.setBlock(new BlockPos(x - 1, y, z), PowerModBlocks.MOON_STONES_BLOCK.get().defaultBlockState(), 3);
					}
				}
			}
			new MultiplicationMoonstoneBlockToTicksWait10().start(world, 400);
		} else if (Math.random() > 0.5) {
			class MultiplicationMoonstoneBlockToTicksWait21 {
				private int ticks = 0;
				private float waitTicks;
				private LevelAccessor world;

				public void start(LevelAccessor world, int waitTicks) {
					this.waitTicks = waitTicks;
					this.world = world;
					MinecraftForge.EVENT_BUS.register(MultiplicationMoonstoneBlockToTicksWait21.this);
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						MultiplicationMoonstoneBlockToTicksWait21.this.ticks += 1;
						if (MultiplicationMoonstoneBlockToTicksWait21.this.ticks >= MultiplicationMoonstoneBlockToTicksWait21.this.waitTicks)
							run();
					}
				}

				private void run() {
					MinecraftForge.EVENT_BUS.unregister(MultiplicationMoonstoneBlockToTicksWait21.this);
					if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == PowerModBlocks.MOON_STONES_BLOCK.get()) {
						world.setBlock(new BlockPos(x, y, z), PowerModBlocks.UNMULTIPLICATION_MOON_STONES_BLOCK.get().defaultBlockState(), 3);
						world.setBlock(new BlockPos(x, y + 1, z), PowerModBlocks.UNMULTIPLICATION_MOON_STONES_BLOCK.get().defaultBlockState(), 3);
						world.setBlock(new BlockPos(x + 1, y, z + 1), PowerModBlocks.UNMULTIPLICATION_MOON_STONES_BLOCK.get().defaultBlockState(), 3);
						world.setBlock(new BlockPos(x, y, z + 1), PowerModBlocks.UNMULTIPLICATION_MOON_STONES_BLOCK.get().defaultBlockState(), 3);
						world.setBlock(new BlockPos(x + 1, y, z), PowerModBlocks.UNMULTIPLICATION_MOON_STONES_BLOCK.get().defaultBlockState(), 3);
						world.setBlock(new BlockPos(x - 1, y, z - 1), PowerModBlocks.UNMULTIPLICATION_MOON_STONES_BLOCK.get().defaultBlockState(), 3);
						world.setBlock(new BlockPos(x, y, z - 1), PowerModBlocks.UNMULTIPLICATION_MOON_STONES_BLOCK.get().defaultBlockState(), 3);
						world.setBlock(new BlockPos(x - 1, y, z), PowerModBlocks.UNMULTIPLICATION_MOON_STONES_BLOCK.get().defaultBlockState(), 3);
					}
				}
			}
			new MultiplicationMoonstoneBlockToTicksWait21().start(world, 400);
		}
	}
}
