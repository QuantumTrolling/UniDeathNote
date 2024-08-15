package net.mcreator.deathnote.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;

import net.mcreator.deathnote.DeathnoteMod;

public class GhostlyHungerSpeechProcedure {
	public static void execute(LevelAccessor world) {
		DeathnoteMod.queueServerWork(20, () -> {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(
						"[\u00A75\u0412\u0435\u043B\u0438\u043A\u0438\u0439 \u0434\u0443\u0445 (\u0411\u043E\u0433\u0438\u043D\u044F \u0441\u043C\u0435\u0440\u0442\u0438)\u00A7f] - \u0417\u0430\u0431\u043B\u0443\u0434\u0448\u0430\u044F \u0434\u0443\u0448\u0430, \u0437\u0430\u0441\u0442\u0440\u044F\u0432 \u0432 \u0441\u043E\u0441\u0442\u043E\u044F\u043D\u0438\u0435 \u043C\u0435\u0436\u0434\u0443 \u0436\u0438\u0437\u043D\u044C\u044E \u0438 \u0441\u043C\u0435\u0440\u0442\u0438, \u0442\u044B \u0434\u043E\u043B\u0436\u043D\u0430 \u0432\u0441\u0435 \u0431\u043E\u043B\u044C\u0448\u0435 \u043F\u0440\u0438\u0431\u043B\u0438\u0436\u0430\u0442\u044C\u0441\u044F \u043A \u043C\u0438\u0440\u0443 \u043C\u0435\u0440\u0442\u0432\u044B\u0445, \u0447\u0442\u043E\u0431\u044B \u043E\u0431\u0440\u0435\u0441\u0442\u0438 \u0448\u0430\u043D\u0441 \u043D\u0430 \u0432\u043E\u0437\u0440\u043E\u0436\u0434\u0435\u043D\u0438\u0435. \u0422\u0440\u0443\u043F\u043D\u0430\u044F \u043F\u043B\u043E\u0442\u044C \u043B\u0438\u0448\u044C \u043F\u0440\u0438\u0431\u043B\u0438\u0437\u0438\u043B\u0430 \u0442\u0435\u0431\u044F \u043A \u044D\u0442\u043E\u043C\u0443, \u043E\u0442\u043D\u044B\u043D\u0435 \u043F\u0438\u0449\u0430 \u0442\u0435\u0431\u0435 \u043D\u0435 \u043D\u0443\u0436\u043D\u0430"),
						false);
		});
	}
}
