package net.mcreator.deathnote.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.deathnote.network.DeathnoteModVariables;
import net.mcreator.deathnote.init.DeathnoteModEntities;

public class GhostSummonProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DeathnoteModVariables.PlayerVariables())).SoulSplitCD) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("deathnote:soulsplit")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("deathnote:soulsplit")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			for (int index0 = 0; index0 < (int) (1 + (entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DeathnoteModVariables.PlayerVariables())).SoulSplitLevel); index0++) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = DeathnoteModEntities.UNI_GHOST.get().spawn(_level, BlockPos.containing(x + Mth.nextInt(RandomSource.create(), 0, 1), y, z + Mth.nextInt(RandomSource.create(), 0, 1)), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setDeltaMovement(0, 0, 0);
					}
				}
			}
			SoulSplitCDProcedure.execute(world, entity);
		}
	}
}
