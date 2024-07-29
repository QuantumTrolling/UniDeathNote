
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.deathnote.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.deathnote.network.MagnetokinesisSkillMessage;
import net.mcreator.deathnote.DeathnoteMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class DeathnoteModKeyMappings {
	public static final KeyMapping MAGNETOKINESIS_SKILL = new KeyMapping("key.deathnote.magnetokinesis_skill", GLFW.GLFW_KEY_1, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				DeathnoteMod.PACKET_HANDLER.sendToServer(new MagnetokinesisSkillMessage(0, 0));
				MagnetokinesisSkillMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(MAGNETOKINESIS_SKILL);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				MAGNETOKINESIS_SKILL.consumeClick();
			}
		}
	}
}
