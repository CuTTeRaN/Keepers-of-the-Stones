
package power.keepeersofthestones.client.gui;

import power.keepeersofthestones.world.inventory.ChoiseMagicPower2Menu;
import power.keepeersofthestones.network.ChoiseMagicPower2ButtonMessage;
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

public class ChoiseMagicPower2Screen extends AbstractContainerScreen<ChoiseMagicPower2Menu> {
	private final static HashMap<String, Object> guistate = ChoiseMagicPower2Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public ChoiseMagicPower2Screen(ChoiseMagicPower2Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 400;
		this.imageHeight = 200;
	}

	private static final ResourceLocation texture = new ResourceLocation("power:textures/screens/choise_magic_power_2.png");

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
		this.font.draw(poseStack, "Choose the desired power of the elements", 127, 6, -12829636);
		this.font.draw(poseStack, "2/3", 10, 6, -12829636);
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
		this.addRenderableWidget(new Button(this.leftPos + 37, this.topPos + 33, 56, 20, new TextComponent(" Moon"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 127, this.topPos + 141, 56, 20, new TextComponent(" Amber"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 37, this.topPos + 114, 56, 20, new TextComponent(" Destruct"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 37, this.topPos + 60, 56, 20, new TextComponent("Space"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 37, this.topPos + 141, 56, 20, new TextComponent("Blood"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 127, this.topPos + 33, 56, 20, new TextComponent("Time"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 127, this.topPos + 60, 56, 20, new TextComponent("Techolog."), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 127, this.topPos + 114, 56, 20, new TextComponent("Explosion"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 127, this.topPos + 87, 56, 20, new TextComponent("Teleport."), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 37, this.topPos + 87, 56, 20, new TextComponent("Creation"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 226, this.topPos + 33, 56, 20, new TextComponent("Mist"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 226, this.topPos + 60, 56, 20, new TextComponent("Sand"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 226, this.topPos + 87, 56, 20, new TextComponent(" Speed"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 10, this.topPos + 168, 93, 20, new TextComponent("Previous page"), e -> {
			if (true) {
				PowerMod.PACKET_HANDLER.sendToServer(new ChoiseMagicPower2ButtonMessage(13, x, y, z));
				ChoiseMagicPower2ButtonMessage.handleButtonAction(entity, 13, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 226, this.topPos + 114, 56, 20, new TextComponent(" Poison"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 226, this.topPos + 141, 56, 20, new TextComponent("Magnet"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 325, this.topPos + 33, 56, 20, new TextComponent("Mushrooms"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 325, this.topPos + 60, 56, 20, new TextComponent("Mercury"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 325, this.topPos + 87, 56, 20, new TextComponent("Music"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 325, this.topPos + 114, 56, 20, new TextComponent("Plague"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 325, this.topPos + 141, 56, 20, new TextComponent("Gravity"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 316, this.topPos + 168, 72, 20, new TextComponent("Next page"), e -> {
			if (true) {
				PowerMod.PACKET_HANDLER.sendToServer(new ChoiseMagicPower2ButtonMessage(21, x, y, z));
				ChoiseMagicPower2ButtonMessage.handleButtonAction(entity, 21, x, y, z);
			}
		}));
	}
}