package power.keepeersofthestones.procedures;

import power.keepeersofthestones.network.PowerModVariables;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.CommandDispatcher;

public class PolarisEffectStartProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			boolean _setval = true;
			entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.polaris = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			boolean _setval = true;
			entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.active_pw = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("power:stone_activation")),
						SoundSource.PLAYERS, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("power:stone_activation")),
						SoundSource.PLAYERS, 1, 1, false);
			}
		}
		{
			Entity _ent = entity;
			if (!_ent.level.isClientSide() && _ent.getServer() != null)
				_ent.getServer().getCommands().performCommand(
						new CommandDispatcher<CommandSourceStack>().parse("item replace entity @s weapon.mainhand with air",
								_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4)),
						"item replace entity @s weapon.mainhand with air");
		}
		{
			Entity _ent = entity;
			if (!_ent.level.isClientSide() && _ent.getServer() != null)
				_ent.getServer().getCommands().performCommand(new CommandDispatcher<CommandSourceStack>().parse("team add polaris",
						_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4)), "team add polaris");
		}
		{
			Entity _ent = entity;
			if (!_ent.level.isClientSide() && _ent.getServer() != null)
				_ent.getServer().getCommands().performCommand(new CommandDispatcher<CommandSourceStack>().parse("team modify polaris color aqua",
						_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4)), "team modify polaris color aqua");
		}
		{
			Entity _ent = entity;
			if (!_ent.level.isClientSide() && _ent.getServer() != null)
				_ent.getServer().getCommands().performCommand(new CommandDispatcher<CommandSourceStack>().parse("team join polaris @s",
						_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4)), "team join polaris @s");
		}
		if (entity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 30, 0, (false), (false)));
		{
			Entity _ent = entity;
			if (!_ent.level.isClientSide() && _ent.getServer() != null)
				_ent.getServer().getCommands().performCommand(
						new CommandDispatcher<CommandSourceStack>().parse(
								"give @s power:polaris_shield{Enchantments:[{id:binding_curse,lvl:1},{id:vanishing_curse,lvl:1}]}",
								_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4)),
						"give @s power:polaris_shield{Enchantments:[{id:binding_curse,lvl:1},{id:vanishing_curse,lvl:1}]}");
		}
		{
			Entity _ent = entity;
			if (!_ent.level.isClientSide() && _ent.getServer() != null)
				_ent.getServer().getCommands().performCommand(
						new CommandDispatcher<CommandSourceStack>().parse(
								"give @s power:polaris_sword{Enchantments:[{id:binding_curse,lvl:1},{id:vanishing_curse,lvl:1}]}",
								_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4)),
						"give @s power:polaris_sword{Enchantments:[{id:binding_curse,lvl:1},{id:vanishing_curse,lvl:1}]}");
		}
	}
}
