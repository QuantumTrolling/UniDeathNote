package net.mcreator.deathnote.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;

import net.mcreator.deathnote.DeathnoteMod;

public class GoddnessGreetingProcedure {
	public static void execute(LevelAccessor world) {
		DeathnoteMod.queueServerWork(20, () -> {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(
						"[\u00A75\u0412\u0435\u043B\u0438\u043A\u0438\u0439 \u0434\u0443\u0445 (\u0411\u043E\u0433\u0438\u043D\u044F \u0441\u043C\u0435\u0440\u0442\u0438)\u00A7f] - \u041F\u0440\u0438\u0432\u0435\u0442\u0441\u0442\u0432\u0443\u044E \u0442\u0435\u0431\u044F, \u0434\u043E\u0447\u044C \u0447\u0435\u043B\u043E\u0432\u0435\u0447\u0435\u0441\u043A\u043E\u0433\u043E \u043C\u0438\u0440\u0430."),
						false);
			DeathnoteMod.queueServerWork(90, () -> {
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(
							"[\u00A75\u0412\u0435\u043B\u0438\u043A\u0438\u0439 \u0434\u0443\u0445 (\u0411\u043E\u0433\u0438\u043D\u044F \u0441\u043C\u0435\u0440\u0442\u0438)\u00A7f] - \u0422\u043E, \u0447\u0442\u043E \u0442\u044B \u043E\u0431\u043D\u0430\u0440\u0443\u0436\u0438\u043B\u0430, \u043D\u0435\u0441\u0435\u0442 \u0432 \u0441\u0435\u0431\u0435 \u0441\u0438\u043B\u0443 \u0438 \u0442\u0430\u0439\u043D\u0443, \u043E\u0442\u0440\u0430\u0436\u0430\u044E\u0449\u0443\u044E \u0442\u0432\u043E\u0435 \u0441\u043E\u0431\u0441\u0442\u0432\u0435\u043D\u043D\u043E\u0435 \u043D\u0435\u0434\u043E\u043B\u0433\u043E\u0432\u0435\u0447\u043D\u043E\u0435 \u0441\u0443\u0449\u0435\u0441\u0442\u0432\u043E\u0432\u0430\u043D\u0438\u0435"),
							false);
				DeathnoteMod.queueServerWork(110, () -> {
					if (!world.isClientSide() && world.getServer() != null)
						world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(
								"[\u00A75\u0412\u0435\u043B\u0438\u043A\u0438\u0439 \u0434\u0443\u0445 (\u0411\u043E\u0433\u0438\u043D\u044F \u0441\u043C\u0435\u0440\u0442\u0438)\u00A7f] - \u0412\u0441\u0435 \u0436\u0438\u0432\u043E\u0435 \u043E\u0434\u043D\u0430\u0436\u0434\u044B \u043F\u0440\u0438\u0445\u043E\u0434\u0438\u0442 \u043A\u043E \u043C\u043D\u0435, \u0438 \u044F \u0437\u0430\u043F\u0438\u0441\u044B\u0432\u0430\u044E \u0438\u0445 \u0438\u0441\u0442\u043E\u0440\u0438\u0438 \u0432 \u044D\u0442\u0443 \u043A\u043D\u0438\u0433\u0443."),
								false);
					DeathnoteMod.queueServerWork(110, () -> {
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(
									"[\u00A75\u0412\u0435\u043B\u0438\u043A\u0438\u0439 \u0434\u0443\u0445 (\u0411\u043E\u0433\u0438\u043D\u044F \u0441\u043C\u0435\u0440\u0442\u0438)\u00A7f] - \u0422\u044B \u043F\u043E\u0442\u043E\u0440\u043E\u043F\u0438\u043B\u0430 \u0441\u043E\u0431\u044B\u0442\u0438\u044F \u0438 \u0437\u0430\u0441\u0442\u0440\u044F\u043B\u0430 \u0443 \u0432\u043E\u0440\u043E\u0442 \u0446\u0430\u0440\u0441\u0442\u0432\u0430 \u043C\u0435\u0440\u0442\u0432\u044B\u0445, \u0442\u0435\u043F\u0435\u0440\u044C \u0442\u044B \u043F\u0440\u043E\u0432\u043E\u0434\u0438\u0448\u044C \u0432\u0435\u0447\u043D\u043E\u0441\u0442\u044C \u0441\u043A\u0438\u0442\u0430\u044F\u0441\u044C \u0443 \u043D\u0438\u0445 \u0432 \u043E\u0431\u043B\u0438\u043A\u0435 \u0434\u0443\u0445\u0430"),
									false);
						DeathnoteMod.queueServerWork(220, () -> {
							if (!world.isClientSide() && world.getServer() != null)
								world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(
										"[\u00A75\u0412\u0435\u043B\u0438\u043A\u0438\u0439 \u0434\u0443\u0445 (\u0411\u043E\u0433\u0438\u043D\u044F \u0441\u043C\u0435\u0440\u0442\u0438)\u00A7f] - \u0414\u0430, \u043C\u043E\u044F \u043A\u043D\u0438\u0433\u0430 \u2014 \u043A\u043B\u044E\u0447 \u043A \u043C\u043E\u0433\u0443\u0449\u0435\u0441\u0442\u0432\u0443, \u043D\u043E \u043F\u043E\u0434\u0443\u043C\u0430\u0439 \u0445\u043E\u0440\u043E\u0448\u043E, \u0434\u043E\u0447\u044C \u0447\u0435\u043B\u043E\u0432\u0435\u0447\u0435\u0441\u043A\u0430\u044F, \u043E \u0446\u0435\u043D\u0435, \u043A\u043E\u0442\u043E\u0440\u0443\u044E \u0442\u044B \u0433\u043E\u0442\u043E\u0432\u0430 \u0437\u0430\u043F\u043B\u0430\u0442\u0438\u0442\u044C \u0437\u0430 \u0432\u043E\u0437\u0432\u0440\u0430\u0449\u0435\u043D\u0438\u0435 \u043A \u043C\u0438\u0440\u0443 \u0436\u0438\u0432\u044B\u0445."),
										false);
							DeathnoteMod.queueServerWork(150, () -> {
								if (!world.isClientSide() && world.getServer() != null)
									world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(
											"[\u00A75\u0412\u0435\u043B\u0438\u043A\u0438\u0439 \u0434\u0443\u0445 (\u0411\u043E\u0433\u0438\u043D\u044F \u0441\u043C\u0435\u0440\u0442\u0438)\u00A7f] - \u041F\u0443\u0442\u0438 \u043A \u0432\u043E\u0437\u0432\u0440\u0430\u0449\u0435\u043D\u0438\u044E \u043A \u0436\u0438\u0437\u043D\u0438 \u0435\u0441\u0442\u044C \u0438 \u044D\u0442\u0430 \u043A\u043D\u0438\u0433\u0430 \u0435\u0434\u0438\u043D\u0441\u0442\u0432\u0435\u043D\u043D\u044B\u0439 \u0442\u0432\u043E\u0439 \u0448\u0430\u043D\u0441."),
											false);
								DeathnoteMod.queueServerWork(130, () -> {
									if (!world.isClientSide() && world.getServer() != null)
										world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(
												"[\u00A75\u0412\u0435\u043B\u0438\u043A\u0438\u0439 \u0434\u0443\u0445 (\u0411\u043E\u0433\u0438\u043D\u044F \u0441\u043C\u0435\u0440\u0442\u0438)\u00A7f] - \u0420\u0435\u0448\u0435\u043D\u0438\u0435 \u043B\u0435\u0436\u0438\u0442 \u0432 \u0442\u0432\u043E\u0438\u0445 \u0440\u0443\u043A\u0430\u0445, \u0438 \u043B\u0438\u0448\u044C \u0442\u044B \u0441\u0430\u043C\u0430 \u043C\u043E\u0436\u0435\u0448\u044C \u0441\u0434\u0435\u043B\u0430\u0442\u044C \u0432\u044B\u0431\u043E\u0440. \u0421\u043B\u0435\u0434\u0443\u0439 \u0441\u0432\u043E\u0435\u0439 \u0441\u0443\u0434\u044C\u0431\u0435 \u0441 \u043C\u0443\u0434\u0440\u043E\u0441\u0442\u044C\u044E, \u0434\u043E\u0447\u044C \u0447\u0435\u043B\u043E\u0432\u0435\u0447\u0435\u0441\u043A\u0430\u044F, \u0438 \u043F\u043E\u043C\u043D\u0438, \u0447\u0442\u043E \u043A\u0430\u0436\u0434\u044B\u0439 \u0432\u044B\u0431\u043E\u0440 \u043D\u0435\u0441\u0435\u0442 \u0441\u0432\u043E\u0438 \u043F\u043E\u0441\u043B\u0435\u0434\u0441\u0442\u0432\u0438\u044F."),
												false);
								});
							});
						});
					});
				});
			});
		});
	}
}
