package net.mcreator.deathnote.procedures;

import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Entity;

import net.mcreator.deathnote.network.DeathnoteModVariables;

public class UniGhostOnEntityTickUpdateProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("AI", (1 + entity.getPersistentData().getDouble("AI")));
		if (entity.getPersistentData().getDouble(
				"AI") == (5 + ((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DeathnoteModVariables.PlayerVariables())).SoulSplitLevel)
						* 20) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}
