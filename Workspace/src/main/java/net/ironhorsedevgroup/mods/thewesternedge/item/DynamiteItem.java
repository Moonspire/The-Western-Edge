package net.ironhorsedevgroup.mods.thewesternedge.item;

import net.ironhorsedevgroup.mods.thewesternedge.TWEUtils;
import net.ironhorsedevgroup.mods.thewesternedge.entity.projectiles.DynamiteProjectile;
import net.ironhorsedevgroup.mods.thewesternedge.init.TWEItems;
import net.ironhorsedevgroup.mods.thewesternedge.init.TWETabs;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;

import java.util.function.Predicate;

public class DynamiteItem extends ProjectileWeaponItem {
    public static final Predicate<ItemStack> DYNAMITE = (itemStack) -> itemStack.is(TWEItems.DYNAMITE.get());
    
    public DynamiteItem() {
        super(new Item.Properties().tab(TWETabs.TAB_TWE_SURVIVAL).stacksTo(16).rarity(Rarity.COMMON));
    }

    @Override
    public void releaseUsing(ItemStack itemStack, Level level, LivingEntity livingEntity, int fuse) {
        System.out.println(fuse);
        if (fuse <= 2) {
            TWEUtils.explode(level, 1.5, livingEntity.position(), livingEntity);
        } else if (!level.isClientSide) {
            DynamiteProjectile dynamite = new DynamiteProjectile(level, livingEntity);
            dynamite.setFuse(fuse);
            dynamite.setItem(itemStack);
            dynamite.shootFromRotation(livingEntity, livingEntity.getXRot(), livingEntity.getYRot(), 0.0F, 1.0F, 1.0F);
            level.addFreshEntity(dynamite);
            if (livingEntity instanceof Player player) {
                player.getCooldowns().addCooldown(itemStack.getItem(), TWEUtils.secondsToTicks(2.5));
            }
        }
        itemStack.shrink(1);
        TWEUtils.putIntTag(itemStack, "CustomModelData", 0);
    }

    @Override
    public void onUsingTick(ItemStack itemStack, LivingEntity livingEntity, int fuse) {
        if (fuse % 10 == 0 && fuse > 10 && fuse < this.getUseDuration(itemStack) - 5) {
            livingEntity.getLevel().playSound((Player)null, livingEntity.blockPosition(), SoundEvents.FIRE_EXTINGUISH, SoundSource.NEUTRAL, 0.2F, 0.7F);
        }
        if (fuse == TWEUtils.secondsToTicks(10.0)) {
            TWEUtils.putIntTag(itemStack, "CustomModelData", 2);
        } else if (fuse == TWEUtils.secondsToTicks(5.5)) {
            TWEUtils.putIntTag(itemStack, "CustomModelData", 3);
        } else if(fuse == TWEUtils.secondsToTicks(1.0)) {
            TWEUtils.putIntTag(itemStack, "CustomModelData", 4);
        } else if(fuse == 1) {
            if (livingEntity instanceof Player player) {
                player.getCooldowns().addCooldown(itemStack.getItem(), TWEUtils.secondsToTicks(5.0));
            }
            livingEntity.stopUsingItem();
            releaseUsing(itemStack, livingEntity.getLevel(), livingEntity, 1);
        }
        super.onUsingTick(itemStack, livingEntity, fuse);
    }

    @Override
    public int getUseDuration(ItemStack itemStack) {
        return TWEUtils.secondsToTicks(15.0);
    }

    @Override
    public int getDefaultProjectileRange() {
        return 5;
    }

    @Override
    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return DYNAMITE;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        level.playSound((Player)null, player.blockPosition(), SoundEvents.TNT_PRIMED, SoundSource.NEUTRAL, 2.3F, 1.0F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
        ItemStack itemstack = player.getItemInHand(hand);
        TWEUtils.putIntTag(itemstack, "CustomModelData", 1);
        boolean flag = !player.getProjectile(itemstack).isEmpty();

        InteractionResultHolder<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, level, player, hand, flag);
        if (ret != null) return ret;

        if (!player.getAbilities().instabuild && !flag) {
            return InteractionResultHolder.fail(itemstack);
        } else {
            player.startUsingItem(hand);
            return InteractionResultHolder.consume(itemstack);
        }
    }
}
