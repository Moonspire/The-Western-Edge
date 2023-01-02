package net.ironhorsedevgroup.mods.thewesternedge.init;

import net.ironhorsedevgroup.mods.thewesternedge.TWEUtils;
import net.ironhorsedevgroup.mods.thewesternedge.item.bottles.BottleUtils;
import net.ironhorsedevgroup.mods.thewesternedge.item.cards.CardUtils;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class TWEColorHandler {
    public static Integer getColor(ItemStack itemStack, Integer tintIndex) {
        Item item = itemStack.getItem();
        if (item == TWEItems.DRINK.get()) {
            return BottleUtils.getColor(itemStack, tintIndex);
        } else if (item == TWEItems.CARD.get()) {
            return CardUtils.getColor(itemStack, tintIndex);
        }
        return TWEUtils.getIntFromRGB(255, 255, 255);
    }
}
