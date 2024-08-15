
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.deathnote.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.deathnote.client.renderer.UniGhostRenderer;
import net.mcreator.deathnote.client.renderer.UndertakerRenderer;
import net.mcreator.deathnote.client.renderer.CursedGhostRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DeathnoteModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(DeathnoteModEntities.UNI_GHOST.get(), UniGhostRenderer::new);
		event.registerEntityRenderer(DeathnoteModEntities.UNDERTAKER.get(), UndertakerRenderer::new);
		event.registerEntityRenderer(DeathnoteModEntities.CURSED_GHOST.get(), CursedGhostRenderer::new);
	}
}
