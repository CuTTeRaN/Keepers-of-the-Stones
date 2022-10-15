
package power.keepeersofthestones.client.gui;

import power.keepeersofthestones.world.inventory.BuildInMusicPlayerMenu;
import power.keepeersofthestones.network.BuildInMusicPlayerButtonMessage;
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

public class BuildInMusicPlayerScreen extends AbstractContainerScreen<BuildInMusicPlayerMenu> {
	private final static HashMap<String, Object> guistate = BuildInMusicPlayerMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public BuildInMusicPlayerScreen(BuildInMusicPlayerMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 300;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("power:textures/screens/build_in_music_player.png");

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
		this.font.draw(poseStack, "Music Player", 122, 7, -12829636);
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
		this.addRenderableWidget(new Button(this.leftPos + 239, this.topPos + 7, 46, 20, new TextComponent("Stop"), e -> {
			if (true) {
				PowerMod.PACKET_HANDLER.sendToServer(new BuildInMusicPlayerButtonMessage(0, x, y, z));
				BuildInMusicPlayerButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 23, this.topPos + 25, 40, 20, new TextComponent("Cat"), e -> {
			if (true) {
				PowerMod.PACKET_HANDLER.sendToServer(new BuildInMusicPlayerButtonMessage(1, x, y, z));
				BuildInMusicPlayerButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 68, this.topPos + 25, 56, 20, new TextComponent("Blocks"), e -> {
			if (true) {
				PowerMod.PACKET_HANDLER.sendToServer(new BuildInMusicPlayerButtonMessage(2, x, y, z));
				BuildInMusicPlayerButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 131, this.topPos + 25, 40, 20, new TextComponent("Far"), e -> {
			if (true) {
				PowerMod.PACKET_HANDLER.sendToServer(new BuildInMusicPlayerButtonMessage(3, x, y, z));
				BuildInMusicPlayerButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 23, this.topPos + 52, 46, 20, new TextComponent("Mall"), e -> {
			if (true) {
				PowerMod.PACKET_HANDLER.sendToServer(new BuildInMusicPlayerButtonMessage(4, x, y, z));
				BuildInMusicPlayerButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 77, this.topPos + 52, 61, 20, new TextComponent("Mellohi"), e -> {
			if (true) {
				PowerMod.PACKET_HANDLER.sendToServer(new BuildInMusicPlayerButtonMessage(5, x, y, z));
				BuildInMusicPlayerButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 140, this.topPos + 52, 51, 20, new TextComponent("Chirp"), e -> {
			if (true) {
				PowerMod.PACKET_HANDLER.sendToServer(new BuildInMusicPlayerButtonMessage(6, x, y, z));
				BuildInMusicPlayerButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 194, this.topPos + 52, 46, 20, new TextComponent("Stal"), e -> {
			if (true) {
				PowerMod.PACKET_HANDLER.sendToServer(new BuildInMusicPlayerButtonMessage(7, x, y, z));
				BuildInMusicPlayerButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 23, this.topPos + 79, 51, 20, new TextComponent("Strad"), e -> {
			if (true) {
				PowerMod.PACKET_HANDLER.sendToServer(new BuildInMusicPlayerButtonMessage(8, x, y, z));
				BuildInMusicPlayerButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 77, this.topPos + 79, 46, 20, new TextComponent("Ward"), e -> {
			if (true) {
				PowerMod.PACKET_HANDLER.sendToServer(new BuildInMusicPlayerButtonMessage(9, x, y, z));
				BuildInMusicPlayerButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 131, this.topPos + 79, 46, 20, new TextComponent("Wait"), e -> {
			if (true) {
				PowerMod.PACKET_HANDLER.sendToServer(new BuildInMusicPlayerButtonMessage(10, x, y, z));
				BuildInMusicPlayerButtonMessage.handleButtonAction(entity, 10, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 185, this.topPos + 79, 61, 20, new TextComponent("Pigstep"), e -> {
			if (true) {
				PowerMod.PACKET_HANDLER.sendToServer(new BuildInMusicPlayerButtonMessage(11, x, y, z));
				BuildInMusicPlayerButtonMessage.handleButtonAction(entity, 11, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 23, this.topPos + 106, 72, 20, new TextComponent("Otherside"), e -> {
			if (true) {
				PowerMod.PACKET_HANDLER.sendToServer(new BuildInMusicPlayerButtonMessage(12, x, y, z));
				BuildInMusicPlayerButtonMessage.handleButtonAction(entity, 12, x, y, z);
			}
		}));
	}
}
