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

public class GravityBoostUseProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity, ItemStack itemstack) {
		if (entity == null || sourceentity == null)
			return;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.GRAVITY_BOOST
				.get()) {
			if (world.isClientSide())
				Minecraft.getInstance().gameRenderer.displayItemActivation(itemstack);
			if (sourceentity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 400);
			if (!(sourceentity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new PowerModVariables.PlayerVariables())).recharge_spell_gravity_boost) {
				{
					Entity _ent = entity;
					if (!_ent.level.isClientSide() && _ent.getServer() != null)
						_ent.getServer().getCommands().performPrefixedCommand(
								_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4),
								"attribute @s forge:entity_gravity base set 3");
				}
				class GravityBoostUseWait8 {
					private int ticks = 0;
					private float waitTicks;
					private LevelAccessor world;

					public void start(LevelAccessor world, int waitTicks) {
						this.waitTicks = waitTicks;
						this.world = world;
						MinecraftForge.EVENT_BUS.register(GravityBoostUseWait8.this);
					}

					@SubscribeEvent
					public void tick(TickEvent.ServerTickEvent event) {
						if (event.phase == TickEvent.Phase.END) {
							GravityBoostUseWait8.this.ticks += 1;
							if (GravityBoostUseWait8.this.ticks >= GravityBoostUseWait8.this.waitTicks)
								run();
						}
					}

					private void run() {
						MinecraftForge.EVENT_BUS.unregister(GravityBoostUseWait8.this);
						{
							Entity _ent = entity;
							if (!_ent.level.isClientSide() && _ent.getServer() != null)
								_ent.getServer().getCommands().performPrefixedCommand(
										_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4),
										"attribute @s forge:entity_gravity base set 0.08");
						}
					}
				}
				new GravityBoostUseWait8().start(world, 200);
			}
			{
				boolean _setval = true;
				sourceentity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.recharge_spell_gravity_boost = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			class GravityBoostUseWait9 {
				private int ticks = 0;
				private float waitTicks;
				private LevelAccessor world;

				public void start(LevelAccessor world, int waitTicks) {
					this.waitTicks = waitTicks;
					this.world = world;
					MinecraftForge.EVENT_BUS.register(GravityBoostUseWait9.this);
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						GravityBoostUseWait9.this.ticks += 1;
						if (GravityBoostUseWait9.this.ticks >= GravityBoostUseWait9.this.waitTicks)
							run();
					}
				}

				private void run() {
					MinecraftForge.EVENT_BUS.unregister(GravityBoostUseWait9.this);
					{
						boolean _setval = false;
						sourceentity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.recharge_spell_gravity_boost = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
				}
			}
			new GravityBoostUseWait9().start(world, 400);
		}
	}
}
