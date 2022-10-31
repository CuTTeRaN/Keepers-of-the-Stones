package power.keepeersofthestones.procedures;

import power.keepeersofthestones.network.PowerModVariables;
import power.keepeersofthestones.init.PowerModItems;
import power.keepeersofthestones.PowerMod;

import net.minecraftforge.common.ForgeHooks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;

public class LittleSizeUseProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.LITTLE_SIZE.get()) {
			if (!(entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).big) {
				if (world.isClientSide())
					Minecraft.getInstance().gameRenderer.displayItemActivation(itemstack);
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack.getItem(), 1200);
				{
					Entity _ent = entity;
					if (!_ent.level.isClientSide() && _ent.getServer() != null) {
						CommandSourceStack _css = new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
								_ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(),
								_ent.getDisplayName(), _ent.level.getServer(), _ent) {
							@Override
							@Nullable
							public Entity getEntity() {
								if (StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE).getCallerClass() == ForgeHooks.class)
									return null;
								return super.getEntity();
							}
						};
						_ent.getServer().getCommands().performPrefixedCommand(_css, "scale set pehkui:base 0.1 @s");
					}
				}
				{
					boolean _setval = true;
					entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.little = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				PowerMod.queueServerWork(800, () -> {
					{
						Entity _ent = entity;
						if (!_ent.level.isClientSide() && _ent.getServer() != null) {
							CommandSourceStack _css = new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
									_ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(),
									_ent.getDisplayName(), _ent.level.getServer(), _ent) {
								@Override
								@Nullable
								public Entity getEntity() {
									if (StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE).getCallerClass() == ForgeHooks.class)
										return null;
									return super.getEntity();
								}
							};
							_ent.getServer().getCommands().performPrefixedCommand(_css, "scale set pehkui:base 1 @s");
						}
					}
					{
						boolean _setval = false;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.little = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				});
			}
		}
	}
}
