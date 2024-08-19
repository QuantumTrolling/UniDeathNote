package net.mcreator.deathnote.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.deathnote.network.DeathnoteModVariables;

public class SetUndertakerPointProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		DeathnoteModVariables.WorldVariables.get(world).UndertakerPointX = entity.getX();
		DeathnoteModVariables.WorldVariables.get(world).syncData(world);
		DeathnoteModVariables.WorldVariables.get(world).UndertakerPointY = entity.getY();
		DeathnoteModVariables.WorldVariables.get(world).syncData(world);
		DeathnoteModVariables.WorldVariables.get(world).UndertakerPointZ = entity.getZ();
		DeathnoteModVariables.WorldVariables.get(world).syncData(world);
	}
}
