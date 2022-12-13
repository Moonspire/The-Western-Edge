package net.ironhorsedevgroup.mods.thewesternedge.mixin;

import net.ironhorsedevgroup.mods.thewesternedge.item.drinks.BottleUtils;
import net.ironhorsedevgroup.mods.thewesternedge.item.drinks.BottleVariants;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.PotionItem;

@Mixin(PotionItem.class)
public class PotionItemMixins {
	@Inject(at = @At("HEAD"), method = "finishUsingItem(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/level/Level;Lnet/minecraft/world/entity/LivingEntity;)Lnet/minecraft/world/item/ItemStack;", cancellable = true)
	public void finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity, CallbackInfoReturnable<ItemStack> callback) {
		if (BottleUtils.getBottle(itemStack) != BottleVariants.POTION_BOTTLE || BottleUtils.getAmount(itemStack) != 1) {
			callback.setReturnValue(BottleUtils.useBottleItem(itemStack, level, livingEntity));
		}
	}

	@Inject(at = @At("RETURN"), method = "getDescriptionId(Lnet/minecraft/world/item/ItemStack;)Ljava/lang/String;", cancellable = true)
	public void getDescriptionId(ItemStack itemStack, CallbackInfoReturnable<String> callback) {
		String name = BottleUtils.getName(itemStack);
		if (name != itemStack.getItem().getDescriptionId()) {
			callback.setReturnValue(name);
		} else {
			callback.setReturnValue(callback.getReturnValue());
		}
	}
}
