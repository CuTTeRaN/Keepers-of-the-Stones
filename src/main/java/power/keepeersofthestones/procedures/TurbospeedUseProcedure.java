package power.keepeersofthestones.procedures;

import power.keepeersofthestones.network.PowerModVariables;
import power.keepeersofthestones.init.PowerModItems;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.Minecraft;

public class TurbospeedUseProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.TURBO_SPEED.get()) {
			if (world.isClientSide())
				Minecraft.getInstance().gameRenderer.displayItemActivation(itemstack);
			{
				boolean _setval = true;
				entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.turbospeed = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 400);
			class WaitHandlerTurbospeedUse6 {
				private int ticks = 0;
				private float waitTicks;
				private LevelAccessor world;

				public void start(LevelAccessor world, int waitTicks) {
					this.waitTicks = waitTicks;
					this.world = world;
					MinecraftForge.EVENT_BUS.register(WaitHandlerTurbospeedUse6.this);
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						WaitHandlerTurbospeedUse6.this.ticks += 1;
						if (WaitHandlerTurbospeedUse6.this.ticks >= WaitHandlerTurbospeedUse6.this.waitTicks)
							run();
					}
				}

				private void run() {
					MinecraftForge.EVENT_BUS.unregister(WaitHandlerTurbospeedUse6.this);
					{
						boolean _setval = false;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.turbospeed = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
			new WaitHandlerTurbospeedUse6().start(world, 400);
		}
	}
}
