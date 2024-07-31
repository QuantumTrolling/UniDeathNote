package net.mcreator.deathnote.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.deathnote.network.DeathnoteModVariables;

public class VengefulSpiritLevelOutPutProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "" + Mth.nextInt(RandomSource.create(), (int) ((entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DeathnoteModVariables.PlayerVariables())).VengefulSpiritLevel + 1),
				(int) ((entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DeathnoteModVariables.PlayerVariables())).VengefulSpiritLevel + 1));
	}
}
