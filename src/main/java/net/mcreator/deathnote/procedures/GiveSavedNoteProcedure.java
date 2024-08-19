package net.mcreator.deathnote.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.deathnote.network.DeathnoteModVariables;

public class GiveSavedNoteProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!(DeathnoteModVariables.WorldVariables.get(world).note.getItem() == ItemStack.EMPTY.getItem())) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = DeathnoteModVariables.WorldVariables.get(world).note;
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		}
	}
}
