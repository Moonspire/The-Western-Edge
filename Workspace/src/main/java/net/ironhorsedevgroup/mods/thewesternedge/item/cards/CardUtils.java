package net.ironhorsedevgroup.mods.thewesternedge.item.cards;

import net.ironhorsedevgroup.mods.thewesternedge.TWEUtils;
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
}