package net.mcreator.deathnote.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;

import net.mcreator.deathnote.DeathnoteMod;

public class UndertakerSpeechProcedure {
	public static void execute(LevelAccessor world) {
		DeathnoteMod.queueServerWork(20, () -> {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(
						"[\u00A70\u0413\u0440\u043E\u0431\u043E\u0432\u0449\u0438\u043A\u00A7f] - \u041E\u0445 \u0442\u044B \u0436 \u0447\u0435\u0440\u0442 \u0442\u0435\u0431\u044F \u0434\u0435\u0440\u0438! \u041F\u0440\u0438\u0437\u0440\u0430\u043A!"),
						false);
			DeathnoteMod.queueServerWork(90, () -> {
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(
							Component.literal("[\u00A70\u0413\u0440\u043E\u0431\u043E\u0432\u0449\u0438\u043A\u00A7f] - \u0422\u0430\u043A\u043E\u0439 \u0440\u0435\u0430\u043A\u0446\u0438\u044F \u0442\u044B \u0436\u0434\u0430\u043B\u0430?"), false);
				DeathnoteMod.queueServerWork(140, () -> {
					if (!world.isClientSide() && world.getServer() != null)
						world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("[\u00A70\u0413\u0440\u043E\u0431\u043E\u0432\u0449\u0438\u043A\u00A7f] - \u0425\u0430-\u0445\u0430-\u0445\u0430-\u0445\u0430!"), false);
					DeathnoteMod.queueServerWork(60, () -> {
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(
									"[\u00A70\u0413\u0440\u043E\u0431\u043E\u0432\u0449\u0438\u043A\u00A7f] - \u0422\u0443\u0442 \u043C\u0435\u0440\u0442\u0432\u0435\u0446\u044B \u043F\u043E \u043D\u043E\u0447\u0430\u043C \u0438\u0437 \u043C\u043E\u0433\u0438\u043B \u043F\u043E\u0434\u043D\u0438\u043C\u0430\u044E\u0442\u0441\u044F, \u0437\u043E\u043C\u0431\u0438, \u0441\u043A\u0435\u043B\u0435\u0442\u044B\u2026 \u0410 \u044F \u043F\u0440\u0438\u0437\u0440\u0430\u043A\u0443 \u0434\u043E\u043B\u0436\u0435\u043D \u0443\u0434\u0438\u0432\u0438\u0442\u044C\u0441\u044F?"),
									false);
						DeathnoteMod.queueServerWork(120, () -> {
							if (!world.isClientSide() && world.getServer() != null)
								world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(
										"[\u00A70\u0413\u0440\u043E\u0431\u043E\u0432\u0449\u0438\u043A\u00A7f] - \u0423 \u043C\u0435\u043D\u044F \u0434\u043B\u044F \u0442\u0435\u0431\u044F \u0440\u0430\u0431\u043E\u0442\u0435\u043D\u043A\u0430, \u043F\u043E\u043C\u043E\u0436\u0435\u0448\u044C \u043C\u043D\u0435, \u0430 \u044F \u0442\u0435\u0431\u0435"),
										false);
							DeathnoteMod.queueServerWork(90, () -> {
								if (!world.isClientSide() && world.getServer() != null)
									world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(
											"[\u00A70\u0413\u0440\u043E\u0431\u043E\u0432\u0449\u0438\u043A\u00A7f] - \u041A\u0430\u043A \u0432\u0438\u0434\u0438\u0448\u044C \u0443 \u043C\u0435\u043D\u044F \u043D\u0430 \u0440\u0430\u0431\u043E\u0442\u0435 \u043E\u0432\u0440\u0430\u043B, \u0442\u0443\u0442 \u044D\u0442\u0438\u0445 \u043C\u0435\u0440\u0442\u0432\u0435\u0446\u043E\u0432 \u043A\u0443\u0440\u044B \u043D\u0435 \u043A\u043B\u044E\u044E\u0442, \u0430 \u043C\u043D\u0435 \u0431\u044B \u0440\u0430\u0437 \u043D\u0435 \u043D\u0430 \u043A\u043B\u0430\u0434\u0431\u0438\u0449\u0435 \u043F\u043E\u0443\u0436\u0438\u043D\u0430\u0442\u044C, \u044D\u0442\u043E\u0439 \u043D\u043E\u0447\u044C\u044E \u0434\u043B\u044F \u043C\u0435\u043D\u044F \u0441\u043E\u0431\u0435\u0440\u0438 \u043D\u0435\u0443\u043F\u043E\u043A\u043E\u0435\u043D\u043D\u0443\u044E \u043D\u0435\u0436\u0438\u0442\u044C \u0438 \u0441\u0433\u0440\u0435\u0431\u0438 \u0441\u044E\u0434\u0430"),
											false);
							});
						});
					});
				});
			});
		});
	}
}
