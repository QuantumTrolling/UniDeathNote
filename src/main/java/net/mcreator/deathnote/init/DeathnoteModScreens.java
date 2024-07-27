
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.deathnote.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.deathnote.client.gui.VengefulSpiritGUIScreen;
import net.mcreator.deathnote.client.gui.SkilllsScreen;
import net.mcreator.deathnote.client.gui.MagnetokinesisGUIScreen;
import net.mcreator.deathnote.client.gui.GhostlyHungerGUIScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DeathnoteModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(DeathnoteModMenus.SKILLLS.get(), SkilllsScreen::new);
			MenuScreens.register(DeathnoteModMenus.GHOSTLY_HUNGER_GUI.get(), GhostlyHungerGUIScreen::new);
			MenuScreens.register(DeathnoteModMenus.VENGEFUL_SPIRIT_GUI.get(), VengefulSpiritGUIScreen::new);
			MenuScreens.register(DeathnoteModMenus.MAGNETOKINESIS_GUI.get(), MagnetokinesisGUIScreen::new);
		});
	}
}
