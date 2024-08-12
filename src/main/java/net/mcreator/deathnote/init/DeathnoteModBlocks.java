
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.deathnote.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.deathnote.block.AltarBlock;
import net.mcreator.deathnote.DeathnoteMod;

public class DeathnoteModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, DeathnoteMod.MODID);
	public static final RegistryObject<Block> ALTAR = REGISTRY.register("altar", () -> new AltarBlock());
}
