package net.mcreator.deathnote.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.deathnote.world.inventory.SoulSplitMenu;
import net.mcreator.deathnote.procedures.SoulSplitLevelOutPutProcedure;
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
	Button button_priniat;
	Button button_empty;
	Button button_empty1;

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

		guiGraphics.blit(new ResourceLocation("deathnote:textures/screens/guilonglong.png"), this.leftPos + -83, this.topPos + 7, 0, 0, 339, 165, 339, 165);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.soul_split.label_prizrachnyi_gholod"), -38, 25, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.soul_split.label_tvoi_gholod_vospolniaietsia_sam_1"), -38, 43, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.soul_split.label_ieda_bolshie_nie_vospolniaiet_tiebie"), -38, 97, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.soul_split.label_prokachka_1_ied_sytosti_v_minutu"), 96, 25, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.soul_split.label_budut_atakovat_mobov"), -38, 61, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.soul_split.label_poluchaietie_uron_v_razmierie_3_sierdie"), -38, 133, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.soul_split.label_atakovat_mobov"), -38, 79, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.soul_split.label_etoi_sposobnosti_vy"), -38, 115, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.soul_split.label_razmierie_3_sierdiechiek"), -38, 151, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.soul_split.label_1_klon_1_siekunda_dlitielnosti"), 96, 43, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.soul_split.label_1_siekunda_otkata_2_urona"), 96, 61, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.soul_split.label_1_siekunda_otkata_2_urona1"), 96, 79, -12829636, false);
		guiGraphics.drawString(this.font,

				SoulSplitLevelOutPutProcedure.execute(entity), 159, 25, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.soul_split.label_3"), 168, 25, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.soul_split.label_ochki"), 123, 124, -16764109, false);
		guiGraphics.drawString(this.font,

				OutPutProcedure.execute(entity), 150, 124, -16764109, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_priniat = Button.builder(Component.translatable("gui.deathnote.soul_split.button_priniat"), e -> {
			if (true) {
				DeathnoteMod.PACKET_HANDLER.sendToServer(new SoulSplitButtonMessage(0, x, y, z));
				SoulSplitButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 60, this.topPos + 142, 61, 20).build();
		guistate.put("button:button_priniat", button_priniat);
		this.addRenderableWidget(button_priniat);
		button_empty = Button.builder(Component.translatable("gui.deathnote.soul_split.button_empty"), e -> {
			if (true) {
				DeathnoteMod.PACKET_HANDLER.sendToServer(new SoulSplitButtonMessage(1, x, y, z));
				SoulSplitButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 114, this.topPos + 97, 30, 20).build();
		guistate.put("button:button_empty", button_empty);
		this.addRenderableWidget(button_empty);
		button_empty1 = Button.builder(Component.translatable("gui.deathnote.soul_split.button_empty1"), e -> {
			if (true) {
				DeathnoteMod.PACKET_HANDLER.sendToServer(new SoulSplitButtonMessage(2, x, y, z));
				SoulSplitButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 159, this.topPos + 97, 30, 20).build();
		guistate.put("button:button_empty1", button_empty1);
		this.addRenderableWidget(button_empty1);
	}
}
