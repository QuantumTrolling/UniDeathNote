package net.mcreator.deathnote.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;

import net.mcreator.deathnote.DeathnoteMod;

public class TeleportSpeechProcedure {
	public static void execute(LevelAccessor world) {
		DeathnoteMod.queueServerWork(20, () -> {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(
						"[\u00A75\u0412\u0435\u043B\u0438\u043A\u0438\u0439 \u0434\u0443\u0445 (\u0411\u043E\u0433\u0438\u043D\u044F \u0441\u043C\u0435\u0440\u0442\u0438)\u00A7f] - \u0422\u0432\u043E\u0451 \u043F\u0440\u0438\u0441\u0443\u0442\u0441\u0442\u0432\u0438\u0435 \u043D\u0430\u0447\u0430\u043B\u043E \u0440\u0430\u0441\u0441\u0435\u0438\u0432\u0430\u0442\u044C\u0441\u044F\u2026 \u0422\u0435\u0431\u044F \u043F\u043E\u0447\u0442\u0438 \u043D\u0435\u0442, \u043B\u0438\u0448\u044C \u043F\u043E\u0434\u0443\u043C\u0430\u0432 \u0442\u044B \u043F\u0435\u0440\u0435\u043C\u0435\u0449\u0430\u0435\u0448\u044C\u0441\u044F \u0432 \u0442\u043E \u043C\u0435\u0441\u0442\u043E \u0447\u0442\u043E \u0442\u043E\u043B\u044C\u043A\u043E \u0443\u0432\u0438\u0434\u0438\u0448\u044C, \u0432\u0435\u0434\u044C \u0442\u044B \u043D\u0435 \u0431\u043E\u043B\u0435\u0435 \u0447\u0435\u043C \u0441\u043E\u0431\u0441\u0442\u0432\u0435\u043D\u043D\u043E\u0435 \u043E\u0449\u0443\u0449\u0435\u043D\u0438\u0435 \u0441\u0435\u0431\u044F."),
						false);
		});
	}
}
