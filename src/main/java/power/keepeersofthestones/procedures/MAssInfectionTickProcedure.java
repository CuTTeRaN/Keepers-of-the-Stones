package power.keepeersofthestones.procedures;

import net.minecraftforge.common.ForgeHooks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import javax.annotation.Nullable;

public class MAssInfectionTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			Entity _ent = entity;
			if (!_ent.level.isClientSide() && _ent.getServer() != null) {
				CommandSourceStack _css = new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
						_ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
						_ent.level.getServer(), _ent) {
					@Override
					@Nullable
					public Entity getEntity() {
						if (StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE).getCallerClass() == ForgeHooks.class)
							return null;
						return super.getEntity();
					}
				};
				_ent.getServer().getCommands().performPrefixedCommand(_css, "effect give @e wither 1 1");
			}
		}
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.WITHER);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.WITCH, x, y, z, 10, 1, 1, 1, 1);
	}
}
