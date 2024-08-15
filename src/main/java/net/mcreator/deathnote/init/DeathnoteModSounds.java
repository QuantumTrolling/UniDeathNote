
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
	public static final RegistryObject<SoundEvent> SOULSPLIT = REGISTRY.register("soulsplit", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("deathnote", "soulsplit")));
	public static final RegistryObject<SoundEvent> LEVITATION = REGISTRY.register("levitation", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("deathnote", "levitation")));
	public static final RegistryObject<SoundEvent> GHOST_LIVING_SOUND = REGISTRY.register("ghost_living_sound", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("deathnote", "ghost_living_sound")));
	public static final RegistryObject<SoundEvent> MANIFESTATION = REGISTRY.register("manifestation", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("deathnote", "manifestation")));
}
