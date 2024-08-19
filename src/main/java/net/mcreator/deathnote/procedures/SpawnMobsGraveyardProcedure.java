package net.mcreator.deathnote.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.deathnote.network.DeathnoteModVariables;

public class SpawnMobsGraveyardProcedure {
	public static void execute(LevelAccessor world) {
		if (!(DeathnoteModVariables.WorldVariables.get(world).ZombieX == 0 && DeathnoteModVariables.WorldVariables.get(world).ZombieY == 0 && DeathnoteModVariables.WorldVariables.get(world).ZombieZ == 0)) {
			for (int index0 = 0; index0 < 6; index0++) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = EntityType.ZOMBIE.spawn(_level, BlockPos.containing(DeathnoteModVariables.WorldVariables.get(world).ZombieX - Mth.nextInt(RandomSource.create(), 0, 2),
							DeathnoteModVariables.WorldVariables.get(world).ZombieY, DeathnoteModVariables.WorldVariables.get(world).ZombieZ + Mth.nextInt(RandomSource.create(), 0, 2)), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setDeltaMovement(0, 0, 0);
					}
				}
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = EntityType.SKELETON.spawn(_level, BlockPos.containing(DeathnoteModVariables.WorldVariables.get(world).ZombieX + Mth.nextInt(RandomSource.create(), 0, 1),
							DeathnoteModVariables.WorldVariables.get(world).ZombieY, DeathnoteModVariables.WorldVariables.get(world).ZombieZ - Mth.nextInt(RandomSource.create(), 0, 1)), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setDeltaMovement(0, 0, 0);
					}
				}
			}
		}
	}
}
