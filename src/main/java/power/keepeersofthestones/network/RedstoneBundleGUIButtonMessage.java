
package power.keepeersofthestones.network;

import power.keepeersofthestones.world.inventory.RedstoneBundleGUIMenu;
import power.keepeersofthestones.procedures.GetStickyPistonProcedure;
import power.keepeersofthestones.procedures.GetRepeaterProcedure;
import power.keepeersofthestones.procedures.GetRedstoneTorchProcedure;
import power.keepeersofthestones.procedures.GetRedstoneLampProcedure;
import power.keepeersofthestones.procedures.GetRedstoneBlockProcedure;
import power.keepeersofthestones.procedures.GetPistonProcedure;
import power.keepeersofthestones.procedures.GetObserverProcedure;
import power.keepeersofthestones.procedures.GetLeverProcedure;
import power.keepeersofthestones.procedures.GetHopperProcedure;
import power.keepeersofthestones.procedures.GetDropperProcedure;
import power.keepeersofthestones.procedures.GetDispenserProcedure;
import power.keepeersofthestones.procedures.GetComparatorProcedure;
import power.keepeersofthestones.PowerMod;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RedstoneBundleGUIButtonMessage {
	private final int buttonID, x, y, z;

	public RedstoneBundleGUIButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public RedstoneBundleGUIButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(RedstoneBundleGUIButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(RedstoneBundleGUIButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level;
		HashMap guistate = RedstoneBundleGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			GetPistonProcedure.execute(entity);
		}
		if (buttonID == 1) {

			GetStickyPistonProcedure.execute(entity);
		}
		if (buttonID == 2) {

			GetObserverProcedure.execute(entity);
		}
		if (buttonID == 3) {

			GetRedstoneBlockProcedure.execute(entity);
		}
		if (buttonID == 4) {

			GetComparatorProcedure.execute(entity);
		}
		if (buttonID == 5) {

			GetRedstoneLampProcedure.execute(entity);
		}
		if (buttonID == 6) {

			GetRepeaterProcedure.execute(entity);
		}
		if (buttonID == 7) {

			GetLeverProcedure.execute(entity);
		}
		if (buttonID == 8) {

			GetRedstoneTorchProcedure.execute(entity);
		}
		if (buttonID == 9) {

			GetHopperProcedure.execute(entity);
		}
		if (buttonID == 10) {

			GetDropperProcedure.execute(entity);
		}
		if (buttonID == 11) {

			GetDispenserProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PowerMod.addNetworkMessage(RedstoneBundleGUIButtonMessage.class, RedstoneBundleGUIButtonMessage::buffer, RedstoneBundleGUIButtonMessage::new,
				RedstoneBundleGUIButtonMessage::handler);
	}
}
