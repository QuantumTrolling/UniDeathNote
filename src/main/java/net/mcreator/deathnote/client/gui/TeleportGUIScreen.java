package net.mcreator.deathnote.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.deathnote.world.inventory.TeleportGUIMenu;
import net.mcreator.deathnote.procedures.TeleportLevelOutPutProcedure;
import net.mcreator.deathnote.procedures.ShowTeleportDeclineProcedure;
import net.mcreator.deathnote.procedures.ShowTeleportButtProcedure;
import net.mcreator.deathnote.procedures.OutPutProcedure;
import net.mcreator.deathnote.network.TeleportGUIButtonMessage;
import net.mcreator.deathnote.DeathnoteMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class TeleportGUIScreen extends AbstractContainerScreen<TeleportGUIMenu> {
	private final static HashMap<String, Object> guistate = TeleportGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_plus_1;
	ImageButton imagebutton_minus_1;
	ImageButton imagebutton_accept2;
	ImageButton imagebutton_dismiss;

	public TeleportGUIScreen(TeleportGUIMenu container, Inventory inventory, Component text) {
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

		guiGraphics.blit(new ResourceLocation("deathnote:textures/screens/gui_final.png"), this.leftPos + -83, this.topPos + -11, 0, 0, 355, 182, 355, 182);

		guiGraphics.blit(new ResourceLocation("deathnote:textures/screens/disembodied_movement.png"), this.leftPos + 135, this.topPos + 20, 0, 0, 64, 64, 64, 64);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.teleport_gui.label_prizrachnyi_gholod"), -38, 7, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.teleport_gui.label_tvoi_gholod_vospolniaietsia_sam_1"), -38, 34, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.teleport_gui.label_ieda_bolshie_nie_vospolniaiet_tiebie"), -38, 70, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.teleport_gui.label_prokachka_1_ied_sytosti_v_minutu"), -38, 88, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.teleport_gui.label_na_niekotoroie_vriemia"), -38, 43, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.teleport_gui.label_1_siekunda_polieta_03_siekundy"), -38, 106, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.teleport_gui.label_5"), 168, 106, -16764109, false);
		guiGraphics.drawString(this.font,

				TeleportLevelOutPutProcedure.execute(entity), 159, 106, -16764109, false);
		guiGraphics.drawString(this.font,

				OutPutProcedure.execute(entity), 72, -1, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.teleport_gui.label_da_smotritie"), -38, 52, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.teleport_gui.label_niie"), -38, 16, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.teleport_gui.label_knopka_aktivatsii_4"), -38, 124, -16764109, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		imagebutton_plus_1 = new ImageButton(this.leftPos + 141, this.topPos + 115, 19, 19, 0, 0, 19, new ResourceLocation("deathnote:textures/screens/atlas/imagebutton_plus_1.png"), 19, 38, e -> {
			if (true) {
				DeathnoteMod.PACKET_HANDLER.sendToServer(new TeleportGUIButtonMessage(0, x, y, z));
				TeleportGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_plus_1", imagebutton_plus_1);
		this.addRenderableWidget(imagebutton_plus_1);
		imagebutton_minus_1 = new ImageButton(this.leftPos + 177, this.topPos + 115, 19, 19, 0, 0, 19, new ResourceLocation("deathnote:textures/screens/atlas/imagebutton_minus_1.png"), 19, 38, e -> {
			if (true) {
				DeathnoteMod.PACKET_HANDLER.sendToServer(new TeleportGUIButtonMessage(1, x, y, z));
				TeleportGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_minus_1", imagebutton_minus_1);
		this.addRenderableWidget(imagebutton_minus_1);
		imagebutton_accept2 = new ImageButton(this.leftPos + 60, this.topPos + 142, 55, 21, 0, 0, 21, new ResourceLocation("deathnote:textures/screens/atlas/imagebutton_accept2.png"), 55, 42, e -> {
			if (ShowTeleportButtProcedure.execute(entity)) {
				DeathnoteMod.PACKET_HANDLER.sendToServer(new TeleportGUIButtonMessage(2, x, y, z));
				TeleportGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (ShowTeleportButtProcedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_accept2", imagebutton_accept2);
		this.addRenderableWidget(imagebutton_accept2);
		imagebutton_dismiss = new ImageButton(this.leftPos + 51, this.topPos + 160, 73, 21, 0, 0, 21, new ResourceLocation("deathnote:textures/screens/atlas/imagebutton_dismiss.png"), 73, 42, e -> {
			if (ShowTeleportDeclineProcedure.execute(entity)) {
				DeathnoteMod.PACKET_HANDLER.sendToServer(new TeleportGUIButtonMessage(3, x, y, z));
				TeleportGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (ShowTeleportDeclineProcedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_dismiss", imagebutton_dismiss);
		this.addRenderableWidget(imagebutton_dismiss);
	}
}
