package net.ironhorsedevgroup.mods.thewesternedge.events;

import net.ironhorsedevgroup.mods.thewesternedge.init.TWEEntities;
import net.ironhorsedevgroup.mods.thewesternedge.init.TWEItems;
import net.ironhorsedevgroup.mods.thewesternedge.item.drinks.BottleUtils;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static net.minecraftforge.versions.forge.ForgeVersion.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientEvents {
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

    @SubscribeEvent
    public static void layerRegister(EntityRenderersEvent.RegisterLayerDefinitions event) {

    }

    @SubscribeEvent
    public static void rendererRegister(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(TWEEntities.DYNAMITE.get(), ThrownItemRenderer::new);
    }

}