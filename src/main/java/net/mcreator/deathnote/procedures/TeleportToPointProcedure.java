package net.mcreator.deathnote.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.deathnote.DeathnoteMod;

public class TeleportToPointProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		DeathnoteMod.queueServerWork(480, () -> {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("execute in minecraft:the_end run tp @a " + 10 + " " + 70 + " " + 10));
		});
	}
}
