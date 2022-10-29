package power.keepeersofthestones.procedures;

import power.keepeersofthestones.init.PowerModBlocks;
import power.keepeersofthestones.PowerMod;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Explosion;
import net.minecraft.core.BlockPos;

public class DetonatorTNTExplodeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		PowerMod.queueServerWork(200, () -> {
			if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == PowerModBlocks.DETONATOR_TNT.get()) {
				world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				if (world instanceof Level _level && !_level.isClientSide())
					_level.explode(null, x, y, z, 3, Explosion.BlockInteraction.BREAK);
			}
		});
	}
}
