package net.mcreator.deathnote.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.deathnote.network.DeathnoteModVariables;

public class ShowTeleportButtonProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (!(entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DeathnoteModVariables.PlayerVariables())).TeleportButton) {
			return true;
		}
		return false;
	}
}
