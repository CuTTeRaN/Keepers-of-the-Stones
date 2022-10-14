
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package power.keepeersofthestones.init;

import power.keepeersofthestones.client.gui.SpawnAnimalsGUIScreen;
import power.keepeersofthestones.client.gui.SpaceAtlasGUIScreen;
import power.keepeersofthestones.client.gui.SoundImitateChoiceScreen;
import power.keepeersofthestones.client.gui.RocketPathGUIScreen;
import power.keepeersofthestones.client.gui.RedstoneBundleGUIScreen;
import power.keepeersofthestones.client.gui.PointGUIScreen;
import power.keepeersofthestones.client.gui.MusicPlayerGUIScreen;
import power.keepeersofthestones.client.gui.LevelsAndSkillsPageScreen;
import power.keepeersofthestones.client.gui.EBWaterScreen;
import power.keepeersofthestones.client.gui.EBVacuumScreen;
import power.keepeersofthestones.client.gui.EBTornadoScreen;
import power.keepeersofthestones.client.gui.EBTimeScreen;
import power.keepeersofthestones.client.gui.EBTeleportationScreen;
import power.keepeersofthestones.client.gui.EBTechnologyScreen;
import power.keepeersofthestones.client.gui.EBSunScreen;
import power.keepeersofthestones.client.gui.EBSpiritScreen;
import power.keepeersofthestones.client.gui.EBSpeedScreen;
import power.keepeersofthestones.client.gui.EBSpaceScreen;
import power.keepeersofthestones.client.gui.EBSoundScreen;
import power.keepeersofthestones.client.gui.EBSmokeScreen;
import power.keepeersofthestones.client.gui.EBShadowScreen;
import power.keepeersofthestones.client.gui.EBSandScreen;
import power.keepeersofthestones.client.gui.EBRainScreen;
import power.keepeersofthestones.client.gui.EBPoisonScreen;
import power.keepeersofthestones.client.gui.EBPlagueScreen;
import power.keepeersofthestones.client.gui.EBOceanScreen;
import power.keepeersofthestones.client.gui.EBMusicScreen;
import power.keepeersofthestones.client.gui.EBMushroomsScreen;
import power.keepeersofthestones.client.gui.EBMoonScreen;
import power.keepeersofthestones.client.gui.EBMistScreen;
import power.keepeersofthestones.client.gui.EBMindScreen;
import power.keepeersofthestones.client.gui.EBMetalScreen;
import power.keepeersofthestones.client.gui.EBMercuryScreen;
import power.keepeersofthestones.client.gui.EBMagnetScreen;
import power.keepeersofthestones.client.gui.EBLightningScreen;
import power.keepeersofthestones.client.gui.EBLightScreen;
import power.keepeersofthestones.client.gui.EBLavaScreen;
import power.keepeersofthestones.client.gui.EBIceScreen;
import power.keepeersofthestones.client.gui.EBGreeneryScreen;
import power.keepeersofthestones.client.gui.EBGravityScreen;
import power.keepeersofthestones.client.gui.EBGoldenDustScreen;
import power.keepeersofthestones.client.gui.EBFormScreen;
import power.keepeersofthestones.client.gui.EBFireScreen;
import power.keepeersofthestones.client.gui.EBExplosionScreen;
import power.keepeersofthestones.client.gui.EBEnergyScreen;
import power.keepeersofthestones.client.gui.EBEarthScreen;
import power.keepeersofthestones.client.gui.EBDestructionScreen;
import power.keepeersofthestones.client.gui.EBCrystalScreen;
import power.keepeersofthestones.client.gui.EBCreationScreen;
import power.keepeersofthestones.client.gui.EBBlueFlameScreen;
import power.keepeersofthestones.client.gui.EBBloodScreen;
import power.keepeersofthestones.client.gui.EBAnimalsScreen;
import power.keepeersofthestones.client.gui.EBAmberScreen;
import power.keepeersofthestones.client.gui.EBAirScreen;
import power.keepeersofthestones.client.gui.EBAetherScreen;
import power.keepeersofthestones.client.gui.CustomMusicPlayerScreen;
import power.keepeersofthestones.client.gui.CultivationGUIScreen;
import power.keepeersofthestones.client.gui.CompanionsGuiScreen;
import power.keepeersofthestones.client.gui.ChoiseSecretStoneGUIScreen;
import power.keepeersofthestones.client.gui.ChoiseMagicStonesPage3Screen;
import power.keepeersofthestones.client.gui.ChoiseMagicStonesPage2Screen;
import power.keepeersofthestones.client.gui.ChoiseMagicStoneGUIScreen;
import power.keepeersofthestones.client.gui.ChoiseMagicPower3Screen;
import power.keepeersofthestones.client.gui.ChoiseMagicPower2Screen;
import power.keepeersofthestones.client.gui.ChoiseMagicPower1Screen;
import power.keepeersofthestones.client.gui.CheckpointGUIScreen;
import power.keepeersofthestones.client.gui.CheckPointTPScreen;
import power.keepeersofthestones.client.gui.BuyLevel3Screen;
import power.keepeersofthestones.client.gui.BuyLevel2Screen;
import power.keepeersofthestones.client.gui.BuildingGUIScreen;
import power.keepeersofthestones.client.gui.BuildInMusicPlayerScreen;
import power.keepeersofthestones.client.gui.BatteryCreateGUIScreen;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class PowerModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(PowerModMenus.CULTIVATION_GUI.get(), CultivationGUIScreen::new);
			MenuScreens.register(PowerModMenus.SPAWN_ANIMALS_GUI.get(), SpawnAnimalsGUIScreen::new);
			MenuScreens.register(PowerModMenus.CHOISE_MAGIC_STONE_GUI.get(), ChoiseMagicStoneGUIScreen::new);
			MenuScreens.register(PowerModMenus.CHOISE_MAGIC_STONES_PAGE_2.get(), ChoiseMagicStonesPage2Screen::new);
			MenuScreens.register(PowerModMenus.CHECKPOINT_GUI.get(), CheckpointGUIScreen::new);
			MenuScreens.register(PowerModMenus.BATTERY_CREATE_GUI.get(), BatteryCreateGUIScreen::new);
			MenuScreens.register(PowerModMenus.REDSTONE_BUNDLE_GUI.get(), RedstoneBundleGUIScreen::new);
			MenuScreens.register(PowerModMenus.BUILDING_GUI.get(), BuildingGUIScreen::new);
			MenuScreens.register(PowerModMenus.EB_FIRE.get(), EBFireScreen::new);
			MenuScreens.register(PowerModMenus.EB_AIR.get(), EBAirScreen::new);
			MenuScreens.register(PowerModMenus.EB_WATER.get(), EBWaterScreen::new);
			MenuScreens.register(PowerModMenus.EB_EARTH.get(), EBEarthScreen::new);
			MenuScreens.register(PowerModMenus.EB_ENERGY.get(), EBEnergyScreen::new);
			MenuScreens.register(PowerModMenus.EB_ICE.get(), EBIceScreen::new);
			MenuScreens.register(PowerModMenus.EB_LIGHTNING.get(), EBLightningScreen::new);
			MenuScreens.register(PowerModMenus.EB_SOUND.get(), EBSoundScreen::new);
			MenuScreens.register(PowerModMenus.EB_CRYSTAL.get(), EBCrystalScreen::new);
			MenuScreens.register(PowerModMenus.EB_LAVA.get(), EBLavaScreen::new);
			MenuScreens.register(PowerModMenus.EB_RAIN.get(), EBRainScreen::new);
			MenuScreens.register(PowerModMenus.EB_TORNADO.get(), EBTornadoScreen::new);
			MenuScreens.register(PowerModMenus.EB_OCEAN.get(), EBOceanScreen::new);
			MenuScreens.register(PowerModMenus.EB_GREENERY.get(), EBGreeneryScreen::new);
			MenuScreens.register(PowerModMenus.EB_ANIMALS.get(), EBAnimalsScreen::new);
			MenuScreens.register(PowerModMenus.EB_METAL.get(), EBMetalScreen::new);
			MenuScreens.register(PowerModMenus.EB_LIGHT.get(), EBLightScreen::new);
			MenuScreens.register(PowerModMenus.EB_SHADOW.get(), EBShadowScreen::new);
			MenuScreens.register(PowerModMenus.EB_VACUUM.get(), EBVacuumScreen::new);
			MenuScreens.register(PowerModMenus.EB_SUN.get(), EBSunScreen::new);
			MenuScreens.register(PowerModMenus.EB_MOON.get(), EBMoonScreen::new);
			MenuScreens.register(PowerModMenus.EB_SPACE.get(), EBSpaceScreen::new);
			MenuScreens.register(PowerModMenus.EB_TIME.get(), EBTimeScreen::new);
			MenuScreens.register(PowerModMenus.EB_CREATION.get(), EBCreationScreen::new);
			MenuScreens.register(PowerModMenus.EB_DESTRUCTION.get(), EBDestructionScreen::new);
			MenuScreens.register(PowerModMenus.EB_BLOOD.get(), EBBloodScreen::new);
			MenuScreens.register(PowerModMenus.EB_TECHNOLOGY.get(), EBTechnologyScreen::new);
			MenuScreens.register(PowerModMenus.EB_TELEPORTATION.get(), EBTeleportationScreen::new);
			MenuScreens.register(PowerModMenus.EB_EXPLOSION.get(), EBExplosionScreen::new);
			MenuScreens.register(PowerModMenus.EB_AMBER.get(), EBAmberScreen::new);
			MenuScreens.register(PowerModMenus.POINT_GUI.get(), PointGUIScreen::new);
			MenuScreens.register(PowerModMenus.EB_BLUE_FLAME.get(), EBBlueFlameScreen::new);
			MenuScreens.register(PowerModMenus.CHOISE_MAGIC_STONES_PAGE_3.get(), ChoiseMagicStonesPage3Screen::new);
			MenuScreens.register(PowerModMenus.SPACE_ATLAS_GUI.get(), SpaceAtlasGUIScreen::new);
			MenuScreens.register(PowerModMenus.CHECK_POINT_TP.get(), CheckPointTPScreen::new);
			MenuScreens.register(PowerModMenus.LEVELS_AND_SKILLS_PAGE.get(), LevelsAndSkillsPageScreen::new);
			MenuScreens.register(PowerModMenus.BUY_LEVEL_2.get(), BuyLevel2Screen::new);
			MenuScreens.register(PowerModMenus.BUY_LEVEL_3.get(), BuyLevel3Screen::new);
			MenuScreens.register(PowerModMenus.EB_MIST.get(), EBMistScreen::new);
			MenuScreens.register(PowerModMenus.SOUND_IMITATE_CHOICE.get(), SoundImitateChoiceScreen::new);
			MenuScreens.register(PowerModMenus.EB_SAND.get(), EBSandScreen::new);
			MenuScreens.register(PowerModMenus.EB_SPEED.get(), EBSpeedScreen::new);
			MenuScreens.register(PowerModMenus.EB_POISON.get(), EBPoisonScreen::new);
			MenuScreens.register(PowerModMenus.EB_MAGNET.get(), EBMagnetScreen::new);
			MenuScreens.register(PowerModMenus.EB_MUSHROOMS.get(), EBMushroomsScreen::new);
			MenuScreens.register(PowerModMenus.EB_MERCURY.get(), EBMercuryScreen::new);
			MenuScreens.register(PowerModMenus.MUSIC_PLAYER_GUI.get(), MusicPlayerGUIScreen::new);
			MenuScreens.register(PowerModMenus.EB_MUSIC.get(), EBMusicScreen::new);
			MenuScreens.register(PowerModMenus.EB_PLAGUE.get(), EBPlagueScreen::new);
			MenuScreens.register(PowerModMenus.ROCKET_PATH_GUI.get(), RocketPathGUIScreen::new);
			MenuScreens.register(PowerModMenus.EB_GRAVITY.get(), EBGravityScreen::new);
			MenuScreens.register(PowerModMenus.CUSTOM_MUSIC_PLAYER.get(), CustomMusicPlayerScreen::new);
			MenuScreens.register(PowerModMenus.BUILD_IN_MUSIC_PLAYER.get(), BuildInMusicPlayerScreen::new);
			MenuScreens.register(PowerModMenus.EB_SMOKE.get(), EBSmokeScreen::new);
			MenuScreens.register(PowerModMenus.EB_SPIRIT.get(), EBSpiritScreen::new);
			MenuScreens.register(PowerModMenus.CHOISE_MAGIC_POWER_1.get(), ChoiseMagicPower1Screen::new);
			MenuScreens.register(PowerModMenus.CHOISE_MAGIC_POWER_3.get(), ChoiseMagicPower3Screen::new);
			MenuScreens.register(PowerModMenus.CHOISE_MAGIC_POWER_2.get(), ChoiseMagicPower2Screen::new);
			MenuScreens.register(PowerModMenus.EB_AETHER.get(), EBAetherScreen::new);
			MenuScreens.register(PowerModMenus.COMPANIONS_GUI.get(), CompanionsGuiScreen::new);
			MenuScreens.register(PowerModMenus.EB_FORM.get(), EBFormScreen::new);
			MenuScreens.register(PowerModMenus.EB_MIND.get(), EBMindScreen::new);
			MenuScreens.register(PowerModMenus.EB_GOLDEN_DUST.get(), EBGoldenDustScreen::new);
			MenuScreens.register(PowerModMenus.CHOISE_SECRET_STONE_GUI.get(), ChoiseSecretStoneGUIScreen::new);
		});
	}
}
