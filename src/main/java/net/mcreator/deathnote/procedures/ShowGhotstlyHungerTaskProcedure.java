package net.mcreator.deathnote.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.deathnote.world.inventory.GhostlyHungerGUIMenu;
import net.mcreator.deathnote.network.DeathnoteModVariables;

public class ShowGhotstlyHungerTaskProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DeathnoteModVariables.PlayerVariables())).GhostlyHungerButton
				&& !(entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DeathnoteModVariables.PlayerVariables())).GhostlyHunger) {
			return true;
		} else if (ShowGHButtonProcedure.execute(entity) && entity instanceof Player _plr0 && _plr0.containerMenu instanceof GhostlyHungerGUIMenu
				&& !(entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DeathnoteModVariables.PlayerVariables())).GhostlyHunger) {
			return true;
		}
		return false;
	}
}
