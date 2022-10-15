package power.keepeersofthestones.procedures;

import power.keepeersofthestones.init.PowerModItems;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Entity;

public class TameTornadoProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity instanceof Player _playerHasItem
				? _playerHasItem.getInventory().contains(new ItemStack(PowerModItems.TORNADO_BATTLE_AXE.get()))
				: false) {
			if (entity instanceof TamableAnimal _toTame && sourceentity instanceof Player _owner)
				_toTame.tame(_owner);
		}
		class TameTornadoWait3 {
			private int ticks = 0;
			private float waitTicks;
			private LevelAccessor world;

			public void start(LevelAccessor world, int waitTicks) {
				this.waitTicks = waitTicks;
				this.world = world;
				MinecraftForge.EVENT_BUS.register(TameTornadoWait3.this);
			}

			@SubscribeEvent
			public void tick(TickEvent.ServerTickEvent event) {
				if (event.phase == TickEvent.Phase.END) {
					TameTornadoWait3.this.ticks += 1;
					if (TameTornadoWait3.this.ticks >= TameTornadoWait3.this.waitTicks)
						run();
				}
			}

			private void run() {
				MinecraftForge.EVENT_BUS.unregister(TameTornadoWait3.this);
				if (!entity.level.isClientSide())
					entity.discard();
			}
		}
		new TameTornadoWait3().start(world, 400);
	}
}
