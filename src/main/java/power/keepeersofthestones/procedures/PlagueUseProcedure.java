package power.keepeersofthestones.procedures;

import power.keepeersofthestones.network.PowerModVariables;
import power.keepeersofthestones.init.PowerModMobEffects;

import net.minecraftforge.common.ForgeHooks;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import javax.annotation.Nullable;

public class PlagueUseProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!(entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new PowerModVariables.PlayerVariables())).golden_dust) {
			{
				boolean _setval = true;
				entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.battery = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(PowerModMobEffects.PLAGUE_MASTER.get(), 6000, 1, (false), (false)));
		} else if ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new PowerModVariables.PlayerVariables())).golden_dust) {
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(PowerModMobEffects.PLAGUE_MASTER.get(), 6000, 1, (false), (false)));
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
					_ent.getServer().getCommands().performPrefixedCommand(_css,
							"give @s power:pinch_of_golden_dust{Enchantments:[{id:binding_curse,lvl:1},{id:vanishing_curse,lvl:1}]}");
				}
			}
		}
		if (entity instanceof Player _player)
			_player.closeContainer();
	}
}
