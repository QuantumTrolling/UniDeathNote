package net.mcreator.deathnote.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.deathnote.world.inventory.LevitationGUIMenu;
import net.mcreator.deathnote.procedures.ShowLevitationDeclineProcedure;
import net.mcreator.deathnote.procedures.ShowLevitationButtProcedure;
import net.mcreator.deathnote.procedures.OutPutProcedure;
import net.mcreator.deathnote.procedures.LevitationLevelOutPutProcedure;
import net.mcreator.deathnote.network.LevitationGUIButtonMessage;
import net.mcreator.deathnote.DeathnoteMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class LevitationGUIScreen extends AbstractContainerScreen<LevitationGUIMenu> {
	private final static HashMap<String, Object> guistate = LevitationGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_plus_1;
	ImageButton imagebutton_minus_1;
	ImageButton imagebutton_accept2;
	ImageButton imagebutton_dismiss;

	public LevitationGUIScreen(LevitationGUIMenu container, Inventory inventory, Component text) {
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

		guiGraphics.blit(new ResourceLocation("deathnote:textures/screens/levitation.png"), this.leftPos + 125, this.topPos + 20, 0, 0, 64, 64, 64, 64);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.levitation_gui.label_prizrachnyi_gholod"), -47, 7, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.levitation_gui.label_tvoi_gholod_vospolniaietsia_sam_1"), -47, 25, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.levitation_gui.label_ieda_bolshie_nie_vospolniaiet_tiebie"), -47, 52, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.levitation_gui.label_prokachka_1_ied_sytosti_v_minutu"), -47, 88, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.levitation_gui.label_na_niekotoroie_vriemia"), -47, 34, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.levitation_gui.label_mieshchaieties_po_briennoi_ziemlie"), -47, 61, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.levitation_gui.label_ziemlie"), -47, 70, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.levitation_gui.label_1_siekunda_polieta_03_siekundy"), -47, 106, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.levitation_gui.label_siekundy_otkata"), -47, 115, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.levitation_gui.label_5"), 159, 106, -16764109, false);
		guiGraphics.drawString(this.font,

				LevitationLevelOutPutProcedure.execute(entity), 150, 106, -16764109, false);
		guiGraphics.drawString(this.font,

				OutPutProcedure.execute(entity), 63, -1, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.levitation_gui.label_knopka_aktivatsii_3"), -47, 133, -16764109, false);
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
				DeathnoteMod.PACKET_HANDLER.sendToServer(new LevitationGUIButtonMessage(0, x, y, z));
				LevitationGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_plus_1", imagebutton_plus_1);
		this.addRenderableWidget(imagebutton_plus_1);
		imagebutton_minus_1 = new ImageButton(this.leftPos + 168, this.topPos + 115, 19, 19, 0, 0, 19, new ResourceLocation("deathnote:textures/screens/atlas/imagebutton_minus_1.png"), 19, 38, e -> {
			if (true) {
				DeathnoteMod.PACKET_HANDLER.sendToServer(new LevitationGUIButtonMessage(1, x, y, z));
				LevitationGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_minus_1", imagebutton_minus_1);
		this.addRenderableWidget(imagebutton_minus_1);
		imagebutton_accept2 = new ImageButton(this.leftPos + 60, this.topPos + 142, 55, 21, 0, 0, 21, new ResourceLocation("deathnote:textures/screens/atlas/imagebutton_accept2.png"), 55, 42, e -> {
			if (ShowLevitationButtProcedure.execute(entity)) {
				DeathnoteMod.PACKET_HANDLER.sendToServer(new LevitationGUIButtonMessage(2, x, y, z));
				LevitationGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (ShowLevitationButtProcedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_accept2", imagebutton_accept2);
		this.addRenderableWidget(imagebutton_accept2);
		imagebutton_dismiss = new ImageButton(this.leftPos + 51, this.topPos + 160, 73, 21, 0, 0, 21, new ResourceLocation("deathnote:textures/screens/atlas/imagebutton_dismiss.png"), 73, 42, e -> {
			if (ShowLevitationDeclineProcedure.execute(entity)) {
				DeathnoteMod.PACKET_HANDLER.sendToServer(new LevitationGUIButtonMessage(3, x, y, z));
				LevitationGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (ShowLevitationDeclineProcedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_dismiss", imagebutton_dismiss);
		this.addRenderableWidget(imagebutton_dismiss);
	}
}
