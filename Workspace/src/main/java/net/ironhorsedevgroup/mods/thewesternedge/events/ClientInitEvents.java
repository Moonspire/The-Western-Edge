package net.ironhorsedevgroup.mods.thewesternedge.events;

import net.ironhorsedevgroup.mods.thewesternedge.init.TWEItems;
import net.ironhorsedevgroup.mods.thewesternedge.item.drinks.BottleColor;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ClientInitEvents {
    @SubscribeEvent
    public static void registerItemColors(ColorHandlerEvent.Item event)
    {
        // the LiquidColour lambda function is used to change the rendering colour of the liquid in the bottle
        // i.e.: when vanilla wants to know what colour to render our itemVariants instance, it calls the LiquidColour lambda function
        System.out.println("TWEItemColorRegistered");
        event.getItemColors().register(new BottleColor(), TWEItems.DRINK.get());
    }
}
