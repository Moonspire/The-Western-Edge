package net.ironhorsedevgroup.mods.thewesternedge.mixin;

import net.ironhorsedevgroup.mods.thewesternedge.drinks.BottleUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.PotionItem;

@Mixin(PotionItem.class)
public class PotionApplyEffectModification {
	@Inject(at = @At("HEAD"), method = "finishUsingItem(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/level/Level;Lnet/minecraft/world/entity/LivingEntity;)Lnet/minecraft/world/item/ItemStack;", cancellable = true)
	public void finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity, CallbackInfoReturnable<ItemStack> callback) {
		if (BottleUtils.getBottle(itemStack) != 0 || BottleUtils.getAmount(itemStack) != 1) {
			callback.setReturnValue(BottleUtils.useBottleItem(itemStack, level, livingEntity));
		}
	}
}
