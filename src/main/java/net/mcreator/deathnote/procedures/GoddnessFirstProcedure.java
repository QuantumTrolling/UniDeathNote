package net.mcreator.deathnote.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;

import net.mcreator.deathnote.DeathnoteMod;

public class GoddnessFirstProcedure {
	public static void execute(LevelAccessor world) {
		DeathnoteMod.queueServerWork(20, () -> {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(
						"[\u00A75\u0412\u0435\u043B\u0438\u043A\u0438\u0439 \u0434\u0443\u0445 (\u0411\u043E\u0433\u0438\u043D\u044F \u0441\u043C\u0435\u0440\u0442\u0438)\u00A7f] - \uD800\uDF34\uA640\uD800\uDF41\uA640 `\u00D7`\uD800\uDF40`\uA855 = \uD800\uDD18`\u03B6'\uD800\uDD17 \uD800\uDD14# \uD804\uDC0C`\u00D7\uD800\uDD16\uD800\uDD12"),
						false);
		});
	}
}
