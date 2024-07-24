package net.mcreator.deathnote.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.deathnote.world.inventory.SkilllsMenu;
import net.mcreator.deathnote.network.SkilllsButtonMessage;
import net.mcreator.deathnote.DeathnoteMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class SkilllsScreen extends AbstractContainerScreen<SkilllsMenu> {
	private final static HashMap<String, Object> guistate = SkilllsMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_skillgui;
	ImageButton imagebutton_skillgui1;

	public SkilllsScreen(SkilllsMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 154 && mouseX < leftPos + 178 && mouseY > topPos + 11 && mouseY < topPos + 35)
			guiGraphics.renderTooltip(font, Component.translatable("gui.deathnote.skillls.tooltip_prizrachnyi_gholod"), mouseX, mouseY);
		if (mouseX > leftPos + 135 && mouseX < leftPos + 159 && mouseY > topPos + 62 && mouseY < topPos + 86)
			guiGraphics.renderTooltip(font, Component.translatable("gui.deathnote.skillls.tooltip_mstitielnyi_dukh"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(new ResourceLocation("deathnote:textures/screens/gui1.png"), this.leftPos + -38, this.topPos + -11, 0, 0, 250, 180, 250, 180);

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
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		imagebutton_skillgui = new ImageButton(this.leftPos + 150, this.topPos + 7, 32, 32, 0, 0, 32, new ResourceLocation("deathnote:textures/screens/atlas/imagebutton_skillgui.png"), 32, 64, e -> {
			if (true) {
				DeathnoteMod.PACKET_HANDLER.sendToServer(new SkilllsButtonMessage(0, x, y, z));
				SkilllsButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_skillgui", imagebutton_skillgui);
		this.addRenderableWidget(imagebutton_skillgui);
		imagebutton_skillgui1 = new ImageButton(this.leftPos + 131, this.topPos + 58, 32, 32, 0, 0, 32, new ResourceLocation("deathnote:textures/screens/atlas/imagebutton_skillgui1.png"), 32, 64, e -> {
			if (true) {
				DeathnoteMod.PACKET_HANDLER.sendToServer(new SkilllsButtonMessage(1, x, y, z));
				SkilllsButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_skillgui1", imagebutton_skillgui1);
		this.addRenderableWidget(imagebutton_skillgui1);
	}
}
