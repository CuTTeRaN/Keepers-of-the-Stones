package power.keepeersofthestones.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class IceSharpFreezingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.setTicksFrozen((int) 1200);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.SNOWFLAKE, x, y, z, 25, 2, 2, 2, 0.1);
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, new BlockPos(x, y, z),
						ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.hurt_freeze")), SoundSource.NEUTRAL, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.hurt_freeze")),
						SoundSource.NEUTRAL, 1, 1, false);
			}
		}
	}
}
