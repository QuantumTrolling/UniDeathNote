package net.mcreator.deathnote.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.deathnote.network.DeathnoteModVariables;
import net.mcreator.deathnote.DeathnoteMod;

public class SoulSplitCDProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		{
			boolean _setval = true;
			entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.SoulSplitCD = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		DeathnoteMod.queueServerWork((int) (20 * (3 - 0.3 * (entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DeathnoteModVariables.PlayerVariables())).SoulSplitLevel)), () -> {
			{
				boolean _setval = false;
				entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.SoulSplitCD = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		});
	}
}
