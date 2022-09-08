package net.ironhorsedevgroup.mods.thewesternedge.item;

import com.mojang.blaze3d.shaders.Effect;
import net.ironhorsedevgroup.mods.thewesternedge.init.TWEMobEffects;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class AbstractBandageItem extends Item implements ItemRightClickTrigger {
    public AbstractBandageItem(Item.Properties properties) {
        super(properties);
    }

    public MobEffect getMobEffect() {
        return TWEMobEffects.BANDAGES_EFFECT.get();
    }

    public int getCooldown() {
        return 300;
    }

    public int getStrength() {
        return 0;
    }

    public int getUseDuration() {
        return 64;
    }

    public int getEffectDuration() {
        return 0;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
        if (itemstack.getItem() instanceof AbstractBandageItem bandageitem) {
            return bandageitem.applyGauzeStripEffect(entity, itemstack);
        }
        return itemstack;
    }

    @Override
    public int mobInteract(InteractionHand hand, Entity entity, Player player) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (itemstack.getItem() instanceof AbstractBandageItem bandageitem && entity instanceof LivingEntity livingentity) {
            bandageitem.applyGauzeStripEffect(livingentity, itemstack);
            return this.getCooldown();
        } else {
            return 0;
        }
    }

    @Override
    public int getUseDuration(ItemStack itemstack) {
        if (itemstack.getItem() instanceof AbstractBandageItem bandageitem) {
            return bandageitem.getUseDuration();
        }
        return 0;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack itemstack) {
        return UseAnim.DRINK;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
        return ItemUtils.startUsingInstantly(world, entity, hand);
    }

    public ItemStack applyGauzeStripEffect(LivingEntity entity, ItemStack itemstack, int cooldown, int strength, int duration, MobEffect effect) {
        if (entity instanceof Player player) {
            if (!player.getAbilities().instabuild) {
                itemstack.shrink(1);
            }
            Item item = itemstack.getItem();
            player.getCooldowns().addCooldown(item, (cooldown + item.getUseDuration(itemstack)));
        } else {
            itemstack.shrink(1);
        }
        entity.addEffect(new MobEffectInstance(effect, duration, strength));
        return itemstack;
    }

    public ItemStack applyGauzeStripEffect(LivingEntity entity, ItemStack itemstack) {
        if (itemstack.getItem() instanceof AbstractBandageItem bandageitem) {
            return applyGauzeStripEffect(entity, itemstack, bandageitem.getCooldown(), bandageitem.getStrength(), bandageitem.getEffectDuration(), bandageitem.getMobEffect());
        }
        return itemstack;
    }
}
