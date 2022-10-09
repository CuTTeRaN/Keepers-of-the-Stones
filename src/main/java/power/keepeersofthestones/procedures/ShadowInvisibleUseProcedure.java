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
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.client.Minecraft;

public class ShadowInvisibleUseProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.SHADOW_INVISIBLE
				.get()) {
			if (!(entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).amber) {
				if (!(entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new PowerModVariables.PlayerVariables())).golden_dust) {
					if (world.isClientSide())
						Minecraft.getInstance().gameRenderer.displayItemActivation(itemstack);
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown(itemstack.getItem(), 400);
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 200, 254, (false), (false)));
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(PowerModItems.SHADOW_HELMET.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1,
								_player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(PowerModItems.SHADOW_CHESTPLATE.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1,
								_player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(PowerModItems.SHADOW_LEGGINGS.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1,
								_player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(PowerModItems.SHADOW_BOOTS.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1,
								_player.inventoryMenu.getCraftSlots());
					}
					class WaitHandlerShadowInvisibleUse15 {
						private int ticks = 0;
						private float waitTicks;
						private LevelAccessor world;

						public void start(LevelAccessor world, int waitTicks) {
							this.waitTicks = waitTicks;
							this.world = world;
							MinecraftForge.EVENT_BUS.register(WaitHandlerShadowInvisibleUse15.this);
						}

						@SubscribeEvent
						public void tick(TickEvent.ServerTickEvent event) {
							if (event.phase == TickEvent.Phase.END) {
								WaitHandlerShadowInvisibleUse15.this.ticks += 1;
								if (WaitHandlerShadowInvisibleUse15.this.ticks >= WaitHandlerShadowInvisibleUse15.this.waitTicks)
									run();
							}
						}

						private void run() {
							MinecraftForge.EVENT_BUS.unregister(WaitHandlerShadowInvisibleUse15.this);
							if ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new PowerModVariables.PlayerVariables())).shadow) {
								{
									Entity _ent = entity;
									if (!_ent.level.isClientSide() && _ent.getServer() != null)
										_ent.getServer().getCommands().performPrefixedCommand(
												_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4),
												"item replace entity @s armor.head with power:shadow_helmet{Enchantments:[{id:binding_curse,lvl:1},{id:vanishing_curse,lvl:1}]}");
								}
								{
									Entity _ent = entity;
									if (!_ent.level.isClientSide() && _ent.getServer() != null)
										_ent.getServer().getCommands().performPrefixedCommand(
												_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4),
												"item replace entity @s armor.chest with power:shadow_chestplate{Enchantments:[{id:binding_curse,lvl:1},{id:vanishing_curse,lvl:1}]}");
								}
								{
									Entity _ent = entity;
									if (!_ent.level.isClientSide() && _ent.getServer() != null)
										_ent.getServer().getCommands().performPrefixedCommand(
												_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4),
												"item replace entity @s armor.legs with power:shadow_leggings{Enchantments:[{id:binding_curse,lvl:1},{id:vanishing_curse,lvl:1}]}");
								}
								{
									Entity _ent = entity;
									if (!_ent.level.isClientSide() && _ent.getServer() != null)
										_ent.getServer().getCommands().performPrefixedCommand(
												_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4),
												"item replace entity @s armor.feet with power:shadow_boots{Enchantments:[{id:binding_curse,lvl:1},{id:vanishing_curse,lvl:1}]}");
								}
							}
						}
					}
					new WaitHandlerShadowInvisibleUse15().start(world, 200);
				} else if ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new PowerModVariables.PlayerVariables())).golden_dust) {
					if (world.isClientSide())
						Minecraft.getInstance().gameRenderer.displayItemActivation(itemstack);
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown(itemstack.getItem(), 400);
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 200, 254, (false), (false)));
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(PowerModItems.GOLDEN_DUST_HELMET.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1,
								_player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(PowerModItems.GOLDEN_DUST_CHESTPLATE.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1,
								_player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(PowerModItems.GOLDEN_DUST_LEGGINGS.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1,
								_player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(PowerModItems.GOLDEN_DUST_BOOTS.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1,
								_player.inventoryMenu.getCraftSlots());
					}
					class WaitHandlerShadowInvisibleUse29 {
						private int ticks = 0;
						private float waitTicks;
						private LevelAccessor world;

						public void start(LevelAccessor world, int waitTicks) {
							this.waitTicks = waitTicks;
							this.world = world;
							MinecraftForge.EVENT_BUS.register(WaitHandlerShadowInvisibleUse29.this);
						}

						@SubscribeEvent
						public void tick(TickEvent.ServerTickEvent event) {
							if (event.phase == TickEvent.Phase.END) {
								WaitHandlerShadowInvisibleUse29.this.ticks += 1;
								if (WaitHandlerShadowInvisibleUse29.this.ticks >= WaitHandlerShadowInvisibleUse29.this.waitTicks)
									run();
							}
						}

						private void run() {
							MinecraftForge.EVENT_BUS.unregister(WaitHandlerShadowInvisibleUse29.this);
							if ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new PowerModVariables.PlayerVariables())).shadow) {
								{
									Entity _ent = entity;
									if (!_ent.level.isClientSide() && _ent.getServer() != null)
										_ent.getServer().getCommands().performPrefixedCommand(
												_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4),
												"item replace entity @s armor.head with power:golden_dust_helmet{Enchantments:[{id:binding_curse,lvl:1},{id:vanishing_curse,lvl:1}]}");
								}
								{
									Entity _ent = entity;
									if (!_ent.level.isClientSide() && _ent.getServer() != null)
										_ent.getServer().getCommands().performPrefixedCommand(
												_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4),
												"item replace entity @s armor.chest with power:golden_dust_chestplate{Enchantments:[{id:binding_curse,lvl:1},{id:vanishing_curse,lvl:1}]}");
								}
								{
									Entity _ent = entity;
									if (!_ent.level.isClientSide() && _ent.getServer() != null)
										_ent.getServer().getCommands().performPrefixedCommand(
												_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4),
												"item replace entity @s armor.legs with power:golden_dust_leggings{Enchantments:[{id:binding_curse,lvl:1},{id:vanishing_curse,lvl:1}]}");
								}
								{
									Entity _ent = entity;
									if (!_ent.level.isClientSide() && _ent.getServer() != null)
										_ent.getServer().getCommands().performPrefixedCommand(
												_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4),
												"item replace entity @s armor.feet with power:golden_dust_boots{Enchantments:[{id:binding_curse,lvl:1},{id:vanishing_curse,lvl:1}]}");
								}
							}
						}
					}
					new WaitHandlerShadowInvisibleUse29().start(world, 200);
				}
			} else if ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new PowerModVariables.PlayerVariables())).amber) {
				if (world.isClientSide())
					Minecraft.getInstance().gameRenderer.displayItemActivation(itemstack);
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack.getItem(), 400);
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 200, 254, (false), (false)));
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(PowerModItems.AMBER_HELMET.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1,
							_player.inventoryMenu.getCraftSlots());
				}
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(PowerModItems.AMBER_CHESTPLATE.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1,
							_player.inventoryMenu.getCraftSlots());
				}
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(PowerModItems.AMBER_LEGGINGS.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1,
							_player.inventoryMenu.getCraftSlots());
				}
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(PowerModItems.AMBER_BOOTS.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1,
							_player.inventoryMenu.getCraftSlots());
				}
				class WaitHandlerShadowInvisibleUse43 {
					private int ticks = 0;
					private float waitTicks;
					private LevelAccessor world;

					public void start(LevelAccessor world, int waitTicks) {
						this.waitTicks = waitTicks;
						this.world = world;
						MinecraftForge.EVENT_BUS.register(WaitHandlerShadowInvisibleUse43.this);
					}

					@SubscribeEvent
					public void tick(TickEvent.ServerTickEvent event) {
						if (event.phase == TickEvent.Phase.END) {
							WaitHandlerShadowInvisibleUse43.this.ticks += 1;
							if (WaitHandlerShadowInvisibleUse43.this.ticks >= WaitHandlerShadowInvisibleUse43.this.waitTicks)
								run();
						}
					}

					private void run() {
						MinecraftForge.EVENT_BUS.unregister(WaitHandlerShadowInvisibleUse43.this);
						if ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new PowerModVariables.PlayerVariables())).shadow) {
							{
								Entity _ent = entity;
								if (!_ent.level.isClientSide() && _ent.getServer() != null)
									_ent.getServer().getCommands().performPrefixedCommand(
											_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4),
											"item replace entity @s armor.head with power:amber_helmet{Enchantments:[{id:binding_curse,lvl:1},{id:vanishing_curse,lvl:1}]}");
							}
							{
								Entity _ent = entity;
								if (!_ent.level.isClientSide() && _ent.getServer() != null)
									_ent.getServer().getCommands().performPrefixedCommand(
											_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4),
											"item replace entity @s armor.chest with power:amber_chestplate{Enchantments:[{id:binding_curse,lvl:1},{id:vanishing_curse,lvl:1}]}");
							}
							{
								Entity _ent = entity;
								if (!_ent.level.isClientSide() && _ent.getServer() != null)
									_ent.getServer().getCommands().performPrefixedCommand(
											_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4),
											"item replace entity @s armor.legs with power:amber_leggings{Enchantments:[{id:binding_curse,lvl:1},{id:vanishing_curse,lvl:1}]}");
							}
							{
								Entity _ent = entity;
								if (!_ent.level.isClientSide() && _ent.getServer() != null)
									_ent.getServer().getCommands().performPrefixedCommand(
											_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4),
											"item replace entity @s armor.feet with power:amber_boots{Enchantments:[{id:binding_curse,lvl:1},{id:vanishing_curse,lvl:1}]}");
							}
						}
					}
				}
				new WaitHandlerShadowInvisibleUse43().start(world, 200);
			}
		}
	}
}
