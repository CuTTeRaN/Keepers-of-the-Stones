package power.keepeersofthestones.procedures;

import power.keepeersofthestones.network.PowerModVariables;
import power.keepeersofthestones.init.PowerModItems;
import power.keepeersofthestones.PowerMod;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.common.ForgeHooks;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.TaskChainer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSigningContext;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;

public class BlueLightningUseProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, ItemStack itemstack) {
		if (entity == null || sourceentity == null)
			return;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.BLUE_LIGHTNING
				.get()) {
			if (world.isClientSide())
				Minecraft.getInstance().gameRenderer.displayItemActivation(itemstack);
			if (sourceentity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 400);
			if (!(sourceentity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new PowerModVariables.PlayerVariables())).recharge_spell_blue_flame) {
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
						_ent.getServer().getCommands().performPrefixedCommand(_css, "summon minecraft:lightning_bolt ~ ~ ~");
					}
				}
				PowerMod.queueServerWork(40, () -> {
					if (world instanceof ServerLevel _level) {
						LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
						entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
						entityToSpawn.setVisualOnly(true);
						_level.addFreshEntity(entityToSpawn);
					}
					PowerMod.queueServerWork(40, () -> {
						if (world instanceof ServerLevel _level) {
							LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
							entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
							entityToSpawn.setVisualOnly(true);
							_level.addFreshEntity(entityToSpawn);
						}
						PowerMod.queueServerWork(40, () -> {
							if (world instanceof ServerLevel _level) {
								LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
								entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
								entityToSpawn.setVisualOnly(true);
								_level.addFreshEntity(entityToSpawn);
							}
							PowerMod.queueServerWork(40, () -> {
								if (world instanceof ServerLevel _level) {
									LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
									entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
									entityToSpawn.setVisualOnly(true);
									_level.addFreshEntity(entityToSpawn);
								}
								PowerMod.queueServerWork(40, () -> {
									if (world instanceof ServerLevel _level) {
										LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
										entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
										entityToSpawn.setVisualOnly(true);
										_level.addFreshEntity(entityToSpawn);
									}
								});
							});
						});
					});
				});
			}
			{
				boolean _setval = true;
				sourceentity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.recharge_spell_blue_flame = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			PowerMod.queueServerWork(400, () -> {
				{
					boolean _setval = false;
					sourceentity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.recharge_spell_blue_flame = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
			});
		}
	}
}
