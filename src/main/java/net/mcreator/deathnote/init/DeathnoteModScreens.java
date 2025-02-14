
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
import net.mcreator.deathnote.client.gui.TeleportGUIScreen;
import net.mcreator.deathnote.client.gui.SoulSplitScreen;
import net.mcreator.deathnote.client.gui.SkilllsScreen;
import net.mcreator.deathnote.client.gui.RevivalGUIScreen;
import net.mcreator.deathnote.client.gui.ObsessionGUIScreen;
import net.mcreator.deathnote.client.gui.ManifestationGUIScreen;
import net.mcreator.deathnote.client.gui.MagnetokinesisGUIScreen;
import net.mcreator.deathnote.client.gui.LevitationGUIScreen;
import net.mcreator.deathnote.client.gui.IntangibilityGUIScreen;
import net.mcreator.deathnote.client.gui.IncorporealityGUIScreen;
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
			MenuScreens.register(DeathnoteModMenus.INCORPOREALITY_GUI.get(), IncorporealityGUIScreen::new);
			MenuScreens.register(DeathnoteModMenus.SOUL_SPLIT.get(), SoulSplitScreen::new);
			MenuScreens.register(DeathnoteModMenus.OBSESSION_GUI.get(), ObsessionGUIScreen::new);
			MenuScreens.register(DeathnoteModMenus.LEVITATION_GUI.get(), LevitationGUIScreen::new);
			MenuScreens.register(DeathnoteModMenus.TELEPORT_GUI.get(), TeleportGUIScreen::new);
			MenuScreens.register(DeathnoteModMenus.INTANGIBILITY_GUI.get(), IntangibilityGUIScreen::new);
			MenuScreens.register(DeathnoteModMenus.MANIFESTATION_GUI.get(), ManifestationGUIScreen::new);
			MenuScreens.register(DeathnoteModMenus.REVIVAL_GUI.get(), RevivalGUIScreen::new);
		});
	}
}
