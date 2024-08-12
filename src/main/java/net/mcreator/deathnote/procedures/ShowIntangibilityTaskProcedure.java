package net.mcreator.deathnote.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.deathnote.world.inventory.IntangibilityGUIMenu;
import net.mcreator.deathnote.network.DeathnoteModVariables;

public class ShowIntangibilityTaskProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DeathnoteModVariables.PlayerVariables())).IntangibilityButton
				&& !(entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DeathnoteModVariables.PlayerVariables())).Intangibility) {
			return true;
		} else if (ShowIntangibilityButtonProcedure.execute(entity) && entity instanceof Player _plr0 && _plr0.containerMenu instanceof IntangibilityGUIMenu
				&& !(entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DeathnoteModVariables.PlayerVariables())).Intangibility) {
			return true;
		}
		return false;
	}
}
