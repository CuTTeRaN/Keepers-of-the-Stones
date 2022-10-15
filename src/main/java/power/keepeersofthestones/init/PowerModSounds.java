
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package power.keepeersofthestones.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PowerModSounds {
	public static Map<ResourceLocation, SoundEvent> REGISTRY = new HashMap<>();
	static {
		REGISTRY.put(new ResourceLocation("power", "powerful_stone"), new SoundEvent(new ResourceLocation("power", "powerful_stone")));
		REGISTRY.put(new ResourceLocation("power", "tyrannosaurus_rex.hurt"),
				new SoundEvent(new ResourceLocation("power", "tyrannosaurus_rex.hurt")));
		REGISTRY.put(new ResourceLocation("power", "tyrannosaurus_rex.dead"),
				new SoundEvent(new ResourceLocation("power", "tyrannosaurus_rex.dead")));
		REGISTRY.put(new ResourceLocation("power", "raptor.dead"), new SoundEvent(new ResourceLocation("power", "raptor.dead")));
		REGISTRY.put(new ResourceLocation("power", "raptor.hurt"), new SoundEvent(new ResourceLocation("power", "raptor.hurt")));
		REGISTRY.put(new ResourceLocation("power", "time_power"), new SoundEvent(new ResourceLocation("power", "time_power")));
		REGISTRY.put(new ResourceLocation("power", "music1"), new SoundEvent(new ResourceLocation("power", "music1")));
		REGISTRY.put(new ResourceLocation("power", "music2"), new SoundEvent(new ResourceLocation("power", "music2")));
		REGISTRY.put(new ResourceLocation("power", "music3"), new SoundEvent(new ResourceLocation("power", "music3")));
		REGISTRY.put(new ResourceLocation("power", "music4"), new SoundEvent(new ResourceLocation("power", "music4")));
		REGISTRY.put(new ResourceLocation("power", "music5"), new SoundEvent(new ResourceLocation("power", "music5")));
		REGISTRY.put(new ResourceLocation("power", "music6"), new SoundEvent(new ResourceLocation("power", "music6")));
		REGISTRY.put(new ResourceLocation("power", "music7"), new SoundEvent(new ResourceLocation("power", "music7")));
		REGISTRY.put(new ResourceLocation("power", "music8"), new SoundEvent(new ResourceLocation("power", "music8")));
		REGISTRY.put(new ResourceLocation("power", "music9"), new SoundEvent(new ResourceLocation("power", "music9")));
		REGISTRY.put(new ResourceLocation("power", "music10"), new SoundEvent(new ResourceLocation("power", "music10")));
		REGISTRY.put(new ResourceLocation("power", "stone_activation"), new SoundEvent(new ResourceLocation("power", "stone_activation")));
		REGISTRY.put(new ResourceLocation("power", "rocket.fly"), new SoundEvent(new ResourceLocation("power", "rocket.fly")));
		REGISTRY.put(new ResourceLocation("power", "stone_deactivation"), new SoundEvent(new ResourceLocation("power", "stone_deactivation")));
	}

	@SubscribeEvent
	public static void registerSounds(RegistryEvent.Register<SoundEvent> event) {
		for (Map.Entry<ResourceLocation, SoundEvent> sound : REGISTRY.entrySet())
			event.getRegistry().register(sound.getValue().setRegistryName(sound.getKey()));
	}
}
