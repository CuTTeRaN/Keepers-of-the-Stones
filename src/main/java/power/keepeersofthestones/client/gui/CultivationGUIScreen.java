
package power.keepeersofthestones.client.gui;

import power.keepeersofthestones.world.inventory.CultivationGUIMenu;
import power.keepeersofthestones.network.CultivationGUIButtonMessage;
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

public class CultivationGUIScreen extends AbstractContainerScreen<CultivationGUIMenu> {
	private final static HashMap<String, Object> guistate = CultivationGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public CultivationGUIScreen(CultivationGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 354;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("power:textures/screens/cultivation_gui.png");

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
		this.font.draw(poseStack, Component.translatable("gui.power.cultivation_gui.label_select_a_plant_to_get"), 113, 6, -12829636);
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
		this.addRenderableWidget(new Button(this.leftPos + 257, this.topPos + 133, 77, 20,
				Component.translatable("gui.power.cultivation_gui.button_water_lily"), e -> {
					if (true) {
						PowerMod.PACKET_HANDLER.sendToServer(new CultivationGUIButtonMessage(0, x, y, z));
						CultivationGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}));
		this.addRenderableWidget(
				new Button(this.leftPos + 5, this.topPos + 25, 77, 20, Component.translatable("gui.power.cultivation_gui.button_oak_sapling"), e -> {
					if (true) {
						PowerMod.PACKET_HANDLER.sendToServer(new CultivationGUIButtonMessage(1, x, y, z));
						CultivationGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}));
		this.addRenderableWidget(new Button(this.leftPos + 131, this.topPos + 25, 77, 20,
				Component.translatable("gui.power.cultivation_gui.button_birch_sapling"), e -> {
					if (true) {
						PowerMod.PACKET_HANDLER.sendToServer(new CultivationGUIButtonMessage(2, x, y, z));
						CultivationGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}));
		this.addRenderableWidget(new Button(this.leftPos + 131, this.topPos + 133, 77, 20,
				Component.translatable("gui.power.cultivation_gui.button_spruce_sapling"), e -> {
					if (true) {
						PowerMod.PACKET_HANDLER.sendToServer(new CultivationGUIButtonMessage(3, x, y, z));
						CultivationGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}));
		this.addRenderableWidget(new Button(this.leftPos + 257, this.topPos + 25, 77, 20,
				Component.translatable("gui.power.cultivation_gui.button_acacia_sapling"), e -> {
					if (true) {
						PowerMod.PACKET_HANDLER.sendToServer(new CultivationGUIButtonMessage(4, x, y, z));
						CultivationGUIButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}));
		this.addRenderableWidget(
				new Button(this.leftPos + 5, this.topPos + 52, 77, 20, Component.translatable("gui.power.cultivation_gui.button_dark_sapling"), e -> {
					if (true) {
						PowerMod.PACKET_HANDLER.sendToServer(new CultivationGUIButtonMessage(5, x, y, z));
						CultivationGUIButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}));
		this.addRenderableWidget(new Button(this.leftPos + 131, this.topPos + 52, 77, 20,
				Component.translatable("gui.power.cultivation_gui.button_jungle_sapling"), e -> {
					if (true) {
						PowerMod.PACKET_HANDLER.sendToServer(new CultivationGUIButtonMessage(6, x, y, z));
						CultivationGUIButtonMessage.handleButtonAction(entity, 6, x, y, z);
					}
				}));
		this.addRenderableWidget(
				new Button(this.leftPos + 5, this.topPos + 79, 77, 20, Component.translatable("gui.power.cultivation_gui.button_wheat"), e -> {
					if (true) {
						PowerMod.PACKET_HANDLER.sendToServer(new CultivationGUIButtonMessage(7, x, y, z));
						CultivationGUIButtonMessage.handleButtonAction(entity, 7, x, y, z);
					}
				}));
		this.addRenderableWidget(
				new Button(this.leftPos + 131, this.topPos + 79, 77, 20, Component.translatable("gui.power.cultivation_gui.button_potato"), e -> {
					if (true) {
						PowerMod.PACKET_HANDLER.sendToServer(new CultivationGUIButtonMessage(8, x, y, z));
						CultivationGUIButtonMessage.handleButtonAction(entity, 8, x, y, z);
					}
				}));
		this.addRenderableWidget(
				new Button(this.leftPos + 257, this.topPos + 79, 77, 20, Component.translatable("gui.power.cultivation_gui.button_carrot"), e -> {
					if (true) {
						PowerMod.PACKET_HANDLER.sendToServer(new CultivationGUIButtonMessage(9, x, y, z));
						CultivationGUIButtonMessage.handleButtonAction(entity, 9, x, y, z);
					}
				}));
		this.addRenderableWidget(
				new Button(this.leftPos + 5, this.topPos + 133, 77, 20, Component.translatable("gui.power.cultivation_gui.button_beetroot"), e -> {
					if (true) {
						PowerMod.PACKET_HANDLER.sendToServer(new CultivationGUIButtonMessage(10, x, y, z));
						CultivationGUIButtonMessage.handleButtonAction(entity, 10, x, y, z);
					}
				}));
		this.addRenderableWidget(
				new Button(this.leftPos + 5, this.topPos + 106, 77, 20, Component.translatable("gui.power.cultivation_gui.button_melon"), e -> {
					if (true) {
						PowerMod.PACKET_HANDLER.sendToServer(new CultivationGUIButtonMessage(11, x, y, z));
						CultivationGUIButtonMessage.handleButtonAction(entity, 11, x, y, z);
					}
				}));
		this.addRenderableWidget(
				new Button(this.leftPos + 131, this.topPos + 106, 77, 20, Component.translatable("gui.power.cultivation_gui.button_pumpkin"), e -> {
					if (true) {
						PowerMod.PACKET_HANDLER.sendToServer(new CultivationGUIButtonMessage(12, x, y, z));
						CultivationGUIButtonMessage.handleButtonAction(entity, 12, x, y, z);
					}
				}));
		this.addRenderableWidget(new Button(this.leftPos + 257, this.topPos + 106, 77, 20,
				Component.translatable("gui.power.cultivation_gui.button_sugar_cane"), e -> {
					if (true) {
						PowerMod.PACKET_HANDLER.sendToServer(new CultivationGUIButtonMessage(13, x, y, z));
						CultivationGUIButtonMessage.handleButtonAction(entity, 13, x, y, z);
					}
				}));
		this.addRenderableWidget(
				new Button(this.leftPos + 257, this.topPos + 52, 77, 20, Component.translatable("gui.power.cultivation_gui.button_bamboo"), e -> {
					if (true) {
						PowerMod.PACKET_HANDLER.sendToServer(new CultivationGUIButtonMessage(14, x, y, z));
						CultivationGUIButtonMessage.handleButtonAction(entity, 14, x, y, z);
					}
				}));
	}
}
