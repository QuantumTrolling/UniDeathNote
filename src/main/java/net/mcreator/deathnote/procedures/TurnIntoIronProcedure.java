package net.mcreator.deathnote.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.deathnote.network.DeathnoteModVariables;

import java.util.Map;

public class TurnIntoIronProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double dx = 0;
		double dz = 0;
		double dy = 0;
		if ((entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DeathnoteModVariables.PlayerVariables())).Magnetokinesis
				&& !(entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DeathnoteModVariables.PlayerVariables())).MagnetokinesisCD) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("deathnote:magnetokinesis")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("deathnote:magnetokinesis")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			dx = x - 1;
			dz = z - 1;
			dy = y - 1;
			for (int index0 = 0; index0 < 6; index0++) {
				for (int index1 = 0; index1 < 6; index1++) {
					for (int index2 = 0; index2 < 6; index2++) {
						if ((world.getBlockState(BlockPos.containing(dx, dy, dz))).getBlock() == Blocks.STONE) {
							if (Math.random() < 0.2) {
								{
									BlockPos _bp = BlockPos.containing(dx, dy, dz);
									BlockState _bs = Blocks.IRON_ORE.defaultBlockState();
									BlockState _bso = world.getBlockState(_bp);
									for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
										Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
										if (_property != null && _bs.getValue(_property) != null)
											try {
												_bs = _bs.setValue(_property, (Comparable) entry.getValue());
											} catch (Exception e) {
											}
									}
									world.setBlock(_bp, _bs, 3);
								}
							}
						}
						dz = dz + 1;
					}
					dz = z - 1;
					dx = dx + 1;
				}
				dx = x - 1;
				dz = z - 1;
				dy = dy + 1;
			}
			{
				boolean _setval = true;
				entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MagnetokinesisCD = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			MagnetCDProcedure.execute(world, entity);
		}
	}
}
