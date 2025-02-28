
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.deathnote.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.deathnote.world.inventory.VengefulSpiritGUIMenu;
import net.mcreator.deathnote.world.inventory.TeleportGUIMenu;
import net.mcreator.deathnote.world.inventory.SoulSplitMenu;
import net.mcreator.deathnote.world.inventory.SkilllsMenu;
import net.mcreator.deathnote.world.inventory.RevivalGUIMenu;
import net.mcreator.deathnote.world.inventory.ObsessionGUIMenu;
import net.mcreator.deathnote.world.inventory.ManifestationGUIMenu;
import net.mcreator.deathnote.world.inventory.MagnetokinesisGUIMenu;
import net.mcreator.deathnote.world.inventory.LevitationGUIMenu;
import net.mcreator.deathnote.world.inventory.IntangibilityGUIMenu;
import net.mcreator.deathnote.world.inventory.IncorporealityGUIMenu;
import net.mcreator.deathnote.world.inventory.GhostlyHungerGUIMenu;
import net.mcreator.deathnote.DeathnoteMod;

public class DeathnoteModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, DeathnoteMod.MODID);
	public static final RegistryObject<MenuType<SkilllsMenu>> SKILLLS = REGISTRY.register("skillls", () -> IForgeMenuType.create(SkilllsMenu::new));
	public static final RegistryObject<MenuType<GhostlyHungerGUIMenu>> GHOSTLY_HUNGER_GUI = REGISTRY.register("ghostly_hunger_gui", () -> IForgeMenuType.create(GhostlyHungerGUIMenu::new));
	public static final RegistryObject<MenuType<VengefulSpiritGUIMenu>> VENGEFUL_SPIRIT_GUI = REGISTRY.register("vengeful_spirit_gui", () -> IForgeMenuType.create(VengefulSpiritGUIMenu::new));
	public static final RegistryObject<MenuType<MagnetokinesisGUIMenu>> MAGNETOKINESIS_GUI = REGISTRY.register("magnetokinesis_gui", () -> IForgeMenuType.create(MagnetokinesisGUIMenu::new));
	public static final RegistryObject<MenuType<IncorporealityGUIMenu>> INCORPOREALITY_GUI = REGISTRY.register("incorporeality_gui", () -> IForgeMenuType.create(IncorporealityGUIMenu::new));
	public static final RegistryObject<MenuType<SoulSplitMenu>> SOUL_SPLIT = REGISTRY.register("soul_split", () -> IForgeMenuType.create(SoulSplitMenu::new));
	public static final RegistryObject<MenuType<ObsessionGUIMenu>> OBSESSION_GUI = REGISTRY.register("obsession_gui", () -> IForgeMenuType.create(ObsessionGUIMenu::new));
	public static final RegistryObject<MenuType<LevitationGUIMenu>> LEVITATION_GUI = REGISTRY.register("levitation_gui", () -> IForgeMenuType.create(LevitationGUIMenu::new));
	public static final RegistryObject<MenuType<TeleportGUIMenu>> TELEPORT_GUI = REGISTRY.register("teleport_gui", () -> IForgeMenuType.create(TeleportGUIMenu::new));
	public static final RegistryObject<MenuType<IntangibilityGUIMenu>> INTANGIBILITY_GUI = REGISTRY.register("intangibility_gui", () -> IForgeMenuType.create(IntangibilityGUIMenu::new));
	public static final RegistryObject<MenuType<ManifestationGUIMenu>> MANIFESTATION_GUI = REGISTRY.register("manifestation_gui", () -> IForgeMenuType.create(ManifestationGUIMenu::new));
	public static final RegistryObject<MenuType<RevivalGUIMenu>> REVIVAL_GUI = REGISTRY.register("revival_gui", () -> IForgeMenuType.create(RevivalGUIMenu::new));
}
