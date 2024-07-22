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
	ImageButton imagebutton_icon_star;
	ImageButton imagebutton_icon_star1;
	ImageButton imagebutton_icon_star2;
	ImageButton imagebutton_icon_star3;

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

	private static final ResourceLocation texture = new ResourceLocation("deathnote:textures/screens/skillls.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 136 && mouseX < leftPos + 160 && mouseY > topPos + 13 && mouseY < topPos + 37)
			guiGraphics.renderTooltip(font, Component.translatable("gui.deathnote.skillls.tooltip_empty"), mouseX, mouseY);
		if (mouseX > leftPos + 110 && mouseX < leftPos + 134 && mouseY > topPos + 40 && mouseY < topPos + 64)
			guiGraphics.renderTooltip(font, Component.translatable("gui.deathnote.skillls.tooltip_empty1"), mouseX, mouseY);
		if (mouseX > leftPos + 65 && mouseX < leftPos + 89 && mouseY > topPos + 28 && mouseY < topPos + 52)
			guiGraphics.renderTooltip(font, Component.translatable("gui.deathnote.skillls.tooltip_maghnitokiniez"), mouseX, mouseY);
		if (mouseX > leftPos + 104 && mouseX < leftPos + 128 && mouseY > topPos + 81 && mouseY < topPos + 105)
			guiGraphics.renderTooltip(font, Component.translatable("gui.deathnote.skillls.tooltip_biestieliesnost"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
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
		imagebutton_icon_star = new ImageButton(this.leftPos + 114, this.topPos + 43, 16, 16, 0, 0, 16, new ResourceLocation("deathnote:textures/screens/atlas/imagebutton_icon_star.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_icon_star", imagebutton_icon_star);
		this.addRenderableWidget(imagebutton_icon_star);
		imagebutton_icon_star1 = new ImageButton(this.leftPos + 141, this.topPos + 16, 16, 16, 0, 0, 16, new ResourceLocation("deathnote:textures/screens/atlas/imagebutton_icon_star1.png"), 16, 32, e -> {
			if (true) {
				DeathnoteMod.PACKET_HANDLER.sendToServer(new SkilllsButtonMessage(1, x, y, z));
				SkilllsButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_icon_star1", imagebutton_icon_star1);
		this.addRenderableWidget(imagebutton_icon_star1);
		imagebutton_icon_star2 = new ImageButton(this.leftPos + 69, this.topPos + 31, 16, 16, 0, 0, 16, new ResourceLocation("deathnote:textures/screens/atlas/imagebutton_icon_star2.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_icon_star2", imagebutton_icon_star2);
		this.addRenderableWidget(imagebutton_icon_star2);
		imagebutton_icon_star3 = new ImageButton(this.leftPos + 108, this.topPos + 84, 16, 16, 0, 0, 16, new ResourceLocation("deathnote:textures/screens/atlas/imagebutton_icon_star3.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_icon_star3", imagebutton_icon_star3);
		this.addRenderableWidget(imagebutton_icon_star3);
	}
}
