
package power.keepeersofthestones.client.gui;

import power.keepeersofthestones.world.inventory.EBCrystalMenu;
import power.keepeersofthestones.network.EBCrystalButtonMessage;
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

public class EBCrystalScreen extends AbstractContainerScreen<EBCrystalMenu> {
	private final static HashMap<String, Object> guistate = EBCrystalMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public EBCrystalScreen(EBCrystalMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 0;
	}

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("power:textures/screens/book_of_elements_book.png"));
		this.blit(ms, this.leftPos + -244, this.topPos + -127, 0, 0, 512, 256, 512, 256);

		RenderSystem.setShaderTexture(0, new ResourceLocation("power:textures/screens/crystal_stone.png"));
		this.blit(ms, this.leftPos + -104, this.topPos + -109, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("power:textures/screens/crystal_master.png"));
		this.blit(ms, this.leftPos + 93, this.topPos + -109, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("power:textures/screens/crystal_element.png"));
		this.blit(ms, this.leftPos + 71, this.topPos + -85, 0, 0, 61, 128, 61, 128);

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
		this.font.draw(poseStack, Component.translatable("gui.power.eb_crystal.label_class_additional"), -162, -85, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.power.eb_crystal.label_element_crystal"), -162, -67, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.power.eb_crystal.label_force_shine"), -162, -49, -12829636);
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
				new Button(this.leftPos + 152, this.topPos + 86, 30, 20, Component.translatable("gui.power.eb_crystal.button_empty"), e -> {
					if (true) {
						PowerMod.PACKET_HANDLER.sendToServer(new EBCrystalButtonMessage(0, x, y, z));
						EBCrystalButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}));
	}
}
