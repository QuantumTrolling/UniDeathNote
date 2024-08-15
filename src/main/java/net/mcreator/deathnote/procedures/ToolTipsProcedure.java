package net.mcreator.deathnote.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.Screen;

import net.mcreator.deathnote.init.DeathnoteModItems;

import javax.annotation.Nullable;

import java.util.List;

@Mod.EventBusSubscriber
public class ToolTipsProcedure {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onItemTooltip(ItemTooltipEvent event) {
		execute(event, event.getItemStack(), event.getToolTip());
	}

	public static void execute(ItemStack itemstack, List<Component> tooltip) {
		execute(null, itemstack, tooltip);
	}

	private static void execute(@Nullable Event event, ItemStack itemstack, List<Component> tooltip) {
		if (tooltip == null)
			return;
		if (itemstack.getItem() == DeathnoteModItems.BOOK_OF_DEATH.get()) {
			itemstack.setHoverName(Component.literal("\u00A75\u041A\u043D\u0438\u0433\u0430 \u0441\u043C\u0435\u0440\u0442\u0438"));
			if (Screen.hasShiftDown()) {
				tooltip.add(Component
						.literal("\u00A76\u041A\u043D\u0438\u0433\u0430 \u0441\u043C\u0435\u0440\u0442\u0438 - \u0434\u043E\u0441\u0442\u0443\u043F\u043D\u0430 \u0442\u043E\u043B\u044C\u043A\u043E \u043C\u0451\u0440\u0442\u0432\u044B\u043C"));
			} else {
				tooltip.add(Component.literal("\u0417\u0430\u0436\u043C\u0438\u0442\u0435 \u0448\u0438\u0444\u0442 \u0447\u0442\u043E\u0431\u044B \u0443\u0432\u0438\u0434\u0435\u0442\u044C \u043E\u043F\u0438\u0441\u0430\u043D\u0438\u0435"));
			}
		}
	}
}
