
package power.keepeersofthestones.client.gui;

import power.keepeersofthestones.world.inventory.ChoiseMagicPower3Menu;
import power.keepeersofthestones.network.ChoiseMagicPower3ButtonMessage;
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

public class ChoiseMagicPower3Screen extends AbstractContainerScreen<ChoiseMagicPower3Menu> {
	private final static HashMap<String, Object> guistate = ChoiseMagicPower3Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public ChoiseMagicPower3Screen(ChoiseMagicPower3Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 400;
		this.imageHeight = 200;
	}

	private static final ResourceLocation texture = new ResourceLocation("power:textures/screens/choise_magic_power_3.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("power:textures/screens/blue_flame_master.png"));
		this.blit(ms, this.leftPos + 19, this.topPos + 33, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("power:textures/screens/smoke_master.png"));
		this.blit(ms, this.leftPos + 19, this.topPos + 60, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("power:textures/screens/spirit_master.png"));
		this.blit(ms, this.leftPos + 19, this.topPos + 87, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("power:textures/screens/form_master.png"));
		this.blit(ms, this.leftPos + 19, this.topPos + 141, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("power:textures/screens/mind_master.png"));
		this.blit(ms, this.leftPos + 109, this.topPos + 33, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("power:textures/screens/aether_master.png"));
		this.blit(ms, this.leftPos + 19, this.topPos + 114, 0, 0, 16, 16, 16, 16);

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
		this.font.draw(poseStack, Component.translatable("gui.power.choise_magic_power_3.label_choose_the_desired_power_of_the"), 127, 6, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.power.choise_magic_power_3.label_33"), 10, 6, -12829636);
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
				new Button(this.leftPos + 37, this.topPos + 87, 56, 20, Component.translatable("gui.power.choise_magic_power_3.button_spirit"), e -> {
					if (true) {
						PowerMod.PACKET_HANDLER.sendToServer(new ChoiseMagicPower3ButtonMessage(0, x, y, z));
						ChoiseMagicPower3ButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}));
		this.addRenderableWidget(
				new Button(this.leftPos + 37, this.topPos + 141, 56, 20, Component.translatable("gui.power.choise_magic_power_3.button_form"), e -> {
					if (true) {
						PowerMod.PACKET_HANDLER.sendToServer(new ChoiseMagicPower3ButtonMessage(1, x, y, z));
						ChoiseMagicPower3ButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}));
		this.addRenderableWidget(new Button(this.leftPos + 37, this.topPos + 114, 56, 20,
				Component.translatable("gui.power.choise_magic_power_3.button_aether"), e -> {
					if (true) {
						PowerMod.PACKET_HANDLER.sendToServer(new ChoiseMagicPower3ButtonMessage(2, x, y, z));
						ChoiseMagicPower3ButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}));
		this.addRenderableWidget(
				new Button(this.leftPos + 127, this.topPos + 33, 56, 20, Component.translatable("gui.power.choise_magic_power_3.button_mind"), e -> {
					if (true) {
						PowerMod.PACKET_HANDLER.sendToServer(new ChoiseMagicPower3ButtonMessage(3, x, y, z));
						ChoiseMagicPower3ButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}));
		this.addRenderableWidget(new Button(this.leftPos + 37, this.topPos + 33, 56, 20,
				Component.translatable("gui.power.choise_magic_power_3.button_blue_flame"), e -> {
					if (true) {
						PowerMod.PACKET_HANDLER.sendToServer(new ChoiseMagicPower3ButtonMessage(4, x, y, z));
						ChoiseMagicPower3ButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}));
		this.addRenderableWidget(
				new Button(this.leftPos + 37, this.topPos + 60, 56, 20, Component.translatable("gui.power.choise_magic_power_3.button_smoke"), e -> {
					if (true) {
						PowerMod.PACKET_HANDLER.sendToServer(new ChoiseMagicPower3ButtonMessage(5, x, y, z));
						ChoiseMagicPower3ButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}));
		this.addRenderableWidget(new Button(this.leftPos + 10, this.topPos + 168, 93, 20,
				Component.translatable("gui.power.choise_magic_power_3.button_previous_page"), e -> {
					if (true) {
						PowerMod.PACKET_HANDLER.sendToServer(new ChoiseMagicPower3ButtonMessage(6, x, y, z));
						ChoiseMagicPower3ButtonMessage.handleButtonAction(entity, 6, x, y, z);
					}
				}));
	}
}
