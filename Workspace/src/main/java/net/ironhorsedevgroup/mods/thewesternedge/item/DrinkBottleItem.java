package net.ironhorsedevgroup.mods.thewesternedge.item;

import net.ironhorsedevgroup.mods.thewesternedge.item.bottles.BottleUtils;
import net.ironhorsedevgroup.mods.thewesternedge.item.bottles.BottleDrinks;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class DrinkBottleItem extends Item {
    private static final int DRINK_DURATION = 32;
    public DrinkBottleItem(Item.Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack getDefaultInstance() {
        return BottleUtils.addDrink(super.getDefaultInstance(), BottleDrinks.BLACKWATER, 1.0, 0.0);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity entity) {
        return BottleUtils.useBottleItem(itemStack, level, entity);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemStack = BottleUtils.use(level, player, hand);
        if (itemStack != null) {
            return InteractionResultHolder.pass(itemStack);
        }
        return ItemUtils.startUsingInstantly(level, player, hand);
    }

    @Override
    public int getUseDuration(ItemStack itemStack) {
        return BottleUtils.getUseDuration(itemStack);
    }

    @Override
    public String getDescriptionId(ItemStack itemStack) {
        return BottleUtils.getName(itemStack);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack itemStack) {
        return UseAnim.DRINK;
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        BottleUtils.addDrinkTooltip(itemStack, components);
    }

    @Override
    public boolean hurtEnemy(ItemStack itemStack, LivingEntity entity, LivingEntity sourceEntity) {
        return super.hurtEnemy(itemStack, entity, sourceEntity);
    }

    @Override
    public void fillItemCategory(CreativeModeTab tab, NonNullList<ItemStack> itemStack) {
        if (this.allowdedIn(tab)) {
            for(BottleDrinks drink : BottleDrinks.values()) {
                if (drink != BottleDrinks.EMPTY) {
                    ItemStack newStack = new ItemStack(this);
                    BottleUtils.setBottle(newStack, drink.getDefaultBottle());
                    BottleUtils.addDrink(newStack, drink, BottleUtils.getBottleSize(newStack));
                    BottleUtils.setName(newStack, BottleUtils.getDrinkName(drink));
                    itemStack.add(newStack);
                }
            }
        }

    }
}
