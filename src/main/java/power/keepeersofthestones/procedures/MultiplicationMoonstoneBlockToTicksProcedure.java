package power.keepeersofthestones.procedures;

import power.keepeersofthestones.init.PowerModBlocks;
import power.keepeersofthestones.PowerMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class MultiplicationMoonstoneBlockToTicksProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Math.random() < 0.5) {
			PowerMod.queueServerWork(400, () -> {
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
			});
		} else if (Math.random() > 0.5) {
			PowerMod.queueServerWork(400, () -> {
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
			});
		}
	}
}
