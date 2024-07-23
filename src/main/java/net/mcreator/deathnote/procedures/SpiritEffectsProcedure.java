package net.mcreator.deathnote.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Drowned;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.Entity;

import net.mcreator.deathnote.network.DeathnoteModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class SpiritEffectsProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof Player) {
			if (sourceentity instanceof Drowned) {
				{
					double _setval = 6;
					entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.NimberofEffect = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (sourceentity instanceof Spider) {
				{
					double _setval = 2;
					entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.NimberofEffect = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (sourceentity instanceof Blaze) {
				{
					double _setval = 3;
					entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.NimberofEffect = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (sourceentity instanceof Skeleton) {
				{
					double _setval = 4;
					entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.NimberofEffect = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (sourceentity instanceof EnderMan) {
				{
					double _setval = 5;
					entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.NimberofEffect = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (sourceentity instanceof Zombie) {
				{
					double _setval = 1;
					entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.NimberofEffect = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
