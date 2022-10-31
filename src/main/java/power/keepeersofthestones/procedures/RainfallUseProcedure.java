package power.keepeersofthestones.procedures;

import power.keepeersofthestones.PowerMod;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.common.ForgeHooks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.TaskChainer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSigningContext;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;

public class RainfallUseProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (world.isClientSide())
			Minecraft.getInstance().gameRenderer.displayItemActivation(itemstack);
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack.getItem(), 400);
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
				_ent.getServer().getCommands().performPrefixedCommand(_css, "weather rain");
			}
		}
		PowerMod.queueServerWork(600, () -> {
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
					_ent.getServer().getCommands().performPrefixedCommand(_css, "weather clear");
				}
			}
		});
	}
}
