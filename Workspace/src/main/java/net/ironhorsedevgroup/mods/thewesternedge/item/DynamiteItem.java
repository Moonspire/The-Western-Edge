package net.ironhorsedevgroup.mods.thewesternedge.item;

import net.ironhorsedevgroup.mods.thewesternedge.TWEUtils;
import net.ironhorsedevgroup.mods.thewesternedge.entity.projectiles.DynamiteProjectile;
import net.ironhorsedevgroup.mods.thewesternedge.init.TWEItems;
import net.ironhorsedevgroup.mods.thewesternedge.init.TWETabs;
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
    public static final Predicate<ItemStack> DYNAMITE = (itemStack) -> {
        return itemStack.is(TWEItems.DYNAMITE.get());
    };
    
    public DynamiteItem() {
        super(new Item.Properties().tab(TWETabs.TAB_TWE_SURVIVAL).stacksTo(16).rarity(Rarity.COMMON));
    }

    @Override
    public void releaseUsing(ItemStack itemStack, Level level, LivingEntity livingEntity, int fuse) {
        if (fuse <= 2) {
            TWEUtils.explode(level, 1.5, livingEntity.position(), livingEntity);
        } else {
            if (!level.isClientSide) {
                DynamiteProjectile dynamite = new DynamiteProjectile(level, livingEntity);
                dynamite.setFuse(fuse);
                dynamite.setItem(itemStack);
                dynamite.shootFromRotation(livingEntity, livingEntity.getXRot(), livingEntity.getYRot(), 0.0F, 1.5F, 1.0F);
                level.addFreshEntity(dynamite);
            }
        }
        itemStack.shrink(1);
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
        ItemStack itemstack = player.getItemInHand(hand);
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
