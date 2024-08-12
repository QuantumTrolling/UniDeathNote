package net.mcreator.deathnote.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.deathnote.world.inventory.SoulSplitMenu;
import net.mcreator.deathnote.procedures.SoulSplitLevelOutPutProcedure;
import net.mcreator.deathnote.procedures.ShowSoulSplitButtonProcedure;
import net.mcreator.deathnote.procedures.OutPutProcedure;
import net.mcreator.deathnote.network.SoulSplitButtonMessage;
import net.mcreator.deathnote.DeathnoteMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class SoulSplitScreen extends AbstractContainerScreen<SoulSplitMenu> {
	private final static HashMap<String, Object> guistate = SoulSplitMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_plus_1;
	ImageButton imagebutton_minus_1;
	ImageButton imagebutton_accept2;

	public SoulSplitScreen(SoulSplitMenu container, Inventory inventory, Component text) {
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

		guiGraphics.blit(new ResourceLocation("deathnote:textures/screens/splitting_soul.png"), this.leftPos + 132, this.topPos + 25, 0, 0, 64, 64, 64, 64);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.soul_split.label_prizrachnyi_gholod"), -38, 7, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.soul_split.label_tvoi_gholod_vospolniaietsia_sam_1"), -38, 25, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.soul_split.label_ieda_bolshie_nie_vospolniaiet_tiebie"), -38, 61, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.soul_split.label_prokachka_1_ied_sytosti_v_minutu"), -38, 106, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.soul_split.label_budut_atakovat_mobov"), -38, 34, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.soul_split.label_poluchaietie_uron_v_razmierie_3_sierdie"), -38, 79, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.soul_split.label_atakovat_mobov"), -38, 43, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.soul_split.label_etoi_sposobnosti_vy"), -38, 70, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.soul_split.label_razmierie_3_sierdiechiek"), -38, 88, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.soul_split.label_1_klon_1_siekunda_dlitielnosti"), -38, 124, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.soul_split.label_1_siekunda_otkata_2_urona"), -38, 133, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.soul_split.label_1_siekunda_otkata_2_urona1"), -38, 142, -12829636, false);
		guiGraphics.drawString(this.font,

				SoulSplitLevelOutPutProcedure.execute(entity), 159, 106, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.soul_split.label_3"), 168, 106, -16764109, false);
		guiGraphics.drawString(this.font,

				OutPutProcedure.execute(entity), 69, -2, -16764109, false);
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
				DeathnoteMod.PACKET_HANDLER.sendToServer(new SoulSplitButtonMessage(0, x, y, z));
				SoulSplitButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_plus_1", imagebutton_plus_1);
		this.addRenderableWidget(imagebutton_plus_1);
		imagebutton_minus_1 = new ImageButton(this.leftPos + 177, this.topPos + 115, 19, 19, 0, 0, 19, new ResourceLocation("deathnote:textures/screens/atlas/imagebutton_minus_1.png"), 19, 38, e -> {
			if (true) {
				DeathnoteMod.PACKET_HANDLER.sendToServer(new SoulSplitButtonMessage(1, x, y, z));
				SoulSplitButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_minus_1", imagebutton_minus_1);
		this.addRenderableWidget(imagebutton_minus_1);
		imagebutton_accept2 = new ImageButton(this.leftPos + 60, this.topPos + 142, 55, 21, 0, 0, 21, new ResourceLocation("deathnote:textures/screens/atlas/imagebutton_accept2.png"), 55, 42, e -> {
			if (ShowSoulSplitButtonProcedure.execute(entity)) {
				DeathnoteMod.PACKET_HANDLER.sendToServer(new SoulSplitButtonMessage(2, x, y, z));
				SoulSplitButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (ShowSoulSplitButtonProcedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_accept2", imagebutton_accept2);
		this.addRenderableWidget(imagebutton_accept2);
	}
}
