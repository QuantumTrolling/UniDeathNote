package net.mcreator.deathnote.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;

import net.mcreator.deathnote.DeathnoteMod;

public class GoddnessFirstProcedure {
	public static void execute(LevelAccessor world) {
		DeathnoteMod.queueServerWork(20, () -> {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(
						"[\u0412\u0435\u043B\u0438\u043A\u0438\u0439 \u0434\u0443\u0445 (\u0411\u043E\u0433\u0438\u043D\u044F \u0441\u043C\u0435\u0440\u0442\u0438)] - l\u0302\u030E\u0301\u0361\u0342\u0345\u0362\u0328\u0329\u032Aa\u0309\u033D\u0357\u0305\u033B\u0325\u031C\u0331d\u0314\u0315\u0329\u0339f\u030E\u0308\u0314\u0325\u035F\u034Dnl\u0303\u0308\u0313\u0346\u0305\u033B\u0333\u0356\u0320\u0348s\u0312\u0310\u035D\u031E\u035F\u0353k\u0300\u0360\u035E\u030F\u0305\u031C\u0332\u0323\u0317\u0329a\u0308\u030E\u0313\u0357\u032D\u0319\u0317\u032Ds\u031A\u031B\u0358\u0333\u0356\u0347a\u035B\u0352\u033E\u0307\u0331\u0353\u0345\u0348s\u0306\u030B\u0360\u035A\u0327\u031Ff\u033D\u030A\u030F\u0313\u033A\u0328\u0329\u0347"),
						false);
		});
	}
}
