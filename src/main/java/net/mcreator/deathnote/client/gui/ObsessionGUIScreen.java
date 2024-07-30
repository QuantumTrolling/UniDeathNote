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

		guiGraphics.blit(new ResourceLocation("deathnote:textures/screens/gui1.png"), this.leftPos + -38, this.topPos + -11, 0, 0, 250, 180, 250, 180);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.obsession_gui.label_prizrachnyi_gholod"), -29, -2, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.obsession_gui.label_kak_otkryt_zadacha_miertvietskii"), -29, 16, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.obsession_gui.label_tvoi_gholod_vospolniaietsia_sam_1"), -29, 52, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.obsession_gui.label_ieda_bolshie_nie_vospolniaiet_tiebie"), -29, 88, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.obsession_gui.label_prokachka_1_ied_sytosti_v_minutu"), -29, 106, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.obsession_gui.label_1_zhielieznuiu_kirku"), -29, 34, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.obsession_gui.label_budut_atakovat_mobov"), -29, 70, -1, false);
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
		}).bounds(this.leftPos + 51, this.topPos + 133, 61, 20).build();
		guistate.put("button:button_priniat", button_priniat);
		this.addRenderableWidget(button_priniat);
	}
}
