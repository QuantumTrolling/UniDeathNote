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
	ImageButton imagebutton_1ghostly_hunger;
	ImageButton imagebutton_2vengeful_spirit;
	ImageButton imagebutton_3magnetogenesis;
	ImageButton imagebutton_1ghostly_hunger1;
	ImageButton imagebutton_1ghostly_hunger2;
	ImageButton imagebutton_6obsession;
	ImageButton imagebutton_1ghostly_hunger3;
	ImageButton imagebutton_1ghostly_hunger4;

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
		if (mouseX > leftPos + 124 && mouseX < leftPos + 148 && mouseY > topPos + 12 && mouseY < topPos + 36)
			guiGraphics.renderTooltip(font, Component.translatable("gui.deathnote.skillls.tooltip_prizrachnyi_gholod"), mouseX, mouseY);
		if (mouseX > leftPos + 101 && mouseX < leftPos + 125 && mouseY > topPos + 35 && mouseY < topPos + 59)
			guiGraphics.renderTooltip(font, Component.translatable("gui.deathnote.skillls.tooltip_mstitielnyi_dukh"), mouseX, mouseY);
		if (mouseX > leftPos + 111 && mouseX < leftPos + 135 && mouseY > topPos + 64 && mouseY < topPos + 88)
			guiGraphics.renderTooltip(font, Component.translatable("gui.deathnote.skillls.tooltip_maghnitokiniez"), mouseX, mouseY);
		if (mouseX > leftPos + 72 && mouseX < leftPos + 96 && mouseY > topPos + 65 && mouseY < topPos + 89)
			guiGraphics.renderTooltip(font, Component.translatable("gui.deathnote.skillls.tooltip_biestieliesnost"), mouseX, mouseY);
		if (mouseX > leftPos + 101 && mouseX < leftPos + 125 && mouseY > topPos + 94 && mouseY < topPos + 118)
			guiGraphics.renderTooltip(font, Component.translatable("gui.deathnote.skillls.tooltip_rasshchieplieniie_dushi"), mouseX, mouseY);
		if (mouseX > leftPos + 71 && mouseX < leftPos + 95 && mouseY > topPos + 102 && mouseY < topPos + 126)
			guiGraphics.renderTooltip(font, Component.translatable("gui.deathnote.skillls.tooltip_odierzhimost"), mouseX, mouseY);
		if (mouseX > leftPos + 42 && mouseX < leftPos + 66 && mouseY > topPos + 94 && mouseY < topPos + 118)
			guiGraphics.renderTooltip(font, Component.translatable("gui.deathnote.skillls.tooltip_lievitatsiia"), mouseX, mouseY);
		if (mouseX > leftPos + 71 && mouseX < leftPos + 95 && mouseY > topPos + 27 && mouseY < topPos + 51)
			guiGraphics.renderTooltip(font, Component.translatable("gui.deathnote.skillls.tooltip_biestieliesnoie_pieriemieshchieniie"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(new ResourceLocation("deathnote:textures/screens/guii.png"), this.leftPos + -33, this.topPos + -3, 0, 0, 240, 165, 240, 165);

		guiGraphics.blit(new ResourceLocation("deathnote:textures/screens/gui_for_skills2.png"), this.leftPos + -34, this.topPos + -11, 0, 0, 240, 165, 240, 165);

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
		imagebutton_1ghostly_hunger = new ImageButton(this.leftPos + 130, this.topPos + 15, 16, 16, 0, 0, 16, new ResourceLocation("deathnote:textures/screens/atlas/imagebutton_1ghostly_hunger.png"), 16, 32, e -> {
			if (true) {
				DeathnoteMod.PACKET_HANDLER.sendToServer(new SkilllsButtonMessage(0, x, y, z));
				SkilllsButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_1ghostly_hunger", imagebutton_1ghostly_hunger);
		this.addRenderableWidget(imagebutton_1ghostly_hunger);
		imagebutton_2vengeful_spirit = new ImageButton(this.leftPos + 106, this.topPos + 39, 16, 16, 0, 0, 16, new ResourceLocation("deathnote:textures/screens/atlas/imagebutton_2vengeful_spirit.png"), 16, 32, e -> {
			if (true) {
				DeathnoteMod.PACKET_HANDLER.sendToServer(new SkilllsButtonMessage(1, x, y, z));
				SkilllsButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_2vengeful_spirit", imagebutton_2vengeful_spirit);
		this.addRenderableWidget(imagebutton_2vengeful_spirit);
		imagebutton_3magnetogenesis = new ImageButton(this.leftPos + 117, this.topPos + 68, 16, 16, 0, 0, 16, new ResourceLocation("deathnote:textures/screens/atlas/imagebutton_3magnetogenesis.png"), 16, 32, e -> {
			if (true) {
				DeathnoteMod.PACKET_HANDLER.sendToServer(new SkilllsButtonMessage(2, x, y, z));
				SkilllsButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_3magnetogenesis", imagebutton_3magnetogenesis);
		this.addRenderableWidget(imagebutton_3magnetogenesis);
		imagebutton_1ghostly_hunger1 = new ImageButton(this.leftPos + 77, this.topPos + 69, 16, 16, 0, 0, 16, new ResourceLocation("deathnote:textures/screens/atlas/imagebutton_1ghostly_hunger1.png"), 16, 32, e -> {
			if (true) {
				DeathnoteMod.PACKET_HANDLER.sendToServer(new SkilllsButtonMessage(3, x, y, z));
				SkilllsButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_1ghostly_hunger1", imagebutton_1ghostly_hunger1);
		this.addRenderableWidget(imagebutton_1ghostly_hunger1);
		imagebutton_1ghostly_hunger2 = new ImageButton(this.leftPos + 106, this.topPos + 98, 16, 16, 0, 0, 16, new ResourceLocation("deathnote:textures/screens/atlas/imagebutton_1ghostly_hunger2.png"), 16, 32, e -> {
			if (true) {
				DeathnoteMod.PACKET_HANDLER.sendToServer(new SkilllsButtonMessage(4, x, y, z));
				SkilllsButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:imagebutton_1ghostly_hunger2", imagebutton_1ghostly_hunger2);
		this.addRenderableWidget(imagebutton_1ghostly_hunger2);
		imagebutton_6obsession = new ImageButton(this.leftPos + 77, this.topPos + 105, 16, 16, 0, 0, 16, new ResourceLocation("deathnote:textures/screens/atlas/imagebutton_6obsession.png"), 16, 32, e -> {
			if (true) {
				DeathnoteMod.PACKET_HANDLER.sendToServer(new SkilllsButtonMessage(5, x, y, z));
				SkilllsButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:imagebutton_6obsession", imagebutton_6obsession);
		this.addRenderableWidget(imagebutton_6obsession);
		imagebutton_1ghostly_hunger3 = new ImageButton(this.leftPos + 49, this.topPos + 98, 16, 16, 0, 0, 16, new ResourceLocation("deathnote:textures/screens/atlas/imagebutton_1ghostly_hunger3.png"), 16, 32, e -> {
			if (true) {
				DeathnoteMod.PACKET_HANDLER.sendToServer(new SkilllsButtonMessage(6, x, y, z));
				SkilllsButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		});
		guistate.put("button:imagebutton_1ghostly_hunger3", imagebutton_1ghostly_hunger3);
		this.addRenderableWidget(imagebutton_1ghostly_hunger3);
		imagebutton_1ghostly_hunger4 = new ImageButton(this.leftPos + 77, this.topPos + 31, 16, 16, 0, 0, 16, new ResourceLocation("deathnote:textures/screens/atlas/imagebutton_1ghostly_hunger4.png"), 16, 32, e -> {
			if (true) {
				DeathnoteMod.PACKET_HANDLER.sendToServer(new SkilllsButtonMessage(7, x, y, z));
				SkilllsButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		});
		guistate.put("button:imagebutton_1ghostly_hunger4", imagebutton_1ghostly_hunger4);
		this.addRenderableWidget(imagebutton_1ghostly_hunger4);
	}
}
