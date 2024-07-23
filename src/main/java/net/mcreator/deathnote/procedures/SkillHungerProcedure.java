package net.mcreator.deathnote.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.deathnote.network.DeathnoteModVariables;
import net.mcreator.deathnote.DeathnoteMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class SkillHungerProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DeathnoteModVariables.PlayerVariables())).GhostlyHunger) {
			if ((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) < 20
					&& (entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) != (entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DeathnoteModVariables.PlayerVariables())).foodLevel) {
				{
					double _setval = entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0;
					entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.foodLevel = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				DeathnoteMod.queueServerWork(240, () -> {
					if (entity instanceof Player _player)
						_player.getFoodData().setFoodLevel((int) ((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0)
								+ (entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DeathnoteModVariables.PlayerVariables())).GhotlyHungerLevel));
				});
			}
		}
	}
}
