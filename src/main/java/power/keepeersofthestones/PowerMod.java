/*
 *    MCreator note:
 *
 *    If you lock base mod element files, you can edit this file and it won't get overwritten.
 *    If you change your modid or package, you need to apply these changes to this file MANUALLY.
 *
 *    Settings in @Mod annotation WON'T be changed in case of the base mod element
 *    files lock too, so you need to set them manually here in such case.
 *
 *    If you do not lock base mod element files in Workspace settings, this file
 *    will be REGENERATED on each build.
 *
 */
package power.keepeersofthestones;

import power.keepeersofthestones.init.PowerModTabs;
import power.keepeersofthestones.init.PowerModSounds;
import power.keepeersofthestones.init.PowerModParticleTypes;
import power.keepeersofthestones.init.PowerModMobEffects;
import power.keepeersofthestones.init.PowerModMenus;
import power.keepeersofthestones.init.PowerModItems;
import power.keepeersofthestones.init.PowerModFluids;
import power.keepeersofthestones.init.PowerModFluidTypes;
import power.keepeersofthestones.init.PowerModFeatures;
import power.keepeersofthestones.init.PowerModEntities;
import power.keepeersofthestones.init.PowerModEnchantments;
import power.keepeersofthestones.init.PowerModBlocks;
import power.keepeersofthestones.init.PowerModBlockEntities;
import power.keepeersofthestones.init.PowerModBiomes;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.minecraftforge.network.simple.SimpleChannel;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;

import java.util.function.Supplier;
import java.util.function.Function;
import java.util.function.BiConsumer;
import java.util.List;
import java.util.ArrayList;
import java.util.AbstractMap;

@Mod("power")
public class PowerMod {
	public static final Logger LOGGER = LogManager.getLogger(PowerMod.class);
	public static final String MODID = "power";

	public PowerMod() {
		MinecraftForge.EVENT_BUS.register(this);
		PowerModTabs.load();
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		PowerModSounds.REGISTRY.register(bus);
		PowerModBlocks.REGISTRY.register(bus);
		PowerModItems.REGISTRY.register(bus);
		PowerModEntities.REGISTRY.register(bus);
		PowerModBlockEntities.REGISTRY.register(bus);
		PowerModFeatures.REGISTRY.register(bus);
		PowerModFluids.REGISTRY.register(bus);
		PowerModFluidTypes.REGISTRY.register(bus);

		PowerModMobEffects.REGISTRY.register(bus);

		PowerModEnchantments.REGISTRY.register(bus);
		PowerModParticleTypes.REGISTRY.register(bus);
		PowerModMenus.REGISTRY.register(bus);
		PowerModBiomes.REGISTRY.register(bus);
	}

	private static final String PROTOCOL_VERSION = "1";
	public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(new ResourceLocation(MODID, MODID), () -> PROTOCOL_VERSION,
			PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
	private static int messageID = 0;

	public static <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder,
			BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
		PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
		messageID++;
	}

	private static final List<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ArrayList<>();

	public static void queueServerWork(int tick, Runnable action) {
		workQueue.add(new AbstractMap.SimpleEntry(action, tick));
	}

	@SubscribeEvent
	public void tick(TickEvent.ServerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			List<AbstractMap.SimpleEntry<Runnable, Integer>> actions = new ArrayList<>();
			workQueue.forEach(work -> {
				work.setValue(work.getValue() - 1);
				if (work.getValue() == 0)
					actions.add(work);
			});
			actions.forEach(e -> e.getKey().run());
			workQueue.removeAll(actions);
		}
	}
}
