package net.mcreator.deathnote.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.deathnote.world.inventory.ManifestationGUIMenu;
import net.mcreator.deathnote.network.DeathnoteModVariables;

public class ShowManifestationTaskDopProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DeathnoteModVariables.PlayerVariables())).ManifestationButton
				&& !(entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DeathnoteModVariables.PlayerVariables())).Manifestation
				&& (entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DeathnoteModVariables.PlayerVariables())).found_soulshard) {
			return true;
		} else if (entity instanceof Player _plr0 && _plr0.containerMenu instanceof ManifestationGUIMenu
				&& !(entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DeathnoteModVariables.PlayerVariables())).Manifestation && ShowManifestationButtonProcedure.execute(entity)
				&& (entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DeathnoteModVariables.PlayerVariables())).found_soulshard) {
			return true;
		}
		return false;
	}
}
