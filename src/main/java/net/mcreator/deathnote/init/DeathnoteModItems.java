
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.deathnote.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.deathnote.item.SoulShardItem;
import net.mcreator.deathnote.item.PageofRevivalItem;
import net.mcreator.deathnote.item.BookOfDeathItem;
import net.mcreator.deathnote.DeathnoteMod;

public class DeathnoteModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, DeathnoteMod.MODID);
	public static final RegistryObject<Item> BOOK_OF_DEATH = REGISTRY.register("book_of_death", () -> new BookOfDeathItem());
	public static final RegistryObject<Item> UNDERTAKER_SPAWN_EGG = REGISTRY.register("undertaker_spawn_egg", () -> new ForgeSpawnEggItem(DeathnoteModEntities.UNDERTAKER, -1, -1, new Item.Properties()));
	public static final RegistryObject<Item> ALTAR = block(DeathnoteModBlocks.ALTAR);
	public static final RegistryObject<Item> SOUL_SHARD = REGISTRY.register("soul_shard", () -> new SoulShardItem());
	public static final RegistryObject<Item> CURSED_GHOST_SPAWN_EGG = REGISTRY.register("cursed_ghost_spawn_egg", () -> new ForgeSpawnEggItem(DeathnoteModEntities.CURSED_GHOST, -1, -1, new Item.Properties()));
	public static final RegistryObject<Item> PAGEOF_REVIVAL = REGISTRY.register("pageof_revival", () -> new PageofRevivalItem());

	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
