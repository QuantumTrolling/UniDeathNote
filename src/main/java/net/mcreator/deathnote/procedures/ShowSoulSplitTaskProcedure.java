package net.mcreator.deathnote.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.deathnote.world.inventory.SoulSplitMenu;
import net.mcreator.deathnote.network.DeathnoteModVariables;

public class ShowSoulSplitTaskProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DeathnoteModVariables.PlayerVariables())).SoulSplitButton
				&& !(entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DeathnoteModVariables.PlayerVariables())).SoulSplit) {
			return true;
		} else if (entity instanceof Player _plr0 && _plr0.containerMenu instanceof SoulSplitMenu && !(entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DeathnoteModVariables.PlayerVariables())).SoulSplit
				&& ShowSoulSplitButtProcedure.execute(entity)) {
			return true;
		}
		return false;
	}
}
