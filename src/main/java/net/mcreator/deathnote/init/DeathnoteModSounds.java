
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.deathnote.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.deathnote.DeathnoteMod;

public class DeathnoteModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, DeathnoteMod.MODID);
	public static final RegistryObject<SoundEvent> MAGNETOKINESIS = REGISTRY.register("magnetokinesis", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("deathnote", "magnetokinesis")));
}
