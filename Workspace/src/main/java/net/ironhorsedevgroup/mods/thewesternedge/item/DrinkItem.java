package net.ironhorsedevgroup.mods.thewesternedge.item;

import net.ironhorsedevgroup.mods.thewesternedge.TWEUtils;
import net.ironhorsedevgroup.mods.thewesternedge.alcoholsystem.DrinkUtils;
import net.ironhorsedevgroup.mods.thewesternedge.init.TWEAdditives;
import net.ironhorsedevgroup.mods.thewesternedge.init.TWEDrinks;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import software.bernie.geckolib3.core.util.Color;

import javax.annotation.Nullable;
import java.util.List;

public class DrinkItem extends Item {
    private static final int DRINK_DURATION = 32;
    public DrinkItem(Item.Properties p_42979_) {
        super(p_42979_);
    }

    @Override
    public ItemStack getDefaultInstance() {
        return DrinkUtils.addDrink(super.getDefaultInstance(), TWEDrinks.BLACKWATER, 1.0);
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
        DrinkUtils.addDrinkTooltip(itemStack, components, true);
    }

    @Override
    public void fillItemCategory(CreativeModeTab tab, NonNullList<ItemStack> itemStack) {
        if (this.allowdedIn(tab)) {
            for(TWEDrinks drink : TWEDrinks.values()) {
                if (drink != TWEDrinks.EMPTY) {
                    ItemStack newStack = new ItemStack(this);
                    DrinkUtils.addDrink(newStack, drink, 1.0);
                    DrinkUtils.setBottle(newStack, 9);
                    itemStack.add(newStack);
                }
            }
        }

    }
}
