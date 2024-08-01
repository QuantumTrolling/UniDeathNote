
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

import net.mcreator.deathnote.network.TeleportBindMessage;
import net.mcreator.deathnote.network.SoulSplitBindMessage;
import net.mcreator.deathnote.network.MagnetokinesisSkillMessage;
import net.mcreator.deathnote.network.LevitationBindMessage;
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
	public static final KeyMapping SOUL_SPLIT_BIND = new KeyMapping("key.deathnote.soul_split_bind", GLFW.GLFW_KEY_2, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				DeathnoteMod.PACKET_HANDLER.sendToServer(new SoulSplitBindMessage(0, 0));
				SoulSplitBindMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping LEVITATION_BIND = new KeyMapping("key.deathnote.levitation_bind", GLFW.GLFW_KEY_3, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				DeathnoteMod.PACKET_HANDLER.sendToServer(new LevitationBindMessage(0, 0));
				LevitationBindMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping TELEPORT_BIND = new KeyMapping("key.deathnote.teleport_bind", GLFW.GLFW_KEY_4, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				DeathnoteMod.PACKET_HANDLER.sendToServer(new TeleportBindMessage(0, 0));
				TeleportBindMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(MAGNETOKINESIS_SKILL);
		event.register(SOUL_SPLIT_BIND);
		event.register(LEVITATION_BIND);
		event.register(TELEPORT_BIND);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				MAGNETOKINESIS_SKILL.consumeClick();
				SOUL_SPLIT_BIND.consumeClick();
				LEVITATION_BIND.consumeClick();
				TELEPORT_BIND.consumeClick();
			}
		}
	}
}
