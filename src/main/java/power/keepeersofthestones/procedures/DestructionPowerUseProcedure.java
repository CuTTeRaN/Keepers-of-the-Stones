package power.keepeersofthestones.procedures;

import power.keepeersofthestones.init.PowerModItems;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.Minecraft;

public class DestructionPowerUseProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.DESTRUCTION_POWER
				.get()) {
			if (world.isClientSide())
				Minecraft.getInstance().gameRenderer.displayItemActivation(itemstack);
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 1200);
			if (entity instanceof Player _player) {
				_player.getAbilities().invulnerable = (true);
				_player.onUpdateAbilities();
			}
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, y, z, 20, Explosion.BlockInteraction.DESTROY);
			class WaitHandlerDestructionPowerUse9 {
				private int ticks = 0;
				private float waitTicks;
				private LevelAccessor world;

				public void start(LevelAccessor world, int waitTicks) {
					this.waitTicks = waitTicks;
					this.world = world;
					MinecraftForge.EVENT_BUS.register(WaitHandlerDestructionPowerUse9.this);
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						WaitHandlerDestructionPowerUse9.this.ticks += 1;
						if (WaitHandlerDestructionPowerUse9.this.ticks >= WaitHandlerDestructionPowerUse9.this.waitTicks)
							run();
					}
				}

				private void run() {
					MinecraftForge.EVENT_BUS.unregister(WaitHandlerDestructionPowerUse9.this);
					if (entity instanceof Player _player) {
						_player.getAbilities().invulnerable = (false);
						_player.onUpdateAbilities();
					}
				}
			}
			new WaitHandlerDestructionPowerUse9().start(world, 20);
		}
	}
}
