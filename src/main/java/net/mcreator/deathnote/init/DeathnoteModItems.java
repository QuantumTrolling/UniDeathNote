
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.deathnote.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.mcreator.deathnote.item.BookOfDeathItem;
import net.mcreator.deathnote.DeathnoteMod;

public class DeathnoteModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, DeathnoteMod.MODID);
	public static final RegistryObject<Item> BOOK_OF_DEATH = REGISTRY.register("book_of_death", () -> new BookOfDeathItem());
}
