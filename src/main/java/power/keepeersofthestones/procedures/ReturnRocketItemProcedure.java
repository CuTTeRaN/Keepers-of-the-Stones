package power.keepeersofthestones.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.CommandDispatcher;

public class ReturnRocketItemProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			Entity _ent = entity;
			if (!_ent.level.isClientSide() && _ent.getServer() != null)
				_ent.getServer().getCommands().performCommand(new CommandDispatcher<CommandSourceStack>().parse("give @p power:rocket_item",
						_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4)), "give @p power:rocket_item");
		}
	}
}
