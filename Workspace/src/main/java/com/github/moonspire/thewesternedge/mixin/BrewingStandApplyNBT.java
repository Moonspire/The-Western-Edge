package com.github.moonspire.thewesternedge.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.ItemStack;

@Mixin(PotionBrewing.class)
public class BrewingStandApplyNBT {
	@Inject(at = @At("RETURN"), method = "mix(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/ItemStack;)Lnet/minecraft/world/item/ItemStack;", cancellable = true, remap = false)
	private static void mix(ItemStack ingredient, ItemStack potion, CallbackInfoReturnable<ItemStack> callback) {
    	if (potion.getOrCreateTag().getDouble("CustomModelData") != 0) {
    		ItemStack retPot = callback.getReturnValue();
    		retPot.getOrCreateTag().putDouble("CustomModelData", potion.getOrCreateTag().getDouble("CustomModelData"));
	    	callback.setReturnValue(retPot);
	    } else {
	    	callback.setReturnValue(callback.getReturnValue());
	    }
	}
}