package net.ironhorsedevgroup.mods.thewesternedge.events;

import com.mojang.logging.LogUtils;
import net.ironhorsedevgroup.mods.thewesternedge.init.TWEItems;
import net.ironhorsedevgroup.mods.thewesternedge.item.drinks.BottleUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static net.minecraftforge.versions.forge.ForgeVersion.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ColorHandlers {
    @SubscribeEvent
    public static void registerItemColors(ColorHandlerEvent.Item event)
    {
        event.getItemColors().register(
                (
                        (pStack, pTintIndex) -> (BottleUtils.getColor(pStack, pTintIndex))
                )
                , TWEItems.DRINK.get()
        );
    }
}