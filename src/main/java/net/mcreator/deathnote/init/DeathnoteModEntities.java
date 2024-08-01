
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.deathnote.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.deathnote.entity.UniGhostEntity;
import net.mcreator.deathnote.entity.UndertakerEntity;
import net.mcreator.deathnote.DeathnoteMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DeathnoteModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, DeathnoteMod.MODID);
	public static final RegistryObject<EntityType<UniGhostEntity>> UNI_GHOST = register("uni_ghost",
			EntityType.Builder.<UniGhostEntity>of(UniGhostEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(UniGhostEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<UndertakerEntity>> UNDERTAKER = register("undertaker",
			EntityType.Builder.<UndertakerEntity>of(UndertakerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(UndertakerEntity::new)

					.sized(0.6f, 1.8f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			UniGhostEntity.init();
			UndertakerEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(UNI_GHOST.get(), UniGhostEntity.createAttributes().build());
		event.put(UNDERTAKER.get(), UndertakerEntity.createAttributes().build());
	}
}
