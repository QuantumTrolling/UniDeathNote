package net.mcreator.deathnote.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.deathnote.world.inventory.VengefulSpiritGUIMenu;
import net.mcreator.deathnote.network.DeathnoteModVariables;

public class ShowVengefulSpiritFinalTaskProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DeathnoteModVariables.PlayerVariables())).VengefulspiritButton
				&& !(entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DeathnoteModVariables.PlayerVariables())).VengefulSpirit
				&& (entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DeathnoteModVariables.PlayerVariables())).haveGraverPage) {
			return true;
		} else if (entity instanceof Player _plr0 && _plr0.containerMenu instanceof VengefulSpiritGUIMenu
				&& !(entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DeathnoteModVariables.PlayerVariables())).VengefulSpirit
				&& (entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DeathnoteModVariables.PlayerVariables())).haveGraverPage && ShowVengefulSpiritButtonProcedure.execute(entity)) {
			return true;
		}
		return false;
	}
}
