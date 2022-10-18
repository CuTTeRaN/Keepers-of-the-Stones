package power.keepeersofthestones.procedures;

import power.keepeersofthestones.network.PowerModVariables;
import power.keepeersofthestones.init.PowerModBlocks;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class SunExplodeUseProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).battery) {
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, y, z, 4, Explosion.BlockInteraction.DESTROY);
			if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == PowerModBlocks.MOON_STONES_BLOCK.get()) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""),
									_level.getServer(), null).withSuppressedOutput(),
							"fill ~-16 ~-16 ~-16 ~16 ~16 ~16 air replace power:moon_stones_block");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""),
									_level.getServer(), null).withSuppressedOutput(),
							"fill ~-16 ~-16 ~-16 ~16 ~16 ~16 air replace power:unmultiplication_moon_stones_block");
			} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == PowerModBlocks.UNMULTIPLICATION_MOON_STONES_BLOCK.get()) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""),
									_level.getServer(), null).withSuppressedOutput(),
							"fill ~-16 ~-16 ~-16 ~16 ~16 ~16 air replace power:moon_stones_block");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""),
									_level.getServer(), null).withSuppressedOutput(),
							"fill ~-16 ~-16 ~-16 ~16 ~16 ~16 air replace power:unmultiplication_moon_stones_block");
			}
		} else {
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, y, z, 4, Explosion.BlockInteraction.NONE);
		}
	}
}
