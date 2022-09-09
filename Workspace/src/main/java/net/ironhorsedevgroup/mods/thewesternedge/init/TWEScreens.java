package net.ironhorsedevgroup.mods.thewesternedge.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.ironhorsedevgroup.mods.thewesternedge.client.gui.GauzeRollGuiScreen;
import net.ironhorsedevgroup.mods.thewesternedge.client.gui.BrewersBarrelGuiScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TWEScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(TWEMenus.GAUZE_ROLL_GUI, GauzeRollGuiScreen::new);
			MenuScreens.register(TWEMenus.BREWERS_BARREL_GUI, BrewersBarrelGuiScreen::new);
		});
	}
}
