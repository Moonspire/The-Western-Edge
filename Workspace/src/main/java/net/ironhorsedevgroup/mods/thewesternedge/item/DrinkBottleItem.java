package net.ironhorsedevgroup.mods.thewesternedge.item;

import net.ironhorsedevgroup.mods.thewesternedge.TWEUtils;
import net.ironhorsedevgroup.mods.thewesternedge.drinks.BottleUtils;
import net.ironhorsedevgroup.mods.thewesternedge.init.TWEDrinks;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

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
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity entity) {
        return BottleUtils.useBottleItem(itemStack, level, entity);
    }

    @Override
    public int getUseDuration(ItemStack itemStack) {
        return BottleUtils.getUseDuration(itemStack);
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
    public UseAnim getUseAnimation(ItemStack itemStack) {
        return UseAnim.DRINK;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        return ItemUtils.startUsingInstantly(level, player, hand);
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
