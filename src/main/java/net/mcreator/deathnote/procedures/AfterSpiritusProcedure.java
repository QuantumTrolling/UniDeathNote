package net.mcreator.deathnote.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;

import net.mcreator.deathnote.DeathnoteMod;

public class AfterSpiritusProcedure {
	public static void execute(LevelAccessor world) {
		DeathnoteMod.queueServerWork(20, () -> {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(
						"[\u00A75\u0412\u0435\u043B\u0438\u043A\u0438\u0439 \u0434\u0443\u0445 (\u0411\u043E\u0433\u0438\u043D\u044F \u0441\u043C\u0435\u0440\u0442\u0438)\u00A7f] - \u042D\u0442\u043E \u0441\u043E\u0437\u0434\u0430\u043D\u0438\u0435 \u043F\u0440\u0435\u0442\u0435\u043D\u0434\u0443\u0435\u0442 \u043D\u0430 \u043C\u043E\u044E \u0432\u043B\u0430\u0441\u0442\u044C, \u0442\u044B \u0434\u043E\u043B\u0436\u043D\u0430 \u043E\u0442\u043E\u0431\u0440\u0430\u0442\u044C \u0443 \u043D\u0435\u0433\u043E \u0437\u0430\u0445\u0432\u0430\u0447\u0435\u043D\u043D\u0443\u044E \u0438\u043C \u0441\u0438\u043B\u0443"),
						false);
			DeathnoteMod.queueServerWork(240, () -> {
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(
							"[\u00A75\u0412\u0435\u043B\u0438\u043A\u0438\u0439 \u0434\u0443\u0445 (\u0411\u043E\u0433\u0438\u043D\u044F \u0441\u043C\u0435\u0440\u0442\u0438)\u00A7f] - \u0412\u0438\u0434\u0438\u0448\u044C \u043A\u0440\u0438\u0441\u0442\u0430\u043B\u043B\u044B \u043A\u043E\u0442\u043E\u0440\u044B\u0435 \u043F\u043E\u0434\u043F\u0438\u0442\u044B\u0432\u0430\u044E\u0442 \u044D\u0442\u043E \u0441\u043E\u0437\u0434\u0430\u043D\u0438\u0435?"),
							false);
				DeathnoteMod.queueServerWork(120, () -> {
					if (!world.isClientSide() && world.getServer() != null)
						world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(
								"[\u00A75\u0412\u0435\u043B\u0438\u043A\u0438\u0439 \u0434\u0443\u0445 (\u0411\u043E\u0433\u0438\u043D\u044F \u0441\u043C\u0435\u0440\u0442\u0438)\u00A7f] - \u041F\u043E\u0434\u043E\u0431\u0440\u0430\u0432\u0448\u0438\u0441\u044C \u043A \u043D\u0438\u043C \u0438\u0441\u043F\u043E\u043B\u044C\u0437\u0443\u0439 \u043D\u0430 \u043D\u0438\u0445 \u043A\u043D\u0438\u0433\u0443 \u0441\u043C\u0435\u0440\u0442\u0438, \u0442\u043E\u0433\u0434\u0430 \u043C\u044B \u0438\u0445 \u0438\u0441\u043A\u0430\u0437\u0438\u043C \u044D\u043D\u0435\u0440\u0433\u0438\u0435\u0439 \u0441\u043C\u0435\u0440\u0442\u0438 \u0438 \u0432\u043C\u0435\u0441\u0442\u043E \u043F\u043E\u0434\u043F\u0438\u0442\u044B\u0432\u0430\u043D\u0438\u044F \u0434\u0440\u0430\u043A\u043E\u043D\u0430 \u043E\u043D\u0438 \u043D\u0430\u0447\u043D\u0443\u0442 \u0438\u0441\u0441\u0443\u0448\u0430\u0442\u044C \u0435\u0433\u043E \u0442\u0435\u043B\u043E!"),
								false);
				});
			});
		});
	}
}
