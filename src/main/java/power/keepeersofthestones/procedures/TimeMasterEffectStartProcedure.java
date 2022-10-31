package power.keepeersofthestones.procedures;

import power.keepeersofthestones.network.PowerModVariables;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.common.ForgeHooks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.TaskChainer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSigningContext;

import javax.annotation.Nullable;

public class TimeMasterEffectStartProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			boolean _setval = true;
			entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.time = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			boolean _setval = true;
			entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.active = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("power:stone_activation")),
						SoundSource.PLAYERS, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("power:stone_activation")),
						SoundSource.PLAYERS, 1, 1, false);
			}
		}
		{
			Entity _ent = entity;
			if (!_ent.level.isClientSide() && _ent.getServer() != null) {
				CommandSourceStack _css = new CommandSourceStack(_ent, _ent.position(), _ent.getRotationVector(),
						_ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
						_ent.level.getServer(), _ent, true, (c, s, r) -> {
						}, EntityAnchorArgument.Anchor.FEET, CommandSigningContext.ANONYMOUS, TaskChainer.IMMEDIATE) {
					@Override
					@Nullable
					public Entity getEntity() {
						if (StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE).getCallerClass() == ForgeHooks.class)
							return null;
						return super.getEntity();
					}
				};
				_ent.getServer().getCommands().performPrefixedCommand(_css, "item replace entity @s weapon.mainhand with air");
			}
		}
		if (entity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 30, 0, (false), (false)));
		if (!(entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).amber) {
			if (!(entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new PowerModVariables.PlayerVariables())).golden_dust) {
				{
					Entity _ent = entity;
					if (!_ent.level.isClientSide() && _ent.getServer() != null) {
						CommandSourceStack _css = new CommandSourceStack(_ent, _ent.position(), _ent.getRotationVector(),
								_ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(),
								_ent.getDisplayName(), _ent.level.getServer(), _ent, true, (c, s, r) -> {
								}, EntityAnchorArgument.Anchor.FEET, CommandSigningContext.ANONYMOUS, TaskChainer.IMMEDIATE) {
							@Override
							@Nullable
							public Entity getEntity() {
								if (StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE).getCallerClass() == ForgeHooks.class)
									return null;
								return super.getEntity();
							}
						};
						_ent.getServer().getCommands().performPrefixedCommand(_css,
								"item replace entity @s armor.head with power:time_helmet{Enchantments:[{id:binding_curse,lvl:1},{id:vanishing_curse,lvl:1}]}");
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level.isClientSide() && _ent.getServer() != null) {
						CommandSourceStack _css = new CommandSourceStack(_ent, _ent.position(), _ent.getRotationVector(),
								_ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(),
								_ent.getDisplayName(), _ent.level.getServer(), _ent, true, (c, s, r) -> {
								}, EntityAnchorArgument.Anchor.FEET, CommandSigningContext.ANONYMOUS, TaskChainer.IMMEDIATE) {
							@Override
							@Nullable
							public Entity getEntity() {
								if (StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE).getCallerClass() == ForgeHooks.class)
									return null;
								return super.getEntity();
							}
						};
						_ent.getServer().getCommands().performPrefixedCommand(_css,
								"item replace entity @s armor.chest with power:time_chestplate{Enchantments:[{id:binding_curse,lvl:1},{id:vanishing_curse,lvl:1}]}");
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level.isClientSide() && _ent.getServer() != null) {
						CommandSourceStack _css = new CommandSourceStack(_ent, _ent.position(), _ent.getRotationVector(),
								_ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(),
								_ent.getDisplayName(), _ent.level.getServer(), _ent, true, (c, s, r) -> {
								}, EntityAnchorArgument.Anchor.FEET, CommandSigningContext.ANONYMOUS, TaskChainer.IMMEDIATE) {
							@Override
							@Nullable
							public Entity getEntity() {
								if (StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE).getCallerClass() == ForgeHooks.class)
									return null;
								return super.getEntity();
							}
						};
						_ent.getServer().getCommands().performPrefixedCommand(_css,
								"item replace entity @s armor.legs with power:time_leggings{Enchantments:[{id:binding_curse,lvl:1},{id:vanishing_curse,lvl:1}]}");
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level.isClientSide() && _ent.getServer() != null) {
						CommandSourceStack _css = new CommandSourceStack(_ent, _ent.position(), _ent.getRotationVector(),
								_ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(),
								_ent.getDisplayName(), _ent.level.getServer(), _ent, true, (c, s, r) -> {
								}, EntityAnchorArgument.Anchor.FEET, CommandSigningContext.ANONYMOUS, TaskChainer.IMMEDIATE) {
							@Override
							@Nullable
							public Entity getEntity() {
								if (StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE).getCallerClass() == ForgeHooks.class)
									return null;
								return super.getEntity();
							}
						};
						_ent.getServer().getCommands().performPrefixedCommand(_css,
								"item replace entity @s armor.feet with power:time_boots{Enchantments:[{id:binding_curse,lvl:1},{id:vanishing_curse,lvl:1}]}");
					}
				}
			}
		}
		{
			Entity _ent = entity;
			if (!_ent.level.isClientSide() && _ent.getServer() != null) {
				CommandSourceStack _css = new CommandSourceStack(_ent, _ent.position(), _ent.getRotationVector(),
						_ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
						_ent.level.getServer(), _ent, true, (c, s, r) -> {
						}, EntityAnchorArgument.Anchor.FEET, CommandSigningContext.ANONYMOUS, TaskChainer.IMMEDIATE) {
					@Override
					@Nullable
					public Entity getEntity() {
						if (StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE).getCallerClass() == ForgeHooks.class)
							return null;
						return super.getEntity();
					}
				};
				_ent.getServer().getCommands().performPrefixedCommand(_css,
						"give @s power:time_blade{Enchantments:[{id:binding_curse,lvl:1},{id:vanishing_curse,lvl:1}]}");
			}
		}
		{
			Entity _ent = entity;
			if (!_ent.level.isClientSide() && _ent.getServer() != null) {
				CommandSourceStack _css = new CommandSourceStack(_ent, _ent.position(), _ent.getRotationVector(),
						_ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
						_ent.level.getServer(), _ent, true, (c, s, r) -> {
						}, EntityAnchorArgument.Anchor.FEET, CommandSigningContext.ANONYMOUS, TaskChainer.IMMEDIATE) {
					@Override
					@Nullable
					public Entity getEntity() {
						if (StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE).getCallerClass() == ForgeHooks.class)
							return null;
						return super.getEntity();
					}
				};
				_ent.getServer().getCommands().performPrefixedCommand(_css,
						"give @s power:time_dilation{Enchantments:[{id:binding_curse,lvl:1},{id:vanishing_curse,lvl:1}]}");
			}
		}
		{
			Entity _ent = entity;
			if (!_ent.level.isClientSide() && _ent.getServer() != null) {
				CommandSourceStack _css = new CommandSourceStack(_ent, _ent.position(), _ent.getRotationVector(),
						_ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
						_ent.level.getServer(), _ent, true, (c, s, r) -> {
						}, EntityAnchorArgument.Anchor.FEET, CommandSigningContext.ANONYMOUS, TaskChainer.IMMEDIATE) {
					@Override
					@Nullable
					public Entity getEntity() {
						if (StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE).getCallerClass() == ForgeHooks.class)
							return null;
						return super.getEntity();
					}
				};
				_ent.getServer().getCommands().performPrefixedCommand(_css,
						"give @s power:acceleration_time{Enchantments:[{id:binding_curse,lvl:1},{id:vanishing_curse,lvl:1}]}");
			}
		}
		{
			Entity _ent = entity;
			if (!_ent.level.isClientSide() && _ent.getServer() != null) {
				CommandSourceStack _css = new CommandSourceStack(_ent, _ent.position(), _ent.getRotationVector(),
						_ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
						_ent.level.getServer(), _ent, true, (c, s, r) -> {
						}, EntityAnchorArgument.Anchor.FEET, CommandSigningContext.ANONYMOUS, TaskChainer.IMMEDIATE) {
					@Override
					@Nullable
					public Entity getEntity() {
						if (StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE).getCallerClass() == ForgeHooks.class)
							return null;
						return super.getEntity();
					}
				};
				_ent.getServer().getCommands().performPrefixedCommand(_css,
						"give @s power:time_reversed{Enchantments:[{id:binding_curse,lvl:1},{id:vanishing_curse,lvl:1}]}");
			}
		}
		{
			Entity _ent = entity;
			if (!_ent.level.isClientSide() && _ent.getServer() != null) {
				CommandSourceStack _css = new CommandSourceStack(_ent, _ent.position(), _ent.getRotationVector(),
						_ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
						_ent.level.getServer(), _ent, true, (c, s, r) -> {
						}, EntityAnchorArgument.Anchor.FEET, CommandSigningContext.ANONYMOUS, TaskChainer.IMMEDIATE) {
					@Override
					@Nullable
					public Entity getEntity() {
						if (StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE).getCallerClass() == ForgeHooks.class)
							return null;
						return super.getEntity();
					}
				};
				_ent.getServer().getCommands().performPrefixedCommand(_css,
						"give @s power:time_stop{Enchantments:[{id:binding_curse,lvl:1},{id:vanishing_curse,lvl:1}]}");
			}
		}
	}
}
