package net.ironhorsedevgroup.mods.thewesternedge.item;

import net.ironhorsedevgroup.mods.thewesternedge.TWEUtils;
import net.ironhorsedevgroup.mods.thewesternedge.drinks.BottleUtils;
import net.ironhorsedevgroup.mods.thewesternedge.init.TWEDrinks;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class DrinkBottleItem extends Item {
    private static final int DRINK_DURATION = 32;
    public DrinkBottleItem(Item.Properties p_42979_) {
        super(p_42979_);
    }

    @Override
    public ItemStack getDefaultInstance() {
        return BottleUtils.addDrink(super.getDefaultInstance(), TWEDrinks.BLACKWATER);
    }

    @Override
    public String getDescriptionId(ItemStack itemStack) {
        String name = TWEUtils.getStringTag(itemStack, "DrinkName");
        if (name == "") {
            return super.getDescriptionId(itemStack);
        }
        return name;
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        BottleUtils.addDrinkTooltip(itemStack, components);
    }

    @Override
    public void fillItemCategory(CreativeModeTab tab, NonNullList<ItemStack> itemStack) {
        if (this.allowdedIn(tab)) {
            for(TWEDrinks drink : TWEDrinks.values()) {
                if (drink != TWEDrinks.EMPTY) {
                    ItemStack newStack = new ItemStack(this);
                    BottleUtils.addDrink(newStack, drink);
                    BottleUtils.addPotion(newStack, Potions.STRONG_REGENERATION);
                    BottleUtils.setBottle(newStack, 9);
                    BottleUtils.setContentsView(newStack, true);
                    itemStack.add(newStack);
                }
            }

        }

    }
}
