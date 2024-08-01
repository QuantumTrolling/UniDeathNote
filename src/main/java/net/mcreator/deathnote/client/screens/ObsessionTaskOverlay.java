
package net.mcreator.deathnote.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;

import net.mcreator.deathnote.procedures.ShowSoulSplitTaskProcedure;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class ObsessionTaskOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		int posX = w / 2;
		int posY = h / 2;
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		if (ShowSoulSplitTaskProcedure.execute(entity)) {
			event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.deathnote.obsession_task.label_zadacha_miertvietskii_gholod_sies"), posX + -234, posY + -112, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.deathnote.obsession_task.label_siest_ghniluiu_plot"), posX + -234, posY + -103, -1, false);
		}
	}
}
