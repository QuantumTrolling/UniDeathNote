
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.deathnote.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.deathnote.DeathnoteMod;

public class DeathnoteModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DeathnoteMod.MODID);
	public static final RegistryObject<CreativeModeTab> DEATH = REGISTRY.register("death",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.deathnote.death")).icon(() -> new ItemStack(DeathnoteModItems.BOOK_OF_DEATH.get())).displayItems((parameters, tabData) -> {
				tabData.accept(DeathnoteModItems.BOOK_OF_DEATH.get());
				tabData.accept(DeathnoteModItems.UNDERTAKER_SPAWN_EGG.get());
				tabData.accept(DeathnoteModBlocks.ALTAR.get().asItem());
				tabData.accept(DeathnoteModItems.SOUL_SHARD.get());
				tabData.accept(DeathnoteModItems.CURSED_GHOST_SPAWN_EGG.get());
			})

					.build());
}
