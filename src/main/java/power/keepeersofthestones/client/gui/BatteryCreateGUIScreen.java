
package power.keepeersofthestones.client.gui;

import power.keepeersofthestones.world.inventory.BatteryCreateGUIMenu;
import power.keepeersofthestones.procedures.BatteryCreateGUIZnachieniieProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class BatteryCreateGUIScreen extends AbstractContainerScreen<BatteryCreateGUIMenu> {
	private final static HashMap<String, Object> guistate = BatteryCreateGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public BatteryCreateGUIScreen(BatteryCreateGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("power:textures/screens/battery_create_gui.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("power:textures/screens/slot_for_stone.png"));
		this.blit(ms, this.leftPos + 24, this.topPos + 35, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("power:textures/screens/slot_for_battery.png"));
		this.blit(ms, this.leftPos + 52, this.topPos + 35, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("power:textures/screens/arrow_gui.png"));
		this.blit(ms, this.leftPos + 75, this.topPos + 36, 0, 0, 22, 15, 22, 15);

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
		this.font.draw(poseStack, Component.translatable("gui.power.battery_create_gui.label_charging_the_battery"), 42, 7, -12829636);
		this.font.draw(poseStack,

				BatteryCreateGUIZnachieniieProcedure.execute(world, x, y, z), 83, 51, -12829636);
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
	}
}
