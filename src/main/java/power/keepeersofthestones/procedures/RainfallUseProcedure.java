package power.keepeersofthestones.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.Minecraft;

public class RainfallUseProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (world.isClientSide())
			Minecraft.getInstance().gameRenderer.displayItemActivation(itemstack);
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack.getItem(), 400);
		{
			Entity _ent = entity;
			if (!_ent.level.isClientSide() && _ent.getServer() != null)
				_ent.getServer().getCommands().performPrefixedCommand(_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4),
						"weather rain");
		}
		class WaitHandlerRainfallUse6 {
			private int ticks = 0;
			private float waitTicks;
			private LevelAccessor world;

			public void start(LevelAccessor world, int waitTicks) {
				this.waitTicks = waitTicks;
				this.world = world;
				MinecraftForge.EVENT_BUS.register(WaitHandlerRainfallUse6.this);
			}

			@SubscribeEvent
			public void tick(TickEvent.ServerTickEvent event) {
				if (event.phase == TickEvent.Phase.END) {
					WaitHandlerRainfallUse6.this.ticks += 1;
					if (WaitHandlerRainfallUse6.this.ticks >= WaitHandlerRainfallUse6.this.waitTicks)
						run();
				}
			}

			private void run() {
				MinecraftForge.EVENT_BUS.unregister(WaitHandlerRainfallUse6.this);
				{
					Entity _ent = entity;
					if (!_ent.level.isClientSide() && _ent.getServer() != null)
						_ent.getServer().getCommands()
								.performPrefixedCommand(_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4), "weather clear");
				}
			}
		}
		new WaitHandlerRainfallUse6().start(world, 600);
	}
}
