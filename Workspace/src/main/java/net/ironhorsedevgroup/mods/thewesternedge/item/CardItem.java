package net.ironhorsedevgroup.mods.thewesternedge.item;

import net.ironhorsedevgroup.mods.thewesternedge.TWEUtils;
import net.ironhorsedevgroup.mods.thewesternedge.TheWesternEdgeMod;
import net.ironhorsedevgroup.mods.thewesternedge.item.cards.CardUtils;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

public class CardItem extends Item {
    public CardItem(Item.Properties properties) {
        super(properties);
    }

    @Override
    public void fillItemCategory(CreativeModeTab tab, NonNullList<ItemStack> itemStack) {
        if (this.allowdedIn(tab)) {
            for (int i = 0; i <= 52; i++) {
                ItemStack newStack = new ItemStack(this);
                TWEUtils.putIntTag(newStack, "CustomModelData", i);
                itemStack.add(newStack);
            }
        }
    }

    @Override
    public String getDescriptionId(ItemStack itemStack) {
        return CardUtils.getCard(itemStack).getName();
    }
}
