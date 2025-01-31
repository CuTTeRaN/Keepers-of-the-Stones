
package power.keepeersofthestones.client.gui;

import power.keepeersofthestones.world.inventory.MusicPlayerGUIMenu;
import power.keepeersofthestones.network.MusicPlayerGUIButtonMessage;
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

public class MusicPlayerGUIScreen extends AbstractContainerScreen<MusicPlayerGUIMenu> {
	private final static HashMap<String, Object> guistate = MusicPlayerGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public MusicPlayerGUIScreen(MusicPlayerGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 300;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("power:textures/screens/music_player_gui.png");

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
		this.font.draw(poseStack, Component.translatable("gui.power.music_player_gui.label_music_player"), 122, 7, -12829636);
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
		this.addRenderableWidget(
				new Button(this.leftPos + 239, this.topPos + 7, 46, 20, Component.translatable("gui.power.music_player_gui.button_stop"), e -> {
					if (true) {
						PowerMod.PACKET_HANDLER.sendToServer(new MusicPlayerGUIButtonMessage(0, x, y, z));
						MusicPlayerGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}));
		this.addRenderableWidget(
				new Button(this.leftPos + 50, this.topPos + 61, 67, 20, Component.translatable("gui.power.music_player_gui.button_buildin"), e -> {
					if (true) {
						PowerMod.PACKET_HANDLER.sendToServer(new MusicPlayerGUIButtonMessage(1, x, y, z));
						MusicPlayerGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}));
		this.addRenderableWidget(
				new Button(this.leftPos + 176, this.topPos + 61, 56, 20, Component.translatable("gui.power.music_player_gui.button_custom"), e -> {
					if (true) {
						PowerMod.PACKET_HANDLER.sendToServer(new MusicPlayerGUIButtonMessage(2, x, y, z));
						MusicPlayerGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}));
	}
}
