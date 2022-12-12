package net.ironhorsedevgroup.mods.thewesternedge.mixin;

import net.ironhorsedevgroup.mods.thewesternedge.TWEUtils;
import net.ironhorsedevgroup.mods.thewesternedge.drinks.BottleUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.ItemStack;

@Mixin(PotionBrewing.class)
public class BrewingStandApplyNBT {
	@Inject(at = @At("RETURN"), method = "mix(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/ItemStack;)Lnet/minecraft/world/item/ItemStack;", cancellable = true)
	private static void mix(ItemStack ingredient, ItemStack potion, CallbackInfoReturnable<ItemStack> callback) {
		Integer bottle = BottleUtils.getBottle(potion);
		Double servings = BottleUtils.getAmount(potion);
    	if (bottle != 0) {
    		ItemStack retPot = callback.getReturnValue();
    		BottleUtils.setBottle(retPot, bottle);
			TWEUtils.putDoubleTag(retPot, "Servings", BottleUtils.getBottleSize(retPot));
	    	callback.setReturnValue(retPot);
	    } else {
	    	callback.setReturnValue(callback.getReturnValue());
	    }
	}
}