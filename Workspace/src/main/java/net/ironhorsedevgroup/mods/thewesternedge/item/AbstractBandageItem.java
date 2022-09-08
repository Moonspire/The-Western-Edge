package net.ironhorsedevgroup.mods.thewesternedge.item;

import com.mojang.blaze3d.shaders.Effect;
import net.ironhorsedevgroup.mods.thewesternedge.init.TWEMobEffects;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

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

    public int mobInteract(InteractionHand hand, Entity entity, Player player) {
        if (entity instanceof LivingEntity livingentity) {
            applyGauzeStripEffect(livingentity, player.getItemInHand(hand), this.getCooldown(), this.getStrength(), this.getEffectDuration(), this.getMobEffect());
            return this.getCooldown();
        }
        return 0;
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
}
