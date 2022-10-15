
package power.keepeersofthestones.client.gui;

import power.keepeersofthestones.world.inventory.CustomMusicPlayerMenu;
import power.keepeersofthestones.network.CustomMusicPlayerButtonMessage;
import power.keepeersofthestones.PowerMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class CustomMusicPlayerScreen extends AbstractContainerScreen<CustomMusicPlayerMenu> {
	private final static HashMap<String, Object> guistate = CustomMusicPlayerMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public CustomMusicPlayerScreen(CustomMusicPlayerMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 375;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("power:textures/screens/custom_music_player.png");

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
		this.font.draw(poseStack, "Music Player", 160, 7, -12829636);
		this.font.draw(poseStack, "This music works only with a resource pack that adds music!", 25, 142, -65536);
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
		this.addRenderableWidget(new Button(this.leftPos + 277, this.topPos + 7, 46, 20, new TextComponent("Stop"), e -> {
			if (true) {
				PowerMod.PACKET_HANDLER.sendToServer(new CustomMusicPlayerButtonMessage(0, x, y, z));
				CustomMusicPlayerButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 61, this.topPos + 34, 30, 20, new TextComponent("1"), e -> {
			if (true) {
				PowerMod.PACKET_HANDLER.sendToServer(new CustomMusicPlayerButtonMessage(1, x, y, z));
				CustomMusicPlayerButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 97, this.topPos + 34, 30, 20, new TextComponent("2"), e -> {
			if (true) {
				PowerMod.PACKET_HANDLER.sendToServer(new CustomMusicPlayerButtonMessage(2, x, y, z));
				CustomMusicPlayerButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 133, this.topPos + 34, 30, 20, new TextComponent("3"), e -> {
			if (true) {
				PowerMod.PACKET_HANDLER.sendToServer(new CustomMusicPlayerButtonMessage(3, x, y, z));
				CustomMusicPlayerButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 169, this.topPos + 34, 30, 20, new TextComponent("4"), e -> {
			if (true) {
				PowerMod.PACKET_HANDLER.sendToServer(new CustomMusicPlayerButtonMessage(4, x, y, z));
				CustomMusicPlayerButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 205, this.topPos + 34, 30, 20, new TextComponent("5"), e -> {
			if (true) {
				PowerMod.PACKET_HANDLER.sendToServer(new CustomMusicPlayerButtonMessage(5, x, y, z));
				CustomMusicPlayerButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 61, this.topPos + 61, 30, 20, new TextComponent("6"), e -> {
			if (true) {
				PowerMod.PACKET_HANDLER.sendToServer(new CustomMusicPlayerButtonMessage(6, x, y, z));
				CustomMusicPlayerButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 97, this.topPos + 61, 30, 20, new TextComponent("7"), e -> {
			if (true) {
				PowerMod.PACKET_HANDLER.sendToServer(new CustomMusicPlayerButtonMessage(7, x, y, z));
				CustomMusicPlayerButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 133, this.topPos + 61, 30, 20, new TextComponent("8"), e -> {
			if (true) {
				PowerMod.PACKET_HANDLER.sendToServer(new CustomMusicPlayerButtonMessage(8, x, y, z));
				CustomMusicPlayerButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 169, this.topPos + 61, 30, 20, new TextComponent("9"), e -> {
			if (true) {
				PowerMod.PACKET_HANDLER.sendToServer(new CustomMusicPlayerButtonMessage(9, x, y, z));
				CustomMusicPlayerButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 205, this.topPos + 61, 30, 20, new TextComponent("10"), e -> {
			if (true) {
				PowerMod.PACKET_HANDLER.sendToServer(new CustomMusicPlayerButtonMessage(10, x, y, z));
				CustomMusicPlayerButtonMessage.handleButtonAction(entity, 10, x, y, z);
			}
		}));
	}
}
