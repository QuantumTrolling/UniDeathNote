package net.mcreator.deathnote.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.deathnote.network.DeathnoteModVariables;
import net.mcreator.deathnote.DeathnoteMod;

public class BreakingBlocksProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DeathnoteModVariables.PlayerVariables())).Manifestation
				&& !(entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DeathnoteModVariables.PlayerVariables())).ManifestationCD) {
			{
				boolean _setval = false;
				entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.IntangibilityDebuff = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			DeathnoteMod.queueServerWork((int) (20 * (3 + (entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DeathnoteModVariables.PlayerVariables())).ManifestationLevel)), () -> {
				{
					boolean _setval = true;
					entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.IntangibilityDebuff = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				ManefistationCDProcedure.execute(world, entity);
			});
		}
	}
}
