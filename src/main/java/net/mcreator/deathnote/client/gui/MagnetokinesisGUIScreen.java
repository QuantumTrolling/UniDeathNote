package net.mcreator.deathnote.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.deathnote.world.inventory.MagnetokinesisGUIMenu;
import net.mcreator.deathnote.procedures.OutPutProcedure;
import net.mcreator.deathnote.procedures.MagnitokinesisLevelOutPutProcedure;
import net.mcreator.deathnote.network.MagnetokinesisGUIButtonMessage;
import net.mcreator.deathnote.DeathnoteMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class MagnetokinesisGUIScreen extends AbstractContainerScreen<MagnetokinesisGUIMenu> {
	private final static HashMap<String, Object> guistate = MagnetokinesisGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_priniat;
	Button button_empty;
	Button button_empty1;

	public MagnetokinesisGUIScreen(MagnetokinesisGUIMenu container, Inventory inventory, Component text) {
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

		guiGraphics.blit(new ResourceLocation("deathnote:textures/screens/guilonglong.png"), this.leftPos + -74, this.topPos + 7, 0, 0, 339, 165, 339, 165);

		guiGraphics.blit(new ResourceLocation("deathnote:textures/screens/magnetogenesis.png"), this.leftPos + 60, this.topPos + -38, 0, 0, 64, 64, 64, 64);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.magnetokinesis_gui.label_prizrachnyi_gholod"), -29, 25, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.magnetokinesis_gui.label_tvoi_gholod_vospolniaietsia_sam_1"), -29, 43, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.magnetokinesis_gui.label_ieda_bolshie_nie_vospolniaiet_tiebie"), -29, 97, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.magnetokinesis_gui.label_prokachka_1_ied_sytosti_v_minutu"), 114, 25, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.magnetokinesis_gui.label_zhielieznoi_rudoi"), -29, 79, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.magnetokinesis_gui.label_riadom_s_vami"), -29, 61, -12829636, false);
		guiGraphics.drawString(this.font,

				MagnitokinesisLevelOutPutProcedure.execute(entity), 168, 25, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.magnetokinesis_gui.label_3"), 177, 25, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.magnetokinesis_gui.label_5_ruda_1_siekunda_kd"), 114, 43, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.magnetokinesis_gui.label_otkata"), 114, 61, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.magnetokinesis_gui.label_ochki"), 141, 106, -16764109, false);
		guiGraphics.drawString(this.font,

				OutPutProcedure.execute(entity), 168, 106, -16764109, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_priniat = Button.builder(Component.translatable("gui.deathnote.magnetokinesis_gui.button_priniat"), e -> {
			if (true) {
				DeathnoteMod.PACKET_HANDLER.sendToServer(new MagnetokinesisGUIButtonMessage(0, x, y, z));
				MagnetokinesisGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 60, this.topPos + 142, 61, 20).build();
		guistate.put("button:button_priniat", button_priniat);
		this.addRenderableWidget(button_priniat);
		button_empty = Button.builder(Component.translatable("gui.deathnote.magnetokinesis_gui.button_empty"), e -> {
			if (true) {
				DeathnoteMod.PACKET_HANDLER.sendToServer(new MagnetokinesisGUIButtonMessage(1, x, y, z));
				MagnetokinesisGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 132, this.topPos + 79, 30, 20).build();
		guistate.put("button:button_empty", button_empty);
		this.addRenderableWidget(button_empty);
		button_empty1 = Button.builder(Component.translatable("gui.deathnote.magnetokinesis_gui.button_empty1"), e -> {
			if (true) {
				DeathnoteMod.PACKET_HANDLER.sendToServer(new MagnetokinesisGUIButtonMessage(2, x, y, z));
				MagnetokinesisGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 177, this.topPos + 79, 30, 20).build();
		guistate.put("button:button_empty1", button_empty1);
		this.addRenderableWidget(button_empty1);
	}
}
