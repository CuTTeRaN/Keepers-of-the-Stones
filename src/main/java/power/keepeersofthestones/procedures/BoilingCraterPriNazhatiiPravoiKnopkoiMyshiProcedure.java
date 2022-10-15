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

public class BoilingCraterPriNazhatiiPravoiKnopkoiMyshiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.BOILING_CRATER.get()) {
			if (world.isClientSide())
				Minecraft.getInstance().gameRenderer.displayItemActivation(itemstack);
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 400);
			class BoilingCraterPriNazhatiiPravoiKnopkoiMyshiWait12 {
				private int ticks = 0;
				private float waitTicks;
				private LevelAccessor world;

				public void start(LevelAccessor world, int waitTicks) {
					this.waitTicks = waitTicks;
					this.world = world;
					MinecraftForge.EVENT_BUS.register(BoilingCraterPriNazhatiiPravoiKnopkoiMyshiWait12.this);
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						BoilingCraterPriNazhatiiPravoiKnopkoiMyshiWait12.this.ticks += 1;
						if (BoilingCraterPriNazhatiiPravoiKnopkoiMyshiWait12.this.ticks >= BoilingCraterPriNazhatiiPravoiKnopkoiMyshiWait12.this.waitTicks)
							run();
					}
				}

				private void run() {
					MinecraftForge.EVENT_BUS.unregister(BoilingCraterPriNazhatiiPravoiKnopkoiMyshiWait12.this);
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""),
										_level.getServer(), null).withSuppressedOutput(),
								"fill ~-1 ~-3 ~-2 ~2 ~ ~2 minecraft:water[] replace minecraft:stone");
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""),
										_level.getServer(), null).withSuppressedOutput(),
								"fill ~-1 ~-3 ~-2 ~2 ~ ~2 minecraft:water[] replace minecraft:grass_block");
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""),
										_level.getServer(), null).withSuppressedOutput(),
								"fill ~-1 ~-3 ~-2 ~2 ~ ~2 minecraft:water[] replace minecraft:dirt");
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""),
										_level.getServer(), null).withSuppressedOutput(),
								"fill ~-1 ~-3 ~-2 ~2 ~ ~2 minecraft:water[] replace minecraft:sand");
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""),
										_level.getServer(), null).withSuppressedOutput(),
								"fill ~-1 ~-1 ~-2 ~2 ~ ~2 minecraft:water[] replace minecraft:cobblestone");
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands()
								.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "",
										Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"fill ~-2 ~-2 ~-2 ~2 ~-2 ~2 minecraft:magma_block");
				}
			}
			new BoilingCraterPriNazhatiiPravoiKnopkoiMyshiWait12().start(world, 3);
			class BoilingCraterPriNazhatiiPravoiKnopkoiMyshiWait15 {
				private int ticks = 0;
				private float waitTicks;
				private LevelAccessor world;

				public void start(LevelAccessor world, int waitTicks) {
					this.waitTicks = waitTicks;
					this.world = world;
					MinecraftForge.EVENT_BUS.register(BoilingCraterPriNazhatiiPravoiKnopkoiMyshiWait15.this);
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						BoilingCraterPriNazhatiiPravoiKnopkoiMyshiWait15.this.ticks += 1;
						if (BoilingCraterPriNazhatiiPravoiKnopkoiMyshiWait15.this.ticks >= BoilingCraterPriNazhatiiPravoiKnopkoiMyshiWait15.this.waitTicks)
							run();
					}
				}

				private void run() {
					MinecraftForge.EVENT_BUS.unregister(BoilingCraterPriNazhatiiPravoiKnopkoiMyshiWait15.this);
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""),
										_level.getServer(), null).withSuppressedOutput(),
								"fill ~-2 ~-1 ~-2 ~2 ~ ~2 minecraft:air replace minecraft:water[]");
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""),
										_level.getServer(), null).withSuppressedOutput(),
								"fill ~-2 ~-2 ~-2 ~2 ~-2 ~2 minecraft:cobblestone replace minecraft:magma_block");
				}
			}
			new BoilingCraterPriNazhatiiPravoiKnopkoiMyshiWait15().start(world, 400);
		}
	}
}
