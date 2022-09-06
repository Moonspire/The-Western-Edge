
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.ironhorsedevgroup.mods.thewesternedge.init;

import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.AbstractContainerMenu;

import java.util.List;
import java.util.ArrayList;

import net.ironhorsedevgroup.mods.thewesternedge.world.inventory.GauzeRollGuiMenu;
import net.ironhorsedevgroup.mods.thewesternedge.world.inventory.BrewersBarrelGuiMenu;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ThewesternedgeModMenus {
	private static final List<MenuType<?>> REGISTRY = new ArrayList<>();
	public static final MenuType<GauzeRollGuiMenu> GAUZE_ROLL_GUI = register("gauze_roll_gui",
			(id, inv, extraData) -> new GauzeRollGuiMenu(id, inv, extraData));
	public static final MenuType<BrewersBarrelGuiMenu> BREWERS_BARREL_GUI = register("brewers_barrel_gui",
			(id, inv, extraData) -> new BrewersBarrelGuiMenu(id, inv, extraData));

	private static <T extends AbstractContainerMenu> MenuType<T> register(String registryname, IContainerFactory<T> containerFactory) {
		MenuType<T> menuType = new MenuType<T>(containerFactory);
		menuType.setRegistryName(registryname);
		REGISTRY.add(menuType);
		return menuType;
	}

	@SubscribeEvent
	public static void registerContainers(RegistryEvent.Register<MenuType<?>> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new MenuType[0]));
	}
}
