package net.mcreator.deathnote.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.deathnote.network.DeathnoteModVariables;

public class ObsessionDeclineProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			boolean _setval = false;
			entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.ObsessionButton = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
