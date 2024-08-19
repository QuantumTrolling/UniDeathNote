package net.mcreator.deathnote.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.deathnote.network.DeathnoteModVariables;

public class SetZombieSPawnPointProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		DeathnoteModVariables.WorldVariables.get(world).ZombieX = entity.getX();
		DeathnoteModVariables.WorldVariables.get(world).syncData(world);
		DeathnoteModVariables.WorldVariables.get(world).ZombieY = entity.getY();
		DeathnoteModVariables.WorldVariables.get(world).syncData(world);
		DeathnoteModVariables.WorldVariables.get(world).ZombieZ = entity.getZ();
		DeathnoteModVariables.WorldVariables.get(world).syncData(world);
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList().broadcastSystemMessage(
					Component.literal((" " + DeathnoteModVariables.WorldVariables.get(world).ZombieX + " " + DeathnoteModVariables.WorldVariables.get(world).ZombieY + " " + DeathnoteModVariables.WorldVariables.get(world).ZombieZ)), false);
	}
}
