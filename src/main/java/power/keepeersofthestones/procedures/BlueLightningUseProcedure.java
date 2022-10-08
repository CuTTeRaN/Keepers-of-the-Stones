package power.keepeersofthestones.procedures;

import power.keepeersofthestones.network.PowerModVariables;
import power.keepeersofthestones.init.PowerModItems;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

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
					if (!_ent.level.isClientSide() && _ent.getServer() != null)
						_ent.getServer().getCommands().performPrefixedCommand(
								_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4), "summon minecraft:lightning_bolt ~ ~ ~");
				}
				class WaitHandler16 {
					private int ticks = 0;
					private float waitTicks;
					private LevelAccessor world;

					public void start(LevelAccessor world, int waitTicks) {
						this.waitTicks = waitTicks;
						this.world = world;
						MinecraftForge.EVENT_BUS.register(WaitHandler16.this);
					}

					@SubscribeEvent
					public void tick(TickEvent.ServerTickEvent event) {
						if (event.phase == TickEvent.Phase.END) {
							WaitHandler16.this.ticks += 1;
							if (WaitHandler16.this.ticks >= WaitHandler16.this.waitTicks)
								run();
						}
					}

					private void run() {
						MinecraftForge.EVENT_BUS.unregister(WaitHandler16.this);
						if (world instanceof ServerLevel _level) {
							LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
							entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
							entityToSpawn.setVisualOnly(true);
							_level.addFreshEntity(entityToSpawn);
						}
						class WaitHandler15 {
							private int ticks = 0;
							private float waitTicks;
							private LevelAccessor world;

							public void start(LevelAccessor world, int waitTicks) {
								this.waitTicks = waitTicks;
								this.world = world;
								MinecraftForge.EVENT_BUS.register(WaitHandler15.this);
							}

							@SubscribeEvent
							public void tick(TickEvent.ServerTickEvent event) {
								if (event.phase == TickEvent.Phase.END) {
									WaitHandler15.this.ticks += 1;
									if (WaitHandler15.this.ticks >= WaitHandler15.this.waitTicks)
										run();
								}
							}

							private void run() {
								MinecraftForge.EVENT_BUS.unregister(WaitHandler15.this);
								if (world instanceof ServerLevel _level) {
									LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
									entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
									entityToSpawn.setVisualOnly(true);
									_level.addFreshEntity(entityToSpawn);
								}
								class WaitHandler14 {
									private int ticks = 0;
									private float waitTicks;
									private LevelAccessor world;

									public void start(LevelAccessor world, int waitTicks) {
										this.waitTicks = waitTicks;
										this.world = world;
										MinecraftForge.EVENT_BUS.register(WaitHandler14.this);
									}

									@SubscribeEvent
									public void tick(TickEvent.ServerTickEvent event) {
										if (event.phase == TickEvent.Phase.END) {
											WaitHandler14.this.ticks += 1;
											if (WaitHandler14.this.ticks >= WaitHandler14.this.waitTicks)
												run();
										}
									}

									private void run() {
										MinecraftForge.EVENT_BUS.unregister(WaitHandler14.this);
										if (world instanceof ServerLevel _level) {
											LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
											entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
											entityToSpawn.setVisualOnly(true);
											_level.addFreshEntity(entityToSpawn);
										}
										class WaitHandler13 {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												this.world = world;
												MinecraftForge.EVENT_BUS.register(WaitHandler13.this);
											}

											@SubscribeEvent
											public void tick(TickEvent.ServerTickEvent event) {
												if (event.phase == TickEvent.Phase.END) {
													WaitHandler13.this.ticks += 1;
													if (WaitHandler13.this.ticks >= WaitHandler13.this.waitTicks)
														run();
												}
											}

											private void run() {
												MinecraftForge.EVENT_BUS.unregister(WaitHandler13.this);
												if (world instanceof ServerLevel _level) {
													LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
													entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
													entityToSpawn.setVisualOnly(true);
													_level.addFreshEntity(entityToSpawn);
												}
												class WaitHandler12 {
													private int ticks = 0;
													private float waitTicks;
													private LevelAccessor world;

													public void start(LevelAccessor world, int waitTicks) {
														this.waitTicks = waitTicks;
														this.world = world;
														MinecraftForge.EVENT_BUS.register(WaitHandler12.this);
													}

													@SubscribeEvent
													public void tick(TickEvent.ServerTickEvent event) {
														if (event.phase == TickEvent.Phase.END) {
															WaitHandler12.this.ticks += 1;
															if (WaitHandler12.this.ticks >= WaitHandler12.this.waitTicks)
																run();
														}
													}

													private void run() {
														MinecraftForge.EVENT_BUS.unregister(WaitHandler12.this);
														if (world instanceof ServerLevel _level) {
															LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
															entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
															entityToSpawn.setVisualOnly(true);
															_level.addFreshEntity(entityToSpawn);
														}
													}
												}
												new WaitHandler12().start(world, 40);
											}
										}
										new WaitHandler13().start(world, 40);
									}
								}
								new WaitHandler14().start(world, 40);
							}
						}
						new WaitHandler15().start(world, 40);
					}
				}
				new WaitHandler16().start(world, 40);
			}
			{
				boolean _setval = true;
				sourceentity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.recharge_spell_blue_flame = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			class WaitHandler17 {
				private int ticks = 0;
				private float waitTicks;
				private LevelAccessor world;

				public void start(LevelAccessor world, int waitTicks) {
					this.waitTicks = waitTicks;
					this.world = world;
					MinecraftForge.EVENT_BUS.register(WaitHandler17.this);
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						WaitHandler17.this.ticks += 1;
						if (WaitHandler17.this.ticks >= WaitHandler17.this.waitTicks)
							run();
					}
				}

				private void run() {
					MinecraftForge.EVENT_BUS.unregister(WaitHandler17.this);
					{
						boolean _setval = false;
						sourceentity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.recharge_spell_blue_flame = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
				}
			}
			new WaitHandler17().start(world, 400);
		}
	}
}
