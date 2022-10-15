package power.keepeersofthestones.procedures;

import power.keepeersofthestones.world.inventory.ChoiseSecretStoneGUIMenu;
import power.keepeersofthestones.network.PowerModVariables;

import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import io.netty.buffer.Unpooled;

public class OpenSecretStonesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (PowerModVariables.MapVariables.get(world).fire_stone) {
			if (PowerModVariables.MapVariables.get(world).air_stone) {
				if (PowerModVariables.MapVariables.get(world).water_stone) {
					if (PowerModVariables.MapVariables.get(world).earth_stone) {
						if (PowerModVariables.MapVariables.get(world).energy_stone) {
							if (PowerModVariables.MapVariables.get(world).ice_stone) {
								if (PowerModVariables.MapVariables.get(world).lightning_stone) {
									if (PowerModVariables.MapVariables.get(world).sound_stone) {
										if (PowerModVariables.MapVariables.get(world).crystal_stone) {
											if (PowerModVariables.MapVariables.get(world).lava_stone) {
												if (PowerModVariables.MapVariables.get(world).rain_stone) {
													if (PowerModVariables.MapVariables.get(world).tornado_stone) {
														if (PowerModVariables.MapVariables.get(world).ocean_stone) {
															if (PowerModVariables.MapVariables.get(world).greenery_stone) {
																if (PowerModVariables.MapVariables.get(world).animals_stone) {
																	if (PowerModVariables.MapVariables.get(world).metal_stone) {
																		if (PowerModVariables.MapVariables.get(world).light_stone) {
																			if (PowerModVariables.MapVariables.get(world).shadow_stone) {
																				if (PowerModVariables.MapVariables.get(world).vacuum_stone) {
																					if (PowerModVariables.MapVariables.get(world).sun_stone) {
																						if (PowerModVariables.MapVariables.get(world).moon_stone) {
																							if (PowerModVariables.MapVariables
																									.get(world).creation_stone) {
																								if (PowerModVariables.MapVariables
																										.get(world).destruction_stone) {
																									if (PowerModVariables.MapVariables
																											.get(world).blood_stone) {
																										if (PowerModVariables.MapVariables
																												.get(world).technology_stone) {
																											if (PowerModVariables.MapVariables
																													.get(world).time_stone) {
																												if (PowerModVariables.MapVariables
																														.get(world).teleportation_stone) {
																													if (PowerModVariables.MapVariables
																															.get(world).explosion_stone) {
																														if (PowerModVariables.MapVariables
																																.get(world).amber_stone) {
																															if (PowerModVariables.MapVariables
																																	.get(world).space_stone) {
																																if (PowerModVariables.MapVariables
																																		.get(world).magnet_stone) {
																																	if (PowerModVariables.MapVariables
																																			.get(world).mist_stone) {
																																		if (PowerModVariables.MapVariables
																																				.get(world).sand_stone) {
																																			if (PowerModVariables.MapVariables
																																					.get(world).speed_stone) {
																																				if (PowerModVariables.MapVariables
																																						.get(world).poison_stone) {
																																					if (PowerModVariables.MapVariables
																																							.get(world).mushrooms_stone) {
																																						if (PowerModVariables.MapVariables
																																								.get(world).mercury_stone) {
																																							if (PowerModVariables.MapVariables
																																									.get(world).music_stone) {
																																								if (PowerModVariables.MapVariables
																																										.get(world).plague_stone) {
																																									if (PowerModVariables.MapVariables
																																											.get(world).gravity_stone) {
																																										if (PowerModVariables.MapVariables
																																												.get(world).blue_flame_stone) {
																																											if (PowerModVariables.MapVariables
																																													.get(world).spirit_stone) {
																																												if (PowerModVariables.MapVariables
																																														.get(world).aether_stone) {
																																													if (PowerModVariables.MapVariables
																																															.get(world).smoke_stone) {
																																														if (PowerModVariables.MapVariables
																																																.get(world).form_stone) {
																																															if (PowerModVariables.MapVariables
																																																	.get(world).mind_stone) {
																																																if (PowerModVariables.MapVariables
																																																		.get(world).golden_dust_stone) {
																																																	{
																																																		if (entity instanceof ServerPlayer _ent) {
																																																			BlockPos _bpos = new BlockPos(
																																																					x,
																																																					y,
																																																					z);
																																																			NetworkHooks
																																																					.openScreen(
																																																							(ServerPlayer) _ent,
																																																							new MenuProvider() {
																																																								@Override
																																																								public Component getDisplayName() {
																																																									return Component
																																																											.literal(
																																																													"ChoiseSecretStoneGUI");
																																																								}

																																																								@Override
																																																								public AbstractContainerMenu createMenu(
																																																										int id,
																																																										Inventory inventory,
																																																										Player player) {
																																																									return new ChoiseSecretStoneGUIMenu(
																																																											id,
																																																											inventory,
																																																											new FriendlyByteBuf(
																																																													Unpooled.buffer())
																																																													.writeBlockPos(
																																																															_bpos));
																																																								}
																																																							},
																																																							_bpos);
																																																		}
																																																	}
																																																}
																																															}
																																														}
																																													}
																																												}
																																											}
																																										}
																																									}
																																								}
																																							}
																																						}
																																					}
																																				}
																																			}
																																		}
																																	}
																																}
																															}
																														}
																													}
																												}
																											}
																										}
																									}
																								}
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
