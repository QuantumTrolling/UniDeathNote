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
	ImageButton imagebutton_1ghostly_hunger2;
	ImageButton imagebutton_6obsession;
	ImageButton imagebutton_1ghostly_hunger3;
	ImageButton imagebutton_1ghostly_hunger4;
	ImageButton imagebutton_1ghostly_hunger5;
	ImageButton imagebutton_1ghostly_hunger6;
	ImageButton imagebutton_4disembodied;
	ImageButton imagebutton_11resurrection;

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
		if (mouseX > leftPos + 100 && mouseX < leftPos + 124 && mouseY > topPos + 35 && mouseY < topPos + 59)
			guiGraphics.renderTooltip(font, Component.translatable("gui.deathnote.skillls.tooltip_mstitielnyi_dukh"), mouseX, mouseY);
		if (mouseX > leftPos + 111 && mouseX < leftPos + 135 && mouseY > topPos + 64 && mouseY < topPos + 88)
			guiGraphics.renderTooltip(font, Component.translatable("gui.deathnote.skillls.tooltip_maghnitokiniez"), mouseX, mouseY);
		if (mouseX > leftPos + 70 && mouseX < leftPos + 94 && mouseY > topPos + 27 && mouseY < topPos + 51)
			guiGraphics.renderTooltip(font, Component.translatable("gui.deathnote.skillls.tooltip_biestieliesnost"), mouseX, mouseY);
		if (mouseX > leftPos + 100 && mouseX < leftPos + 124 && mouseY > topPos + 94 && mouseY < topPos + 118)
			guiGraphics.renderTooltip(font, Component.translatable("gui.deathnote.skillls.tooltip_rasshchieplieniie_dushi"), mouseX, mouseY);
		if (mouseX > leftPos + 40 && mouseX < leftPos + 64 && mouseY > topPos + 36 && mouseY < topPos + 60)
			guiGraphics.renderTooltip(font, Component.translatable("gui.deathnote.skillls.tooltip_odierzhimost"), mouseX, mouseY);
		if (mouseX > leftPos + 72 && mouseX < leftPos + 96 && mouseY > topPos + 104 && mouseY < topPos + 128)
			guiGraphics.renderTooltip(font, Component.translatable("gui.deathnote.skillls.tooltip_lievitatsiia"), mouseX, mouseY);
		if (mouseX > leftPos + 30 && mouseX < leftPos + 54 && mouseY > topPos + 66 && mouseY < topPos + 90)
			guiGraphics.renderTooltip(font, Component.translatable("gui.deathnote.skillls.tooltip_biestieliesnoie_pieriemieshchieniie"), mouseX, mouseY);
		if (mouseX > leftPos + 71 && mouseX < leftPos + 95 && mouseY > topPos + 65 && mouseY < topPos + 89)
			guiGraphics.renderTooltip(font, Component.translatable("gui.deathnote.skillls.tooltip_nieosiazaiemost"), mouseX, mouseY);
		if (mouseX > leftPos + 42 && mouseX < leftPos + 66 && mouseY > topPos + 95 && mouseY < topPos + 119)
			guiGraphics.renderTooltip(font, Component.translatable("gui.deathnote.skillls.tooltip_proiavlieniie"), mouseX, mouseY);
		if (mouseX > leftPos + 20 && mouseX < leftPos + 44 && mouseY > topPos + 118 && mouseY < topPos + 142)
			guiGraphics.renderTooltip(font, Component.translatable("gui.deathnote.skillls.tooltip_voskrieshieniie"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(new ResourceLocation("deathnote:textures/screens/guii.png"), this.leftPos + -30, this.topPos + -4, 0, 0, 240, 165, 240, 165);

		guiGraphics.blit(new ResourceLocation("deathnote:textures/screens/gui_for_skills3.png"), this.leftPos + -35, this.topPos + -11, 0, 0, 240, 165, 240, 165);

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
		imagebutton_2vengeful_spirit = new ImageButton(this.leftPos + 105, this.topPos + 39, 16, 16, 0, 0, 16, new ResourceLocation("deathnote:textures/screens/atlas/imagebutton_2vengeful_spirit.png"), 16, 32, e -> {
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
		imagebutton_1ghostly_hunger2 = new ImageButton(this.leftPos + 106, this.topPos + 98, 16, 16, 0, 0, 16, new ResourceLocation("deathnote:textures/screens/atlas/imagebutton_1ghostly_hunger2.png"), 16, 32, e -> {
			if (true) {
				DeathnoteMod.PACKET_HANDLER.sendToServer(new SkilllsButtonMessage(3, x, y, z));
				SkilllsButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_1ghostly_hunger2", imagebutton_1ghostly_hunger2);
		this.addRenderableWidget(imagebutton_1ghostly_hunger2);
		imagebutton_6obsession = new ImageButton(this.leftPos + 47, this.topPos + 40, 16, 16, 0, 0, 16, new ResourceLocation("deathnote:textures/screens/atlas/imagebutton_6obsession.png"), 16, 32, e -> {
			if (true) {
				DeathnoteMod.PACKET_HANDLER.sendToServer(new SkilllsButtonMessage(4, x, y, z));
				SkilllsButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:imagebutton_6obsession", imagebutton_6obsession);
		this.addRenderableWidget(imagebutton_6obsession);
		imagebutton_1ghostly_hunger3 = new ImageButton(this.leftPos + 76, this.topPos + 108, 16, 16, 0, 0, 16, new ResourceLocation("deathnote:textures/screens/atlas/imagebutton_1ghostly_hunger3.png"), 16, 32, e -> {
			if (true) {
				DeathnoteMod.PACKET_HANDLER.sendToServer(new SkilllsButtonMessage(5, x, y, z));
				SkilllsButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:imagebutton_1ghostly_hunger3", imagebutton_1ghostly_hunger3);
		this.addRenderableWidget(imagebutton_1ghostly_hunger3);
		imagebutton_1ghostly_hunger4 = new ImageButton(this.leftPos + 35, this.topPos + 69, 16, 16, 0, 0, 16, new ResourceLocation("deathnote:textures/screens/atlas/imagebutton_1ghostly_hunger4.png"), 16, 32, e -> {
			if (true) {
				DeathnoteMod.PACKET_HANDLER.sendToServer(new SkilllsButtonMessage(6, x, y, z));
				SkilllsButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		});
		guistate.put("button:imagebutton_1ghostly_hunger4", imagebutton_1ghostly_hunger4);
		this.addRenderableWidget(imagebutton_1ghostly_hunger4);
		imagebutton_1ghostly_hunger5 = new ImageButton(this.leftPos + 75, this.topPos + 69, 16, 16, 0, 0, 16, new ResourceLocation("deathnote:textures/screens/atlas/imagebutton_1ghostly_hunger5.png"), 16, 32, e -> {
			if (true) {
				DeathnoteMod.PACKET_HANDLER.sendToServer(new SkilllsButtonMessage(7, x, y, z));
				SkilllsButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		});
		guistate.put("button:imagebutton_1ghostly_hunger5", imagebutton_1ghostly_hunger5);
		this.addRenderableWidget(imagebutton_1ghostly_hunger5);
		imagebutton_1ghostly_hunger6 = new ImageButton(this.leftPos + 47, this.topPos + 98, 16, 16, 0, 0, 16, new ResourceLocation("deathnote:textures/screens/atlas/imagebutton_1ghostly_hunger6.png"), 16, 32, e -> {
			if (true) {
				DeathnoteMod.PACKET_HANDLER.sendToServer(new SkilllsButtonMessage(8, x, y, z));
				SkilllsButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		});
		guistate.put("button:imagebutton_1ghostly_hunger6", imagebutton_1ghostly_hunger6);
		this.addRenderableWidget(imagebutton_1ghostly_hunger6);
		imagebutton_4disembodied = new ImageButton(this.leftPos + 76, this.topPos + 31, 16, 16, 0, 0, 16, new ResourceLocation("deathnote:textures/screens/atlas/imagebutton_4disembodied.png"), 16, 32, e -> {
			if (true) {
				DeathnoteMod.PACKET_HANDLER.sendToServer(new SkilllsButtonMessage(9, x, y, z));
				SkilllsButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		});
		guistate.put("button:imagebutton_4disembodied", imagebutton_4disembodied);
		this.addRenderableWidget(imagebutton_4disembodied);
		imagebutton_11resurrection = new ImageButton(this.leftPos + 24, this.topPos + 122, 16, 16, 0, 0, 16, new ResourceLocation("deathnote:textures/screens/atlas/imagebutton_11resurrection.png"), 16, 32, e -> {
			if (true) {
				DeathnoteMod.PACKET_HANDLER.sendToServer(new SkilllsButtonMessage(10, x, y, z));
				SkilllsButtonMessage.handleButtonAction(entity, 10, x, y, z);
			}
		});
		guistate.put("button:imagebutton_11resurrection", imagebutton_11resurrection);
		this.addRenderableWidget(imagebutton_11resurrection);
	}
}
