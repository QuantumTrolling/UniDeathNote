package net.mcreator.deathnote.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;

import net.mcreator.deathnote.DeathnoteMod;

public class MagnetokinesisSpeechProcedure {
	public static void execute(LevelAccessor world) {
		DeathnoteMod.queueServerWork(20, () -> {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(
						"[\u00A75\u0412\u0435\u043B\u0438\u043A\u0438\u0439 \u0434\u0443\u0445 (\u0411\u043E\u0433\u0438\u043D\u044F \u0441\u043C\u0435\u0440\u0442\u0438)\u00A7f] - \u041C\u0430\u0433\u043D\u0438\u0442\u043E\u043A\u0438\u043D\u0435\u0437 \u2014 \u044D\u0442\u043E \u0434\u0430\u0440, \u043A\u043E\u0442\u043E\u0440\u044B\u0439 \u043F\u043E\u0437\u0432\u043E\u043B\u044F\u0435\u0442 \u0442\u0435\u0431\u0435 \u043F\u0440\u0438\u0442\u044F\u0433\u0438\u0432\u0430\u0442\u044C \u0440\u0443\u0434\u044B \u043A \u0441\u0435\u0431\u0435. \u041F\u0443\u0441\u0442\u044C \u044D\u0442\u043E \u0438 \u0443\u0436\u0430\u0441\u0430\u044E\u0449\u0438\u0439 \u0441\u043F\u043E\u0441\u043E\u0431 \u0438\u0441\u043F\u043E\u043B\u044C\u0437\u043E\u0432\u0430\u0442\u044C \u043A\u043D\u0438\u0433\u0443 \u0441\u043C\u0435\u0440\u0442\u0438 \u0434\u043B\u044F \u043D\u0430\u0431\u0438\u0432\u0430\u043D\u0438\u044F \u0441\u043E\u0431\u0441\u0442\u0432\u0435\u043D\u043D\u044B\u0445 \u043A\u0430\u0440\u043C\u0430\u043D\u043E\u0432 \u0434\u0440\u0430\u0433\u043E\u0446\u0435\u043D\u043D\u044B\u043C\u0438 \u043F\u043E\u0440\u043E\u0434\u0430\u043C\u0438, \u043D\u043E \u043D\u0430 \u044D\u0442\u043E \u043A\u043D\u0438\u0433\u0430 \u0442\u043E\u0436\u0435 \u0441\u043F\u043E\u0441\u043E\u0431\u043D\u0430"),
						false);
		});
	}
}
