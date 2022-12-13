package net.ironhorsedevgroup.mods.thewesternedge.item.drinks;

import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib3.core.util.Color;

public class BottleColor implements ItemColor {
    @Override
    public int getColor(ItemStack itemStack, int tintIndex) {
        {
            switch (tintIndex) {
                case 0: return Color.WHITE.getColor();
                case 1: {
                    return Color.RED.getColor();
                }
                default: {
                    // oops! should never get here.
                    return Color.BLACK.getColor();
                }
            }
        }
    }
}
