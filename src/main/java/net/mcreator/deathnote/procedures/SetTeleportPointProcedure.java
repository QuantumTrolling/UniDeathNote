package net.mcreator.deathnote.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.deathnote.network.DeathnoteModVariables;

public class SetTeleportPointProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		DeathnoteModVariables.WorldVariables.get(world).TeleportX = entity.getX();
		DeathnoteModVariables.WorldVariables.get(world).syncData(world);
		DeathnoteModVariables.WorldVariables.get(world).TeleportY = entity.getY();
		DeathnoteModVariables.WorldVariables.get(world).syncData(world);
		DeathnoteModVariables.WorldVariables.get(world).TeleportZ = entity.getZ();
		DeathnoteModVariables.WorldVariables.get(world).syncData(world);
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList().broadcastSystemMessage(
					Component.literal((DeathnoteModVariables.WorldVariables.get(world).TeleportX + " " + DeathnoteModVariables.WorldVariables.get(world).TeleportY + " " + DeathnoteModVariables.WorldVariables.get(world).TeleportZ)), false);
	}
}
