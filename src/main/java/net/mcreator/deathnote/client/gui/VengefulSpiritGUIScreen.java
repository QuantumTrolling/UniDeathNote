package net.mcreator.deathnote.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.deathnote.world.inventory.VengefulSpiritGUIMenu;
import net.mcreator.deathnote.procedures.VengefulSpiritLevelOutPutProcedure;
import net.mcreator.deathnote.procedures.ShowVengefulSpiritButtonProcedure;
import net.mcreator.deathnote.procedures.OutPutProcedure;
import net.mcreator.deathnote.network.VengefulSpiritGUIButtonMessage;
import net.mcreator.deathnote.DeathnoteMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class VengefulSpiritGUIScreen extends AbstractContainerScreen<VengefulSpiritGUIMenu> {
	private final static HashMap<String, Object> guistate = VengefulSpiritGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_plus_1;
	ImageButton imagebutton_minus_1;
	ImageButton imagebutton_accept2;

	public VengefulSpiritGUIScreen(VengefulSpiritGUIMenu container, Inventory inventory, Component text) {
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

		guiGraphics.blit(new ResourceLocation("deathnote:textures/screens/vengeful_spirit.png"), this.leftPos + 135, this.topPos + 20, 0, 0, 64, 64, 64, 64);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.vengeful_spirit_gui.label_prizrachnyi_gholod"), -38, 7, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.vengeful_spirit_gui.label_tvoi_gholod_vospolniaietsia_sam_1"), -38, 25, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.vengeful_spirit_gui.label_ieda_bolshie_nie_vospolniaiet_tiebie"), -38, 79, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.vengeful_spirit_gui.label_prokachka_1_ied_sytosti_v_minutu"), -38, 106, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.vengeful_spirit_gui.label_poluchaietie_bieskoniechnyi"), -38, 34, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.vengeful_spirit_gui.label_ot_moba_kotoryi_vas_ubil"), -38, 43, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.vengeful_spirit_gui.label_ubil"), -38, 52, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.vengeful_spirit_gui.label_snizhaietsia_20_maks_zdorovia"), -38, 88, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.vengeful_spirit_gui.label_1_urovien_k_effiektu"), -38, 124, -16764109, false);
		guiGraphics.drawString(this.font,

				OutPutProcedure.execute(entity), 72, -1, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.vengeful_spirit_gui.label_5"), 168, 106, -16764109, false);
		guiGraphics.drawString(this.font,

				VengefulSpiritLevelOutPutProcedure.execute(entity), 159, 106, -16764109, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathnote.vengeful_spirit_gui.label_ubil1"), -38, 61, -16764109, false);
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
				DeathnoteMod.PACKET_HANDLER.sendToServer(new VengefulSpiritGUIButtonMessage(0, x, y, z));
				VengefulSpiritGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_plus_1", imagebutton_plus_1);
		this.addRenderableWidget(imagebutton_plus_1);
		imagebutton_minus_1 = new ImageButton(this.leftPos + 177, this.topPos + 115, 19, 19, 0, 0, 19, new ResourceLocation("deathnote:textures/screens/atlas/imagebutton_minus_1.png"), 19, 38, e -> {
			if (true) {
				DeathnoteMod.PACKET_HANDLER.sendToServer(new VengefulSpiritGUIButtonMessage(1, x, y, z));
				VengefulSpiritGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_minus_1", imagebutton_minus_1);
		this.addRenderableWidget(imagebutton_minus_1);
		imagebutton_accept2 = new ImageButton(this.leftPos + 69, this.topPos + 142, 55, 21, 0, 0, 21, new ResourceLocation("deathnote:textures/screens/atlas/imagebutton_accept2.png"), 55, 42, e -> {
			if (ShowVengefulSpiritButtonProcedure.execute(entity)) {
				DeathnoteMod.PACKET_HANDLER.sendToServer(new VengefulSpiritGUIButtonMessage(2, x, y, z));
				VengefulSpiritGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (ShowVengefulSpiritButtonProcedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_accept2", imagebutton_accept2);
		this.addRenderableWidget(imagebutton_accept2);
	}
}
