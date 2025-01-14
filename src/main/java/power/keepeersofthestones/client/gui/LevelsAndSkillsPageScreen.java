
package power.keepeersofthestones.client.gui;

import power.keepeersofthestones.world.inventory.LevelsAndSkillsPageMenu;
import power.keepeersofthestones.procedures.ReturnReactiveFlyingProcedure;
import power.keepeersofthestones.procedures.ReturnLevel3Procedure;
import power.keepeersofthestones.procedures.ReturnLevel2Procedure;
import power.keepeersofthestones.procedures.ReturnLevel1Procedure;
import power.keepeersofthestones.procedures.NoReturnReactiveFlyingProcedure;
import power.keepeersofthestones.procedures.GetLevel2Procedure;
import power.keepeersofthestones.procedures.GetLevel1Procedure;
import power.keepeersofthestones.network.LevelsAndSkillsPageButtonMessage;
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

public class LevelsAndSkillsPageScreen extends AbstractContainerScreen<LevelsAndSkillsPageMenu> {
	private final static HashMap<String, Object> guistate = LevelsAndSkillsPageMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public LevelsAndSkillsPageScreen(LevelsAndSkillsPageMenu container, Inventory inventory, Component text) {
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

		if (GetLevel2Procedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("power:textures/screens/level_checked.png"));
			this.blit(ms, this.leftPos + -71, this.topPos + -56, 0, 0, 19, 18, 19, 18);
		}
		if (ReturnLevel3Procedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("power:textures/screens/level_checked.png"));
			this.blit(ms, this.leftPos + -69, this.topPos + -24, 0, 0, 19, 18, 19, 18);
		}
		if (GetLevel1Procedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("power:textures/screens/level_checked.png"));
			this.blit(ms, this.leftPos + -72, this.topPos + -87, 0, 0, 19, 18, 19, 18);
		}

		RenderSystem.setShaderTexture(0, new ResourceLocation("power:textures/screens/fire_master.png"));
		this.blit(ms, this.leftPos + 46, this.topPos + -71, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("power:textures/screens/blue_flame_master.png"));
		this.blit(ms, this.leftPos + 64, this.topPos + -71, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("power:textures/screens/lightning_master.png"));
		this.blit(ms, this.leftPos + 80, this.topPos + -71, 0, 0, 16, 16, 16, 16);

		if (ReturnReactiveFlyingProcedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("power:textures/screens/level_checked.png"));
			this.blit(ms, this.leftPos + 138, this.topPos + -70, 0, 0, 19, 18, 19, 18);
		}

		RenderSystem.setShaderTexture(0, new ResourceLocation("power:textures/screens/rain_master.png"));
		this.blit(ms, this.leftPos + 94, this.topPos + -71, 0, 0, 16, 16, 16, 16);

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
		this.font.draw(poseStack, Component.translatable("gui.power.levels_and_skills_page.label_level_2"), -163, -48, -13421773);
		this.font.draw(poseStack, Component.translatable("gui.power.levels_and_skills_page.label_level_3"), -163, -18, -13421773);
		this.font.draw(poseStack, Component.translatable("gui.power.levels_and_skills_page.label_level_1"), -163, -81, -13421773);
		this.font.draw(poseStack, Component.translatable("gui.power.levels_and_skills_page.label_reactive_flying"), 25, -81, -13421773);
		this.font.draw(poseStack, Component.translatable("gui.power.levels_and_skills_page.label_for"), 25, -65, -13421773);
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
		this.addRenderableWidget(new Button(this.leftPos + -180, this.topPos + 86, 30, 20,
				Component.translatable("gui.power.levels_and_skills_page.button_empty"), e -> {
					if (true) {
						PowerMod.PACKET_HANDLER.sendToServer(new LevelsAndSkillsPageButtonMessage(0, x, y, z));
						LevelsAndSkillsPageButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}));
		this.addRenderableWidget(new Button(this.leftPos + 152, this.topPos + 86, 30, 20,
				Component.translatable("gui.power.levels_and_skills_page.button_empty1"), e -> {
				}));
		this.addRenderableWidget(new Button(this.leftPos + -82, this.topPos + -61, 40, 20,
				Component.translatable("gui.power.levels_and_skills_page.button_buy"), e -> {
					if (ReturnLevel1Procedure.execute(entity)) {
						PowerMod.PACKET_HANDLER.sendToServer(new LevelsAndSkillsPageButtonMessage(2, x, y, z));
						LevelsAndSkillsPageButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (ReturnLevel1Procedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + -82, this.topPos + -29, 40, 20,
				Component.translatable("gui.power.levels_and_skills_page.button_buy1"), e -> {
					if (ReturnLevel2Procedure.execute(entity)) {
						PowerMod.PACKET_HANDLER.sendToServer(new LevelsAndSkillsPageButtonMessage(3, x, y, z));
						LevelsAndSkillsPageButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (ReturnLevel2Procedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + 128, this.topPos + -75, 40, 20,
				Component.translatable("gui.power.levels_and_skills_page.button_buy2"), e -> {
					if (NoReturnReactiveFlyingProcedure.execute(entity)) {
						PowerMod.PACKET_HANDLER.sendToServer(new LevelsAndSkillsPageButtonMessage(4, x, y, z));
						LevelsAndSkillsPageButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (NoReturnReactiveFlyingProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
	}
}
