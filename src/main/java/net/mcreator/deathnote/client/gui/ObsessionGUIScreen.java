package net.mcreator.deathnote.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.deathnote.world.inventory.ObsessionGUIMenu;
import net.mcreator.deathnote.procedures.ShowObsessionDeclineProcedure;
import net.mcreator.deathnote.procedures.ShowObsessionButtProcedure;
import net.mcreator.deathnote.procedures.OutPutProcedure;
import net.mcreator.deathnote.procedures.ObsessionLevelOutPutProcedure;
import net.mcreator.deathnote.network.ObsessionGUIButtonMessage;
import net.mcreator.deathnote.DeathnoteMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class ObsessionGUIScreen extends AbstractContainerScreen<ObsessionGUIMenu> {
	private final static HashMap<String, Object> guistate = ObsessionGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_plus_1;
	ImageButton imagebutton_minus_1;
	ImageButton imagebutton_accept2;
	ImageButton imagebutton_dismiss;

	public ObsessionGUIScreen(ObsessionGUIMenu container, Inventory inventory, Component text) {
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
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(new ResourceLocation("deathnote:textures/screens/gui_final.png"), this.leftPos + -92, this.topPos + -11, 0, 0, 355, 182, 355, 182);

		guiGraphics.blit(new ResourceLocation("deathnote:textures/screens/obsession.png"), this.leftPos + 125, this.topPos + 18, 0, 0, 64, 64, 64, 64);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.obsession_gui.label_prizrachnyi_gholod"), -47, 7, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.obsession_gui.label_tvoi_gholod_vospolniaietsia_sam_1"), -47, 25, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.obsession_gui.label_ieda_bolshie_nie_vospolniaiet_tiebie"), -47, 61, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.obsession_gui.label_prokachka_1_ied_sytosti_v_minutu"), -47, 79, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.obsession_gui.label_budut_atakovat_mobov"), -47, 43, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.obsession_gui.label_bonus_50_k_nanosimomu"), -47, 34, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.obsession_gui.label_10_k_uronu"), -47, 97, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.obsession_gui.label_5"), 159, 106, -16764109, false);
		guiGraphics.drawString(this.font,

				ObsessionLevelOutPutProcedure.execute(entity), 150, 106, -12829636, false);
		guiGraphics.drawString(this.font,

				OutPutProcedure.execute(entity), 63, -1, -16764109, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		imagebutton_plus_1 = new ImageButton(this.leftPos + 132, this.topPos + 115, 19, 19, 0, 0, 19, new ResourceLocation("deathnote:textures/screens/atlas/imagebutton_plus_1.png"), 19, 38, e -> {
			if (true) {
				DeathnoteMod.PACKET_HANDLER.sendToServer(new ObsessionGUIButtonMessage(0, x, y, z));
				ObsessionGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_plus_1", imagebutton_plus_1);
		this.addRenderableWidget(imagebutton_plus_1);
		imagebutton_minus_1 = new ImageButton(this.leftPos + 168, this.topPos + 115, 19, 19, 0, 0, 19, new ResourceLocation("deathnote:textures/screens/atlas/imagebutton_minus_1.png"), 19, 38, e -> {
			if (true) {
				DeathnoteMod.PACKET_HANDLER.sendToServer(new ObsessionGUIButtonMessage(1, x, y, z));
				ObsessionGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_minus_1", imagebutton_minus_1);
		this.addRenderableWidget(imagebutton_minus_1);
		imagebutton_accept2 = new ImageButton(this.leftPos + 60, this.topPos + 142, 55, 21, 0, 0, 21, new ResourceLocation("deathnote:textures/screens/atlas/imagebutton_accept2.png"), 55, 42, e -> {
			if (ShowObsessionButtProcedure.execute(entity)) {
				DeathnoteMod.PACKET_HANDLER.sendToServer(new ObsessionGUIButtonMessage(2, x, y, z));
				ObsessionGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (ShowObsessionButtProcedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_accept2", imagebutton_accept2);
		this.addRenderableWidget(imagebutton_accept2);
		imagebutton_dismiss = new ImageButton(this.leftPos + 51, this.topPos + 163, 73, 21, 0, 0, 21, new ResourceLocation("deathnote:textures/screens/atlas/imagebutton_dismiss.png"), 73, 42, e -> {
			if (ShowObsessionDeclineProcedure.execute(entity)) {
				DeathnoteMod.PACKET_HANDLER.sendToServer(new ObsessionGUIButtonMessage(3, x, y, z));
				ObsessionGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (ShowObsessionDeclineProcedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_dismiss", imagebutton_dismiss);
		this.addRenderableWidget(imagebutton_dismiss);
	}
}
