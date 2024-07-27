package net.mcreator.deathnote.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.deathnote.network.DeathnoteModVariables;

public class TurnIntoIronProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DeathnoteModVariables.PlayerVariables())).Magnetokinesis) {
			entity.getPersistentData().putDouble("Cooldown", (entity.getPersistentData().getDouble("Cooldown") + 1));
			if (entity.getPersistentData().getDouble("Cooldown") == 20 * 3) {
				for (int index0 = 0; index0 < 3; index0++) {
					for (int index1 = 0; index1 < 3; index1++) {
					}
				}
			}
		}
	}
}
