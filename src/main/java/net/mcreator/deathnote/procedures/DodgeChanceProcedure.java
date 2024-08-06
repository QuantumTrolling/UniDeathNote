package net.mcreator.deathnote.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.deathnote.network.DeathnoteModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class DodgeChanceProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity());
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DeathnoteModVariables.PlayerVariables())).Intangibility) {
			if (entity instanceof Player) {
				if (Math.random() < 0.5 + 0.1 * (entity.getCapability(DeathnoteModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DeathnoteModVariables.PlayerVariables())).IntangibilityLevel) {
					if (event != null && event.isCancelable()) {
						event.setCanceled(true);
					}
				}
			}
		}
	}
}
