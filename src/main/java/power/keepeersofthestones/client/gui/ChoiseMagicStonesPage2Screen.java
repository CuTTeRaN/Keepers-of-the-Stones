
package power.keepeersofthestones.client.gui;

import power.keepeersofthestones.world.inventory.ChoiseMagicStonesPage2Menu;
import power.keepeersofthestones.network.ChoiseMagicStonesPage2ButtonMessage;
import power.keepeersofthestones.PowerMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class ChoiseMagicStonesPage2Screen extends AbstractContainerScreen<ChoiseMagicStonesPage2Menu> {
	private final static HashMap<String, Object> guistate = ChoiseMagicStonesPage2Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public ChoiseMagicStonesPage2Screen(ChoiseMagicStonesPage2Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 400;
		this.imageHeight = 200;
	}

	private static final ResourceLocation texture = new ResourceLocation("power:textures/screens/choise_magic_stones_page_2.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		RenderSystem.setShaderTexture(0, new ResourceLocation("power:textures/screens/moon_master.png"));
		this.blit(ms, this.leftPos + 19, this.topPos + 33, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("power:textures/screens/cosmos_master.png"));
		this.blit(ms, this.leftPos + 19, this.topPos + 60, 0, 0, -1, -1, -1, -1);

		RenderSystem.setShaderTexture(0, new ResourceLocation("power:textures/screens/blood_master.png"));
		this.blit(ms, this.leftPos + 19, this.topPos + 141, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("power:textures/screens/time_master.png"));
		this.blit(ms, this.leftPos + 109, this.topPos + 33, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("power:textures/screens/technology_master.png"));
		this.blit(ms, this.leftPos + 109, this.topPos + 60, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("power:textures/screens/teleportation_master.png"));
		this.blit(ms, this.leftPos + 109, this.topPos + 87, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("power:textures/screens/explosion_master.png"));
		this.blit(ms, this.leftPos + 109, this.topPos + 114, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("power:textures/screens/creation_master.png"));
		this.blit(ms, this.leftPos + 19, this.topPos + 87, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("power:textures/screens/destruction_master.png"));
		this.blit(ms, this.leftPos + 19, this.topPos + 114, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("power:textures/screens/amber_master.png"));
		this.blit(ms, this.leftPos + 109, this.topPos + 141, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("power:textures/screens/space_master.png"));
		this.blit(ms, this.leftPos + 19, this.topPos + 60, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("power:textures/screens/mist_master.png"));
		this.blit(ms, this.leftPos + 208, this.topPos + 33, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("power:textures/screens/sand_master.png"));
		this.blit(ms, this.leftPos + 208, this.topPos + 60, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("power:textures/screens/speed_master.png"));
		this.blit(ms, this.leftPos + 208, this.topPos + 87, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("power:textures/screens/poison_master.png"));
		this.blit(ms, this.leftPos + 208, this.topPos + 114, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("power:textures/screens/magnet_master.png"));
		this.blit(ms, this.leftPos + 208, this.topPos + 141, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("power:textures/screens/mushrooms_master.png"));
		this.blit(ms, this.leftPos + 307, this.topPos + 33, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("power:textures/screens/mercury_master.png"));
		this.blit(ms, this.leftPos + 307, this.topPos + 60, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("power:textures/screens/music_master.png"));
		this.blit(ms, this.leftPos + 307, this.topPos + 87, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("power:textures/screens/plague_master.png"));
		this.blit(ms, this.leftPos + 307, this.topPos + 114, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("power:textures/screens/gravity_master.png"));
		this.blit(ms, this.leftPos + 307, this.topPos + 141, 0, 0, 16, 16, 16, 16);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, Component.translatable("gui.power.choise_magic_stones_page_2.label_choose_a_stone_to_get_it"), 127, 6, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.power.choise_magic_stones_page_2.label_23"), 10, 6, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		this.addRenderableWidget(new Button(this.leftPos + 37, this.topPos + 33, 56, 20,
				Component.translatable("gui.power.choise_magic_stones_page_2.button_moon"), e -> {
					if (true) {
						PowerMod.PACKET_HANDLER.sendToServer(new ChoiseMagicStonesPage2ButtonMessage(0, x, y, z));
						ChoiseMagicStonesPage2ButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}));
		this.addRenderableWidget(new Button(this.leftPos + 127, this.topPos + 141, 56, 20,
				Component.translatable("gui.power.choise_magic_stones_page_2.button_amber"), e -> {
					if (true) {
						PowerMod.PACKET_HANDLER.sendToServer(new ChoiseMagicStonesPage2ButtonMessage(1, x, y, z));
						ChoiseMagicStonesPage2ButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}));
		this.addRenderableWidget(new Button(this.leftPos + 37, this.topPos + 114, 56, 20,
				Component.translatable("gui.power.choise_magic_stones_page_2.button_destruct"), e -> {
					if (true) {
						PowerMod.PACKET_HANDLER.sendToServer(new ChoiseMagicStonesPage2ButtonMessage(2, x, y, z));
						ChoiseMagicStonesPage2ButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}));
		this.addRenderableWidget(new Button(this.leftPos + 37, this.topPos + 60, 56, 20,
				Component.translatable("gui.power.choise_magic_stones_page_2.button_space"), e -> {
					if (true) {
						PowerMod.PACKET_HANDLER.sendToServer(new ChoiseMagicStonesPage2ButtonMessage(3, x, y, z));
						ChoiseMagicStonesPage2ButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}));
		this.addRenderableWidget(new Button(this.leftPos + 37, this.topPos + 141, 56, 20,
				Component.translatable("gui.power.choise_magic_stones_page_2.button_blood"), e -> {
					if (true) {
						PowerMod.PACKET_HANDLER.sendToServer(new ChoiseMagicStonesPage2ButtonMessage(4, x, y, z));
						ChoiseMagicStonesPage2ButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}));
		this.addRenderableWidget(new Button(this.leftPos + 127, this.topPos + 33, 56, 20,
				Component.translatable("gui.power.choise_magic_stones_page_2.button_time"), e -> {
					if (true) {
						PowerMod.PACKET_HANDLER.sendToServer(new ChoiseMagicStonesPage2ButtonMessage(5, x, y, z));
						ChoiseMagicStonesPage2ButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}));
		this.addRenderableWidget(new Button(this.leftPos + 127, this.topPos + 60, 56, 20,
				Component.translatable("gui.power.choise_magic_stones_page_2.button_techolog"), e -> {
					if (true) {
						PowerMod.PACKET_HANDLER.sendToServer(new ChoiseMagicStonesPage2ButtonMessage(6, x, y, z));
						ChoiseMagicStonesPage2ButtonMessage.handleButtonAction(entity, 6, x, y, z);
					}
				}));
		this.addRenderableWidget(new Button(this.leftPos + 127, this.topPos + 114, 56, 20,
				Component.translatable("gui.power.choise_magic_stones_page_2.button_explosion"), e -> {
					if (true) {
						PowerMod.PACKET_HANDLER.sendToServer(new ChoiseMagicStonesPage2ButtonMessage(7, x, y, z));
						ChoiseMagicStonesPage2ButtonMessage.handleButtonAction(entity, 7, x, y, z);
					}
				}));
		this.addRenderableWidget(new Button(this.leftPos + 127, this.topPos + 87, 56, 20,
				Component.translatable("gui.power.choise_magic_stones_page_2.button_teleport"), e -> {
					if (true) {
						PowerMod.PACKET_HANDLER.sendToServer(new ChoiseMagicStonesPage2ButtonMessage(8, x, y, z));
						ChoiseMagicStonesPage2ButtonMessage.handleButtonAction(entity, 8, x, y, z);
					}
				}));
		this.addRenderableWidget(new Button(this.leftPos + 37, this.topPos + 87, 56, 20,
				Component.translatable("gui.power.choise_magic_stones_page_2.button_creation"), e -> {
					if (true) {
						PowerMod.PACKET_HANDLER.sendToServer(new ChoiseMagicStonesPage2ButtonMessage(9, x, y, z));
						ChoiseMagicStonesPage2ButtonMessage.handleButtonAction(entity, 9, x, y, z);
					}
				}));
		this.addRenderableWidget(new Button(this.leftPos + 226, this.topPos + 33, 56, 20,
				Component.translatable("gui.power.choise_magic_stones_page_2.button_mist"), e -> {
					if (true) {
						PowerMod.PACKET_HANDLER.sendToServer(new ChoiseMagicStonesPage2ButtonMessage(10, x, y, z));
						ChoiseMagicStonesPage2ButtonMessage.handleButtonAction(entity, 10, x, y, z);
					}
				}));
		this.addRenderableWidget(new Button(this.leftPos + 226, this.topPos + 60, 56, 20,
				Component.translatable("gui.power.choise_magic_stones_page_2.button_sand"), e -> {
					if (true) {
						PowerMod.PACKET_HANDLER.sendToServer(new ChoiseMagicStonesPage2ButtonMessage(11, x, y, z));
						ChoiseMagicStonesPage2ButtonMessage.handleButtonAction(entity, 11, x, y, z);
					}
				}));
		this.addRenderableWidget(new Button(this.leftPos + 226, this.topPos + 87, 56, 20,
				Component.translatable("gui.power.choise_magic_stones_page_2.button_speed"), e -> {
					if (true) {
						PowerMod.PACKET_HANDLER.sendToServer(new ChoiseMagicStonesPage2ButtonMessage(12, x, y, z));
						ChoiseMagicStonesPage2ButtonMessage.handleButtonAction(entity, 12, x, y, z);
					}
				}));
		this.addRenderableWidget(new Button(this.leftPos + 10, this.topPos + 168, 93, 20,
				Component.translatable("gui.power.choise_magic_stones_page_2.button_previous_page"), e -> {
					if (true) {
						PowerMod.PACKET_HANDLER.sendToServer(new ChoiseMagicStonesPage2ButtonMessage(13, x, y, z));
						ChoiseMagicStonesPage2ButtonMessage.handleButtonAction(entity, 13, x, y, z);
					}
				}));
		this.addRenderableWidget(new Button(this.leftPos + 226, this.topPos + 114, 56, 20,
				Component.translatable("gui.power.choise_magic_stones_page_2.button_poison"), e -> {
					if (true) {
						PowerMod.PACKET_HANDLER.sendToServer(new ChoiseMagicStonesPage2ButtonMessage(14, x, y, z));
						ChoiseMagicStonesPage2ButtonMessage.handleButtonAction(entity, 14, x, y, z);
					}
				}));
		this.addRenderableWidget(new Button(this.leftPos + 226, this.topPos + 141, 56, 20,
				Component.translatable("gui.power.choise_magic_stones_page_2.button_magnet"), e -> {
					if (true) {
						PowerMod.PACKET_HANDLER.sendToServer(new ChoiseMagicStonesPage2ButtonMessage(15, x, y, z));
						ChoiseMagicStonesPage2ButtonMessage.handleButtonAction(entity, 15, x, y, z);
					}
				}));
		this.addRenderableWidget(new Button(this.leftPos + 325, this.topPos + 33, 56, 20,
				Component.translatable("gui.power.choise_magic_stones_page_2.button_mushrooms"), e -> {
					if (true) {
						PowerMod.PACKET_HANDLER.sendToServer(new ChoiseMagicStonesPage2ButtonMessage(16, x, y, z));
						ChoiseMagicStonesPage2ButtonMessage.handleButtonAction(entity, 16, x, y, z);
					}
				}));
		this.addRenderableWidget(new Button(this.leftPos + 325, this.topPos + 60, 56, 20,
				Component.translatable("gui.power.choise_magic_stones_page_2.button_mercury"), e -> {
					if (true) {
						PowerMod.PACKET_HANDLER.sendToServer(new ChoiseMagicStonesPage2ButtonMessage(17, x, y, z));
						ChoiseMagicStonesPage2ButtonMessage.handleButtonAction(entity, 17, x, y, z);
					}
				}));
		this.addRenderableWidget(new Button(this.leftPos + 325, this.topPos + 87, 56, 20,
				Component.translatable("gui.power.choise_magic_stones_page_2.button_music"), e -> {
					if (true) {
						PowerMod.PACKET_HANDLER.sendToServer(new ChoiseMagicStonesPage2ButtonMessage(18, x, y, z));
						ChoiseMagicStonesPage2ButtonMessage.handleButtonAction(entity, 18, x, y, z);
					}
				}));
		this.addRenderableWidget(new Button(this.leftPos + 325, this.topPos + 114, 56, 20,
				Component.translatable("gui.power.choise_magic_stones_page_2.button_plague"), e -> {
					if (true) {
						PowerMod.PACKET_HANDLER.sendToServer(new ChoiseMagicStonesPage2ButtonMessage(19, x, y, z));
						ChoiseMagicStonesPage2ButtonMessage.handleButtonAction(entity, 19, x, y, z);
					}
				}));
		this.addRenderableWidget(new Button(this.leftPos + 325, this.topPos + 141, 56, 20,
				Component.translatable("gui.power.choise_magic_stones_page_2.button_gravity"), e -> {
					if (true) {
						PowerMod.PACKET_HANDLER.sendToServer(new ChoiseMagicStonesPage2ButtonMessage(20, x, y, z));
						ChoiseMagicStonesPage2ButtonMessage.handleButtonAction(entity, 20, x, y, z);
					}
				}));
		this.addRenderableWidget(new Button(this.leftPos + 316, this.topPos + 168, 72, 20,
				Component.translatable("gui.power.choise_magic_stones_page_2.button_next_page"), e -> {
					if (true) {
						PowerMod.PACKET_HANDLER.sendToServer(new ChoiseMagicStonesPage2ButtonMessage(21, x, y, z));
						ChoiseMagicStonesPage2ButtonMessage.handleButtonAction(entity, 21, x, y, z);
					}
				}));
	}
}
