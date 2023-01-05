package net.ironhorsedevgroup.mods.thewesternedge.item.cards;

import net.ironhorsedevgroup.mods.thewesternedge.TWEUtils;
import net.ironhorsedevgroup.mods.thewesternedge.init.TWEConfig;
import net.minecraft.world.item.ItemStack;

public class CardUtils {
    public static Cards getCard(int id) {
        for (Cards card : Cards.values()) {
            if (card.getID() == id) {
                return card;
            }
        }
        return Cards.DEFAULT;
    }

    public static Cards getCard(ItemStack itemStack) {
        Integer id = TWEUtils.getIntTag(itemStack, "CustomModelData");
        return getCard(id);
    }

    public static Integer getColor(ItemStack itemStack, Integer tintIndex) {
        return getCard(itemStack).getColor(tintIndex);
    }

    public static Integer getColor(String suit) {
        if (suit == "crossbows") {
            return TWEUtils.getIntFromRGB(TWEConfig.cardCrossbowsColor);
        } else if (suit == "bows") {
            return TWEUtils.getIntFromRGB(TWEConfig.cardBowsColor);
        } else if (suit == "swords") {
            return TWEUtils.getIntFromRGB(TWEConfig.cardSwordsColor);
        } else if (suit == "axes") {
            return TWEUtils.getIntFromRGB(TWEConfig.cardAxesColor);
        } else {
            return TWEUtils.getIntFromRGB(255, 255, 255);
        }
    }
}