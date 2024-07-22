
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.deathnote.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.deathnote.world.inventory.SkilllsMenu;
import net.mcreator.deathnote.DeathnoteMod;

public class DeathnoteModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, DeathnoteMod.MODID);
	public static final RegistryObject<MenuType<SkilllsMenu>> SKILLLS = REGISTRY.register("skillls", () -> IForgeMenuType.create(SkilllsMenu::new));
}
