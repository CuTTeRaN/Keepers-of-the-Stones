package power.keepeersofthestones.procedures;

import power.keepeersofthestones.init.PowerModBlocks;

import net.minecraftforge.common.ForgeHooks;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import javax.annotation.Nullable;

public class ExplosionMasterEffectsProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20, 2, (false), (false)));
		if (entity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 20, 3, (false), (false)));
		if (entity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20, 1, (false), (false)));
		if (entity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 20, 0, (false), (false)));
		if (!(entity instanceof Player _playerHasItem
				? _playerHasItem.getInventory().contains(new ItemStack(PowerModBlocks.DETONATOR_TNT.get()))
				: false)) {
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
							"give @s power:detonator_tnt{Enchantments:[{id:binding_curse,lvl:1},{id:vanishing_curse,lvl:1}]}");
				}
			}
		}
	}
}
