package net.mcreator.deathnote.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.deathnote.world.inventory.ObsessionGUIMenu;
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
	Button button_priniat;
	Button button_empty;
	Button button_empty1;

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

		guiGraphics.blit(new ResourceLocation("deathnote:textures/screens/guilonglong.png"), this.leftPos + -92, this.topPos + 7, 0, 0, 339, 165, 339, 165);

		guiGraphics.blit(new ResourceLocation("deathnote:textures/screens/obsession.png"), this.leftPos + 51, this.topPos + -38, 0, 0, 64, 64, 64, 64);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.obsession_gui.label_prizrachnyi_gholod"), -47, 25, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.obsession_gui.label_tvoi_gholod_vospolniaietsia_sam_1"), -47, 43, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.obsession_gui.label_ieda_bolshie_nie_vospolniaiet_tiebie"), -47, 97, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.obsession_gui.label_prokachka_1_ied_sytosti_v_minutu"), 96, 25, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.obsession_gui.label_budut_atakovat_mobov"), -47, 79, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.obsession_gui.label_bonus_50_k_nanosimomu"), -47, 61, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.obsession_gui.label_10_k_uronu"), 96, 43, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.obsession_gui.label_5"), 159, 25, -16764109, false);
		guiGraphics.drawString(this.font,

				ObsessionLevelOutPutProcedure.execute(entity), 150, 25, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.obsession_gui.label_ochki"), 105, 106, -16764109, false);
		guiGraphics.drawString(this.font,

				OutPutProcedure.execute(entity), 132, 106, -16764109, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_priniat = Button.builder(Component.translatable("gui.deathnote.obsession_gui.button_priniat"), e -> {
			if (true) {
				DeathnoteMod.PACKET_HANDLER.sendToServer(new ObsessionGUIButtonMessage(0, x, y, z));
				ObsessionGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 51, this.topPos + 142, 61, 20).build();
		guistate.put("button:button_priniat", button_priniat);
		this.addRenderableWidget(button_priniat);
		button_empty = Button.builder(Component.translatable("gui.deathnote.obsession_gui.button_empty"), e -> {
			if (true) {
				DeathnoteMod.PACKET_HANDLER.sendToServer(new ObsessionGUIButtonMessage(1, x, y, z));
				ObsessionGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 105, this.topPos + 70, 30, 20).build();
		guistate.put("button:button_empty", button_empty);
		this.addRenderableWidget(button_empty);
		button_empty1 = Button.builder(Component.translatable("gui.deathnote.obsession_gui.button_empty1"), e -> {
			if (true) {
				DeathnoteMod.PACKET_HANDLER.sendToServer(new ObsessionGUIButtonMessage(2, x, y, z));
				ObsessionGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 150, this.topPos + 70, 30, 20).build();
		guistate.put("button:button_empty1", button_empty1);
		this.addRenderableWidget(button_empty1);
	}
}
