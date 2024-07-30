
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.deathnote.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.deathnote.client.model.ModelUniGhostClone;
import net.mcreator.deathnote.client.model.ModelUniGhost;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class DeathnoteModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModelUniGhostClone.LAYER_LOCATION, ModelUniGhostClone::createBodyLayer);
		event.registerLayerDefinition(ModelUniGhost.LAYER_LOCATION, ModelUniGhost::createBodyLayer);
	}
}
