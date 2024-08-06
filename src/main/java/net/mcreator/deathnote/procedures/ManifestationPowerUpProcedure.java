package net.mcreator.deathnote.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.deathnote.network.DeathnoteModVariables;

public class ManifestationPowerUpProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DeathnoteModVariables.PlayerVariables())).Manifestation
				&& (entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DeathnoteModVariables.PlayerVariables())).Points != 0
				&& (entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DeathnoteModVariables.PlayerVariables())).ManifestationLevel != 2) {
			{
				double _setval = (entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DeathnoteModVariables.PlayerVariables())).ManifestationLevel + 1;
				entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ManifestationLevel = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DeathnoteModVariables.PlayerVariables())).Points - 1;
				entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Points = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
