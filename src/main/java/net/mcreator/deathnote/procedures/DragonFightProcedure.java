package net.mcreator.deathnote.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;

public class DragonFightProcedure {
	public static void execute(LevelAccessor world) {
		if (Math.random() < 0.5) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(
						"[\u00A75\u0412\u0435\u043B\u0438\u043A\u0438\u0439 \u0434\u0443\u0445 (\u0411\u043E\u0433\u0438\u043D\u044F \u0441\u043C\u0435\u0440\u0442\u0438)\u00A7f] - \u041F\u0440\u043E\u0434\u043E\u043B\u0436\u0430\u0439, \u0442\u044B \u043F\u043E\u0447\u0442\u0438 \u0443 \u0446\u0435\u043B\u0438!"),
						false);
		} else if (Math.random() < 0.4) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(
						"[\u00A75\u0412\u0435\u043B\u0438\u043A\u0438\u0439 \u0434\u0443\u0445 (\u0411\u043E\u0433\u0438\u043D\u044F \u0441\u043C\u0435\u0440\u0442\u0438)\u00A7f] - \u0414\u0440\u0430\u043A\u043E\u043D \u0441\u043B\u0430\u0431\u0435\u0435\u0442, \u044F \u0447\u0443\u0432\u0441\u0442\u0432\u0443\u044E \u044D\u0442\u043E."),
						false);
		} else {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(
						"[\u00A75\u0412\u0435\u043B\u0438\u043A\u0438\u0439 \u0434\u0443\u0445 (\u0411\u043E\u0433\u0438\u043D\u044F \u0441\u043C\u0435\u0440\u0442\u0438)\u00A7f] - \u041F\u0443\u0441\u0442\u044C \u044F\u0449\u0435\u0440\u0438\u0446\u0430 \u0437\u043D\u0430\u0435\u0442 \u0441\u0432\u043E\u0451 \u043C\u0435\u0441\u0442\u043E!"),
						false);
		}
	}
}
