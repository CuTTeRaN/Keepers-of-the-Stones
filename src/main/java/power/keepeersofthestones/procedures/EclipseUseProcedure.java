package power.keepeersofthestones.procedures;

import power.keepeersofthestones.init.PowerModItems;
import power.keepeersofthestones.PowerMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.Minecraft;

public class EclipseUseProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (world instanceof Level _lvl && _lvl.isDay()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.ECLIPSE.get()) {
				if (world.isClientSide())
					Minecraft.getInstance().gameRenderer.displayItemActivation(itemstack);
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack.getItem(), 600);
				{
					Entity _ent = entity;
					if (!_ent.level.isClientSide() && _ent.getServer() != null)
						_ent.getServer().getCommands()
								.performPrefixedCommand(_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4), "time set night");
				}
				PowerMod.queueServerWork(400, () -> {
					{
						Entity _ent = entity;
						if (!_ent.level.isClientSide() && _ent.getServer() != null)
							_ent.getServer().getCommands()
									.performPrefixedCommand(_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4), "time set day");
					}
				});
			}
		}
	}
}
