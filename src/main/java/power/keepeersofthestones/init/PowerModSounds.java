
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package power.keepeersofthestones.init;

import power.keepeersofthestones.PowerMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

public class PowerModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, PowerMod.MODID);
	public static final RegistryObject<SoundEvent> POWERFUL_STONE = REGISTRY.register("powerful_stone",
			() -> new SoundEvent(new ResourceLocation("power", "powerful_stone")));
	public static final RegistryObject<SoundEvent> TYRANNOSAURUS_REX_HURT = REGISTRY.register("tyrannosaurus_rex.hurt",
			() -> new SoundEvent(new ResourceLocation("power", "tyrannosaurus_rex.hurt")));
	public static final RegistryObject<SoundEvent> TYRANNOSAURUS_REX_DEAD = REGISTRY.register("tyrannosaurus_rex.dead",
			() -> new SoundEvent(new ResourceLocation("power", "tyrannosaurus_rex.dead")));
	public static final RegistryObject<SoundEvent> RAPTOR_DEAD = REGISTRY.register("raptor.dead",
			() -> new SoundEvent(new ResourceLocation("power", "raptor.dead")));
	public static final RegistryObject<SoundEvent> RAPTOR_HURT = REGISTRY.register("raptor.hurt",
			() -> new SoundEvent(new ResourceLocation("power", "raptor.hurt")));
	public static final RegistryObject<SoundEvent> TIME_POWER = REGISTRY.register("time_power",
			() -> new SoundEvent(new ResourceLocation("power", "time_power")));
	public static final RegistryObject<SoundEvent> MUSIC1 = REGISTRY.register("music1",
			() -> new SoundEvent(new ResourceLocation("power", "music1")));
	public static final RegistryObject<SoundEvent> MUSIC2 = REGISTRY.register("music2",
			() -> new SoundEvent(new ResourceLocation("power", "music2")));
	public static final RegistryObject<SoundEvent> MUSIC3 = REGISTRY.register("music3",
			() -> new SoundEvent(new ResourceLocation("power", "music3")));
	public static final RegistryObject<SoundEvent> MUSIC4 = REGISTRY.register("music4",
			() -> new SoundEvent(new ResourceLocation("power", "music4")));
	public static final RegistryObject<SoundEvent> MUSIC5 = REGISTRY.register("music5",
			() -> new SoundEvent(new ResourceLocation("power", "music5")));
	public static final RegistryObject<SoundEvent> MUSIC6 = REGISTRY.register("music6",
			() -> new SoundEvent(new ResourceLocation("power", "music6")));
	public static final RegistryObject<SoundEvent> MUSIC7 = REGISTRY.register("music7",
			() -> new SoundEvent(new ResourceLocation("power", "music7")));
	public static final RegistryObject<SoundEvent> MUSIC8 = REGISTRY.register("music8",
			() -> new SoundEvent(new ResourceLocation("power", "music8")));
	public static final RegistryObject<SoundEvent> MUSIC9 = REGISTRY.register("music9",
			() -> new SoundEvent(new ResourceLocation("power", "music9")));
	public static final RegistryObject<SoundEvent> MUSIC10 = REGISTRY.register("music10",
			() -> new SoundEvent(new ResourceLocation("power", "music10")));
	public static final RegistryObject<SoundEvent> STONE_ACTIVATION = REGISTRY.register("stone_activation",
			() -> new SoundEvent(new ResourceLocation("power", "stone_activation")));
	public static final RegistryObject<SoundEvent> ROCKET_FLY = REGISTRY.register("rocket.fly",
			() -> new SoundEvent(new ResourceLocation("power", "rocket.fly")));
	public static final RegistryObject<SoundEvent> STONE_DEACTIVATION = REGISTRY.register("stone_deactivation",
			() -> new SoundEvent(new ResourceLocation("power", "stone_deactivation")));
}
