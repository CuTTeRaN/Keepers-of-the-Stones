
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package power.keepeersofthestones.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class PowerModKeyMappings {
	public static final KeyMapping DETRANSFORM_KEY = new KeyMapping("key.power.detransform_key", GLFW.GLFW_KEY_U, "key.categories.stones");
	public static final KeyMapping SPECIAL_ABILITY_KEY = new KeyMapping("key.power.special_ability_key", GLFW.GLFW_KEY_R, "key.categories.stones");

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(DETRANSFORM_KEY);
		event.register(SPECIAL_ABILITY_KEY);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				DETRANSFORM_KEY.consumeClick();
				SPECIAL_ABILITY_KEY.consumeClick();
			}
		}
	}
}
