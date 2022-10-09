package power.keepeersofthestones.procedures;

import power.keepeersofthestones.init.PowerModItems;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.client.Minecraft;

public class IronShieldUseProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.IRON_SHIELD.get()) {
			if (world.isClientSide())
				Minecraft.getInstance().gameRenderer.displayItemActivation(itemstack);
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 600);
			class WaitHandlerIronShieldUse7 {
				private int ticks = 0;
				private float waitTicks;
				private LevelAccessor world;

				public void start(LevelAccessor world, int waitTicks) {
					this.waitTicks = waitTicks;
					this.world = world;
					MinecraftForge.EVENT_BUS.register(WaitHandlerIronShieldUse7.this);
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						WaitHandlerIronShieldUse7.this.ticks += 1;
						if (WaitHandlerIronShieldUse7.this.ticks >= WaitHandlerIronShieldUse7.this.waitTicks)
							run();
					}
				}

				private void run() {
					MinecraftForge.EVENT_BUS.unregister(WaitHandlerIronShieldUse7.this);
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands()
								.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "",
										Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"fill ~-2 ~ ~-2 ~2 ~4 ~2 iron_block outline");
				}
			}
			new WaitHandlerIronShieldUse7().start(world, 3);
			class WaitHandlerIronShieldUse9 {
				private int ticks = 0;
				private float waitTicks;
				private LevelAccessor world;

				public void start(LevelAccessor world, int waitTicks) {
					this.waitTicks = waitTicks;
					this.world = world;
					MinecraftForge.EVENT_BUS.register(WaitHandlerIronShieldUse9.this);
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						WaitHandlerIronShieldUse9.this.ticks += 1;
						if (WaitHandlerIronShieldUse9.this.ticks >= WaitHandlerIronShieldUse9.this.waitTicks)
							run();
					}
				}

				private void run() {
					MinecraftForge.EVENT_BUS.unregister(WaitHandlerIronShieldUse9.this);
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands()
								.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "",
										Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"fill ~-2 ~ ~-2 ~2 ~4 ~2 air outline");
				}
			}
			new WaitHandlerIronShieldUse9().start(world, 600);
		}
	}
}
