
package net.mcreator.deathnote.command;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.common.util.FakePlayerFactory;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.Commands;

import net.mcreator.deathnote.procedures.SetTeleportPointProcedure;

@Mod.EventBusSubscriber
public class TeleportPointCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("teleportpoint")

				.then(Commands.argument("name", EntityArgument.player()).executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					SetTeleportPointProcedure.execute(world, entity);
					return 0;
				})));
	}
}
